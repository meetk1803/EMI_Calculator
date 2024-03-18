package com.encle.emicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.encle.emicalculator.Adapters.insurance_adapter;
import com.encle.emicalculator.Model.insurance_model;
import com.example.emicalculator.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Insuarance_Main extends AppCompatActivity {
    private CardView[] cardViews;
    private List<insurance_model> insuranceItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insuarance_main);

        // Initialize CardViews array
        cardViews = new CardView[]{
                findViewById(R.id.health_card),
                findViewById(R.id.motor_card),
                findViewById(R.id.home_card),
                findViewById(R.id.fire_card),
                findViewById(R.id.travel_card),
                findViewById(R.id.property_card),
                findViewById(R.id.term_life_card),
                findViewById(R.id.whole_life_card),
                findViewById(R.id.endowment_plans_card),
                findViewById(R.id.unit_linked_Card),
                findViewById(R.id.child_plans_card),
                findViewById(R.id.pension_plans_card)
        };

        // Parse JSON data
        String jsonString = loadJSONFromResource();
        insuranceItems = insurance_adapter.parseJson(jsonString);

        // Set onClickListeners for cardViews
        for (int i = 0; i < cardViews.length; i++) {
            final int index = i;
            cardViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openInsuranceDetails(index);
                }
            });
        }
    }

    private void openInsuranceDetails(int index) {
        if (index >= 0 && index < insuranceItems.size()) {
            insurance_model item = insuranceItems.get(index);
            String title = item.getTitle();
            String details = item.getDescription();

            // Create an intent to start the next activity
            Intent intent = new Intent(Insuarance_Main.this, inDetails_Insurance.class);
            intent.putExtra("title", title);
            intent.putExtra("details", details);
            startActivity(intent);
        } else {
            // Handle invalid index
            Toast.makeText(this, "Insurance details not available", Toast.LENGTH_SHORT).show();
        }
    }

    // Load JSON data from the resource file
    private String loadJSONFromResource() {
        String json;
        try (InputStream is = getResources().openRawResource(R.raw.insurance_data)) {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle IOException
            Toast.makeText(this, "Error reading JSON data", Toast.LENGTH_SHORT).show();
            return null;
        }
        return json;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void txt_back(View view) {
        finish();
    }
}