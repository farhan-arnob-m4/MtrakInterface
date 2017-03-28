package com.example.metafour.mtrakinterface.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.metafour.mtrakinterface.model.SiteDetails;

import java.util.ArrayList;
import java.util.Collections;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDBName.db";
    private static final String SITE_CODE_TABLE_NAME = "sitetable";
    private static final String ID_COLUMN = "id";
    private static final String SITE_CODE_COLUMN = "sitecode";
    private Context mContext;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table  " + SITE_CODE_TABLE_NAME +
                        "( id integer primary key AUTOINCREMENT, " + SITE_CODE_COLUMN + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + SITE_CODE_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSiteCode(String sitecode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SITE_CODE_COLUMN, sitecode);
        db.insert(SITE_CODE_TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, SITE_CODE_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact(Integer id, String name, String phone, String email, String street, String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SITE_CODE_COLUMN, name);
        db.update(SITE_CODE_TABLE_NAME, contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(SITE_CODE_TABLE_NAME,
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<SiteDetails> getAllSiteCode() {
        ArrayList<SiteDetails> array_list = new ArrayList<SiteDetails>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + SITE_CODE_TABLE_NAME, null);
        res.moveToFirst();
        int i = 0;
        while (!res.isAfterLast()) {
            String sideCode = res.getString(res.getColumnIndex(SITE_CODE_COLUMN));
            array_list.add(new SiteDetails("iTrakII - " + sideCode, "Pfizer Australia"));
            res.moveToNext();
        }
        res.close();
        Collections.reverse(array_list);
        return array_list;
    }
}