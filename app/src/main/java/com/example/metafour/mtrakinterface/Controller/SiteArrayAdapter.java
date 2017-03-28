package com.example.metafour.mtrakinterface.Controller;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.metafour.mtrakinterface.R;
import com.example.metafour.mtrakinterface.model.SiteDetails;

import java.util.ArrayList;

/**
 * Created by farhan-arnob-m4 on 3/24/17.
 */

public class SiteArrayAdapter extends ArrayAdapter<SiteDetails> {
    public SiteArrayAdapter(Context context, ArrayList<SiteDetails> sites) {
        super(context, 0, sites);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SiteDetails singleSiteDetails = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout_for_site_code, parent, false);
        }


        // Lookup view for data population
        TextView siteName = (TextView) convertView.findViewById(R.id.site_name);
        TextView siteCode = (TextView) convertView.findViewById(R.id.site_code);

        //changing typeface
        Typeface type = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/DejaVuSansCondensed-Bold.ttf");
        siteCode.setTypeface(type);
        siteName.setTypeface(type);
        // Populate the data into the template view using the data object
        siteName.setText(singleSiteDetails.getSiteName());
        siteCode.setText(singleSiteDetails.getSiteCode());
        // Return the completed view to render on screen
        return convertView;
    }
}