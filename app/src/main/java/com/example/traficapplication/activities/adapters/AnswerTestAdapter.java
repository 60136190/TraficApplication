package com.example.traficapplication.activities.adapters;

import static com.example.traficapplication.R.color.dark_white;
import static com.example.traficapplication.R.drawable.border_blue;
import static com.example.traficapplication.R.drawable.border_green;
import static com.example.traficapplication.R.drawable.border_red;
import static com.example.traficapplication.R.drawable.border_white;
import static com.example.traficapplication.activities.utils.Contants.listId;

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
import com.example.traficapplication.activities.models.AnswerAll;
import com.example.traficapplication.activities.utils.StoreUtils;

import java.util.ArrayList;
import java.util.List;

public class AnswerTestAdapter extends RecyclerView.Adapter<AnswerTestAdapter.AnswerViewHolder> {
    private Context context;
    List<AnswerAll> answers = new ArrayList<>();

    private int checkedPosition =0;

    public AnswerTestAdapter(Context context, List<AnswerAll> answers) {
        this.context = context;
        this.answers = answers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnswerTestAdapter.AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer, parent, false);
        return new AnswerTestAdapter.AnswerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AnswerTestAdapter.AnswerViewHolder holder, int position) {
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
        void bind(final AnswerAll answer){
            ans.setText(String.valueOf(answer.getTitle()));
            ans.setBackgroundResource(border_white);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = String.valueOf(answer.getId());

                    if (checkedPosition == -1){
                        ans.setBackgroundResource(border_white);
                    }
                    else {
                        ans.setBackgroundResource(border_blue);
                        if (answer.getTrue().equals("1")){
                            ans.setBackgroundResource(border_green);
                            int n = listId.size();
                            if (n==0){
                                listId.add(id);
                                StoreUtils.writeListInPref(context,listId,"listID");
                            }
                            else {
                                int k =0;
                                for (int i = 0;i<n;i++){
                                    if (id!= listId.get(i)){
                                                k= k+1;
                                    }
                                }
                                if (k==n){
                                    listId.add(id);
                                    StoreUtils.writeListInPref(context,listId,"listID");
                                }
                            }

                        }
                        else {
                            ans.setBackgroundResource(border_red);
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
}
