package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(Empleado org, Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE,String s){
        super(org, f, horaP, duracionP, tipo, listaDeE);
        sala = s;
    }
    public String getMedioReunion(){ return "Presencial"; }
    public String getSitioReunion(){ return "La sala es " + sala; }
}