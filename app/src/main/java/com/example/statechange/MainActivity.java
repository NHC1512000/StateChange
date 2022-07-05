package com.example.statechange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Activity Main";
    private MediaPlayer mediaPlayer ;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this,R.raw.ok);

        Log.d("Activity main",": On create");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity main",": On start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity main",": On restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        Log.d("Activity main",": On resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity main",": On create");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity main",": On create");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
        Log.d("Activity main",": On create");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Activity main","Save instance state");
        outState.putInt("position", mediaPlayer.getCurrentPosition());
        Log.d("Activity main", "save instance state: "+ mediaPlayer.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Activity main" ,"restore instance state");
        position= savedInstanceState.getInt("position");
        mediaPlayer.seekTo(position);

    }
}