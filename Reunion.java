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
    public ArrayList obtenerAsistencias(){}
    public ArrayList obtenerAusencias(){}
    public ArrayList obtenerRetrasos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal(){}
    public void iniciar(){}
    public void finalizar(){}
}
