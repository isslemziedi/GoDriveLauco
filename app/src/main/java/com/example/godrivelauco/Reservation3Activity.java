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

public class Reservation3Activity extends AppCompatActivity {

    private Button btnContinue3;
    private ImageView GoBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.reservation3_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reservation3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnContinue3 = findViewById(R.id.continue3Button);

        GoBackBtn = findViewById(R.id.imageViewGoBack);

        btnContinue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reservation3Activity.this, CreditCardActivity.class);
                startActivity(intent);

            }
        });

        GoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reservation3Activity.this, Reservation2Activity.class);
                startActivity(intent);
            }
        });
    }

    }

