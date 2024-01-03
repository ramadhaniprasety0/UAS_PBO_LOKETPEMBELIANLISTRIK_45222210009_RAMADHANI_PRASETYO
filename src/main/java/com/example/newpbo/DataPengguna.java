package com.example.newpbo;
import java.util.HashMap;
import java.util.Map;

public class DataPengguna {
    private static Map<String, Pengguna> databasePengguna = new HashMap<>();

    public static void addPengguna(Pengguna pengguna) {
        databasePengguna.put(pengguna.getNomerMeter(), pengguna);
    }

    public static Pengguna getPenggunaByNomerMeter(String nomorMeter) {
        return databasePengguna.get(nomorMeter);
    }
}
