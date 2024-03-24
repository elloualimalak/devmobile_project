package com.example.myapplication_dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Email,Password;
    DBconnexion DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = findViewById(R.id.mail);
        Password = findViewById(R.id.mpass);
        DB= new DBconnexion(this);
    }
    public void inscription(View v){
        Intent inte = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(inte);
    }
    public void SeConnecter(View view) {
        EditText email= (EditText) findViewById(R.id.mail);
        EditText password= (EditText) findViewById(R.id.mpass);
        String mail = email.getText().toString();
        String pass = password.getText().toString();

        if (validateLogin(mail, pass)==true) {
            Toast.makeText(MainActivity.this, "Connexion avec succès", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        } else
        {
            Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean validateLogin(String email, String password) {
        SQLiteDatabase rdb = DB.getReadableDatabase();
        Cursor res = rdb.rawQuery("SELECT * FROM compte WHERE email='" + email + "' AND password='" + password + "'", null);
        res.moveToFirst();
        if (res.getColumnCount() > 0){
            res.close();
            return true;
        } else
            return false;

    }

}