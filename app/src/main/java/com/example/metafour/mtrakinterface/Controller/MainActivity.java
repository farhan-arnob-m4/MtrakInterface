package com.example.metafour.mtrakinterface.Controller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.metafour.mtrakinterface.R;
import com.example.metafour.mtrakinterface.model.SiteCode;
import com.example.metafour.mtrakinterface.model.SiteDetails;
import com.example.metafour.mtrakinterface.ui.SiteCodeFragmentListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SiteArrayAdapter adapter;
    ListView listView;
    View listViewLinearLayout;
    ArrayList<SiteDetails> list;
    SiteCode siteCode;
    private FragmentManager fm;
    private SiteCodeFragmentListener siteCodeFragmentListener;
    private String NAME_OF_MY_SHARED_PREFERENCES = "siteCodePreferences";
    private String DIALOGUE = "dialogue";
    private FloatingActionButton newSiteButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences(NAME_OF_MY_SHARED_PREFERENCES, getBaseContext().MODE_PRIVATE);
        siteCode = new SiteCode(getApplicationContext());
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        siteCodeFragmentListener = new SiteCodeFragmentListener();
        newSiteButton = (FloatingActionButton) findViewById(R.id.new_user_fab);
        listViewLinearLayout = findViewById(R.id.list_view_linear_layout);
        listView = (ListView) findViewById(R.id.list_view_for_site);
        list = siteCode.getListOfSiteCode();
        if (list.size() <= 0) {
            listViewLinearLayout.setVisibility(View.GONE);
        }
        Toast.makeText(getApplicationContext(), "size:" + list.size(), Toast.LENGTH_SHORT).show();
        adapter = new SiteArrayAdapter(getBaseContext(), list);
        listView.setAdapter(adapter);

        newSiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siteCodeFragmentListener.show(fm, DIALOGUE);
            }
        });


    }


}
