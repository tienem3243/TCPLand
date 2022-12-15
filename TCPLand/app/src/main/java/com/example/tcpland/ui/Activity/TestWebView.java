package com.example.tcpland.ui.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tcpland.R;


public class TestWebView extends Fragment {
    public TestWebView(String dataWeb) {
        this.dataWeb = dataWeb;
    }

    public String getDataWeb() {
        return dataWeb;
    }

    public void setDataWeb(String dataWeb) {
        this.dataWeb = dataWeb;
    }

    String dataWeb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.web_view_news, container, false);
        WebView mWebview =  rootview.findViewById(R.id.webview);

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

}