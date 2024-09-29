import clase2.algoritmos.BusquedaBinaria;

public static void main(String[] args) {
    int[] listaDesordenada = {34, 7, 23, 32, 5, 62};
    int elementoBuscado = BusquedaBinaria.busquedaBinaria(listaDesordenada, 62);
    System.out.println("Elemento buscado se encuentra en el índice: " + elementoBuscado);
}