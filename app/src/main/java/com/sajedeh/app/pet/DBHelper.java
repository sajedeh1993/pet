package com.sajedeh.app.pet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sajedeh.app.pet.PetContract.PetEntity;

import java.io.FileInputStream;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "pet.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

      final String SQL_CREATE_TABLE_PET="CREATE TABLE " + PetEntity.TABLE_NAME + "(" +
              PetEntity.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
              PetEntity.COLUMN_NAME + " TEXT," +
              PetEntity.COLUMN_GENDER + " INTEGER," +
              PetEntity.COLUMN_AGE + " INTEGER," +
              PetEntity.COLUMN_PIC + " INTEGER" +
              ");";
      sqLiteDatabase.execSQL(SQL_CREATE_TABLE_PET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertPet(Pet pet){
        SQLiteDatabase db=getWritableDatabase();

//        db.execSQL("INSERT INTO" + PetEntity.TABLE_NAME + "VALUES()");

        ContentValues contentValues = new ContentValues();
        contentValues.put(PetEntity.COLUMN_NAME,pet.name);
        contentValues.put(PetEntity.COLUMN_AGE,pet.age);
        contentValues.put(PetEntity.COLUMN_GENDER,pet.gender);
        contentValues.put(PetEntity.COLUMN_PIC,pet.pic);


        long id=db.insert(PetEntity.TABLE_NAME,null,contentValues);

    }

    public Cursor getAll(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from " + PetEntity.TABLE_NAME , null);
        return cursor;
    }
}
