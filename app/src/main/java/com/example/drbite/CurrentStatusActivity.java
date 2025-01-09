package com.example.drbite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CurrentStatusActivity extends AppCompatActivity {

    private TextView currentWeightText, goalWeightText, weeklyPlanText, dailyPlanText;
    private Button currentWeightButton;
    private TextView goalWeightDisplay, weeklyPlanDisplay, dailyPlanDisplay, currentWeightDisplay;
    private ImageButton doitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentstatus);

        currentWeightText = findViewById(R.id.currentWeightLabel);
        goalWeightText = findViewById(R.id.goalWeightLabel);
        weeklyPlanText = findViewById(R.id.weeklyPlanLabel);
        dailyPlanText = findViewById(R.id.dailyPlanLabel);

        currentWeightDisplay = findViewById(R.id.currentWeightValue);
        goalWeightDisplay = findViewById(R.id.goalWeightValue);
        weeklyPlanDisplay = findViewById(R.id.weeklyPlanValue);
        dailyPlanDisplay = findViewById(R.id.dailyPlanValue);

        doitButton = findViewById(R.id.doIt);

        double targetWeight = getIntent().getDoubleExtra("targetWeight", 0.0);
        double caloriesIntake = getIntent().getDoubleExtra("caloriesIntake", 0.0);
        double currentWeight = getIntent().getDoubleExtra("currentWeight", 0.0);

        double weeklyPlan = caloriesIntake * 7;
        double dailyPlan = caloriesIntake;

        currentWeightDisplay.setText(String.format("%.2f", currentWeight) + " kg");
        goalWeightDisplay.setText(String.format("%.2f", targetWeight) + " kg");
        weeklyPlanDisplay.setText(String.format("%.2f", weeklyPlan) + " kcal");
        dailyPlanDisplay.setText(String.format("%.2f", dailyPlan) + " kcal");

        doitButton.setOnClickListener(v -> {
            Intent intent = new Intent(CurrentStatusActivity.this, dataActivity.class);
            intent.putExtra("dailyPlan", dailyPlan); // Pass dailyPlan to ProgressActivity
            intent.putExtra("totalCalories", 0.0); // Pass totalCalories as 0 for now
            startActivity(intent);
        });
    }
}