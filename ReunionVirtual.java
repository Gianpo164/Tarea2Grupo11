package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;
    public ReunionVirtual(Empleado org, Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE,String enl){
        super(org, f, horaP, duracionP, tipo, listaDeE);
        enlace = enl;
    }
    public String getMedioReunion(){ return "Virtual"; }
    public String getSitioReunion(){ return "El enlace es " + enlace; }
}