package com.example.godrivelauco;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcceuillActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acceuill1_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.acceuill1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Automatically navigate to MainActivity2 after 4 seconds
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AcceuillActivity1.this, AcceuillActivity2.class);
                startActivity(intent);
                finish(); // Optional: closes the current activity
            }
        }, 4000); // 4000 milliseconds = 3 seconds

    }
}
