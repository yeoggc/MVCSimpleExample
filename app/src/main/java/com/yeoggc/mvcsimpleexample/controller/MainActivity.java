package com.yeoggc.mvcsimpleexample.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yeoggc.mvcsimpleexample.R;
import com.yeoggc.mvcsimpleexample.model.OnWeathInfoListener;
import com.yeoggc.mvcsimpleexample.model.WeatherBean;
import com.yeoggc.mvcsimpleexample.model.WeatherModel;

/**
 * 在Android的MVC中，activity扮演的角色是Controller.
 */
public class MainActivity extends AppCompatActivity implements OnWeathInfoListener{
    TextView tvDate;
    TextView tvWeatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    /**
     *   注释1
     */

    private void initView() {

        tvDate = (TextView) findViewById(R.id.tvDate);
        tvWeatherInfo = (TextView) findViewById(R.id.tvWeatherInfo);

    }


    public void getWeathInfo(View v) {
        WeatherModel weatherModel = new WeatherModel();
        weatherModel.getWeatherInfo("深圳",this);
    }

    @Override
    public void onSuccess(WeatherBean weatherBean) {

        WeatherBean.DataBean.ForecastBean forecastBean = weatherBean.getData().getForecast().get(0);//今天天气数据

        tvDate.setText(forecastBean.getDate()+": ");
        tvWeatherInfo.setText(forecastBean.getType());

    }

    @Override
    public void onFailed() {
        Toast.makeText(getApplicationContext(),"获取今天天气失败..",Toast.LENGTH_LONG).show();
    }
}
