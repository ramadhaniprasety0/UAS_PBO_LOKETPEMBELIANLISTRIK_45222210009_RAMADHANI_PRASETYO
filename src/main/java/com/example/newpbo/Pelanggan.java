package com.example.newpbo;

public class Pelanggan extends Pengguna {
    public Pelanggan(String nama, double saldo, String nomorMeter, double jumlahkWh) {
        super(nama, saldo, nomorMeter, jumlahkWh);
    }

    @Override
    public String getInfo() {
        return "Info Pelanggan : \n Nama :" + nama + "\n Saldo = " + saldo + "\n Nomer Meter = " + NomerMeter + "\n kWh = " + jumlahkWh+" \n";
    }

}
