package com.yeoggc.mvcsimpleexample.model;

/**
 * Created by yeoggc on 2017/1/11.
 */

public interface OnWeathInfoListener {

    void onSuccess(WeatherBean weatherBean);

    void onFailed();
}
