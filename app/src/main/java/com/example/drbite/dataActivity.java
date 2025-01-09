package com.example.drbite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataActivity extends AppCompatActivity {

    private ImageButton plusButton, minusButton, continueButton;
    private List<String> foodItems = new ArrayList<>();
    private List<Integer> foodCalories = new ArrayList<>();
    private int totalCalories = 0;
    private static final String TAG = "NutritionApp";
    private Map<String, Integer> foodCalorieMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        // Initialize the food calorie map
        initializeFoodCalorieMap();

        plusButton = findViewById(R.id.plus);
        minusButton = findViewById(R.id.minus);
        continueButton = findViewById(R.id.continueee);

        plusButton.setOnClickListener(view -> {
            String foodItem = ((EditText) findViewById(R.id.editTextText2)).getText().toString().trim();
            if (!foodItem.isEmpty()) {
                fetchCalories(foodItem);
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

            double dailyPlan = getIntent().getDoubleExtra("dailyPlan", 0.0);
            Intent intent = new Intent(dataActivity.this, ProgressActivity.class);
            intent.putExtra("totalCalories", totalCalories);
            intent.putExtra("dailyPlan", dailyPlan);
            startActivity(intent);
        });
    }

    private void initializeFoodCalorieMap() {
        foodCalorieMap = new HashMap<>();

        foodCalorieMap.put("Apple", 52);
        foodCalorieMap.put("Banana", 89);
        foodCalorieMap.put("Orange", 47);
        foodCalorieMap.put("Nutella", 539);
        foodCalorieMap.put("Coca-Cola", 42);
        foodCalorieMap.put("Chicken Breast", 165);
        foodCalorieMap.put("Rice", 130);
        foodCalorieMap.put("Broccoli", 34);
        foodCalorieMap.put("Egg", 155);
        foodCalorieMap.put("Almonds", 576);
        foodCalorieMap.put("Peanut Butter", 588);
        foodCalorieMap.put("Oatmeal", 71);
        foodCalorieMap.put("Pasta", 131);
        foodCalorieMap.put("Potato", 77);
        foodCalorieMap.put("Tomato", 18);
        foodCalorieMap.put("Cheddar Cheese", 402);
        foodCalorieMap.put("Yogurt", 59);
        foodCalorieMap.put("Salmon", 206);
        foodCalorieMap.put("Beef", 250);
        foodCalorieMap.put("Pork", 242);
        foodCalorieMap.put("Shrimp", 99);
        foodCalorieMap.put("Tuna", 132);
        foodCalorieMap.put("Mango", 60);
        foodCalorieMap.put("Grapes", 69);
        foodCalorieMap.put("Strawberries", 32);
        foodCalorieMap.put("Blueberries", 57);
        foodCalorieMap.put("Watermelon", 30);
        foodCalorieMap.put("Carrot", 41);
        foodCalorieMap.put("Spinach", 23);
        foodCalorieMap.put("Cucumber", 16);
        foodCalorieMap.put("Bell Pepper", 20);
        foodCalorieMap.put("Zucchini", 17);
        foodCalorieMap.put("Onion", 40);
        foodCalorieMap.put("Garlic", 149);
        foodCalorieMap.put("Honey", 304);
        foodCalorieMap.put("Sugar", 387);
        foodCalorieMap.put("Dark Chocolate", 546);
        foodCalorieMap.put("Ice Cream", 207);
        foodCalorieMap.put("Pizza", 285);
        foodCalorieMap.put("Burger", 250);
        foodCalorieMap.put("Fries", 365);
        foodCalorieMap.put("Soda", 150);
        foodCalorieMap.put("Granola Bar", 100);
        foodCalorieMap.put("Cereal", 375);
        foodCalorieMap.put("Pancakes", 227);
        foodCalorieMap.put("Waffles", 291);
        foodCalorieMap.put("Bagel", 250);
        foodCalorieMap.put("Croissant", 406);
        foodCalorieMap.put("Doughnut", 452);
        foodCalorieMap.put("Chips", 536);
        foodCalorieMap.put("Popcorn", 387);
        foodCalorieMap.put("Nuts", 607);
        foodCalorieMap.put("Seeds", 573);
        foodCalorieMap.put("Coconut", 354);
        foodCalorieMap.put("Avocado", 160);
        foodCalorieMap.put("Biryani", 250);
        foodCalorieMap.put("Nihari", 300);
        foodCalorieMap.put("Karahi", 350);
        foodCalorieMap.put("Kebab", 250);
        foodCalorieMap.put("Paratha", 300);
        foodCalorieMap.put("Roti", 120);
        foodCalorieMap.put("Samosa", 300);
        foodCalorieMap.put("Pakora", 250);
        foodCalorieMap.put("Chaat", 200);
        foodCalorieMap.put("Chana Chaat", 180);
        foodCalorieMap.put("Halwa", 350);
        foodCalorieMap.put("Gulab Jamun", 330);
        foodCalorieMap.put("Jalebi", 300);
        foodCalorieMap.put("Lassi", 120);
        foodCalorieMap.put("Daal", 120);
        foodCalorieMap.put("Aloo Gosht", 250);
        foodCalorieMap.put("Palak Paneer", 200);
        foodCalorieMap.put("Chana Daal", 150);
        foodCalorieMap.put("Bh indi Masala", 150);
        foodCalorieMap.put("Kheer", 120);
        foodCalorieMap.put("Bun Kebab", 300);
        foodCalorieMap.put("Pulao", 200);
        foodCalorieMap.put("Dahi Bhalla", 250);
        foodCalorieMap.put("Chappal Kebab", 350);
        foodCalorieMap.put("Kofta", 300);
        foodCalorieMap.put("Naan", 250);
        foodCalorieMap.put("Chutney", 50);
        foodCalorieMap.put("Pani Puri", 200);
        foodCalorieMap.put("Dahi", 60);
        foodCalorieMap.put("Methi Thepla", 200);
        foodCalorieMap.put("Kachori", 300);
        foodCalorieMap.put("Chicken Tikka", 200);
        foodCalorieMap.put("Fish Curry", 250);
        foodCalorieMap.put("Mutton Karahi", 400);
        foodCalorieMap.put("Chicken Qorma", 350);
        foodCalorieMap.put("Vegetable Biryani", 220);
        foodCalorieMap.put("Chole Bhature", 350);
        foodCalorieMap.put("Aloo Tikki", 200);
        foodCalorieMap.put("Mutton Biryani", 300);
        foodCalorieMap.put("Daal Makhani", 200);
        foodCalorieMap.put("Aloo Baingan", 150);
        foodCalorieMap.put("Kadhi", 150);
        foodCalorieMap.put("Mutton Nihari", 400);
        foodCalorieMap.put("Chicken Seekh Kebab", 250);
        foodCalorieMap.put("Vegetable Samosa", 300);
        foodCalorieMap.put("Chicken Karahi", 350);
        foodCalorieMap.put("Chicken Jalfrezi", 250);
        foodCalorieMap.put("Mutton Korma", 350);
        foodCalorieMap.put("Vegetable Korma", 200);
        foodCalorieMap.put("Chicken Biryani (Hyderabadi)", 290);
        foodCalorieMap.put("Mutton Biryani (Sindhi)", 320);
        foodCalorieMap.put("Chicken Malai Boti", 250);
        foodCalorieMap.put("Vegetable Nihari", 250);
        foodCalorieMap.put("Chicken Biryani (Khyber Pakhtunkhwa)", 280);
        foodCalorieMap.put("Mutton Nihari (Sindhi)", 400);
        foodCalorieMap.put("Chicken Seekh Kebab (Sindhi)", 250);
        foodCalorieMap.put("Vegetable Samosa (Sindhi)", 300);
        foodCalorieMap.put("Chicken Karahi (Sindhi)", 350);
        foodCalorieMap.put("Mutton Pulao (Khyber Pakhtunkhwa)", 300);
        foodCalorieMap.put("Chicken Jalfrezi (Sindhi)", 250);
    }

    private void fetchCalories(final String foodItem) {

        if (foodCalorieMap.containsKey(foodItem)) {
            int calories = foodCalorieMap.get(foodItem);
            addFoodItem(foodItem, calories);
        } else {
            Toast.makeText(dataActivity.this, "No calorie info found for this food", Toast.LENGTH_SHORT).show();
        }
    }

    private void addFoodItem(String foodItem, int calories) {
        foodItems.add(foodItem);
        foodCalories.add(calories);
        updateTotalCalories();
        updateDisplay();
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
            caloriesDisplay.append(foodCalories.get(i )).append("\n");
        }

        ((TextView) findViewById(R.id.textView14)).setText(itemsDisplay.toString());
        ((TextView) findViewById(R.id.textView15)).setText(caloriesDisplay.toString());
    }
}