package com.androidrio.motioninandroid.motion

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.androidrio.motioninandroid.R
import com.androidrio.motioninandroid.motion.aware.push.ChoreographFragment
import com.androidrio.motioninandroid.motion.natural.movement.MovementFragment
import com.androidrio.motioninandroid.motion.natural.transforming.TransformingMaterialFragment
import com.androidrio.motioninandroid.motion.responsive.create.NewSurfaceFragment
import com.androidrio.motioninandroid.motion.responsive.react.ReactionListFragment
import com.androidrio.motioninandroid.motion.type.Motion
import kotlinx.android.synthetic.main.activity_motion.*

class MotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)
        setSupportActionBar(motionToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent?.let {
            val motion =  it.extras?.get(KEY_MOTION) as Motion
            val fragment = when (motion) {
                Motion.REACT -> ReactionListFragment.newInstance()
                Motion.CREATE -> NewSurfaceFragment.newInstance()
                Motion.MOVEMENT -> MovementFragment.newInstance()
                Motion.TRANSFORM -> TransformingMaterialFragment.newInstance()
                Motion.CHOREOGRAPH -> ChoreographFragment.newInstance()
            }

            supportFragmentManager.beginTransaction().replace(R.id.contentRoot, fragment, "motion")
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        val KEY_MOTION = "keyMotion"
    }
}
