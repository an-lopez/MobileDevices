package com.escom.ipn.mx.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class ListaAdapter extends BaseAdapter {

    private ArrayList<?> al;
    private int R_layout_IdView;
    private Context c;

    public ListaAdapter(ArrayList<?> al, int r_layout_IdView, Context c) {
        super();
        this.al = al;
        R_layout_IdView = r_layout_IdView;
        this.c = c;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R_layout_IdView, null);
        }
        onEntry(al.get(position), convertView);
        return convertView;
    }

    public abstract void onEntry(Object object, View view);
}
