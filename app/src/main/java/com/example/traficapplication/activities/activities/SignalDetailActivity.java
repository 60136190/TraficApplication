package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.InfoAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.Info;
import com.example.traficapplication.activities.models.InfoResponse;
import com.example.traficapplication.activities.models.SignResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignalDetailActivity extends AppCompatActivity {
//    private InfoAdapter infoAdapter;
//    private ArrayList<Info> info = new ArrayList<>();
    private TextView tvSignalName,tvSignalDetail,tvSignalCode;

    private CircleImageView cImgSignal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal_detail);
        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String id = (String) b.get("id");
//        getIn4(id);
        Call<SignResponse> responseDTOCall = (Call<SignResponse>) ApiClient.getApi().getDetail(id);
        responseDTOCall.enqueue(new Callback<SignResponse>() {
            @Override
            public void onResponse(Call<SignResponse> call, Response<SignResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignalDetailActivity.this, response.body().getData().get(0).getName(),
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignalDetailActivity.this, "error",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<SignResponse> call, Throwable t) {
                Toast.makeText(SignalDetailActivity.this, "Connect internet is wrong! ",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUi() {
        tvSignalName = findViewById(R.id.tv_signal_name_detail);
        cImgSignal = findViewById(R.id.img_signal_detail);
        tvSignalDetail = findViewById(R.id.tv_describe_detail);
        tvSignalCode = findViewById(R.id.tv_code_signal_detail);

    }
    private void getIn4( String id){
        Call<SignResponse> responseDTOCall = (Call<SignResponse>) ApiClient.getApi().getDetail(id);
        responseDTOCall.enqueue(new Callback<SignResponse>() {
            @Override
            public void onResponse(Call<SignResponse> call, Response<SignResponse> response) {
               if(response.isSuccessful()){
                   Toast.makeText(SignalDetailActivity.this, response.body().getData().get(0).getName(),
                           Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(SignalDetailActivity.this, "error",
                           Toast.LENGTH_SHORT).show();
               }
            }
            @Override
            public void onFailure(Call<SignResponse> call, Throwable t) {
                Toast.makeText(SignalDetailActivity.this, "Connect internet is wrong! ",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
//    public  void setInfo(Intent iin, Bundle b){
//        if(b!=null)
//        {
//            String signalDetail = (String) b.get("detail");
//            tvSignalDetail.setText(signalDetail);
//            int img = (int) b.get("img");
//            cImgSignal.setImageResource(img);
//            String signalName =(String) b.get("name");
//            tvSignalName.setText(signalName);
//
//        }
//    }

}