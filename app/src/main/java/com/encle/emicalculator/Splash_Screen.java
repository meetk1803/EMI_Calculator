package com.encle.emicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.emicalculator.R;
import com.google.android.material.card.MaterialCardView;

public class Splash_Screen extends AppCompatActivity {

    MaterialCardView card_share, card_rateus, card_privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        card_share = findViewById(R.id.card_share);
        card_privacy = findViewById(R.id.card_privacy);


        card_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent with ACTION_SEND
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                // Set the type of content to text/plain
                shareIntent.setType("text/plain");

                // Set the content of the sharing
                String shareMessage = "Check out this amazing app!";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

                // Launch the sharing activity
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        card_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash_Screen.this, Privacy_policy.class));
            }
        });

        YoYo.with(Techniques.FadeIn)
                .duration(2000)
                .playOn(findViewById(R.id.getstarted_layout));

    }

    public void getStarted(View view) {
        startActivity(new Intent(Splash_Screen.this, Home_Loan_Emi_Calc.class));
        finish();
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Splash_Screen.this, Rate_us_Screen.class);
        startActivity(i);
    }
}