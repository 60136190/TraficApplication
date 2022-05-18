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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignalDetailActivity extends AppCompatActivity {
    private InfoAdapter infoAdapter;
    private ArrayList<Info> info = new ArrayList<>();
    private TextView tvSignalName;
    private TextView tvSignalDetail;
    private CircleImageView cImgSignal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal_detail);
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
        int id = (int) b.get("id");
        Call<InfoResponse> responseDTOCall = (Call<InfoResponse>) ApiClient.getApi().getSpData(String.valueOf(id));
        responseDTOCall.enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                tvSignalDetail.setText(response.body().getData().get(0).getChitiet());
                String url = response.body().getData().get(0).getUrl();
                Picasso.with(SignalDetailActivity.this)
                        .load(url).fit().centerInside().into(cImgSignal);
                tvSignalName.setText(response.body().getData().get(0).getTensp());
            }
            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                Toast.makeText(SignalDetailActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
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