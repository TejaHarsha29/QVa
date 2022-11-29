package com.example.qv.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.qv.Model.Movies;
import com.example.qv.MoviesAdapter;
import com.example.qv.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("movies");

    private ArrayList<Movies> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_data);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);





        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();




        MoviesAdapter adapter = new MoviesAdapter(this,list);
        recyclerView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    Movies movies=snapshot1.getValue(Movies.class);
                    list.add(movies);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}