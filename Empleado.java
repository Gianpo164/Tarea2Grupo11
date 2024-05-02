package org.example;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado (String ID, String APELLIDOS, String NOMBRE, String CORREO) {
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }

    @Override
    public Invitacion invitar(Invitacion invi) {
        return invi;
    }
}
