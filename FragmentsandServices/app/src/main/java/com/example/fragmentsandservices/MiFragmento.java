package com.example.fragmentsandservices;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MiFragmento.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MiFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiFragmento extends Fragment {
    public final static int OK = 0;
    public final static int CANCEL = 1;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MiFragmento() {
        // Required empty public constructor
    }

    public static MiFragmento newInstance(String param1, String param2) {
        MiFragmento fragment = new MiFragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mi_fragmento, container, false);
        ((Button) v.findViewById(R.id.xbnA)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonDigitado(v);
                Toast.makeText(getActivity(), "Desde MiFragmento",
                        Toast.LENGTH_LONG).show();
            }
        });
        ((Button) v.findViewById(R.id.xbnC)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonDigitado(v);
            }
        });
        return v;

    }

    public void botonDigitado(View v) {
        if (null == mListener)
            return;
        if (((Button) v).getText().equals("Aceptar"))
            mListener.digitado(OK, ((EditText)
                    getActivity().findViewById(R.id.xet)).getText().toString());
        else
            mListener.digitado(CANCEL, "");
    }

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        if (a instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) a;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

        public void digitado(int resultado, String texto);
    }

}
