package com.androidrio.motioninandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidrio.motioninandroid.motion.responsive.ResponsiveListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.activity_home_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            ResponsiveListFragment fragment = ResponsiveListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment, "home_container")
                    .commit();
        }
    }
}
