package clase10.actividades;

public class Act2 {
    

    static int N = 4; // Tamaño del tablero 4x4

    // Verifica si la ubicación de un escritorio es válida
    public static boolean esSeguroEscritorio(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) { // Evita conflictos en la fila o columna
                return false;
            }
        }
        return true;
    }

    // Verifica si la ubicación de una silla es válida
    public static boolean esSeguroSilla(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2 || tablero[i][col] == 2) { // Evita conflictos en la fila o columna
                return false;
            }
        }
        return true;
    }

    // Función para resolver el problema
    public static void resolverDisenoInteriores() {
        int[][] tablero = new int[N][N]; // Crear un tablero vacío
        colocarEscritorios(tablero, 0, 0); // Iniciar colocando escritorios
    }

    // Función recursiva para colocar escritorios en posiciones válidas
    public static void colocarEscritorios(int[][] tablero, int fila, int escritoriosColocados) {
        if (escritoriosColocados == 4) { // Si se han colocado 4 escritorios
            colocarSillas(tablero, 0, 0, 0); // Iniciar colocando las sillas
            return; // Continuar buscando otras soluciones
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroEscritorio(tablero, i, j)) {
                    tablero[i][j] = 1; // Colocar un escritorio
                    colocarEscritorios(tablero, i + 1, escritoriosColocados + 1); // Colocar el siguiente escritorio
                    tablero[i][j] = 0; // Backtracking: quitar el escritorio
                }
            }
        }
    }

    // Función recursiva para colocar sillas en posiciones válidas
    public static void colocarSillas(int[][] tablero, int fila, int col, int sillasColocadas) {
        if (sillasColocadas == 4) { // Si se han colocado 4 sillas
            imprimirTablero(tablero); // Imprimir el tablero con una solución válida
            return; // Continuar buscando otras soluciones
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esSeguroSilla(tablero, i, j) && tablero[i][j] == 0) { // Verifica que no haya conflicto
                    tablero[i][j] = 2; // Colocar una silla
                    colocarSillas(tablero, i + 1, 0, sillasColocadas + 1); // Colocar la siguiente silla
                    tablero[i][j] = 0; // Backtracking: quitar la silla
                }
            }
        }
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("E "); // Escritorio
                } else if (tablero[i][j] == 2) {
                    System.out.print("S "); // Silla
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDisenoInteriores();
    }

}
