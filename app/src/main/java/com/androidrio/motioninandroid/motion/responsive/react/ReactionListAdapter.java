package com.androidrio.motioninandroid.motion.responsive.react;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;

/**
 * Created by AndroidRio on 13/04/2016.
 */
public class ReactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ReactionListAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reaction_list, parent, false);
        ReactionItemViewHolder holder = new ReactionItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ReactionItemViewHolder extends RecyclerView.ViewHolder {

        public ReactionItemViewHolder(View itemView) {
            super(itemView);
        }

    }

}
