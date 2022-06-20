package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.traficapplication.R;

import org.w3c.dom.Text;

public class NoteActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        initUI();
        setText();

    }

    private void initUI() {
        tv = findViewById(R.id.tv_note);
    }

    private void setText() {
        tv.setText("- Đây là ứng dụng hỗ trợ học và ôn thi bằng lái xe." +
                "\n- Ứng dụng này không có tác dụng thay thế lớp học trực tiếp cùng với các bằng cấp liên quan." +
                "\n- Đây là ứng dụng thử nghiệm, có thể xảy ra một số lỗi trong quá trình sử dụng." +
                "\n- Xin cảm ơn bạn đã sử dụng và chúc bạn may mắn.");

    }
}