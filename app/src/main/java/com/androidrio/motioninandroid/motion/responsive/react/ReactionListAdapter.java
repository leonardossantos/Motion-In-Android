package com.androidrio.motioninandroid.motion.responsive.react;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.widget.AnimatableAdapter;

/**
 * Created by AndroidRio on 13/04/2016.
 */
public class ReactionListAdapter extends RecyclerView.Adapter<ReactionListAdapter.ReactionItemViewHolder> implements AnimatableAdapter{

    private int lastAnimatedPosition;
    private boolean animationsLocked = false;
    private boolean delayEnterAnimation = true;
    private int itemsCount = 0;

    public ReactionListAdapter() {
    }

    @Override
    public ReactionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reaction_list, parent, false);
        ReactionItemViewHolder holder = new ReactionItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReactionItemViewHolder holder, int position) {
        runEnterAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }

    @Override
    public void animateContent() {
        itemsCount = 5;
        notifyDataSetChanged();
    }

    public class ReactionItemViewHolder extends RecyclerView.ViewHolder {


        public ReactionItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    private void runEnterAnimation(View view, int position) {
        if (animationsLocked) return;

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(100);
            view.setAlpha(0.f);
            view.animate()
                    .translationY(0).alpha(1.f)
                    .setStartDelay(delayEnterAnimation? 20 * (position) : 0)
                    .setInterpolator(new DecelerateInterpolator(2.f))
                    .setDuration(300)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            animationsLocked = true;
                        }
                    })
                    .start();
        }
    }

}
