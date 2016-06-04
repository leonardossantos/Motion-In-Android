package com.androidrio.motioninandroid.responsive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;

public class ReactionListFragment extends Fragment {

    public ReactionListFragment() {
        // Required empty public constructor
    }

    public static ReactionListFragment newInstance() {
        ReactionListFragment fragment = new ReactionListFragment();
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
        return inflater.inflate(R.layout.fragment_reaction_list, container, false);
    }
}
