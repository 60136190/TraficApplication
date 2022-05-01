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
import com.example.traficapplication.activities.activities.DocumentsActivity;
import com.example.traficapplication.activities.activities.LawActivity;
import com.example.traficapplication.activities.activities.NoteActivity;
import com.example.traficapplication.activities.activities.SignalActivity;
import com.example.traficapplication.activities.activities.TestActivity;
import com.example.traficapplication.activities.activities.TrickActivity;
import com.example.traficapplication.activities.models.Function;
import com.example.traficapplication.activities.models.Law;

import java.util.List;

public class LawAdapter extends RecyclerView.Adapter<LawAdapter.LawViewHolder> {
    private Context context;
    private List<Law> law;

    public LawAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Law> law) {
        this.law = law;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public LawAdapter.LawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_view, parent, false);
        return new LawAdapter.LawViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LawAdapter.LawViewHolder holder, int position) {
        Law l = law.get(position);
        int a = position;
        if (l == null) {
            return;
        }
        holder.imgLaw.setImageResource(l.getImgLaw());
        holder.typeLaw.setText(l.getTypeLaw());
//adknasldnaldnmasdmalmdasdasdasdasd
//        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (a) {
//                    case 0:
//                        Intent intent = new Intent(context, TestActivity.class);
//                        context.startActivity(intent);
//                        break;
//                    case 1:
//                        Intent intent1 = new Intent(context, DocumentsActivity.class);
//                        context.startActivity(intent1);
//                        break;
//                    case 2:
//                        Intent intent2 = new Intent(context, SignalActivity.class);
//                        context.startActivity(intent2);
//                        break;
//                    case 3:
//                        Intent intent3 = new Intent(context, TrickActivity.class);
//                        context.startActivity(intent3);
//                        break;
//                    case 4:
//                        Intent intent4 = new Intent(context, LawActivity.class);
//                        context.startActivity(intent4);
//                        break;
//                    case 5:
//                        Intent intent5 = new Intent(context, NoteActivity.class);
//                        context.startActivity(intent5);
//                        break;
//                }
//
//            }
//        });
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
            imgLaw = itemView.findViewById(R.id.img_item_grid_view);
            typeLaw = itemView.findViewById(R.id.tv_title_item_grid_view);
            constraintLayout = itemView.findViewById(R.id.item_function);
        }
    }
}
