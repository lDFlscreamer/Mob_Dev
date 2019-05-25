package com.kpi.lab4.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.kpi.lab4.R;
import com.kpi.lab4.fragment.ButtonFragment;
import com.kpi.lab4.fragment.TxtFragment;
import com.kpi.lab4.fragment.VideoFragment;

public class VideoPlayer extends FragmentActivity {

    private ButtonFragment videoControl;
    private ButtonFragment urlControl;
    private VideoFragment videowindow;
    private TxtFragment txtFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoControl = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.VideoButtonFragment);
        urlControl = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.VideoUrlButtonFragment);
        videowindow = (VideoFragment) getSupportFragmentManager().findFragmentById(R.id.VideoFragment);
        txtFragment = (TxtFragment) getSupportFragmentManager().findFragmentById(R.id.textL);
        Switch aSwitch = findViewById(R.id.switch1);


        String uriPath = "https://www.demonuts.com/Demonuts/smallvideo.mp4";
        videowindow.setUri(uriPath);

        videoControl.setTextOn_LeftButton("stop");
        videoControl.setActionOn_LeftButton(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                videowindow.changeMediacontroler(aSwitch.isChecked());
                videowindow.stop();
            }
        });

        videoControl.setTextOn_RightButton("play/Pause");
        videoControl.setActionOn_RightButton(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                videowindow.changeMediacontroler(aSwitch.isChecked());
                videowindow.pause();
            }
        });


        urlControl.setTextOn_RightButton("clear");
        urlControl.setTextOn_LeftButton("set URL");
        urlControl.setActionOn_RightButton((View view) -> {
            txtFragment.toDefault();
            videowindow.setUri(uriPath);
        });
        urlControl.setActionOn_LeftButton((View view) -> {
            String inputed = txtFragment.getText();
            if (inputed == null || inputed.isEmpty()) {
                Toast.makeText(this, "Uri is Empty",
                        Toast.LENGTH_LONG).show();
                return;
            }
            videowindow.setUri(inputed);
        });


    }

    public void localeStorage(View view) {
        int readExternalStoragePermission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            String requirePermission[] = {Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, requirePermission, 2);
        } else {
            selectVideoFile();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                videowindow.setUri(data.getData().toString());
            }
        }
    }

    private void selectVideoFile() {
        Intent selectVideoIntent = new Intent(Intent.ACTION_GET_CONTENT);
        selectVideoIntent.setType("video/*");
        startActivityForResult(selectVideoIntent, 1);
    }


    @Override
    protected void onPause() {
        super.onPause();
        videowindow.pause();
    }
}
