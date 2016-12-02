package com.androidbelieve.startagain;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.Model.DataAdapter;
import com.Model.UserDbHelper;
import com.markobozic.startagain.HubMenu;

import java.util.Calendar;
/**
 * Created by Marko on 12.9.2016..
 */
public class AccountSetupTime extends AppCompatActivity {

    TextView textUserWakeup,textUserStarday;
    SQLiteDatabase sqLiteDatabase;  //objekt sqlite-a
    UserDbHelper userDbHelper; //za dobivanje infromacije iz baze trebamo DbHelper
    Cursor cursor;
    DataAdapter dataAdapter;
    EditText bt_WakeUp,bt_StartDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setup_time);
        textUserWakeup = (TextView) findViewById(R.id.text_WakeUp);
        textUserStarday = (TextView) findViewById(R.id.text_WakeUp);
        bt_StartDay = (EditText) findViewById(R.id.bt_StartDay);
        bt_WakeUp = (EditText) findViewById(R.id.bt_WakeUp);
        bt_WakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AccountSetupTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        bt_WakeUp.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        bt_StartDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AccountSetupTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        bt_StartDay.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


        dataAdapter = new DataAdapter(getApplicationContext(),R.layout.activity_account_setup_time);
        //textUserStarday.(dataAdapter);
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase(); //inicijalizacija objekta
        cursor = userDbHelper.getInformations(sqLiteDatabase); //dobivanje infromacije iz baza koristeći cursor objekt
        //provjera baze
        if(cursor.moveToFirst())
        {
            do {

            }while(cursor.moveToNext());
        }

    }
    public void welcome_start (View view)
    {
        //String button_text;
        //button_text = ((Button) view).getText().toString();
        Intent intent = new Intent(this,HubMenu.class);
        startActivity(intent);
        /*
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
         */
    }
}
