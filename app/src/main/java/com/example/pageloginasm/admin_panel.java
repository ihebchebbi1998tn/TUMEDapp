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

public class admin_panel extends AppCompatActivity {
    private View rectangle_2;
    private View rectangle_4;
    private View rectangle_3;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_3_adminpanel);
        // Check if ActionBar is not null before setting its display properties
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        rectangle_4 = findViewById(R.id.rectangle_4);
        rectangle_3 = findViewById(R.id.rectangle_3);
        rectangle_2 = findViewById(R.id.rectangle_2);

        rectangle_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(admin_panel.this, loginadmin.class);
                startActivity(intent);
            }
        });

        rectangle_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(admin_panel.this, loginadmin.class);
                startActivity(intent);
            }
        });

        rectangle_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(admin_panel.this, loginadmin.class);
                startActivity(intent);
            }
        });
    }




}






