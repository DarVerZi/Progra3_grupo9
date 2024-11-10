package clase12.actividades;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
 
    class Node {
        String name;
        int cost;
    
        public Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

public class Act2 {

        private final Map<String, List<Node>> graph = new HashMap<>();
    
        // Método para agregar conexiones entre destinos
        public void addEdge(String from, String to, int cost) {
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Node(to, cost));
        }
    
        // Método para realizar búsqueda UCS con un itinerario de menor costo
        public int buscarViajeCostoMinimo(String origen, String destino) {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
            priorityQueue.add(new Node(origen, 0));
            Set<String> visitados = new HashSet<>();
            Map<String, String> predecesores = new HashMap<>(); // Para rastrear la ruta
    
            while (!priorityQueue.isEmpty()) {
                Node actual = priorityQueue.poll();
    
                // Si alcanzamos el destino, mostramos la ruta y retornamos el costo
                if (actual.name.equals(destino)) {
                    mostrarRuta(predecesores, origen, destino);
                    return actual.cost;
                }
    
                // Si ya visitamos este nodo, lo ignoramos
                if (visitados.contains(actual.name)) continue;
                visitados.add(actual.name);
    
                // Explorar vecinos
                for (Node vecino : graph.getOrDefault(actual.name, new ArrayList<>())) {
                    if (!visitados.contains(vecino.name)) {
                        int nuevoCosto = actual.cost + vecino.cost;
                        priorityQueue.add(new Node(vecino.name, nuevoCosto));
                        predecesores.put(vecino.name, actual.name); // Guardar el nodo previo para reconstruir la ruta
                    }
                }
            }
    
            System.out.println("No se encontró un camino desde " + origen + " hasta " + destino);
            return -1; // Retorna -1 si no se encuentra un camino
        }
    
        // Método para mostrar la ruta de menor costo
        private void mostrarRuta(Map<String, String> predecesores, String origen, String destino) {
            Stack<String> ruta = new Stack<>();
            String paso = destino;
    
            while (paso != null) {
                ruta.push(paso);
                paso = predecesores.get(paso);
            }
    
            System.out.print("Ruta de menor costo: ");
            while (!ruta.isEmpty()) {
                System.out.print(ruta.pop() + (ruta.isEmpty() ? "" : " -> "));
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            Act2 seleccionViaje = new Act2();
    
            // Agregar conexiones entre destinos y sus costos
            seleccionViaje.addEdge("A", "B", 50);
            seleccionViaje.addEdge("A", "C", 70);
            seleccionViaje.addEdge("B", "C", 40);
            seleccionViaje.addEdge("B", "D", 100);
            seleccionViaje.addEdge("C", "E", 60);
            seleccionViaje.addEdge("D", "E", 20);
    
            // Parámetros del viaje
            String origen = "A";
            String destino = "E";
            
            // Ejecutar búsqueda del viaje de menor costo
            int costoTotal = seleccionViaje.buscarViajeCostoMinimo(origen, destino);
    
            if (costoTotal != -1) {
                System.out.println("El costo mínimo desde " + origen + " hasta " + destino + " es: " + costoTotal);
            } else {
                System.out.println("No se encontró un camino desde " + origen + " hasta " + destino);
            }
        }
}
