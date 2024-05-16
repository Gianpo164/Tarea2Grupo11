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

    /**
     * @param tipo Tipo de reunión
     */
    tipoReunion(String tipo){
        this.tipo = tipo;
    }

    /**
     * Devuelve el tipo de reunión
     * @return Tipo de reunión
     */
    public String getTipo(){ return tipo; }

}
