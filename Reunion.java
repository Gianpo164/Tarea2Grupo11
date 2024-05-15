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
    public Reunion(){}
    public ArrayList obtenerAsistencias(){}
    public ArrayList obtenerAusencias(){}
    public ArrayList obtenerRetrasos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal(){}
    public void iniciar(){}
    public void finalizar(){}
}
