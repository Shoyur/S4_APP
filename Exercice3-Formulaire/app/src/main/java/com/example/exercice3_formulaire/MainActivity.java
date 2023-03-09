package com.example.exercice3_formulaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText etNom;
    public EditText etPrenom;
    public RadioGroup rgSexe;
    public Spinner spinFonction;
    public CheckBox cbT1;
    public CheckBox cbT2;
    public CheckBox cbT3;
    public CheckBox cbT4;
    public EditText etComm;
    public Button btEnvoyer;
    public Button btEffacer;


    public String texte;

    public TextView tvPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        rgSexe = findViewById(R.id.rgSexe);
        spinFonction = findViewById(R.id.spinFonction);
        cbT1 = findViewById(R.id.cbT1);
        cbT2 = findViewById(R.id.cbT2);
        cbT3 = findViewById(R.id.cbT3);
        cbT4 = findViewById(R.id.cbT4);
        etComm = findViewById(R.id.etComm);
        btEnvoyer = findViewById(R.id.btEnvoyer);
        btEffacer = findViewById(R.id.btEffacer);

        // test pour que le clavier android n'apparaisse pas...
        etNom.setShowSoftInputOnFocus(false);
        etPrenom.setShowSoftInputOnFocus(false);
        etComm.setShowSoftInputOnFocus(false);

        btEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { envoyer(view); }
        });
        btEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { effacer(); }
        });

    }

    public void onButtonShowPopupWindowClick(View view) {

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        tvPopup = popupView.findViewById(R.id.tvPopup);
        tvPopup.setText(texte);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    void envoyer(View view) {
        texte = "";
        texte += "Formulaire envoyé pour :\n";
        texte += "Nom = " + etNom.getText() + "\n";
        texte += "Prénom = " + etPrenom.getText() + "\n";
        RadioButton rbSel = rgSexe.findViewById(rgSexe.getCheckedRadioButtonId());
        texte += "Sexe = " + rbSel.getText() + "\n";
        texte += "Fonction = " + spinFonction.getSelectedItem().toString() + "\n";
        texte += "Temps de travail = ";
        texte += cbT1.isChecked() ? cbT1.getText() + ", " : "";
        texte += cbT2.isChecked() ? cbT2.getText() + ", " : "";
        texte += cbT3.isChecked() ? cbT3.getText() + ", " : "";
        texte += cbT4.isChecked() ? cbT4.getText() + ", " : "";
        texte += "\nCommentaires = \n";
        texte += etComm.getText();
        texte += "\n";
        onButtonShowPopupWindowClick(view);
    }

    void effacer() {
        etNom.setText("");
        etPrenom.setText("");
        rgSexe.check(R.id.rbM);
        spinFonction.setSelection(0);
        cbT1.setChecked(false);
        cbT2.setChecked(false);
        cbT3.setChecked(false);
        cbT4.setChecked(false);
        etComm.setText("");
    }
}