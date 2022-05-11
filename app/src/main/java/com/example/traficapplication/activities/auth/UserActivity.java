package com.example.traficapplication.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.InfoAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.Info;
import com.example.traficapplication.activities.models.ResponseInfo;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    private InfoAdapter adapter;
    ArrayList<Info> data = new ArrayList<>();
   private CircleImageView imgUser;
    private TextView user,email,phoneNum,address,gender;
    private ImageView editUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initUi();
        onClick();
        getModelApi();


    }
    private void onClick(){
        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,EditUserActivity.class);
                Bitmap bitmap = BitmapFactory.decodeResource
                        (getResources(), R.drawable.user); // your bitmap
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
                startActivity(intent);
            }
        });
    }

    private void initUi() {
        imgUser = findViewById(R.id.img_user);
        user = findViewById(R.id.tv_user);
        email = findViewById(R.id.tv_mail);
        phoneNum = findViewById(R.id.tv_phoneNum);
        address = findViewById(R.id.tv_add);
        gender = findViewById(R.id.tv_gender);
        editUser = findViewById(R.id.img_edit_user);

    }
    private void getModelApi(){
        Call<ResponseInfo> responseDTOCall = (Call<ResponseInfo>) ApiClient.getApi().getAllData();
        responseDTOCall.enqueue(new Callback<ResponseInfo>() {
            @Override
            public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
                String url = response.body().getData().get(1).getUrl();
                Picasso.with(UserActivity.this)
                        .load(url).fit().centerInside().into(imgUser);
                Toast.makeText(UserActivity.this, "OK ", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<ResponseInfo> call, Throwable t) {
                Toast.makeText(UserActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }


}