package com.example.shaikhbro.classsavingtest.Utils;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

/**
 * Created by ShaikhBro on 5/15/2017.
 */
public class DBHelper {


    DB snappyDB;
    private final static String MY_DB = "FIRST_DB";
    private final static String USER_ONE_INT = "USER_ONE_INT";
    private final static String USER_ONE_FLOAT = "USER_ONE_FLOAT";
    private final static String USER_ONE_STRING = "USER_ONE_STRING";

    // create DB with a given name
    public void createDB(Context context) {
        try {
            snappyDB = DBFactory.open(context, MY_DB);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    // insert primitive types (Integer)

    public void saveInt(Context context, int number) {
        try {
            snappyDB = DBFactory.open(context, MY_DB);
            snappyDB.putInt(USER_ONE_INT, number);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    // insert primitive type (Float)

    public void saveFloat(Context context, float decimal) {
        try {
            snappyDB = DBFactory.open(context, MY_DB);
            snappyDB.putFloat(USER_ONE_FLOAT, decimal);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    // insert String type (String)

    public void saveString(Context context, String name) {
        try {
            snappyDB = DBFactory.open(context, MY_DB);
            snappyDB.put(USER_ONE_STRING, name);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    // show primitive type (Integer)

    public int getInt(Context context) {
        int number = 0;
        try {

            snappyDB = DBFactory.open(context,MY_DB);
            number = snappyDB.getInt(USER_ONE_INT);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
        return number;
    }

    // show primitive type (Float)
    public float getFloat(Context context) {
        float decimal = 0f;
        try {
            snappyDB = DBFactory.open(context,MY_DB);
            decimal = snappyDB.getFloat(USER_ONE_FLOAT);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
        return decimal;
    }

    // show String type (String)
    public String getString(Context context) {
        String name = "";
        try {
            snappyDB = DBFactory.open(context,MY_DB);
            name = snappyDB.get(USER_ONE_STRING);
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
        return name;
    }
}
