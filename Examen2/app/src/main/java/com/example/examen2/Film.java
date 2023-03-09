package com.example.examen2;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private int numFilm;
    private String titre;
    private double classement;
    private String categorie;


    public Film(int numFilm, String titre, double classement, String categorie) {
        this.numFilm = numFilm;
        this.titre = titre;
        this.classement = classement;
        this.categorie = categorie;
    }

    public Film(Parcel parcel) {
        this.numFilm = parcel.readInt();
        this.titre = parcel.readString();
        this.classement = parcel.readDouble();
        this.categorie = parcel.readString();
    }

    public int getNumFilm() {
        return numFilm;
    }
    public void setNumFilm(int numFilm) {
        this.numFilm = numFilm;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getClassement() {
        return classement;
    }
    public void setClassement(int classement) {
        this.classement = classement;
    }

    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(numFilm);
        parcel.writeString(titre);
        parcel.writeDouble(classement);
        parcel.writeString(categorie);

    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        public Film createFromParcel(Parcel parcel) {
            return new Film(parcel);
        }
        public Film[] newArray(int grandeur) {
            return new Film[grandeur];
        }
    };

    public String afficherFilm() {
        return "Film { numFilm=" + numFilm +
                ", titre='" + titre +
                ", classement=" + classement +
                ", catégorie=" + categorie +
                " }";
    }
}