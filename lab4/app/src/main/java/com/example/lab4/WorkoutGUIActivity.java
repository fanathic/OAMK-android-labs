package com.example.lab4;

import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4.model.WorkOutPartBase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class WorkoutGUIActivity extends AppCompatActivity {

    private ArrayList<WorkOutPartBase> workoutList = new ArrayList<>();
    private TextView textViewTimeLeft;
    private TextView textViewWorkOutType;
    private int currentPosition;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_gui);
        textViewTimeLeft = (TextView) findViewById(R.id.textView_workout_time_left);
        textViewWorkOutType = (TextView) findViewById(R.id.textView_gui_workout_type);
        workoutList = (ArrayList<WorkOutPartBase>) getIntent().getSerializableExtra("workoutList");
        currentPosition = 0;



        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                    if(workoutList.size() != 0) {
                        StartTImer(currentPosition);
                    }
                }
            }
        });

        tts.speak("Workout done, good job", TextToSpeech.QUEUE_FLUSH, null);



        /*
        for (WorkOutPartBase workout : workoutList) {
            if (workout == null) break;
            textViewWorkOutType.setText(workout.getType());
            new CountDownTimer(workout.getLength() * 1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    textViewTimeLeft.setText("" + millisUntilFinished / 1000);

                }

                public void onFinish() {

                }
            }.start();
        }
        */



    }

    private void StartTImer(final int position) {
        WorkOutPartBase workout = workoutList.get(position);
        if (workout == null) return;
        textViewWorkOutType.setText(workout.getType());
        tts.speak(workout.getType(), TextToSpeech.QUEUE_FLUSH, null);
        new CountDownTimer(workout.getLength() * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewTimeLeft.setText("" + millisUntilFinished / 1000);

            }

            public void onFinish() {
                if(position < workoutList.size() - 1) {
                    currentPosition++;
                    StartTImer(currentPosition);
                }
            }
        }.start();

    }
}


