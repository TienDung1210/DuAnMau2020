package com.example.duanmau2020.Bill;

import java.util.Date;

public class Bill {
    public int mahd;
    public java.util.Date date;
    public String  tensachbill;
    public double soluongbill;
    public double giatien;
    public double tongtien;

    public Bill() {
    }

    public Bill(int mahd, Date date, String tensachbill, double soluongbill, double giatien, double tongtien) {
        this.mahd = mahd;
        this.date = date;
        this.tensachbill = tensachbill;
        this.soluongbill = soluongbill;
        this.giatien = giatien;
        this.tongtien = tongtien;
    }
}
