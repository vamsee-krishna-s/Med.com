package com.Vamsee.medcom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Service extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Medicine_Collection> medicineArraylist;
    MyAdapter myAdapter;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        recyclerView = findViewById(R.id.recyclerView101);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        db = FirebaseFirestore.getInstance();
        medicineArraylist = new ArrayList<Medicine_Collection>();
        myAdapter = new MyAdapter(Service.this,medicineArraylist);

        recyclerView.setAdapter(myAdapter);


        EventChangeListener();

    }
    private void EventChangeListener() {


        db.collection("Service_Collection")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable @org.jetbrains.annotations.Nullable QuerySnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                        if(error!= null){
                            Log.e("Firestore ERROR", "onEvent: ");
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){
                                medicineArraylist.add(dc.getDocument().toObject(Medicine_Collection.class));
                            }

                            myAdapter.notifyDataSetChanged();


                        }

                    }
                });
    }

}