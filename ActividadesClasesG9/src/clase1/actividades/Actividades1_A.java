package clase1.actividades;

import java.util.List;

public class Actividades1_A {
        /* a. Realizar un programa en java, dado un array, calcular el máximo.
                ¿ Cual es el orden de complejidad asintótica ? */
        
        public int buscarMaximo (List<Integer> numeros) {
                int salida = 0;
                
                for (int num : numeros) {
                if ( salida <= num ) {
                        salida = num;
                }
            }
                return salida;
        }
    
}
