package com.kpi.lab1;

import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radio = findViewById(R.id.radio);
        View button = findViewById(R.id.change);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                checkBox();
            }
        });

        button = findViewById(R.id.cancel);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                cancel();
            }
        });

    }


    public void changeColor(EditText txt, int color, String str) {

        txt.setTextColor(color);

        if (str != null) {
            txt.setText(str);

        }


    }

    public void checkBox() {

        RadioGroup radio = findViewById(R.id.radio);
        EditText text = findViewById(R.id.plain_text_input);

        if (radio.getCheckedRadioButtonId() != -1) {
            int checkedRadioButtonId = radio.getCheckedRadioButtonId();

            switch (checkedRadioButtonId) {
                case R.id.radioButton: {
                    changeColor(text, Color.BLUE, null);
                    break;

                }

                case R.id.radioButton2: {
                    changeColor(text, Color.RED, null);
                    break;

                }
                case R.id.radioButton3: {
                    changeColor(text, Color.GREEN, null);
                    break;

                }
                case R.id.radioButton4: {
                    changeColor(text, Color.BLACK, null);
                    break;

                }

            }
        }


    }


    public void cancel() {
        EditText text = findViewById(R.id.plain_text_input);
        text.setText("");
        RadioButton r=findViewById(R.id.radioButton4);
        r.setChecked(true);


    }
}
