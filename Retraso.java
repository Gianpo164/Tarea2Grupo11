package org.example;

import java.time.Instant;

/**
 * Representación de la asistencia de un empleado, pero llegando tarde a una reunion
 */
public class Retraso extends Asistencia {
    private Instant horaLlegada;

    /**
     * Crea la asistencia del empleado a la reunión y determina el momento de su llegada
     * @param e Empleado que asistió
     */
    public Retraso(Empleado e) {
        super(e);

        horaLlegada = Instant.now();
    }

    /**
     * Devuelve el momento en que el empleado llegó a la reunión
     * @return El momento en que llegó a la reunión
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
}
