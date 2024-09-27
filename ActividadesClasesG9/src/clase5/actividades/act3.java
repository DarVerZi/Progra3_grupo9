package clase5.actividades;

import clase5.algoritmos.GrafoListaAdyacencia;
import clase5.algoritmos.PrimAlgorithm;

public class act3 {
    public static void main(String[] args) {
        int numVertices = 4;
        GrafoListaAdyacencia grafoLista = new GrafoListaAdyacencia(numVertices);

        grafoLista.agregarArista(0, 1, 1);
        grafoLista.agregarArista(0, 2, 4);
        grafoLista.agregarArista(1, 3, 3);
        grafoLista.agregarArista(2, 3, 2);

        PrimAlgorithm.primMST(numVertices, grafoLista.getListaAdyacencia());
    }
}