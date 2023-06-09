package com.afundacion.myaplication;



import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AcercaDe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AcercaDe extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TEXT_ID ="" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AcercaDe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AcercaDe.
     */
    // TODO: Rename and change types and number of parameters
    public static AcercaDe newInstance(String param1, String param2) {
        AcercaDe fragment = new AcercaDe();
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
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);
    }

    public static AcercaDe newInstance(@StringRes int textId) {
        AcercaDe frag = new AcercaDe();

        Bundle args = new Bundle();
        args.putInt(TEXT_ID, textId);
        frag.setArguments(args);

        return frag;
    }
    @SuppressLint("MissingInflatedId")
    public View onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
        super.onViewCreated(view, savedInstanceState);

        View layout = inflater.inflate(R.layout.fragment_home, container, false);

        if (getArguments() != null) {
            String text = getString(getArguments().getInt(TEXT_ID));
            ((TextView) layout.findViewById(R.id.textAcercaDe)).setText(text);
        } else {
            throw new IllegalArgumentException("Argument " + TEXT_ID + " is mandatory");
        }

        return layout;
    }
}