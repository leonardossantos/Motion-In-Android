package com.androidrio.motioninandroid.responsive.movement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.androidrio.motioninandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AndroidRio on 04/06/2016.
 */
public class MovementFragment extends Fragment {
    private Scene mFirstScene;
    private Scene mSecondScene;
    @Bind(R.id.fragment_movement_container)
    FrameLayout mContainer;

    public static MovementFragment newInstance() {
        MovementFragment fragment = new MovementFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movement, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFirstScene = Scene.getSceneForLayout(mContainer, R.layout.fragment_movement_fscene, getActivity());
        mSecondScene = Scene.getSceneForLayout(mContainer, R.layout.fragment_movement_sscene, getActivity());

        final Transition arcTransition = TransitionInflater.from(getActivity()).inflateTransition(R.transition.trasition_arc);

        final TransitionManager transitionManager = new TransitionManager();
        transitionManager.setTransition(mFirstScene, mSecondScene, arcTransition);
        transitionManager.setTransition(mSecondScene, mFirstScene, arcTransition);

        mFirstScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                ViewGroup sceneRoot = mFirstScene.getSceneRoot();
                CardView card = (CardView) sceneRoot.findViewById(R.id.fragment_movement_card);
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        transitionManager.transitionTo(mSecondScene);
                    }
                });
            }
        });

        mSecondScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                ViewGroup sceneRoot = mSecondScene.getSceneRoot();
                CardView card = (CardView) sceneRoot.findViewById(R.id.fragment_movement_card);
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        transitionManager.transitionTo(mFirstScene);
                    }
                });
            }
        });

        transitionManager.transitionTo(mFirstScene);

    }
}