/*
package com.example.godrivelauco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CarDescriptionActivity extends AppCompatActivity {

    private ImageView GoBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_car_description);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.carDesc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        GoBackBtn = findViewById(R.id.btnBack);


        // Retrieve car details from intent
        String carName = getIntent().getStringExtra("CAR_NAME");
        String carTransmission = getIntent().getStringExtra("CAR_TRANSMISSION");
        double carRating = getIntent().getDoubleExtra("CAR_RATING", 0.0);
        int carPricePerDay = getIntent().getIntExtra("CAR_PRICE_PER_DAY", 0);
        String carImage = getIntent().getStringExtra("CAR_IMAGE");
        boolean isFavorite = getIntent().getBooleanExtra("CAR_FAVORITE", false);

        // Find and update UI elements
        TextView titleTextView = findViewById(R.id.tvCarName);
        RatingBar ratingTextView = findViewById(R.id.ratingBar);
        ImageView carImageView = findViewById(R.id.imgCarImage);
        // Add more UI element references as needed

        // Set the values
        titleTextView.setText(carName);
        ratingTextView.setRating((float) carRating);

        // Set car image (assuming you're using drawable resources)
        int imageResourceId = getResources().getIdentifier(carImage, "drawable", getPackageName());
        if (imageResourceId != 0) {
            carImageView.setImageResource(imageResourceId);
        }


        GoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDescriptionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}

*/





/*
package com.example.godrivelauco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CarDescriptionActivity extends AppCompatActivity {

    private ImageView GoBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_car_description);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.carDesc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GoBackBtn = findViewById(R.id.btnBack);

        // Retrieve car details from intent
        String carName = getIntent().getStringExtra("CAR_NAME");
        String carTransmission = getIntent().getStringExtra("CAR_TRANSMISSION");
        double carRating = getIntent().getDoubleExtra("CAR_RATING", 0.0);
        int carPricePerDay = getIntent().getIntExtra("CAR_PRICE_PER_DAY", 0);
        String carImage = getIntent().getStringExtra("CAR_IMAGE");
        boolean isFavorite = getIntent().getBooleanExtra("CAR_FAVORITE", false);

        // Retrieve owner details from intent
        String ownerName = getIntent().getStringExtra("OWNER_NAME");
        String ownerEmail = getIntent().getStringExtra("OWNER_EMAIL");
        String ownerImageUrl = getIntent().getStringExtra("OWNER_IMAGE_URL");
        String ownerPhoneNumber = getIntent().getStringExtra("OWNER_PHONE_NUMBER");

        // Find and update UI elements
        TextView titleTextView = findViewById(R.id.tvCarName);
        RatingBar ratingTextView = findViewById(R.id.ratingBar);
        ImageView carImageView = findViewById(R.id.imgCarImage);

        // Owner details
        TextView ownerNameTextView = findViewById(R.id.ownerName);
        TextView ownerEmailTextView = findViewById(R.id.ownerEmail);
        ImageView ownerImageView = findViewById(R.id.ownerProfilePic);

        // Set the values
        titleTextView.setText(carName);
        ratingTextView.setRating((float) carRating);

        // Set car image (assuming you're using drawable resources)
        int imageResourceId = getResources().getIdentifier(carImage, "drawable", getPackageName());
        if (imageResourceId != 0) {
            carImageView.setImageResource(imageResourceId);
        }

        // Set owner details
        ownerNameTextView.setText(ownerName);
        ownerEmailTextView.setText(ownerEmail);
        int ownerImageResourceId = getResources().getIdentifier(ownerImageUrl, "drawable", getPackageName());
        if (ownerImageResourceId != 0) {
            ownerImageView.setImageResource(ownerImageResourceId);
        }

        GoBackBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CarDescriptionActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
*/


package com.example.godrivelauco;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarDescriptionActivity extends AppCompatActivity {

    private ImageView goBackBtn, smsIcon, phoneIcon, locationIcon;
    private ImageView ownerProfilePic;
    private TextView carNameTextView, transmissionTextView, priceTextView, ownerNameTextView, ownerEmailTextView, locationTextView;
    private RatingBar ratingBar;
    private Car car;
    private Owner owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_description);

        // Initialize UI elements
        initializeViews();

        // Retrieve car and owner details from intent
        retrieveIntentData();

        // Set values to UI elements
        populateUIWithCarDetails();

        // Set click listeners
        setupClickListeners();
    }

    private void initializeViews() {
        goBackBtn = findViewById(R.id.btnBack);
        smsIcon = findViewById(R.id.smsIcon);
        phoneIcon = findViewById(R.id.phoneIcon);
        locationIcon = findViewById(R.id.locationIcon);
        ownerProfilePic = findViewById(R.id.ownerProfilePic);
        ownerNameTextView = findViewById(R.id.ownerName);
        ownerEmailTextView = findViewById(R.id.ownerEmail);
        locationTextView = findViewById(R.id.tvLocation);
        carNameTextView = findViewById(R.id.tvCarName);
        ratingBar = findViewById(R.id.ratingBar);
        transmissionTextView = findViewById(R.id.tvTransmission);
        priceTextView = findViewById(R.id.tvPricePerDay);
    }

    private void retrieveIntentData() {
        car = (Car) getIntent().getSerializableExtra("CAR");
        if (car != null) {
            owner = car.getOwner();
        }
    }

    private void populateUIWithCarDetails() {
        if (car != null && owner != null) {
            carNameTextView.setText(car.getName());
            ratingBar.setRating((float) car.getRating());
            transmissionTextView.setText(car.getTransmission());
            priceTextView.setText(String.format("$%d/day", car.getPricePerDay()));

            ownerNameTextView.setText(owner.getName());
            ownerEmailTextView.setText(owner.getEmail());
            locationTextView.setText(owner.getImageUrl());  // Using imageUrl as location for this example

            int imageResourceId = getResources().getIdentifier(owner.getImageUrl(), "drawable", getPackageName());
            if (imageResourceId != 0) {
                ownerProfilePic.setImageResource(imageResourceId);
            }
        }
    }

    private void setupClickListeners() {
        goBackBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CarDescriptionActivity.this, MainActivity.class);
            startActivity(intent);
        });

        smsIcon.setOnClickListener(v -> {
            if (owner != null) {
                String smsUri = "smsto:" + owner.getPhoneNumber();
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(smsUri));
                startActivity(smsIntent);
            }
        });

        phoneIcon.setOnClickListener(v -> {
            if (owner != null) {
                String phoneUri = "tel:" + owner.getPhoneNumber();
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneUri));
                startActivity(phoneIntent);
            }
        });

        locationIcon.setOnClickListener(v -> {
            if (owner != null) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + owner.getImageUrl());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
