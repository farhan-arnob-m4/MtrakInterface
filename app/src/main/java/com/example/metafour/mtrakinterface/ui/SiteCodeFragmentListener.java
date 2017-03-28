package com.example.metafour.mtrakinterface.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.metafour.mtrakinterface.R;
import com.example.metafour.mtrakinterface.model.SiteCode;
import com.example.metafour.mtrakinterface.model.db.DBHelper;

/**
 * Created by farhan-arnob-m4 on 3/23/17.
 */

public class SiteCodeFragmentListener extends DialogFragment{

    View siteView;
    SiteCode siteCode;
    private Button newUserButton;
    private EditText newSiteCode;
    private DBHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        siteView = inflater.inflate(R.layout.site_view,null);
        siteCode = new SiteCode(getContext());
        newUserButton = (Button) siteView.findViewById(R.id.new_user_button);
        newSiteCode = (EditText) siteView.findViewById(R.id.text_large1);
        dbHelper = new DBHelper(getContext());
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newSiteText = newSiteCode.getText().toString();
                if (!newSiteText.equals("") && newSiteText.length() == 6) {
                    dbHelper.insertSiteCode(newSiteText);
                    siteCode.setListOfSiteCode(newSiteText);
                    newSiteCode.setText("");
                    getActivity().finish();
                    startActivity(getActivity().getIntent());
                } else {
                    Toast.makeText(getContext(), "Site code Error!", Toast.LENGTH_SHORT).show();
                }
                getDialog().dismiss();
            }
        });
        return siteView;
    }
}
