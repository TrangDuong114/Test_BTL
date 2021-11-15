package com.example.test_btl.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.test_btl.R;
import com.example.test_btl.model.lich_hom_nay;
import com.example.test_btl.tr_hom_nay;

import java.util.ArrayList;

public class adapterLichhn extends BaseAdapter {

    private tr_hom_nay context;

    private ArrayList<lich_hom_nay>  ArrayListLichhn;

    public adapterLichhn(tr_hom_nay context, ArrayList<lich_hom_nay> arrayListLichhn) {
        this.context = context;
        ArrayListLichhn = arrayListLichhn;
    }

    @Override
    public int getCount() {
        return ArrayListLichhn.size();
    }

    @Override
    public Object getItem(int i) {
        return ArrayListLichhn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.listhn,null);

        TextView txt_tieu_de = view.findViewById(R.id.txt_td);
        TextView txt_cre_nhn = view.findViewById(R.id.txt_cre_nhn);
        ImageButton btnhien = view.findViewById(R.id.btn_hien);
        ImageButton btnhsua = view.findViewById(R.id.btn_sua);
        ImageButton btnxoa = view.findViewById(R.id.btn_xoa);


        lich_hom_nay lhn = ArrayListLichhn.get(i);

        txt_cre_nhn.setText(lhn.getNgay());
        txt_tieu_de.setText(lhn.getTieu_de());

        int id = lhn.getId();

        //click xem thông tin
        btnhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.thong_tin(id);

            }
        });

        //click sửa
        btnhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.sua(id);
            }
        });

        //click xóa
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gọi tới phương thức xoa ở tr_hom_nay
                context.xoa(id);
            }
        });

        return view;
    }
}
