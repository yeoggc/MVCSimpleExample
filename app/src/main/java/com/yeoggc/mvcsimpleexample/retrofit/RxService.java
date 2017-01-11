package com.yeoggc.mvcsimpleexample.retrofit;

import retrofit2.Retrofit;

/**
 * 对使用Retrofi2进行简单封装的类
 * Created by SkyEyesStion on 2016/2/26.
 */
public class RxService {
    private static final String BASEURL = "http://wthrcdn.etouch.cn/";
    private static Retrofit retrofit;


    private RxService() {
    }

    public static <T> T createApi(Class<T> clazz) {
        return genericRetrofit().create(clazz);
    }


    private static Retrofit genericRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(CustomGsonConverterFactory.create())// 使用Gson作为数据转换器
                    .build();
        }
        return retrofit;
    }
}
