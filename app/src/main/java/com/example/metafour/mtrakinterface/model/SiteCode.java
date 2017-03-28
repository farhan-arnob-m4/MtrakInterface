package com.example.metafour.mtrakinterface.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.metafour.mtrakinterface.model.db.DBHelper;

import java.util.ArrayList;

/**
 * Created by metafour on 3/23/17.
 */

public class SiteCode {
    SharedPreferences sharedPreferences;
    private String NAME_OF_MY_SHARED_PREFERENCES = "siteCodePreferences";
    private String CURRENT_COUNT_OF_SITE="currentSiteCount";
    private Context mContext;
    private DBHelper mydb;
    public SiteCode(Context context){
        mContext = context;
        Log.d("SiteCode","context:"+mContext);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mydb = new DBHelper(context);
    }

    public ArrayList<SiteDetails> getListOfSiteCode() {
//        ArrayList<SiteDetails> arrayList = new ArrayList<>();
//        SiteDetails siteDetails = new SiteDetails();
//        for (int i = 0; i < 8; i++) {
//            arrayList.add(siteDetails);
//        }
        return mydb.getAllSiteCode();

    }

    public void setListOfSiteCode(String newSiteCode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Integer currentSite = Integer.valueOf(sharedPreferences.getString(CURRENT_COUNT_OF_SITE,"-1"));
        currentSite++;
        if(currentSite!=-1){
            editor.putString(CURRENT_COUNT_OF_SITE,currentSite+"");
            editor.putString(currentSite+"",newSiteCode);
            editor.apply();
        }
    }



}
