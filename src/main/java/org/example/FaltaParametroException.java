package org.example;

/**
 * Excepción que maneja un mensaje de error personalizado
 */
public class FaltaParametroException extends Exception{
    /**
     * Creación de la excepción para la situación especificada
     * @param mensajeError Mensaje de error que será entregado
     */
    public FaltaParametroException(String mensajeError){
        super(mensajeError);
    }
}
