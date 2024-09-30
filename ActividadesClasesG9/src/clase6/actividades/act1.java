package clase6.actividades;


import clase6.models.Objeto;

import java.util.ArrayList;
import java.util.List;

public class act1 {

    //Fuerza bruta
    public static void main(String[] args) {
        Objeto[] objetos = {
                new Objeto(3, 4),
                new Objeto(4, 5),
                new Objeto(2, 3)
        };
        int capacidad = 6;


        fuerzaBruta(objetos, capacidad);

        programacionDinamica(objetos, capacidad);


    }

    //Fuerza bruta

    public static void fuerzaBruta(Objeto[] objetos, int capacidad) {
        int n = objetos.length;
        int maxValue = 0;
        List<Objeto> bestCombination = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            int totalWeight = 0;
            int totalValue = 0;
            List<Objeto> currentCombination = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    totalWeight += objetos[j].peso;
                    totalValue += objetos[j].valor;
                    currentCombination.add(objetos[j]);
                }
            }

            if (totalWeight <= capacidad && totalValue > maxValue) {
                maxValue = totalValue;
                bestCombination = currentCombination;
            }
        }
        System.out.println("Mejor combinación (Fuerza Bruta):");
        for (Objeto objeto : bestCombination) {
            System.out.println("Peso: " + objeto.peso + ", Valor: " + objeto.valor);
        }
        System.out.println("Valor total: " + maxValue);
    }

    //Programación Dinámica

    public static void programacionDinamica(Objeto[] objetos, int capacidad) {
        int n = objetos.length;
        int[][] solucion = new int[n + 1][capacidad + 1];


        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (objetos[i - 1].peso <= w) {
                    solucion[i][w] = Math.max(solucion[i - 1][w], solucion[i - 1][w - objetos[i - 1].peso] + objetos[i - 1].valor);
                } else {
                    solucion[i][w] = solucion[i - 1] [w];
                }
            }
        }


        int valorMaximo = solucion[n][capacidad];
        System.out.println("Valor máximo (Programación Dinámica): " + valorMaximo);


        List<Objeto> mejorCombinacion = new ArrayList<>();
        int w = capacidad;
        for (int i = n; i > 0 && valorMaximo > 0; i--) {

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
}


