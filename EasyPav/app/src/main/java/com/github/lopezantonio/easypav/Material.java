package com.github.lopezantonio.easypav;

public class Material {
    String nombre;
    int img;

    public Material(String nombre, int img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImg() {
        return img;
    }
}
