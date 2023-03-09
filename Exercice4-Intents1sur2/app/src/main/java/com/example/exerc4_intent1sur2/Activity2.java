package com.example.exerc4_intent1sur2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    Button btRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        btRetour = findViewById(R.id.btRetour);

        Bundle donnees = getIntent().getExtras();
        String textes[] = donnees.getStringArray("donnees");

        tv1.setText("Nom: " + textes[0]);
        tv2.setText("Prénom: " + textes[1]);
        tv3.setText("Sexe: " + textes[2]);

        btRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}