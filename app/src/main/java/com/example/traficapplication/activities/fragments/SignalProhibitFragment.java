package com.example.traficapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.InfoAdapter;
import com.example.traficapplication.activities.adapters.SignalAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.Info;
import com.example.traficapplication.activities.models.InfoResponse;
import com.example.traficapplication.activities.models.Signal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignalProhibitFragment extends Fragment {


    // search bar
    private EditText edtSearch;
    private CharSequence search = "";

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
        prohibitSignalView = inflater.inflate(R.layout.fragment_signal_prohibit, container, false);
        initUi();
        setRecylerView();
        getIn4();
        search();
        return prohibitSignalView;

    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this.prohibitSignalView.getContext());
        infoAdapter = new InfoAdapter(info,this.prohibitSignalView.getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.prohibitSignalView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void initUi() {
        edtSearch = prohibitSignalView.findViewById(R.id.edt_search_prohibit);
        recyclerView = prohibitSignalView.findViewById(R.id.rv_prohibit_signal);
    }

    private void getIn4(){
        Call<InfoResponse> responseDTOCall = (Call<InfoResponse>) ApiClient.getApi().getAllData();
        responseDTOCall.enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(infoAdapter);
                info.addAll(response.body().getData());
            }
            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void search(){
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }
    private void filter(String text) {
        List<Info> filteredList = new ArrayList<>();
        for (Info item : info) {
            if (item.getTensp().toUpperCase().contains(text.toUpperCase())) {
                filteredList.add(item);
            }
        }
        infoAdapter.filterListInfo(filteredList);
    }

}