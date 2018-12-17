package com.appy.ndpsh.seccion_13_http_request.Interface;

import com.appy.ndpsh.seccion_13_http_request.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather")
    Call<City> getCity(@Query("q") String City, @Query("appid") String key);
}
