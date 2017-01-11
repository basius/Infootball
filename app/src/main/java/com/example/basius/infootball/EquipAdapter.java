package com.example.basius.infootball;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_equips, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvNomEquip = (TextView) convertView.findViewById(R.id.tvNomEquip);
        TextView tvGrup = (TextView) convertView.findViewById(R.id.tvGrup);
        TextView tvPartitsJugats = (TextView) convertView.findViewById(R.id.tvPartitsJugats);
        TextView tvPunts = (TextView) convertView.findViewById(R.id.tvPunts);
        ImageView ibEscutEquip = (ImageView) convertView.findViewById(R.id.ibEscutEquip);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvNomEquip.setText(equip.getNom());
        tvGrup.setText(equip.getGrup());
        tvPartitsJugats.setText("PJ: "+equip.getPartitsJugats());
        tvPunts.setText(equip.getPunts());

        // Retornem la View replena per a mostrarla
        return convertView;
    }
}
