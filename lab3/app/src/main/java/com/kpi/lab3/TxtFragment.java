package com.kpi.lab3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import lombok.Getter;


public class TxtFragment extends Fragment {


    private EditText text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.txt_layout, container, false);
        text=view.findViewById(R.id.plain_text_input);
        return view;
    }

    public void toDefault() {
       text.setText("");
    }

    public void changeColor(int color){

        text.setTextColor(color);

    }

    public String getText(){
        return text.getText().toString();
    }

}
