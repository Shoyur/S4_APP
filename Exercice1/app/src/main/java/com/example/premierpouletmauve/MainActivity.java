package com.example.premierpouletmauve;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bPlus = findViewById(R.id.bPlus);
        bPlus.setOnClickListener(this);
        Button bMoins = findViewById(R.id.bMoins);
        bMoins.setOnClickListener(this);
        Button bFois = findViewById(R.id.bFois);
        bFois.setOnClickListener(this);
        Button bDiv = findViewById(R.id.bDiv);
        bDiv.setOnClickListener(this);
        Button bMod = findViewById(R.id.bMod);
        bMod.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText n1 = findViewById(R.id.n1);
        EditText n2 = findViewById(R.id.n2);
        if (n1.getText().length() < 1 || n2.getText().length() < 1) { return; }
        double nb1 = Double.parseDouble(n1.getText().toString());
        double nb2 = Double.parseDouble(n2.getText().toString());
        TextView resultat = findViewById(R.id.resultat);

        switch (v.getId()) {
            case R.id.bPlus: {
                resultat.setText(nb1+nb2+"");
                break;
            }
            case R.id.bMoins: {
                resultat.setText(nb1-nb2+"");
                break;
            }
            case R.id.bFois: {
                resultat.setText(nb1*nb2+"");
                break;
            }
            case R.id.bDiv: {
                resultat.setText(nb1/nb2+"");
                break;
            }
            case R.id.bMod: {
                resultat.setText(nb1%nb2+"");
                break;
            }
        }

    }

    public void ajouterEcouteur() {

        //Toast.makeText(this, "Buton plus", Toast.LENGTH_SHORT).show();
        //bPlus = findViewById(R.id.bPlus);
        //bPlus.setOnClickListener(this);

               /* bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.)
                EditText n1 = findViewById(R.id.n1);
                EditText n2 = findViewById(R.id.n2);
                TextView resultat = findViewById(R.id.resultat);
                double nb1 = Double.parseDouble(n1.getText().toString());
                double nb2 = Double.parseDouble(n2.getText().toString());
                double res = nb1+nb2;
                resultat.setText(res+"");
            }
        });*/
    }

    public void changeWOW() {
        //TextView leTexte = findViewById(R.id.leTexte1);
        //leTexte.setTextColor(Color.parseColor(randomHEX()));
        //leTexte = findViewById(R.id.leTexte2);
        //leTexte.setTextColor(Color.parseColor(randomHEX()));
        //leTexte = findViewById(R.id.leTexte3);
        //leTexte.setTextColor(Color.parseColor(randomHEX()));
    }

    //public String randomHEX() {
        //Random obj = new Random();
        //int rand_num = obj.nextInt(0xffffff + 1);
        //return String.format("#%06x", rand_num);
    //}



    //public void opPlus() {
       // EditText n1 = findViewById(R.id.n1);
      //  EditText n2 = findViewById(R.id.n2);
      //  TextView resultat = findViewById(R.id.resultat);
        //Toast.makeText(this, "crfc", Toast.LENGTH_SHORT).show();
        //int reponse = Integer.parseInt(String.valueOf(n1)) + Integer.parseInt(String.valueOf(n2));
        //resultat.setText(reponse);
        //resultat.setText("YO");
    //}

}