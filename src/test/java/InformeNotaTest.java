import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class InformeNotaTest {
    private ArrayList<Empleado> listaEmpleados;
    private Empleado e1;
    private Empleado e2;
    private Empleado e3;
    private Empleado e4;
    private Empleado e5;
    private Departamento D1;
    private ReunionVirtual reunionV;
    private Nota nota = new Nota("Test");
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void informeNotaTest() throws FaltaParametroException{
        listaEmpleados = new ArrayList<>();
        e1 = new Empleado("1", "rutb butn", "zar", "rutb@example1.com");
        e2 = new Empleado("2", "alftu ren", "plve", "alftu@example2.com");
        e3 = new Empleado("3", "tur fir", "juan", "tur@example3.com");
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
        reunionV = new ReunionVirtual(e1, Date.from(Instant.now()),Instant.now(), Duration.of(90, ChronoUnit.SECONDS), tipoReunion.TECNICA, listaEmpleados,"test.test.test");
        for (int i = 0; i < 6; i++) {
            reunionV.asistirReunion(listaEmpleados.get(i));
        }
        reunionV.iniciar();
        nota.setContenido("Nota");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reunionV.asistirReunion(listaEmpleados.get(6));
    }
    @Test
    void informeTest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        reunionV.finalizar(true);
        Assertions.assertEquals("Informe creado", outputStreamCaptor.toString().trim());
    }
    @Test
    void testNota(){
        reunionV.finalizar(false);
        Assertions.assertEquals("Nota",nota.getContenido());
    }
    @Test
    void testNull()throws FaltaParametroException{
        ReunionPresencial R2 = new ReunionPresencial(e1, Date.from(Instant.now()),Instant.now(), Duration.of(90, ChronoUnit.SECONDS), tipoReunion.MARKETING, listaEmpleados,"404");
    }

}