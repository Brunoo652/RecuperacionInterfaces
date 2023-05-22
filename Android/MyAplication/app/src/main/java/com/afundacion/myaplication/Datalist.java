package com.afundacion.myaplication;

public class Datalist {
    private String nombre;
    private String url;
    private String desc;

    public Datalist(String nombre, String url, String desc){
        this.nombre = nombre;
        this.url = url;
        this.desc = desc;
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
