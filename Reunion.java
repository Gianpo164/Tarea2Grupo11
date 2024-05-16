package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.Clock;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representación de una reunión de empresa
 */
public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio = Instant.MAX;
    private Instant horaFin = Instant.MAX;
    private tipoReunion tipoDeReunion;
    private ArrayList<Empleado> listaDeInvitados;
    private ArrayList<Asistencia> listaDeAsistencias;
    private ArrayList<Retraso> listaDeRetraso;
    private ArrayList<Empleado> listaDeAusencias;
    private ArrayList<Empleado> listaDeEmpleadoAsistentes;
  
    /**
     * Se crea una reunión, con la información correspondiente
     */
    public Reunion(Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE){
        fecha = f;
        horaPrevista = horaP;
        duracionPrevista = duracionP;
        listaDeInvitados = listaDeE;
        listaDeAsistencias = new ArrayList<>();
        listaDeRetraso = new ArrayList<>();
        listaDeAusencias = new ArrayList<>();
        listaDeEmpleadoAsistentes = new ArrayList<>();
        Invitacion invitacion = new Invitacion(horaP);
        tipoDeReunion = tipo;
        for (Empleado e : listaDeE){
            e.invitar(invitacion);
        }
    }
    public void asistirReunion(Empleado e){
        if (Instant.now().isAfter(horaFin)){
        }else if (e.invitado && !Instant.now().isAfter(horaInicio) && !listaDeEmpleadoAsistentes.contains(e)) {
            Asistencia a = new Asistencia(e);
            listaDeEmpleadoAsistentes.add(e);
            listaDeAsistencias.add(a);
        }else if (e.invitado && !listaDeEmpleadoAsistentes.contains(e)) {
            Retraso r = new Retraso(e);
            listaDeEmpleadoAsistentes.add(e);
            listaDeRetraso.add(r);
        }
    }
  
    /**
     * Devuelve una lista con la asistencia de la reunión
     * @return Lista de asistentes
     */
    public ArrayList obtenerAsistencias(){
        return listaDeAsistencias;
    }
  
    /**
     * Devuelve una lista con la ausencia de la reunión
     * @return lista de ausencias
     */
    public ArrayList obtenerAusencias(){
        listaDeAusencias.clear();
        listaDeAusencias.addAll(listaDeInvitados);
        listaDeAusencias.removeAll(listaDeEmpleadoAsistentes);
        return listaDeAusencias;
    }
  
    /**
     * Devuelve una lista con los asistentes con retraso de la reunión
     * @return Lista de asistentes con retraso
     */
    public ArrayList obtenerRetrasos(){
        return listaDeRetraso;
    }
  
    /**
     * Devuelve la cantidad de empelados que asistieron a la reunión
     * @return Cantidad de asistentes
     */
    public int obtenerTotalAsistencia(){
        return obtenerAsistencias().size() + obtenerRetrasos().size();
    }
  
    /**
     * Devuelve el porcentaje de asistentes de la reunión con respecto al total de empleados invitados
     * @return Porcentaje de asistencia
     */
    public float obtenerPorcentajeAsistencia(){
        return (((float)(obtenerAsistencias().size() + obtenerRetrasos().size()) / (float)listaDeInvitados.size()) * (float)100);
    }
  
    /**
     * Inicia la reunión, a partir de este punto las asisencias se consideran retrasos
     */
    public float calcularTiempoReal(){
        return (float)horaInicio.until(horaFin, ChronoUnit.SECONDS);//Posible modificacion para entregar informacion relevante al informe
    }
  
    /**
     * Inicia la reunión, a partir de este punto las asisencias se consideran retrasos
     */
    public void iniciar(){
        horaInicio = Instant.now();
    }
  
    /**
     * Finaliza la reunión, ya no se contabiliza ningún tipo de asistencia
     */
    public void finalizar(){
        horaFin = Instant.now();
    }
}