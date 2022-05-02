package com.example.traficapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.MotoAdapter;
import com.example.traficapplication.activities.models.Law;

import java.util.ArrayList;
import java.util.List;

public class MotoFragment  extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private MotoAdapter lawAdapter;
    private GridLayoutManager gridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_moto, container, false);
        intiUi();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        lawAdapter = new MotoAdapter(this.getContext());
        gridLayoutManager = new GridLayoutManager(this.view.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        lawAdapter.setData(getListLaw());
        recyclerView.setAdapter(lawAdapter);
    }

    private List<Law> getListLaw() {
        List<Law> listLaw = new ArrayList<>();
        listLaw.add(new Law(R.drawable.test, "Hiệu lệnh, biển chỉ dẫn"));
        listLaw.add(new Law(R.drawable.books, "Chuyển hướng, nhường đường"));
        listLaw.add(new Law(R.drawable.traffic_lights, "Dừng xe, đỗ xe"));
        listLaw.add(new Law(R.drawable.lightbulb, "Thiết bị ưu tiên, còi"));
        listLaw.add(new Law(R.drawable.legal_document, "Tốc độ, khoảng cách an toàn"));
        listLaw.add(new Law(R.drawable.warning, "Vận chuyển người, hàng hóa"));
        listLaw.add(new Law(R.drawable.warning, "Trang thiết bị phương tiện"));
        listLaw.add(new Law(R.drawable.warning, "Đường cấm, đường một chiều"));
        listLaw.add(new Law(R.drawable.warning, "Nồng độ cồn, chất kích thích"));
        listLaw.add(new Law(R.drawable.warning, "Giấy tờ xe"));
        listLaw.add(new Law(R.drawable.warning, "Khác"));

        return listLaw;
    }
    private void intiUi() {
        recyclerView = view.findViewById(R.id.rv_moto);
    }
}