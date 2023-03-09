package MikeMoreProjets.Calcoolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnTouchListener {

    int operateur = 0;
    double numerateur = 0;
    boolean fin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton boutonC = findViewById(R.id.boutonC);
        boutonC.setOnClickListener(this);
        AppCompatButton boutonPM = findViewById(R.id.boutonPM);
        boutonPM.setOnClickListener(this);
        AppCompatButton boutonMod = findViewById(R.id.boutonMod);
        boutonMod.setOnClickListener(this);
        AppCompatButton boutonBack = findViewById(R.id.boutonBack);
        boutonBack.setOnClickListener(this);
        AppCompatButton boutonXDeux = findViewById(R.id.boutonXDeux);
        boutonXDeux.setOnClickListener(this);
        AppCompatButton boutonRacine = findViewById(R.id.boutonRacine);
        boutonRacine.setOnClickListener(this);
        AppCompatButton boutonSurX = findViewById(R.id.boutonSurX);
        boutonSurX.setOnClickListener(this);
        AppCompatButton boutonDiv = findViewById(R.id.boutonDiv);
        boutonDiv.setOnClickListener(this);
        AppCompatButton boutonSept = findViewById(R.id.boutonSept);
        boutonSept.setOnClickListener(this);
        AppCompatButton boutonHuit = findViewById(R.id.boutonHuit);
        boutonHuit.setOnClickListener(this);
        AppCompatButton boutonNeuf = findViewById(R.id.boutonNeuf);
        boutonNeuf.setOnClickListener(this);
        AppCompatButton boutonFois = findViewById(R.id.boutonFois);
        boutonFois.setOnClickListener(this);
        AppCompatButton boutonQuatre = findViewById(R.id.boutonQuatre);
        boutonQuatre.setOnClickListener(this);
        AppCompatButton boutonCinq = findViewById(R.id.boutonCinq);
        boutonCinq.setOnClickListener(this);
        AppCompatButton boutonSix = findViewById(R.id.boutonSix);
        boutonSix.setOnClickListener(this);
        AppCompatButton boutonMoins = findViewById(R.id.boutonMoins);
        boutonMoins.setOnClickListener(this);
        AppCompatButton boutonUn = findViewById(R.id.boutonUn);
        boutonUn.setOnClickListener(this);
        AppCompatButton boutonDeux = findViewById(R.id.boutonDeux);
        boutonDeux.setOnClickListener(this);
        AppCompatButton boutonTrois = findViewById(R.id.boutonTrois);
        boutonTrois.setOnClickListener(this);
        AppCompatButton boutonPlus = findViewById(R.id.boutonPlus);
        boutonPlus.setOnClickListener(this);
        AppCompatButton boutonZero = findViewById(R.id.boutonZero);
        boutonZero.setOnClickListener(this);
        AppCompatButton boutonPoint = findViewById(R.id.boutonPoint);
        boutonPoint.setOnClickListener(this);
        AppCompatButton boutonEgal = findViewById(R.id.boutonEgal);
        boutonEgal.setOnClickListener(this);

    }

    void razCouleur() {
        findViewById(R.id.boutonDiv).setBackgroundTintList(getResources().getColorStateList(R.color.orange));
        findViewById(R.id.boutonFois).setBackgroundTintList(getResources().getColorStateList(R.color.orange));
        findViewById(R.id.boutonMoins).setBackgroundTintList(getResources().getColorStateList(R.color.orange));
        findViewById(R.id.boutonPlus).setBackgroundTintList(getResources().getColorStateList(R.color.orange));
    }

    void maj(String n) { // si on entre n'importe quel chiffre
        razCouleur();
        TextView resultat = findViewById(R.id.resultat);
        if (fin) {
            fin = false;
            resultat.setText("0");
        }
        String temp = resultat.getText().toString();
        resultat.setText(((temp.equals("0")) ? "" : temp) + n);
    }

    void operateur(int o, double n) {
        razCouleur();
        if (n != 0) {
            fin = true;
            switch (o) {
                case 0: { break; }
                case 1: {
                    operateur = 1;
                    findViewById(R.id.boutonDiv).setBackgroundTintList(getResources().getColorStateList(R.color.orange2));
                    break; }
                case 2: {
                    operateur = 2;
                    findViewById(R.id.boutonFois).setBackgroundTintList(getResources().getColorStateList(R.color.orange2));
                    break; }
                case 3: {
                    operateur = 3;
                    findViewById(R.id.boutonMoins).setBackgroundTintList(getResources().getColorStateList(R.color.orange2));
                    break; }
                case 4: {
                    operateur = 4;
                    findViewById(R.id.boutonPlus).setBackgroundTintList(getResources().getColorStateList(R.color.orange2));
                    break; }
            }
            numerateur = n;
        }
    }

    void calculer() {
        TextView afficheID = findViewById(R.id.resultat);
        String afficheString = afficheID.getText().toString();
        double afficheDouble = Double.parseDouble(afficheString);
        if (numerateur != 0) {
            double temp = 0;
            switch (operateur) {
                case 1 : {
                    temp = numerateur / afficheDouble;
                    break;
                }
                case 2 : {
                    temp = numerateur * afficheDouble;
                    break;
                }
                case 3 : {
                    temp = numerateur - afficheDouble;
                    break;
                }
                case 4 : {
                    temp = numerateur + afficheDouble;
                    break;
                }
            }
            afficheID.setText(temp + "");
        }
        numerateur = Double.parseDouble(afficheString);
    }

    @Override
    public void onClick(View v) {

        TextView afficheID = findViewById(R.id.resultat);
        String afficheString = afficheID.getText().toString();
        double afficheDouble = Double.parseDouble(afficheString);

        switch (v.getId()) {
            case R.id.boutonC: {
                afficheID.setText("0");
                operateur(-1, 0.0);
                operateur = 0;
                numerateur = 0;
                break;
            }
            case R.id.boutonPM: {
                if (!afficheString.startsWith("-")) {
                    afficheID.setText("-" + afficheString);
                }
                else {
                    afficheID.setText(afficheString.substring(1));
                }
                break;
            }
            case R.id.boutonMod: {
                afficheID.setText((afficheDouble / 100) + "");
                break;
            }
            case R.id.boutonBack: {
                if (afficheString != "0") {
                    if (afficheString.length() > 1) {
                        afficheID.setText(afficheString.substring(0, afficheString.length() - 1));
                    }
                    else { afficheID.setText("0"); }
                }
                break;
            }
            case R.id.boutonXDeux: {
                afficheID.setText(Math.pow(afficheDouble, 2) + "");
                operateur = 0;
                numerateur = 0;
                break;
            }
            case R.id.boutonRacine: {
                afficheID.setText(Math.pow(afficheDouble, 0.5) + "");
                operateur = 0;
                numerateur = 0;
                break;
            }
            case R.id.boutonSurX: {
                afficheID.setText((1 / afficheDouble) + "");
                operateur = 0;
                numerateur = 0;
                break;
            }
            case R.id.boutonDiv: { operateur(1, afficheDouble); break; }
            case R.id.boutonSept: { maj("7"); break; }
            case R.id.boutonHuit: { maj("8"); break; }
            case R.id.boutonNeuf: { maj("9"); break; }
            case R.id.boutonFois: { operateur(2, afficheDouble); break; }
            case R.id.boutonQuatre: { maj("4"); break; }
            case R.id.boutonCinq: { maj("5"); break; }
            case R.id.boutonSix: { maj("6"); break; }
            case R.id.boutonMoins: { operateur(3, afficheDouble); break; }
            case R.id.boutonUn: { maj("1"); break; }
            case R.id.boutonDeux: { maj("2"); break; }
            case R.id.boutonTrois: { maj("3"); break; }
            case R.id.boutonPlus: { operateur(4, afficheDouble); break; }
            case R.id.boutonZero: { maj("0"); break; }
            case R.id.boutonPoint: {
                if (!afficheString.contains(".")) { afficheID.setText(afficheString + "."); }
                break;
            }
            case R.id.boutonEgal: {
                if (afficheString != "0") {
                    calculer();
                    fin = true;
                    operateur = 0;
                }
                break;
            }
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}