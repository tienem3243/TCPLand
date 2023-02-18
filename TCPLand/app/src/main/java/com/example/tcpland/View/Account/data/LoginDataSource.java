package com.example.tcpland.View.Account.data;

import com.example.tcpland.View.Account.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    String result = null;

    public Result<LoggedInUser> login(String username, String password) {

        try {

         LoggedInUser loggedInUser = new LoggedInUser(username,username);
         return new Result.Success<>(loggedInUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Lỗi không xác định", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}