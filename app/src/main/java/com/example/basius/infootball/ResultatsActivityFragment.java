package com.example.basius.infootball;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultatsActivityFragment extends Fragment {
    private ArrayList<Equip> items;
    private EquipAdapter adapter;
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
        View view = inflater.inflate(R.layout.fragment_resultats, container, false);
        ListView lvEquips = (ListView) view.findViewById(R.id.lvEquips);
        items = new ArrayList<>();

        adapter = new EquipAdapter(
                getContext(),
                R.layout.lv_equips,
                items
        );

        lvEquips.setAdapter(adapter);
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

    private class RefreshDataTask extends AsyncTask<Void,Void, ArrayList<Equip>>{
        @Override
        protected  ArrayList<Equip> doInBackground(Void... voids) {
            FootballApi api = new FootballApi();
            ArrayList<Equip> result = api.getAllTeams();
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Equip> equips) {
            adapter.clear();
            for (Equip equip : equips) {
                adapter.add(equip);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }


}
