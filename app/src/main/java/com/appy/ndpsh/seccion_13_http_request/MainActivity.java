package com.appy.ndpsh.seccion_13_http_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\n" +
                "id: 1,\n" +
                "name: 'london' " +
                "}";

        Gson gson = new Gson();
        City city = gson.fromJson(json, City.class);
        Toast.makeText(this, city.getId() + "--" + city.getName(), Toast.LENGTH_LONG).show();
    }
}
