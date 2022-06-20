package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.models.Question;
import com.squareup.picasso.Picasso;

import java.util.List;

 public class QuestionLearnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    List<Question> questions;

    public QuestionLearnAdapter(Context context, List<Question> questions) {
        this.context = context;
        this.questions = questions;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question,parent,false);
        return new QuestionLearnAdapter.QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Question currentItem = questions.get(position);
        String nullUrl ="";
        if (currentItem.getImage().getUrl().equals(nullUrl)){
            ((QuestionViewHolder)holder).img.setVisibility(View.GONE);
        }
        else {
            ((QuestionViewHolder)holder).img.setVisibility(View.VISIBLE);
            String url = currentItem.getImage().getUrl();
            Picasso.with(getContext())
                    .load(url).fit().centerInside().into(((QuestionViewHolder)holder).img);
        }
        ((QuestionViewHolder)holder).itemTitle.setText(currentItem.getQuestion());
        ((QuestionViewHolder)holder).answer.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        ((QuestionViewHolder)holder).answer.setItemAnimator(new DefaultItemAnimator());
        AnswerLearnAdapter answerLearnAdapter = new AnswerLearnAdapter( context,currentItem.getAnswer());
        ((QuestionViewHolder)holder).answer.setAdapter(answerLearnAdapter);
    }
    @Override
    public int getItemCount() {
        if (questions != null){
            return questions.size();
        }
        return 0;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private RecyclerView answer;
        private ImageView img;
        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_quest);
            itemTitle = itemView.findViewById(R.id.tv_quest);
            answer = itemView.findViewById(R.id.answer);
        }
    }


}
