package com.example.examen2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    private ArrayList<Film> tabFilms;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        tabFilms = intent.getParcelableArrayListExtra("films");


        spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Action");
        arrayList.add("Drame");
        arrayList.add("Comique");
        arrayList.add("Enfants");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                listerCateg();
            }
            public void onNothingSelected(AdapterView<?> parentView) {  }
        });


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

    public void listerCateg() {
        Spinner spinner = findViewById(R.id.spinner);;
        String selectedCategory = spinner.getSelectedItem().toString();
        ArrayList<Film> filmsByCategory = new ArrayList<>();
        for (Film film : tabFilms) {
            if (film.getCategorie().equals(selectedCategory)) {
                filmsByCategory.add(film);
            }
        }
        ListView listView = findViewById(R.id.liste1); //54
        ArrayAdapter<Film> filmsAdapter = new ArrayAdapter<Film>(this, android.R.layout.simple_list_item_1, tabFilms); //55
        listView.setAdapter(filmsAdapter); // 56
        ArrayList<String> liste = new ArrayList<>(); // 59
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste)); // 60
        ArrayAdapter<Film> filmTousAdapter = new ArrayAdapter<Film>(this, R.layout.liste_item, R.id.text_numFilm, filmsByCategory) {
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
}