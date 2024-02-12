import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotificationDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notification.db";
    private static final int DATABASE_VERSION = 1;

    public NotificationDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define the SQL statement to create the table
        String SQL_CREATE_NOTIFICATION_TABLE = "CREATE TABLE " + NotificationContract.NotificationEntry.TABLE_NAME + " ("
                + NotificationContract.NotificationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NotificationContract.NotificationEntry.COLUMN_NAME_TITLE + " TEXT NOT NULL, "
                + NotificationContract.NotificationEntry.COLUMN_NAME_MESSAGE + " TEXT NOT NULL, "
                + NotificationContract.NotificationEntry.COLUMN_NAME_DATE + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_NOTIFICATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the table and recreate it if the database version has changed
        db.execSQL("DROP TABLE IF EXISTS " + NotificationContract.NotificationEntry.TABLE_NAME);
        onCreate(db);
    }
}