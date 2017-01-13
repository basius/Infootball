package com.example.basius.infootball;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;
/**
 * Created by basius on 13/01/17.
 */

public class InfootballContentProvider extends CupboardContentProvider {
    // The content provider authority is used for building Uri's for the provider
    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Equip.class);
    }

    public InfootballContentProvider() {
        super(AUTHORITY, 1);
    }
}
