package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representación de un formato virtual de reunión
 */
public class ReunionVirtual extends Reunion {
    private String enlace;


    /**
     * Se crea una reunión, con la información correspondiente y se invitan empleados
     * @param f Fecha de la reunión
     * @param horaP Hora prevista para la reunión
     * @param duracionP Duración prevista de la reunión
     * @param tipo Tipo de reunión
     * @param listaDeE Lista de empleados a invitar
     * @param enl Enlace para ingresar a la reunión
     */
    public ReunionVirtual(Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE,String enl){
        super(f, horaP, duracionP, tipo, listaDeE);
        enlace = enl;
    }

    /**
     * Devuelve el enlace para ingresar a la reunión
     * @return Enlace de la reunión
     */
    public String getEnlace(){
        return enlace;
    }
}