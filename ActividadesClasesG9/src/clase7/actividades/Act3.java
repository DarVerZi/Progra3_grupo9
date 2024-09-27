package clase7.actividades;

/*
 # Actividad 3
    Dada la consigna de la actividad 2, modificar o rehacer el programa, para que se 
    pida origen y destino y se imprima el camino más corto entre dos vértices.
 */

import java.util.Scanner;

public class Act3 {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito
    
    public static void main(String[] args) {
        Act3 fw = new Act3();
        String centroDistribucion [] = {"Pilar"
                                        ,"Moron"
                                        ,"La Plata"
                                       };

        int graph[][] = { 
                            {0, 8, 5},
                            {3, 0, INF},
                            {INF, 2, 0}
                        };
        int V = graph.length;
        fw.floydWarshall(graph, V, centroDistribucion);
    }

   
    
    void floydWarshall(int graph[][], int V, String centroDistribucion [] ) {
        int dist[][] = new int[V][V];
        Scanner scanner = new Scanner(System.in);
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
     // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        // IndicarDistancia(dist, V, centroDistribucion);
        ImprimirDestinos(centroDistribucion);
        System.out.println("Ingrese el Origen: ");
        String origen = scanner.nextLine();
        
        System.out.println("Ingrese el Destino: ");
        String destino = scanner.nextLine();

        IndicarDistancia(dist, centroDistribucion, Integer.parseInt(origen), Integer.parseInt(destino));

    }



    void ImprimirDestinos (String centroDistribucion []) {
        int tam = centroDistribucion.length;
        for (int i = 0; i < tam; i++) {
            System.out.println("Ingrese: " + i + " para " + centroDistribucion[i]);
        }
    }

  void IndicarDistancia(int dist[][], String centroDistribucion [] ,int origen ,int destino  ) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        if (origen != destino) {
            if (dist[origen][destino] == INF)
            System.out.println("Desde "+ centroDistribucion[origen] +" Hasta " + centroDistribucion[destino]  + "  No existe servicio" );
            else
                System.out.println("Desde "+ centroDistribucion[origen] +" Hasta " + centroDistribucion[destino]  + " Demora: " + dist[origen][destino] +" Mins" );
            }

    }

}
