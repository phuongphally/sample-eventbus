package com.meanroom.greatdb.source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.meanroom.greatdb.model.Student;
import com.meanroom.greatdb.schema.StudentSchema;
import com.meanroom.greatdb.schema.TeacherSchema;

/**
 * Created by phuon on 25-Jan-17.
 */
public class MeanRoomDatabase extends SQLiteOpenHelper {



    private static final String DATABSE_NAME = "students.db";

    private static final int DATABASE_VERSION = 2;

    public MeanRoomDatabase(Context context){
        super(context,DATABSE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(StudentSchema.CREATE_TABLE);
        db.execSQL(TeacherSchema.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(StudentSchema.DELETE_TABLE);
        db.execSQL(TeacherSchema.DELETE_TABLE);
        onCreate(db);
    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.i("down","working");
        onUpgrade(db, oldVersion, newVersion);
    }



}
