import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class ReunionTest {
    private ArrayList<Empleado> listaEmpleados;
    private Empleado e1;
    private Empleado e2;
    private Empleado e3;
    private Empleado e4;
    private Empleado e5;
    private Departamento D1;
    private ReunionVirtual reunionV;

    @BeforeEach
    void inicializacion() throws FaltaParametroException{
        listaEmpleados = new ArrayList<>();
        e1 = new Empleado("1", "tur fir", "juan", "tur@example1.com");
        e2 = new Empleado("2", "alftu ren", "plve", "alftu@example2.com");
        e3 = new Empleado("3", "rutb butn", "zar", "rutb@example3.com");
        e4 = new Empleado("4", "iuyr reix", "ler", "iuyr@example4.com");
        e5 = new Empleado("5", "tarme emt", "cay", "tarme@example5.com");
        D1 = new Departamento("Design");
        for (int i = 6; i <= 10; i++) {
            D1.addEmpleado(new Empleado("A"+i, "Apellido"+i, "Nombre"+i, i+".correo@empresa.com"));
        }
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        listaEmpleados.add(e4);
        listaEmpleados.add(e5);
        listaEmpleados.addAll(D1.getEmpleados());
        reunionV = new ReunionVirtual(e1,Date.from(Instant.now()),Instant.now(), Duration.of(90, ChronoUnit.SECONDS),tipoReunion.TECNICA,listaEmpleados,"test.test.test");
        for (int i = 0; i < 6; i++) {
            reunionV.asistirReunion(listaEmpleados.get(i));
        }
        reunionV.iniciar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reunionV.asistirReunion(listaEmpleados.get(6));
    }
    @Test
    void testAsistencias(){
        reunionV.finalizar(true);
        Assertions.assertEquals(6, reunionV.obtenerAsistencias().size(),"Lista de asistencias erronea");
    }
    @Test
    void testAusencias(){
        reunionV.finalizar(true);
        Assertions.assertEquals(3, reunionV.obtenerAusencias().size(), "lista de ausencias erronea");
    }
    @Test
    void testRetrasos(){
        reunionV.finalizar(false);
        Assertions.assertEquals(1, reunionV.obtenerRetrasos().size(),"lista de retrasos erronea");
    }
    @Test
    void testTotalAsistencia(){
        reunionV.finalizar(false);
        Assertions.assertEquals(7, reunionV.obtenerTotalAsistencia(), "Numero de asistentes erroneo");
    }
    @Test
    void testPorcentajeAsistencia(){
        reunionV.finalizar(false);
        Assertions.assertEquals((((float)7)/(float)10 * (float)100), reunionV.obtenerPorcentajeAsistencia(), "porcentaje erroneo");
    }
    @Test
    void testTiempoReal(){
        reunionV.finalizar(false);
        Assertions.assertEquals(1, reunionV.calcularTiempoReal(),"tiempo erroneo");
    }
}