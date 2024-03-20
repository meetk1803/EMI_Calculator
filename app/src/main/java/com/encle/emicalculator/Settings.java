package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.emicalculator.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void open_language(View view) {
        Intent intent = new Intent(this, LanguageActivity.class);
        startActivity(intent);
    }
    public void txt_back(View view) {
        finish();
    }
}