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
import com.example.traficapplication.activities.models.ResponseDTO;
import com.example.traficapplication.activities.models.UserRegister;
import com.example.traficapplication.activities.utils.Contants;
import com.example.traficapplication.activities.utils.StoreUtils;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText edtName, edtPass, edtEmail, edtPhone, edtAdd;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        intiUI();
        create();
    }
    private void create(){
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getModelIn4();
            }
        });
    }
    private void getModelIn4(){
        String name, pass, mail, phone, add;
        name = String.valueOf(edtName.getText());
        pass = String.valueOf(edtPass.getText());
        mail = String.valueOf(edtEmail.getText());
        phone = String.valueOf(edtPhone.getText());
        add = String.valueOf(edtAdd.getText());
        UserRegister userRegister = new UserRegister(mail,pass,name,phone,add);
        Call<LoginResponse> responseDTOCall = (Call<LoginResponse>) ApiClient.User().Register(userRegister);
        responseDTOCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getStatus()==200)
                {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    StoreUtils.save(RegisterActivity.this, Contants.email, mail);
                    StoreUtils.save(RegisterActivity.this, Contants.id, String.valueOf(response.body().getId()));
                    finish();
                }
                else
                {
                    if (mail==null){
                        Toast.makeText(RegisterActivity.this, "Email còn trống", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void intiUI() {
        edtName = findViewById(R.id.txt_input_name);
        edtPass =findViewById(R.id.txt_input_pass);
        edtEmail = findViewById(R.id.txt_input_email);
        edtPhone = findViewById(R.id.txt_input_phone);
        edtAdd = findViewById(R.id.txt_input_add);
        btnCreate = findViewById(R.id.btn_create);

    }
}