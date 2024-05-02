package org.example;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> Empleados;
    public Departamento(String NOMBRE) {
        Empleados = new ArrayList<Empleado>();
        nombre = NOMBRE;
    }
    public void addEmpleado(Empleado e) {
        Empleados.add(e);
    }
    public int ObtenerCntEmpleados() {
        return Empleados.size();
    }
}
