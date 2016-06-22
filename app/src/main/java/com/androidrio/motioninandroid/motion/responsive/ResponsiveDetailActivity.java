package com.androidrio.motioninandroid.motion.responsive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.motion.natural.transforming.TransformingMaterialFragment;

public class ResponsiveDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsive_detail);

        if (savedInstanceState == null) {
            TransformingMaterialFragment fragment = TransformingMaterialFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_root, fragment, "reaction")
                    .commit();
        }
    }
}
