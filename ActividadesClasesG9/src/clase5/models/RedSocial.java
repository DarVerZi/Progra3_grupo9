package clase5.models;

import java.util.*;

public class RedSocial {
    private Map<Usuario, Set<Usuario>> listaAdyacencia;

    public RedSocial() {
        this.listaAdyacencia = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(Usuario usuario) {
        listaAdyacencia.putIfAbsent(usuario, new HashSet<>());
    }

    // Un usuario sigue a otro
    public void seguir(Usuario seguidor, Usuario seguido) {
        if (!listaAdyacencia.containsKey(seguidor)) {
            System.out.println(seguidor + " no está registrado en el sistema.");
            return;
        }
        if (!listaAdyacencia.containsKey(seguido)) {
            System.out.println(seguido + " no está registrado en el sistema.");
            return;
        }
        listaAdyacencia.get(seguidor).add(seguido);
    }

    // Un usuario deja de seguir a otro
    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (listaAdyacencia.containsKey(seguidor)) {
            listaAdyacencia.get(seguidor).remove(seguido);
        }
    }

    // Obtener la lista de usuarios que sigue un usuario dado
    public Set<Usuario> listaDeSeguidos(Usuario usuario) {
        return listaAdyacencia.getOrDefault(usuario, new HashSet<>());
    }

    // Obtener la lista de seguidores de un usuario dado
    public Set<Usuario> listaDeSeguidores(Usuario usuario) {
        Set<Usuario> seguidores = new HashSet<>();
        for (Map.Entry<Usuario, Set<Usuario>> entry : listaAdyacencia.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }
}