package com.RNG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // just want to run the button animation on initial startup, not every startup
    private static boolean firstAnimationComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (firstAnimationComplete != false) return;

        firstAnimationComplete = true;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        Button wheelButton = findViewById(R.id.wheel);
        wheelButton.setX(screenWidth);
        wheelButton.animate().x(30);

        Button diceButton = findViewById(R.id.dice);
        diceButton.setX(-screenWidth - 20);
        diceButton.animate().x(30);

        Button randomNumberButton = findViewById(R.id.random_number);
        randomNumberButton.setX(screenWidth);
        randomNumberButton.animate().x(30);

        Button randomPasswordButton = findViewById(R.id.random_password);
        randomPasswordButton.setX(-screenWidth - 20);
        randomPasswordButton.animate().x(30);
    }

    public void wheelOfRNG_OnClick(View view) {
        Intent intent = new Intent(this, WheelOfRNGActivity.class);
        startActivity(intent);
    }

    public void dice_OnClick(View view) {
        Intent intent = new Intent(this, DiceActivity.class);
        startActivity(intent);
    }

    public void randomNumber_OnClick(View view) {
        Intent intent = new Intent(this, RandomNumberActivity.class);
        startActivity(intent);
    }

    public void randomPassword_OnClick(View view) {
        Intent intent = new Intent(this, RandomPasswordActivity.class);
        startActivity(intent);
    }
}
