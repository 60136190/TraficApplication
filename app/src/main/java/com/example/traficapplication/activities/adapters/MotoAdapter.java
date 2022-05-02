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
import com.example.traficapplication.activities.activities.DetailItemActivity;
import com.example.traficapplication.activities.activities.ListLawActivity;
import com.example.traficapplication.activities.models.Law;

import java.util.List;

public class MotoAdapter extends RecyclerView.Adapter<MotoAdapter.LawViewHolder> {
    private Context context;
    private List<Law> law;

    public MotoAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Law> law) {
        this.law = law;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MotoAdapter.LawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_law, parent, false);
        return new MotoAdapter.LawViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MotoAdapter.LawViewHolder holder, int position) {
        Law l = law.get(position);
        int a = position;
        if (l == null) {
            return;
        }
        holder.imgLaw.setImageResource(l.getImgLaw());
        holder.typeLaw.setText(l.getTypeLaw());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListLawActivity.class);
                intent.putExtra("detail","Xe may");
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        if (law != null) {
            return law.size();
        }
        return 0;
    }
    public class LawViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgLaw;
        private TextView typeLaw;
        private ConstraintLayout constraintLayout;
        public LawViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLaw = itemView.findViewById(R.id.img_item_type_law);
            typeLaw = itemView.findViewById(R.id.tv_title_item_type_law);
            constraintLayout = itemView.findViewById(R.id.item_type_law);
        }
    }

}
