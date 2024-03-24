package com.example.myapplication_dev_mobile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    DBconnexion DB;
    TextView textViewNombrePersonnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        DB= new DBconnexion(this);
        textViewNombrePersonnes = findViewById(R.id.nbre);

        int nbrepers;
        nbrepers = DB.nombrePersonnesAAgadir();

        textViewNombrePersonnes.setText("Nombre d'annonce à Agadir : " + nbrepers);
    }


}




