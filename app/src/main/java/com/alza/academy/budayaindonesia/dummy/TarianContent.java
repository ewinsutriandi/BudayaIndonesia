package com.alza.academy.budayaindonesia.dummy;

import com.alza.academy.budayaindonesia.model.TarianDaerah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TarianContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<TarianDaerah> ITEMS = new ArrayList<TarianDaerah>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, TarianDaerah> ITEM_MAP = new HashMap<String, TarianDaerah>();


    static {
        addItem(new TarianDaerah("Tari Rudat","Lombok",
                "Tarian daerah lombok yang mirip dengan pertunjukan pencak silat karena " +
                        "memiliki gerakan memukul, menendang, kuda-kuda, dan menangkis." +
                        "Tari rudat digunakan dalam menyambut tamu dan dalam acara formal pemerintahan."));
        addItem(new TarianDaerah("Tari Setabik","Musi Banyuasin",
                "Tarian ini digunakan untuk menyambut tamu yang disimbolkan dengan penyuguhan kapur sirih."));
        addItem(new TarianDaerah("Tari Pagar Pengantin","Sumatera Selatan",
                "Tarian ini ditampilkan pada acara resepsi pernikahan adat Palembang " +
                        "dan Sumatera Selatan pada umumnya. Tarian ini memiliki makna filosofis perpisahan pengantin " +
                        "perempuan kepada keluarganya."));
    }

    private static void addItem(TarianDaerah item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getJudulTarian(), item);
    }




}
