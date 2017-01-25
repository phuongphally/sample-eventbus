package com.meanroom.greatdb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;

import com.meanroom.greatdb.model.Student;
import com.meanroom.greatdb.schema.StudentSchema;

import java.util.List;

/**
 * Created by phuon on 25-Jan-17.
 */
public class StudentDao extends BaseDAO implements TemplateDAO<Student> {


    private static StudentDao instance;

    private  ContentValues values = new ContentValues();

    private StudentDao(Context context){
        super(context);
    }

    public static StudentDao getInstance(Context context){
        if(instance==null){

            instance = new StudentDao(context);

        }
        return instance;
    }



    @Override
    public long insert(Student student) {
        try {
            values.put(StudentSchema.COLUME_NAME, student.getName());
            return getWrite().insert(StudentSchema.TABLE_NAME, null, values);



        }catch (SQLiteException e){

        }
        return -1;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public List<Student> lists() {
        return null;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }

    @Override
    public long update(long id, Student mNew) {
        return 0;
    }
}
