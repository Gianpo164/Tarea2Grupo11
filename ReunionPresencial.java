package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representación de un formato presencial de reunión
 */
public class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * Se crea una reunión, con la información correspondiente y se invitan empleados
     * @param org Empleado organizador de la reunión
     * @param f Fecha de la reunión
     * @param horaP Hora prevista para la reunión
     * @param duracionP Duración prevista de la reunión
     * @param tipo Tipo de reunión
     * @param listaDeE Lista de empleados a invitar
     * @param s Sala donde se llevará acabo la reunión
     */
    public ReunionPresencial(Empleado org, Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE,String s){
        super(org, f, horaP, duracionP, tipo, listaDeE);
        sala = s;
    }

    /**
     * Devuelve el formato establecido para la reunión
     * @return Formato de la reunión
     */
    public String getMedioReunion(){ return "Presencial"; }

    /**
     * Devuelve la sala donde se llevará acabo la reunión
     * @return Sala de la reunión
     */
    public String getSitioReunion(){ return "La sala es " + sala; }
}