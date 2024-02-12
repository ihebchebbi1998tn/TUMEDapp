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
   
   // ADD VIEWS AND DECLARATION
   
   private NotificationDbHelper notificationDbHelper;
   private EditText NotifName;
   private EditText NotifDescription;
   private EditText NotifDate;
   private Button SendNotif;

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
		
	    NotifName = findViewById(R.id.TelAgent);
		NotifDescription = findViewById(R.id.TelAgent);
		NotifDate = findViewById(R.id.TelAgent);

	    SendNotif = findViewById(R.id.SendNotif);
		
		notificationDbHelper = new NotificationDbHelper(this);
		
		SendNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotification();
            }
        });

    }
	
	private void saveNotification() {
        String name = NotifName.getText().toString().trim();
        String description = NotifDescription.getText().toString().trim();
        String date = NotifDate.getText().toString().trim();

        if (name.isEmpty()) {
            NotifName.setError("Name is required");
            NotifName.requestFocus();
            return;
        }

        if (description.isEmpty()) {
            NotifDescription.setError("Description is required");
            NotifDescription.requestFocus();
            return;
        }

        if (date.isEmpty()) {
            NotifDate.setError("Date is required");
            NotifDate.requestFocus();
            return;
        }

        SQLiteDatabase db = notificationDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NotificationContract.NotificationEntry.COLUMN_NAME, name);
        values.put(NotificationContract.NotificationEntry.COLUMN_DESCRIPTION, description);
        values.put(NotificationContract.NotificationEntry.COLUMN_DATE, date);

        long newRowId = db.insert(NotificationContract.NotificationEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error saving notification", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Notification saved with id " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

}




