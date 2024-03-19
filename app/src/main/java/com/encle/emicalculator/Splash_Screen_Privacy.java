package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.emicalculator.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Splash_Screen_Privacy extends AppCompatActivity {
    ExtendedFloatingActionButton BTN_accept;
    CheckBox chk_privacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_privacy);

        chk_privacy=findViewById(R.id.chk_privacy);
        BTN_accept =findViewById(R.id.BTN_accept);


        BTN_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk_privacy.isChecked()){

                    startActivity(new Intent(Splash_Screen_Privacy.this,Splash_Screen.class));
                }else {
                    Toast.makeText(Splash_Screen_Privacy.this, "Please accept terms & conditions", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}