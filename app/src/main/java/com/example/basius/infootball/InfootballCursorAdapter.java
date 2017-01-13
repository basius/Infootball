package com.example.basius.infootball;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.basius.infootball.databinding.LvEquipsBinding;

/**
 * Created by basius on 13/01/17.
 */

public class InfootballCursorAdapter extends CupboardCursorAdapter<Equip> {
    public InfootballCursorAdapter(Context context, Class<Equip> entityClass) {
        super(context, entityClass);
    }
    @Override
    public View newView(Context context, Equip model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LvEquipsBinding binding = DataBindingUtil.inflate(inflater, R.layout.lv_equips, parent, false);
        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Equip model) {
        LvEquipsBinding binding = DataBindingUtil.getBinding(view);
        binding.tvNomEquip.setText(model.getNom());
        binding.tvGrup.setText(model.getGrup());
        binding.tvPartitsJugats.setText(model.getPartitsJugats());
        binding.tvPunts.setText(model.getPunts());;
        Glide.with(context).load(model.getUrlImage()).into(binding.ibEscutEquip);
    }
}
