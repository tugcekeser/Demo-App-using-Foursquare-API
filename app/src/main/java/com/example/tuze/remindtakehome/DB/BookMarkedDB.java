package com.example.tuze.remindtakehome.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BookMarkedDB {
    public static final String KEY_ROWID = "Rowid";
    public static final String KEY_VENUEID = "VenueId";
    public static final String KEY_MARKED = "Marked";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_CREATE = "create table if not exists " +
            "Venue (Rowid integer primary key autoincrement, VenueId text not null,Marked integer);";

    private static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS Venue";
    private static final String SELECT_SQL = "select * from ";
    private static final String DATABASE_NAME = "foursquare";
    private static final String DATABASE_TABLE = "Venue";
    private static final int DATABASE_VERSION = 1;
    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public BookMarkedDB(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, oldVersion + " to " + newVersion
                    + ", which will destroy all old data");
            db.execSQL(DROP_TABLE_SQL);
            onCreate(db);
        }
    }

    //Open DB
    public BookMarkedDB open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //Close DB
    public void close() {
        DBHelper.close();
    }

    //Add venue bookmark
    public long insertVenue(String venueId) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_VENUEID, venueId);
        initialValues.put(KEY_MARKED, 0);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //Delete venue bookmark
    public boolean deleteVenue(String venueId) {
        return db.delete(DATABASE_TABLE, KEY_VENUEID + "=" + venueId, null) > 0;
    }

    //Get all venue bookmark values
    public Cursor getAllVenues() {
        return db.rawQuery(SELECT_SQL+ DATABASE_TABLE, null);
    }

    //Read venue bookmark
    public Cursor getVenue(String venueId) throws SQLException {
        String selectQuery = SELECT_SQL + DATABASE_TABLE
                + " where " + KEY_VENUEID + " = " + "'" + venueId + "'";

        Cursor mCursor = db.rawQuery(selectQuery, null);
        return mCursor;
    }

    //Update venue bookmark
    public boolean updateVenue(String venueId, int marked) {
        ContentValues args = new ContentValues();
        args.put(KEY_MARKED, marked);
        return db.update(DATABASE_TABLE, args, KEY_VENUEID + "= '" + venueId + "'", null) > 0;
    }

}