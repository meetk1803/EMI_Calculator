package com.encle.emicalculator.Adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.encle.emicalculator.Model.places;
import com.example.emicalculator.R;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {
    private Context context;
    private List<places> placesList;


    public PlacesAdapter(Context context, List<places> placesList) {
        this.context = context;
        this.placesList = placesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        places places = placesList.get(position);
        holder.bankName.setText(places.getName());
        holder.bankLogo.setImageResource(places.getLogo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the name of the place
                String placeName = places.getName();

                // Construct the URI for searching the place on Google Maps
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + placeName);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bankLogo;
        TextView bankName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bankLogo = itemView.findViewById(R.id.bank_logo);
            bankName = itemView.findViewById(R.id.bank_name);
        }
    }
}
