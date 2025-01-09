package com.example.drbite;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    private TextView requiredValueTextView;
    private TextView obtainedValueTextView;
    private TextView remainingValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        requiredValueTextView = findViewById(R.id.requiredvalue);
        obtainedValueTextView = findViewById(R.id.obtainedvalue);
        remainingValueTextView = findViewById(R.id.remainingvalue);


        double dailyPlan = getIntent().getDoubleExtra("dailyPlan", 0.0);
        int totalCalories = getIntent().getIntExtra("totalCalories", 0);


        double remainingCalories = dailyPlan - totalCalories;


        requiredValueTextView.setText(String.format("%.2f", dailyPlan) + " kcal");
        obtainedValueTextView.setText(String.format("%d kcal", totalCalories));
        remainingValueTextView.setText(String.format("%.2f", remainingCalories) + " kcal");
    }
}