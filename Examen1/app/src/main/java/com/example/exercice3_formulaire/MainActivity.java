package com.example.exercice3_formulaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextView tvDate;
    public EditText etMax;
    public EditText etLue;
    public RadioGroup rgRoute;
    public EditText etTotal;
    public Button btEnvoyer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        etMax = findViewById(R.id.etMax);
        etLue = findViewById(R.id.etLue);
        rgRoute = findViewById(R.id.rgRoute);
        etTotal = findViewById(R.id.etTotal);
        btEnvoyer = findViewById(R.id.btEnvoyer);

        // test pour que le clavier android n'apparaisse pas...
        etMax.setShowSoftInputOnFocus(false);
        etLue.setShowSoftInputOnFocus(false);
        etTotal.setShowSoftInputOnFocus(false);

        tvDate.setText("Date: " + (new SimpleDateFormat("dd/MM/yyyy")).format(new Date()));

        btEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { calculer(view); }
        });

    }

    void calculer(View view) {
        Double total = 25.0;
        int max = Integer.parseInt(etMax.getText().toString());
        int lue = Integer.parseInt(etLue.getText().toString());
        int trop = lue - max;
        if (trop <= 0) {
            etTotal.setText("0.00 $");
            return;
        }
        RadioButton coche = rgRoute.findViewById(rgRoute.getCheckedRadioButtonId());
        if (coche.getText().equals("Autoroute") || trop >= 25) {
            total += (trop * 20);
        }
        else {
            total += (trop * 15);
        }
        etTotal.setText(String.format("%.2f", total) + " $");

    }


}