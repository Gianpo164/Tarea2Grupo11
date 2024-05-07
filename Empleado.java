package org.example;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Boolean invitado = false;

    public Empleado (String ID, String APELLIDOS, String NOMBRE, String CORREO) {
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }

    @Override
    public void invitar(Invitacion invi) {
        invitado = true;
    }
    @Override
    public Boolean getInvitado() {
        return invitado;
    }
}