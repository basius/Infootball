package com.example.basius.infootball;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.databinding.DataBindingUtil;
import com.example.basius.infootball.databinding.FragmentResultatsBinding;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import nl.littlerobots.cupboard.tools.provider.UriHelper;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultatsActivityFragment extends Fragment {
    private ArrayList<Equip> items;
    private InfootballCursorAdapter adapter;
    private FragmentResultatsBinding binding;
    public ResultatsActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                                inflater, R.layout.fragment_resultats, container, false);
                View view = binding.getRoot();
        items = new ArrayList<>();

        adapter = new InfootballCursorAdapter(getContext(), Equip.class);

        binding.lvEquips.setAdapter(adapter);
        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_resultats, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void refresh(){
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
     }

    private class RefreshDataTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            ArrayList<Equip> equips = FootballApi.getAllTeams();
            ArrayList<Equip> result = new ArrayList<>();
            for (Equip e : equips) {
                //Quan l'equip que recorrem tingui activat el switch preference, l'afegim.
                if (preferences.getBoolean("grup" + e.getGrup(), true) == true) {
                    result.add(e);
                }
            }
            //Registro els equips a la BBDD
            DataManager.eliminaEquip(getContext());
            DataManager.guardaEquip(result, getContext());
            return null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }


}
