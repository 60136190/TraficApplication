package com.example.traficapplication.activities.fragments;

import static com.example.traficapplication.R.menu.nav_search_menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.SignalAdapter;
import com.example.traficapplication.activities.models.Signal;

import java.util.ArrayList;
import java.util.List;


public class AuxiliarySignalFragment extends Fragment {

private ArrayAdapter<String> adapter;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    private View auxiliarySignalView;
    private RecyclerView recyclerView;
    private SignalAdapter signalAdapter;
    private ArrayList<Signal> signals = new ArrayList<>();
    private LinearLayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        auxiliarySignalView = inflater.inflate(R.layout.fragment_auxiliary_signal, container, false);
        initUi();
        setRecylerView();
        return auxiliarySignalView;
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this.auxiliarySignalView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        signalAdapter = new SignalAdapter(this.auxiliarySignalView.getContext(),signals);
//        signalAdapter = new SignalAdapter(this.auxiliarySignalView.getContext(),getList());
        recyclerView.setAdapter(signalAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.auxiliarySignalView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        signals.add(new Signal(R.drawable.img,"abc","cccccccc"));
        signals.add(new Signal(R.drawable.img,"abc","abc"));
        signalAdapter.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = auxiliarySignalView.findViewById(R.id.rv_auxiliary_signal);
    }
//    private List<Signal> getList(){
//        List<Signal> list = new ArrayList<>();
//        list.add(new Signal(R.drawable.img,"abc","cccccccc"));
//        list.add(new Signal(R.drawable.img,"abc","abc"));
//        return list;
//    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater = getActivity().getMenuInflater();
//        inflater.inflate(nav_search_menu,menu);
//    }
}