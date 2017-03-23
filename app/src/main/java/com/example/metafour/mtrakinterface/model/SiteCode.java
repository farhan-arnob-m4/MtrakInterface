package com.example.metafour.mtrakinterface.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by metafour on 3/23/17.
 */

public class SiteCode {
    private String NAME_OF_MY_SHARED_PREFERENCES = "siteCodePreferences";
    private String CURRENT_COUNT_OF_SITE="currentSiteCount";
    private Context mContext;
    SharedPreferences sharedPreferences;
    public SiteCode(Context context){
        mContext = context;
        Log.d("SiteCode","context:"+mContext);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public ArrayList<String> getListOfSiteCode() {
        ArrayList<String> arrayList=new ArrayList<>();
        Integer currentSite = Integer.valueOf(sharedPreferences.getString(CURRENT_COUNT_OF_SITE,"-1"));
        for(int i = currentSite;i>-1;i--){
            String siteCode = sharedPreferences.getString(i+"",-1+"");
                arrayList.add(siteCode);
        }
        return arrayList;

    }

    public void setListOfSiteCode(String newSiteCode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Integer currentSite = Integer.valueOf(sharedPreferences.getString(CURRENT_COUNT_OF_SITE,"-1"));
        currentSite++;
        if(currentSite!=-1){
            editor.putString(CURRENT_COUNT_OF_SITE,currentSite+"");
            editor.putString(currentSite+"",newSiteCode);
            editor.commit();
        }
    }



}
