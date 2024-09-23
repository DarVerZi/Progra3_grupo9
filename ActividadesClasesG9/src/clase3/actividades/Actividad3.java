package clase3.actividades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import clase3.models.Cliente;

public class Actividad3 {

/*  Objetivo: Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, 
    nombre y scoring, buscando los dos clientes con los scoring máximos. 
    Tareas:
    Resolver mediante pseudocódigo
    Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas 
    matemáticas) para indicar la complejidad algorítmica.
    Implementar en java
 */

    public static List<Cliente> buscarMaxScoringClientes(List<Cliente> clientes, int n) {
        if (clientes.size() <= n) {
            return new ArrayList<>(clientes);
        }

        int mitad = clientes.size() / 2;
        List<Cliente> izq = clientes.subList(0, mitad);
        List<Cliente> der = clientes.subList(mitad, clientes.size());

        List<Cliente> maxizq = buscarMaxScoringClientes(izq, n);
        List<Cliente> maxder = buscarMaxScoringClientes(der, n);

        return mergeMaxN(maxizq, maxder, n);
    }

    private static List<Cliente> mergeMaxN(List<Cliente> izq, List<Cliente> der, int n) {
        List<Cliente> merged = new ArrayList<>(izq);
        merged.addAll(der);
        merged.sort(Comparator.comparingInt(cliente -> -cliente.getScoring()));

        return merged.subList(0, Math.min(n, merged.size()));
    }

    public static void Actividad_test (String[] args) {
        List<Cliente> clientes = List.of(
            new Cliente(1, "Juan", 85),
            new Cliente(2, "Ana", 92),
            new Cliente(3, "Luis", 78),
            new Cliente(4, "Maria", 95),
            new Cliente(5, "Carlos", 88)
        );

        int n = 3;
        List<Cliente> maxClientes = buscarMaxScoringClientes(clientes, n);
        System.out.println("Los " + n + " clientes con el scoring máximo son:");
        for (Cliente cliente : maxClientes) {
            cliente.toString();
        }
    }

}
