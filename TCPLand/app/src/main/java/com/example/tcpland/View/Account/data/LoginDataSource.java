package com.example.tcpland.View.Account.data;

import android.util.Log;

import com.example.tcpland.SignInTask;
import com.example.tcpland.View.Account.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    String result = null;

    public Result<LoggedInUser> login(String username, String password) {

        try {

            SignInTask signInTask = new SignInTask();
            signInTask.execute(username, password);
        } catch (Exception e) {
            return new Result.Error(new IOException("Lỗi không xác định", e));
        }
        return new Result.Error(new IOException("Lỗi không xác định"));
    }

    public void logout() {
        // TODO: revoke authentication
    }
}