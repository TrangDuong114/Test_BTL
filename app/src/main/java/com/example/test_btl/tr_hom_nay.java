package com.example.test_btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.example.test_btl.adpter.adapterLichhn;
import com.example.test_btl.database.dtb;
import com.example.test_btl.model.lich_hom_nay;

import java.util.ArrayList;

public class tr_hom_nay extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewLichhn;
    ArrayList<lich_hom_nay> ARLlnh;
    com.example.test_btl.database.dtb dtb;
    adapterLichhn adt_lhn;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_hom_nay);

        toolbar = findViewById(R.id.tbLhn);
        listViewLichhn = findViewById(R.id.lsv_hom_nay);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dtb = new dtb(this);

        ARLlnh = new ArrayList<>();
        //Phần này thêm vào thì khi click vào nút thiết lập lịch hiện file đã dừng lại

        Cursor cursor = dtb.getData();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String td = cursor.getString(1);
            String nd = cursor.getString(2);
            String ng = cursor.getString(3);
            String gio = cursor.getString(4);
            ARLlnh.add(new lich_hom_nay(id, td, nd, ng, gio));
        }
        adt_lhn = new adapterLichhn(tr_hom_nay.this,ARLlnh);
        listViewLichhn.setAdapter(adt_lhn);
        cursor.moveToFirst();
        cursor.close();
    }
    //thêm 1 menu là add vào toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd,menu);
        return true;

    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Nếu click vào add
        switch (item.getItemId()){

            case R.id.menuadd:
                Intent intent1 = new Intent(tr_hom_nay.this,tr_hom_nay_2.class);
                startActivity(intent1);
                break;
                //Nếu click vào nút còn lại là nút back thì quay lại main
            default:
                Intent intent = new Intent(tr_hom_nay.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //nếu clcik back ở màn hình sẽ quay lại main activity
    @Override
    public void onBackPressed() {
        count++;
        if (count>=1){
            Intent intent = new Intent(tr_hom_nay.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //phương thức hiển thị thông tin
    public void thong_tin(final int pos) {
        Cursor cursor = dtb.getData();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            if (id == pos){
                Intent intent = new Intent(tr_hom_nay.this,tr_thong_tin.class);

                intent.putExtra("id",id);
                String td = cursor.getString(1);
                String nd = cursor.getString(2);
                String ng = cursor.getString(3);
                String gio = cursor.getString(4);

                intent.putExtra("tieu de",td);
                intent.putExtra("noi dung",nd);
                intent.putExtra("ngay",ng);
                intent.putExtra("gio",gio);

                startActivity(intent);
            }
        }
    }

    //Phương thức xóa
    public void xoa(final int p) {
        //đối tượng cửa sổ
        Dialog dialog = new Dialog(this);
        //nạp layout vào dialog
        dialog.setContentView(R.layout.dialogxoa);

        dialog.setCanceledOnTouchOutside(false);

        Button btnco = dialog.findViewById(R.id.btnco_xoa);
        Button btnko = dialog.findViewById(R.id.btnko_xoa);

        btnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // dtb = new dtb(tr_hom_nay.this);
                //xóa thông tin trong csdl
                dtb.deleteghichu(p);

                //Cập nhật lại
                Intent intent = new Intent(tr_hom_nay.this,tr_hom_nay.class);
                startActivity(intent);
            }
        });
        //đóng dialog
        btnko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    //Phương thức sửa
    public void sua(final int pos){
        Cursor cursor = dtb.getData();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            if (id ==pos){
                Intent intent = new Intent(tr_hom_nay.this,tr_sua_tt.class);

                String td = cursor.getString(1);
                String nd = cursor.getString(2);
                String ng = cursor.getString(3);
                String gio = cursor.getString(4);

                //Gửi dưc liệu qua tr_sua_tt
                intent.putExtra("id",id);
                intent.putExtra("tieu de",td);
                intent.putExtra("noi dung",nd);
                intent.putExtra("ngay",ng);
                intent.putExtra("gio",gio);

                startActivity(intent);
            }
        }
    }
}