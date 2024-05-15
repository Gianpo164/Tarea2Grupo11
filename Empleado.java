package org.example;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;
    public boolean invitado = false;

    public Empleado (String ID, String APELLIDOS, String NOMBRE, String CORREO) {
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }
    public void setDepartamento(String d){
        departamento = d;
    }
    public String getDepartamento(){ return departamento; }

    public String getId() {
        return id;
    }
    @Override
    public void invitar(Invitacion invi) {
        if (invi != null)
            invitado = true;
    }
    @Override
    public boolean getInvitado() {
        return invitado;
    }
}