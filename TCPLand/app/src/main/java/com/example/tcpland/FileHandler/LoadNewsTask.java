package com.example.tcpland.FileHandler;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.tcpland.Model.RealEstateModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoadNewsTask extends AsyncTask<String,Void,String>{
    Activity activity;
    int loadRange=0;
    //todo optimize load
    public AsyncResponse delegate = null;
    public LoadNewsTask(Activity Activity, AsyncResponse delegate){
        this.delegate = delegate;
        activity=Activity;
    }
    public interface AsyncResponse {
        void processFinish(String output) throws IOException;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = null;
        OkHttpClient client = new OkHttpClient();
        String query=LoadData("ApiQuery.txt", activity.getApplicationContext());
        String val="postsConnection";
        int index=query.indexOf(val);

        query= addString(query,"(skip: "+loadRange+")",index+val.length());
        Log.e("get query", "doInBackground: "+query);
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://api-ap-northeast-1.hygraph.com/v2/clbequozv0gwt01una4fc4di0/master").newBuilder();
        urlBuilder.addQueryParameter("query", query);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            res=response.body().string();
            Log.e("test", "get: "+res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
    public String addString(String str, String str2, int position) {
        return str.substring(0, position) + str2 + str.substring(position);
    }
    @Override
    protected void onPostExecute(String s) {
        try {
            delegate.processFinish(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RealEstateModel> LoadRealEstate(String fileName, Context context) {
        String jsonFileString = UtilsCustom.getJsonFromAssets(context, fileName);
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<RealEstateModel>>() { }.getType();
        List<RealEstateModel> realEstateModel = gson.fromJson(jsonFileString, listUserType);
        return realEstateModel;
    }

    public String LoadData(String inFile,Context context) {
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;

    }


}
