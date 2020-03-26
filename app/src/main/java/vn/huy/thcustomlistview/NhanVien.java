package vn.huy.thcustomlistview;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String ma;
    private String ten;
    private boolean isFemale;
    private boolean isDel;

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public NhanVien(String ma, String ten, boolean isFemale) {
        this.ma = ma;
        this.ten = ten;
        this.isFemale = isFemale;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }
}
