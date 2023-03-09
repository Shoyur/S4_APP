package com.example.lab1p2_spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textes sous-lignés
        TextView textViewTop = findViewById(R.id.textViewTop);
        TextView textViewProvinces = findViewById(R.id.textViewProvinces);
        TextView textViewVilles = findViewById(R.id.textViewVilles);
        textViewTop.setPaintFlags(textViewTop.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textViewProvinces.setPaintFlags(textViewTop.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textViewVilles.setPaintFlags(textViewTop.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // populer le spinner provinces
        List<String> listeProvinces =  new ArrayList<>();
        listeProvinces.add("Québec");
        listeProvinces.add("Ontario");
        listeProvinces.add("Alberta");
        ArrayAdapter<String> adapterProvinces = new ArrayAdapter<String>(
                this, R.layout.spinner_text, listeProvinces);
        adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // liste villes quebec
        List<String> listeVillesQuebec =  new ArrayList<>();
        listeVillesQuebec.add("Montréal");
        listeVillesQuebec.add("Boucherville");
        listeVillesQuebec.add("Laval");
        ArrayAdapter<String> adapterVillesQuebec = new ArrayAdapter<String>(
                this, R.layout.spinner_text, listeVillesQuebec);
        adapterVillesQuebec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // liste villes ontario
        List<String> listeVillesOntario =  new ArrayList<>();
        listeVillesOntario.add("Toronto");
        listeVillesOntario.add("Kingston");
        listeVillesOntario.add("Sandbanks");
        ArrayAdapter<String> adapterVillesOntario = new ArrayAdapter<String>(
                this, R.layout.spinner_text, listeVillesOntario);
        adapterVillesOntario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // liste villes alberta
        List<String> listeVillesAlberta =  new ArrayList<>();
        listeVillesAlberta.add("Calgary");
        listeVillesAlberta.add("Edmonton");
        listeVillesAlberta.add("Red Deer");
        ArrayAdapter<String> adapterVillesAlberta = new ArrayAdapter<String>(
                this, R.layout.spinner_text, listeVillesAlberta);
        adapterVillesAlberta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinProvinces = findViewById(R.id.spin1);
        Spinner spinVilles = findViewById(R.id.spin2);
        spinProvinces.setAdapter(adapterProvinces);

        // notre drapeau
        ImageView drapeau = findViewById(R.id.drapeau);

        spinProvinces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0: {
                        drapeau.setImageResource(R.drawable.quebec);
                        spinVilles.setAdapter(adapterVillesQuebec);
                        break;
                    }
                    case 1: {
                        drapeau.setImageResource(R.drawable.ontario);
                        spinVilles.setAdapter(adapterVillesOntario);
                        break;
                    }
                    case 2: {
                        drapeau.setImageResource(R.drawable.alberta);
                        spinVilles.setAdapter(adapterVillesAlberta);
                        break;
                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parentView) {  }
        });
    }
}