package com.example.test_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_btl.database.dtb;
import com.example.test_btl.model.lich_hom_nay;


public class tr_hom_nay_2 extends AppCompatActivity {

    Button btnadd ;
    EditText edtd, ednd, ednhn, edtg;
    com.example.test_btl.database.dtb dtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_hom_nay2);

        btnadd = findViewById(R.id.btn_add);
        edtd = findViewById(R.id.etxt_td);
        ednd = findViewById(R.id.etxt_nd);
        ednhn = findViewById(R.id.etxt_nhn);
        edtg = findViewById(R.id.etxt_tg);

        dtb = new dtb(this);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAdd();
            }
        });
    }

    private void DialogAdd() {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialoge_them);

        dialog.setCanceledOnTouchOutside(false);

        Button btnco = dialog.findViewById(R.id.btn_co);
        Button btnko = dialog.findViewById(R.id.btn_ko);

        btnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tieu_de = edtd.getText().toString().trim();
                String noi_dung = ednd.getText().toString().trim();
                String nhac_nho = ednhn.getText().toString().trim();
                String thoi_gian = edtg.getText().toString().trim();

                if (tieu_de.equals("")|| noi_dung.equals("")|| nhac_nho.equals("")||thoi_gian.equals("")){
                    Toast.makeText(tr_hom_nay_2.this,"Bạn điền thiếu thông tin",Toast.LENGTH_LONG).show();
                }
                else {
                    lich_hom_nay lhn = taonoidung();

                    dtb.Addghichu(lhn);

                    Intent intent = new Intent(tr_hom_nay_2.this,tr_hom_nay.class);
                    startActivity(intent);

                    Toast.makeText(tr_hom_nay_2.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
         dialog.show();

    }

    private lich_hom_nay taonoidung() {
        String tieu_de = edtd.getText().toString().trim();
        String noi_dung = ednd.getText().toString().trim();
        String nhac_nho = ednhn.getText().toString().trim();
        String thoi_gian = edtg.getText().toString().trim();

        lich_hom_nay lhn = new lich_hom_nay(tieu_de,noi_dung,nhac_nho,thoi_gian);
        return lhn;
    }


}