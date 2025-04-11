package com.example.gitar;

public class GitarTeli {
    private String isim;
    private int sesKaynagiId;

    public GitarTeli(String isim, int sesKaynagiId) {
        this.isim = isim;
        this.sesKaynagiId = sesKaynagiId;
    }

    public String getIsim() {
        return isim;
    }

    public int getSesKaynagiId() {
        return sesKaynagiId;
    }
}
