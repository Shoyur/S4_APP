package com.example.exerc4_intent1sur2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etNom;
    EditText etPrenom;
    RadioGroup rgSexe;
    Button btEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        rgSexe = findViewById(R.id.rgSexe);
        btEnvoyer = findViewById(R.id.btEnvoyer);

        btEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String donnees[] = new String[3];
                donnees[0] = etNom.getText().toString();
                donnees[1] = etPrenom.getText().toString();
                RadioButton rbSel = rgSexe.findViewById(rgSexe.getCheckedRadioButtonId());
                donnees[2] = rbSel.getText().toString();
                Intent intentTest = new Intent(MainActivity.this, Activity2.class);
                intentTest.putExtra("donnees", donnees);
                startActivity(intentTest);
            }
        });
    }
}