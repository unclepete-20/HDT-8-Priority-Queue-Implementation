/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DriverDos {

    /** 
     * @param args
     */
    public static void main(String[] args) {

        PriorityQueue<Paciente> queue = new PriorityQueue<Paciente>(); 

        try {
            File file = new File("pacientes.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String infoPacientes = reader.nextLine();
                String[]  infoFichas = infoPacientes.split(","); 

                Paciente paciente = new Paciente(infoFichas[0], infoFichas[1], infoFichas[2]);

                paciente.conversionClave();

                queue.add(paciente);

            }

            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        System.out.println(queue);
    }
        
}

