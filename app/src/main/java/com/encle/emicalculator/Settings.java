package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.emicalculator.R;

public class Settings extends AppCompatActivity {

    public ImageView language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        language = findViewById(R.id.language);
        updateLanguageText();
    }

    private void updateLanguageText() {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String selectedLanguage = preferences.getString("selected_language", "English");
       // language.setText(selectedLanguage);
    }

    public void open_language(View view) {
        Intent intent = new Intent(this, LanguageActivity.class);
        startActivity(intent);
    }
    public void txt_back(View view) {
        finish();
    }

    public void share_app(View view){
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

    public void open_privacy(View v){
        startActivity(new Intent(this,Privacy_policy.class));
    }
}