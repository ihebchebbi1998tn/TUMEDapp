package com.example.pageloginasm;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class frame_1_activity extends Activity {

	private View _bg__frame_1_ek2;
	private ImageView vector;
	private ImageView image_1;
	private ImageView vector_ek1;
	private ImageView vector_ek2;
	private ImageView vector_ek3;
	private ImageView vector_ek4;
	private TextView agent_asm;
	private View rectangle_3;
	private EditText EmailAgent; // Change to EditText
	private View rectangle_4;
	private EditText Motdepassagent; // Change to EditText
	private View rectangle_5;
	private EditText TelAgent; // Change to EditText
	private View rectangle_6;
	private View rectangle_2;
	private Spinner zoneSpinner;
	String zone ;
	private EditText NomPrenom; // Change to EditText

	// Initialize the DatabaseHelper and SQLiteDatabase objects
	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;

	@SuppressLint("MissingInflatedId")
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_1);

		// Initialize the SQLiteDatabase object
		dbHelper = new DatabaseHelper(this);
		db = dbHelper.getWritableDatabase();

		_bg__frame_1_ek2 = findViewById(R.id._bg__frame_1_ek2);
		image_1 = findViewById(R.id.image_1);
		vector_ek1 = findViewById(R.id.vector_ek1);
		vector_ek3 = findViewById(R.id.vector_ek3);
		vector_ek4 = findViewById(R.id.vector_ek4);
		agent_asm = findViewById(R.id.agent_asm);
		rectangle_3 = findViewById(R.id.rectangle_3);
		EmailAgent = findViewById(R.id.EmailAgent); // Change to EditText
		rectangle_4 = findViewById(R.id.rectangle_4);
		Motdepassagent = findViewById(R.id.Motdepassagent); // Change to EditText
		rectangle_5 = findViewById(R.id.rectangle_5);
		TelAgent = findViewById(R.id.TelAgent); // Change to EditText
		rectangle_6 = findViewById(R.id.rectangle_6);
		rectangle_2 = findViewById(R.id.rectangle_2);
		NomPrenom = findViewById(R.id.NomPrenom); // Change to EditText
        zoneSpinner = findViewById(R.id.zone_spinner);


//my other code 
		String[] zoneArray = getResources().getStringArray(R.array.zone_array);
		ArrayAdapter<String> zoneAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, zoneArray);
		zoneSpinner.setAdapter(zoneAdapter);

		zoneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Get the selected item from the spinner
				zone = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {


			}
		});
	}

	public void onclickOk(View ClickOK) {
        String name = NomPrenom.getText().toString().trim();
        String email = EmailAgent.getText().toString().trim();
        String codeAgent = Motdepassagent.getText().toString().trim();
        String password = TelAgent.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || codeAgent.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the codeAgent already exists in the database
        Cursor cursor = db.query("Agent", null, "CodeAgent=?", new String[]{codeAgent}, null, null, null);
        if (cursor.getCount() > 0) {
            Toast.makeText(this, "Code agent existe deja", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        cursor.close();

        // Add the new user to the database
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Telephone", email);
        values.put("CodeAgent", codeAgent);
        values.put("Motdepass", password);
        values.put("Zone", zone);
        db.insert("Agent", null, values);

        // Start the loginadmin activity
        Intent intent = new Intent(frame_1_activity.this, loginadmin.class);
        startActivity(intent);

        Toast.makeText(this, "Ajouté avec succès", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}