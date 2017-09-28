package com.androidrio.motioninandroid.motion.responsive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.model.Motion;
import com.androidrio.motioninandroid.widget.DividerItemDecoration;

import java.util.Arrays;

/**
 * Created by AndroidRio on 22/06/2016.
 */
public class ResponsiveListFragment extends Fragment {

    RecyclerView mResponsiveList;

    public static ResponsiveListFragment newInstance() {
        ResponsiveListFragment fragment = new ResponsiveListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_responsive, container, false);
        mResponsiveList = (RecyclerView) rootView.findViewById(R.id.fragment_responsive_list);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mResponsiveList.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST, 8);
        mResponsiveList.addItemDecoration(itemDecoration);

        ResponsiveListAdapter adapter = new ResponsiveListAdapter(getActivity(), Arrays.asList(Motion.values()));
        mResponsiveList.setAdapter(adapter);
    }
}