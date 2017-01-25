package com.meanroom.greatdb.schema;

import android.provider.BaseColumns;

/**
 * Created by phuon on 25-Jan-17.
 */
public class StudentSchema implements BaseColumns {
    public static final String TABLE_NAME  = "students";

    public static final String  COLUME_NAME = "name";

    public static final String CREATE_TABLE =

            "CREATE TABLE "+ TABLE_NAME +" ("+
                    _ID +" integer primary key,"+
                    COLUME_NAME +" text"+
                    ");";

    public static final String DELETE_TABLE = " drop table if exists "+TABLE_NAME;

}