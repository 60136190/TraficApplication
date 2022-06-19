package com.example.traficapplication.activities.adapters;

import static com.example.traficapplication.R.drawable.border_green;
import static com.example.traficapplication.R.drawable.border_red;
import static com.example.traficapplication.R.drawable.border_white;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.models.Answer;

import java.util.ArrayList;
import java.util.List;

public class AnswerLearnAdapter extends RecyclerView.Adapter<AnswerLearnAdapter.AnswerViewHolder> {
    private Context context;
    List<Answer> answers = new ArrayList<>();
    private int checkedPosition =0;

    public AnswerLearnAdapter(Context context, List<Answer> answers) {
        this.context = context;
        this.answers = answers;
        notifyDataSetChanged();
    }
    public void SetAnswer(List<Answer> answers){
        this.answers = new ArrayList<>();
        this.answers = answers;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer, parent, false);
        return new AnswerLearnAdapter.AnswerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
       holder.bind(answers.get(position));
    }

    @Override
    public int getItemCount() {
        if (answers != null){
            return answers.size();
        }
        return 0;
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder {
        private TextView ans;
        private ConstraintLayout constraintLayout;
        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            ans = itemView.findViewById(R.id.tv_answer);
            constraintLayout = itemView.findViewById(R.id.parent_answer);
        }
        void bind(final Answer answer){
            ans.setText(String.valueOf(answer.getTitle()));
            ans.setBackgroundResource(border_white);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkedPosition == -1){
                        ans.setBackgroundResource(border_white);
                    }
                    else {
                        if (answer.getTrue().equals("0")){
                            ans.setBackgroundResource(border_red);
                        }
                        else{
                            ans.setBackgroundResource(border_green);
                        }
                    }
                    if (checkedPosition!= getAdapterPosition()){
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }
    }
    public Answer getSelected(){
        if (checkedPosition!=-1){
            return answers.get(checkedPosition);
        }
        return null;
    }
}
