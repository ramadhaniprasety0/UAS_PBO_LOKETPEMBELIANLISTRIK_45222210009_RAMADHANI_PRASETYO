package com.example.newpbo;

import java.text.DecimalFormat;
import java.util.Random;

// TokenListrik.java
public class TokenListrik implements Transaksi {
    private double jumlah;
    private double biayaAdmin;
    private double biayaKwh;

    private String nomorToken;

    public TokenListrik(double jumlah, double biayaAdmin, double biayaKwh) {
        this.jumlah = jumlah;
        this.biayaAdmin = biayaAdmin;
        this.biayaKwh = biayaKwh;
        this.nomorToken = generateNomorToken();
    }


    @Override
    public double hitungTotal(Pengguna pengguna) {
        double konversiKwh = (jumlah - biayaAdmin) / biayaKwh;
        DecimalFormat df = new DecimalFormat("#.##");
        double total = Double.parseDouble(df.format(konversiKwh));
        pengguna.saldo -= jumlah;
        return total;
    }

    public String getNomorToken() {
        return nomorToken;
    }

    private String generateNomorToken() {

        Random random = new Random();
        StringBuilder nomorToken = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            if (i > 0 && i % 4 == 0){
                nomorToken.append("-");
            }
            nomorToken.append(random.nextInt(10));
        }

        return nomorToken.toString();
    }
}

