package com.example.pageloginasm;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class loginadmin extends AppCompatActivity {
    private View _bg__iphone_8_plus___4_ek2;
    private ImageView image_1;
    private ImageView vector;
    private ImageView vector_ek1;
    private View rectangle_4;
    private TextView CodeAgent;
    private ImageView vector_ek2;
    private TextView passAgent;
    private View rectangle_3;
    private TextView utilisateur;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_2_login);

        // Check if ActionBar is not null before setting its display properties
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        // Initialize the SQLiteDatabase object
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        _bg__iphone_8_plus___4_ek2 = findViewById(R.id._bg__iphone_8_plus___4_ek2);
        image_1 = findViewById(R.id.image_1);
        vector = findViewById(R.id.vector);
        vector_ek1 = findViewById(R.id.vector_ek1);
        rectangle_4 = findViewById(R.id.rectangle_4);
        passAgent = findViewById(R.id.passAgent);
        vector_ek2 = findViewById(R.id.vector_ek2);
        rectangle_3 = findViewById(R.id.rectangle_3);
        CodeAgent = findViewById(R.id.CodeAgent);
    }

public void onClickuser(View view) {
    String codeAgent = CodeAgent.getText().toString();
    String password = passAgent.getText().toString();
    
    if (TextUtils.isEmpty(codeAgent) || TextUtils.isEmpty(password)) {
        Toast.makeText(this, "Veuillez remplir tous les champs pour vous connecter", Toast.LENGTH_SHORT).show();
        return;
    }

    try {
        Cursor cursor = db.rawQuery("SELECT * FROM Agent WHERE CodeAgent = ? AND Motdepass = ?",
                new String[]{codeAgent, password});

        if (cursor.moveToFirst()) {
            Intent intent = new Intent(loginadmin.this, admin_panel.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    } catch (SQLException e) {
        Toast.makeText(this, "Une erreur s'est produite lors de l'exécution de la requête.", Toast.LENGTH_SHORT).show();
        Log.e("loginadmin", "Error querying database: " + e.getMessage());
    }
}

@Override
protected void onDestroy() {
    super.onDestroy();
    db.close();
}
}





