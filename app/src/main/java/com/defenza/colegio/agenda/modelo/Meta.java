package com.defenza.colegio.agenda.modelo;

/**
 * Reflejo de la tabla 'meta' en la base de datos
 */
public class Meta {

    private static final String TAG = Meta.class.getSimpleName();
    /*
        Atributos
         */
    private String idTarea;
    private String fechaF;
    private String actividad;
    private String detalle;
    private String curso;
    private String materia;
    private String estado;

    public Meta(String idtarea, String fechaf, String actividad, String detalle, String curso, String materia, String estado) {

        this.idTarea = idtarea;
        this.fechaF = fechaf;
        this.actividad = actividad;
        this.detalle = detalle;
        this.curso = curso;
        this.materia = materia;
        this.estado=estado;

    }

    public String getidTarea() {
        return idTarea;
    }

    public String getfechaF() {
        return fechaF;
    }

    public String getactividad() {
        return actividad;
    }

    public String getdetalle() {
        return detalle;
    }

    public String getcurso() {
        return curso;
    }

    public String getmateria() {
        return materia;
    }

    public String getestado() {
        return estado;
    }

    /**
     * Compara los atributos de dos metas
     *
     * @param meta Meta externa
     * @return true si son iguales, false si hay cambios
     */
    public boolean compararCon(Meta meta) {
        return this.fechaF.compareTo(meta.fechaF) == 0 &&
                this.actividad.compareTo(meta.actividad) == 0 &&
                this.detalle.compareTo(meta.detalle) == 0 &&
                this.curso.compareTo(meta.curso) == 0 &&
                this.materia.compareTo(meta.materia) == 0;
    }
}
