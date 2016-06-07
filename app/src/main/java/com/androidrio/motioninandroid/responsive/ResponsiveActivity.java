package com.androidrio.motioninandroid.responsive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidrio.motioninandroid.R;
import com.androidrio.motioninandroid.responsive.movement.MovementFragment;

public class ResponsiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsive);

        if (savedInstanceState == null) {
            MovementFragment fragment = MovementFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_root, fragment, "reaction")
                    .commit();
        }
    }
}
