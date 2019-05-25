package com.kpi.lab3;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileRead extends FragmentActivity {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        ButtonFragment buttonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.FileButtonFragment);
        Switch aSwitch = (Switch) findViewById(R.id.SwitchFile);
        TextView textView = (TextView) findViewById(R.id.FileView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        buttonFragment.setTextOn_LeftButton("Open");

        buttonFragment.setTextOn_RightButton("Clear");

        buttonFragment.setActionOn_LeftButton((view) -> {


            textView.setText(FileWorker.ReadFile(FileRead.this));

        });

        buttonFragment.setActionOn_RightButton((view) -> {
            if (aSwitch.isChecked()) {
                FileWorker.deleteFile();
            }
            textView.setText("");
        });

    }


}
