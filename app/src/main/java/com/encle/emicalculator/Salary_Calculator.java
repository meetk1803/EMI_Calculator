package com.encle.emicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class Salary_Calculator extends AppCompatActivity {
    private TextInputEditText CTCannual;
    private TextInputEditText bonus;
    private TextInputEditText M_salary;
    private TextInputEditText total_months;
    private TextInputEditText per_year;
    private boolean isPeriodInYears = true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_calculator);

        CTCannual = findViewById(R.id.CTCannual);
        bonus = findViewById(R.id.bonus);
        M_salary = findViewById(R.id.M_salary);
        total_months = findViewById(R.id.total_months);
        per_year = findViewById(R.id.per_year);

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
        CTCannual.setText("");
        bonus.setText("");
        M_salary.setText("");
        total_months.setText("");
        per_year.setText("");

    }
    private void calculate() {
        try {
            // Retrieve values entered by the user
            String CTCStr = CTCannual.getText().toString().trim();
            String bonusPercentageStr = bonus.getText().toString().trim();

            // Check if any input field is empty
            if (CTCStr.isEmpty() || bonusPercentageStr.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert input values to double
            double CTC = Double.parseDouble(CTCStr);
            double bonusPercentage = Double.parseDouble(bonusPercentageStr);

            // Check if any of the input values is zero
            if (CTC == 0 || bonusPercentage == 0) {
                Toast.makeText(getApplicationContext(), "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate bonus amount based on bonus percentage
            double bonusAmount = (bonusPercentage / 100.0) * CTC;

            // Calculate base salary (CTC minus bonus amount)
            double baseSalary = CTC - bonusAmount;

            // Calculate monthly salary (base salary divided by 12)
            double monthlySalary = baseSalary / 12;

            // Initialize variables for total months and total salary per year
            double totalMonths;
            double totalSalaryPerYear;

            // Check if the user has selected the yearly calculation
            if (isPeriodInYears) {
                // Calculate total months (assuming each year has 12 months)
                totalMonths = 12;

                // Calculate total salary per year (monthly salary multiplied by total months)
                totalSalaryPerYear = monthlySalary * totalMonths;
            } else {
                // If monthly calculation selected, total months is 12
                totalMonths = 12;

                // Total salary per year remains the same as monthly salary
                totalSalaryPerYear = monthlySalary;
            }

            // Format monthly salary in INR
            DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
            String formattedMonthlySalary = "₹" + decimalFormat.format(monthlySalary);

            // Display the results
            M_salary.setText(formattedMonthlySalary);
            total_months.setText(String.valueOf((int) totalMonths));
            per_year.setText(String.format("₹%.2f", totalSalaryPerYear));
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