package com.example.artti.oodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.artti.oodemo.henkilot.Henkilo;
import com.example.artti.oodemo.henkilot.Pelaaja;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.nappi).setOnClickListener(this);
        findViewById(R.id.nappi_2).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        int viewId = v.getId();

        if(viewId == R.id.nappi) {

            Henkilo ope = new Henkilo();
            ope.setNimi("Seppo Taalasmaa");
            ope.setHloTunnus("232345-2323");

            Pelaaja ismo = new Pelaaja();
            ismo.setNimi("Ismo Laitela");
            ismo.setPeliNumero(34);

            Toast.makeText(this, "Pelaajan nimi on " + ismo.getNimi(), Toast.LENGTH_LONG).show();
        }

        else if (viewId == R.id.nappi_2) {
            findViewById(R.id.nappi).setEnabled(false);
            Toast.makeText(this, "Nappia 2 painettu", Toast.LENGTH_LONG).show();
        }

    }


}
