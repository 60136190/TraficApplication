package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.DocumentAdapter;
import com.example.traficapplication.activities.models.Document;

import java.util.ArrayList;

public class DocumentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DocumentAdapter documentAdapter;
    private ArrayList<Document> documents = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);
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
        documentAdapter = new DocumentAdapter(this,documents);
        recyclerView.setAdapter(documentAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        itemAdd(R.drawable.exclamation,"60 câu hỏi điểm liệt","60 Câu hỏi điểm liệt",2);
        itemAdd(R.drawable.essay,"Khái niệm và quy tắc","Gồm 139 câu hỏi (41 câu điểm liệt)",2);
        itemAdd(R.drawable.cone,"văn hóa và đạo đức lái xe","Gồm 21 câu hỏi (4 câu điểm liệt)",2);
        itemAdd(R.drawable.driving_school,"kỹ thuật lái xe","Gồm 18 câu hỏi (5 câu điểm liệt)",2);
        itemAdd(R.drawable.technical_support,"cấu tạo và sửa chữa","Gồm 7 câu hỏi",2);
        itemAdd(R.drawable.traffic_sign,"biển báo đường bộ","Gồm 182 câu hỏi",2);
        itemAdd(R.drawable.intersection,"Sa hình","Gồm 83 câu hỏi",2);
        documentAdapter.notifyDataSetChanged();

    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_document);
    }
    private void itemAdd(int img, String tittle, String content, int seekBarNum){
        documents.add(new Document(img,tittle,content,seekBarNum));
    }
}