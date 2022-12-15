package com.example.tcpland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tcpland.FileHandler.LoadNewsTask;

public class MainActivity extends AppCompatActivity {
    LoadNewsTask myAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}