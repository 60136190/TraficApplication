package com.example.traficapplication.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.PasswordUpdate;
import com.example.traficapplication.activities.models.ProfileResponse;
import com.example.traficapplication.activities.models.ResponseDTO;
import com.example.traficapplication.activities.models.UserUpdate;
import com.example.traficapplication.activities.utils.Contants;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordUpdateActivity extends AppCompatActivity {
    private TextInputEditText pass, newPass, confirmPass;
    private Button btnUpdate;
    private ImageView imgExit;
    private CircleImageView avt;
    private TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_update);
        initUI();
        getIn4();
        saveChange();
        exit();
    }

    @Override
    public void onBackPressed() {
        openDialog(Gravity.BOTTOM);
    }



//    private void changeAvt() {
//    }

    private void openDialog(int gravity){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_user_back);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);

        Button btnSave = dialog.findViewById(R.id.btn_back_user);
        Button btnExit = dialog.findViewById(R.id.btn_exit_user);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
                dialog.dismiss();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        dialog.show();
    }
    private void getIn4() {
        String id = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.id,"");
        Call<ProfileResponse> responseDTOCall = ApiClient.User().Profile(id);
        responseDTOCall.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                String url = response.body().getData().get(0).getProfileImage().getUrl();
                Picasso.with(PasswordUpdateActivity.this)
                        .load(url).fit().centerInside().into(avt);
                String name = String.valueOf(response.body().getData().get(0).getFullName());
                user.setText(name);
            }
            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(PasswordUpdateActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveChange() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }
    private void exit(){
        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.BOTTOM);
            }
        });
    }
    private void back(){
        Intent in10t = new Intent(PasswordUpdateActivity.this,UserActivity.class);
        startActivity(in10t);
        PasswordUpdateActivity.this.finish();
    }
    private void update() {
        String p = String.valueOf(pass.getText());
        String newP = String.valueOf(newPass.getText());
        String confirmP = String.valueOf(confirmPass.getText());
        PasswordUpdate passwordUpdate = new PasswordUpdate(p,newP,confirmP);
        String id = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.id,"");
        Call<ResponseDTO> responseDTOCall = ApiClient.User().UpdatePass(passwordUpdate,id);
        responseDTOCall.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                if (response.body().getStatus() == 200){
                    back();
                }
                else {
                    Toast.makeText(PasswordUpdateActivity.this, response.body().getMsg() +id +"\n"+ p +"\n"+ newP +"\n"+ confirmP, Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Toast.makeText(PasswordUpdateActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initUI() {
        pass = findViewById(R.id.txt_input_up_pass);
        newPass = findViewById(R.id.txt_input_new_pass);
        confirmPass = findViewById(R.id.txt_input_confirm_pass);
        btnUpdate = findViewById(R.id.btn_update_pass);
        imgExit = findViewById(R.id.img_exit_pass);
        avt = findViewById(R.id.img_edit_user_pass);
        user = findViewById(R.id.tv_user_pass);
    }

}