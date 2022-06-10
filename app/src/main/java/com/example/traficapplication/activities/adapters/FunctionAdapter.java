package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.activities.QuestionCategoryActivity;
import com.example.traficapplication.activities.activities.LawActivity;
import com.example.traficapplication.activities.activities.NoteActivity;
import com.example.traficapplication.activities.activities.SignActivity;
import com.example.traficapplication.activities.activities.TestActivity;
import com.example.traficapplication.activities.activities.TrickActivity;
import com.example.traficapplication.activities.models.Function;

import java.util.List;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.FunctionViewHolder> {
    private Context context;
    private List<Function> function;

    public FunctionAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Function> function) {
        this.function = function;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FunctionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_grid_view, parent, false);
        return new FunctionViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FunctionViewHolder holder, int position) {
        Function fnction = function.get(position);
        int a = position;
        if (fnction == null) {
            return;
        }
        holder.imgFunction.setImageResource(fnction.getFuntionAvt());
        holder.tittleFunction.setText(fnction.getFunctionTittle());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (a) {
                    case 0:
                        Intent intent = new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, QuestionCategoryActivity.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, SignActivity.class);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, TrickActivity.class);
                        context.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(context, LawActivity.class);
                        context.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(context, NoteActivity.class);
                        context.startActivity(intent5);
                        break;
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        if (function != null) {
            return function.size();
        }
        return 0;
    }
    public class FunctionViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFunction;
        private TextView tittleFunction;
        private ConstraintLayout constraintLayout;
        public FunctionViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFunction = itemView.findViewById(R.id.img_item_grid_view);
            tittleFunction = itemView.findViewById(R.id.tv_title_item_grid_view);
            constraintLayout = itemView.findViewById(R.id.item_function);
        }
    }
}
