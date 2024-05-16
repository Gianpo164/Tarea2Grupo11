package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(Date f, Instant horaP, Duration duracionP, tipoReunion tipo, ArrayList<Empleado> listaDeE,String s){
        super(f, horaP, duracionP, tipo, listaDeE);
        sala = s;
    }
    public String getEnlace(){
        return sala;
    }
}