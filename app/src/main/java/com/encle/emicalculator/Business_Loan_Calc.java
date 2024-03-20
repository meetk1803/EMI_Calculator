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

public class Business_Loan_Calc extends AppCompatActivity {
    private TextInputEditText edt_principal_amt, edt_rate, edt_year, edt_monthly_business, edt_t_interest, edt_t_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_loan_calc);


        edt_principal_amt = findViewById(R.id.edt_principal_amt);
        edt_rate = findViewById(R.id.edt_rate);
        edt_year = findViewById(R.id.edt_year);
        edt_monthly_business = findViewById(R.id.edt_monthly_business);
        edt_t_interest = findViewById(R.id.edt_t_interest);
        edt_t_payment = findViewById(R.id.edt_t_payment);

        ExtendedFloatingActionButton btn_business_reset = findViewById(R.id.btn_business_reset);
        ExtendedFloatingActionButton btn_business_calculate = findViewById(R.id.btn_business_calculate);


        btn_business_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v);
            }
        });

        btn_business_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(v);
            }
        });
        
        
    }
    //------------------------------------------------------------------------------------------------------
    private  void reset(View view){

        // Clear the text of all TextInputEditText fields
        edt_principal_amt.setText("");
        edt_rate.setText("");
        edt_year.setText("");
        edt_monthly_business.setText("");
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

        // Perform business loan calculation
        double loanAmount = Double.parseDouble(edt_principal_amt.getText().toString());
        double interestRate = Double.parseDouble(edt_rate.getText().toString());
        double loanTerm = Double.parseDouble(edt_year.getText().toString());

        // Check if interest rate or loan term is zero
        if (loanAmount == 0 || interestRate == 0 || loanTerm == 0) {
            // Display appropriate message and return
            Toast.makeText(getApplicationContext(), "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }

        double monthlyInterestRate = interestRate / 1200; // Convert annual rate to monthly rate
        double totalMonths = loanTerm * 12; // Convert years to total months

        double monthlyPayment;
        if (monthlyInterestRate == 0) {
            // For zero interest rate, use simple interest formula
            monthlyPayment = loanAmount / totalMonths;
        } else {
            // For non-zero interest rate, use compound interest formula
            double numerator = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths);
            double denominator = Math.pow(1 + monthlyInterestRate, totalMonths) - 1;
            monthlyPayment = numerator / denominator;
        }

        // Calculate total payment
        double totalPayment = monthlyPayment * totalMonths;
        double totalInterest = totalPayment - loanAmount;

        // Display the results
        edt_monthly_business.setText("₹" + String.format("%.2f", monthlyPayment));
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