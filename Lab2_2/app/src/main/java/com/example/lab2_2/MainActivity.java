package com.example.lab2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final Button gameButton = new Button(this);
        gameButton.setText("Hello, press this button");



        setContentView(gameButton);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                gameButton.setText("You have clicked the button " + counter + " times");

            }
        });
    }
}
