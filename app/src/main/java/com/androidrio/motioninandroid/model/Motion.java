package com.androidrio.motioninandroid.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by AndroidRio on 22/06/2016.
 */
public final class Motion implements Parcelable {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({MOTION_TYPE_REACT, MOTION_TYPE_CREATE, MOTION_TYPE_MOVEMENT, MOTION_TYPE_TRANSFORM, MOTION_TYPE_CHOREOGRAPH})
    public @interface MotionType {
    }

    public static final int MOTION_TYPE_REACT = 1;
    public static final int MOTION_TYPE_CREATE = 2;
    public static final int MOTION_TYPE_MOVEMENT = 3;
    public static final int MOTION_TYPE_TRANSFORM = 4;
    public static final int MOTION_TYPE_CHOREOGRAPH = 5;

    @MotionType
    private int motionType;

    public Motion(@MotionType int motionType) {
        this.motionType = motionType;
    }

    @MotionType
    public int getMotionType() {
        return motionType;
    }

    protected Motion(Parcel in) {
        motionType = in.readInt();
    }

    public static final Creator<Motion> CREATOR = new Creator<Motion>() {
        @Override
        public Motion createFromParcel(Parcel in) {
            return new Motion(in);
        }

        @Override
        public Motion[] newArray(int size) {
            return new Motion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(motionType);
    }
}
