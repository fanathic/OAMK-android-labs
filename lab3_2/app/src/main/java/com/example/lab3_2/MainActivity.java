package com.example.lab3_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button openMap = findViewById(R.id.button_open_map);
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=Oamk,+Kotkantie,+Oulu");
        // Or map point based on latitude/longitude
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        final Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        final Button call = findViewById(R.id.button_create_call);
        Uri number = Uri.parse("tel:+358206110200");
        final Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        final Button goWebsite = findViewById(R.id.button_go);
        final EditText webAddress = findViewById(R.id.editText_website_address);

        openMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(mapIntent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(callIntent);
            }
        });

         goWebsite.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v) {
                 Uri webpage = Uri.parse(webAddress.getText().toString());
                 Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                 startActivity(webIntent);
             }
         });

    }
}
