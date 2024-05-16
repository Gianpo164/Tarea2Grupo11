package org.example;

public class Nota {
    private String contenido;

    public Nota(String nota){
        if (!nota.isBlank()){
            contenido = nota;
        }
    }
}
