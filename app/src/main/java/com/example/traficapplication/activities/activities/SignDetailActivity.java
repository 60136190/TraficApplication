package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.DetailResponse;
import com.example.traficapplication.activities.models.SignResponse;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignDetailActivity extends AppCompatActivity {
    private TextView tvSignName,tvSignDetail,tvSignCode;
    private ImageView ImgSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_detail);
        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String id = (String) b.get("id");
        getIn4(id);
    }
    private void initUi() {
        tvSignName = findViewById(R.id.tv_signal_name_detail);
        ImgSign = findViewById(R.id.img_signal_detail);
        tvSignDetail = findViewById(R.id.tv_describe_detail);
        tvSignCode = findViewById(R.id.tv_code_signal_detail);
    }
    private void getIn4( String id){
        Call<DetailResponse> responseDTOCall = (Call<DetailResponse>) ApiClient.signApi().getDetail(id);
        responseDTOCall.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                String url = response.body().getData().get(0).getImage().getUrl();
                Picasso.with(SignDetailActivity.this)
                        .load(url).fit().centerInside().into(ImgSign);
                tvSignName.setText(response.body().getData().get(0).getName());
                tvSignCode.setText(response.body().getData().get(0).getCode());
                tvSignDetail.setText(response.body().getData().get(0).getDescription());
            }
            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Toast.makeText(SignDetailActivity.this, "Connect internet is wrong! ",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }


}