package com.example.traficapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.InfoAdapter;
import com.example.traficapplication.activities.adapters.SignalAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.Info;
import com.example.traficapplication.activities.models.ResponseInfo;
import com.example.traficapplication.activities.models.Signal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProhibitSignalFragment extends Fragment {

    private View prohibitSignalView;
    private RecyclerView recyclerView;
    private SignalAdapter signalAdapter;
    private ArrayList<Signal> signals = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private InfoAdapter infoAdapter;
    private ArrayList<Info> info = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prohibitSignalView = inflater.inflate(R.layout.fragment_prohibit_signal, container, false);
        initUi();
        setRecylerView();
        getIn4();
        return prohibitSignalView;
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this.prohibitSignalView.getContext());
        infoAdapter = new InfoAdapter(info,this.prohibitSignalView.getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.prohibitSignalView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void initUi() {
        recyclerView = prohibitSignalView.findViewById(R.id.rv_prohibit_signal);
    }
    private void getIn4(){
        Call<ResponseInfo> responseDTOCall = (Call<ResponseInfo>) ApiClient.getApi().getAllData();
        responseDTOCall.enqueue(new Callback<ResponseInfo>() {
            @Override
            public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(infoAdapter);
                info.addAll(response.body().getData());
            }
            @Override
            public void onFailure(Call<ResponseInfo> call, Throwable t) {
                Toast.makeText(getContext(), "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}