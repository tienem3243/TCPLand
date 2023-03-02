package com.example.tcpland.Vi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tcpland.Page.Taisan.TaisanFragment;
import com.example.tcpland.R;

public class TestViActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.lich_su_nap, new TaisanFragment())
                .addToBackStack(null)
                .commit();
        setContentView(R.layout.thongtinnaptien);
    }
}
