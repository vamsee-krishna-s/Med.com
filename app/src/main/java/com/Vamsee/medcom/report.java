package com.Vamsee.medcom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class report extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference ref;

    EditText PersonName, Multilin;
    TextView Pone;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        PersonName = findViewById(R.id.PersonName);
        Multilin = findViewById(R.id.MultiLine);
        Pone = findViewById(R.id.Numb);
        Save = (Button) findViewById(R.id.SaveBtn);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = FirebaseDatabase.getInstance();
                ref = db.getReference("COMPLAIN");

                String PName = PersonName.getText().toString();
                String Multiline = Multilin.getText().toString();
                String Phone = Pone.getText().toString();

                Medicine_Collection med = new Medicine_Collection(PName, Multiline, Phone);
                ref.child(PName).setValue(med);

            }
        });
        
    }
}