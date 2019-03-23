package com.escom.ipn.mx.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NuevaEntradaAdapter extends ArrayAdapter<NuevaEntrada> {
    private final int entradaLayoutRecurso;

    public NuevaEntradaAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.entradaLayoutRecurso = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v2 = getWorkingView(convertView);
        ViewHolder vh = getViewHolder(v2);
        NuevaEntrada nuevaEntrada = getItem(position);

        String s = String.format("Por %s on %s", nuevaEntrada.getAutor(),
                DateFormat.getDateInstance(DateFormat.SHORT).format(nuevaEntrada.getFecha()));

        vh.tituloView.setText(nuevaEntrada.getTitulo());
        vh.subTituloView.setText(s);
        vh.imagenView.setImageResource(nuevaEntrada.getIcono());

        return v2;
    }

    private View getWorkingView(View v3) {
        View workingView = null;

        if(v3 == null){
            workingView = LayoutInflater.from(getContext()).inflate(entradaLayoutRecurso, null);
        }else{
            workingView = v3;
        }
        return workingView;
    }

    private ViewHolder getViewHolder(View workingView) {
        Object tag = workingView.getTag();
        ViewHolder vh = null;
        if(tag == null || !(tag instanceof ViewHolder)){
            vh = new ViewHolder();
            vh.tituloView = (TextView) workingView.findViewById(R.id.tv_titulo);
            vh.subTituloView = (TextView) workingView.findViewById(R.id.tv_subtitutlo);
            vh.imagenView = (ImageView) workingView.findViewById(R.id.iv_icono);
            workingView.setTag(vh);
        }else{
            vh = (ViewHolder) tag;
        }
        return vh;
    }

    private static class ViewHolder {
        public TextView tituloView;
        public TextView subTituloView;
        public ImageView imagenView;
    }
}
