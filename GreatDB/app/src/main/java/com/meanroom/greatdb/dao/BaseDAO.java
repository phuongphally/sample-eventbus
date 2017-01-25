package com.meanroom.greatdb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.meanroom.greatdb.source.MeanRoomDatabase;

/**
 * Created by phuon on 25-Jan-17.
 */
public class BaseDAO<T> {

    private MeanRoomDatabase meanRoomDatabase = null;

    public BaseDAO(Context context) {
        if(meanRoomDatabase==null) {
            meanRoomDatabase = new MeanRoomDatabase(context);
        }

    }

    public SQLiteDatabase getWrite(){
        return meanRoomDatabase.getWritableDatabase();
    }

    public SQLiteDatabase getRead(){
        return meanRoomDatabase.getReadableDatabase();
    }










}
