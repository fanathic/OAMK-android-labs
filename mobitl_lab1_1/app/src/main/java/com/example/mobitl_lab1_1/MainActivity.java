package com.example.mobitl_lab1_1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private TextView currentLocation;
    private Geocoder geocoder;
    private Address address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button_update_location);
        geocoder = new Geocoder(this, Locale.US);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDeviceLocationText();
            }
        });
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        currentLocation = (TextView) findViewById(R.id.textbox_location);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_FINE_LOCATION);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    updateDeviceLocationText();
                }
            }
        }
    }

    public void updateDeviceLocationText() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {


                                try {
                                    address = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0);
                                } catch (Exception ex)
                                {

                                }
                                currentLocation.setText(location.getLatitude() + ", " + location.getLongitude() + "\n" +
                                                address.getLocality() + ", " + address.getCountryName());
                            }
                        }
                    });
        }
    }
}
