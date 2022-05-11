package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.InfoAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.auth.UserActivity;
import com.example.traficapplication.activities.models.Info;
import com.example.traficapplication.activities.models.ResponseInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSignalActivity extends AppCompatActivity {
    private InfoAdapter infoAdapter;
    private ArrayList<Info> info = new ArrayList<>();
    private TextView tvSignalName;
    private TextView tvSignalDetail;
    private CircleImageView cImgSignal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_signal);
        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        getIn4(iin,b);
    }

    private void initUi() {
        tvSignalName = findViewById(R.id.tv_signal_name_detail);
        cImgSignal = findViewById(R.id.img_signal_detail);
        tvSignalDetail = findViewById(R.id.tv_describe_detail);

    }
    private void getIn4(Intent intent, Bundle b){
        Call<ResponseInfo> responseDTOCall = (Call<ResponseInfo>) ApiClient.getApi().getAllData();
        responseDTOCall.enqueue(new Callback<ResponseInfo>() {
            @Override
            public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
                int id = (int) b.get("id");
                tvSignalDetail.setText(response.body().getData().get(id).getChitiet());
                String url = response.body().getData().get(id).getUrl();
                Picasso.with(DetailSignalActivity.this)
                        .load(url).fit().centerInside().into(cImgSignal);
                tvSignalName.setText(response.body().getData().get(id).getTensp());
            }
            @Override
            public void onFailure(Call<ResponseInfo> call, Throwable t) {
                Toast.makeText(DetailSignalActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public  void setInfo(Intent iin, Bundle b){
        if(b!=null)
        {
            String signalDetail = (String) b.get("detail");
            tvSignalDetail.setText(signalDetail);
            int img = (int) b.get("img");
            cImgSignal.setImageResource(img);
            String signalName =(String) b.get("name");
            tvSignalName.setText(signalName);

        }
    }

}