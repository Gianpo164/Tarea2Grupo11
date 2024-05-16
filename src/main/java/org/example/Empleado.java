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
     * Devuelve la identificación asociada al empleado
     * @return Identificación del empleado
     */
    public String getId() {
        return id;
    }

    /**
     * Establece la identififcación asociada al empleado
     * @param id Identificación del empleado
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devuelve los apellidos asociados al empleado
     * @return Apellidos del empleado
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos asociados al empleado
     * @param apellidos Apellidos del empleado
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve el nombre asociado al empleado
     * @return Nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre asociado al empleado
     * @param nombre Nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el correo asociado al empleado
     * @return Correo del empleado
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece un correo para el empleado
     * @param correo Correo del empleado
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve el nombre del departamento al que el empleado pertenece
     * @return Nombre del departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Guarda el nombre del departamento al que pertenece el empleado
     * @param d Nombre del departamento
     */
    public void setDepartamento(String d){
        departamento = d;
    }

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