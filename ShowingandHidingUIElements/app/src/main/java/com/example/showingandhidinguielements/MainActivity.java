package com.example.showingandhidinguielements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTextView = findViewById(R.id.helloTextView);

    }

    public void show(View view) {
        helloTextView.setVisibility(View.VISIBLE);
    }

    public void hide(View view) {
        helloTextView.setVisibility(View.INVISIBLE);
    }
}
