package com.example.labofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bdmusculation.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE exercices0 (num INTEGER PRIMARY KEY, title TEXT, description TEXT)");
        ContentValues values = new ContentValues();

        values.put("num", 1);
        values.put("title", "Exercices abdominaux");
        values.put("description", "Quel sont les meilleurs exercices pour les abdominaux ? Comment cibler le haut et le bas ? Quel programme faire pour avoir des abdos musclés et un bon gainage ? Dans cette section, vous verrez comment muscler les abdominaux efficacement…");
        db.insert("exercices0", null, values);

        values.put("num", 2);
        values.put("title", "Exercices pectoraux");
        values.put("description", "Comment bien cibler les pectoraux ? Quels sont les meilleurs exercices pour le haut, le bas ou l'intérieur ? Ici, vous trouverez tous les exercices de musculation pour les pectoraux ainsi que de nombreux conseils d'entraînement…");
        db.insert("exercices0", null, values);

        values.put("num", 3);
        values.put("title", "Exercices dos");
        values.put("description", "Comment bien se muscler le dos ? Quels sont les meilleurs exercices pour les dorsaux, trapèzes et lombaires ? Dans cette rubrique, vous trouverez de nombreux exercices de musculation pour le dos et des conseils pour obtenir un dos large et massif…");
        db.insert("exercices0", null, values);

        values.put("num", 4);
        values.put("title", "Exercices épaules");
        values.put("description", "Comment muscler les épaules ? Quels sont les meilleurs exercices ? Vous trouverez dans cette rubrique tous les exercices les plus efficaces pour les épaules et des conseils pour bien les réaliser, en toute sécurité…");
        db.insert("exercices0", null, values);

        values.put("num", 5);
        values.put("title", "Exercices biceps");
        values.put("description", "Comment se muscler les biceps rapidement ? Quels exercices faire pour prendre des bras ou se muscler sans matériel ? Vous trouverez tous les exercices les plus efficaces pour les biceps et des conseils pour la musculation des biceps…");
        db.insert("exercices0", null, values);

        values.put("num", 6);
        values.put("title", "Exercices triceps");
        values.put("description", "Comment muscler vos triceps ? Quels sont les meilleurs exercices ? Peut-on complètement isoler une portion ? Vous trouverez dans cette rubrique tous les exercices les plus efficaces. De quoi vous bâtir de bons gros bras bien volumineux…");
        db.insert("exercices0", null, values);

        values.put("num", 7);
        values.put("title", "Exercices avant-bras");
        values.put("description", "Comment muscler vos avants-bras ? Découvrez les meilleurs exercices pour travailler et se muscler les avant-bras. Que ce soit avec la barre ou les haltères, découvrez toutes les variantes…");
        db.insert("exercices0", null, values);

        values.put("num", 8);
        values.put("title", "Exercices cuisses / fessiers");
        values.put("description", "Si vous voulez un physique complet et équilibré, il est important de ne pas délaisser l'entraînement des membres inférieurs. Quels sont les meilleurs exercices pour les quadriceps, ischio-jambiers et fessiers ? Tous les conseils pour muscler et raffermir tout ça…");
        db.insert("exercices0", null, values);

        values.put("num", 9);
        values.put("title", "Exercices mollets");
        values.put("description", "Comment muscler les mollets ? Comment bien les développer sous toutes les coutures ? Vous trouverez dans cette rubrique tous les exercices les plus efficaces pour les mollets ainsi que des explications et conseils pour les cas difficiles…");
        db.insert("exercices0", null, values);


        db.execSQL("CREATE TABLE exercices1 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values1 = new ContentValues();

        values1.put("num", 1);
        values1.put("title", "Crunch au sol");
        values1.put("description", "Le crunch est l'exercice de base très efficace pour muscler les abdominaux et raffermir la taille. Encore faut-il bien le réaliser ! Tous nos conseils pour faire des crunchs parfaits…");
        values1.put("url", "https://www.youtube.com/watch?v=zUk1BiL6Ajc");
        db.insert("exercices1", null, values1);

        values1.put("num", 2);
        values1.put("title", "Relevés de bassin sur plan incliné");
        values1.put("description", "Un bon exercice pour le grand droit des abdominaux. Il a la réputation de solliciter le bas des abdos, là ou le crunch classique vise plus le haut. On peut le réaliser à l'aide d'un banc ou au sol…");
        values1.put("url", "https://www.youtube.com/watch?v=lpxLgh4d-Zg");
        db.insert("exercices1", null, values1);


        db.execSQL("CREATE TABLE exercices2 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values2 = new ContentValues();

        values2.put("num", 1);
        values2.put("title", "");
        values2.put("description", "");
        values2.put("url", "");
        db.insert("exercices2", null, values2);

        values2.put("num", 2);
        values2.put("title", "");
        values2.put("description", "");
        values2.put("url", "");
        db.insert("exercices2", null, values2);


        db.execSQL("CREATE TABLE exercices3 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values3 = new ContentValues();

        values3.put("num", 1);
        values3.put("title", "");
        values3.put("description", "");
        values3.put("url", "");
        db.insert("exercices3", null, values3);

        values3.put("num", 2);
        values3.put("title", "");
        values3.put("description", "");
        values3.put("url", "");
        db.insert("exercices3", null, values3);


        db.execSQL("CREATE TABLE exercices4 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values4 = new ContentValues();

        values4.put("num", 1);
        values4.put("title", "");
        values4.put("description", "");
        values4.put("url", "");
        db.insert("exercices4", null, values4);

        values4.put("num", 2);
        values4.put("title", "");
        values4.put("description", "");
        values4.put("url", "");
        db.insert("exercices4", null, values4);


        db.execSQL("CREATE TABLE exercices5 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values5 = new ContentValues();

        values5.put("num", 1);
        values5.put("title", "");
        values5.put("description", "");
        values5.put("url", "");
        db.insert("exercices5", null, values5);

        values5.put("num", 2);
        values5.put("title", "");
        values5.put("description", "");
        values5.put("url", "");
        db.insert("exercices5", null, values5);


        db.execSQL("CREATE TABLE exercices6 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values6 = new ContentValues();

        values6.put("num", 1);
        values6.put("title", "");
        values6.put("description", "");
        values6.put("url", "");
        db.insert("exercices6", null, values6);

        values6.put("num", 6);
        values6.put("title", "");
        values6.put("description", "");
        values6.put("url", "");
        db.insert("exercices6", null, values6);


        db.execSQL("CREATE TABLE exercices7 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values7 = new ContentValues();

        values7.put("num", 1);
        values7.put("title", "");
        values7.put("description", "");
        values7.put("url", "");
        db.insert("exercices7", null, values7);

        values7.put("num", 2);
        values7.put("title", "");
        values7.put("description", "");
        values7.put("url", "");
        db.insert("exercices7", null, values7);


        db.execSQL("CREATE TABLE exercices8 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values8 = new ContentValues();

        values8.put("num", 1);
        values8.put("title", "");
        values8.put("description", "");
        values8.put("url", "");
        db.insert("exercices8", null, values8);

        values8.put("num", 2);
        values8.put("title", "");
        values8.put("description", "");
        values8.put("url", "");
        db.insert("exercices8", null, values8);


        db.execSQL("CREATE TABLE exercices9 (num INTEGER PRIMARY KEY, title TEXT, description TEXT, url TEXT)");
        ContentValues values9 = new ContentValues();

        values9.put("num", 1);
        values9.put("title", "");
        values9.put("description", "");
        values9.put("url", "");
        db.insert("exercices9", null, values9);

        values9.put("num", 2);
        values9.put("title", "");
        values9.put("description", "");
        values9.put("url", "");
        db.insert("exercices9", null, values9);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}