package com.example.test_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class tr_thong_tin extends AppCompatActivity {

    TextView edtd, ednd, edng, edgio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_thong_tin);

        edtd = findViewById(R.id.txttd_tt);
        ednd = findViewById(R.id.txtnd_tt);
        edng = findViewById(R.id.txtng_tt);
        edgio = findViewById(R.id.txtgio_tt);

        //láy giữu liệu
        Intent intent = getIntent();
        String tieude = intent.getStringExtra("tieu de");
        String noidung = intent.getStringExtra("noi dung");
        String ngay = intent.getStringExtra("ngay");
        String gio = intent.getStringExtra("gio");

        //gán giá trị lên
        edtd.setText(tieude);
        ednd.setText(noidung);
        edng.setText(ngay);
        edgio.setText(gio+"");
    }
}