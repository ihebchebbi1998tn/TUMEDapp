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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class admin_panel extends AppCompatActivity {
    private TextView notificationTitle;
    private TextView notificationMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        // Initialize views
        notificationTitle = findViewById(R.id.notification_title);
        notificationMessage = findViewById(R.id.notification_message);

        // Get the current date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(calendar.getTime());

        // Open the database for reading
         DatabaseHelper dbHelper = new DatabaseHelper(this);
        NotificationDbHelper notificationDbHelper = new NotificationDbHelper(this);
        db = dbHelper.getReadableDatabase();
        notificationDb = notificationDbHelper.getReadableDatabase();

        // Define the columns you want to retrieve from the database
        String[] projection = {
                "NameNotif",
                "DescriptionNotif"
        };

        // Define the selection criteria for the query
        String selection = "DateNotif = ?";
        String[] selectionArgs = { currentDate };

        // Execute the query
        Cursor cursor = db.query(
                "Notification",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        // Check if there are any notifications for the current date
        if (cursor.getCount() > 0) {
            // There is a notification for the current date
            cursor.moveToFirst();
            String title = cursor.getString(cursor.getColumnIndexOrThrow("NameNotif"));
            String message = cursor.getString(cursor.getColumnIndexOrThrow("DescriptionNotif"));

            // Show the notification using the views
            notificationTitle.setText(title);
            notificationMessage.setText(message);

            // Show a toast with the notification information
            Toast.makeText(this, title + ": " + message, Toast.LENGTH_LONG).show();
        } else {
            // No notifications for the current date
            Toast.makeText(this, "No notifications for today.", Toast.LENGTH_SHORT).show();
        }

        // Close the cursor and database to free up resources
        cursor.close();
        db.close();
    }
}