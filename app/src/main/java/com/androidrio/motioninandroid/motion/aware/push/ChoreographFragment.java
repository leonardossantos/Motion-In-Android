package com.androidrio.motioninandroid.motion.aware.push;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.util.UIUtils;
import com.androidrio.motioninandroid.widget.TransitionListenerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AndroidRio on 09/06/2016.
 */
public class ChoreographFragment extends Fragment {

    @Bind(R.id.choreograph_header)
    View mHeader;
    @Bind(R.id.choreograph_fab_first)
    FloatingActionButton mFirstFab;
    @Bind(R.id.choreograph_fab_second)
    FloatingActionButton mSecondFab;
    @Bind(R.id.choreograph_fab_third)
    FloatingActionButton mThirdFab;
    @Bind(R.id.choreograph_content_root)
    RelativeLayout mContentRoot;

    public static ChoreographFragment newInstance() {
        ChoreographFragment fragment = new ChoreographFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choreograph, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHeader(v);
            }
        };

        mFirstFab.setOnClickListener(listener);
        mSecondFab.setOnClickListener(listener);
        mThirdFab.setOnClickListener(listener);

        mHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideView(mHeader);
            }
        });
    }

    private void showHeader(final View fab) {
        final Transition arcTransition = TransitionInflater.from(getActivity()).inflateTransition(R.transition.trasition_choreograph);
        arcTransition.addListener(new TransitionListenerAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                revealView(fab, mHeader, R.color.colorAccent);
            }
        });

        TransitionManager.beginDelayedTransition(mContentRoot, arcTransition);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.setMargins(0, UIUtils.dpToPx(50), 0, 0);
        fab.setLayoutParams(layoutParams);
    }

    private void revealView(View sourceView, View targetView, @ColorRes int revealColor) {
        int cx = (targetView.getLeft() + targetView.getRight()) / 2;
        int cy = (targetView.getTop() + targetView.getBottom()) / 2;
        float finalRadius = (float) Math.hypot(targetView.getWidth(), targetView.getHeight());
        Animator anim = ViewAnimationUtils.createCircularReveal(targetView, cx, cy, sourceView.getWidth(), finalRadius);
        targetView.setVisibility(View.VISIBLE);
        targetView.setBackgroundColor(ContextCompat.getColor(getActivity(), revealColor));
        anim.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }

    private void hideView(final View view) {
        //Does nothing
    }
}