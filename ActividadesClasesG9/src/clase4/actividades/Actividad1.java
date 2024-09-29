package clase4.actividades;

import java.util.Collections;
import java.util.ArrayList;

public class Actividad1 {
    /*
    Implementar una función que, siguiendo la técnica de diseño greedy, determine si 
    es posible entregar un cambio exacto utilizando una lista de monedas disponible.
    Realizar pseudocódigo e implementación en java.
    Indicar la complejidad algorítmica
    */    
        public static void main(String[] args) {
            int[] monedas = {50,10,10,5};
            int monto = 70;

            System.out.println(tieneCambio(monedas,monto));
        }

        private static boolean tieneCambio(int[] monedas, int monto) {
            boolean rta = false;
            ArrayList<Integer> numeros = new ArrayList<>();
            for(int i=0; i< monedas.length; i++) {
                numeros.add(monedas[i]);
            }

            Collections.sort(numeros,Collections.reverseOrder());
            for(Integer n : numeros) {
                System.out.println(monto + " " + n);
                monto -= n;
                if (monto==0) return true;
            }

            return rta;
        }

}

