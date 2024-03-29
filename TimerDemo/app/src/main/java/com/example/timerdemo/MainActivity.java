package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                //Counter is counting down (every second)
                Log.i("Seconds left", String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                //Counter is finished! (after 10 seconds)
                Log.i("Done", "Counter Timer Finished");
            }
        }.start();

        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

                //Insert code to be run every second

                Log.i("Runnable has run", "a second must have passed");
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);
        */
    }
}
