package com.androidrio.motioninandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.androidrio.motioninandroid.motion.type.Motion
import com.androidrio.motioninandroid.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(homeToolbar)

        val layoutManager = LinearLayoutManager(this)
        homeList.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST, 8)
        homeList.addItemDecoration(itemDecoration)

        val adapter = HomeListAdapter(this, Motion.values().asList())
        homeList.adapter = adapter
    }
}
