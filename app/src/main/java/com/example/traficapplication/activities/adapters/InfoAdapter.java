package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.activities.DetailSignalActivity;
import com.example.traficapplication.activities.auth.UserActivity;
import com.example.traficapplication.activities.models.Info;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    ArrayList<Info> info;
    Context context;

    public InfoAdapter(ArrayList<Info> info, Context context) {
        this.info = info;
        this.context = context;
        notifyDataSetChanged();
    }

    public ArrayList<Info> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<Info> info) {
        this.info = info;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_traffic_signal, parent, false);
        return new InfoAdapter.InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        Info currentItem = info.get(position);
        String tensp = currentItem.getTensp();
        String url = currentItem.getUrl();
        Picasso.with(getContext())
                .load(url).fit().centerInside().into(holder.imgSignal);
        holder.nameSignal.setText(tensp);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailSignalActivity.class);
                intent.putExtra("id",currentItem.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imgSignal;
        private TextView nameSignal;
        private ConstraintLayout constraintLayout;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSignal = itemView.findViewById(R.id.img_item_signal);
            nameSignal = itemView.findViewById(R.id.tv_signal_name);
            constraintLayout = itemView.findViewById(R.id.item_signal);
        }
    }
}
