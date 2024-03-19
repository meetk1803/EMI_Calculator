package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
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
        // Retrieve values entered by the user
        double CTC = Double.parseDouble(CTCannual.getText().toString());
        double bonusPercentage = Double.parseDouble(bonus.getText().toString());

        // Calculate bonus amount based on bonus percentage
        double bonusAmount = (bonusPercentage / 100.0) * CTC;

        // Calculate base salary (CTC minus bonus amount)
        double baseSalary = CTC - bonusAmount;

        // Initialize variables for monthly and yearly salaries
        double monthlySalary;
        double yearlySalary;

        // Calculate monthly salary (base salary divided by 12)
        monthlySalary = baseSalary / 12;

        // Format monthly salary in INR
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
        String formattedMonthlySalary = "₹" + decimalFormat.format(monthlySalary);

        // Check if the user has selected the yearly calculation
        if (isPeriodInYears) {
            // Calculate yearly salary
            yearlySalary = monthlySalary * 12;

            // Display the results
            M_salary.setText(formattedMonthlySalary);
            total_months.setText("12");
            per_year.setText(String.format("₹%.2f", yearlySalary));
        } else {
            // Calculate total months (assuming each year has 12 months)
            double totalMonths = 12;

            // Calculate total salary per year (monthly salary multiplied by total months)
            double totalSalaryPerYear = monthlySalary * totalMonths;

            // Display the results
            M_salary.setText(formattedMonthlySalary);
            total_months.setText(String.valueOf((int) totalMonths));
            per_year.setText(String.format("₹%.2f", totalSalaryPerYear));
        }
    }


    public void txt_back(View view) {
        finish();
    }
}