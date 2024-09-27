package clase2.activiades;

import clase2.algoritmos.QuickSort;

public class act3 {
    public static void main(String[] args) {
        int[] listaDesordenada = {34, 7, 23, 32, 5, 62};
        QuickSort.quickSort(listaDesordenada, 0, listaDesordenada.length - 1);

        System.out.println("Lista ordenada:");
        for (int i = 0; i < listaDesordenada.length; i++) {
            System.out.print(listaDesordenada[i] + " ");
        }
    }
}
