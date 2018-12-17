package com.appy.ndpsh.seccion_13_http_request.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.appy.ndpsh.seccion_13_http_request.Interface.WeatherService;
import com.appy.ndpsh.seccion_13_http_request.Models.City;
import com.appy.ndpsh.seccion_13_http_request.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Preparo la base Url y preparamos la instancia y que trabajen conjutamente retrofit+Gson 
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Creo la instancia al servicio
        WeatherService service = retrofit.create(WeatherService.class);
        //Preparamos la llamada con unos valores
        Call<City> cityCall = service
                .getCity("Seville,ES", "83d645fefd9c6203607f8461363e76e1");

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();

            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

    }
}
