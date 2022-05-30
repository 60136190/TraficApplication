package com.example.traficapplication.activities.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.MainActivity;
import com.example.traficapplication.activities.activities.TestDoingActivity;
import com.example.traficapplication.activities.auth.LoginActivity;
import com.example.traficapplication.activities.auth.RegisterActivity;
import com.example.traficapplication.activities.models.Test;
import com.example.traficapplication.activities.sliders.FirstActivity;
import com.example.traficapplication.activities.sliders.SlideActivity;
import com.example.traficapplication.activities.utils.Contants;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private Context context;
    private List<Test> tests;


    public TestAdapter(Context context, ArrayList<Test> tests) {
        this.context = context;
        this.tests=tests;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TestAdapter.TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new TestAdapter.TestViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TestAdapter.TestViewHolder holder, int position) {
        Test t = tests.get(position);
        if (t == null) {
            return;
        }
        holder.tittleTest.setText(t.getTittleTest());
        holder.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                if (sharedPreferences.getString(Contants.email, "").isEmpty()){
                    openDialog(Gravity.BOTTOM);
                }else{
                    Intent intent = new Intent(context, TestDoingActivity.class);
                    intent.putExtra("numTest",String.valueOf(t.getTittleTest()));
                    context.startActivity(intent);
                }

            }
            private void openDialog(int gravity){

                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_user_back);

                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams windowAtribute = window.getAttributes();
                window.setAttributes(windowAtribute);

                TextView tvMessage = dialog.findViewById(R.id.tv_warning_user);
                Button btnLogin = dialog.findViewById(R.id.btn_back_user);
                Button btnCreate = dialog.findViewById(R.id.btn_exit_user);
                btnLogin.setText(R.string.Login);
                btnCreate.setText(R.string.Create);
                tvMessage.setText(R.string.not_login);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,LoginActivity.class);
                        context.startActivity(intent);

                    }
                });
                btnCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, RegisterActivity.class);
                        context.startActivity(intent);

                    }
                });
                dialog.show();
            }
        });

    }
    @Override
    public int getItemCount() {
        if (tests != null) {
            return tests.size();
        }
        return 0;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgTest;
        private TextView tittleTest;
        private  TextView detailTest;
        private Button btnTest;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTest = itemView.findViewById(R.id.img_item_test);
            detailTest = itemView.findViewById(R.id.tv_detail_item_test);
            tittleTest = itemView.findViewById(R.id.tv_tittle_item_test);
            btnTest = itemView.findViewById(R.id.btn_test);
        }
    }
}