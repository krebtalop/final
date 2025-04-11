package com.example.gitar;

import android.content.Context;
import android.content.SharedPreferences;

public class KullaniciYonetimi {
    private static final String PREF_ADI = "KullaniciBilgileri";
    private static final String KEY_KULLANICI_ADI = "kullanici_adi";
    private static final String KEY_SIFRE = "sifre";

    private SharedPreferences sharedPreferences;

    public KullaniciYonetimi(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_ADI, Context.MODE_PRIVATE);
    }

    public void kaydet(String kullaniciAdi, String sifre) {
        sharedPreferences.edit()
                .putString(KEY_KULLANICI_ADI, kullaniciAdi)
                .putString(KEY_SIFRE, sifre)
                .apply();
    }

    public boolean girisKontrol(String kullaniciAdi, String sifre) {
        String kayitliKullanici = sharedPreferences.getString(KEY_KULLANICI_ADI, "");
        String kayitliSifre = sharedPreferences.getString(KEY_SIFRE, "");
        return kullaniciAdi.equals(kayitliKullanici) && sifre.equals(kayitliSifre);
    }
}
