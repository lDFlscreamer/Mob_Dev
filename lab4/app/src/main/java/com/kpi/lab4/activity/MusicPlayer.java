package com.kpi.lab4.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.kpi.lab4.R;
import com.kpi.lab4.fragment.ButtonFragment;

public class MusicPlayer extends FragmentActivity {

    private ButtonFragment videoControl;
    private MediaPlayer mediaPlayer;
    private boolean isPaused;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        videoControl = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.MusicButtonFragment);

        mediaPlayer = MediaPlayer.create(this, R.raw.we);

        mediaPlayer.start();


        videoControl.setTextOn_LeftButton("start");
        videoControl.setActionOn_LeftButton(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });
        videoControl.setTextOn_RightButton("Pause/Resume");
        videoControl.setActionOn_RightButton(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPaused) {
                    mediaPlayer.pause();
                    isPaused = true;
                } else {
                    mediaPlayer.start();
                    isPaused = false;
                }
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
