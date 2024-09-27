package clase7.actividades;

/*
 # Actividad 2
    Una empresa de logística tiene varios centros de distribución en diferentes ciudades de 
    una región y necesita optimizar las rutas de entrega de sus camiones. Cada centro de 
    distribución está conectado a otros centros mediante carreteras, y cada carretera tiene 
    un tiempo de viaje asociado en minutos. Además, algunos centros pueden tener costos 
    adicionales asociados que pueden resultar en tiempos negativos en algunas rutas 
    debido a descuentos especiales o condiciones excepcionales. La empresa desea no 
    solo minimizar el tiempo total de entrega desde su centro de distribución principal hasta 
    todas las otras ciudades, sino también identificar si existen ciclos negativos que podrían 
    llevar a oportunidades de ahorro infinito en el sistema de rutas.
    Objetivo:
    Aplicar el algoritmo de Floyd-Warshall para: Encontrar el tiempo mínimo de entrega 
    desde el centro de distribución principal hasta todos los demás centros de distribución, 
    considerando las diferentes rutas disponibles.
 */

public class Act2 {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito
    
    public static void main(String[] args) {
        Act2 fw = new Act2();
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
        printSolution(dist, V, centroDistribucion);
    }

    void printSolution(int dist[][], int V, String centroDistribucion [] ) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    if (dist[i][j] == INF)
                    System.out.println("Desde "+ centroDistribucion[i] +" Hasta " + centroDistribucion[j]  + "  No existe servicio" );
                    else
                        System.out.println("Desde "+ centroDistribucion[i] +" Hasta " + centroDistribucion[j]  + " Demora: " + dist[i][j] +" Mins" );
                    }
                }
            System.out.println();
        }
    }

}
