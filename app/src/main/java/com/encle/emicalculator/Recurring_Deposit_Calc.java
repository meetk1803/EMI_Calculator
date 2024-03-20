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

public class Recurring_Deposit_Calc extends AppCompatActivity {
    private TextInputEditText depositAmountEditText;
    private TextInputEditText interestRateEditText;
    private TextInputEditText periodEditText;
    private TextInputEditText totalDepositEditText;
    private TextInputEditText totalInterestEditText;
    private TextInputEditText maturityAmountEditText;
    private MaterialAutoCompleteTextView periodSpinner;

    private boolean isPeriodInYears = true;
    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurring_deposit_calc);
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
        try {
            // Retrieve values entered by the user
            String depositAmountStr = depositAmountEditText.getText().toString().trim();
            String interestRateStr = interestRateEditText.getText().toString().trim();
            String periodStr = periodEditText.getText().toString().trim();

            // Check if any input field is empty
            if (depositAmountStr.isEmpty() || interestRateStr.isEmpty() || periodStr.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert input values to double
            double depositAmount = Double.parseDouble(depositAmountStr);
            double interestRate = Double.parseDouble(interestRateStr);
            double period = Double.parseDouble(periodStr);

            // Check if any of the input values is zero
            if (depositAmount == 0 || interestRate == 0 || period == 0) {
                Toast.makeText(getApplicationContext(), "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
                return;
            }

            // Check if the user selected years or months
            boolean isYearly = isPeriodInYears; // Assuming isPeriodInYears represents yearly selection

            // Convert period to months if yearly selected
            if (isYearly) {
                period *= 12; // Convert years to months
            }

            // Convert interest rate from percentage to decimal
            double annualRate = interestRate / 100.0;
            double monthlyRate = annualRate / 12.0;

            // Calculate maturity amount for recurring deposit
            double maturityAmount = depositAmount * (((Math.pow(1 + monthlyRate, period) - 1) / monthlyRate) * (1 + monthlyRate));

            // Calculate total deposit
            double totalDeposit = depositAmount * period;

            // Calculate total interest
            double totalInterest = maturityAmount - totalDeposit;

            // Display the results
            totalDepositEditText.setText(String.format("₹%.2f", totalDeposit));
            totalInterestEditText.setText(String.format("₹%.2f", totalInterest));
            maturityAmountEditText.setText(String.format("₹%.2f", maturityAmount));
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., if input is not a valid number)
            Toast.makeText(getApplicationContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Handle other exceptions
            Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    public void txt_back(View view) {

        finish();
    }
}
