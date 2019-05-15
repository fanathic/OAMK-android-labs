package com.example.lab2_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText = (EditText) findViewById(R.id.name_textedit);
        Button sverigeButton = (Button) findViewById(R.id.sverige_button);
        Button englishButton = findViewById(R.id.english_button);
        Button suomeksiButton = findViewById(R.id.suomeksi_button);
        Button surpriseButton = findViewById(R.id.surprise_button);
        final TextView greetingsText = (TextView) findViewById(R.id.greetings_textView);

        sverigeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingsText.setText("Hejssan " + nameText.getText().toString());
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingsText.setText("Hi " + nameText.getText().toString());
            }
        });

        suomeksiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingsText.setText("Terve " + nameText.getText().toString());
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingsText.setText("Hola " + nameText.getText().toString());
            }
        });

    }
}
