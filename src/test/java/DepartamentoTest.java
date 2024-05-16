import org.example.Departamento;
import org.example.Empleado;
import org.example.Invitacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;

public class DepartamentoTest {
    private Empleado e1;
    private Empleado e2;
    private Empleado e3;
    private Empleado e4;
    private Empleado e5;
    private ArrayList<Empleado> empleados;
    private Invitacion invitacion;
    private Departamento D1;

    @BeforeEach
    void metodosDeDepartamento() {
        e1 = new Empleado("1", "tur fir", "juan", "tur@example1.com");
        e2 = new Empleado("2", "alftu ren", "plve", "alftu@example2.com");
        e3 = new Empleado("3", "rutb butn", "zar", "rutb@example3.com");
        e4 = new Empleado("4", "iuyr reix", "ler", "iuyr@example4.com");
        e5 = new Empleado("5", "tarme emt", "cay", "tarme@example5.com");
        empleados = new ArrayList<>();
        invitacion = new Invitacion(Instant.now());
        D1 = new Departamento("Programing");
        D1.addEmpleado(e1);
        D1.addEmpleado(e2);
        D1.addEmpleado(e3);
        D1.addEmpleado(e4);
        D1.addEmpleado(e5);
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        empleados.add(e4);
        empleados.add(e5);
    }
    @Test
    void testCntEmpleados(){
        Assertions.assertEquals(5,D1.ObtenerCntEmpleados(),"cantidad de empleados erronea");
    }
    @Test
    void testGetEmpleados(){
        Assertions.assertIterableEquals(empleados,D1.getEmpleados(),"Lista de empleados erronea");
    }
    @Test
    void testGetInvitado(){
        D1.invitar(invitacion);
        Assertions.assertTrue(D1.getInvitado(),"Empleados no invitados");
    }
}
