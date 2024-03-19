package com.encle.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.encle.emicalculator.Adapters.BankAdapter;
import com.encle.emicalculator.Adapters.PlacesAdapter;
import com.encle.emicalculator.Model.Bank;
import com.encle.emicalculator.Model.places;
import com.example.emicalculator.R;

import java.util.ArrayList;
import java.util.List;

public class Near_by_Services extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PlacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_services);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view_places);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // Create a list of placeList
        List<places> placesList = createplaceList();

        // Initialize and set up the adapter
        adapter = new PlacesAdapter(this, placesList);
        recyclerView.setAdapter(adapter);
    }

    private List<places> createplaceList() {
        List<places> placeList = new ArrayList<>();

        placeList.add(new places(1, "Airport", R.drawable.places_airport));
        placeList.add(new places(2, "Amusement", R.drawable.places_amusement));
        placeList.add(new places(3, "Aquarium", R.drawable.places_aquarium));
        placeList.add(new places(4, "Art Gallery", R.drawable.places_artgallery));
        placeList.add(new places(5, "ATM", R.drawable.places_atm));
        placeList.add(new places(6, "Bakery", R.drawable.places_bakery));
        placeList.add(new places(7, "Bank", R.drawable.places_bank));
        placeList.add(new places(8, "Beauty Salon", R.drawable.places_beauty));
        placeList.add(new places(9, "Bicycle Store", R.drawable.places_bicycle));
        placeList.add(new places(10, "Book Store", R.drawable.places_book));
        placeList.add(new places(11, "Bowling Alley", R.drawable.places_bowling));
        placeList.add(new places(12, "Bus Station", R.drawable.places_bus));
        placeList.add(new places(13, "Cafe", R.drawable.places_cafe));
        placeList.add(new places(14, "Car Dealer", R.drawable.places_car_dealer));
        placeList.add(new places(15, "Car Rental", R.drawable.places_car_rental));
        placeList.add(new places(16, "Car Repair", R.drawable.places_car_repair));
        placeList.add(new places(17, "Car Wash", R.drawable.places_car_wash));
        placeList.add(new places(18, "Cemetery", R.drawable.places_cemetry));
        placeList.add(new places(19, "Church", R.drawable.places_church));
        placeList.add(new places(20, "City Hall", R.drawable.places_cityhall));
        placeList.add(new places(21, "Clothing Store", R.drawable.places_cloth));
        placeList.add(new places(22, "Convenience Store", R.drawable.places_convenience));
        placeList.add(new places(23, "Court House", R.drawable.places_court));
        placeList.add(new places(24, "Doctor", R.drawable.places_doctor));
        placeList.add(new places(25, "Electrician", R.drawable.places_electrician));
        placeList.add(new places(26, "Electronic Store", R.drawable.places_electronic));
        placeList.add(new places(27, "Embassy", R.drawable.places_embassy));
        placeList.add(new places(28, "Fire Station", R.drawable.places_fire));
        placeList.add(new places(29, "Furniture Store", R.drawable.places_furniture));
        placeList.add(new places(30, "Gas Station", R.drawable.places_gas));
        placeList.add(new places(31, "Grocery Store", R.drawable.places_grocery));
        placeList.add(new places(32, "Gym", R.drawable.places_gym));
        placeList.add(new places(33, "Hair Salon", R.drawable.places_hair));
        placeList.add(new places(34, "Hardware Store", R.drawable.places_hardware));
        placeList.add(new places(35, "Hindu Temple", R.drawable.places_hindutemple));
        placeList.add(new places(36, "Home Goods", R.drawable.places_goods));
        placeList.add(new places(37, "Hospital", R.drawable.places_hospital));
        placeList.add(new places(38, "Insurance Agency", R.drawable.places_insurance));
        placeList.add(new places(39, "Jewelry Store", R.drawable.places_jwellery));
        placeList.add(new places(40, "Library", R.drawable.places_library));
        placeList.add(new places(41, "Local Government Office", R.drawable.places_localgov));
        placeList.add(new places(42, "Locksmith", R.drawable.places_locksmith));
        placeList.add(new places(43, "Meal Delivery", R.drawable.places_mail));
        placeList.add(new places(44, "Museum", R.drawable.places_museum));
        placeList.add(new places(45, "Painter", R.drawable.places_painter));
        placeList.add(new places(46, "Parking", R.drawable.places_parking));
        placeList.add(new places(47, "Park", R.drawable.places_park));
        placeList.add(new places(48, "Pet Store", R.drawable.places_petstore));
        placeList.add(new places(49, "Petrol Pump", R.drawable.places_petrol));
        placeList.add(new places(50, "Pharmacy", R.drawable.places_pharmacy));
        placeList.add(new places(51, "Physiotherapist", R.drawable.places_physio));
        placeList.add(new places(52, "Plumber", R.drawable.places_plumber));
        placeList.add(new places(53, "Police", R.drawable.places_police));
        placeList.add(new places(54, "Real Estate Agency", R.drawable.places_real_estate));
        placeList.add(new places(55, "Roofing Control", R.drawable.places_roofing));
        placeList.add(new places(56, "RV Park", R.drawable.places_rvpark));
        placeList.add(new places(57, "School", R.drawable.places_school));
        placeList.add(new places(58, "Shoe Store", R.drawable.places_shoes));
        placeList.add(new places(59, "Shopping Mall", R.drawable.places_mall));
        placeList.add(new places(60, "Stadium", R.drawable.places_stadium));
        placeList.add(new places(61, "Subway Station", R.drawable.places_subway));
        placeList.add(new places(62, "Super Market", R.drawable.places_supermarket));
        placeList.add(new places(63, "Taxi Stand", R.drawable.places_taxi));
        placeList.add(new places(64, "Train Station", R.drawable.places_train));
        placeList.add(new places(65, "Travel Agency", R.drawable.places_travelagency));
        placeList.add(new places(66, "Veterinary Care", R.drawable.places_veterinary));
        placeList.add(new places(67, "Zoo", R.drawable.places_zoo));

        return placeList;
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
