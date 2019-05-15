package com.example.lab3_4;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class TimerCountdownActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_countdown);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int time = Integer.parseInt(message);
        final TextView textViewTimeLeft = findViewById(R.id.textView_TimeLeft);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.bear);

        new CountDownTimer(time * 1000, 1000){
            public void onTick(long millisUntilFinished) {
                textViewTimeLeft.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mediaPlayer.start();
                while (mediaPlayer.isPlaying());
                //mediaPlayer.release();
                finish();
            }

        }.start();

    }


