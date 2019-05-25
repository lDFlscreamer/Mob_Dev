package com.kpi.lab2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lombok.Getter;

public class ButtonFragment extends Fragment {
    @Getter
    private Button okButton;
    @Getter
    private Button cancelButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_layout, container, false);

        okButton = view.findViewById(R.id.change);
        cancelButton = view.findViewById(R.id.cancel);
        return view;
    }


    public void setActionOn_OkButton(@Nullable View.OnClickListener l) {
        okButton.setOnClickListener(l);


    }


    public void setActionOn_CancelButton(@Nullable View.OnClickListener l) {

        cancelButton.setOnClickListener(l);

    }


}
