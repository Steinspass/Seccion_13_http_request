package com.appy.ndpsh.seccion_13_http_request.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.appy.ndpsh.seccion_13_http_request.Models.City;
import com.appy.ndpsh.seccion_13_http_request.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\n" +
                "id: 1,\n" +
                "name: 'london' " +
                "}";

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        City city = gson.fromJson(json, City.class);
        Toast.makeText(this, city.getId() + "--" + city.getName(), Toast.LENGTH_LONG).show();
    }
}
