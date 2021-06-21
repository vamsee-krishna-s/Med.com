package com.Vamsee.medcom;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.Vamsee.medcom.databinding.ActivityContriBinding;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

public class contri_Activity extends AppCompatActivity {
    private static final String[] res = new String[]{
            "Remdesivir, Favipiravir, Fabiflu, Tocilizumab","equipment /Blood/Plasma etc","dignostics, ct scan,Doctors"
    };

    TextInputLayout details,  StateCity, address_id_ed_1, mob_id_ed, Name_id_ed, resourceName;
    Button bnt_for_creation;
    FirebaseFirestore fbfs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contri);

        fbfs=FirebaseFirestore.getInstance();

        AutoCompleteTextView dropperOR= findViewById(R.id.dropperOR);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, res);
        dropperOR.setAdapter(adapter);

        resourceName = findViewById(R.id.resourceName);
        mob_id_ed = findViewById(R.id.mob_id_ed);
        Name_id_ed = findViewById(R.id.Name_id_ed);
        StateCity = findViewById(R.id.StateCity);
        address_id_ed_1 = findViewById(R.id.address_id_ed_1);
        details = findViewById(R.id.details);

        bnt_for_creation = findViewById(R.id.bnt_for_creation);
        bnt_for_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbfs=FirebaseFirestore.getInstance();


                String Resource = dropperOR.getText().toString();
                String mobile = mob_id_ed.getEditText().getText().toString();
                String Name = Name_id_ed.getEditText().getText().toString();
                String Address = address_id_ed_1.getEditText().getText().toString();
                String City = StateCity.getEditText().getText().toString();
                String Details = details.getEditText().getText().toString();
                Map<String,Object>user= new HashMap<>();
                user.put("Resource", Resource );
                user.put("Mobile",mobile);
                user.put("Name",Name);
                user.put("Address",Address);
                user.put("City",City);
                user.put("Details",Details);


                switch (Resource){

                    case "Remdesivir, Favipiravir, Fabiflu, Tocilizumab":
                        int i=0;
                        i++;
                        fbfs.collection("Medicine_Collection")
                                .add(user)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        openMain();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                                openMain();
                            }
                        });
                        break;

                    case "equipment /Blood/Plasma etc":
                        fbfs.collection("Equipment_Collection")
                                .add(user)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        openMain();
                                        Snackbar.make(resourceName, R.string.app_info,Snackbar.LENGTH_LONG)
                                                .show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                                openMain();
                                Snackbar.make(resourceName, R.string.app_info,Snackbar.LENGTH_LONG)
                                        .show();
                            }
                        });
                        break;

                    case "dignostics, ct scan,Doctors":
                        fbfs.collection("Service_Collection")
                                .add(user)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        openMain();
                                        Snackbar.make(resourceName, R.string.app_info,Snackbar.LENGTH_LONG)
                                                .show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                                openMain();
                                Snackbar.make(resourceName, R.string.app_info,Snackbar.LENGTH_LONG)
                                        .show();
                            }
                        });
                        break;

                }
            }
        });
    }

    private void openMain() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

