package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.emicalculator.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
     private ImageView hindi, english, german,french;
    private static final String DEFAULT_LANGUAGE = "en";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        hindi = findViewById(R.id.hindi);
        english = findViewById(R.id.english);
        german = findViewById(R.id.german);
        french = findViewById(R.id.french);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.setLanguage(LanguageActivity.this, LanguageActivity.DEFAULT_LANGUAGE);
                LanguageActivity.this.startActivity(new Intent(LanguageActivity.this, Home_Loan_Emi_Calc.class));
            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.setLanguage(LanguageActivity.this, "hi");
                LanguageActivity.this.startActivity(new Intent(LanguageActivity.this, Home_Loan_Emi_Calc.class));
            }
        });
        german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.setLanguage(LanguageActivity.this, "de");
                LanguageActivity.this.startActivity(new Intent(LanguageActivity.this, Home_Loan_Emi_Calc.class));
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.setLanguage(LanguageActivity.this, "fr");
                LanguageActivity.this.startActivity(new Intent(LanguageActivity.this, Home_Loan_Emi_Calc.class));
            }
        });
    }

    public void txt_back(View view) {
        finish();
    }
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Home_Loan_Emi_Calc.class));
    }
    public static void setLanguage(Context context, String str) {
        Locale locale = new Locale(str);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        saveSelectedLanguage(context, str);
    }
    public static String getSelectedLanguage(Context context) {
        return context.getSharedPreferences("AppPreferences", 0).getString("", DEFAULT_LANGUAGE);
    }

    private static void saveSelectedLanguage(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AppPreferences", 0).edit();
        edit.putString("", str);
        edit.apply();
    }
}
