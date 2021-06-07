package com.example.piyush.benchmarkapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RunBenchMark extends AppCompatActivity {

    private TextView result;
    private Button compute;
    private String teststring;
    private String HashValue;
    private String tt;
    private String output;
    private long tsLong;
    private String MD5Value;
    private String tt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runbenchmark);
        compute = findViewById(R.id.rbmbegin);
        result = findViewById(R.id.rbmtextview2);
        teststring = getResources().getString(R.string.teststring); //teststring which will be converted to hexadecimals and sent to CPU over 200000 to put load on CPU.
    }

    public void onBeginClick(View view) {  //Button OnClick method to start the algorithm.
        tsLong = System.nanoTime();
        for (Integer i = 0; i < 20000; i++) {  //for loop to send teststring 200000 in CPU by SHA algorithm.
            computeSHAHash(teststring);
        }
        Long ttLong = System.nanoTime() - tsLong;
        tt = ttLong.toString();
        tsLong = System.nanoTime();
        for (Integer i = 0; i < 20000; i++) {  //for loop to send teststring 200000 in CPU by MD5 algorithm.
            computeMD5Hash(teststring);
        }
        Long ttLong2 = System.nanoTime() - tsLong;
        tt2 = ttLong2.toString();
        Integer floor = Math.round(ttLong / 100000);
        Integer floor2 = Math.round(ttLong2 / 100000);
        Integer total = (floor + floor2) / 2;
        //Integer roundnumber = Math.round(ttLong / 100000);
        String score = total.toString();
        output = "SHA-1 hash: " + HashValue + "\n Time Taken: " + tt + "\n \n MD5 Hash: " + MD5Value + "\n \n Time Taken: " + tt2 + "\n \n Score: " + score;
        result.setText(output);
    }

    public void computeSHAHash(String password)  //SHA algorithm.
    {
        MessageDigest mdSha1 = null;
        try {
            mdSha1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e1) {
            Log.e("Benchmark", "Error initializing SHA1");
        }
        try {
            mdSha1.update(password.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data = mdSha1.digest();
        StringBuffer sb = new StringBuffer();
        String hex = null;

        hex = Base64.encodeToString(data, 0, data.length, 0); //Converting the messagedigest to hexadecimals.

        sb.append(hex);
        HashValue = sb.toString();
    }

    public void computeMD5Hash(String password) //MD5 algorithm.
    {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer MD5Hash = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                MD5Hash.append(h);
            }
            MD5Value = MD5Hash.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.e("Benchmark", "Error initializing MD5");
        }
    }
}
