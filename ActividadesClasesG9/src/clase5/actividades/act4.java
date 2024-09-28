package clase5.actividades;

import clase5.algoritmos.Dijkstra;

public class act4 {
    public static void main(String[] args) {
    int vertices = 5;  // Ejemplo con 5 centros de distribución
    Dijkstra.Graph graph = new Dijkstra.Graph(vertices);

    // Agregar carreteras entre los centros con los tiempos de viaje (en minutos)
        graph.addEdge(0, 1, 10);  // Carretera entre el centro 0 y el 1 con 10 minutos de viaje
        graph.addEdge(0, 4, 5);   // Carretera entre el centro 0 y el 4 con 5 minutos de viaje
        graph.addEdge(1, 4, 2);   // Carretera entre el centro 1 y el 4 con 2 minutos de viaje
        graph.addEdge(1, 2, 1);   // Carretera entre el centro 1 y el 2 con 1 minuto de viaje
        graph.addEdge(4, 2, 9);   // Carretera entre el centro 4 y el 2 con 9 minutos de viaje
        graph.addEdge(4, 3, 2);   // Carretera entre el centro 4 y el 3 con 2 minutos de viaje
        graph.addEdge(2, 3, 4);   // Carretera entre el centro 2 y el 3 con 4 minutos de viaje
    // Aplicar Dijkstra desde el centro de distribución principal (por ejemplo, el centro 0)
        graph.dijkstra(0);
    }
}
