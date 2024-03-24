package com.example.myapplication_dev_mobile;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.Nullable;

public class DBconnexion extends SQLiteOpenHelper {
    public DBconnexion(Context context) {
        super(context, "EmploiDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table compte(id integer primary key,email text,ville text,password text);");

        String CREATE_ANNONCE_TABLE = "CREATE TABLE " + "annonce" + "("
                + "id" + " INTEGER PRIMARY KEY,"
                + "titre" + " TEXT,"
                + "categorie" + " TEXT,"
                + "secteur" + " TEXT,"
                + "description" + " TEXT,"
                + "ville" + " TEXT" + ")";
        db.execSQL(CREATE_ANNONCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "compte");
        db.execSQL("DROP TABLE IF EXISTS " + "annonce");
        onCreate(db);
    }

    // Méthode pour ajouter un compte dans la table
    public void ajouterCompte(String email, String ville,String motdepasse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("ville", ville);
        values.put("password", motdepasse);

        db.insert("compte", null, values);
        db.close();
    }

    // Méthode pour ajouter une annonce dans la table
    public void ajouterAnnonce(String titre, String categorie, String secteur, String description, String ville) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("titre", titre);
        values.put("categorie", categorie);
        values.put("secteur", secteur);
        values.put("description", description);
        values.put("ville", ville);

        db.insert("annonce", null, values);
        db.close();
    }
    public int nombrePersonnesAAgadir() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + "annonce" + " WHERE " + "ville" + " = ?";
        String[] selectionArgs = {"Agadir"};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        int count = 0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            cursor.close();
        }
        return count;
    }

}

