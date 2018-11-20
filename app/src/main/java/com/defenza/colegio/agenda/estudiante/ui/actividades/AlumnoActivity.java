package com.defenza.colegio.agenda.estudiante.ui.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  com.defenza.colegio.agenda.R;
import com.defenza.colegio.agenda.estudiante.tools.Constantes;
import com.defenza.colegio.agenda.estudiante.ui.fragmentos.AlumnoFragment;

public class AlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        // Creación del fragmento principal
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new AlumnoFragment(), "AlumnoFragment")
                    .commit();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constantes.CODIGO_DETALLE || requestCode == 3) {
            if (resultCode == RESULT_OK || resultCode == 203) {
                AlumnoFragment fragment = (AlumnoFragment) getSupportFragmentManager().
                        findFragmentByTag("AlumnoFragment");
                fragment.cargarAdaptador();
            }
        }
    }
}
