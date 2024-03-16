package com.encle.emicalculator;

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
    //-------------------------------------------------------------------------------------------------------
    private void reset() {
        // Clear the text of all TextInputEditText fields
        depositAmountEditText.setText("");
        interestRateEditText.setText("");
        periodEditText.setText("");
        totalDepositEditText.setText("");
        totalInterestEditText.setText("");
        maturityAmountEditText.setText("");
    }

    private void calculate() {
        // Hide the soft keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(depositAmountEditText.getWindowToken(), 0);

        // Check if input fields are empty
        if (depositAmountEditText.getText().toString().isEmpty() ||
                interestRateEditText.getText().toString().isEmpty() ||
                periodEditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform fixed deposit calculation
        double depositAmount = Double.parseDouble(depositAmountEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
        double period = Double.parseDouble(periodEditText.getText().toString());

        // Convert period from months to years if selected
        if (!isPeriodInYears) {
            period /= 12;
        }

        // Calculate total interest and maturity amount for simple interest
        double interest = (depositAmount * interestRate * period) / 100;
        double maturityAmount = depositAmount + interest;

        // Display the results
        totalDepositEditText.setText(String.valueOf(depositAmount));
        totalInterestEditText.setText(String.valueOf(interest));
        maturityAmountEditText.setText(String.valueOf(maturityAmount));
    }



    public void txt_back(View view) {
        finish();
    }
}
