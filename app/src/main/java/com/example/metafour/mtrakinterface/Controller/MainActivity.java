package com.example.metafour.mtrakinterface.Controller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

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
    private ImageView logoImage;
    private SharedPreferences sharedPreferences;
    private boolean listViewSizeFlag = true;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences(NAME_OF_MY_SHARED_PREFERENCES, getBaseContext().MODE_PRIVATE);
        siteCode = new SiteCode(getApplicationContext());
        setContentView(R.layout.activity_main);


        //getting or creating object
        siteCodeFragmentListener = new SiteCodeFragmentListener();
        fm = getSupportFragmentManager();
        list = siteCode.getListOfSiteCode();
        adapter = new SiteArrayAdapter(getBaseContext(), list);

        //initializing view
        logoImage = (ImageView) findViewById(R.id.image_logo);
        newSiteButton = (FloatingActionButton) findViewById(R.id.new_user_fab);
        listViewLinearLayout = findViewById(R.id.list_view_linear_layout);
        listView = (ListView) findViewById(R.id.list_view_for_site);

        //setting adapter
        listView.setAdapter(adapter);

        //if empty user listView will be gone.
        if (list.size() <= 0) {
            listViewLinearLayout.setVisibility(View.GONE);
        }

        //floating button for new user
        newSiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siteCodeFragmentListener.show(fm, DIALOGUE);
            }
        });

        //setting listener to the image_logo for changing listViewLinearLayout
        logoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listViewSizeFlag) {
                    // Gets the layout params that will allow you to resize the layout
                    ViewGroup.LayoutParams params = listViewLinearLayout.getLayoutParams();
                    // Changes the height to the specified *pixels*
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());
                    params.height = height;
                    listViewLinearLayout.setLayoutParams(params);

                    listViewSizeFlag = false;
                } else {
                    // Gets the layout params that will allow you to resize the layout
                    ViewGroup.LayoutParams params = listViewLinearLayout.getLayoutParams();
                    // Changes the height to the specified *pixels*
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 278, getResources().getDisplayMetrics());
                    params.height = height;
                    listViewLinearLayout.setLayoutParams(params);

                    listViewSizeFlag = true;
                }

            }
        });


    }


}
