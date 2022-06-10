package com.example.traficapplication.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.traficapplication.activities.utils.Contants;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
   private CircleImageView imgUser;
    private TextView user,email,phoneNum,address;
    private ImageView editUser,logOutUser;
    private Button btnChangePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initUi();
        edtUsr();
        logOutUsr();
        getIn4();
        changePass();
    }

    private void changePass() {
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, PasswordUpdateActivity.class);
                startActivity(intent);
                UserActivity.this.finish();
            }
        });

    }

    private void logOutUsr() {
        logOutUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openDialog(Gravity.BOTTOM);
            }
        });
    }
    private void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_user_back);
        TextView tvMessage = dialog.findViewById(R.id.tv_warning_user);
        Button btnContinue = dialog.findViewById(R.id.btn_back_user);
        Button btnExit = dialog.findViewById(R.id.btn_exit_user);
        tvMessage.setText(R.string.log_out);
        btnContinue.setText(R.string.stay);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences email = UserActivity.this.getSharedPreferences("MySharedPref", 0);
                email.edit().remove("email").commit();
                email.edit().remove("id").commit();
                email.edit().remove("position").commit();
                finishAffinity();
            }
        });
        dialog.show();
    }
    private void edtUsr(){
        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, UserUpdateActivity.class);
                Bitmap bitmap = BitmapFactory.decodeResource
                        (getResources(), R.drawable.user); // your bitmap
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
                startActivity(intent);
                UserActivity.this.finish();
            }
        });
    }
    private void getIn4(){
        String id = getSharedPreferences("MySharedPref",Context.MODE_PRIVATE).getString(Contants.id,"");
        Call<ProfileResponse> responseDTOCall = ApiClient.userApi().Profile(id);
        responseDTOCall.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                String url = response.body().getData().get(0).getProfileImage().getUrl();
                Picasso.with(UserActivity.this)
                        .load(url).fit().centerInside().into(imgUser);
                String name = String.valueOf(response.body().getData().get(0).getFullName());
                user.setText(name);
                email.setText(response.body().getData().get(0).getEmail());
                phoneNum.setText(String.valueOf(response.body().getData().get(0).getPhoneNumber()));
                address.setText(String.valueOf(response.body().getData().get(0).getAddress()));
                Toast.makeText(UserActivity.this, "Xin chào "+name, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(UserActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initUi() {
        imgUser = findViewById(R.id.img_user);
        user = findViewById(R.id.tv_user);
        email = findViewById(R.id.tv_mail);
        phoneNum = findViewById(R.id.tv_phoneNum);
        address = findViewById(R.id.tv_add);
        editUser = findViewById(R.id.img_edit_user);
        logOutUser = findViewById(R.id.img_out_user);
        btnChangePass = findViewById(R.id.btn_update_pass);

    }


}