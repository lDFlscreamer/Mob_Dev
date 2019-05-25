package com.kpi.lab4.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kpi.lab4.R;

import lombok.Getter;

public class ButtonFragment extends Fragment {
    @Getter
    private Button LeftButton;
    @Getter
    private Button RightButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_layout, container, false);

        LeftButton = view.findViewById(R.id.change);
        RightButton = view.findViewById(R.id.cancel);
        return view;
    }


    public void setActionOn_LeftButton(@Nullable View.OnClickListener l) {
        LeftButton.setOnClickListener(l);
    }


    public void setActionOn_RightButton(@Nullable View.OnClickListener l) {
        RightButton.setOnClickListener(l);
    }

    public void setTextOn_LeftButton(String str) {
        LeftButton.setText(str);
    }

    public void setTextOn_RightButton(String str) {
        RightButton.setText(str);
    }

}
