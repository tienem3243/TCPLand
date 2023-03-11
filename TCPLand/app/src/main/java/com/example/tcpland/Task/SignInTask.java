package com.example.tcpland.Task;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tcpland.Model.Account;
import com.example.tcpland.Model.Vi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignInTask extends AsyncTask<String, Void, Boolean> {
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

    String URL = "";
    Data err;
    Data load;
    Data go;

    public Account getAccountInfo() {
        return accountInfo;
    }


    Account accountInfo;

    public interface Data {
        void get();
    }

    public SignInTask(Data data) {
        this.load = data;
    }

    public SignInTask() {
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        String  res= "";
        try {
            res=signIn(strings[0],strings[1]);
            Log.e("signInfo", "doInBackground: " + res);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(res);
            accountInfo = new Account();
            jsonNode=jsonNode.get(0);
            accountInfo.setId_user(jsonNode.get("id_user").toString());
            accountInfo.setEmail(jsonNode.get("email").toString());
            accountInfo.setPassword(jsonNode.get("password").toString());
            accountInfo.setSdt(jsonNode.get("sdt").toString());
            Vi vi1 = new Vi();
            vi1.setAccountAddress(jsonNode.get("tk_1_address").toString());
            vi1.setBalance(jsonNode.get("tk_1_money").asDouble());
            //
            Vi vi2 = new Vi();
            vi2.setAccountAddress(jsonNode.get("tk_2_address").toString());
            vi2.setBalance(jsonNode.get("tk_2_money").asDouble());
            //
            Vi vi3 = new Vi();
            vi3.setAccountAddress(jsonNode.get("tk_3_address").toString());
            vi3.setBalance(jsonNode.get("tk_3_money").asDouble());
            accountInfo.setCapbac(jsonNode.get("capbac").asInt());
            accountInfo.setLuong(jsonNode.get("luong").asDouble());
            accountInfo.setHoahong(jsonNode.get("hoahong").asDouble());
            accountInfo.setQuanliID(jsonNode.get("quanly_id").toString());
            //TODO Date
            accountInfo.setStatus(jsonNode.get("status").toString());
            accountInfo.setKind(jsonNode.get("kind").toString());
            accountInfo.setHoten(jsonNode.get("hoten").toString());

            if (res.contains("email")) {
                load.get();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            Log.e("exp", "doInBackground: " + e);
            e.printStackTrace();

        }
        Log.e("getz", "signIn: " + res);
        return false;
    }

    @Override
    protected void onPostExecute(Boolean s) {
        Log.e("logLoad", "onPostExecute: " + s);
        if (s) {
            go.get();
        } else {
            err.get();
        }
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
                .url(URL)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.body() != null;

        return response.body().string();
    }

}