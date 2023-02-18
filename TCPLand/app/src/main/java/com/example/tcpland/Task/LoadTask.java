package com.example.tcpland.Task;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoadTask extends AsyncTask<String,String,String> {
    String URL="https://gtechland.herokuapp.com/api/getvinaprutuser";

    public String LoadWallet(String idUser, String auth)
            throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("id_user", idUser)
                .add(" auth", auth)
                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.body() != null;
        Log.e("sus", "LoadWallet: "+response.body().string());
        return response.body().string();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            LoadWallet(strings[0],strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
