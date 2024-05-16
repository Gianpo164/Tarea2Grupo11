package org.example;

/**
 * Representación de la asistencia de un empleado a una reunión
 */
public class Asistencia {
    private Empleado empleado;

    /**
     * Crea la asistencia del empleado a la reunión
     * @param e Empleado que asistió
     */
    public Asistencia(Empleado e) {
        empleado = e;
    }

    /**
     * Devuelve al empleado que asistió
     * @return Empleado representado por la instancia de asistencia
     */
    public Empleado getEmpleado() {
        return empleado;
    }
}
