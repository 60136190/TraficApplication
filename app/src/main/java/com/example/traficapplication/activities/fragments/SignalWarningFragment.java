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
import com.example.traficapplication.activities.adapters.SignAdapter;
import com.example.traficapplication.activities.adapters.SignalAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.Info;
import com.example.traficapplication.activities.models.InfoResponse;
import com.example.traficapplication.activities.models.Sign;
import com.example.traficapplication.activities.models.SignResponse;
import com.example.traficapplication.activities.models.Signal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignalWarningFragment extends Fragment {

    private View warningSignalView;
    private RecyclerView recyclerView;
    private SignalAdapter signalAdapter;
    private ArrayList<Signal> signals = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private EditText edtSearch;
    private InfoAdapter infoAdapter;
    private ArrayList<Info> info = new ArrayList<>();
    private SignAdapter signAdapter;
    private  ArrayList<Sign> signs = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        warningSignalView = inflater.inflate(R.layout.fragment_signal_warning, container, false);
        initUi();
        setRecylerView();
        getIn4();
        search();
        return warningSignalView;
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this.warningSignalView.getContext());
        signAdapter = new SignAdapter(signs,this.warningSignalView.getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.warningSignalView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void initUi() {
        recyclerView = warningSignalView.findViewById(R.id.rv_warning_signal);
        edtSearch = warningSignalView.findViewById(R.id.edt_search_warning);
    }

    private void getIn4(){
        Call<SignResponse> responseDTOCall = (Call<SignResponse>) ApiClient.getApi().getProhibitSign();
        responseDTOCall.enqueue(new Callback<SignResponse>() {
            @Override
            public void onResponse(Call<SignResponse> call, Response<SignResponse> response) {
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(signAdapter);
                signs.addAll(response.body().getData());
            }
            @Override
            public void onFailure(Call<SignResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Connecting... ", Toast.LENGTH_SHORT).show();
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
        List<Sign> filteredList = new ArrayList<>();
        for (Sign item : signs) {
            if (item.getName().toUpperCase().contains(text.toUpperCase())) {
                filteredList.add(item);
            }
        }
        signAdapter.filterListSign(filteredList);
    }
}