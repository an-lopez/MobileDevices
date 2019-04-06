package com.escom.ipn.mx.sharedpreferences;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EjemploSQLite3";
    Context context;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+ DbContract.ExampleEntry.TABLE_NAME+" (" +
                    DbContract.ExampleEntry._ID+ " INTEGER PRIMARY KEY, " +
                    DbContract.ExampleEntry.COLUMN_NAME_NAME+ " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.ExampleEntry.TABLE_NAME;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void insertExample(int id, String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DbContract.ExampleEntry._ID, id);
        contentValues.put(DbContract.ExampleEntry.COLUMN_NAME_NAME, name);

        long newId = db.insert(DbContract.ExampleEntry.TABLE_NAME, null, contentValues);

    }

    public List<Entry> listValues(){
        List listaEntradas = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();

        String projection[] = {BaseColumns._ID, DbContract.ExampleEntry.COLUMN_NAME_NAME};

        String selection = "";
        String selectionArgs[] = {""};

        Cursor cursor = db.query(
                DbContract.ExampleEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
                );
        while(cursor.moveToNext()){
            Entry entry = new Entry();
            entry.setId( cursor.getInt(cursor.getColumnIndexOrThrow(DbContract.ExampleEntry._ID)));
            entry.setName(cursor.getString(cursor.getColumnIndex(DbContract.ExampleEntry.COLUMN_NAME_NAME)));
            listaEntradas.add(entry);
        }
        return listaEntradas;

    }
}
