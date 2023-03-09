package com.example.examen2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public int newNumFilm;
    public int newTitre;
    public int newClassement;
    public int newCategorie;


    public final ArrayList<Film> tabFilms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    public void chargerFilms(MenuItem menu) {
        tabFilms.add(new Film(1125, "Le dernier empereur", 4.5, "Action"));
        tabFilms.add(new Film(1279, "Titanic", 5, "Drame"));
        tabFilms.add(new Film(1487, "Diner de cons", 4, "Comique"));
        tabFilms.add(new Film(2452, "Interstellar", 5, "Drame"));
        tabFilms.add(new Film(3210, "Good cop bad cop", 3.5, "Comique"));
        tabFilms.add(new Film(4211, "Reine des neiges", 4, "Enfants"));
        Toast.makeText(this, "Les 6 premiers films ont bien été ajoutés!", Toast.LENGTH_LONG).show();

    }

    public void ajouter(MenuItem menu) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("AJOUT D'UN FILM");

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.ajouter, null);
        alertDialog.setView(dialogView)
        .setPositiveButton("AJOUTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                EditText valueView1 = (EditText) dialogView.findViewById(R.id.et1);
                EditText valueView2 = (EditText) dialogView.findViewById(R.id.et2);
                EditText valueView3 = (EditText) dialogView.findViewById(R.id.et3);
                EditText valueView4 = (EditText) dialogView.findViewById(R.id.et4);

                newNumFilm = Integer.parseInt(valueView1.getText().toString());
                tabFilms.add(new Film(
                        Integer.parseInt(valueView1.getText().toString()),
                        valueView2.getText().toString(),
                        Double.parseDouble(valueView3.getText().toString()),
                        valueView4.getText().toString()));
                Toast.makeText(MainActivity.this, "Le film #"+valueView1.getText().toString()+"a été ajouté", Toast.LENGTH_LONG).show();
            }
        });

        alertDialog.show();
    }
    public void ajouterAvecInfo() {

    }
    public void lister(MenuItem menu) {
        Intent intentAct2 = new Intent(MainActivity.this, Activity2.class);
        intentAct2.putParcelableArrayListExtra("films", tabFilms);
        startActivity(intentAct2);
    }
    public void rechercher(MenuItem menu) {
        Intent intentAct3 = new Intent(MainActivity.this, Activity3.class);
        intentAct3.putParcelableArrayListExtra("films", tabFilms);
        startActivity(intentAct3);
    }
    public void quitter(MenuItem menu) {
        this.finishAffinity();
    }

}