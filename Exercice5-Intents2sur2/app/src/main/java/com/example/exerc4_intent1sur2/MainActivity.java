package com.example.exerc4_intent1sur2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNom;
    EditText etPrenom;
    EditText etAge;
    RadioGroup rgSexe;
    Button btEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        etAge = findViewById(R.id.etAge);
        rgSexe = findViewById(R.id.rgSexe);
        btEnvoyer = findViewById(R.id.btEnvoyer);

        btEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String donnees[] = new String[4];
                donnees[0] = etNom.getText().toString();
                donnees[1] = etPrenom.getText().toString();
                RadioButton rbSel = rgSexe.findViewById(rgSexe.getCheckedRadioButtonId());
                donnees[2] = rbSel.getText().toString();
                donnees[3] = etAge.getText().toString();
                Intent intent1 = new Intent(MainActivity.this, Activity2.class);
                intent1.putExtra("donnees", donnees);
                activityResultLaunch.launch(intent1);
            }
        });
    }
    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1) {
                Toast.makeText(MainActivity.this, result.getData().getStringExtra("reponse"), Toast.LENGTH_LONG).show();
            }
        }
    });

}