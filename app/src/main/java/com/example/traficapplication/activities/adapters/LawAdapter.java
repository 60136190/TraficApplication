package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.models.Law;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LawAdapter extends RecyclerView.Adapter<LawAdapter.ItemLawViewHolder> {
    private Context itemLawContext;
    private List<Law> law;

    public LawAdapter(Context itemLawContext, List<Law> law) {
        this.itemLawContext = itemLawContext;
        this.law = law;
    }

    @NonNull
    @Override
    public LawAdapter.ItemLawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_law, parent, false);
        return new LawAdapter.ItemLawViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LawAdapter.ItemLawViewHolder holder, int position) {
        Law itemL = law.get(position);
        int a = position;
        if (itemL == null) {
            return;
        }
//        holder.imgItemLaw.setImageResource(itemL.getImgItemLaw());
        holder.tittleItemLaw.setText(itemL.getTittleItemLaw());
        holder.contentItemLaw.setText(itemL.getContentItemLaw());
//        holder.detailItemLaw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int img = itemL.getImgItemLaw();
//                String tittle = itemL.getTittleItemLaw();
//                String content = itemL.getContentItemLaw();
//                String detail = itemL.getDetailItemLaw();
//                Intent intent = new Intent(itemLawContext, LawDetailListActivity.class);
//                intent.putExtra("img",img);
//                intent.putExtra("tittle",tittle);
//                intent.putExtra("content",content);
//                intent.putExtra("detail",detail);
//                itemLawContext.startActivity(intent);
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


    public class ItemLawViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imgItemLaw;
        private TextView tittleItemLaw,contentItemLaw,detailItemLaw;
        private ConstraintLayout constraintLayout;
        public ItemLawViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgItemLaw = itemView.findViewById(R.id.img_item_list_law);
            tittleItemLaw = itemView.findViewById(R.id.tv_law_name);
            contentItemLaw = itemView.findViewById(R.id.tv_law_content);
//            detailItemLaw = itemView.findViewById(R.id.tv_law_detail);
            constraintLayout = itemView.findViewById(R.id.item_list_law);
        }
    }

}
