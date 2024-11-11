package clase11.actividades;

import models.Almacen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Actividad3 {
    private HashMap<Integer, Almacen> almacenes; // Mapa de almacenes
    private ArrayList<LinkedList<Integer>> adj; // Lista de adyacencia
    private int contadorAlmacenes; // Contador de almacenes para asignar IDs

    // Constructor
    public Actividad3() {
        almacenes = new HashMap<>();
        adj = new ArrayList<>();
        contadorAlmacenes = 0;
    }

    // Método para agregar un nuevo almacén
    public void agregarAlmacen(String nombre) {
        Almacen nuevoAlmacen = new Almacen(contadorAlmacenes, nombre);
        almacenes.put(contadorAlmacenes, nuevoAlmacen);
        adj.add(new LinkedList<>()); // Inicializar lista de adyacencia para el nuevo almacén
        contadorAlmacenes++; // Incrementar el contador de almacenes
    }

    // Método para conectar dos almacenes
    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adj.get(id1).add(id2);
            adj.get(id2).add(id1); // Grafo no dirigido (ruta bidireccional)
        } else {
            System.out.println("Uno o ambos almacenes no existen.");
        }
    }

    // Método para realizar BFS desde un almacén de inicio
    public void BFS(int idInicio) {
        if (!almacenes.containsKey(idInicio)) {
            System.out.println("El almacén de inicio no existe.");
            return;
        }

        boolean[] visitado = new boolean[contadorAlmacenes]; // Array de visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para BFS

        visitado[idInicio] = true; // Marcar el almacén de inicio como visitado
        cola.add(idInicio); // Añadirlo a la cola

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            int idActual = cola.poll(); // Extraer el primer almacén de la cola
            System.out.print(almacenes.get(idActual).getNombre() + " "); // Mostrar el almacén

            // Obtener todos los almacenes adyacentes
            for (int idVecino : adj.get(idActual)) {
                if (!visitado[idVecino]) {
                    visitado[idVecino] = true; // Marcar como visitado
                    cola.add(idVecino); // Añadir a la cola
                }
            }
        }
        System.out.println();
    }

    // Método auxiliar de DFS que se llama recursivamente
    private void DFSUtil(int id, boolean[] visitado) {
        visitado[id] = true; // Marcar el almacén actual como visitado
        System.out.print(almacenes.get(id).getNombre() + " "); // Mostrar el almacén

        // Recorrer todos los almacenes adyacentes
        for (int idVecino : adj.get(id)) {
            if (!visitado[idVecino]) {
                DFSUtil(idVecino, visitado); // Llamada recursiva para los almacenes no visitados
            }
        }
    }

    // Método para realizar DFS desde un almacén de inicio
    public void DFS(int idInicio) {
        if (!almacenes.containsKey(idInicio)) {
            System.out.println("El almacén de inicio no existe.");
            return;
        }

        boolean[] visitado = new boolean[contadorAlmacenes]; // Array para marcar los almacenes visitados
        System.out.println("Recorrido DFS:");
        DFSUtil(idInicio, visitado);
        System.out.println();
    }




    public static void main(String[] args) {
        Actividad3 redDeAlmacenes = new Actividad3();

        // Agregar almacenes
        redDeAlmacenes.agregarAlmacen("models.Almacen 0");
        redDeAlmacenes.agregarAlmacen("models.Almacen 1");
        redDeAlmacenes.agregarAlmacen("models.Almacen 2");
        redDeAlmacenes.agregarAlmacen("models.Almacen 3");
        redDeAlmacenes.agregarAlmacen("models.Almacen 4");
        redDeAlmacenes.agregarAlmacen("models.Almacen 5");
        redDeAlmacenes.agregarAlmacen("models.Almacen 6");
        redDeAlmacenes.agregarAlmacen("models.Almacen 7");
        redDeAlmacenes.agregarAlmacen("models.Almacen 8");


        // Conectar almacenes
        redDeAlmacenes.conectarAlmacenes(0, 1);
        redDeAlmacenes.conectarAlmacenes(0, 2);
        redDeAlmacenes.conectarAlmacenes(2, 5);
        redDeAlmacenes.conectarAlmacenes(1, 3);
        redDeAlmacenes.conectarAlmacenes(3, 6);
        redDeAlmacenes.conectarAlmacenes(1, 4);
        redDeAlmacenes.conectarAlmacenes(4, 7);
        redDeAlmacenes.conectarAlmacenes(4, 8);




        // Recorridos BFS y DFS
        redDeAlmacenes.BFS(6);
        redDeAlmacenes.DFS(6);
    }
}
