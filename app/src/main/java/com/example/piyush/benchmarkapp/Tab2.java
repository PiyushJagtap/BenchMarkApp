package com.example.piyush.benchmarkapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2 extends Fragment {

    TextView textView;
    String DeviceName = Build.MODEL; //string to call device name;
    String Board = Build.BOARD; //string to call motherboard name;
    String Brand = Build.BRAND; //string to call brand name;
    String BootLoader = Build.BOOTLOADER; //string to show bootloader version;
    String CPU1 = Build.CPU_ABI; //string to call cpu instruction set no;
    String Device = Build.DEVICE; //string to call industrial name;
    String Display = Build.DISPLAY;//string to call build id;
    String HardWare = Build.HARDWARE; //string to call hardware name from kernel;
    String Host = Build.HOST; //string to call internal engineering number;
    String SDK = Build.VERSION.SDK; //string to call api level;
    String Release = Build.VERSION.RELEASE; //string to call android version;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2, container, false);
        textView = (TextView) v.findViewById(R.id.DeviceInfo);
        //textview to display all the strings
        textView.setText("Device Name : " + DeviceName  //displays device name;
                + "\n" +
                "\n" +
                "MotherBoard : " + Board  //displays motherboard name;
                + "\n" +
                "\n" +
                "Brand Name : " + Brand  //displays brand name;
                + "\n" +
                "\n" +
                "BootLoader Version Number : " + BootLoader //displays bootloader version;
                + "\n" +
                "\n" +
                "CPU Instruction Set No : " + CPU1  //displays cpu instruction set no;
                + "\n" +
                "\n" +
                "Android Version : " + Release  //displays android version;
                + "\n" +
                "\n" +
                "Industrial Name : " + Device  //displays industrial name;
                + "\n" +
                "\n" +
                "Build ID : " + Display  //displays build id;
                + "\n" +
                "\n" +
                "API Level : " + SDK  //displays api level;
                + "\n" +
                "\n" +
                "Hardware : " + HardWare  //displays hardware name from kernel;
                + "\n" +
                "\n" +
                "Host : " + Host  //displays internal engineering number;
        );

        return v;
    }
}
