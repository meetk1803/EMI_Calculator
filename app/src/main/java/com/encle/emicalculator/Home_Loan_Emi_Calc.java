package com.encle.emicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.emicalculator.R;

public class Home_Loan_Emi_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan_emi_calc);

        CardView card_emi_calc = findViewById(R.id.emi_calc);
        CardView card_business_calc = findViewById(R.id.business_calc);
        CardView card_fd_calc = findViewById(R.id.fd_calc);
        CardView card_rd_calc = findViewById(R.id.rd_calc);
        CardView card_salary_calc = findViewById(R.id.salary_calc);
        CardView card_gst_calc = findViewById(R.id.gst_calc);
        CardView card_ppf_calc =findViewById(R.id.ppf_calc);
        CardView card_simple_interest_calc =findViewById(R.id.simple_interest_calc);
        CardView card_compound_interest_calc =findViewById(R.id.compound_interest_calc);
        CardView card_insurance =findViewById(R.id.insurance);
        CardView card_bank_service =findViewById(R.id.bank_service);
        CardView card_near_by_places =findViewById(R.id.near_by_places);


        card_emi_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,EMI_Calc.class));
            }
        });

        card_business_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Business_Loan_Calc.class));
            }
        });

        card_fd_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Fixed_Deposit_Calc.class));
            }
        });

        card_rd_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Recurring_Deposit_Calc.class));
            }
        });
        card_salary_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Salary_Calculator.class));
            }
        });
        card_gst_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,GST_Calculator.class));
            }
        });

        card_ppf_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,PPF_Calc.class));
            }
        });

        card_simple_interest_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Simple_Interest_Calc.class));
            }
        });
        card_compound_interest_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Compound_Interest_Calc.class));
            }
        });
        card_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this,Insuarance_Main.class));
            }
        });
        card_bank_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this, Home_Loan_Emi_Calc.class));
            }
        });
        card_near_by_places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Loan_Emi_Calc.this, Home_Loan_Emi_Calc.class));
            }
        });
    }
}