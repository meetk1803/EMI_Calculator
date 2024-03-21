package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.encle.emicalculator.Adapters.BankAdapter;
import com.encle.emicalculator.Adapters.LanguageAdapter;
import com.encle.emicalculator.Model.Bank;
import com.encle.emicalculator.Model.Language;
import com.example.emicalculator.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LanguageAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of
        List<Language> languageList = createLanguageList();

        // Initialize and set up the adapter
        adapter = new LanguageAdapter(this, languageList);
        recyclerView.setAdapter(adapter);
    }
    public void switchToHindi(View view) {
        setLocale("hi"); // Set Hindi locale
        recreate(); // Restart activity to apply changes
    }
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
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

}