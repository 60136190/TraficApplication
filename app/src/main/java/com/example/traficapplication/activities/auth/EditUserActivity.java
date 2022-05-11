package com.example.traficapplication.activities.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.activities.DoingTestActivity;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gun0912.tedbottompicker.TedBottomPicker;
import gun0912.tedbottompicker.TedBottomPicker.Builder;
import gun0912.tedbottompicker.TedBottomSheetDialogFragment;

public class EditUserActivity extends AppCompatActivity {

    private CircleImageView avt;
    private ImageView edtAvt;
    private TextView user,email,phoneNum,address,gender;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        initUi();
        getInfo();
        changeAvt();
        save();


    }

    private void changeAvt() {
    }



    @Override
    public void onBackPressed() {
        openDialog(Gravity.BOTTOM);
    }

    private void openDialog(int gravity){

        final Dialog dialog = new Dialog(this);
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

        // show dialog
        Button btnContinue = dialog.findViewById(R.id.btn_back_user);
        Button btnExit = dialog.findViewById(R.id.btn_exit_user);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditUserActivity.this.finish();
            }
        });
        dialog.show();
    }
    private void getInfo() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if(getIntent().hasExtra("byteArray")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            avt.setImageBitmap(bitmap);
        }
//        user.setText(String.valueOf(b.get("user")));
//        email.setText(String.valueOf(b.get("mail")));
//        phoneNum.setText(String.valueOf(b.get("phone")));
//        address.setText(String.valueOf(b.get("add")));
//        gender.setText(String.valueOf(b.get("gender")));
    }

    private void save() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initUi() {
        avt = findViewById(R.id.img_edit_user);
        user = findViewById(R.id.edt_user);
        email = findViewById(R.id.edt_mail);
        phoneNum = findViewById(R.id.edt_phoneNum);
        address = findViewById(R.id.edt_add);
        gender = findViewById(R.id.edt_gender);
        edtAvt = findViewById(R.id.img_edit_avt);
        btnSave = findViewById(R.id.btn_save_edit);
    }

}