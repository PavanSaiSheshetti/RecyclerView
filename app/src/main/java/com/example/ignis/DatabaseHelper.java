package com.example.ignis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.ims.RcsUceAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Records.DATABASE_NAME, null, Records.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Records.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + Records.TABLE_NAME);
        onCreate(db);

    }
    public long insert_record(String vehicle, String number, String date, String odometer, String problems, String fuel,
                              String fuel_type, String belongings, String scratches, String Estimate , String Front_Image,
                              String Rear_Image, String RtSide_Image, String LtSide_Image, String odofuel_Image,
                              String Shield_Image, String tyre, String paint, String engine, String coolant, String list,
                              String inspect, String Executive, String sign){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Records.COL1, vehicle);
        cv.put(Records.COL2, number);
        cv.put(Records.COL3, date);
        cv.put(Records.COL4, odometer);
        cv.put(Records.COL5, problems);
        cv.put(Records.COL6, fuel);
        cv.put(Records.COL7, fuel_type);
        cv.put(Records.COL8, belongings);
        cv.put(Records.COL9, scratches);
        cv.put(Records.COL10, Estimate);
        cv.put(Records.COL11, Front_Image);
        cv.put(Records.COL12, Rear_Image);
        cv.put(Records.COL13, RtSide_Image);
        cv.put(Records.COL14, LtSide_Image);
        cv.put(Records.COL15, odofuel_Image);
        cv.put(Records.COL16, Shield_Image);
        cv.put(Records.COL17, tyre);
        cv.put(Records.COL18, paint);
        cv.put(Records.COL19, engine);
        cv.put(Records.COL20, coolant);
        cv.put(Records.COL21, list);
        cv.put(Records.COL22, inspect);
        cv.put(Records.COL23, Executive);
        cv.put(Records.COL24, sign);
        long result = db.insert(Records.TABLE_NAME,null,cv);
        db.close();
        return result;
    }
    public ArrayList<ModelRecord> getAllRecords(){

        ArrayList<ModelRecord> recordList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Records.TABLE_NAME ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                ModelRecord modelRecord = new ModelRecord(
                        ""+cursor.getInt(cursor.getColumnIndex(Records.COL_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL1)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL2)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL3)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL4)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL5)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL6)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL7)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL8)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL9)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL10)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL11)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL12)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL13)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL14)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL15)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL16)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL17)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL18)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL19)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL20)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL21)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL22)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL23)),
                        ""+cursor.getString(cursor.getColumnIndex(Records.COL24)));
                recordList.add(modelRecord);
            }while(cursor.moveToNext());
        }
        db.close();
        return recordList;
    }


}
