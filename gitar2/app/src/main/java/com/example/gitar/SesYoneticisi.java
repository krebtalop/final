package com.example.gitar;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import java.util.HashMap;
import java.util.Map;

public class SesYoneticisi {
    private SoundPool sesHavuzu;
    private Map<Integer, Integer> sesHaritasi;
    private Context baglam;

    public SesYoneticisi(Context context) {
        this.baglam = context;
        sesHaritasi = new HashMap<>();

        AudioAttributes ozellikler = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        sesHavuzu = new SoundPool.Builder()
                .setAudioAttributes(ozellikler)
                .setMaxStreams(6)
                .build();
    }

    public void sesleriYukle(Gitar gitar) {
        for (int i = 0; i < gitar.tumTelleriGetir().size(); i++) {
            GitarTeli tel = gitar.getTel(i);
            int sesId = sesHavuzu.load(baglam, tel.getSesKaynagiId(), 1);
            sesHaritasi.put(i, sesId);
        }
    }

    public void sesCal(int notIndeksi) {
        Integer sesId = sesHaritasi.get(notIndeksi);
        if (sesId != null) {
            sesHavuzu.play(sesId, 1, 1, 0, 0, 1);
        }
    }
}
