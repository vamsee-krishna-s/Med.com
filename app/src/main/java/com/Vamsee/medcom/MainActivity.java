package com.Vamsee.medcom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button contri;
    private Button medi;
    private Button equi;
    private Button servi;
    private TextView URLdat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLdat = findViewById(R.id.URLdet);
        URLdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.who.int/emergencies/diseases/novel-coronavirus-2019");
            }
        });


        contri = (Button) findViewById(R.id.contri);
                contri.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openConti();

                    }
                });
        medi = (Button) findViewById(R.id.Medi);
             medi.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     openmedi();
                 }
             });
        equi = (Button) findViewById(R.id.Equi);
             equi.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     openequi();
                 }
             });
        servi = (Button) findViewById(R.id.servi);
             servi.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     openservi();
                 }
             });
    }

    private void gotoURL(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    private void openservi() {
        Intent intent= new Intent(this, Service.class);
        startActivity(intent);
    }

    private void openequi() {
        Intent intent= new Intent(this, equipment.class);
        startActivity(intent);
    }

    private void openmedi() {
        Intent intent= new Intent(this, Medicine.class);
        startActivity(intent);
    }


    private void openConti() {
        Intent intent= new Intent(this, contri_Activity.class);
        startActivity(intent);
    }
}