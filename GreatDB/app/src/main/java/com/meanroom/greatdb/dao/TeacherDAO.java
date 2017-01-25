package com.meanroom.greatdb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.meanroom.greatdb.model.Student;
import com.meanroom.greatdb.model.Teacher;
import com.meanroom.greatdb.schema.TeacherSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuon on 25-Jan-17.
 */
public class TeacherDAO extends BaseDAO <Teacher> implements  TemplateDAO<Teacher>{

    private static TeacherDAO instance;

    ContentValues values = new ContentValues();


    private TeacherDAO(Context context){
        super(context);
    }
    public static  TeacherDAO getInstance(Context context) {
        if(instance==null){
            instance = new TeacherDAO(context);
        }
        return instance;
    }


    @Override
    public long insert(Teacher teacher) {
        values.put(TeacherSchema.COLUME_NAME,teacher.getName());
        return getWrite().insert(TeacherSchema.TABLE_NAME,null,values);
    }

    @Override
    public List<Teacher> getAll() {
        String selectQuery = "SELECT  * FROM " + TeacherSchema.TABLE_NAME;
        List<Teacher> lists = new ArrayList<>();

        Cursor cursor=null;

        try{

            cursor = getRead().rawQuery(selectQuery,null);

            while (cursor.moveToNext()){
                long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(TeacherSchema._ID));
                String itemName = cursor.getString(cursor.getColumnIndexOrThrow(TeacherSchema.COLUME_NAME));

                Teacher student = new Teacher();
                student.setId(itemId);
                student.setName(itemName);

                lists.add(student);
            }

        }catch (Exception e){

        }finally {
            cursor.close();
        }



        return lists;
    }

    @Override
    public List<Teacher> lists() {

        List<Teacher> lists = new ArrayList<>();

        Cursor cursor=null;

        try{

            // Define a projection that specifies which columns from the database
// you will actually use after this query.
            String[] projection = {
                    TeacherSchema._ID,
                    TeacherSchema.COLUME_NAME

            };

// Filter results WHERE "title" = 'My Title'
            String selection = TeacherSchema.COLUME_NAME+ " = ?";
            String[] selectionArgs = { "student new" };

// How you want the results sorted in the resulting Cursor
            String sortOrder =
                    TeacherSchema._ID + " DESC";

              cursor = getRead().query(
                    TeacherSchema.TABLE_NAME,                 // The table to query
                    projection,                               // The columns to return
                    selection,                                // The columns for the WHERE clause
                    selectionArgs,                            // The values for the WHERE clause
                    null,                                     // don't group the rows
                    null,                                     // don't filter by row groups
                    sortOrder                                 // The sort order
            );

            while (cursor.moveToNext()){
                long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(TeacherSchema._ID));
                String itemName = cursor.getString(cursor.getColumnIndexOrThrow(TeacherSchema.COLUME_NAME));

                Teacher student = new Teacher();
                student.setId(itemId);
                student.setName(itemName);

                lists.add(student);
            }



        } catch (Exception e){

        }finally {
            cursor.close();
        }




        return lists;

    }

    @Override
    public boolean delete(Teacher teacher) {


        String selection = TeacherSchema._ID+ " = ?";
        String[] selectionArgs = { ""+teacher.getId() };

         if(getRead().delete(TeacherSchema.TABLE_NAME,selection,selectionArgs)>0){
             return true;
         }


        return false;
    }

    @Override
    public long update(long id, Teacher teacher) {

        values.put(TeacherSchema.COLUME_NAME,teacher.getName());

        // Which row to update, based on the title
        String selection = TeacherSchema._ID+ " = ?";
        String[] selectionArgs = { ""+id };

        int count = getRead().update(
                TeacherSchema.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }


}
