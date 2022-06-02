package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.activities.CarActivity;
import com.example.traficapplication.activities.activities.DocumentDetailActivity;
import com.example.traficapplication.activities.activities.DocumentsActivity;
import com.example.traficapplication.activities.models.Document;
import com.example.traficapplication.activities.models.Law;

import java.util.ArrayList;
import java.util.List;
public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {
    private Context context;
    private List<Document> documents;
    public DocumentAdapter(Context context, ArrayList<Document> documents) {
        this.context = context;
        this.documents=documents;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_document, parent, false);
        return new DocumentAdapter.DocumentViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        Document d = documents.get(position);
        int a = position;
        if (d == null) {
            return;
        }
        holder.imgDocument.setImageResource(d.getImgDocument());
        holder.detailDocument.setText(d.getDetailDocument());
        holder.tittleDocument.setText(d.getTittleDocument());
        holder.seekBarNumDocument.setText(String.valueOf(d.getSeekBarNum()));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DocumentDetailActivity.class);
                intent.putExtra("lawPos",String.valueOf(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        if (documents != null) {
            return documents.size();
        }
        return 0;
    }
    public class DocumentViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgDocument;
        private TextView tittleDocument;
        private  TextView detailDocument;
        private TextView seekBarNumDocument;
        private SeekBar seekBarDocument;
        private ConstraintLayout constraintLayout;
        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDocument = itemView.findViewById(R.id.img_item_document);
            seekBarDocument=itemView.findViewById(R.id.sb_item_document);
            detailDocument = itemView.findViewById(R.id.tv_detail_item_document);
            tittleDocument = itemView.findViewById(R.id.tv_tittle_item_document);
            constraintLayout = itemView.findViewById(R.id.item_document);
            seekBarNumDocument = itemView.findViewById(R.id.tv_seekBarNum_item_document);
        }
    }
}
