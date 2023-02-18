package com.example.tcpland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tcpland.Task.LoadTask;
import com.example.tcpland.Task.SignInTask;
import com.google.gson.annotations.Expose;

public class MainActivity extends AppCompatActivity {
    public class Data{

        public Data(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Expose
        private String email;
        @Expose
        private String password;
        //Add a constructor and getters + setters
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new LoadTask().execute("0215024202356","u");
        setContentView(R.layout.activity_main4);

    }

}