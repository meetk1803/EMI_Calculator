package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.emicalculator.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class GST_Calculator extends AppCompatActivity {

    private TextInputEditText initialAmountEditText;
    private TextInputEditText gstRateEditText;
    private TextInputEditText gstAmountEditText;
    private TextInputEditText netAmountEditText;
    private TextInputEditText totalAmountEditText;
    private TextInputEditText cgstEditText;
    private TextInputEditText sgstEditText;
    private RadioButton addGSTRadioButton;
    private RadioButton subtractGSTRadioButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_calculator);

        // Initialize views
        initialAmountEditText = findViewById(R.id.initial_amount_edit_text);
        gstRateEditText = findViewById(R.id.gst_rate_edit_text);
        gstAmountEditText = findViewById(R.id.gst_amount_edit_text);
        netAmountEditText = findViewById(R.id.net_amount_edit_text);
        addGSTRadioButton = findViewById(R.id.add_gst_radio_button);
        subtractGSTRadioButton = findViewById(R.id.subtract_gst_radio_button);
        totalAmountEditText = findViewById(R.id.total_gst_involves);
        cgstEditText = findViewById(R.id.cgst_amount);
        sgstEditText = findViewById(R.id.Sgst_amount);

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
        // Retrieve values entered by the user
        double initialAmount = Double.parseDouble(Objects.requireNonNull(initialAmountEditText.getText()).toString());
        double gstRate = Double.parseDouble(Objects.requireNonNull(gstRateEditText.getText()).toString());
        boolean isAddGST = addGSTRadioButton.isChecked(); // Check if user selected "Add GST +"

        // Calculate GST amount based on the GST rate
        double gstAmount = (gstRate / 100) * initialAmount;

        // Calculate CGST and SGST (assuming equal division)
        double cgst = gstAmount / 2;
        double sgst = gstAmount / 2;

        // Calculate the net amount after adding or subtracting GST
        double netAmount;
        if (isAddGST) {
            netAmount = initialAmount + gstAmount;
        } else {
            netAmount = initialAmount - gstAmount;
        }

        // Calculate the total amount including GST
        double totalAmount = netAmount;

        // Display the calculated values in the respective TextInputEditText fields
        gstAmountEditText.setText(String.format("₹%.2f", gstAmount));
        netAmountEditText.setText(String.format("₹%.2f", netAmount));
        totalAmountEditText.setText(String.format("₹%.2f", totalAmount));
        cgstEditText.setText(String.format("₹%.2f", cgst));
        sgstEditText.setText(String.format("₹%.2f", sgst));
    }

    // Method to reset all input fields
    private void resetFields() {
        initialAmountEditText.setText("");
        gstRateEditText.setText("");
        gstAmountEditText.setText("");
        netAmountEditText.setText("");
        addGSTRadioButton.setChecked(true);
    }

    // Method to handle back button click
    public void txt_back(View view) {
        finish();
    }
}
