package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Splash_Screen_Privacy extends AppCompatActivity {
    ExtendedFloatingActionButton BTN_accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_privacy);

        BTN_accept =findViewById(R.id.BTN_accept);

        BTN_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash_Screen_Privacy.this,Splash_Screen.class));
            }
        });
    }
}