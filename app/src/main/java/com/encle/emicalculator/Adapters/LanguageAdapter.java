package com.encle.emicalculator.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.encle.emicalculator.Model.Language;
import com.example.emicalculator.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {
    private Context context;
    private List<Language> languageList;
    private int lastCheckedPosition = -1; // Variable to store the last checked position

    public LanguageAdapter(Context context, List<Language> languageList) {
        this.context = context;
        this.languageList = languageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.languageitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Language language = languageList.get(position);

        // Set language name
        holder.languageNameTextView.setText(language.getName());
        holder.languageLogoImageView.setImageResource(language.getLogo());

        // Set radio button checked state
        holder.languageRadioButton.setChecked(position == lastCheckedPosition);

        // Set click listener for radio button
        holder.languageRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != lastCheckedPosition) {
                    if (lastCheckedPosition != -1) {
                        // Uncheck the previous item
                        languageList.get(lastCheckedPosition).setSelected(false);
                    }
                    // Check the current item
                    languageList.get(position).setSelected(true);
                    lastCheckedPosition = position;
                    notifyDataSetChanged(); // Refresh the RecyclerView to reflect changes
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView languageLogoImageView;
        RadioButton languageRadioButton;
        AppCompatTextView languageNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            // Initialize views
            languageLogoImageView = itemView.findViewById(R.id.languageLogoImageView);
            languageRadioButton = itemView.findViewById(R.id.chk__privacy);
            languageNameTextView = itemView.findViewById(R.id.languageNameTextView);
        }
    }
}
