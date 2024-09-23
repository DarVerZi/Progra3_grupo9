package clase3.actividades;

import java.util.List;

public class Actividad2 {
    
    /*  Objetivo: Dada una lista de números, encontrar los dos números mayores 
        utilizando la técnica de Divide y Conquista.
        Tareas:
        Pseudocódigo: Escribe el pseudocódigo que resuelva el problema.
        Implementación en Java: Implementa el pseudocódigo en Java.
        Análisis de Recurrencia: Realiza el análisis de recurrencia conceptual por el 
        método inductivo (sin utilizar fórmulas matemáticas) para determinar la 
        complejidad algorítmica del algoritmo.
    */

    public static int[] buscarMaxNumeros(List<Integer> numeros) {
        if (numeros.size() == 1) {
            return new int[]{numeros.get(0), Integer.MIN_VALUE};
        }
        if (numeros.size() == 2) {
            return numeros.get(0) > numeros.get(1) ? 
                   new int[]{numeros.get(0), numeros.get(1)} : 
                   new int[]{numeros.get(1), numeros.get(0)};
        }

        int mitad = numeros.size() / 2;
        List<Integer> izq = numeros.subList(0, mitad);
        List<Integer> der = numeros.subList(mitad, numeros.size());

        int[] maxizq = buscarMaxNumeros(izq);
        int[] maxder = buscarMaxNumeros(der);

        return mergeMaxNumeros(maxizq, maxder);
    }

    private static int[] mergeMaxNumeros(int[] izq, int[] der) {
        int[] result = new int[4];
        result[0] = izq[0];
        result[1] = izq[1];
        result[2] = der[0];
        result[3] = der[1];

        java.util.Arrays.sort(result);

        return new int[]{result[3], result[2]};
    }

}
