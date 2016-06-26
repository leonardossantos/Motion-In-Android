package com.androidrio.motioninandroid.motion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.model.Motion;
import com.androidrio.motioninandroid.motion.natural.movement.MovementFragment;
import com.androidrio.motioninandroid.motion.natural.transforming.TransformingMaterialFragment;
import com.androidrio.motioninandroid.motion.responsive.create.NewSurfaceFragment;
import com.androidrio.motioninandroid.motion.responsive.react.ReactionListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MotionActivity extends AppCompatActivity {
    public static final String KEY_MOTION = "keyMotion";

    @Bind(R.id.motion_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            Motion motion = bundle.getParcelable(KEY_MOTION);

            Fragment fragment;

            switch (motion.getMotionType()) {
                case Motion.MOTION_TYPE_REACT:
                    fragment = ReactionListFragment.newInstance();
                    break;
                case Motion.MOTION_TYPE_CREATE:
                    fragment = NewSurfaceFragment.newInstance();
                    break;
                case Motion.MOTION_TYPE_MOVEMENT:
                    fragment = MovementFragment.newInstance();
                    break;
                default:
                    fragment = TransformingMaterialFragment.newInstance();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.content_root, fragment, "motion")
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
