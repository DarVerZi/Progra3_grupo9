package clase3.actividades;

import java.util.List;
import clase3.models.Cliente;

public class Actividad1 {
    
    /* Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, nombre y 
        scoring, buscando el cliente con el scoring máximo.
        Resolver mediante pseudocódigo
        Implementar en java
        Realizar el análisis de recurrencia por método inductivo (sin usar fórmulas 
        matemáticas) para indicar la complejidad algorítmica 
    */

    public Cliente clienteMayorScore (List <Cliente> clientes) {
        
        if (clientes.size() == 1) {
            return clientes.get(0);
        }

        int mid = clientes.size() / 2;
        List<Cliente> izq = clientes.subList(0, mid);
        List<Cliente> der = clientes.subList(mid, clientes.size());

        Cliente maxIzq = clienteMayorScore(izq);
        Cliente maxDer = clienteMayorScore(der);

        return maxIzq.getScoring() > maxDer.getScoring() ? maxIzq : maxDer;
    }
}
