package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        ArrayList<Film> tabFilms = intent.getParcelableArrayListExtra("films");

        ListView listView = findViewById(R.id.liste1); //54

        ArrayAdapter<Film> filmsAdapter = new ArrayAdapter<Film>(this, android.R.layout.simple_list_item_1, tabFilms); //55

        listView.setAdapter(filmsAdapter); // 56

        ArrayList<String> liste = new ArrayList<>(); // 59

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste)); // 60



        ArrayAdapter<Film> filmTousAdapter = new ArrayAdapter<Film>(this, R.layout.liste_item, R.id.text_numFilm, tabFilms) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View rowView = super.getView(position, convertView, parent);
                Film film = getItem(position);

                TextView numFilm = rowView.findViewById(R.id.text_numFilm);
                numFilm.setText(String.valueOf(film.getNumFilm()));

                TextView titre = rowView.findViewById(R.id.text_titre);
                titre.setText(film.getTitre());

                TextView classement = rowView.findViewById(R.id.text_classement);
                classement.setText(String.valueOf(film.getClassement()));

                TextView categorie = rowView.findViewById(R.id.text_categorie);
                categorie.setText(film.getCategorie());


                return rowView;
            }
        };
        listView.setAdapter(filmTousAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    public void retour(MenuItem menu) {
        finish();
    }
    public void quitter(MenuItem menu) {
        this.finishAffinity();
    }
}