package clase5.algoritmos;

public class GrafoAdyacencia {
    private int[][] matrizAdyacencia;
    private int numVertices;


    public GrafoAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int verticeOrigen, int verticeDestino) {
        matrizAdyacencia[verticeOrigen][verticeDestino] = 1;
    }


    public void eliminarArista(int verticeOrigen, int verticeDestino) {
        matrizAdyacencia[verticeOrigen][verticeDestino] = 0;
    }

    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        return matrizAdyacencia[verticeOrigen][verticeDestino] == 1;
    }

    public void listarAdyacentes(int vertice) {
        System.out.print("Vértices adyacentes a " + vertice + ": ");
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                gradoSalida++;
            }
        }
        return gradoSalida;
    }

    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[i][vertice] == 1) {
                gradoEntrada++;
            }
        }
        return gradoEntrada;
    }
}
