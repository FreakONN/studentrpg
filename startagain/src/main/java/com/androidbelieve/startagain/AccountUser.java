package com.androidbelieve.startagain;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.Model.UserDbHelper;

/**
 * Created by Marko on 12.9.2016..
 */
public class AccountUser extends AppCompatActivity {
    EditText ContactName, ContactEmail;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_user);
        ContactName = (EditText) findViewById(R.id.contact_name);
        ContactEmail = (EditText) findViewById(R.id.contact_email);

    }

    public void addContact(View view)
    {
        String name = ContactName.getText().toString();
        String email = ContactEmail.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(name,email,sqLiteDatabase);

        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_SHORT).show();
        userDbHelper.close();

        Intent intent = new Intent(this,AccountSetupTime.class);
        startActivity(intent);
    }
}