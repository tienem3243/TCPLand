package com.example.tcpland.View.Account;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tcpland.R;
import com.example.tcpland.databinding.ActivityLoginBinding;
import com.example.tcpland.ui.Activity.HomeActivity;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding biding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        biding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(biding.getRoot());
        //button setup
        biding.signUpLink.setOnClickListener(v->{
            Intent intent= new Intent(LoginActivity.this, Sign_up.class);
            LoginActivity.this.startActivity(intent);
        });
       biding.buttonLogin.setOnClickListener(v->{
           //validate
           if(isEmpty(biding.textEmail)){
                arlet(v,"Chưa điền Email");
             return;
           }
           if(isEmpty(biding.textPassword)){
               arlet(v,"Chưa điền Password");
               return;
           }
//
           Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
           LoginActivity.this.startActivity(intent);
        });
       //field set

    }
    public void arlet(View v,String s){
        Snackbar.make(this,v,s,3000).show();
    }
    boolean isEmpty(EditText editText){
        CharSequence str=editText.getText().toString();
        return TextUtils.isEmpty(str);
    }
}