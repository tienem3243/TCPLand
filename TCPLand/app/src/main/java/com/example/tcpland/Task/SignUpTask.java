package com.example.tcpland.Task;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpTask extends AsyncTask<String, Void, Boolean> {
    public Data getLoad() {
        return load;
    }

    public void setLoad(Data load) {
        this.load = load;
    }

    public Data getGo() {
        return go;
    }

    public void setGo(Data go) {
        this.go = go;
    }

    public Data getErr() {
        return err;
    }

    public void setErr(Data err) {
        this.err = err;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    String URL="";
    Data err;
    Data load;
    Data go;
    public interface Data {
         void get();
    }

    public SignUpTask(Data data) {
        this.load = data;
    }

    public SignUpTask() {
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        String res = "";
        try {
            res = signUp(strings[0], strings[1],strings[2]);
            if(res.contains("UserAdded")){
                load.get();
                return true;
            }else {
               return  false;
            }
        } catch (IOException e) {
            err.get();
            e.printStackTrace();
            Log.e("errTask", "doInBackground: "+e );

        }
        Log.e("getz", "signIn: " + res);
        return false;
    }

    @Override
    protected void onPostExecute(Boolean s) {
        Log.e("logLoad", "onPostExecute: " + s);
        if(s){
            go.get();
        }else{
            err.get();
        }
        super.onPostExecute(s);
    }

    public String signUp(String email, String password,String idPresenter)
            throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .add("tructhuoc_id",idPresenter)
                .build();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL+"/api/signup")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.body() != null;
        if(Objects.equals(response.body().string(), "UserAdded")){
            formBody = new FormBody.Builder()
                    .add("tructhuoc_id", idPresenter)
                    .build();
             request = new Request.Builder()
                    .url(URL+"/api/checktructhuoc_id")
                    .post(formBody)
                    .build();

            call = client.newCall(request);
            response = call.execute();
            Log.e("register",response.body().string());
            if(Objects.equals(response.body().string(), "Tructhuoc_idExisted")){
                formBody = new FormBody.Builder()
                        .add("email", idPresenter)
                        .build();
                request = new Request.Builder()
                        .url(URL+"/api/createtable")
                        .post(formBody)
                        .build();

                call = client.newCall(request);
                response = call.execute();
            }
        }
        return response.body().string();
    }

}