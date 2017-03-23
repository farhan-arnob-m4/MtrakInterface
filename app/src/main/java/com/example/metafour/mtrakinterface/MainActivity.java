package com.example.metafour.mtrakinterface;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.metafour.mtrakinterface.model.SiteCode;
import com.example.metafour.mtrakinterface.ui.SiteCodeFragmentListener;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    private SiteCodeFragmentListener siteCodeFragmentListener;
    private String NAME_OF_MY_SHARED_PREFERENCES = "siteCodePreferences";
    private String DIALOGUE = "dialogue";
    private Button nextButton;
    private EditText newSiteCode;
    private SharedPreferences sharedPreferences;
    ImageView chooseUser;
    SiteCode siteCode ;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences(NAME_OF_MY_SHARED_PREFERENCES, getBaseContext().MODE_PRIVATE);
        siteCode = new SiteCode(getApplicationContext());
        setContentView(R.layout.activity_main);
        chooseUser= (ImageView) findViewById(R.id.image_logo);
        fm = getSupportFragmentManager();
        siteCodeFragmentListener = new SiteCodeFragmentListener();
        nextButton = (Button) findViewById(R.id.button_next);
        newSiteCode = (EditText) findViewById(R.id.text_large1);
        chooseUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                siteCodeFragmentListener.show(fm,DIALOGUE);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"button Next value: "+newSiteCode.getText().toString(),Toast.LENGTH_SHORT).show();
                siteCode.setListOfSiteCode(newSiteCode.getText().toString());
                newSiteCode.setText("");
            }
        });
    }


}
