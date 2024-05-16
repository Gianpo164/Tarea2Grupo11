package org.example;

/**
 * Enumeración de los tipos de reunión
 */
public enum tipoReunion {
    /**
     * Reunión de tipo tecnica
     */
    TECNICA("Tecnica"),
    /**
     * Reunión de tipo marketing
     */
    MARKETING("Marketing"),
    /**
     * Reunión de otro tipo
     */
    OTRO("Otro");

    private final String tipo;

    tipoReunion(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){ return tipo; }

}
