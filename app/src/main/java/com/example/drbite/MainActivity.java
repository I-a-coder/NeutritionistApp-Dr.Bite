package com.example.drbite;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewWelcome, textViewDr, textViewBite, textViewTrack, textViewConsult, textViewAccount, textViewSignIn;
    private ImageButton startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        textViewWelcome = findViewById(R.id.textView);
        textViewDr = findViewById(R.id.textView3);
        textViewBite = findViewById(R.id.textView8);
        textViewTrack = findViewById(R.id.textView9);
        textViewConsult = findViewById(R.id.textView10);
        textViewAccount = findViewById(R.id.textView11);
        textViewSignIn = findViewById(R.id.signintext);
        startButton = findViewById(R.id.start);

        // Handle start button click
        startButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        });

        // Handle sign in click
        textViewSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        });
    }
}
