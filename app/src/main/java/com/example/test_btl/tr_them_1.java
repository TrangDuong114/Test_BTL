package com.example.test_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class tr_them_1 extends AppCompatActivity {
    //khai báo cho giờ
    Button btntime;
    TextView txttime;
    final Calendar c = Calendar.getInstance();//lấy ra được ngày giờ hiện tại
    TimePickerDialog timePickerDialog;
    int tH, tM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_them1);
        getView();
    }
    private void getView() {
        btntime = findViewById(R.id.btn_time);
        txttime = findViewById(R.id.txt_time);

        btntime.setOnClickListener(this::onClick_gio);
    }

    //Xử lý sự kiện cho nút giờ
    public  void onClick_gio(View view) {
        switch (view.getId()){
            case R.id.btn_time:
                //lấy ra ngày tháng năm hiện tại
                tH = c.get(Calendar.HOUR);
                tM = c.get(Calendar.MINUTE);
                //xử lý sự kiện trên timepickerDialog
                timePickerDialog = new TimePickerDialog(tr_them_1.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int h, int m) {
                                txttime.setText(h +":" +m);

                            }
                        },tH, tM,false );
                timePickerDialog.show();
                break;
            default:
                break;

        }
    }
}