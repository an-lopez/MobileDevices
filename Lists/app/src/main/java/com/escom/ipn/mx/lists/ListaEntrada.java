package com.escom.ipn.mx.lists;

import java.io.Serializable;

public class ListaEntrada implements Serializable {
    private int idim;
    private String a;
    private String d;

    public ListaEntrada(int idim, String a, String d) {
        this.idim = idim;
        this.a = a;
        this.d = d;
    }

    public int getIdim() {
        return idim;
    }

    public String getA() {
        return a;
    }

    public String getD() {
        return d;
    }
}
