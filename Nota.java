package org.example;

public class Nota {
    private String contenido;

    public Nota(String nota){
        if (!nota.isBlank()){
            contenido = nota;
        }
    }
    public String getContenido(){ return contenido; }
    public void setContenido(String c){ contenido = c; }

}
