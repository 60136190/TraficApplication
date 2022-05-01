package com.example.traficapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.SignalAdapter;
import com.example.traficapplication.activities.models.Signal;

import java.util.ArrayList;


public class WarningSignalFragment extends Fragment {

    private View warningSignalView;
    private RecyclerView recyclerView;
    private SignalAdapter signalAdapter;
    private ArrayList<Signal> signals = new ArrayList<>();
    private LinearLayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        warningSignalView = inflater.inflate(R.layout.fragment_warning_signal, container, false);
        initUi();
        setRecylerView();
        return warningSignalView;
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this.warningSignalView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        signalAdapter = new SignalAdapter(this.warningSignalView.getContext(),signals);
        recyclerView.setAdapter(signalAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.warningSignalView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        signals.add(new Signal(R.drawable.img,"abc","abc"));
        signals.add(new Signal(R.drawable.img,"abc","abc"));
        signalAdapter.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = warningSignalView.findViewById(R.id.rv_warning_signal);
    }
}