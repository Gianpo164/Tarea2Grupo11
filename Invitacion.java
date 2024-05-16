package org.example;

import java.time.Instant;

/**
 * Representación de una invitación a una reunión
 */
public class Invitacion {
    private Instant hora;

    /**
     * Crea la invitación, usando la hora prevista de inicio de la reunión
     * @param horaPrevista Momento de inicio de la reunión
     */
    public Invitacion(Instant horaPrevista) {
        hora = horaPrevista;
    }
}
