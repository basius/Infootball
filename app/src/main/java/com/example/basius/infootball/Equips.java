package com.example.basius.infootball;

import java.util.List;

/**
 * Created by basius on 4/01/17.
 */

public class Equips {
    private String nom;
    private String grup;
    private String partitsJugats;
    private String punts;
    private String urlImage;
    private List<Equips> equips;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getPartitsJugats() {
        return partitsJugats;
    }

    public void setPartitsJugats(String partitsJugats) {
        this.partitsJugats = partitsJugats;
    }

    public String getPunts() {
        return punts;
    }

    public void setPunts(String punts) {
        this.punts = punts;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<Equips> getEquips() {
        return equips;
    }

    public void setEquips(List<Equips> equips) {
        this.equips = equips;
    }

    @Override
    public String toString() {
        return "Equips{" +
                "nom='" + nom + '\'' +
                ", grup='" + grup + '\'' +
                ", partitsJugats='" + partitsJugats + '\'' +
                ", punts='" + punts + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", equips=" + equips +
                '}';
    }
}

