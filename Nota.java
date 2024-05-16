package org.example;

/**
 * Representación de las notas que pueden ser creadas en una reunión
 */
public class Nota {
    private String contenido;

    /**
     * Crea una nota a partir del texto introducido
     * @param nota Texto que será guardado
     */
    public Nota(String nota){
        if (!nota.isBlank()){
            contenido = nota;
        }
    }
    public String getContenido(){ return contenido; }
    public void setContenido(String c){ contenido = c; }

}
