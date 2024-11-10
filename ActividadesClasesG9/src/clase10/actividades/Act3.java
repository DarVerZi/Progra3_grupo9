package clase10.actividades;

public class Act3 {

    
    static int N = 4; // Tamaño del tablero 4x4
    
    // Verifica si la ubicación de una computadora es válida
    public static boolean esSeguroComputadora(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) { // Verificar filas y columnas
                return false;
            }
        }
        return true;
    }

    // Verifica si la ubicación de una impresora es válida
    public static boolean esSeguroImpresora(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2 || tablero[i][col] == 2) { // Verificar filas y columnas
                return false;
            }
        }
        return true;
    }

    // Función para resolver la disposición de equipos en la oficina
    public static void resolverDistribucionEquipos() {
        int[][] tablero = new int[N][N]; // Crear un tablero vacío
        colocarComputadoras(tablero, 0, 0); // Iniciar colocando las computadoras
    }

    // Función recursiva para colocar computadoras en posiciones válidas
    public static void colocarComputadoras(int[][] tablero, int fila, int computadorasColocadas) {
        if (computadorasColocadas == 4) { // Si se han colocado 4 computadoras
            colocarImpresoras(tablero, 0, 0, 0); // Iniciar colocando las impresoras
            return; // Continuar buscando otras soluciones
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroComputadora(tablero, i, j)) {
                    tablero[i][j] = 1; // Colocar una computadora
                    colocarComputadoras(tablero, i + 1, computadorasColocadas + 1); // Colocar la siguiente computadora
                    tablero[i][j] = 0; // Backtracking: quitar la computadora
                }
            }
        }
    }

    // Función recursiva para colocar impresoras en posiciones válidas
    public static void colocarImpresoras(int[][] tablero, int fila, int col, int impresorasColocadas) {
        if (impresorasColocadas == 4) { // Si se han colocado 4 impresoras
            imprimirTablero(tablero); // Imprimir el tablero con una solución válida
            return; // Continuar buscando otras soluciones
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esSeguroImpresora(tablero, i, j) && tablero[i][j] == 0) { // Verifica que no haya conflicto
                    tablero[i][j] = 2; // Colocar una impresora
                    colocarImpresoras(tablero, i + 1, 0, impresorasColocadas + 1); // Colocar la siguiente impresora
                    tablero[i][j] = 0; // Backtracking: quitar la impresora
                }
            }
        }
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("C "); // Computadora
                } else if (tablero[i][j] == 2) {
                    System.out.print("I "); // Impresora
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDistribucionEquipos();
    }
}
