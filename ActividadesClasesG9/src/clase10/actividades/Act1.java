package clase10.actividades;

public class Act1 {


    static int N = 4; // Tamaño del tablero 4x4

    // Verifica si se puede colocar una reina en la posición (fila, col)
    public static boolean esSeguro(int tablero[][], int fila, int col) {
        // Verificar la fila y columna actuales
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) {
                return false;
            }
        }
        
        // Verificar diagonales
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i < N && j < N; i++, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        
        return true; // Es seguro colocar la reina
    }

    // Resuelve el problema de las dos reinas usando backtracking
    public static void resolverDosReinas() {
        int tablero[][] = new int[N][N]; // Crear un tablero vacío
        colocarReina(tablero, 0, 0, 0); // Iniciar desde la primera reina
    }

    // Función para colocar reinas en todas las posiciones válidas
    public static void colocarReina(int tablero[][], int fila, int col, int reinasColocadas) {
        if (reinasColocadas == 2) { // Cuando se han colocado dos reinas
            imprimirTablero(tablero);
            return; // Continuar buscando más combinaciones
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) { // Comenzar desde la última posición
                if (esSeguro(tablero, i, j)) {
                    tablero[i][j] = 1; // Colocar la reina
                    colocarReina(tablero, i, j + 1, reinasColocadas + 1); // Colocar la siguiente reina
                    tablero[i][j] = 0; // Backtrack: quitar la reina
                }
            }
        }
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int tablero[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] == 1 ? "R " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDosReinas();
    }

}
