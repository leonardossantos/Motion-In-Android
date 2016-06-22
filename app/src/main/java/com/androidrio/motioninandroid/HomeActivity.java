package com.androidrio.motioninandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.androidrio.motioninandroid.widget.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.home_list)
    RecyclerView mHomeList;
    @Bind(R.id.activity_home_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mHomeList.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST, 8);
        mHomeList.addItemDecoration(itemDecoration);
        HomeListAdapter adapter = new HomeListAdapter(this);
        mHomeList.setAdapter(adapter);
    }
}
