package com.example.basius.infootball;
import android.content.Context;
import android.net.Uri;

import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
/**
 * Created by basius on 13/01/17.
 */

public class DataManager {
    private static UriHelper URI_HELPER = UriHelper.with(InfootballContentProvider.AUTHORITY);
    private static Uri EQUIP_URI = URI_HELPER.getUri(Equip.class);
    static void guardaEquip(ArrayList<Equip> equips, Context context) {
        cupboard().withContext(context).put(EQUIP_URI, Equip.class, equips);
    }
    public static void eliminaEquip(Context context) {
        cupboard().withContext(context).delete(EQUIP_URI, "_id > ?", "1");
    }
}
