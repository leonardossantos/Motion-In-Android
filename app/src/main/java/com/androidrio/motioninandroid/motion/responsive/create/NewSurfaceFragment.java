package com.androidrio.motioninandroid.motion.responsive.create;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.util.UIUtils;
import com.androidrio.motioninandroid.widget.AnimationListenerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewSurfaceFragment extends Fragment {
    public static final int CARD_HEIGHT = 160;
    @Bind(R.id.fragment_new_surface_toggle)
    ImageButton mToogle;
    @Bind(R.id.fragment_new_surface_card)
    CardView mCard;

    public NewSurfaceFragment() {
    }

    public static NewSurfaceFragment newInstance() {
        NewSurfaceFragment fragment = new NewSurfaceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_new_surface, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCard.setPivotY(UIUtils.dpToPx(CARD_HEIGHT));
        mToogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCard.getVisibility() == View.GONE) {
                    mCard.setPivotY(UIUtils.dpToPx(CARD_HEIGHT));
                    mCard.setVisibility(View.VISIBLE);
                    AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.animator_scale);
                    animator.setTarget(mCard);
                    animator.start();
                } else {
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_new_surface_collapse);
                    animation.setAnimationListener(new AnimationListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mCard.setVisibility(View.GONE);
                        }
                    });
                    mCard.startAnimation(animation);
                }
            }
        });

        getActivity().setTitle("New Surface");
    }
}
