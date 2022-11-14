package com.example.tcpland.View.Account;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tcpland.R;
import com.example.tcpland.View.DashBoard;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton buttonLogin= findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(v->{
            Intent intent= new Intent(LoginActivity.this, DashBoard.class);
            LoginActivity.this.startActivity(intent);
        });
    }
}