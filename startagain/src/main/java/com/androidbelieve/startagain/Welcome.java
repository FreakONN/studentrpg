package com.androidbelieve.startagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.markobozic.startagain.*;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void welcome_start (View view)
    {
        //String button_text;
        //button_text = ((Button) view).getText().toString();

        Intent intent = new Intent(this,AccountSetup.class);
        startActivity(intent);


/*
        Intent intent = new Intent(this,TaskManagament.class);
        startActivity(intent);
*/
    }
}
