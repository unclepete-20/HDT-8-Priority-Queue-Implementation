/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 8
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DriverEmergencia {

    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean cycle1 = true;

        while(cycle1){ 
            //Menu inicial.
            System.out.println("\nEscoga la implementacion para ordenar a sus pacientes: \n");
            System.out.println("1. VectorHeap");
            System.out.println("2. Priority Queue");
            System.out.println("3. Salir\n");

            int option = scan.nextInt();

            switch(option){

                case 1:{ //Sistema de emergencias con la implementacion de VectorHeap.

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

                    boolean cycle2 = true;

                    while(cycle2){

                        System.out.println("\n================================= SISTEMA DE EMERGENCIAS DEL HOSPITAL ROOSEVELT =================================\n");
                        System.out.println("1. Siguiente paciente");
                        System.out.println("2. Salir");

                        int option2 = scan.nextInt();

                        if(option2 == 1){ //Sale del sistema si no encuentra pacientes en el sistema.
                            if(vector.isEmpty()){
                                System.out.println("\nNo hay pacientes. Saliendo del sistema...\n");
                                System.exit(1);

                            } else { //Se escogen a los pacientes segun su codigo de prioridad.
                                System.out.println("\nPaciente por atender segun su prioridad:\n");
                                System.out.println(vector.remove());
                            }
                        } else if(option2 == 2){
                            System.out.println("\nSaliendo del sistema...\n");
                            vector.clear();
                            cycle2 = false;
                        }
                    }

                    break;
                }

                case 2:{//Sistema que utiliza el Priority Queue.

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

                    boolean cycle3 = true;

                    while(cycle3){

                        System.out.println("\n================================= SISTEMA DE EMERGENCIAS DEL HOSPITAL ROOSEVELT =================================\n");
                        System.out.println("1. Siguiente paciente");
                        System.out.println("2. Salir");

                        int option2 = scan.nextInt();

                        if(option2 == 1){ //Sale del sistema si no encuentra pacientes en el sistema.
                            if(queue.isEmpty()){
                                System.out.println("\nNo hay pacientes. Saliendo del sistema...\n");
                                System.exit(1);

                            } else { //Se escogen a los pacientes segun su codigo de prioridad.
                                System.out.println("\nPaciente por atender segun su prioridad:\n");
                                System.out.println(queue.poll());
                            }
                        } else if(option2 == 2){
                            System.out.println("\nSaliendo del sistema...\n");
                            queue.clear();
                            cycle3 = false;
                        }

                    }

                    break;
                }

                case 3:{//Se sale del programa.
                    System.out.println("\nSaliedo del sistema...\n");
                    cycle1 = false;
                    scan.close();
                    break;
                }
            }
        }


    }
}
