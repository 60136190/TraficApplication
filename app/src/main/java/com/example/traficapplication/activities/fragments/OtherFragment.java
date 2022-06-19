package com.example.traficapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.OtherAdapter;
import com.example.traficapplication.activities.models.LawCategory;

import java.util.ArrayList;
import java.util.List;


public class OtherFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private OtherAdapter lawAdapter;
    private GridLayoutManager gridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_other, container, false);
        intiUi();
        setAdapter();
        return view;
    }
    private void setAdapter() {
        lawAdapter = new OtherAdapter(this.getContext());
        gridLayoutManager = new GridLayoutManager(this.view.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        lawAdapter.setData(getListLaw());
        recyclerView.setAdapter(lawAdapter);
    }
    private List<LawCategory> getListLaw() {
        List<LawCategory> listLawCategory = new ArrayList<>();
        listLawCategory.add(new LawCategory(R.drawable.signpost, "Hiệu lệnh, biển chỉ dẫn"));
        listLawCategory.add(new LawCategory(R.drawable.directions, "Chuyển hướng, nhường đường"));
        listLawCategory.add(new LawCategory(R.drawable.parking, "Dừng xe, đỗ xe"));
        listLawCategory.add(new LawCategory(R.drawable.demostration, "Thiết bị ưu tiên, còi"));
        listLawCategory.add(new LawCategory(R.drawable.speedometer, "Tốc độ, khoảng cách an toàn"));
        listLawCategory.add(new LawCategory(R.drawable.transportations, "Vận chuyển người, hàng hóa"));
        listLawCategory.add(new LawCategory(R.drawable.helmet, "Trang thiết bị phương tiện"));
        listLawCategory.add(new LawCategory(R.drawable.stop, "Đường cấm, đường một chiều"));
        listLawCategory.add(new LawCategory(R.drawable.non_alcoholic_beer, "Nồng độ cồn, chất kích thích"));
        listLawCategory.add(new LawCategory(R.drawable.certification, "Giấy tờ xe"));
        listLawCategory.add(new LawCategory(R.drawable.gamer, "Khác"));
        return listLawCategory;
    }
    private void intiUi() {
        recyclerView = view.findViewById(R.id.rv_other);
    }
}