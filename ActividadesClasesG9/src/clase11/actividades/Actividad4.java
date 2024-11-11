package clase11.actividades;

import java.util.*;


import clase11.models.Usuario;

class Actividad4 {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> adj;
    private int contadorUsuarios;

    public Actividad4() {
        this.usuarios = new HashMap<>();
        this.adj = new HashMap<>();
        this.contadorUsuarios = 0;
    }

    // Método para agregar un usuario a la red
    public void agregarUsuario(String nombre) {
        Usuario nuevoUsuario = new Usuario(contadorUsuarios, nombre);
        usuarios.put(contadorUsuarios, nuevoUsuario);
        adj.put(contadorUsuarios, new ArrayList<>());
        contadorUsuarios++;
    }

    // Método para conectar dos usuarios (amistad bidireccional)
    public void agregarAmistad(int id1, int id2) {
        if (!usuarios.containsKey(id1) || !usuarios.containsKey(id2)) {
            System.out.println("Uno o ambos usuarios no existen.");
            return;
        }
        adj.get(id1).add(id2);
        adj.get(id2).add(id1);
    }

    // Método para realizar BFS desde un usuario de inicio
    public void BFS(int idInicio) {
        if (!usuarios.containsKey(idInicio)) {
            System.out.println("El usuario de inicio no existe.");
            return;
        }

        boolean[] visitado = new boolean[contadorUsuarios]; // Array de visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para BFS

        visitado[idInicio] = true; // Marcar el usuario de inicio como visitado
        cola.add(idInicio); // Añadirlo a la cola

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            int idActual = cola.poll(); // Extraer el primer usuario de la cola
            System.out.print(usuarios.get(idActual).getNombre() + " "); // Mostrar el usuario

            // Obtener todos los usuarios adyacentes
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
        visitado[id] = true; // Marcar el usuario actual como visitado
        System.out.print(usuarios.get(id).getNombre() + " "); // Mostrar el usuario

        // Recorrer todos los usuarios adyacentes
        for (int idVecino : adj.get(id)) {
            if (!visitado[idVecino]) {
                DFSUtil(idVecino, visitado); // Llamada recursiva para los usuarios no visitados
            }
        }
    }

    // Método para realizar DFS desde un usuario de inicio
    public void DFS(int idInicio) {
        if (!usuarios.containsKey(idInicio)) {
            System.out.println("El usuario de inicio no existe.");
            return;
        }

        boolean[] visitado = new boolean[contadorUsuarios];
        System.out.println("Recorrido DFS:");
        DFSUtil(idInicio, visitado);
        System.out.println();
    }

    public static void main(String[] args) {

        Actividad4 redSocial = new Actividad4();

        redSocial.agregarUsuario("Dario");
        redSocial.agregarUsuario("Amaya");
        redSocial.agregarUsuario("Darian");
        redSocial.agregarUsuario("Julian");


        redSocial.agregarAmistad(0, 1); // Juan y Maria son amigos
        redSocial.agregarAmistad(1, 2); // Maria y Pedro son amigos
        redSocial.agregarAmistad(2, 3); // Pedro y Ana son amigos
        redSocial.agregarAmistad(3, 0); // Ana y Juan son amigos


        redSocial.BFS(0);

        redSocial.DFS(1);
    }
}
