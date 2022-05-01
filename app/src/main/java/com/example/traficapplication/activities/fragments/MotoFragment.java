package com.example.traficapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.FunctionAdapter;
import com.example.traficapplication.activities.adapters.LawAdapter;
import com.example.traficapplication.activities.models.Function;
import com.example.traficapplication.activities.models.Law;

import java.util.ArrayList;
import java.util.List;

public class MotoFragment  extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LawAdapter lawAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_moto, container, false);
        intiUi();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        lawAdapter = new LawAdapter(this.getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.view.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        lawAdapter.setData(getListLaw());
        recyclerView.setAdapter(lawAdapter);
    }

    private List<Law> getListLaw() {
        List<Law> listLaw = new ArrayList<>();
        listLaw.add(new Law(R.drawable.test, "Thi Sát hạch"));
        listLaw.add(new Law(R.drawable.books, "Lí thuyết"));
        listLaw.add(new Law(R.drawable.traffic_lights, "Biển báo đường bộ"));
        listLaw.add(new Law(R.drawable.lightbulb, "Mẹo ôn tập, thi"));
        listLaw.add(new Law(R.drawable.legal_document, "Tra cứu luật"));
        listLaw.add(new Law(R.drawable.warning, "Lưu ý"));

        return listLaw;
    }
    private void intiUi() {
        recyclerView = view.findViewById(R.id.rv_moto);
    }
}