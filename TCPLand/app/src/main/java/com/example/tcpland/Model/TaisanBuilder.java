package com.example.tcpland.Model;

public class TaisanBuilder {
    private int capBac;
    private String chucDanh;
    private double luong;
    private float hhDoanhso;
    private float hhDongcap;
    private double kpiNhom;
    private float thuongKpi;

    public TaisanBuilder setCapBac(int capBac) {
        this.capBac = capBac;
        return this;
    }

    public TaisanBuilder setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
        return this;
    }

    public TaisanBuilder setLuong(double luong) {
        this.luong = luong;
        return this;
    }

    public TaisanBuilder setHhDoanhso(float hhDoanhso) {
        this.hhDoanhso = hhDoanhso;
        return this;
    }

    public TaisanBuilder setHhDongcap(float hhDongcap) {
        this.hhDongcap = hhDongcap;
        return this;
    }

    public TaisanBuilder setKpiNhom(double kpiNhom) {
        this.kpiNhom = kpiNhom;
        return this;
    }

    public TaisanBuilder setThuongKpi(float thuongKpi) {
        this.thuongKpi = thuongKpi;
        return this;
    }

    public Taisan createTaisan() {
        return new Taisan(capBac, chucDanh, luong, hhDoanhso, hhDongcap, kpiNhom, thuongKpi);
    }
}