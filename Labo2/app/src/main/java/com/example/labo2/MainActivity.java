package com.example.labo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private List<String> categories;
    private List<Produit> produits = new ArrayList<>();
    private ListView listView;
    private Button button;
    private View headerRow;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        categories = Arrays.asList("Catégorie_1", "Catégorie_2", "Catégorie_3");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // créer 10 produits au hasard
        for (int i = 1; i <= 10; i++) {
            Produit produit = new Produit();
            produit.setId(i);
            produit.setNom("Produit_" + i);
            produit.setCategorie(categories.get(new Random().nextInt(categories.size())));
            produit.setPrix(new Random().nextDouble() * 100.0);
            produit.setStock(new Random().nextInt(99) + 1);
            produits.add(produit);
        }

        listView = findViewById(R.id.listview);
        final ArrayAdapter<Produit> produitAdapter = new ArrayAdapter<Produit>(this, android.R.layout.simple_list_item_1, produits);
        listView.setAdapter(produitAdapter);

        button = findViewById(R.id.bt1);
        list = new ArrayList<>();
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               vider();
            }
        });
    }

    public void vider() {
        list.clear();
        listView.removeHeaderView(headerRow);
        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    public void ajouterHeader() {
        headerRow = getLayoutInflater().inflate(R.layout.produit_list_item, listView, false);
        TextView idLabel = headerRow.findViewById(R.id.text_id);
        idLabel.setText("ID");
        TextView nomLabel = headerRow.findViewById(R.id.text_nom);
        nomLabel.setText("Nom");
        TextView categorieLabel = headerRow.findViewById(R.id.text_categorie);
        categorieLabel.setText("Catégorie");
        TextView prixLabel = headerRow.findViewById(R.id.text_prix);
        prixLabel.setText("Prix");
        TextView stockLabel = headerRow.findViewById(R.id.text_stock);
        stockLabel.setText("Stock");
        listView.addHeaderView(headerRow);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_lister:
                vider();
                ajouterHeader();
                final ArrayAdapter<Produit> produitAdapter = new ArrayAdapter<Produit>(this, R.layout.produit_list_item, R.id.text_id, produits) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View rowView = super.getView(position, convertView, parent);
                        Produit produit = getItem(position);
                        TextView idView = rowView.findViewById(R.id.text_id);
                        idView.setText(String.valueOf(produit.getId()));
                        TextView nomView = rowView.findViewById(R.id.text_nom);
                        nomView.setText(produit.getNom());
                        TextView categorieView = rowView.findViewById(R.id.text_categorie);
                        categorieView.setText(produit.getCategorie());
                        TextView prixView = rowView.findViewById(R.id.text_prix);
                        double price = produit.getPrix();
                        String formattedPrice = String.format("%.2f$", price);
                        prixView.setText(formattedPrice);
                        TextView stockView = rowView.findViewById(R.id.text_stock);
                        stockView.setText(String.valueOf(produit.getStock()));
                        return rowView;
                    }
                };
                listView.setAdapter(produitAdapter);
                return true;
            case R.id.action_categorie:
                vider();
                ajouterHeader();
                String selectedCategory = spinner.getSelectedItem().toString();
                ArrayList<Produit> produitsByCategory = new ArrayList<>();
                for (Produit produit : produits) {
                    if (produit.getCategorie().equals(selectedCategory)) {
                        produitsByCategory.add(produit);
                    }
                }
                final ArrayAdapter<Produit> produitAdapter2 = new ArrayAdapter<Produit>(this, R.layout.produit_list_item, R.id.text_id, produitsByCategory) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View rowView = super.getView(position, convertView, parent);
                        Produit produit = getItem(position);
                        TextView idView = rowView.findViewById(R.id.text_id);
                        idView.setText(String.valueOf(produit.getId()));
                        TextView nomView = rowView.findViewById(R.id.text_nom);
                        nomView.setText(produit.getNom());
                        TextView categorieView = rowView.findViewById(R.id.text_categorie);
                        categorieView.setText(produit.getCategorie());
                        TextView prixView = rowView.findViewById(R.id.text_prix);
                        double price = produit.getPrix();
                        String formattedPrice = String.format("%.2f$", price);
                        prixView.setText(formattedPrice);
                        TextView stockView = rowView.findViewById(R.id.text_stock);
                        stockView.setText(String.valueOf(produit.getStock()));
                        return rowView;
                    }
                };
                listView.setAdapter(produitAdapter2);
                return true;
            case R.id.action_total:
                vider();
                int total_produits = 0;
                double total_prix = 0.00;
                for (Produit produit : produits) {
                    total_produits += produit.getStock();
                    total_prix += (produit.getPrix() * produit.getStock());

                }
                DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
                symbols.setGroupingSeparator(' ');
                NumberFormat formatter = new DecimalFormat("#,##0.00", symbols);
                String formattedPrice = formatter.format(total_prix);
                String[] parts = formattedPrice.split("\\.");
                String integerPart = parts[0];
                String decimalPart = String.format("%02d", Integer.parseInt(parts[1]));
                String resultat= integerPart + "." + decimalPart + "$";
                list.add("L'inventaire contient " + total_produits + " produits.\nLe total s'élève à " + resultat + ".");
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list); // create the adapter with the updated data
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}