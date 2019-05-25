package com.kpi.lab4;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.VideoView;

import com.kpi.lab4.activity.MusicPlayer;
import com.kpi.lab4.activity.VideoPlayer;
import com.kpi.lab4.fragment.ButtonFragment;

import lombok.Getter;


public class MainActivity extends AppCompatActivity {

    @Getter
    private VideoView mVideoView2;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       mediaPlayer = MediaPlayer.create(this, R.raw.soundw);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer.start();
        setTitle("Choose your destiny");
        ButtonFragment buttonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.FileButtonFragment);

        buttonFragment.setTextOn_LeftButton("Music player");

        buttonFragment.setTextOn_RightButton("Video Player");

        buttonFragment.setActionOn_RightButton((View) -> {

            Intent i = new Intent(MainActivity.this, VideoPlayer.class);
            startActivity(i);
        });

        buttonFragment.setActionOn_LeftButton((View) -> {

            Intent i = new Intent(MainActivity.this, MusicPlayer.class);
            startActivity(i);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer = MediaPlayer.create(this, R.raw.soundw);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();

    }
}
