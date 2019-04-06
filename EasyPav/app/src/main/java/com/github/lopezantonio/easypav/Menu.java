package com.github.lopezantonio.easypav;

public class Menu {
    private String nombre;
    private String url;
    private boolean isGroup, hasChildren, hasMaterial;

    public Menu(String nombre, String url, boolean isGroup, boolean hasChildren, boolean hasMaterial) {
        this.nombre = nombre;
        this.url = url;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
        this.hasMaterial = hasMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public boolean isHasMaterial() {
        return hasMaterial;
    }
}
