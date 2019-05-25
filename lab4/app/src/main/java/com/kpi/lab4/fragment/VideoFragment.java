package com.kpi.lab4.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.kpi.lab4.R;

import lombok.Getter;

public class VideoFragment extends Fragment {

    @Getter
    private VideoView player;

    private MediaController mediacontroller;
    private boolean isPaused = true;
    private Uri url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment_layout, container, false);
        player = view.findViewById(R.id.videoView1);
        mediacontroller = new MediaController(getContext());
        mediacontroller.setAnchorView(player);
        return view;
    }


    public void setUri(String uri) {


        this.url = Uri.parse(uri);


        player.setVideoURI(url);
    }

    public void changeMediacontroler(boolean use) {

        if (use) {
            player.setMediaController(mediacontroller);
        } else {
            player.setMediaController(null);
        }

    }


    public void start() {
        player.requestFocus();
        player.setVideoURI(url);

        player.start();

    }

    public void stop() {
        player.stopPlayback();
        player.resume();
    }

    public void pause() {

        if (!isPaused) {
            player.pause();
            isPaused = true;
        } else {
            player.requestFocus();
            player.start();
            isPaused = false;
        }

    }


}
