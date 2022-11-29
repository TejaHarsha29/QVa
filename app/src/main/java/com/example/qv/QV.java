package com.example.qv;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class QV extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
