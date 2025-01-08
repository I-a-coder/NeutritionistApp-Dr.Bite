package com.example.drbite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMIactivity extends AppCompatActivity {

    private EditText heightEditText, weightEditText, ageEditText, targetWeightEditText;
    private ImageButton calculateButton;
    private Spinner goalSpinner;
    private TextView weightDisplay;

    private static final double CALORIES_PER_KG = 7700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        heightEditText = findViewById(R.id.confirmpassword);
        weightEditText = findViewById(R.id.editTextText7);
        ageEditText = findViewById(R.id.editTextText3);
        targetWeightEditText = findViewById(R.id.editTextText);
        calculateButton = findViewById(R.id.calculate);
        goalSpinner = findViewById(R.id.spinner2);
        weightDisplay = findViewById(R.id.weightdisplay);

        String[] bmiGoals = {"Weight Loss", "Weight Gain", "Maintain"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, bmiGoals);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();
        String targetWeightStr = targetWeightEditText.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty() || ageStr.isEmpty() || targetWeightStr.isEmpty()) {
            Toast.makeText(BMIactivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double height = Double.parseDouble(heightStr) / 100;
        double weight = Double.parseDouble(weightStr);
        double targetWeight = Double.parseDouble(targetWeightStr);

        double bmi = weight / (height * height);

        weightDisplay.setText("BMI: " + String.format("%.2f", bmi));

        String selectedGoal = goalSpinner.getSelectedItem().toString();

        double caloriesIntake = calculateCaloriePlan(weight, targetWeight, selectedGoal);

        Toast.makeText(BMIactivity.this, "Calories Distribution for " + selectedGoal + ": " + caloriesIntake + " calories per day", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(BMIactivity.this, CurrentStatusActivity.class);
        intent.putExtra("targetWeight", targetWeight);
        intent.putExtra("caloriesIntake", caloriesIntake);
        intent.putExtra("currentWeight", weight);
        startActivity(intent);
    }

    private double calculateCaloriePlan(double currentWeight, double targetWeight, String goal) {
        double dailyCalories = 0;

        switch (goal) {
            case "Weight Loss":
                dailyCalories = (currentWeight * 30) - 500;
                break;
            case "Weight Gain":
                dailyCalories = (currentWeight * 30) + 500;
                break;
            case "Maintain":
                dailyCalories = currentWeight * 30;
                break;
        }

        return dailyCalories;
    }
}
