package com.example.tcpland.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.tcpland.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView mWebview  = new WebView(this);
        String s="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Image</h2>\n" +
                "<img src=\"https://cdn.sstatic.net/Img/teams/teams-illo-free-sidebar-promo.svg?v=47faa659a05e\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        mWebview.loadData(s,"text/html", "UTF-8");
        setContentView(mWebview);
    }
}