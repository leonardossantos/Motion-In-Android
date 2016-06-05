package com.androidrio.motioninandroid.responsive.react;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.widget.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReactionListFragment extends Fragment {

    @Bind(R.id.fragment_reaction_list)
    RecyclerView mReactionList;

    public ReactionListFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_reaction_list, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST, 16);
        mReactionList.addItemDecoration(itemDecoration);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mReactionList.setLayoutManager(layoutManager);
        ReactionListAdapter adapter = new ReactionListAdapter();
        mReactionList.setAdapter(adapter);
    }
}
