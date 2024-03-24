package com.example.myapplication_dev_mobile;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    DBconnexion DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        DB= new DBconnexion(this);
    }
    public void suivant(View v){
        EditText titre=(EditText) findViewById(R.id.edittitre);
        EditText contrat=(EditText) findViewById(R.id.contrat);
        RadioButton CAT=(RadioButton) findViewById(R.id.rad1);
        EditText desc=(EditText) findViewById(R.id.desc);
        CheckBox ville= (CheckBox) findViewById(R.id.checkbox5);
        RadioButton SECT=(RadioButton) findViewById(R.id.sec3);



        String Titre=titre.getText().toString();
        String Ville=ville.getText().toString();
        String Contrat=contrat.getText().toString();
        String DESC=desc.getText().toString();
        String secteur=SECT.getText().toString();

        DB.ajouterAnnonce(Titre,Contrat,secteur,DESC,Ville);

        Toast.makeText(this, "annonce ajouté avec succès", Toast.LENGTH_LONG).show();
        Intent inten = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(inten);

    }}
