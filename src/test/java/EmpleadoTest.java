import org.example.Empleado;
import org.example.Invitacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class EmpleadoTest {
    @Test
    void metodosDeEmpleado() {
        Empleado empleado = new Empleado("A1","Ter H.","John","test@test.test");
        Invitacion invitacion = new Invitacion(Instant.MAX);
        empleado.invitar(invitacion);
        Assertions.assertTrue(empleado.getInvitado());
    }
}