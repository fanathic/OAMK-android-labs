package com.example.lab3_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "testi";
    EditText editText_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText_time = findViewById(R.id.editText_time);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTimer(View view) {
        Intent intent = new Intent(this, TimerCountdownActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText_time);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
