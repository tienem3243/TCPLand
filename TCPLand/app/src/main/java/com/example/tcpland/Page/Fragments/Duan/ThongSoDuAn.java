package com.example.tcpland.Page.Fragments.Duan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Model.Duan;
import com.example.tcpland.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ThongSoDuAn extends Fragment {
    FloatingActionButton button;
    Duan news;
    public ThongSoDuAn(String dataWeb, Duan news) {
        dataWeb="<style>img{display: inline;height: auto;max-width: 100%;}</style>"+dataWeb;
        this.dataWeb = dataWeb;
        this.news= news;
    }

    public String getDataWeb() {
        return dataWeb;
    }

    public void setDataWeb(String dataWeb) {
        this.dataWeb = dataWeb;
    }

    String dataWeb;
    @SuppressLint({"SetJavaScriptEnabled", "ClickableViewAccessibility"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.chi_tiet_du_an, container, false);
        button=rootview.findViewById(R.id.detailNewsBtn);
        button.setOnClickListener(v->{
            Log.e("buttonfloating", "clicked" );
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("second")
                    .replace(R.id.fragment_container, new ChiTietDuAn(news))
                    .commit();
        });
        WebView mWebView =  rootview.findViewById(R.id.webview);
        mWebView.setFocusableInTouchMode(false);
        mWebView.setFocusable(false);
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            float m_downX;
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() > 1) {
                    //Multi touch detected
                    return true;
                }

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // save the x
                        m_downX = motionEvent.getX();
                        break;
                    }
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP: {
                        // set x so that it doesn't move
                        motionEvent.setLocation(m_downX, motionEvent.getY());
                        break;
                    }

                }
                return false;
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true); // enable javascript
        WebSettings settings = mWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        mWebView.loadData(dataWeb,"text/html","UTF-8");
        mWebView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getActivity(), description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });


        return  rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        clockwise(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void clockwise(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.come);
        view.startAnimation(animation1);
        view.setAnimation(animation1);
    }
}