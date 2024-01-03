package com.example.newpbo;
public abstract class Pengguna {
    String nama;
    double saldo;

    String NomerMeter;

    double jumlahkWh;


    public Pengguna(String nama, double saldo, String NomerMeter, double jumlahkWh) {
        this.nama = nama;
        this.saldo = saldo;
        this.NomerMeter = NomerMeter;
        this.jumlahkWh = jumlahkWh;
    }

    public abstract String getInfo();


    public double getSaldo(){
        return saldo;
    }

    public String getNomerMeter(){
        return NomerMeter;
    }

}
