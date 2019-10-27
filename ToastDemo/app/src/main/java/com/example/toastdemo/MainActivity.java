package com.example.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doEnterName(View view) {
        Log.i("Info", "Do enter name executed");
        EditText nameEditText = findViewById(R.id.nameEditText);

        Toast.makeText(MainActivity.this, "Hi there, " + nameEditText.getText().toString(), Toast.LENGTH_LONG).show();

    }
}
