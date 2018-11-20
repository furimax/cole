package com.defenza.colegio.agenda.estudiante.modelo;

/**
 * Reflejo de la tabla 'meta' en la base de datos
 */
public class Estudiante {

    private static final String TAG = Estudiante.class.getSimpleName();
    /*
        Atributos
         */
    private String emp_no;
    private String nombre;
    private String apellidos;
    private String n1;
    private String n2;
    private String n3;
    private String n4;
    private String promedio;
    private String cursosa;

    public Estudiante(String emp_no, String nombre, String apellidos, String n1, String n2, String n3, String n4, String promedio, String cursos) {

        this.emp_no = emp_no;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4=n4;
        this.promedio=promedio;
        this.cursosa=cursos;

    }

    public String getemp_no() {
        return emp_no;
    }

    public String getnombre() {
        return nombre;
    }

    public String getapellidos() {
        return apellidos;
    }

    public String getn1() {
        return n1;
    }

    public String getn2() {
        return n2;
    }

    public String getn3() {
        return n3;
    }

    public String getn4() {
        return n4;
    }

    public String getpromedio() {
        return promedio;
    }

    public String getcursosa() {
        return cursosa;
    }


    /**
     * Compara los atributos de dos metas
     *
     * @param estudiante Meta externa
     * @return true si son iguales, false si hay cambios
     */
    public boolean compararCon(Estudiante estudiante) {
        return this.nombre.compareTo(estudiante.nombre) == 0 &&
                this.apellidos.compareTo(estudiante.apellidos) == 0 &&
                this.n1.compareTo(estudiante.n1) == 0 &&
                this.n2.compareTo(estudiante.n2) == 0 &&
                this.n3.compareTo(estudiante.n3) == 0 &&
                this.n4.compareTo(estudiante.n4) == 0 &&
                this.promedio.compareTo(estudiante.promedio) == 0 &&
                this.cursosa.compareTo(estudiante.cursosa) == 0;
    }
}
