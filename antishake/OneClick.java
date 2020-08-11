package com.zykg.base.view.antishake;

import java.util.Calendar;

/**
 * Created by Riggs on 2018/12/19
 */
public class OneClick {
    private String methodName;
    private static final int CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    public OneClick(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public boolean check() {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            return false;
        } else {
            return true;
        }
    }

    public boolean check(int delayTime) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > delayTime) {
            lastClickTime = currentTime;
            return false;
        } else {
            return true;
        }
    }
}
