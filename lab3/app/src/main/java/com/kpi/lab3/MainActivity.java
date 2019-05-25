package com.kpi.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private static int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonFragment buttonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.ButtonL);
        TxtFragment txtFragment = (TxtFragment) getSupportFragmentManager().findFragmentById(R.id.textL);
        RadiogrupFragment radiogrupFragment = (RadiogrupFragment) getSupportFragmentManager().findFragmentById(R.id.radioGrupL);


        buttonFragment.setActionOn_LeftButton((View) -> {
            DateFormat dateFormat =
                    DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            Date currentTime = Calendar.getInstance().getTime();

            String color = radiogrupFragment.getColor();

            txtFragment.changeColor(Color.parseColor(color));

            FileWorker.saveToFile(
                    String.format("%s : %s - %s",
                            color,
                            txtFragment.getText(),
                            dateFormat.format(currentTime)));


        });

        buttonFragment.setActionOn_RightButton((View) -> {
            txtFragment.toDefault();
            radiogrupFragment.toDefault();
        });

        Button file = findViewById(R.id.file_button);
        file.setOnClickListener((View) -> {

            Intent i = new Intent(MainActivity.this, FileRead.class);
            startActivity(i);
        });
    }


}

