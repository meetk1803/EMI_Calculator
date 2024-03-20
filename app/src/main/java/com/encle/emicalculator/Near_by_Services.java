package com.encle.emicalculator;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.encle.emicalculator.Adapters.PlacesAdapter;
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

        placeList.add(new places(1, getString(R.string.placeName_Airport), R.drawable.places_airport));
        placeList.add(new places(2, getString(R.string.placeName_Amusement), R.drawable.places_amusement));
        placeList.add(new places(3, getString(R.string.placeName_Aquarium), R.drawable.places_aquarium));
        placeList.add(new places(4, getString(R.string.placeName_Art_Gallery), R.drawable.places_artgallery));
        placeList.add(new places(5, getString(R.string.placeName_ATM), R.drawable.places_atm));
        placeList.add(new places(6, getString(R.string.placeName_Bakery), R.drawable.places_bakery));
        placeList.add(new places(7, getString(R.string.placeName_Bank), R.drawable.places_bank));
        placeList.add(new places(8, getString(R.string.placeName_Beauty_Salon), R.drawable.places_beauty));
        placeList.add(new places(9, getString(R.string.placeName_Bicycle_Store), R.drawable.places_bicycle));
        placeList.add(new places(10, getString(R.string.placeName_Book_Store), R.drawable.places_book));
        placeList.add(new places(11, getString(R.string.placeName_Bowling_Alley), R.drawable.places_bowling));
        placeList.add(new places(12, getString(R.string.placeName_Bus_Station), R.drawable.places_bus));
        placeList.add(new places(13, getString(R.string.placeName_Cafe), R.drawable.places_cafe));
        placeList.add(new places(14, getString(R.string.placeName_Car_Dealer), R.drawable.places_car_dealer));
        placeList.add(new places(15, getString(R.string.placeName_Car_Rental), R.drawable.places_car_rental));
        placeList.add(new places(16, getString(R.string.placeName_Car_Repair), R.drawable.places_car_repair));
        placeList.add(new places(17, getString(R.string.placeName_Car_Wash), R.drawable.places_car_wash));
        placeList.add(new places(18, getString(R.string.placeName_Cemetery), R.drawable.places_cemetry));
        placeList.add(new places(19, getString(R.string.placeName_Church), R.drawable.places_church));
        placeList.add(new places(20, getString(R.string.placeName_City_Hall), R.drawable.places_cityhall));
        placeList.add(new places(21, getString(R.string.placeName_Clothing_Store), R.drawable.places_cloth));
        placeList.add(new places(22, getString(R.string.placeName_Convenience_Store), R.drawable.places_convenience));
        placeList.add(new places(23, getString(R.string.placeName_Court_House), R.drawable.places_court));
        placeList.add(new places(24, getString(R.string.placeName_Doctor), R.drawable.places_doctor));
        placeList.add(new places(25, getString(R.string.placeName_Electrician), R.drawable.places_electrician));
        placeList.add(new places(26, getString(R.string.placeName_Electronic_Store), R.drawable.places_electronic));
        placeList.add(new places(27, getString(R.string.placeName_Embassy), R.drawable.places_embassy));
        placeList.add(new places(28, getString(R.string.placeName_Fire_Station), R.drawable.places_fire));
        placeList.add(new places(29, getString(R.string.placeName_Furniture_Store), R.drawable.places_furniture));
        placeList.add(new places(30, getString(R.string.placeName_Gas_Station), R.drawable.places_gas));
        placeList.add(new places(31, getString(R.string.placeName_Grocery_Store), R.drawable.places_grocery));
        placeList.add(new places(32, getString(R.string.placeName_Gym), R.drawable.places_gym));
        placeList.add(new places(33, getString(R.string.placeName_Hair_Salon), R.drawable.places_hair));
        placeList.add(new places(34, getString(R.string.placeName_Hardware_Store), R.drawable.places_hardware));
        placeList.add(new places(35, getString(R.string.placeName_Hindu_Temple), R.drawable.places_hindutemple));
        placeList.add(new places(36, getString(R.string.placeName_Home_Goods), R.drawable.places_goods));
        placeList.add(new places(37, getString(R.string.placeName_Hospital), R.drawable.places_hospital));
        placeList.add(new places(38, getString(R.string.placeName_Insurance_Agency), R.drawable.places_insurance));
        placeList.add(new places(39, getString(R.string.placeName_Jewelry_Store), R.drawable.places_jwellery));
        placeList.add(new places(40, getString(R.string.placeName_Library), R.drawable.places_library));
        placeList.add(new places(41, getString(R.string.placeName_Local_Government_Office), R.drawable.places_localgov));
        placeList.add(new places(42, getString(R.string.placeName_Locksmith), R.drawable.places_locksmith));
        placeList.add(new places(43, getString(R.string.placeName_Meal_Delivery), R.drawable.places_mail));
        placeList.add(new places(44, getString(R.string.placeName_Museum), R.drawable.places_museum));
        placeList.add(new places(45, getString(R.string.placeName_Painter), R.drawable.places_painter));
        placeList.add(new places(46, getString(R.string.placeName_Parking), R.drawable.places_parking));
        placeList.add(new places(47, getString(R.string.placeName_Park), R.drawable.places_park));
        placeList.add(new places(48, getString(R.string.placeName_Pet_Store), R.drawable.places_petstore));
        placeList.add(new places(49, getString(R.string.placeName_Petrol_Pump), R.drawable.places_petrol));
        placeList.add(new places(50, getString(R.string.placeName_Pharmacy), R.drawable.places_pharmacy));
        placeList.add(new places(51, getString(R.string.placeName_Physiotherapist), R.drawable.places_physio));
        placeList.add(new places(52, getString(R.string.placeName_Plumber), R.drawable.places_plumber));
        placeList.add(new places(53, getString(R.string.placeName_Police), R.drawable.places_police));
        placeList.add(new places(54, getString(R.string.placeName_Real_Estate_Agency), R.drawable.places_real_estate));
        placeList.add(new places(55, getString(R.string.placeName_Roofing_Control), R.drawable.places_roofing));
        placeList.add(new places(56, getString(R.string.placeName_RV_Park), R.drawable.places_rvpark));
        placeList.add(new places(57, getString(R.string.placeName_School), R.drawable.places_school));
        placeList.add(new places(58, getString(R.string.placeName_Shoe_Store), R.drawable.places_shoes));
        placeList.add(new places(59, getString(R.string.placeName_Shopping_Mall), R.drawable.places_mall));
        placeList.add(new places(60, getString(R.string.placeName_Stadium), R.drawable.places_stadium));
        placeList.add(new places(61, getString(R.string.placeName_Subway_Station), R.drawable.places_subway));
        placeList.add(new places(62, getString(R.string.placeName_Super_Market), R.drawable.places_supermarket));
        placeList.add(new places(63, getString(R.string.placeName_Taxi_Stand), R.drawable.places_taxi));
        placeList.add(new places(64, getString(R.string.placeName_Train_Station), R.drawable.places_train));
        placeList.add(new places(65, getString(R.string.placeName_Travel_Agency), R.drawable.places_travelagency));
        placeList.add(new places(66, getString(R.string.placeName_Veterinary_Care), R.drawable.places_veterinary));
        placeList.add(new places(67, getString(R.string.placeName_Zoo), R.drawable.places_zoo));

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
