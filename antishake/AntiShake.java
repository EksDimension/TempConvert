package com.zykg.base.view.antishake;

/**
 * Created by Riggs on 2018/12/19
 */
public class AntiShake {
    private static LimitQueue<OneClick> queue = new LimitQueue<>(20);

    public static boolean check(Object o) {
        String flag;
        if (o == null) {
            flag = Thread.currentThread().getStackTrace()[2].getMethodName();
        } else {
            flag = o.toString();
        }
        for (OneClick util : queue.getArrayList()) {
            if (util.getMethodName().equals(flag)) {
                return util.check();
            }
        }
        OneClick clickUtil = new OneClick(flag);
        queue.offer(clickUtil);
        return clickUtil.check();
    }

    public static boolean check(Object o, int delayTime) {
        String flag;
        if (o == null) {
            flag = Thread.currentThread().getStackTrace()[2].getMethodName();
        } else {
            flag = o.toString();
        }
        for (OneClick util : queue.getArrayList()) {
            if (util.getMethodName().equals(flag)) {
                return util.check(delayTime);
            }
        }
        OneClick clickUtil = new OneClick(flag);
        queue.offer(clickUtil);
        return clickUtil.check(delayTime);
    }
}