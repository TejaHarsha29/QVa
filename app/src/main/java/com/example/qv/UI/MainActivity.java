package com.example.qv.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qv.DialogExample;
import com.example.qv.Model.Movies;
import com.example.qv.Adapter.OfflineDataActivity;
import com.example.qv.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements DialogExample.ExampleDialogListener {


    Button addDetails,show,showOnline;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("movies");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDetails = findViewById(R.id.add);
        show = findViewById(R.id.show);
        showOnline = findViewById(R.id.online);


        showOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirebaseDataActivity.class);
                startActivity(intent);
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OfflineDataActivity.class);
                startActivity(intent);
            }
        });


        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });



    }

    private void openDialog() {

        DialogExample dialogExample = new DialogExample();
        dialogExample.show(getSupportFragmentManager(),"example dialog");





    }

    @Override
    public void applyText(String name, String des, String rating) {

        Movies movie = new Movies(name,des,rating);

        reference.push().setValue(movie);


    }
}