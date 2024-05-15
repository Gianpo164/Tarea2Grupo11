package org.example;

import java.time.Instant;

public class Asistencia {
    private Empleado empleado;
    public Asistencia(Empleado e) {
        empleado = e;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
}
