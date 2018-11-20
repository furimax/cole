package com.defenza.colegio.agenda.estudiante.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.defenza.colegio.agenda.estudiante.modelo.Estudiante;
import  com.defenza.colegio.agenda.R;
import java.util.List;

import com.defenza.colegio.agenda.ui.actividades.DetailActivity;

/**
 * Adaptador del recycler view
 */
public class EstudianteAdapter extends RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder> implements ItemClickListener {

    /**
     * Lista de objetos {@link Estudiante} que representan la fuente de datos
     * de inflado
     */
    private List<Estudiante> items;
    /*
    Contexto donde actua el recycler view
     */
    private Context context;
    //METODO CONSTRUCTOR
    public EstudianteAdapter(List<Estudiante> items, Context context) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public EstudianteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_alumno, viewGroup, false);
        return new EstudianteViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(EstudianteViewHolder viewHolder, int i) {
        viewHolder.nombre.setText(items.get(i).getnombre());
        viewHolder.apellidos.setText(items.get(i).getapellidos());
        viewHolder.curso.setText(items.get(i).getcursosa());
        viewHolder.promedio.setText(items.get(i).getpromedio());



    }

    /**
     * Sobrescritura del método de la interfaz {@link ItemClickListener}
     *
     * @param view     item actual
     * @param position posición del item actual
     */
    @Override
    public void onItemClick(View view, int position) {
        DetailActivity.launch(
                (Activity) context, items.get(position).getemp_no());
    }


    public static class EstudianteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView apellidos;
        public TextView n1;
        public TextView n2;
        public TextView n3;
        public TextView n4;
        public TextView promedio;
        public TextView curso;
        public ItemClickListener listener;

        //falta conpletar

        public EstudianteViewHolder(View v, ItemClickListener listener) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.fecha);
            apellidos = (TextView) v.findViewById(R.id.actividad);
            curso = (TextView) v.findViewById(R.id.cursoalumno);
            promedio = (TextView) v.findViewById(R.id.materia);
            this.listener = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}


interface ItemClickListener {
    void onItemClick(View view, int position);
}
