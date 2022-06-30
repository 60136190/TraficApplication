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
import com.example.traficapplication.activities.activities.CarActivity;
import com.example.traficapplication.activities.models.LawCategory;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.LawViewHolder> {
    private Context context;
    private List<LawCategory> lawCategory;

    public CarAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<LawCategory> lawCategory) {
        this.lawCategory = lawCategory;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CarAdapter.LawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_law_category, parent, false);
        return new CarAdapter.LawViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CarAdapter.LawViewHolder holder, int position) {
        LawCategory l = lawCategory.get(position);
        int a = position;
        if (l == null) {
            return;
        }
        holder.imgLaw.setImageResource(l.getImgLaw());
        holder.typeLaw.setText(l.getTypeLaw());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CarActivity.class);
                intent.putExtra("lawPos",String.valueOf(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        if (lawCategory != null) {
            return lawCategory.size();
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
