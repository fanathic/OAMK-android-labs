package com.example.lab4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lab4.model.WorkOutPartBase;
import com.example.lab4.model.WorkoutPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private WorkOutPartAdapter workOutPartAdapter;
    private TextView workOutLengthTextView;
    private ArrayList<WorkOutPartBase> workoutList = new ArrayList<>();
    private WorkOutPartBase workoutToAdd;
    private Button startWorkOutButton;
    private Intent intentWorkoutGUI;
    private String filename;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        workOutLengthTextView = (TextView) findViewById(R.id.textView_total_length);
        listView = (ListView) findViewById(R.id.workout_list);
        startWorkOutButton = (Button) findViewById(R.id.button_start_workout);
        intentWorkoutGUI = new Intent(this, WorkoutGUIActivity.class);
        filename = "workouts";

        loadWorkOutListFromFile();

        int workOutLength = 0;
        for (WorkOutPartBase part:workoutList
             ) {
            if (part != null) {
                workOutLength += part.getLength();

            }
        }
        workOutLengthTextView.setText("Total length: " + workOutLength/60 +" minutes " + workOutLength%60 +" seconds");
        workOutPartAdapter = new WorkOutPartAdapter(this, workoutList);
        listView.setAdapter(workOutPartAdapter);

        startWorkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentWorkoutGUI.putExtra("workoutList", workoutList);
                startActivity(intentWorkoutGUI);
            }
        });



    }

    @Override
    protected void onStop (){
        super.onStop();
        saveWorkOutListToFile();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_new) {
            addNewPart();
        }

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_clear) {
            askForConfirmationAndClear();
        }

        return super.onOptionsItemSelected(item);
    }

    public void addNewPart() {
        Intent intent =new Intent(this, AddNewPartActivity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // get workout data from Intent
                WorkOutPartBase returnWorkOut = (WorkOutPartBase) data.getSerializableExtra("serialize_data");
                workoutList.add(returnWorkOut);
                int workOutLength = 0;
                for (WorkOutPartBase part:workoutList
                ) {
                    if (part != null) {
                        workOutLength += part.getLength();

                    }
                }
                workOutLengthTextView.setText("Total length: " + workOutLength/60 +" minutes " + workOutLength%60 +" seconds");
                workOutPartAdapter = new WorkOutPartAdapter(this, workoutList);
                listView.setAdapter(workOutPartAdapter);


            }
        }
    }

    private void askForConfirmationAndClear() {
        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                workoutList.clear();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });



        builder.setMessage("Do you really want to clear workouts?")
                .setTitle("Clear workouts");

        AlertDialog dialog = builder.create();

        dialog.show();
        workOutPartAdapter = new WorkOutPartAdapter(this, workoutList);
        listView.setAdapter(workOutPartAdapter);
        int workOutLength = 0;
        workOutLengthTextView.setText("Total length: " + workOutLength/60 +" minutes " + workOutLength%60 +" seconds");

    }

    private void saveWorkOutListToFile() {

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(workoutList);
            objectOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadWorkOutListFromFile() {

        try {
            FileInputStream fis = this.openFileInput(filename);
            ObjectInputStream is = new ObjectInputStream(fis);
            workoutList = (ArrayList<WorkOutPartBase>) is.readObject();
            is.close();
            fis.close();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }


}
