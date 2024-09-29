package clase4.algoritmos;

import clase4.models.Comprobantes;
import java.util.ArrayList;

public class MergeSortComprobantes {

    public static void mergeSort(ArrayList<Comprobantes> lista) {
        if (lista.size() < 2) {
            return; // Si la lista tiene 0 o 1 elementos, ya está ordenada
        }
        int medio = lista.size() / 2;

        // Dividir la lista en dos mitades
        ArrayList<Comprobantes> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Comprobantes> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(lista, izquierda, derecha);
    }

    private static void merge(ArrayList<Comprobantes> lista, ArrayList<Comprobantes> izquierda, ArrayList<Comprobantes> derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).getValor() <= derecha.get(j).getValor() ) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.size()) {
            lista.set(k++, izquierda.get(i++));
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.size()) {
            lista.set(k++, derecha.get(j++));
        }
    }

}
