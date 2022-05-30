package com.example.traficapplication.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.MainActivity;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.LoginResponse;
import com.example.traficapplication.activities.models.UserLogin;
import com.example.traficapplication.activities.utils.Contants;
import com.example.traficapplication.activities.utils.StoreUtils;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText edtEmail;
    TextInputEditText edtPass;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initUi();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });
    }



    private void logIn() {
        String mail = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();

        UserLogin userLogin1 = new UserLogin(mail,pass);
        Call<LoginResponse> responseDTOCall = (Call<LoginResponse>) ApiClient.User().Login(userLogin1);
        responseDTOCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getStatus()==200)
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    StoreUtils.save(LoginActivity.this, Contants.email, mail);
                    StoreUtils.save(LoginActivity.this, Contants.id, String.valueOf(response.body().getId()));
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUi() {
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.txt_input_pass);
        btnSignIn = findViewById(R.id.btn_signInLoginScreen);
    }


}