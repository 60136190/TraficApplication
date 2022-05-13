package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.traficapplication.R;

public class TestDoingActivity extends AppCompatActivity {

    private long backPressTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_doing);

    }

    @Override
    public void onBackPressed() {
        openDialog(Gravity.BOTTOM);
}

    private void openDialog(int gravity){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_test_back);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);

        // show dialog
        Button btnContinue = dialog.findViewById(R.id.btn_continue_test);
        Button btnExit = dialog.findViewById(R.id.btn_exit_test);
        TextView tvTestTittle = dialog.findViewById(R.id.tv_testing);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        tvTestTittle.setText(String.valueOf(b.get("numTest")));
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestDoingActivity.this.finish();
            }
        });
        dialog.show();
    }



}