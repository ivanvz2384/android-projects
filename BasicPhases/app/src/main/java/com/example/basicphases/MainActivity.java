package com.example.basicphases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String myPackage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPackage = getApplicationContext().getPackageName();
        Log.i("INFO", "My package is " +  myPackage);
    }

    public void buttonTapped(View view) {
        int id = view.getId();
        String ourId = view.getResources().getResourceEntryName(id);
        Log.i("button tapped", ourId);
        int resourceId = getResources().getIdentifier(ourId, "raw", myPackage);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, resourceId);
        mediaPlayer.start();
    }
}
