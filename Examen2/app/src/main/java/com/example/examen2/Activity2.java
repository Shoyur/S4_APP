package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

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

        Intent in = getIntent();
        Parcelable[] parcelables = in.getParcelableArrayExtra("user");
        User[] users = new User[parcelables.length];
        for (int i = 0; i < parcelables.length; i++) {
            users[i] = (User) parcelables[i];
        }
//        Log.d("Users", Arrays.toString(users));
        // test:
        tv3.setText("TEST: " + users[0].getName());

        btRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}