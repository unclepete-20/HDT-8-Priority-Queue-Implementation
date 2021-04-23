/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 8
 */

public class Paciente implements Comparable<Paciente>{

    //Atributos de la clase paciente.
    private String nombre;
    private String enfermedad;
    private String prioridad;
    private int codigo;

    public Paciente(String nombre, String enfermedad, String codigoPrioridad){ //Constructor de la clase Paciente.

        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad = codigoPrioridad;
    }

    public void conversionClave(){ //Convierte las clavez alfabeticas por claves numericas.
        
        char clave = prioridad.charAt(0);
        int codigoNumerico = (int)(clave);
        this.codigo = codigoNumerico - 64;
        
    }


    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }


    
    /** 
     * @return String
     */
    public String getEnfermedad() {
        return enfermedad;
    }


    
    /** 
     * @return String
     */
    public String getPrioridad() {
        return prioridad;
    }
    

    
    /** 
     * @return int
     */
    public int getCodigo() {
        return codigo;
    }


    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    /** 
     * @param enfermedad
     */
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }


    
    /** 
     * @param prioridad
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    
    /** 
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {

        return "Nombre: " + nombre + " Enfermedad: " + enfermedad + " Prioridad: " + prioridad;
    }


    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Paciente o) {

        return (this.codigo - o.getCodigo());
    }

    
    
}
