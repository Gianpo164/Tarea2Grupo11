package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representación de un informe con la información de una reunión
 */
public class Informe {

    File informe;

    /**
     * Crea una instancia de Informe
     */
    public Informe() {}

    /**
     * Crea un informe sobre la reunión
     * @param momentoCreacion Valor para diferenciar cada informe
     */
    public void crearInforme(String momentoCreacion){
        informe = new File("Informe_"+ momentoCreacion + ".txt");
        try {
            if (informe.createNewFile()){
                System.out.println("Informe creado");
            }
            else{
                System.out.println("Error al crear el informe");
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Traspasa la información de la reunión al informe
     * @param r Reunión a la que le corresponde el informe
     */
    public void escribirContenido(Reunion r){
        try {
            FileWriter contenido = new FileWriter(informe);
            contenido.write("///////////////////  Informe de la reunion ///////////////////\n");
            contenido.write("Fecha de la reunion: " + r.fechaToString() + "\n");
            contenido.write("Hora prevista de inicio: " + r.horaPrevistaToString() + "\n");
            contenido.write("Hora de inicio: " + r.horaInicioToString() + "\n");
            contenido.write("Hora de fin: " + r.horaFinToString() + "\n");
            contenido.write("Duracion prevista: " + r.duracionPrevistaToString() + "\n");
            contenido.write("Duracion: " + r.calcularTiempoReal() + "s" + "\n");
            contenido.write("Organizador: " + r.getOrganizador().getNombre() + " " + r.getOrganizador().getApellidos() + "\n");
            contenido.write("Tipo de Reunion: " + r.getTipoDeReunion().getTipo() + "\n");
            contenido.write("Medio de la Reunion: " + r.getMedioReunion() + "\n");
            contenido.write(r.getSitioReunion() + "\n");
            contenido.write("Lista de Participantes: \n");
            for (int i = 0; i < r.getListaDeParticipantes().size(); i++) {
                ArrayList<Empleado> p = r.getListaDeParticipantes();
                contenido.write("\t" + p.get(i).getNombre() + " " + p.get(i).getApellidos() + "\n");
            }
            contenido.write("Notas: \n");
            for (int i = 0; i < r.getNotas().size(); i++) {
                ArrayList<Nota> n = r.getNotas();
                contenido.write("\t" + n.get(i).getContenido() + "\n");
            }
            contenido.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

