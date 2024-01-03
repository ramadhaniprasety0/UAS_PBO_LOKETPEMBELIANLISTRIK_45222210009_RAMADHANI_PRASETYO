package com.example.newpbo;

import java.text.DecimalFormat;

public class PaketData implements Transaksi {
    private double jumlah;
    private double tarifPerGb;

    private String NoTlpn;
    private double jumlahGB;

    public PaketData(double jumlah, String NoTlpn ,double tarifPerGb) {
        this.jumlah = jumlah;
        this.NoTlpn = NoTlpn;
        this.tarifPerGb = tarifPerGb;
    }

    public String getNoTlpn(){
        return NoTlpn;
    }

    @Override
    public double hitungTotal(Pengguna pengguna) {
        double jumlahGB = jumlah / tarifPerGb;
        DecimalFormat df = new DecimalFormat("#.##");
        double total = Double.parseDouble(df.format(jumlahGB));
        pengguna.saldo -= jumlah;
        return total;
    }

}

