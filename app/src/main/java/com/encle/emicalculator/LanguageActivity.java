package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.encle.emicalculator.Adapters.BankAdapter;
import com.encle.emicalculator.Adapters.LanguageAdapter;
import com.encle.emicalculator.Model.Bank;
import com.encle.emicalculator.Model.Language;
import com.example.emicalculator.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class LanguageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LanguageAdapter adapter;

    public ShapeableImageView BTN_change;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        // Initialize RecyclerView

        BTN_change =findViewById(R.id.BTN_change);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of
        List<Language> languageList = createLanguageList();

        // Initialize and set up the adapter
        adapter = new LanguageAdapter(this, languageList);
        recyclerView.setAdapter(adapter);
    }

    private List<Language> createLanguageList() {
        List<Language> languages = new ArrayList<>();

        languages.add(new Language("English", R.drawable.english));
        languages.add(new Language("German", R.drawable.german));
        languages.add(new Language("Spanish", R.drawable.spanish));
        languages.add(new Language("French", R.drawable.french));
        languages.add(new Language("Hindi", R.drawable.hindi));
        languages.add(new Language( "Italian", R.drawable.italian));
        languages.add(new Language("Korean", R.drawable.korean));
        languages.add(new Language("Malay", R.drawable.malay));
        languages.add(new Language("Polish", R.drawable.polish));

        return languages;
    }

    public void txt_back(View view) {
        finish();
    }
    public void apply_changes(View view) {
        // Get the selected language from adapter
        String selectedLanguage = adapter.getSelectedLanguage();

        // Store the selected language in SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        preferences.edit().putString("selected_language", selectedLanguage).apply();

// Restart the Home_Loan_Emi_Calc activity to apply language changes
        Intent restartIntent = new Intent(this, Home_Loan_Emi_Calc.class);
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(restartIntent);
        finish();

    }


}