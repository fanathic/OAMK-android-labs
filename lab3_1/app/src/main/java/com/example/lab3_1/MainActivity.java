package com.example.lab3_1;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.color_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConstraintLayout backgroundLayout = (ConstraintLayout) findViewById(R.id.background);
        TextView textView = (TextView) findViewById(R.id.colorText);
        switch (item.getItemId()) {
            case R.id.red:
                backgroundLayout.setBackgroundColor(Color.RED);
                textView.setText("Red");
                return true;
            case R.id.green:
                backgroundLayout.setBackgroundColor(Color.GREEN);
                textView.setText("Green");
                return true;
            case R.id.blue:
                backgroundLayout.setBackgroundColor(Color.BLUE);
                textView.setText("Blue");
                return true;
            case R.id.yellow:
                backgroundLayout.setBackgroundColor(Color.YELLOW);
                textView.setText("Yellow");
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
