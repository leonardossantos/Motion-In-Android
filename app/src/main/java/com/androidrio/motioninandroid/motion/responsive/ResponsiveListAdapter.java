package com.androidrio.motioninandroid.motion.responsive;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.model.Motion;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AndroidRio on 18/06/2016.
 */
public class ResponsiveListAdapter extends RecyclerView.Adapter {
    private Activity mActivity;
    private List<Motion> mMotionList;

    public ResponsiveListAdapter(Activity activity, List<Motion> motionList) {
        mActivity = activity;
        mMotionList = motionList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_list, parent, false);
        RecyclerView.ViewHolder viewHolder = new HomeListItem(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mMotionList.size();
    }

    class HomeListItem extends RecyclerView.ViewHolder {

        @Bind(R.id.item_home_card)
        CardView mHomeCard;

        public HomeListItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mHomeCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MotionActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MotionActivity.KEY_MOTION, mMotionList.get(HomeListItem.this.getAdapterPosition()));
                    intent.putExtras(bundle);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity,
                            Pair.create(v, "background"));
                    v.getContext().startActivity(intent, options.toBundle());
                }
            });
        }
    }
}
