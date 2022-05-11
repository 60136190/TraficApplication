package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.TestAdapter;
import com.example.traficapplication.activities.adapters.TrickAdapter;
import com.example.traficapplication.activities.models.Test;
import com.example.traficapplication.activities.models.Trick;

import java.util.ArrayList;

public class TrickActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TrickAdapter trickAdapter;
    private ArrayList<Trick> tricks = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);
        initUi();
        setRecylerView();

    }



//    private void defineAdapter() {
//        Intent iin = getIntent();
//        Bundle b = iin.getExtras();
//        if (b.get("lawPos").equals("0")) {
//            itemAdd(R.drawable.img,"abc","cccccccc","cascas");
//        }
//        if (b.get("lawPos").equals("1")) {
//            itemAdd(R.drawable.img_2,"abc","cccccccc","cascas");
//        }
//        if (b.get("lawPos").equals("3")){
//            itemAdd(R.drawable.img_3,"abc","cccccccc","cascas");
//        }
//
//    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        trickAdapter = new TrickAdapter(this, tricks);
        recyclerView.setAdapter(trickAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        itemAdd("Cấp phép","●Đường cấm dừng, cấm đỗ, cấm đi do UBND cấp tỉnh cấp.\n●Xe quá khổ, quá tải do: cơ quan quản lý đường bộ có thẩm quyền cấp phép");
        itemAdd("Nồng độ cồn","Người điều khiển xe mô tô, ô tô, xe máy kéo trên đường mà trong máu hoặc hơi thở có nồng độ cồn: Bị nghiêm cấm.");
        itemAdd("Khoảng cách an toàn tối thiểu","●35m nếu vận tốc lưu hành (V) = 60 (km/h)\n●55m nếu 60<V≤80\n●70m nếu 80<V≤100\n●100m nếu 100<V≤120\n●Dưới 60km/h: Chủ động và đảm bảo khoảng cách");
        itemAdd("Hỏi về tuổi (T)","●Gắn máy: 16T (dưới 50 cm3\n●Mô tô + B1 + B2: 18T");
//        itemAdd("Trên đường cao tốc, trong đường hầm, đường vòng, đầu dốc, nơi tầm nhìn hạn chế,");
//        itemAdd("Đề số 6");
//        itemAdd("Đề số 7");
//        itemAdd("Đề số 8");
//        itemAdd("Đề số 9");
//        itemAdd("Đề số 10");
//        itemAdd("Đề số 11");
//        itemAdd("Đề số 12");
//        itemAdd("Đề số 13");
//        itemAdd("Đề số 14");
//        itemAdd("Đề số 15");
//        itemAdd("Đề số 16");
//        itemAdd("Đề số 17");
//        itemAdd("Đề số 18");

        trickAdapter.notifyDataSetChanged();

    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_trick);
    }
    private void itemAdd( String tittle, String detail){
        tricks.add(new Trick(tittle,detail));
    }
}