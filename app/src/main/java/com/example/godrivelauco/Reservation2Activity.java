package com.example.godrivelauco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Reservation2Activity extends AppCompatActivity {

    private Button reservationStep2btn;
    private ImageView GoBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.reservation2_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reservation2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        reservationStep2btn = findViewById(R.id.continue2Button);
        GoBackBtn = findViewById(R.id.imageViewGoBack);

        reservationStep2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reservation2Activity.this, Reservation3Activity.class);
                startActivity(intent);
            }
        });

        GoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reservation2Activity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });

    }
}
