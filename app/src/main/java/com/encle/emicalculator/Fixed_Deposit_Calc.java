package com.encle.emicalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Objects;

public class Fixed_Deposit_Calc extends AppCompatActivity {
    private TextInputEditText depositAmountEditText;
    private TextInputEditText interestRateEditText;
    private TextInputEditText periodEditText;
    private TextInputEditText totalDepositEditText;
    private TextInputEditText totalInterestEditText;
    private TextInputEditText maturityAmountEditText;
    private MaterialAutoCompleteTextView periodSpinner;

    private boolean isPeriodInYears = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_deposit_calc);

        depositAmountEditText = findViewById(R.id.txt_d_amt);
        interestRateEditText = findViewById(R.id.txt_d_rate);
        periodEditText = findViewById(R.id.txt_d_period);
        totalDepositEditText = findViewById(R.id.txt_total_d);
        totalInterestEditText = findViewById(R.id.total_d_interest);
        maturityAmountEditText = findViewById(R.id.total_d_maturity_amt);
        periodSpinner = findViewById(R.id.txt_spinner_period);

        // Populate spinner options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.period_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        periodSpinner.setAdapter(adapter);

        periodSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Set period type based on selection
                isPeriodInYears = position == 0; // Assuming years are at position 0
            }
        });

        ExtendedFloatingActionButton btn_emi_reset = findViewById(R.id.btn_emi_reset);
        ExtendedFloatingActionButton btn_emi_calculate = findViewById(R.id.btn_emi_calculate);

        btn_emi_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        btn_emi_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    private void reset() {
        // Clear the text of all TextInputEditText fields
        depositAmountEditText.setText("");
        interestRateEditText.setText("");
        periodEditText.setText("");
        totalDepositEditText.setText("");
        totalInterestEditText.setText("");
        maturityAmountEditText.setText("");
    }

    @SuppressLint("DefaultLocale")
    private void calculate() {
        // Retrieve values entered by the user
        double principal = Double.parseDouble(depositAmountEditText.getText().toString());
        double rate = Double.parseDouble(interestRateEditText.getText().toString());
        double time = Double.parseDouble(periodEditText.getText().toString());

        // Check if time is provided in years or months
        boolean isYearly = periodSpinner.getText().toString().toLowerCase().contains("year");

        // If time is provided in years, convert it to months
        if (isYearly) {
            time *= 12; // Convert years to months
        }
        // Calculate total deposit, total interest, and maturity amount
        double annualRate = rate / 100; // Convert percentage to decimal

        // Calculate total interest using compound interest formula
        double totalInterest = principal * (Math.pow(1 + (annualRate / 12), time) - 1);
        double maturityAmount = principal + totalInterest;

        // Display the formatted results
        totalDepositEditText.setText(String.format("₹%.2f", principal));
        totalInterestEditText.setText(String.format("₹%.2f", totalInterest));
        maturityAmountEditText.setText(String.format("₹%.2f", maturityAmount));
    }

    public void txt_back(View view) {
        finish();
    }
}
