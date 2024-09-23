package clase7.actividades;

/*
 # Actividad 1
    Tenemos 4 nodos y las siguientes aristas con sus respectivos pesos:
    1 → 2, peso 2
    2 → 4, peso 4
    1 → 4, peso 5
    4 → 3, peso 2
    Realizar una prueba de escritorio para el algoritmo de Floyd-Warshall, el cual es 
    un algoritmo clásico de programación dinámica que permite calcular las distancias 
    más cortas entre todos los pares de nodos en un grafo ponderado
 */

 public class Act1 {
    
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito
    
    public static void main(String[] args) {
        Act1 fw = new Act1();
        int graph[][] = { 
                            {0, 2,INF,5},
                            {INF, 0, INF,4},
                            {INF, INF, 0,INF},
                            {INF, INF, 2,0}
                        };
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

   
    
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
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
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
