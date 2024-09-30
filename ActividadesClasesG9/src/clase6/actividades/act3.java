package clase6.actividades;

import clase6.models.Proyecto;
import clase6.models.Resultado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class act3 {



        public static void main(String[] args) {
            int[] costos = {10, 15, 20, 25};
            int[] beneficios = {100, 200, 150, 300};
            int presupuesto = 35;

            // Fuerza Bruta: Complejidad temporal O(2^n) estamos revisando todas las combinaciones posibles
            Resultado resultadoFuerzaBruta = obtenerMaxBeneficioFuerzaBruta(costos, beneficios, presupuesto);
            System.out.println("---- Fuerza Bruta ----");
            System.out.println("El beneficio máximo es: " + resultadoFuerzaBruta.beneficioMaximo);
            System.out.print("Proyectos seleccionados: ");
            for (int proyecto : resultadoFuerzaBruta.proyectosSeleccionados) {
                System.out.print(proyecto + " ");
            }
            System.out.println("\n");

            // Programación Dinámica O(n.P) P es el presupuesto.
            Resultado resultadoDinamico = obtenerMaxBeneficioDinamico(costos, beneficios, presupuesto);
            System.out.println("---- Programación Dinámica ----");
            System.out.println("El beneficio máximo es: " + resultadoDinamico.beneficioMaximo);
            System.out.print("Proyectos seleccionados: ");
            for (int proyecto : resultadoDinamico.proyectosSeleccionados) {
                System.out.print(proyecto + " ");
            }
            System.out.println("\n");

            // Greedy O(n log n)
            Resultado resultadoGreedy = obtenerMaxBeneficioGreedy(costos, beneficios, presupuesto);
            System.out.println("---- Greedy ----");
            System.out.println("El beneficio máximo es: " + resultadoGreedy.beneficioMaximo);
            System.out.print("Proyectos seleccionados: ");
            for (int proyecto : resultadoGreedy.proyectosSeleccionados) {
                System.out.print(proyecto + " ");
            }
        }

        // Fuerza Bruta
        public static Resultado obtenerMaxBeneficioFuerzaBruta(int[] costos, int[] beneficios, int presupuesto) {
            int n = costos.length;
            int maxBeneficio = 0;
            List<Integer> proyectosSeleccionados = new ArrayList<>();

            for (int i = 0; i < (1 << n); i++) {
                int costoTotal = 0;
                int beneficioTotal = 0;
                List<Integer> proyectosActuales = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        costoTotal += costos[j];
                        beneficioTotal += beneficios[j];
                        proyectosActuales.add(j + 1);
                    }
                }

                if (costoTotal <= presupuesto && beneficioTotal > maxBeneficio) {
                    maxBeneficio = beneficioTotal;
                    proyectosSeleccionados = new ArrayList<>(proyectosActuales);
                }
            }

            return new Resultado(maxBeneficio, proyectosSeleccionados);
        }


        public static Resultado obtenerMaxBeneficioDinamico(int[] costos, int[] beneficios, int presupuesto) {
            int n = costos.length;
            int[][] dp = new int[n + 1][presupuesto + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= presupuesto; j++) {
                    if (costos[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            int maxBeneficio = dp[n][presupuesto];
            List<Integer> proyectosSeleccionados = new ArrayList<>();

            int w = presupuesto;
            for (int i = n; i > 0 && maxBeneficio > 0; i--) {
                if (maxBeneficio != dp[i - 1][w]) {
                    proyectosSeleccionados.add(i);
                    maxBeneficio -= beneficios[i - 1];
                    w -= costos[i - 1];
                }
            }

            return new Resultado(dp[n][presupuesto], proyectosSeleccionados);
        }


        public static Resultado obtenerMaxBeneficioGreedy(int[] costos, int[] beneficios, int presupuesto) {
            int n = costos.length;
            Proyecto[] proyectos = new Proyecto[n];

            for (int i = 0; i < n; i++) {
                proyectos[i] = new Proyecto(i + 1, costos[i], beneficios[i], (double) beneficios[i] / costos[i]);
            }

            java.util.Arrays.sort(proyectos, Comparator.comparingDouble(p -> -p.relacionBeneficioCosto));

            int maxBeneficio = 0;
            List<Integer> proyectosSeleccionados = new ArrayList<>();

            for (Proyecto proyecto : proyectos) {
                if (proyecto.costo <= presupuesto) {
                    proyectosSeleccionados.add(proyecto.indice);
                    maxBeneficio += proyecto.beneficio;
                    presupuesto -= proyecto.costo;
                }
            }

            return new Resultado(maxBeneficio, proyectosSeleccionados);
        }
    }
