package com.example.piyush.benchmarkapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab1 extends Fragment {

    public Button startBenchMark;

    public View init()  //Mehtod View to start a new activity on button click
    {
        startBenchMark = getView().findViewById(R.id.startBenchmark);  //object of button to get xml about the button and implement.
        startBenchMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //Button Click method to open new activity
                Intent start = new Intent(Tab1.this.getActivity(), RunBenchMark.class);
                startActivity(start);
            }
        });
        return null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {  //View to show the contents of Tab1
        return inflater.inflate(R.layout.tab1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {  //Main method to run everything on Tab1
        super.onActivityCreated(savedInstanceState);
        init();
    }
}



