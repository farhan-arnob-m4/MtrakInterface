package com.example.metafour.mtrakinterface.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.metafour.mtrakinterface.MainActivity;
import com.example.metafour.mtrakinterface.R;
import com.example.metafour.mtrakinterface.model.SiteCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by metafour on 3/23/17.
 */

public class SiteCodeFragmentListener extends DialogFragment{
    View siteView;
    ListView listView;
    ArrayAdapter<String> adapter;
    SiteCode siteCode;
    List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        siteView = inflater.inflate(R.layout.site_view,null);
        listView = (ListView) siteView.findViewById(R.id.list_view_for_site);
        siteCode = new SiteCode(getContext());
        list = siteCode.getListOfSiteCode();
        adapter= new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        getDialog().setTitle("Chooser your site");
        return siteView;
    }
}
