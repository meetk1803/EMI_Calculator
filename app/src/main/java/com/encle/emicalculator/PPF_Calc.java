package com.encle.emicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.Locale;
import java.util.Objects;

public class PPF_Calc extends AppCompatActivity {
    private TextInputEditText edt_investment_amount;
    private TextInputEditText edt_rate_of_interest;
    private TextInputEditText edt_monthly_emi;
    private TextInputEditText txt_total_investment;
    private TextInputEditText txt_total_interest_value;
    private TextInputEditText txt_maturity_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppf_calc);

        edt_investment_amount = findViewById(R.id.edt_investment_amount);
        edt_rate_of_interest = findViewById(R.id.edt_rate_of_interest);
        edt_monthly_emi = findViewById(R.id.edt_monthly_emi);
        txt_total_investment = findViewById(R.id.txt_total_investment);
        txt_total_interest_value = findViewById(R.id.txt_total_interest_value);
        txt_maturity_amount = findViewById(R.id.txt_maturity_amount);
        // Set OnClickListener for the Calculate button
        findViewById(R.id.btn_emi_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGST();
            }
        });

        // Set OnClickListener for the Reset button
        findViewById(R.id.btn_emi_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }
    private void calculateGST() {
        try {
            // Get input values
            String investmentAmountStr = edt_investment_amount.getText().toString().trim();
            String rateOfInterestStr = edt_rate_of_interest.getText().toString().trim();
            String monthlyEmiStr = edt_monthly_emi.getText().toString().trim();

            // Check if input fields are empty
            if (investmentAmountStr.isEmpty() || rateOfInterestStr.isEmpty() || monthlyEmiStr.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert input values to double
            double investmentAmount = Double.parseDouble(investmentAmountStr);
            double rateOfInterest = Double.parseDouble(rateOfInterestStr);
            double monthlyEmi = Double.parseDouble(monthlyEmiStr);

            // Check if any of the input values is zero
            if (investmentAmount == 0 || rateOfInterest == 0 || monthlyEmi == 0) {
                Toast.makeText(getApplicationContext(), "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate total investment
            double totalInvestment = investmentAmount + (monthlyEmi * 12); // Assuming monthly EMI for 1 year

            // Calculate total interest value
            double totalInterestValue = (totalInvestment * rateOfInterest) / 100;

            // Calculate maturity amount
            double maturityAmount = totalInvestment + totalInterestValue;

            // Display the calculated values
            txt_total_investment.setText("₹" + String.format(Locale.getDefault(), "%.2f", totalInvestment));
            txt_total_interest_value.setText("₹" + String.format(Locale.getDefault(), "%.2f", totalInterestValue));
            txt_maturity_amount.setText("₹" + String.format(Locale.getDefault(), "%.2f", maturityAmount));
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., if input is not a valid number)
            Toast.makeText(getApplicationContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Handle other exceptions
            Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }





    // Method to reset all input fields
    private void resetFields() {
        edt_investment_amount.setText("");
        edt_rate_of_interest.setText("");
        edt_monthly_emi.setText("");
        txt_total_investment.setText("");
        txt_total_interest_value.setText("");
        txt_maturity_amount.setText("");
    }

    public void txt_back(View view) {
        finish();
    }

}


