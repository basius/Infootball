package com.example.basius.infootball;

import java.io.Serializable;
import java.util.List;

/**
 * Created by basius on 4/01/17.
 */

public class Equip implements Serializable {
    private String nom;
    private String grup;
    private String partitsJugats;
    private String punts;
    private String urlImage;

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


    @Override
    public String toString() {
        return "Equip{" +
                "nom='" + nom + '\'' +
                ", grup='" + grup + '\'' +
                ", partitsJugats='" + partitsJugats + '\'' +
                ", punts='" + punts + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}

