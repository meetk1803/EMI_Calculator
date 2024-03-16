package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.emicalculator.R;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        YoYo.with(Techniques.FadeIn)
                .duration(2000)
                .playOn(findViewById(R.id.getstarted_layout));

    }

    public void getStarted(View view){
        startActivity(new Intent(Splash_Screen.this,Home_Loan_Emi_Calc.class));
    }
}