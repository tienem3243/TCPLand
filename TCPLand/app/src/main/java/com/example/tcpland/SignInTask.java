package com.example.tcpland;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tcpland.View.Account.data.Result;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignInTask extends AsyncTask<String, Void, String> {
    Data data;

    public interface Data {
        public void get(String s);
    }

    public SignInTask(Data data) {
        this.data = data;
    }

    public SignInTask() {
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";
        try {
            res = signIn(strings[0], strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("getz", "signIn: " + res);
        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.e("logLoad", "onPostExecute: " + s);

        super.onPostExecute(s);
    }

    public String signIn(String email, String password)
            throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://gtechland.herokuapp.com/api/signin")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.body() != null;

        return response.body().string();
    }
}