package com.androidrio.motioninandroid.responsive.create;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;

public class NewSurfaceFragment extends Fragment {

    public NewSurfaceFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_new_surface, container, false);
    }
}
