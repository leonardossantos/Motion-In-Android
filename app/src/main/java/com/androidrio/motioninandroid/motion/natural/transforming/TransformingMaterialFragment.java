package com.androidrio.motioninandroid.motion.natural.transforming;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.androidrio.motioninandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransformingMaterialFragment extends Fragment {


    private Scene mFirstScene;
    private Scene mSecondScene;
    FrameLayout mContainer;

    public static TransformingMaterialFragment newInstance() {
        TransformingMaterialFragment fragment = new TransformingMaterialFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transforming_material, container, false);
        mContainer = (FrameLayout) rootView.findViewById(R.id.fragment_transforming_container);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFirstScene = Scene.getSceneForLayout(mContainer, R.layout.fragment_transforming_material_fscene, getActivity());
        mSecondScene = Scene.getSceneForLayout(mContainer, R.layout.fragment_transforming_material_sscene, getActivity());

        final Transition arcTransition = TransitionInflater.from(getActivity()).inflateTransition(R.transition.trasition_transforming);

        final TransitionManager transitionManager = new TransitionManager();
        transitionManager.setTransition(mFirstScene, mSecondScene, arcTransition);
        transitionManager.setTransition(mSecondScene, mFirstScene, arcTransition);

        mFirstScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                ViewGroup sceneRoot = mFirstScene.getSceneRoot();
                View card = sceneRoot.findViewById(R.id.fragment_transforming_card);
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
                View card = sceneRoot.findViewById(R.id.fragment_transforming_card);
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        transitionManager.transitionTo(mFirstScene);
                    }
                });
            }
        });

        transitionManager.transitionTo(mFirstScene);

        getActivity().setTitle("Transform Material");
    }

}
