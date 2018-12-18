package com.appy.ndpsh.seccion_13_http_request.API;

import com.appy.ndpsh.seccion_13_http_request.API.Deserializer.MyDeserializer;
import com.appy.ndpsh.seccion_13_http_request.Models.City;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String BASE_ICONS = "http://openweathermap.org/img/w/";
    public static final String EXTENSION_ICONS = ".png";

    public static final String APP_KEY = "83d645fefd9c6203607f8461363e76e1";
    private static Retrofit retrofit = null;

    //Preparo la base Url y preparamos la instancia y que trabajen conjutamente retrofit+Gson
    public static Retrofit getApi() {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(City.class, new MyDeserializer());

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
