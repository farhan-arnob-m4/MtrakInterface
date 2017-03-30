package com.example.metafour.mtrakinterface.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metafour.mtrakinterface.R;
import com.example.metafour.mtrakinterface.model.db.DBHelper;

/**
 * Created by farhan-arnob-m4 on 3/23/17.
 */

public class DeleteReconfigureSiteCodeFragmentListener extends DialogFragment {

    View siteView;
    private Button deleteButton;
    private DBHelper dbHelper;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        String textViewString = getArguments().getString("textForTextView");
        siteView = inflater.inflate(R.layout.delete_reconfigure_site_view, null);
        dbHelper = new DBHelper(getContext());
        deleteButton = (Button) siteView.findViewById(R.id.delete_button);
        textView = (TextView) siteView.findViewById(R.id.text_view_for_delete_or_reconfig_fragment);
        textView.setText(textViewString);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dbHelper.deleteContact(textView.getText().toString()) != 0) {
                    Toast.makeText(getContext(), "successfully deleted", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                    startActivity(getActivity().getIntent());
                }
            }
        });


        return siteView;
    }
}
