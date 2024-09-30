package clase6.actividades;

import clase6.models.Objeto;

import java.util.ArrayList;
import java.util.List;

public class act2 {


    public static void programacionDinamica(Objeto[] objetos, int capacidad) {
        int n = objetos.length;
        int[][] solucion = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (objetos[i - 1].peso <= w) {
                    solucion[i][w] = Math.max(solucion[i - 1][w], solucion[i - 1][w - objetos[i - 1].peso] + objetos[i - 1].valor);
                } else {
                    solucion[i][w] = solucion[i - 1][w];
                }
            }
        }

        int valorMaximo = solucion[n][capacidad];
        System.out.println("Valor máximo (Programación Dinámica): " + valorMaximo);

        List<Objeto> mejorCombinacion = new ArrayList<>();
        int w = capacidad;
        for (int i = n; i > 0 && valorMaximo > 0; i--) {
            // Si el objeto fue incluido
            if (valorMaximo != solucion[i - 1][w]) {
                mejorCombinacion.add(objetos[i - 1]);
                valorMaximo -= objetos[i - 1].valor;
                w -= objetos[i - 1].peso;
            }
        }


        System.out.println("Mejor combinación (Programación Dinámica):");
        for (Objeto objeto : mejorCombinacion) {
            System.out.println("Peso: " + objeto.peso + ", Valor: " + objeto.valor);
        }
    }

    public static void main(String[] args) {
        Objeto[] objetos = {
                new Objeto(2, 4),
                new Objeto(5, 2),
                new Objeto(6, 1),
                new Objeto(7, 6)
        };
        int capacidad = 10;

        programacionDinamica(objetos, capacidad);


    }

}
