package com.example.lab2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {





    private Button addBtn = null;
    private Button editBtn = null;
    private Button rmvBtn = null;
    private EditText textEditor = null;
    private ListView countryList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LinearLayout mainLayOut = new LinearLayout(this);
        LinearLayout btnLayOut = new LinearLayout(this);

        textEditor = new EditText(this);
        addBtn = new Button(this);
        editBtn = new Button(this);
        rmvBtn = new Button(this);
        countryList = new ListView(this);

        final String[] COUNTRIES = new String[] {
                "Afghanistan", "Albania", "Angola", "Finland", "Germany", "Norway", "Sweden"
        };
        final ArrayList<String> countries = new ArrayList<String>(Arrays.asList(COUNTRIES));
        final ArrayAdapter<String> aa;

        mainLayOut.setOrientation(LinearLayout.VERTICAL);

        btnLayOut.setOrientation(LinearLayout.HORIZONTAL);
        btnLayOut.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnLayOut.setGravity(Gravity.CENTER);


        addBtn.setText("Add");
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countries.add(textEditor.getText().toString());
                textEditor.setText("");
            }
        });

        editBtn.setText("Edit");

        rmvBtn.setText("Remove");
        rmvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countries.remove(textEditor.getText().toString());
            }
        });



        btnLayOut.addView(addBtn);
        btnLayOut.addView(editBtn);
        btnLayOut.addView(rmvBtn);

        mainLayOut.addView(btnLayOut);
        mainLayOut.addView(textEditor);
        mainLayOut.addView(countryList);

        setContentView(mainLayOut);


        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        countryList.setAdapter(aa);


    }


}
