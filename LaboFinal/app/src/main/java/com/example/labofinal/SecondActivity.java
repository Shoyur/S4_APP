package com.example.labofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<MyItem> itemList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        int numIntent = intent.getIntExtra("num", 0) + 1;

        Cursor cursor = db.query("exercices" + numIntent, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int num = cursor.getInt(cursor.getColumnIndexOrThrow("num"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
            itemList.add(new MyItem(num, getResources().getIdentifier("e" + num, "drawable", getPackageName()), title, description));
        }
        db.close();

        MyAdapter adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_autres, menu);
        return true;
    }

    public void retour(MenuItem item) {
        finish();
    }
    public void ajouter(MenuItem item) {

    }
}