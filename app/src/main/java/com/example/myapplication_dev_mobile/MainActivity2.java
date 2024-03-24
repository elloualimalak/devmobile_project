package com.example.myapplication_dev_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    DBconnexion DB;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        DB= new DBconnexion(this);
    }
    public void createCompte(View v){
        EditText email=(EditText) findViewById(R.id.edittextemail);
        EditText ville=(EditText) findViewById(R.id.ville);
        EditText pass=(EditText) findViewById(R.id.mpass);
        EditText passval=(EditText) findViewById(R.id.mpassverif);

        String Email=email.getText().toString();
        String Ville=ville.getText().toString();
        String Pass=pass.getText().toString();
        String Passval=email.getText().toString();
        if(Passval.equals(Passval)){
            DB.ajouterCompte(Email,Ville,Pass);

            Toast.makeText(this, "Compte ajouté avec succès", Toast.LENGTH_LONG).show();
            Intent inten = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(inten);
        }
        else {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_LONG).show();
        }
    }

}
