package com.example.godrivelauco;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreditCardActivity extends AppCompatActivity {

    private Spinner spinnerMonth;
    private Spinner spinnerYear;
    private Button confirmBtn;

    private ImageView GoBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.credit_card);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.credit_card), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerMonth = findViewById(R.id.spinner_month);
        spinnerYear = findViewById(R.id.spinner_year);
        confirmBtn = findViewById(R.id.confirmBooking4Button);
        GoBackBtn = findViewById(R.id.imageViewGoBack);

        GoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreditCardActivity.this, Reservation3Activity.class);
                startActivity(intent);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreditCardActivity.this, ReservationSuccessActivity.class);
                startActivity(intent);
            }
        });

        // Month Adapter
        String[] months = {"Month", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthAdapter);

        // Year Adapter
        String[] years = {"Year", "2023", "2024", "2025", "2026", "2027"};
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);

        // Spinner Listeners
        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) view).setTextColor(Color.GRAY); // Set color for default text
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) view).setTextColor(Color.GRAY); // Set color for default text
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

}
