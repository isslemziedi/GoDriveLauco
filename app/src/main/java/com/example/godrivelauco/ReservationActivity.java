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

public class ReservationActivity extends AppCompatActivity {

    private Button reservationStep1btn;

    private ImageView GoBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.reservation_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reservation), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        reservationStep1btn = findViewById(R.id.continue1Button);
        GoBackBtn = findViewById(R.id.imageViewGoBack);

        reservationStep1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationActivity.this, Reservation2Activity.class);
                startActivity(intent);
            }
        });

        GoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
