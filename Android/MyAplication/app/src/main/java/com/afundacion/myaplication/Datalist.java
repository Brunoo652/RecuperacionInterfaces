package com.afundacion.myaplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Datalist {
    private String nombre;
    private String url;
    private String desc;

    public Datalist(JSONObject json) throws JSONException {
        this.nombre = json.getString("nombre");
        this.desc = json.getString("descripcion");
        this.url = json.getString("imagen_url");
    }

    public String getDesc() {
        return desc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }
}
