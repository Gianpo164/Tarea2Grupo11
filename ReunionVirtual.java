package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;
    public ReunionVirtual(Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE,String enl){
        super(f, horaP, duracionP, tipo, listaDeE);
        enlace = enl;
    }
    public String getEnlace(){
        return enlace;
    }
}