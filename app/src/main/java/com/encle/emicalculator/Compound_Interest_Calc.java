package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class Compound_Interest_Calc extends AppCompatActivity {
    private TextInputEditText edt_investment_amount;
    private TextInputEditText edt_rate_of_interest;
    private TextInputEditText edt_period;
    private TextInputEditText txt_simple_investment;
    private TextInputEditText txt_principal_interest_value;
    private TextInputEditText txt_total_amount;
    private MaterialAutoCompleteTextView periodSpinner;

    private boolean isPeriodInYears = true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_interest_calc);

        edt_investment_amount = findViewById(R.id.edt_investment_amount);
        edt_rate_of_interest = findViewById(R.id.edt_rate_of_interest);
        edt_period = findViewById(R.id.edt_period);
        txt_simple_investment = findViewById(R.id.txt_simple_investment);
        txt_principal_interest_value = findViewById(R.id.txt_principal_interest_value);
        txt_total_amount = findViewById(R.id.txt_total_amount);
        periodSpinner = findViewById(R.id.periodSpinner);

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
        edt_investment_amount.setText("");
        edt_rate_of_interest.setText("");
        edt_period.setText("");
        txt_simple_investment.setText("");
        txt_principal_interest_value.setText("");
        txt_total_amount.setText("");
    }

    private void calculate() {
        // Retrieve values entered by the user
        double principal = Double.parseDouble(edt_investment_amount.getText().toString());
        double rate = Double.parseDouble(edt_rate_of_interest.getText().toString());
        double time = Double.parseDouble(edt_period.getText().toString());

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

        // Format the results to display with two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        // Display the formatted results
        txt_simple_investment.setText(String.format("₹%.2f", principal));
        txt_principal_interest_value.setText(String.format("₹%.2f", totalInterest));
        txt_total_amount.setText(String.format("₹%.2f", maturityAmount));
    }

    public void txt_back(View view) {
        finish();
    }

}