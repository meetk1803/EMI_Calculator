package com.encle.emicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class Simple_Interest_Calc extends AppCompatActivity {
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
        setContentView(R.layout.activity_simple_interest_calc);

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

    @SuppressLint("DefaultLocale")
    private void calculate() {
        // Get input values
        double principal, rateOfInterest, period;
        try {
            String principalStr = edt_investment_amount.getText().toString().trim();
            String rateOfInterestStr = edt_rate_of_interest.getText().toString().trim();
            String periodStr = edt_period.getText().toString().trim();

            // Check if any input field is empty
            if (principalStr.isEmpty() || rateOfInterestStr.isEmpty() || periodStr.isEmpty()) {
                Toast.makeText(this, "Please enter all inputs", Toast.LENGTH_SHORT).show();
                return;
            }

            // Parse input values to double
            principal = Double.parseDouble(principalStr);
            rateOfInterest = Double.parseDouble(rateOfInterestStr);
            period = Double.parseDouble(periodStr);

            // Check if any of the input values is zero
            if (principal == 0 || rateOfInterest == 0 || period == 0) {
                Toast.makeText(this, "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., if input is not a valid number)
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // Determine if the period is provided in years or months
        boolean isYearly = isPeriodInYears;

        // Calculate interest based on the period
        double interest;
        if (isYearly) {
            // Calculate yearly interest
            interest = (principal * rateOfInterest * period) / 100;
        } else {
            // Calculate monthly interest
            double monthlyRate = rateOfInterest / 12 / 100; // Convert annual rate to monthly rate
            interest = principal * monthlyRate * period;
        }

        // Calculate total amount
        double totalAmount = principal + interest;

        // Format the values for display
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedInterest = "₹" + decimalFormat.format(interest);
        String formattedTotalAmount = "₹" + decimalFormat.format(totalAmount);

        // Display the results
        txt_simple_investment.setText(formattedInterest);
        txt_principal_interest_value.setText(formattedInterest);
        txt_total_amount.setText(formattedTotalAmount);
    }


    public void txt_back(View view) {
        finish();
    }

}