package com.example.tcpland.View.Account.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tcpland.Task.SignInTask;
import com.example.tcpland.R;
import com.example.tcpland.databinding.ActivityLoginBinding;
import com.example.tcpland.ui.Activity.HomeActivity;


public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory()).get(LoginViewModel.class);

        final EditText usernameEditText = binding.textEmail;
        final EditText passwordEditText = binding.textPassword;
        final ImageButton loginButton = binding.buttonLogin;
        final ProgressBar loadingProgressBar = binding.loading;

        binding.signUpLink.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, Sign_up.class);
            LoginActivity.this.startActivity(intent);
        });

        ObserverResult(usernameEditText, passwordEditText, loginButton);

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                    loginViewModel.loginDataChanged(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
            return false;
        });

        loginButton.setOnClickListener(v -> {

            String username = usernameEditText.getText().toString();
            Log.e("test onclick", "onCreate: " + username);
            String password = passwordEditText.getText().toString();
            LoginFormState s = loginViewModel.getLoginFormState().getValue();
            if (s == null) {
                s = new LoginFormState(false);
                showLoginFailed(R.string.login_failed);
            }
            if (s.isDataValid()) {
                SignInTask signInTask = new SignInTask();
                signInTask.setURL("https://gtechland.herokuapp.com/api/signin");
                signInTask.setGo(() -> {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    Log.e("log", "onCreate: "+signInTask.getAccountInfo() );
                    intent.putExtra("userInfo",signInTask.getAccountInfo());
                    LoginActivity.this.startActivity(intent);
                });
                loadingProgressBar.setVisibility(View.VISIBLE);

                signInTask.setLoad(() -> {
                    loginViewModel.login(username, password);

                });
                signInTask.setErr(() -> {
                    showLoginFailed(R.string.login_failed);
                    loadingProgressBar.setVisibility(View.GONE);
                });
                signInTask.execute(username, password);
            }


        });

        if (getIntent().getExtras() != null) {
            Intent intentz = getIntent();
            String email = intentz.getStringExtra("email");
            String pass = intentz.getStringExtra("password");
            loginViewModel.loginDataChanged(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            usernameEditText.setText(email);
            passwordEditText.setText(pass);
        }


    }

    private void ObserverResult(EditText usernameEditText, EditText passwordEditText, ImageButton loginButton) {
        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            loginButton.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                usernameEditText.setError(getString(loginFormState.getUsernameError()));
            }
            if (loginFormState.getPasswordError() != null) {
                passwordEditText.setError(getString(loginFormState.getPasswordError()));
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + " " + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

}