package com.escom.examensegundoparcial;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Resultado.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Resultado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Resultado extends android.support.v4.app.Fragment {

    private Double[][] resses;


    public Resultado() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if (getArguments() != null) {
                resses = (Double[][]) getArguments().getSerializable("res");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_resultado, container, false);

        GridLayout gl = v.findViewById(R.id.glfragment);
        gl.setRowCount(resses.length);
        gl.setColumnCount(resses[0].length);

        for (int i = 0; i < resses.length; i++) {
            for (int j = 0; j < resses[0].length; j++) {
                EditText tv = new EditText(getActivity());
                tv.setText(resses[i][j]+"");
                gl.addView(tv);
            }
        }

        return v;
    }

}
