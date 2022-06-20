package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.models.Trick;

import java.util.ArrayList;
import java.util.List;

public class TrickAdapter extends RecyclerView.Adapter<TrickAdapter.TrickViewHolder> {

    private Context context;
    private List<Trick> tricks;


    public TrickAdapter(Context context, ArrayList<Trick> tricks) {
        this.context = context;
        this.tricks=tricks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrickAdapter.TrickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trick, parent, false);
        return new TrickAdapter.TrickViewHolder(view);
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onBindViewHolder(@NonNull TrickAdapter.TrickViewHolder holder, int position) {
        Trick t = tricks.get(position);
        int a = position;
        if (t == null) {
            return;
        }

        holder.tittleTrick.setText(t.getTittleTrick());
        holder.detailTrick.setText(t.getDetailTrick());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.detailTrick.getVisibility() == View.VISIBLE)
                {
//                    holder.imgDown.setRotation(180);
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    holder.imgDown.startAnimation(rotate);
                    holder.detailTrick.setVisibility(View.GONE);
                }
                else
                {
                    RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    holder.imgDown.startAnimation(rotate);
                    holder.detailTrick.setVisibility(View.VISIBLE);

                }
            }
        });



    }

    @Override
    public int getItemCount() {
        if (tricks != null) {
            return tricks.size();
        }
        return 0;
    }

    public class TrickViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgDown;
        private TextView tittleTrick;
        private  TextView detailTrick;
        private ConstraintLayout constraintLayout;

        public TrickViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDown = itemView.findViewById(R.id.arrow_down);
            detailTrick = itemView.findViewById(R.id.tv_detail_item_trick);
            tittleTrick = itemView.findViewById(R.id.tv_tittle_item_trick);
            constraintLayout = itemView.findViewById(R.id.item_trick);

        }
    }

}
