package com.androidrio.motioninandroid

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidrio.motioninandroid.motion.MotionActivity
import com.androidrio.motioninandroid.motion.type.Motion
import kotlinx.android.synthetic.main.item_home_list.view.*

/**
 * Created by AndroidRio on 18/06/2016.
 */
class HomeListAdapter(private val activity: Activity, private val motionList: List<Motion>) : RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_home_list, parent, false)
        return HomeListViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return motionList.size
    }

    inner class HomeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.itemHomeCard.setOnClickListener {
                val intent = Intent(it.context, MotionActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable(MotionActivity.KEY_MOTION, motionList[this@HomeListViewHolder.adapterPosition])
                intent.putExtras(bundle)
                val options = ActivityOptions.makeSceneTransitionAnimation(activity,
                        Pair.create(it, it.resources.getString(R.string.shared_item_background)))
                it.context.startActivity(intent, options.toBundle())
            }
        }
    }
}
