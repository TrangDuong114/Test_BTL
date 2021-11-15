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

public class tr_sua_tt extends AppCompatActivity {

    EditText edstd, edsnd, edsng, edsgio;
    Button btnsua;

    com.example.test_btl.database.dtb dtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_sua_tt);

        edstd = findViewById(R.id.etxttd_sua);
        edsnd = findViewById(R.id.etxtnd_sua);
        edsng = findViewById(R.id.etxtnhn_sua);
        edsgio = findViewById(R.id.etxttg_sua);
        btnsua = findViewById(R.id.btnsua_tt);

        //Lấy dữ liệu
        Intent intent = getIntent();

        int id = intent.getIntExtra("id",0);
        String tieude = intent.getStringExtra("tieu de");
        String noidung = intent.getStringExtra("noi dung");
        String ngay = intent.getStringExtra("ngay");
        String gio = intent.getStringExtra("gio");

        edstd.setText(tieude);
        edsnd.setText(noidung);
        edsng.setText(ngay);
        edsgio.setText(gio);

        dtb = new dtb(this);

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialogsua(id);
            }
        });

    }

    private void Dialogsua(int id) {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogsua);

        dialog.setCanceledOnTouchOutside(false);

        Button btn_co = dialog.findViewById(R.id.btnco_sua);
        Button btnko = dialog.findViewById(R.id.btnko_sua);

        btn_co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String td = edstd.getText().toString().trim();
                String nd = edsnd.getText().toString().trim();
                String ng = edsng.getText().toString().trim();
                String gio = edsgio.getText().toString().trim();

                if(td.equals("")|| nd.equals("")|| ng.equals("")|| gio.equals("")){
                    Toast.makeText(tr_sua_tt.this,"Bạn điền thiếu",Toast.LENGTH_LONG).show();

                }
                else {
                    lich_hom_nay lhn = suatt();

                    dtb.updateghichu(lhn, id);

                    Intent intent = new Intent(tr_sua_tt.this,tr_hom_nay.class);
                    startActivity(intent);
                    Toast.makeText(tr_sua_tt.this,"sửa thành công",Toast.LENGTH_LONG).show();

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

    //Lưu trứ giữ liệu
   private lich_hom_nay suatt(){
       String td = edstd.getText().toString().trim();
       String nd = edsnd.getText().toString().trim();
       String ng = edsng.getText().toString().trim();
       String gio = edsgio.getText().toString().trim();

       lich_hom_nay lhn = new lich_hom_nay(td, nd, ng, gio);
       return lhn;
   }
}