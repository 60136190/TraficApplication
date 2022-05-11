package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.activities.CarActivity;
import com.example.traficapplication.activities.activities.DoingTestActivity;
import com.example.traficapplication.activities.models.Document;
import com.example.traficapplication.activities.models.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private Context context;
    private List<Test> tests;


    public TestAdapter(Context context, ArrayList<Test> tests) {
        this.context = context;
        this.tests=tests;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TestAdapter.TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new TestAdapter.TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.TestViewHolder holder, int position) {
        Test t = tests.get(position);
        int a = position;
        if (t == null) {
            return;
        }

        holder.tittleTest.setText(t.getTittleTest());
        holder.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DoingTestActivity.class);
                intent.putExtra("numTest",String.valueOf(t.getTittleTest()));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        if (tests != null) {
            return tests.size();
        }
        return 0;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgTest;
        private TextView tittleTest;
        private  TextView detailTest;
        private Button btnTest;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTest = itemView.findViewById(R.id.img_item_test);
            detailTest = itemView.findViewById(R.id.tv_detail_item_test);
            tittleTest = itemView.findViewById(R.id.tv_tittle_item_test);
            btnTest = itemView.findViewById(R.id.btn_test);
        }
    }
}