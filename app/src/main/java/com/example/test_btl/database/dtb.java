package com.example.test_btl.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.test_btl.model.lich_hom_nay;

public class dtb extends SQLiteOpenHelper {
    //Tên database
    private static String DATABASE_NAME = "ghichu";
    //Bảng môn học
    private static String TABLE_ghichu = "ghichu";
    private static String ID_ghichu = "idsubject";
    private static String SUBJECT_TITLE = "subjecttitle";//tiêu đề
    private static String CREDITS = "credits";//nội dung
    private static String TIME = "time";//ngày
    private static String PLACE = "place";//giờ
    private static int VERSION = 1;

    /*//Bảng sinh viên
    private static String TABLE_STUDENT = "student";
    private static String ID_STUDENT = "idstudent";
    private static String STUDENT_NAME = "sudentname";
    private static String SEX = "sex";
    private static String STUDENT_CODE = "studentcode";
    private static String DATE_OF_BIRTH = "dateofbirth";*/


    //Tạo bảng môn học
    private String SQLQuery = "CREATE TABLE "+ TABLE_ghichu +" ( "+ID_ghichu+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +SUBJECT_TITLE+" TEXT, "
            +CREDITS+" INTEGER, "
            +TIME+" TEXT, "
            + PLACE+" TEXT) ";

   /* //Tạo bảng sinh viên
    private String SQLQuery1 = "CREATE TABLE "+ TABLE_STUDENT +" ( "+ID_STUDENT+" integer primary key AUTOINCREMENT, "
            +STUDENT_NAME+" TEXT, "
            +SEX+" TEXT, "
            +STUDENT_CODE+" TEXT, "
            +DATE_OF_BIRTH+" TEXT, "
            +ID_SUBJECTS+" INTEGER , FOREIGN KEY ( "+ ID_SUBJECTS +" ) REFERENCES "+
            TABLE_SUBJECTS+"("+ID_SUBJECTS+"))";*/

    public dtb(@Nullable Context context) {
        super(context, DATABASE_NAME,null ,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  void Addghichu(lich_hom_nay lhn) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SUBJECT_TITLE,lhn.getTieu_de());
        values.put(CREDITS,lhn.getNoi_dung());
        values.put(TIME,lhn.getNgay());
        values.put(PLACE,lhn.getGio());

        db.insert(TABLE_ghichu,null,values);
        db.close();
    }

    public  boolean updateghichu(lich_hom_nay lhn, int id){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(SUBJECT_TITLE,lhn.getTieu_de());
        values.put(CREDITS,lhn.getNoi_dung());
        values.put(TIME,lhn.getNgay());
        values.put(PLACE,lhn.getGio());

        db.update(TABLE_ghichu,values,ID_ghichu+" = "+id,null);

        return  true;

    }

    public Cursor getData() {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_ghichu,null);

        return cursor;
    }
    public int deleteghichu(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_ghichu,ID_ghichu+" = "+i,null);
        return res;
    }
}
