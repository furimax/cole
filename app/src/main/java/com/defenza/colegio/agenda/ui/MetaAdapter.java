package com.defenza.colegio.agenda.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.defenza.colegio.agenda.R;

import java.util.List;

import com.defenza.colegio.agenda.modelo.Meta;
import com.defenza.colegio.agenda.ui.actividades.DetailActivity;

/**
 * Adaptador del recycler view
 */
public class MetaAdapter extends RecyclerView.Adapter<MetaAdapter.MetaViewHolder> implements ItemClickListener {

    /**
     * Lista de objetos {@link Meta} que representan la fuente de datos
     * de inflado
     */
    private List<Meta> items;

    /*
    Contexto donde actua el recycler view
     */
    private Context context;

    //METODO CONSTRUCTOR
    public MetaAdapter(List<Meta> items, Context context) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MetaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);
        return new MetaViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(MetaViewHolder viewHolder, int i) {
        viewHolder.fechaF.setText(items.get(i).getfechaF());
        viewHolder.actividad.setText(items.get(i).getactividad());
        viewHolder.detalle.setText(items.get(i).getdetalle());
        viewHolder.curso.setText(items.get(i).getcurso());
        viewHolder.materia.setText(items.get(i).getmateria());


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
                (Activity) context, items.get(position).getidTarea());
    }


    public static class MetaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        public TextView fechaF;
        public TextView actividad;
        public TextView detalle;
        public TextView curso;
        public TextView materia;
        public TextView estado;
        public ItemClickListener listener;

        public MetaViewHolder(View v, ItemClickListener listener) {
            super(v);
            fechaF = (TextView) v.findViewById(R.id.fecha);
            curso = (TextView) v.findViewById(R.id.curso);
            materia = (TextView) v.findViewById(R.id.materia);
            actividad = (TextView) v.findViewById(R.id.actividad);
            detalle = (TextView) v.findViewById(R.id.detalle);
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
