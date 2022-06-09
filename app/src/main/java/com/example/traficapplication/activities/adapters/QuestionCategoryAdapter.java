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
import com.example.traficapplication.activities.activities.QuestionActivity;
import com.example.traficapplication.activities.models.QuestionCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuestionCategoryAdapter extends RecyclerView.Adapter<QuestionCategoryAdapter.QuestionCategoryViewHolder> {
    List<QuestionCategory> questionCategories;
    private Context context;

    public QuestionCategoryAdapter(List<QuestionCategory> questionCategories, Context context) {
        this.questionCategories = questionCategories;
        this.context = context;
    }

    public List<QuestionCategory> getQuestionCategories() {
        return questionCategories;
    }

    public void setQuestionCategories(List<QuestionCategory> questionCategories) {
        this.questionCategories = questionCategories;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public QuestionCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question_category, parent, false);
        return new QuestionCategoryAdapter.QuestionCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionCategoryViewHolder holder, int position) {
            QuestionCategory currentItem = questionCategories.get(position);
        String url = currentItem.getImage().getUrl();
        Picasso.with(getContext())
                .load(url).fit().centerInside().into(holder.imgDocument);
//        holder.numQuest.setText(currentItem.ge);
        holder.tittleDocument.setText(currentItem.getName());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,QuestionActivity.class);
                intent.putExtra("id",currentItem.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (questionCategories != null) {
            return questionCategories.size();
        }
        return 0;
    }


    public class QuestionCategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgDocument;
        private TextView tittleDocument;
        private  TextView numQuest;
        private TextView seekBarNumDocument;
        private SeekBar seekBarDocument;
        private ConstraintLayout constraintLayout;
        public QuestionCategoryViewHolder(@NonNull View itemView) {
                super(itemView);
                imgDocument = itemView.findViewById(R.id.img_item_document);
//                seekBarDocument=itemView.findViewById(R.id.sb_item_document);
            numQuest = itemView.findViewById(R.id.tv_number_quest);
                tittleDocument = itemView.findViewById(R.id.tv_tittle_item_document);
                constraintLayout = itemView.findViewById(R.id.item_document);
//                seekBarNumDocument = itemView.findViewById(R.id.tv_seekBarNum_item_document);
        }


    }


}
