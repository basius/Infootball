package com.example.basius.infootball;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by basius on 4/01/17.
 */

public class FootballApi {
    private String equipsChampions = "http://api.football-data.org/v1/competitions/440/leagueTable";

    public ArrayList<Equip> getAllTeams(){
        Uri builtUri = Uri.parse(equipsChampions)
                .buildUpon()
                .build();
        String url = builtUri.toString();
        return doCall(url);
    }

    @Nullable
    private ArrayList<Equip> doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static ArrayList<Equip> processJson(String jsonResponse) {
        ArrayList<Equip> equip = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONObject standings = data.getJSONObject("standings");
        //  Log.d("NomEquip:  ", "NumeroGrups:   "+standings.length());
            char[] lletresGrups = {'A','B','C','D','E','F','G','H'};
            for (int i = 0; i < standings.length(); i++) {
                //Obtenim el grup, en cas de que hi hagin grups eliminats no es mostraran ja que
                //nomes printem standings.length
                JSONArray grups = standings.getJSONArray(lletresGrups[i]+"");
                //JSONObject jsonGrup = jsonTeams.getJSONObject(i);
                Log.d("NomEquip:  ", grups.get(i)+"");
                Equip e = new Equip();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equip;
    }
}
