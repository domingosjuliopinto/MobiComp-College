package com.example.databaseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.edit_text_name);
        EditText contactEditText = findViewById(R.id.edit_text_contact);
        EditText dobEditText = findViewById(R.id.edit_text_dob);
        Button insert = findViewById(R.id.button_insert);
        Button update = findViewById(R.id.button_update);
        Button delete = findViewById(R.id.button_delete);
        Button view = findViewById(R.id.button_view);

        DBHelper dbHelper = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = nameEditText.getText().toString();
                String contactText = contactEditText.getText().toString();
                String dobText = dobEditText.getText().toString();

                Boolean checkInsertData = dbHelper.insertUserData(nameText,contactText,dobText);
                if(checkInsertData==true){
                    Toast.makeText(MainActivity.this,"New Entry Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"New Entry Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = nameEditText.getText().toString();
                String contactText = contactEditText.getText().toString();
                String dobText = dobEditText.getText().toString();

                Boolean checkUpdateData = dbHelper.updateUserData(nameText,contactText,dobText);
                if(checkUpdateData==true){
                    Toast.makeText(MainActivity.this,"Entry Updated",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Entry Not Updated",Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = nameEditText.getText().toString();

                Boolean checkDeleteData = dbHelper.deleteUserData(nameText);
                if(checkDeleteData==true){
                    Toast.makeText(MainActivity.this,"Entry Deleted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Entry Not Deleted",Toast.LENGTH_LONG).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = dbHelper.getUserData();
                if (result.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entries Exist",Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Name: " + result.getString(0)+"\n");
                    buffer.append("Contact: " + result.getString(1)+"\n");
                    buffer.append("Dob: " + result.getString(2)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}