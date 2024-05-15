package org.example;

import java.util.ArrayList;

public class Departamento implements Invitable {
    private String nombre;
    private ArrayList<Empleado> Empleados;
    public Departamento(String NOMBRE) {
        Empleados = new ArrayList<Empleado>();
        nombre = NOMBRE;
    }
    public void addEmpleado(Empleado e) {
        Empleados.add(e);
        e.setDepartamento(nombre);
    }
    public Empleado getEmpleado(String ID) {
        Empleado aux = null;
        for (int i = 0; i < Empleados.size(); i++)
            if (ID == Empleados.get(i).getId()) {
                aux = Empleados.get(i);
                break;
            }
        return aux;
    }
    public int ObtenerCntEmpleados() {
        return Empleados.size();
    }
    @Override
    public void invitar(Invitacion invi) {
        if (invi != null)
            for (int i = 0; i < Empleados.size(); i++)
                Empleados.get(i).invitado = true;
    }
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
