package com.example.tcpland.ui.Fragments.Fragments;

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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Model.NewsModel;
import com.example.tcpland.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class NewsDeepDetail extends Fragment {
    FloatingActionButton button;
    NewsModel news;
    public NewsDeepDetail(String dataWeb, NewsModel news) {
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
        View rootview=inflater.inflate(R.layout.web_view_news, container, false);
        button=rootview.findViewById(R.id.detailNewsBtn);
        button.setOnClickListener(v->{
            Log.e("buttonfloating", "clicked" );
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("second")
                    .replace(R.id.fragment_container1, new News_Detail(news))
                    .commit();
        });
        WebView mWebview =  rootview.findViewById(R.id.webview);
        mWebview.setOnTouchListener(new View.OnTouchListener() {
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
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript
        mWebview.loadData(dataWeb,"text/html","UTF-8");
        mWebview.setWebViewClient(new WebViewClient() {
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