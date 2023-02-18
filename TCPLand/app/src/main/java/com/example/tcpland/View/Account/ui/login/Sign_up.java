package com.example.tcpland.View.Account.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tcpland.R;
import com.example.tcpland.Task.SignUpTask;
import com.example.tcpland.databinding.ActivitySignUpBinding;

import java.util.Objects;

public class Sign_up extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private LoginViewModel loginViewModel;

    public Sign_up() {
        // required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        final Button btnSignUp = binding.accept;
        final EditText email = binding.email;
        final EditText id_presenter = binding.idPresenter;
        final EditText password = binding.passwd;
        final EditText rep_password = binding.passwdRep;

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            btnSignUp.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                email.setError(this.getString(loginFormState.getUsernameError()));

            }
            if (loginFormState.getPasswordError() != null) {
                password.setError(this.getString(loginFormState.getPasswordError()));
            }
            if (loginFormState.getPasswordError() != null) {
                rep_password.setError(this.getString(loginFormState.getPasswordError()));
            }

        });

        loginViewModel.getLoginResult().observe(this, loginResult -> {
            if (loginResult == null) {
                return;
            }

            if (loginResult.getError() != null) {
                showSignUpErr(loginResult.getError());
            }

            this.setResult(Activity.RESULT_OK);

            //Complete and destroy login activity once successful
            this.finish();
        });
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginViewModel.loginDataChanged(email.getText().toString(), password.getText().toString(), rep_password.getText().toString());
            }
        };
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        rep_password.addTextChangedListener(textWatcher);
        btnSignUp.setOnClickListener(v -> {
            Log.e("cast3", "onCreateView: ");
            SignUpTask signUpTask = new SignUpTask();
            signUpTask.setURL("https://gtechland.herokuapp.com");
            signUpTask.setLoad(new SignUpTask.Data() {
                @Override
                public void get() {

                }
            });
            signUpTask.setErr(new SignUpTask.Data() {
                @Override
                public void get() {

                }
            });
            signUpTask.setGo(new SignUpTask.Data() {
                @Override
                public void get() {
                    showStatus(R.string.SucceedSignUp);
                    Intent intent= new Intent(Sign_up.this,LoginActivity.class);
                    intent.putExtra("email",email.getText().toString())
                            .putExtra("password",password.getText().toString());
                    Sign_up.this.startActivity(intent);
                }
            });
            signUpTask.execute(
                    email.getText().toString(),
                    password.getText().toString(),
                    id_presenter.getText().toString());

        });
        setContentView(binding.getRoot());
    }


    private void showSignUpErr(@StringRes Integer errorString) {
        Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show();
    }

    private void showStatus(@StringRes Integer errorString) {
        Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show();
    }

}



