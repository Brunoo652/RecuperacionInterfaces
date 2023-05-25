package com.afundacion.myaplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListadoVideojuegos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListadoVideojuegos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TEXT_ID = "";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListadoVideojuegos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListadoVideojuegos.
     */
    // TODO: Rename and change types and number of parameters
    public static ListadoVideojuegos newInstance(String param1, String param2) {
        ListadoVideojuegos fragment = new ListadoVideojuegos();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado_videojuegos, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        Activity activity = getActivity();
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://raw.githubusercontent.com/CarlosAfundacion/EXAMEN/main/games.json",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Datalist> allthedata = new ArrayList<>();
                        for (int i=0;i<response.length();i++){
                            try {
                                JSONObject videojuego = response.getJSONObject(i);
                                Datalist datalist = new Datalist(videojuego);
                                allthedata.add(datalist);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            MyAdapter myAdapter =  new MyAdapter(allthedata, activity);
                            recyclerView.setAdapter(myAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(view.getContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue cola = Volley.newRequestQueue(getActivity());
        cola.add(request);
        return view;
    }

    public static ListadoVideojuegos newInstance(@StringRes int textId) {
        ListadoVideojuegos frag = new ListadoVideojuegos();

        Bundle args = new Bundle();
        args.putInt(TEXT_ID, textId);
        frag.setArguments(args);

        return frag;
    }

    @SuppressLint("MissingInflatedId")
    public View onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
        super.onViewCreated(view, savedInstanceState);

        View layout = inflater.inflate(R.layout.fragment_listado_videojuegos, container, false);

        if (getArguments() != null) {
            String text = getString(getArguments().getInt(TEXT_ID));
            ((TextView) layout.findViewById(R.id.text)).setText(text);
        } else {
            throw new IllegalArgumentException("Argument " + TEXT_ID + " is mandatory");
        }
        return layout;
    }
}