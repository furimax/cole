package com.defenza.colegio.agenda.estudiante.ui.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.defenza.colegio.agenda.estudiante.modelo.Estudiante;
import com.defenza.colegio.agenda.estudiante.tools.Constantes;
import com.defenza.colegio.agenda.estudiante.ui.EstudianteAdapter;
import com.defenza.colegio.agenda.estudiante.web.VolleySingleton;

import com.google.gson.Gson;
import  com.defenza.colegio.agenda.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlumnoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlumnoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumnoFragment extends Fragment {
    //Etiqueta de depuracion
    private static final String TAG = AlumnoFragment.class.getSimpleName();
    //Adaptador del recycler view
    private EstudianteAdapter adapter;
    //Instancia global del recycler view
    private RecyclerView lista;
    //instancia global del administrador
    private RecyclerView.LayoutManager lManager;
    //Instancia global del FAB
    com.melnykov.fab.FloatingActionButton fab;
    private Gson gson = new Gson();

    //Metodo constructor Vacio
    public AlumnoFragment() {
    }

    //metodo del ciclo de vida de un fragmento que es una sub actividad
    //esto carga el fragmento dentro de la actividad principal
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_alumno, container, false);

        lista = (RecyclerView) v.findViewById(R.id.recicladoralumno);
        lista.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());
        lista.setLayoutManager(lManager);

        // Cargar datos en el adaptador
        cargarAdaptador();

        // Obtener instancia del FAB
        fab = (com.melnykov.fab.FloatingActionButton) v.findViewById(R.id.fab);

        // Asignar escucha al FAB
        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Iniciar actividad de inserción
                      /*  getActivity().startActivityForResult(
                                new Intent(getActivity(), InsertActivity.class), 3);*/
                    }
                }
        );

        return v;
    }

    /**
     * Carga el adaptador con las metas obtenidas
     * en la respuesta
     */
    public void cargarAdaptador() {
        // Petición GET
        VolleySingleton.getInstance(getActivity()).addToRequestQueue( new JsonObjectRequest(Request.Method.GET, Constantes.GET, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                // Procesar la respuesta Json
                                procesarRespuesta(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.toString());
                            }
                        }

                )
        );
    }

    /**
     * Interpreta los resultados de la respuesta y así
     * realizar las operaciones correspondientes
     *
     * @param response Objeto Json con la respuesta
     */
    private void procesarRespuesta(JSONObject response) {
        try {
            // Obtener atributo "estado"
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // EXITO
                    // Obtener array "metas" Json
                    JSONArray mensaje = response.getJSONArray("estudiantes");
                    // Parsear con Gson
                    Estudiante[] estudiantes = gson.fromJson(mensaje.toString(), Estudiante[].class);
                    // Inicializar adaptador
                    adapter = new EstudianteAdapter(Arrays.asList(estudiantes), getActivity());
                    // Setear adaptador a la lista
                    lista.setAdapter(adapter);
                    break;
                case "2": // FALLIDO
                    String mensaje2 = response.getString("mensaje");
                    Toast.makeText(
                            getActivity(),
                            mensaje2,
                            Toast.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            Log.d(TAG, e.getMessage());
        }

    }
}
