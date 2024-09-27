package clase2.activiades;

import clase2.algoritmos.MergeSort;

public class act4 {

public static void main(String[] args) {    int[] listaDesordenada2 = {34, 7, 23, 32, 5, 62};
    MergeSort.mergeSort(listaDesordenada2);
    System.out.println("Lista ordenada:");
    for (int i = 0; i < listaDesordenada2.length; i++) {
        System.out.print(listaDesordenada2[i] + " ");
    }}


}
