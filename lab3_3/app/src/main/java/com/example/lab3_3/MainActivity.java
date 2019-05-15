package com.example.lab3_3;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    String creatureType = "Mammals";
    MediaPlayer mediaPlayerBear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.imageView);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        iv4 = findViewById(R.id.imageView4);
        mediaPlayerBear = MediaPlayer.create(this, R.raw.bear);
        final MediaPlayer mediaPlayerHuuhkaja = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(creatureType == "Mammals")
                {
                    mediaPlayerBear.start();
                }
                else{
                    mediaPlayerHuuhkaja.start();
                }
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.zoo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mammals:
                iv1.setImageResource(R.drawable.bear);
                iv2.setImageResource(R.drawable.wolf);
                iv3.setImageResource(R.drawable.elephant);
                iv4.setImageResource(R.drawable.lamb);
                creatureType = "Mammals";
                return true;
            case R.id.birds:
                iv1.setImageResource(R.drawable.huuhkaja);
                iv2.setImageResource(R.drawable.peippo);
                iv3.setImageResource(R.drawable.peukaloinen);
                iv4.setImageResource(R.drawable.punatulkku);
                creatureType = "Birds";
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
