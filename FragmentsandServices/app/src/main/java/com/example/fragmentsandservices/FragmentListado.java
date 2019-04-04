package com.example.fragmentsandservices;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentListado extends Fragment {
    private Grupo[] datos = new Grupo[]{
            new Grupo("\nEstudiante 1", "Calificación 1", "\nReporte de aprovechamiento 1"),
            new Grupo("\nEstudiante 2", "Calificación 2", "\nReporte de aprovechamiento 2"),
            new Grupo("\nEstudiante 3", "Calificación 3", "\nReporte de aprovechamiento 3"),
            new Grupo("\nEstudiante 4", "Calificación 4", "\nReporte de aprovechamiento 4"),
            new Grupo("\nEstudiante 5", "Calificación 5", "\nReporte de aprovechamiento 5")
    };

    private ListView lv;
    private GruposListener cl;

    // TODO: Customize parameters
    private int mColumnCount = 1;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentListado() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        lv = (ListView) getView().findViewById(R.id.xlvListado);
        lv.setAdapter(new AdaptadorGrupos(this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                if (cl != null) {
                    cl.onGrupoSeleccionado((Grupo) lv.getAdapter().getItem(pos));
                }
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    class AdaptadorGrupos extends ArrayAdapter<Grupo> {
        Activity a;
        TextView tv1, tv2;

        AdaptadorGrupos(Fragment f) {
            super(f.getActivity(), R.layout.fragment_grupo, datos);
            this.a = f.getActivity();
        }

        public View getView(int i, View vi, ViewGroup vg) {
            LayoutInflater li = a.getLayoutInflater();
            View v = li.inflate(R.layout.fragment_grupo, null);
            tv1 = (TextView) v.findViewById(R.id.xtvDe);
            tv1.setText(datos[i].getDe());
            tv2 = (TextView) v.findViewById(R.id.xtvAsunto);
            tv2.setText(datos[i].getAsunto());
            return (v);
        }
    }

    public interface GruposListener {
        void onGrupoSeleccionado(Grupo c);
    }

    public void setGruposListener(GruposListener l) {
        this.cl = l;
    }
}
