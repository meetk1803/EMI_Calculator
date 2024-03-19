package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.emicalculator.R;
import com.google.android.material.textview.MaterialTextView;

public class inDetails_Insurance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_details_insurance);

        // Retrieve data from intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        // Find TextViews in the layout
        MaterialTextView titleTextView = findViewById(R.id.insurance_title);
        MaterialTextView detailsTextView = findViewById(R.id.body_insurance);

        // Set data to TextViews
        titleTextView.setText(title);
        detailsTextView.setText(details);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void txt_back(View view) {
        finish();
    }
}