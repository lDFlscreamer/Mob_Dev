package com.kpi.lab2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private static int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonFragment buttonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.ButtonL);
        TxtFragment txtFragment = (TxtFragment)getSupportFragmentManager().findFragmentById(R.id.textL);
        RadiogrupFragment radiogrupFragment=(RadiogrupFragment)getSupportFragmentManager().findFragmentById(R.id.radioGrupL);


        buttonFragment.setActionOn_OkButton((View) -> {
            txtFragment.changeColor(Color.parseColor(radiogrupFragment.getColor()));


        });

        buttonFragment.setActionOn_CancelButton((View) -> {
            txtFragment.toDefault();
            radiogrupFragment.toDefault();
        });
    }





}

