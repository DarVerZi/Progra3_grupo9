package clase5.actividades;

import clase5.algoritmos.GrafoAdyacencia;

public class act2 {
    public static void main(String[] args) {

    GrafoAdyacencia grafo = new GrafoAdyacencia(4);

    // Agregar aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);

    // Verificar aristas
        System.out.println("¿Existe arista de 0 a 1? " + grafo.existeArista(0, 1));
        System.out.println("¿Existe arista de 1 a 2? " + grafo.existeArista(1, 2));

    // Listar adyacentes
        grafo.listarAdyacentes(0);

    // Grados de entrada y salida
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de 3: " + grafo.contarGradoEntrada(3));
}
}