package com.kpi.lab2;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;

import lombok.Getter;

public class RadiogrupFragment extends Fragment {

    private final static int _DEFAULT = 0;
    public static final String _BLACK   = "#FF000000";
    public static final String _DKGRAY  = "#FF444444";
    public static final String _GRAY    = "#FF888888";
    public static final String _LTGRAY  = "#FFCCCCCC";
    public static final String _WHITE   = "#FFFFFFFF";
    public static final String _RED     = "#FFFF0000";
    public static final String _GREEN   = "#FF00FF00";
    public static final String _BLUE    = "#FF0000FF";
    public static final String _YELLOW  = "#FFFFFF00";
    public static final String _CYAN    = "#FF00FFFF";
    public static final String _MAGENTA = "#FFFF00FF";
    public static final String _TRANSPARENT = "0";

    @Getter
    private RadioGroup group;

    private HashMap<RadioButton, String> radioSet = new HashMap<>();

    private void fillSet() {
        radioSet.put((RadioButton) group.getChildAt(0), _BLUE);
        radioSet.put((RadioButton) group.getChildAt(1), _RED);
        radioSet.put((RadioButton) group.getChildAt(2), _GREEN);
        radioSet.put((RadioButton) group.getChildAt(3), _BLACK);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.radiogruop_layout, container, false);
        group = view.findViewById(R.id.radio);
        fillSet();

        return view;
    }

    public void toDefault() {
        RadioButton defaultButton = (RadioButton) group.getChildAt(_DEFAULT);
        defaultButton.setChecked(true);
    }

    public int checkBox() {
        return group.getCheckedRadioButtonId();
    }



    public String getColor() {
        RadioButton chosen = getView().findViewById(checkBox());
        String color = null;
            color = radioSet.get(chosen);
        if (color == null ) {
            color=_BLACK;
        }
        return color;

    }


}
