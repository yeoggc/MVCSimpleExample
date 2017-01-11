package com.yeoggc.mvcsimpleexample.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yeoggc on 2017/1/11.
 */

//http://wthrcdn.etouch.cn/weather_mini?city=%E6%B7%B1%E5%9C%B3

public interface WeatherService {
    @GET("weather_mini")
    Call<WeatherBean> getWeahterInfo(@Query("city") String city);
}
