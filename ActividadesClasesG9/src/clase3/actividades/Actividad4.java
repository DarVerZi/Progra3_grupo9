package clase3.actividades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Actividad4 {
    
/*  Objetivo: Encontrar los "n" elementos más grandes en una lista utilizando la 
    técnica de Divide y Vencerás
    Tareas:
    Resolver mediante pseudocódigo
    Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas 
    matemáticas) para indicar la complejidad algorítmica.
    Implementar en java
 */

 

 public static List<Integer> findMaxNElements(List<Integer> numbers, int n) {
    
    if (numbers.size() <= n) {
            return new ArrayList<>(numbers);
        }

        int mid = numbers.size() / 2;
        List<Integer> left = numbers.subList(0, mid);
        List<Integer> right = numbers.subList(mid, numbers.size());

        List<Integer> maxLeft = findMaxNElements(left, n);
        List<Integer> maxRight = findMaxNElements(right, n);

        return mergeMaxN(maxLeft, maxRight, n);
    }

    private static List<Integer> mergeMaxN(List<Integer> left, List<Integer> right, int n) {
        List<Integer> merged = new ArrayList<>(left);
        merged.addAll(right);
        merged.sort(Comparator.reverseOrder());

        return merged.subList(0, Math.min(n, merged.size()));
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 5, 1, 9, 7, 2, 8, 6, 4);

        int n = 3;
        List<Integer> maxElements = findMaxNElements(numbers, n);
        System.out.println("Los " + n + " elementos más grandes son: " + maxElements);
    }
}
