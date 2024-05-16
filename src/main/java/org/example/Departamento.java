package org.example;

import java.util.ArrayList;

/**
 * Representación de los departamentos de una empresa
 */
public class Departamento implements Invitable {
    private String nombre;
    private ArrayList<Empleado> Empleados;

    /**
     * Crea un departamento con el nombre especificado, además creo la lista de empleados del departamento
     * @param NOMBRE Nombre del departamento
     */
    public Departamento(String NOMBRE) {
        Empleados = new ArrayList<Empleado>();
        nombre = NOMBRE;
    }

    /**
     * Añade empleados al departamento
     * @param e Empleado que será añadido al departamento
     */
    public void addEmpleado(Empleado e) {
        Empleados.add(e);
        e.setDepartamento(nombre);
    }

    /**
     * Devuelve al empleado que este emparejado con la ID ingresada
     * @param ID Identificación del empleado
     * @return Empleado al que le corresponda la ID ingresada
     */
    public Empleado getEmpleado(String ID) {
        Empleado aux = null;
        for (int i = 0; i < Empleados.size(); i++)
            if (ID == Empleados.get(i).getId()) {
                aux = Empleados.get(i);
                break;
            }
        return aux;
    }

    /**
     * Decuelve la lista de empleados del departamento
     * @return Lista de empleados
     */
    public ArrayList<Empleado> getEmpleados() {
        return Empleados;
    }

    /**
     * Devuelve el total de empleados pertenecientes al departamento
     * @return Total de empleados
     */
    public int ObtenerCntEmpleados() {
        return Empleados.size();
    }

    /**
     * Invita a todos los empleados del departamento a una reunión
     * @param invi Invitación a una reunión
     */
    @Override
    public void invitar(Invitacion invi) {
        if (invi != null)
            for (int i = 0; i < Empleados.size(); i++)
                Empleados.get(i).invitado = true;
    }

    /**
     * Devuelve el estado de invitación del departamento, dependiendo si todos sus empleados están invitados o no
     * @return Estado de invitación
     */
    @Override
    public boolean getInvitado() {
        boolean valor = true;
        for (int i = 0; i < Empleados.size(); i++)
            if (!Empleados.get(i).invitado) {
                valor = false;
                break;
            }
        return valor;
    }
}
