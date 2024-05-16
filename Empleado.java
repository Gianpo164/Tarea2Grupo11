package org.example;

/**
 * Representación de los empleados de una empresa
 */
public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;
    /**
     * Estado de invitación del empleado
     */
    public boolean invitado = false;

    /**
     * Crea un empleado con sus datos correspondientes
     * @param ID Identidficación del empleado
     * @param APELLIDOS Apellidos del empleado
     * @param NOMBRE Nombre del empleado
     * @param CORREO Correo del empleado
     */
    public Empleado (String ID, String APELLIDOS, String NOMBRE, String CORREO) {
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }

    /**
     * Devuelve la ID del empleado
     * @return Identificación del empleado
     */
    public String getId() {
        return id;
    }
    public void setId(String id){this.id = id; }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos){this.apellidos = apellidos; }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){this.nombre = nombre; }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo){this.correo = correo; }
    /**
     * Guarda el nombre del departamento al que pertenece el empleado
     * @param d Nombre del departamento
     */
    public void setDepartamento(String d){
        departamento = d;
    }

    /**
     * Devuelve el nombre del departamento al que el empleado pertenece
     * @return Nombre del departamento
     */
    public String getDepartamento(){ return departamento; }






    /**
     * Invita al empleado a una reunión y cambia su estado de inivitación
     * @param invi Invitación a una reunión
     */
    @Override
    public void invitar(Invitacion invi) {
        if (invi != null)
            invitado = true;
    }

    /**
     * Devuelve el estado de invitación a una reunión del empleado
     * @return Estado de invitación
     */
    @Override
    public boolean getInvitado() {
        return invitado;
    }
}