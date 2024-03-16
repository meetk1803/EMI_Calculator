package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.emicalculator.R;

public class Insuarance_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insuarance_main);
    }

    //------------------------------------------------------------------------------------------------------

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void txt_back(View view) {
        finish();
    }
}