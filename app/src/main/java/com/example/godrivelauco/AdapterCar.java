/*
package com.example.godrivelauco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AdapterCar extends RecyclerView.Adapter<AdapterCar.MyViewHolder> {
    private List<Car> carsList;
    private Context context;

    private OnItemClickListener listener;

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(Car car);
    }


    public AdapterCar(Context context, List<Car> carsList) {
        this.context = context;
        this.carsList = carsList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Car c = carsList.get(position);

        holder.carName.setText(c.getName());


        // Convertir le nom de la ressource en ID de ressource
        int resourceId = context.getResources().getIdentifier(
                c.getImageResource(),
                "drawable",
                context.getPackageName()
        );



        // Définir l'image
        holder.carImage.setImageResource(resourceId);

        holder.rating.setText(String.format("%.1f", c.getRating()));
        holder.price.setText(String.valueOf(c.getPricePerDay()));
        holder.transmission.setText(c.getTransmission());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(c);
            }
        });

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_home_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return this.carsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView carName, transmission, rating, price;
        public ImageView carImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.carName);
            carImage = itemView.findViewById(R.id.carImage);
            transmission = itemView.findViewById(R.id.transmission);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}

*/




package com.example.godrivelauco;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import  com.example.godrivelauco.CarDescriptionActivity;

import java.util.List;

public class AdapterCar extends RecyclerView.Adapter<AdapterCar.MyViewHolder> {
    private List<Car> carsList;
    private Context context;

    private OnItemClickListener listener;

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(Car car);
    }

    public AdapterCar(Context context, List<Car> carsList) {
        this.context = context;
        this.carsList = carsList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Car c = carsList.get(position);

        holder.carName.setText(c.getName());

        // Convertir le nom de la ressource en ID de ressource
        int resourceId = context.getResources().getIdentifier(c.getImageResource(), "drawable", context.getPackageName());

        // Définir l'image
        holder.carImage.setImageResource(resourceId);

        holder.rating.setText(String.format("%.1f", c.getRating()));
        holder.price.setText(String.valueOf(c.getPricePerDay()));
        holder.transmission.setText(c.getTransmission());

        holder.itemView.setOnClickListener(v -> {
            // Pass car details and owner details to CarDescriptionActivity
            Intent intent = new Intent(context, CarDescriptionActivity.class);
            intent.putExtra("CAR_NAME", c.getName());
            intent.putExtra("CAR_TRANSMISSION", c.getTransmission());
            intent.putExtra("CAR_RATING", c.getRating());
            intent.putExtra("CAR_PRICE_PER_DAY", c.getPricePerDay());
            intent.putExtra("CAR_IMAGE", c.getImageResource());
            intent.putExtra("CAR_FAVORITE", c.isFavorite());

            // Pass owner details
            Owner owner = c.getOwner();
            intent.putExtra("OWNER_NAME", owner.getName());
            intent.putExtra("OWNER_EMAIL", owner.getEmail());
            intent.putExtra("OWNER_IMAGE_URL", owner.getImageUrl());
            intent.putExtra("OWNER_PHONE_NUMBER", owner.getPhoneNumber());

            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_home_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return this.carsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView carName, transmission, rating, price;
        public ImageView carImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.carName);
            carImage = itemView.findViewById(R.id.carImage);
            transmission = itemView.findViewById(R.id.transmission);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
