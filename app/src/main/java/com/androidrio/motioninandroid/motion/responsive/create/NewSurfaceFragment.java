package com.androidrio.motioninandroid.motion.responsive.create;

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

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewSurfaceFragment extends Fragment {
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

        mToogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCard.getVisibility() == View.GONE) {
                    mCard.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_new_surface_expand);
                    mCard.startAnimation(animation);
                }else{
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_new_surface_collapse);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mCard.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    mCard.startAnimation(animation);
                }
            }
        });
    }
}
