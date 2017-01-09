package com.example.basius.infootball;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public String getAllTeams(){
        Uri builtUri = Uri.parse(equipsChampions)
                .buildUpon()
                .build();
        String url = builtUri.toString();
        return doCall(url);
    }

    @Nullable
    static String doCall(String url) {
        HttpURLConnection c;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setRequestProperty("X-Auth-Token", "19916cabd8014f5ca0219bc519ba3764" ); // API Token
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                        Log.d("NomEquip:  ", sb.toString());
                    }
                    br.close();
                    //processJson(sb.toString());
            }


           // String JsonResponse = HttpUtils.get("http://api.football-data.org/v1/competitions/440/leagueTable/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static ArrayList<Equip> processJson(String jsonResponse) {
        //NO ESTA FUNCIONANT
        ArrayList<Equip> teams = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonTeams = data.getJSONArray("teams");
            Log.d("NomEquip:  ", "99999"+jsonTeams.length());
            for (int i = 0; i < jsonTeams.length(); i++) {
                  Log.d("NomEquip:  ", "99999"+jsonTeams.length());
                JSONObject object = jsonTeams.getJSONObject(i);
                Equip e = new Equip();
                if (object.has("team")) {
                    e.setNom(object.getString("team"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return teams;
    }
}

