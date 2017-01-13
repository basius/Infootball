package com.example.basius.infootball;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import com.example.basius.infootball.databinding.LvEquipsBinding;
/**
 * Created by basius on 11/01/17.
 */

public class EquipAdapter extends ArrayAdapter<Equip> {

    public EquipAdapter(Context context, int resource, List<Equip> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenim l'objecte en la possició corresponent
        Equip equip = getItem(position);
        LvEquipsBinding binding = null;
        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.lv_equips, parent, false);
        }else{
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.tvNomEquip.setText(equip.getNom());
        binding.tvGrup.setText(equip.getGrup());
        binding.tvPartitsJugats.setText("PJ: "+equip.getPartitsJugats());
        binding.tvPunts.setText(equip.getPunts());
        binding.ibEscutEquip.setBackgroundColor(Color.BLACK);
        Glide.with(getContext()).load(equip.getUrlImage()).into(binding.ibEscutEquip);
        // Unim el codi en les Views del Layout
//        TextView tvNomEquip = (TextView) convertView.findViewById(R.id.tvNomEquip);
//        TextView tvGrup = (TextView) convertView.findViewById(R.id.tvGrup);
//        TextView tvPartitsJugats = (TextView) convertView.findViewById(R.id.tvPartitsJugats);
//        TextView tvPunts = (TextView) convertView.findViewById(R.id.tvPunts);
//        ImageView ibEscutEquip = (ImageView) convertView.findViewById(R.id.ibEscutEquip);
        // Fiquem les dades dels objectes (provinents del JSON) en el layout
//        tvNomEquip.setText(equip.getNom());
//        tvGrup.setText(equip.getGrup());
//        tvPartitsJugats.setText("PJ: "+equip.getPartitsJugats());
//        tvPunts.setText(equip.getPunts());
//        Glide.with(getContext()).load(equip.getUrlImage()).into(ibEscutEquip);
        // Retornem la View replena per a mostrarla
        return binding.getRoot();
    }
}
