package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.FunctionAdapter;
import com.example.traficapplication.activities.models.Function;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment  extends Fragment {
    private View view;
    private ViewFlipper flipperImages;
    private RecyclerView recyclerView;
    private FunctionAdapter functionAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        intiUi();
        setAdapter();
        int images[] = {R.drawable.img, R.drawable.img_1, R.drawable.img_driving_nav_drawer,
                R.drawable.img_driving_nav_drawer, R.drawable.img_driving_nav_drawer, R.drawable.img_driving_nav_drawer};
        for (int image : images) {
            flipperImages(image);
        }

        return view;
    }

    private void setAdapter() {
        functionAdapter = new FunctionAdapter(this.getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.view.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        functionAdapter.setData(getListFuntion());
        recyclerView.setAdapter(functionAdapter);
    }

    private List<Function> getListFuntion() {
        List<Function> listFunction = new ArrayList<>();
        listFunction.add(new Function(R.drawable.test, "Thi Sát hạch"));
        listFunction.add(new Function(R.drawable.books, "Lí thuyết"));
        listFunction.add(new Function(R.drawable.traffic_lights, "Biển báo đường bộ"));
        listFunction.add(new Function(R.drawable.lightbulb, "Mẹo ôn tập, thi"));
        listFunction.add(new Function(R.drawable.legal_document, "Tra cứu luât"));
        listFunction.add(new Function(R.drawable.warning, "Lưu ý"));

        return listFunction;
    }
    private void intiUi() {
        flipperImages = view.findViewById(R.id.view_flipper_slide);
        recyclerView = view.findViewById(R.id.rv_function);
    }
        public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
            flipperImages.addView(imageView);
            flipperImages.setFlipInterval(2900);
            flipperImages.setAutoStart(true);
            flipperImages.setInAnimation(getContext(), android.R.anim.slide_in_left);
    }


}
