package com.example.godrivelauco;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class filter_result extends AppCompatActivity {
    private RecyclerView recycleFilter ;
    private List<Car> carList;
    private AdapterCar carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filter_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.filter_result), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        recycleFilter = findViewById(R.id.recyclerViewResult);
        recycleFilter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //initializeCars();
        carAdapter = new AdapterCar(this,carList);
        recycleFilter.setAdapter(carAdapter);

    }
 /*   private void initializeCars() {
        carList = new ArrayList<>();
        carList.add(new Car("Jaguar F Pace", "Automatic", 4.8, 200, R.drawable.maserati));
        carList.add(new Car("Jaguar F Pace", "Automatic", 3.8, 150, R.drawable.red_car));
        carList.add(new Car("Jaguar F Pace", "Automatic", 4.1, 300, R.drawable.black_car));
        carList.add(new Car("Jaguar F Pace", "Automatic", 4.8, 200, R.drawable.maserati));
        carList.add(new Car("Jaguar F Pace", "Automatic", 3.8, 150, R.drawable.red_car));
        carList.add(new Car("Jaguar F Pace", "Automatic", 4.1, 300, R.drawable.black_car));
    }*/
}