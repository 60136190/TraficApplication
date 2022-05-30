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
import com.example.traficapplication.activities.models.ProfileResponse;
import com.example.traficapplication.activities.models.ResponseDTO;
import com.example.traficapplication.activities.models.UserUpdate;
import com.example.traficapplication.activities.utils.Contants;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserUpdateActivity extends AppCompatActivity {

    private CircleImageView avt;
    private ImageView edtAvt,exit;
    private TextView user,email,phoneNum,address,gender;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);
        initUi();
        getIn4();
//        changeAvt();
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

        // show dialog
        Button btnSave = dialog.findViewById(R.id.btn_back_user);
        Button btnExit = dialog.findViewById(R.id.btn_exit_user);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
                dialog.dismiss();
                back();
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
                Picasso.with(UserUpdateActivity.this)
                        .load(url).fit().centerInside().into(avt);
                String name = String.valueOf(response.body().getData().get(0).getFullName());
                user.setText(name);
                email.setText(response.body().getData().get(0).getEmail());
                phoneNum.setText(String.valueOf(response.body().getData().get(0).getPhoneNumber()));
                address.setText(String.valueOf(response.body().getData().get(0).getAddress()));
                Toast.makeText(UserUpdateActivity.this, "Chào "+name, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(UserUpdateActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveChange() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                back();
            }
        });
    }
    private void exit(){
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }
    private void back(){
        Intent intent = new Intent(UserUpdateActivity.this,UserActivity.class);
        startActivity(intent);
        UserUpdateActivity.this.finish();
    }
    private void update() {
        String name = String.valueOf(user.getText());
        String mail = String.valueOf(email.getText());
        String phone = String.valueOf(phoneNum.getText());
        String add = String.valueOf(address.getText());
        UserUpdate userUpdate = new UserUpdate(mail,name,phone,add);
                String id = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.id,"");
                Call<ResponseDTO> responseDTOCall = ApiClient.User().Update(userUpdate,id);
                responseDTOCall.enqueue(new Callback<ResponseDTO>() {
                    @Override
                    public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {

                    }
                    @Override
                    public void onFailure(Call<ResponseDTO> call, Throwable t) {
                        Toast.makeText(UserUpdateActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
                    }
                });
            }


    private void initUi() {
        avt = findViewById(R.id.img_edit_user);
        user = findViewById(R.id.edt_user);
        email = findViewById(R.id.edt_mail);
        phoneNum = findViewById(R.id.edt_phoneNum);
        address = findViewById(R.id.edt_add);
        edtAvt = findViewById(R.id.img_edit_avt);
        btnSave = findViewById(R.id.btn_save_edit);
        exit = findViewById(R.id.img_exit);
    }

}