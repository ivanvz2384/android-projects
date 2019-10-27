package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.laugh);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeSeekBar = findViewById(R.id.volumeSeekBar);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setProgress(currentVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("INFO", "Progress is " +  progress);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("INFO", "onStartTrackingTouch");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("INFO", "onStopTrackingTouch");
            }
        });

        final SeekBar audioSeekBar = findViewById(R.id.audioSeekBar);
        audioSeekBar.setMax(mediaPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                audioSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 100);

        audioSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("INFO", "Progress is " +  progress);
                mediaPlayer.seekTo(progress);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("INFO", "onStartTrackingTouch");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("INFO", "onStopTrackingTouch");
            }
        });

    }

    public void playSound(View view) {
        mediaPlayer.start();
    }

    public void pauseSound(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }


}
