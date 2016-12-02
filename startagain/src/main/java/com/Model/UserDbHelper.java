package com.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.androidbelieve.startagain.UserContact;

/**
 * Created by Marko on 12.9.2016..
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE "+ UserContact.NewUserInfo.TABLE_NAME+"("+ UserContact.NewUserInfo.USER_NAME+" TEXT,"+
            UserContact.NewUserInfo.USER_EMAIL+" TEXT);";


    public UserDbHelper(Context context)//pravimo bazu
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Baza napravljena / otvorena");
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);//create table
        Log.e("DATABASE OPERATIONS","Tablica kreirana");

    }

    public void addInformation(String name,String email, SQLiteDatabase db) //unošenje podataka
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME,name);
        //contentValues.put(UserContact.NewUserInfo.TASK,task);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContact.NewUserInfo.TABLE_NAME,null,contentValues);//inserting into table
        Log.e("DATABASE OPERATIONS","Dodan jedan red");
    }

    //metoda koja će pokupiti sve podatke iz baze i vratiti ih kao Cursor objekt
    public Cursor getInformations(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {UserContact.NewUserInfo.USER_NAME,UserContact.NewUserInfo.USER_EMAIL};
        cursor = db.query(UserContact.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
