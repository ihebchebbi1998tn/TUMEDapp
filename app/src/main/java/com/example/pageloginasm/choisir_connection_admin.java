package com.example.pageloginasm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class choisir_connection_admin extends AppCompatActivity {
    private View _bg__iphone_8_plus___2_ek2;
    private ImageView image_1;
    private TextView logo;
    private TextView passer;
    private ImageView vector;
    private ImageView vector_ek1;
    private View rectangle_3;
    private TextView s_inscrire;
    private View rectangle_2;
    private TextView connexion;
    private View rectangle_1;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_1_choose);
        // Check if ActionBar is not null before setting its display properties
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }


        _bg__iphone_8_plus___2_ek2 = (View) findViewById(R.id._bg__iphone_8_plus___2_ek2);
        image_1 = (ImageView) findViewById(R.id.image_1);
        vector = (ImageView) findViewById(R.id.vector);
        vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
        rectangle_3 = (View) findViewById(R.id.rectangle_3);
        s_inscrire = (TextView) findViewById(R.id.s_inscrire);
        rectangle_2 = (View) findViewById(R.id.rectangle_2);
        connexion = (TextView) findViewById(R.id.connexion);
        rectangle_1 = (View) findViewById(R.id.rectangle_1);

    }

        public void onClickcon (View clicktcon) {
            // Add your onClick action here
            // For example, you can show a Toast message

            Intent intent = new Intent(choisir_connection_admin.this, loginadmin.class);
            startActivity(intent);
        }

        public void onClickinc (View clicktinc) {
            // Add your onClick action here
            // For example, you can show a Toast message

            Intent intent = new Intent(choisir_connection_admin.this, frame_1_activity.class);
            startActivity(intent);
        }



}






