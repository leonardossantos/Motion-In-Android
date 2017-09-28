package com.androidrio.motioninandroid.motion.aware.push

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.RelativeLayout
import com.androidrio.motioninandroid.R
import com.androidrio.motioninandroid.util.UIUtils
import com.androidrio.motioninandroid.widget.TransitionListenerAdapter
import kotlinx.android.synthetic.main.fragment_choreograph.*

/**
 * Created by AndroidRio on 09/06/2016.
 *
 * This fragment can and will be refactored in the future. This is just one of the many possible ways
 * of implementing the Google's example https://material-design.storage.googleapis.com/publish/material_v_8/material_ext_publish/0B14F_FSUCc01TkJIam1HM0VsdEU/Aware_01_Choreo-v2.webm
 * Keep in mind that this would be way easier if implemented using fragment/activity transitions
 * since we wouldn't have to deal with views location.
 */
class ChoreographFragment : Fragment() {

    lateinit var fabOriginalParams: RelativeLayout.LayoutParams
    lateinit var unselectedFabs: ArrayList<View>
    lateinit var selectedFab: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_choreograph, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        unselectedFabs = arrayListOf(
                choreographFabFirst,
                choreographFabSecond,
                choreographFabThird
        )

        activity.title = "Choreograph"
        val listener = View.OnClickListener { v ->
            fabOriginalParams = v.layoutParams as RelativeLayout.LayoutParams
            selectedFab = v
            showHeader(v)
        }

        choreographFabFirst.setOnClickListener(listener)
        choreographFabSecond.setOnClickListener(listener)
        choreographFabThird.setOnClickListener(listener)

        choreographHeader.setOnClickListener { hideView(choreographHeader) }
    }

    private fun showHeader(fab: View) {
        val arcTransition = TransitionInflater.from(activity).inflateTransition(R.transition.trasition_choreograph)
        arcTransition.addListener(object : TransitionListenerAdapter() {
            override fun onTransitionStart(transition: Transition) {
                unselectedFabs.filter { it != fab }.forEach {
                    it.animate().alpha(0f)
                    it.isEnabled = false
                }
            }

            override fun onTransitionEnd(transition: Transition) {
                revealView(fab, choreographHeader, R.color.colorAccent)
            }
        })

        TransitionManager.beginDelayedTransition(choreographContentRoot, arcTransition)
        val layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
        layoutParams.setMargins(0, UIUtils.dpToPx(50), 0, 0)
        fab.layoutParams = layoutParams
    }

    private fun showFab(fab: View, layoutParams: RelativeLayout.LayoutParams) {
        val arcTransition = TransitionInflater.from(activity).inflateTransition(R.transition.trasition_choreograph)
        TransitionManager.beginDelayedTransition(choreographContentRoot, arcTransition)
        fab.layoutParams = layoutParams
        for (view in unselectedFabs) {
            view.animate().alpha(1f)
            view.isEnabled = true
        }
    }

    private fun revealView(sourceView: View, targetView: View, @ColorRes revealColor: Int) {
        val cx = (targetView.left + targetView.right) / 2
        val cy = (targetView.top + targetView.bottom) / 2
        val finalRadius = Math.hypot(targetView.width.toDouble(), targetView.height.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(targetView, cx, cy, sourceView.width.toFloat(), finalRadius)
        targetView.visibility = View.VISIBLE
        targetView.setBackgroundColor(ContextCompat.getColor(activity, revealColor))
        anim.duration = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
        anim.interpolator = AccelerateDecelerateInterpolator()
        anim.start()
    }

    private fun hideView(view: View) {
        val cx = (view.left + view.right) / 2
        val cy = (view.top + view.bottom) / 2
        val initialRadius = view.width
        val anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius.toFloat(), choreographFabFirst.width.toFloat())
        anim.duration = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
        anim.interpolator = AccelerateDecelerateInterpolator()
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.INVISIBLE
                showFab(selectedFab, fabOriginalParams)
            }
        })
        anim.start()
    }

    companion object {

        fun newInstance(): ChoreographFragment {
            return ChoreographFragment()
        }
    }
}