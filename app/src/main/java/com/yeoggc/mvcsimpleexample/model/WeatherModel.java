package com.yeoggc.mvcsimpleexample.model;

import com.yeoggc.mvcsimpleexample.retrofit.RxService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yeoggc on 2017/1/11.
 */

public class WeatherModel {

    public void getWeatherInfo(String cityName, final OnWeathInfoListener listener) {
        Call<WeatherBean> call = RxService.createApi(WeatherService.class).getWeahterInfo(cityName);
        call.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onSuccess(response.body());
                } else {
                    onFailure(call, null);
                }
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                listener.onFailed();
            }
        });
    }

}
