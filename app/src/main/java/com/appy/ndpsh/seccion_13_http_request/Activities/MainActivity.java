package com.appy.ndpsh.seccion_13_http_request.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appy.ndpsh.seccion_13_http_request.API.API;
import com.appy.ndpsh.seccion_13_http_request.API.APIServices.WeatherService;
import com.appy.ndpsh.seccion_13_http_request.Models.City;
import com.appy.ndpsh.seccion_13_http_request.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText EditTextsearch;
    private TextView textViewcity;
    private TextView textViewDescription;
    private TextView textViewTemp;
    private ImageView img;
    private Button btn;

    private WeatherService service;
    private Call<City> cityCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUI();
        // Creo la instancia al servicio
        service = API.getApi().create(WeatherService.class);
        btn.setOnClickListener(this);

    }

    private void SetUI(){
        EditTextsearch = findViewById(R.id.editTextSearch);
        textViewcity =  findViewById(R.id.textViewCity);
        textViewDescription =  findViewById(R.id.textViewDescription);
        textViewTemp = findViewById(R.id.textViewTemperature);
        img = findViewById(R.id.imageViewIcon);
        btn = findViewById(R.id.buttonSearch);
    }

    @Override
    public void onClick(View v) {

        String city = EditTextsearch.getText().toString();
        if (city != "") {
            //Preparamos la llamada con unos valores
            cityCall = service.getCity(city, API.APP_KEY, "metric", "es");

            cityCall.enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {
                    City city = response.body();
                    setResult(city);
                }

                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    private void setResult(City city) {
        textViewcity.setText(city.getName() + ", " + city.getCountry());
        textViewDescription.setText(city.getDescription());
        textViewTemp.setText(city.getTemperature() + "ºC");
        Picasso.get().load(API.BASE_ICONS + city.getIcon() + API.EXTENSION_ICONS).into(img);
    }
}
