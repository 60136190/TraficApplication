package com.example.traficapplication.activities.adapters;

import android.annotation.SuppressLint;
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
import com.example.traficapplication.activities.activities.SignDetailActivity;
import com.example.traficapplication.activities.models.Sign;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SignAdapter extends RecyclerView.Adapter<SignAdapter.SignViewHolder> {
    List<Sign> signs;
    Context context;

    public SignAdapter(List<Sign> signs, Context context) {
        this.signs = signs;
        this.context = context;
    }

    public List<Sign> getSigns() {
        return signs;
    }

    public void setSigns(List<Sign> signs) {
        this.signs = signs;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public SignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_traffic_sign, parent, false);
        return new SignAdapter.SignViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull SignViewHolder holder, int position) {
        Sign currentItem = signs.get(position);
        String signName = currentItem.getName();
        String url = currentItem.getImage().getUrl();
        Picasso.with(getContext())
                .load(url).fit().centerInside().into(holder.imgSignal);
        holder.nameSignal.setText(signName);
        holder.codeSignal.setText(String.valueOf(currentItem.getCode()));
        holder.detailSignal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SignDetailActivity.class);
                String id = currentItem.getId();
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }
    public void filterListSign(List<Sign> filteredList) {
        signs = filteredList;
        notifyDataSetChanged();
    }
    public class SignViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSignal;
        private TextView nameSignal,detailSignal,codeSignal;
        private ConstraintLayout constraintLayout;
        public SignViewHolder(@NonNull View itemView) {
            super(itemView);
            codeSignal = itemView.findViewById(R.id.tv_signal_code);
            detailSignal = itemView.findViewById(R.id.tv_signal_detail);
            imgSignal = itemView.findViewById(R.id.img_item_signal);
            nameSignal = itemView.findViewById(R.id.tv_signal_name);
            constraintLayout = itemView.findViewById(R.id.item_signal);
        }
    }
}
