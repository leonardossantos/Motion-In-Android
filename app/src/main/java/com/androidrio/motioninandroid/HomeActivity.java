package com.androidrio.motioninandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidrio.motioninandroid.motion.responsive.ResponsiveListFragment;


public class HomeActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mToolbar = (Toolbar) findViewById(R.id.activity_home_toolbar);

        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            ResponsiveListFragment fragment = ResponsiveListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment, "home_container")
                    .commit();
        }
    }
}
