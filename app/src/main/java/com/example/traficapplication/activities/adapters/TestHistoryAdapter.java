package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.models.TestHistory;
import com.example.traficapplication.activities.utils.Contants;
import com.example.traficapplication.activities.utils.StoreUtils;

import java.util.ArrayList;
import java.util.List;

public class TestHistoryAdapter extends RecyclerView.Adapter<TestHistoryAdapter.TestHistoryViewHolder> {
   private Context context;
   private List<TestHistory> testHistories = new ArrayList<>();

    public TestHistoryAdapter(Context context, List<TestHistory> testHistories) {
        this.context = context;
        this.testHistories = testHistories;
    }

    @NonNull
    @Override
    public TestHistoryAdapter.TestHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new TestHistoryAdapter.TestHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHistoryAdapter.TestHistoryViewHolder holder, int position) {
        TestHistory currentItem = testHistories.get(position);
        holder.tvResult.setText("Số điểm: "+currentItem.getMark());
        String id = StoreUtils.get(context,Contants.id);
        if (currentItem.getIdUser().equals(id)){
            holder.tvResult.setVisibility(View.VISIBLE);
        }
        else {
            holder.tvResult.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (testHistories!=null){
            return testHistories.size();
        }
        return 0;
    }

    public class TestHistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvResult;
        public TestHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvResult = itemView.findViewById(R.id.item_result);
        }
    }
}
