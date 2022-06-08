package com.example.traficapplication.activities.adapters;

import static com.example.traficapplication.R.color.green;
import static com.example.traficapplication.R.color.red;
import static com.example.traficapplication.R.drawable.background;

import android.annotation.SuppressLint;
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
import com.example.traficapplication.activities.models.Question;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {
    private Context context;
    List<Answer> answers ;

    public AnswerAdapter(Context context, List<Answer> answers) {
        this.context = context;
        this.answers = answers;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer, parent, false);
        return new AnswerAdapter.AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        Answer currentItem = answers.get(position);
        holder.ans.setText(currentItem.getTitle());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (currentItem.getTrue() == "0") {
                    holder.ans.setTextColor(red);
                } else{
                    holder.ans.setTextColor(green);
                }
            }
        });

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
    }
}
