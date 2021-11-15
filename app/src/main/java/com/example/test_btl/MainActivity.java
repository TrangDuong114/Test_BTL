package com.example.test_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btntao, btnls, btnexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btntao = findViewById(R.id.btn_tao);
        btnexit = findViewById(R.id.btn_exit);
        btnls = findViewById(R.id.btn_ls);

        //Click tạo
        btntao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chuyển qua tr_hom_nay
                Intent intent = new Intent(MainActivity.this, tr_hom_nay.class);
                startActivity(intent);
            }
        });

        //Click Lịch sử
        btnls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chuyển qua activity tr_lich_su
                Intent intent = new Intent(MainActivity.this, tr_lich_su.class);
                startActivity(intent);
            }
        });

        //Click Thoát
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogThoat();
            }

        });
    }

    private void DialogThoat() {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.exit);
        //Tắt click ngoài là tắt
        dialog.setCanceledOnTouchOutside(false);
        Button btnco = dialog.findViewById(R.id.btn_co);
        Button btnko = dialog.findViewById(R.id.btn_ko);

        btnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                //Thoát
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });

        //Nếu clik không thì đóng cửa số
        btnko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        //show dialog
        dialog.show();

    }




}