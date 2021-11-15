package com.example.test_btl.model;

public class lich_hom_nay {
    //Các biến

    private int id;

    private String tieu_de;

    private String noi_dung;

    private String ngay;

    private String gio;


    public lich_hom_nay(String tieu_de, String noi_dung, String ngay, String gio) {
        this.tieu_de = tieu_de;
        this.noi_dung = noi_dung;
        this.ngay = ngay;
        this.gio = gio;
    }

    public lich_hom_nay(int id, String tieu_de, String noi_dung, String ngay, String gio) {
        this.id = id;
        this.tieu_de = tieu_de;
        this.noi_dung = noi_dung;
        this.ngay = ngay;
        this.gio = gio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieu_de() {
        return tieu_de;
    }

    public void setTieu_de(String tieu_de) {
        this.tieu_de = tieu_de;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String nhac_nho) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setThoi_gian(String thoi_gian) {
        this.gio = gio;
    }
}
