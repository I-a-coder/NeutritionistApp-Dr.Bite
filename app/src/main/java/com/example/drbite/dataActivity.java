package com.example.drbite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dataActivity extends AppCompatActivity {

    private EditText foodEditText;
    private AppCompatImageButton plusButton, minusButton;
    private AppCompatButton continueButton;
    private List<String> foodItems = new ArrayList<>();
    private List<Integer> foodCalories = new ArrayList<>();
    private int totalCalories = 0;

    private HashMap<String, Integer> foodCalorieMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        foodEditText = findViewById(R.id.editTextText2);
        plusButton = findViewById(R.id.plus);
        minusButton = findViewById(R.id.minus);
        continueButton = findViewById(R.id.continueee);

        foodCalorieMap = new HashMap<>();
        foodCalorieMap.put("Apple", 95);
        foodCalorieMap.put("Banana", 105);
        foodCalorieMap.put("Orange", 62);
        foodCalorieMap.put("Pizza", 285);
        foodCalorieMap.put("Burger", 354);
        foodCalorieMap.put("Salad", 150);
        foodCalorieMap.put("Chicken Breast", 165);

        plusButton.setOnClickListener(view -> {
            String foodItem = foodEditText.getText().toString().trim();
            if (!foodItem.isEmpty()) {
                fetchCalories(foodItem);
                foodEditText.setText("");
            } else {
                Toast.makeText(dataActivity.this, "Please enter a food item", Toast.LENGTH_SHORT).show();
            }
        });

        minusButton.setOnClickListener(view -> {
            if (!foodItems.isEmpty()) {
                foodItems.remove(foodItems.size() - 1);
                foodCalories.remove(foodCalories.size() - 1);
                updateTotalCalories();
                updateDisplay();
            } else {
                Toast.makeText(dataActivity.this, "No items to remove", Toast.LENGTH_SHORT).show();
            }
        });

        continueButton.setOnClickListener(view -> {
            Intent intent = new Intent(dataActivity.this, ProgressActivity.class);
            intent.putExtra("totalCalories", totalCalories);
            startActivity(intent);
        });
    }

    private void fetchCalories(final String foodItem) {
        if (foodCalorieMap.containsKey(foodItem)) {
            int calories = foodCalorieMap.get(foodItem);
            foodItems.add(foodItem);
            foodCalories.add(calories);
            updateTotalCalories();
            updateDisplay();
        } else {
            Toast.makeText(dataActivity.this, "No calorie info found for this food", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTotalCalories() {
        totalCalories = 0;
        for (int calories : foodCalories) {
            totalCalories += calories;
        }
    }

    private void updateDisplay() {
        StringBuilder itemsDisplay = new StringBuilder();
        StringBuilder caloriesDisplay = new StringBuilder();

        for (int i = 0; i < foodItems.size(); i++) {
            itemsDisplay.append(foodItems.get(i)).append("\n");
            caloriesDisplay.append(foodCalories.get(i)).append("\n");
        }

        TextView itemTextView = findViewById(R.id.textView14);
        TextView calorieTextView = findViewById(R.id.textView15);

        itemTextView.setText(itemsDisplay.toString());
        calorieTextView.setText(caloriesDisplay.toString());
    }
}
