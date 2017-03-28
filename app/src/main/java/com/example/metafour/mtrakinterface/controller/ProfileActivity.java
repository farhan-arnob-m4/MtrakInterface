package com.example.metafour.mtrakinterface.controller;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.metafour.mtrakinterface.R;

/**
 * Created by metafour on 3/28/17.
 */

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/DejaVuSansCondensed-Bold.ttf");

        getMenuInflater().inflate(R.menu.user_profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_new_config:
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                getBaseContext().startActivity(i);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_logout:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }
}
