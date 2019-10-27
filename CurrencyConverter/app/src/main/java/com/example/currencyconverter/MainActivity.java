package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

    public void convertCurrency(View view) {
        Log.i("Info", "Converting...");
        EditText convertCurrency = findViewById(R.id.numberEditText);

        if (convertCurrency != null && convertCurrency.getText() != null) {
            Double dollarAmountDouble = Double.parseDouble(convertCurrency.getText().toString());
            Double pountAmount = dollarAmountDouble * 0.75;

            Toast.makeText(MainActivity.this, String.format("%.2f", pountAmount), Toast.LENGTH_SHORT).show();

            Log.i("Amount", convertCurrency.getText().toString());
        } else {
            Toast.makeText(MainActivity.this, "You must input a value", Toast.LENGTH_SHORT).show();
        }

    }



}
