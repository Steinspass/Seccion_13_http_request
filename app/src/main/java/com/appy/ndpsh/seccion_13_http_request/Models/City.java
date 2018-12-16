package com.appy.ndpsh.seccion_13_http_request.Models;

import com.google.gson.annotations.Expose;

public class City {

    // Anotacion para excluir a la que este referida con anotacion en este caso la propiedad name
    @Expose
    public int id;
    public String name;

    public City() {
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
