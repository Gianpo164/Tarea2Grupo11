package org.example;

import java.time.Instant;

public class Retraso extends Asistencia {
    private Instant horaLlegada;
    public Retraso(Empleado e) {
        super(e);

        horaLlegada = Instant.now();
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
}
