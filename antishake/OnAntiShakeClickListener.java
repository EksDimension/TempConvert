package com.zykg.base.view.antishake;

import android.view.View;

/**
 * Created by Riggs on 2018/12/19
 */
public abstract class OnAntiShakeClickListener implements View.OnClickListener {
    private int executeDelayTime = -1;

    @Override
    public void onClick(View v) {
        if (executeDelayTime == -1) {
            if (AntiShake.check(v.getId())) return;
        } else {
            if (AntiShake.check(v.getId(), executeDelayTime)) return;
        }
        onAntiShakeClick(v);
    }

    public abstract void onAntiShakeClick(View v);

    public void setDelayTime(int executeDelayTime) {
        this.executeDelayTime = executeDelayTime;
    }
}
