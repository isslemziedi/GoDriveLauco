package com.example.godrivelauco;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private AdapterCar carAdapter;
    private List<Car> carList;
    private RecyclerView recyclerViewBrand;
    private BrandAdapter brandAdapter;
    private List<Brand> brandList;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceCar;
    private DatabaseReference databaseReferenceBrand;


    private View GoToHome;
    private  View GoToProfile;
    private View GoToReservation;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialiser Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReferenceBrand = databaseReference.child("brands");
        databaseReferenceCar = databaseReference.child("cars");


        recyclerViewBrand= findViewById(R.id.brandRecyclerView);
        recyclerView1= findViewById(R.id.recycleNearCar);
        recyclerView2 = findViewById(R.id.recyclePopularCar);

        GoToHome = findViewById(R.id.nav_home);
        GoToProfile =  findViewById(R.id.nav_profile);
        GoToReservation = findViewById(R.id.nav_reservation);


        GoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        GoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        GoToReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });

        recyclerViewBrand.setNestedScrollingEnabled(false);
        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);

        brandList =new ArrayList<>();


        recyclerViewBrand.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        // initializeBrands();
        brandAdapter = new BrandAdapter(brandList);
        recyclerViewBrand.setAdapter(brandAdapter);


        // Charger les données depuis Firebase
       loadBrandsFromFirebase();
        // Charger les voitures depuis Firebase
        loadCarsFromFirebase();



        // Initialize car list
        carList = new ArrayList<>();

        carAdapter = new AdapterCar(this , carList);
        recyclerView1.setAdapter(carAdapter);
        recyclerView2.setAdapter(carAdapter);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



    }



    private void loadBrandsFromFirebase() {
        databaseReferenceBrand.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            brandList.clear();
            for (DataSnapshot brandSnapshot : snapshot.getChildren()) {
                Brand brand = brandSnapshot.getValue(Brand.class);
                if (brand != null) {
                    brandList.add(brand);
                }
            }
            brandAdapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(MainActivity.this, "Erreur de chargement: " + error.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    });
}


    private void loadCarsFromFirebase() {
        databaseReferenceCar.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                carList.clear();
                for (DataSnapshot carSnapshot : snapshot.getChildren()) {
                    Car car = carSnapshot.getValue(Car.class);
                    if (car != null) {
                        carList.add(car);
                    }
                }
                carAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Erreur de chargement: " +
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}