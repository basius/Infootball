package com.example.basius.infootball;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by basius on 4/01/17.
 */

public class FootballApi {
    private String API_KEY = "19916cabd8014f5ca0219bc519ba3764";
    private String equipsChampions = "http://api.football-data.org/v1/competitions/440/leagueTable";

    public ArrayList<Equip> getAllTeams(){
        Uri builtUri = Uri.parse(equipsChampions)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        try {
            String JsonResponse = HttpUtils.get(url);

            ArrayList<Equip> teams = new ArrayList<Equip>();

           /* JSONObject data= new JSONObject(JsonResponse);
            JSONArray jsonTeams = data.getJSONArray("teams");
            for (int i = 0; i<jsonTeams.length() ; i++) {
                Log.d("NomEquip:  ", teams.toString());
                Equip e = new Equip();
                JSONObject object = jsonTeams.getJSONObject(i);
                if (object.has("team")) {
                    e.setNom(object.getString("team"));
                }
                teams.add(e);
            }
            */
            return teams;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
