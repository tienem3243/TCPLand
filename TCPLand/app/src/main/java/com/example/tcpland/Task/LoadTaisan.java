package com.example.tcpland.Task;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoadTaisan extends AsyncTask<String, Void, String> {
    public Data getLoad() {
        return load;
    }

    public void getResult(Data load) {
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

    public void setQuerry(String URL) {
        this.URL = URL;
    }

    String URL="";
    Data err;
    Data load;
    Data go;
    public interface Data {
         void get(String e) throws IOException;
    }

    public LoadTaisan(Data data) {
        this.load = data;
    }

    public LoadTaisan() {
    }

    @Override
    protected String doInBackground(String... strings) {

        String res = "";
        try {
            go.get("start loading");
            res = querry(strings[0], strings[1]);
            return res;
        } catch (IOException e) {
            try {
                err.get(String.valueOf(e));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            Log.e("errTask", "doInBackground: "+e );

        }
        return "Not found";
    }


    @Override
    protected void onPostExecute(String s) {
        Log.e("logLoad", "onPostExecute: " + s);
        try {
            load.get(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

    public String querry(String id_user, String auth)
            throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("id_user", id_user)
                .add("auth", auth)
                .build();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL+"")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.body() != null;
        return response.body().string();
    }

}