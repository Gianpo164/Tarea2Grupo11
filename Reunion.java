package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.Clock;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private String tipoDeReunion;
    private ArrayList<Empleado> listaDeInvitados;
    private ArrayList<Asistencia> listaDeAsistencias;
    private ArrayList<Retraso> listaDeRetraso;
    private ArrayList<Empleado> listaDeAusencias;
    private ArrayList<Empleado> listaDeEmpleadoAsistentes;
    public Reunion(Date f, Instant horaP, Duration duracionP, int tipo, ArrayList<Empleado> listaDeE){
        fecha = f;
        horaPrevista = horaP;
        duracionPrevista = duracionP;
        listaDeInvitados = listaDeE;
        Invitacion invitacion = new Invitacion(horaP);
        switch (tipo){
            case 1:
                tipoDeReunion = "TECNICA";
                break;
            case 2:
                tipoDeReunion = "MARKETING";
                break;
            case 3:
                tipoDeReunion = "OTRO";
                break;
            default:
                break;
        }
        for (Empleado e : listaDeE){
            e.invitar(invitacion);
        }
    }
    public void asistirReunion(Empleado e){
        if (e.invitado && !Instant.now().isAfter(horaInicio) && !listaDeEmpleadoAsistentes.contains(e)) {
            Asistencia a = new Asistencia(e);
            listaDeEmpleadoAsistentes.add(e);
            listaDeAsistencias.add(a);
        } else if (e.invitado && !listaDeEmpleadoAsistentes.contains(e)) {
            Retraso r = new Retraso(e);
            listaDeEmpleadoAsistentes.add(e);
            listaDeRetraso.add(r);
        }
    }
    public ArrayList obtenerAsistencias(){
        return listaDeAsistencias;
    }
    public ArrayList obtenerAusencias(){
        listaDeAusencias.clear();
        listaDeAusencias.addAll(listaDeInvitados);
        return listaDeAsistencias;
    }
    public ArrayList obtenerRetrasos(){
        return listaDeRetraso;
    }
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal(){}
    public void iniciar(){}
    public void finalizar(){}
}
