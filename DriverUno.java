import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

public class DriverUno {

    /** 
     * @param args
     */
    public static void main(String[] args) {

        VectorHeap<Paciente> vector = new VectorHeap<Paciente>(); //Instancia de un vector heap.
        
        try { //Se escanea el documento con los nombres, sintomas y codigo de prioridad.
            File file = new File("pacientes.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String infoPacientes = reader.nextLine();
                String[]  infoFichas = infoPacientes.split(","); //Se almacena esa informacion en un Array.

                Paciente paciente = new Paciente(infoFichas[0], infoFichas[1], infoFichas[2]); //Se creab los pacientes.

                paciente.conversionClave(); //Permite que el ordenamiento se lleve a cabo exitosamente.

                vector.add(paciente); //Se agregan los pacientes al vector heap.

            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        //Se imprime toda la informacion solicitada ordenada por codigo de prioridad.
        System.out.println("\n==================================== SISTEMA DE EMERGENCIAS DEL HOSPITAL ROOSEVELT ====================================\n");
        System.out.println("LISTA RECIEN INGRESADA\n");
        System.out.println(vector);

        System.out.println("\nLISTA ORGANIZADA POR PRIORIDAD\n");

        vector.sort(); //Se realiza el sorting que ordena por codigo de prioridad.

        System.out.println("\n");
    }
}
