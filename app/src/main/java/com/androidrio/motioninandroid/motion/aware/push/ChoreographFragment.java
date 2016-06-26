package com.androidrio.motioninandroid.motion.aware.push;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AndroidRio on 09/06/2016.
 */
public class ChoreographFragment extends Fragment {

    @Bind(R.id.choreograph_fab_first)
    FloatingActionButton mFirstFab;
    @Bind(R.id.choreograph_fab_second)
    FloatingActionButton mSecondFab;
    @Bind(R.id.choreograph_fab_third)
    FloatingActionButton mThirdFab;

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
    }

    private void showHeader(View fab) {
        //Does nothing
    }
}