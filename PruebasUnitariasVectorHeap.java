/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PruebasUnitariasVectorHeap{

    VectorHeap<String> vhPrueba = new VectorHeap<String>();

    @Test
    public void pruebaVHAdd(){ //Prueba unitaria para el metodo Add del VectorHeap.

        vhPrueba.add("value");
        vhPrueba.add("value2");
        vhPrueba.add("value3");
        vhPrueba.add("value4");

        assertEquals(4, vhPrueba.size());

    }

    @Test
    public void pruebaVHRemove(){ //Prueba unitaria para el metodo Remove del VectorHeap.
     
        
        vhPrueba.add("value");
        vhPrueba.add("value2");
        vhPrueba.add("value3");
        vhPrueba.add("value4");

        vhPrueba.remove();
        vhPrueba.remove();
        vhPrueba.remove();
        vhPrueba.remove();

        assertEquals(true, vhPrueba.isEmpty());
    }
}