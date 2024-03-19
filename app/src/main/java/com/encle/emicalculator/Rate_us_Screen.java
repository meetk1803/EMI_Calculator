package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Rate_us_Screen extends AppCompatActivity {

    LinearLayout layout_rate_yesno;

    ExtendedFloatingActionButton BTN_YES,BTN_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us_screen);

        layout_rate_yesno = findViewById(R.id.layout_rate_yesno);
        BTN_YES =findViewById(R.id.BTN_YES);
        BTN_NO =findViewById(R.id.BTN_NO);

        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra("privacy") != null) {
            String source = intent.getStringExtra("privacy");
            if (source.equals("privacy")) {
                layout_rate_yesno.setVisibility(View.VISIBLE);
            }
        }

        BTN_YES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        BTN_NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}