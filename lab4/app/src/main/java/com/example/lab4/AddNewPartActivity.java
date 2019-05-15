package com.example.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lab4.model.PausePart;
import com.example.lab4.model.WorkOutPartBase;
import com.example.lab4.model.WorkoutPart;

public class AddNewPartActivity extends AppCompatActivity {


    private String workOutType = "Workout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_part);
        Button addButton = (Button) findViewById(R.id.button_add_part);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText lengthText = (EditText) findViewById(R.id.editText_length_of_part);
                int length = Integer.parseInt(lengthText.getText().toString());


                if(workOutType == "Workout"){
                    WorkoutPart part = new WorkoutPart(length);
                    Intent intent = new Intent();
                    intent.putExtra("serialize_data", part);
                    setResult(RESULT_OK, intent);
                    finish();
                } else if (workOutType == "Pause") {
                    PausePart part = new PausePart(length);
                    Intent intent = new Intent();
                    intent.putExtra("serialize_data", part);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_work_out:
                if (checked)
                    workOutType = "Workout";
                    break;
            case R.id.radioButton_pause:
                if (checked)
                    workOutType = "Pause";
                    break;
        }
    }


}
