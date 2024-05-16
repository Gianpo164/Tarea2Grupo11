package org.example;

public class FaltaParametroException extends Exception{
    public FaltaParametroException(String mensajeError){
        super(mensajeError);
    }
}
