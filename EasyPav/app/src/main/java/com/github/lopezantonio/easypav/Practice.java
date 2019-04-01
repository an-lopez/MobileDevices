package com.github.lopezantonio.easypav;

public class Practice {
    String nombre;
    String url;
    int img;

    public Practice(String nombre, String url, int img) {
        this.nombre = nombre;
        this.url = url;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public int getImg() {
        return img;
    }
}
