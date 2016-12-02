package com.androidbelieve.startagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.markobozic.startagain.HubMenu;

/**
 * Created by Marko on 12.9.2016..
 */
public class AccountSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_menu);
    }

    public void welcome_start (View view)
    {
        Intent intent = new Intent(this,HubMenu.class);
        startActivity(intent);
    }
}

