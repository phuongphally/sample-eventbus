package com.meanroom.greatdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meanroom.greatdb.model.Student;
import com.meanroom.greatdb.schema.StudentSchema;

/**
 * Created by phuon on 25-Jan-17.
 */
public class MeanRoomDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;





    public MeanRoomDatabase(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentSchema.DELETE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(StudentSchema.DELETE_TABLE);
        onCreate(db);

    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
