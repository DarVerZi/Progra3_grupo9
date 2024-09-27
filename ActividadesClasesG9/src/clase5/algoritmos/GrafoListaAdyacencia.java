package clase5.algoritmos;

import java.util.*;

public class GrafoListaAdyacencia {
    private int numVertices;
    private List<List<int[]>> listaAdyacencia;


    public GrafoListaAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }
    
    public void agregarArista(int verticeOrigen, int verticeDestino, int costo) {
        listaAdyacencia.get(verticeOrigen).add(new int[]{verticeDestino, costo});
        listaAdyacencia.get(verticeDestino).add(new int[]{verticeOrigen, costo}); // Arista bidireccional
    }

    public List<List<int[]>> getListaAdyacencia() {
        return listaAdyacencia;
    }
}
