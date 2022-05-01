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
import com.example.traficapplication.activities.activities.DetailSignalActivity;
import com.example.traficapplication.activities.activities.TestActivity;
import com.example.traficapplication.activities.models.Function;
import com.example.traficapplication.activities.models.Signal;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignalAdapter extends RecyclerView.Adapter<SignalAdapter.SignalViewHolder>{
    private Context signalContext;
    private List<Signal> signal;

    public SignalAdapter(Context signalContext, List<Signal> signal) {
        this.signalContext = signalContext;
        this.signal = signal;
    }

    @NonNull
    @Override
    public SignalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_traffic_signal, parent, false);
        return new SignalAdapter.SignalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SignalViewHolder holder, int position) {
        Signal sign = signal.get(position);
        int a = position;
        if (sign == null) {
            return;
        }
        holder.imgSignal.setImageResource(sign.getSignalImg());
        holder.nameSignal.setText(sign.getSignalName());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int img = sign.getSignalImg();
                String name = sign.getSignalName();
                String detail = sign.getSignalDetail();
                Intent intent = new Intent(signalContext, DetailSignalActivity.class);
                intent.putExtra("img",img);
                intent.putExtra("name",name);
                intent.putExtra("detail",detail);
                signalContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (signal != null) {
            return signal.size();
        }
        return 0;
    }


    public class SignalViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imgSignal;
        private TextView nameSignal;
        private ConstraintLayout constraintLayout;
        public SignalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSignal = itemView.findViewById(R.id.img_item_signal);
            nameSignal = itemView.findViewById(R.id.tv_signal_name);
            constraintLayout = itemView.findViewById(R.id.item_signal);
        }
    }
}
