package org.example;

import java.text.SimpleDateFormat;
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
    private Empleado organizador;
    private tipoReunion tipoDeReunion;
    private ArrayList<Nota> notas;
    private ArrayList<Empleado> listaDeInvitados;
    private ArrayList<Asistencia> listaDeAsistencias;
    private ArrayList<Retraso> listaDeRetraso;
    private ArrayList<Empleado> listaDeAusencias;
    private ArrayList<Empleado> listaDeEmpleadoAsistentes;
  
    /**
     * Se crea una reunión, con la información correspondiente y se invitan empleados
     * @param f Fecha de la reunión
     * @param horaP Hora prevista para la reunión
     * @param duracionP Duración prevista de la reunión
     * @param tipo Tipo de reunión
     * @param listaDeE Lista de empleados a invitar
     */
    public Reunion(Empleado org, Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE){
        fecha = f;
        horaPrevista = horaP;
        duracionPrevista = duracionP;
        organizador = org;
        tipoDeReunion = tipo;
        notas = new ArrayList<>();
        listaDeInvitados = listaDeE;
        listaDeAsistencias = new ArrayList<>();
        listaDeRetraso = new ArrayList<>();
        listaDeAusencias = new ArrayList<>();
        listaDeEmpleadoAsistentes = new ArrayList<>();
        Invitacion invitacion = new Invitacion(horaP);
        for (Empleado e : listaDeE){
            e.invitar(invitacion);
        }
    }

    /**
     * Registro de la asistencia a la reunión, además se determina el tipo de asistencia
     * @param e Empleado que asistirá
     */
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
     * Devuelve la duración de la reunión
     * @return Duración total
     */
    public float calcularTiempoReal(){
        return (float)horaInicio.until(horaFin, ChronoUnit.SECONDS);//Posible modificacion para entregar informacion relevante al informe
    }
  
    /**
     * Inicia la reunión, a partir de este punto las asistencias se consideran retrasos
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
    public void crearInforme(){
        String pattern = "yyyy-MM-dd_hh-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String horaPrevista = simpleDateFormat.format(Date.from(Instant.now()));
        Informe informe = new Informe();
        informe.crearInforme(horaPrevista);
        informe.escribirContenido(this);
    }
    public Date getFecha() { return fecha; }
    public Instant getHoraPrevista() { return horaPrevista; }
    public Duration getDuracionPrevista() { return duracionPrevista; }
    public Instant getHoraInicio() { return horaInicio; }
    public Instant getHoraFin() { return horaFin; }
    public Empleado getOrganizador() { return organizador; }
    public tipoReunion getTipoDeReunion() {return tipoDeReunion; }
    public abstract String getMedioReunion();
    public abstract String getSitioReunion();
    public ArrayList getNotas(){ return notas;}
    public ArrayList getListaDeParticipantes(){ return listaDeEmpleadoAsistentes; }

    public String fechaToString(){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(fecha);
        return date;
    }
    public String horaPrevistaToString(){
        String pattern = "hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String horaPrevista = simpleDateFormat.format(Date.from(this.horaPrevista));
        return horaPrevista;
    }

    public String duracionPrevistaToString(){
        float duracionPrevista = (float) this.duracionPrevista.toSeconds();
        return (duracionPrevista + "s");
    }

    public String horaInicioToString(){
        String pattern = "hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String horaInicio = simpleDateFormat.format(Date.from(this.horaInicio));
        return horaInicio;
    }
    public String horaFinToString(){
        String pattern = "hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String horaFin = simpleDateFormat.format(Date.from(this.horaFin));
        return horaFin;
    }
    public void crearNota(String contenido){
        Nota n = new Nota(contenido);
        notas.add(n);
    }
}