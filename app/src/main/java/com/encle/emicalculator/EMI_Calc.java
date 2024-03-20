package com.encle.emicalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class EMI_Calc extends AppCompatActivity {
    private TextInputEditText edt_principal_amt, edt_rate, edt_year, edt_monthly_emi, edt_t_interest, edt_t_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calc);

        edt_principal_amt = findViewById(R.id.edt_principal_amt);
        edt_rate = findViewById(R.id.edt_rate);
        edt_year = findViewById(R.id.edt_year);
        edt_monthly_emi = findViewById(R.id.edt_monthly_emi);
        edt_t_interest = findViewById(R.id.edt_t_interest);
        edt_t_payment = findViewById(R.id.edt_t_payment);

        ExtendedFloatingActionButton btn_emi_reset = findViewById(R.id.btn_emi_reset);
        ExtendedFloatingActionButton btn_emi_calculate = findViewById(R.id.btn_emi_calculate);

        btn_emi_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v);
            }
        });

        btn_emi_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(v);
            }
        });
    }

    //------------------------------------------------------------------------------------------------------
    private void reset(View view) {

        // Clear the text of all TextInputEditText fields
        edt_principal_amt.setText("");
        edt_rate.setText("");
        edt_year.setText("");
        edt_monthly_emi.setText("");
        edt_t_interest.setText("");
        edt_t_payment.setText("");
    }

    private void calculate(View view) {
        // Hide the soft keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        // Check if input fields are empty
        if (edt_principal_amt.getText().toString().isEmpty() ||
                edt_rate.getText().toString().isEmpty() ||
                edt_year.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform EMI calculation
        double principalAmt = Double.parseDouble(edt_principal_amt.getText().toString());
        double rate = Double.parseDouble(edt_rate.getText().toString());
        double year = Double.parseDouble(edt_year.getText().toString());

        // Check if rate or year is zero
        if (principalAmt==0||rate == 0 || year == 0) {
            // Display appropriate message and return
            Toast.makeText(getApplicationContext(), "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }

        double monthlyRate = rate / 1200; // Convert annual rate to monthly rate
        double totalMonths = year * 12; // Convert years to total months

        double numerator = principalAmt * monthlyRate * Math.pow(1 + monthlyRate, totalMonths);
        double denominator = Math.pow(1 + monthlyRate, totalMonths) - 1;

        // Check if denominator is zero
        if (denominator == 0) {
            // Display appropriate message and return
            Toast.makeText(getApplicationContext(), "Invalid input. Please ensure interest rate and loan duration are not zero", Toast.LENGTH_SHORT).show();
            return;
        }

        double monthlyEMI = numerator / denominator;
        double totalPayment = monthlyEMI * totalMonths;
        double totalInterest = totalPayment - principalAmt;

        // Display the results
        edt_monthly_emi.setText("₹" + String.format("%.2f", monthlyEMI));
        edt_t_interest.setText("₹" + String.format("%.2f", totalInterest));
        edt_t_payment.setText("₹" + String.format("%.2f", totalPayment));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void txt_back(View view) {
        finish();
    }
}
