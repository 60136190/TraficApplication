package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {
    private Context context;
    private List<String> results = new ArrayList();

    public ResultAdapter(Context context, List<String> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result, parent, false);
        return new ResultAdapter.ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        String currentItem = results.get(position);
        holder.tvResult.setText("Lần "+position+1+": "+currentItem);
    }

    @Override
    public int getItemCount() {
        if (results!=null){
            return results.size();
        }
        return 0;
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {
        private TextView tvResult;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            tvResult = itemView.findViewById(R.id.item_result);
        }
    }
}
