package clase4.actividades;

import java.util.Collections;
import java.util.List;

public class Actividad1 {
    

    public  boolean cambioExacto (List<Integer> monedas, int monto) {
        /*
            función Boolean encontrarMinimoMonedas(monedas, monto)
            ordenar monedas de menor a mayor

            Entero resto = monto;

            para i desde el índice más alto de monedas hasta el índice 0 (de mayor a menor)

                si resto < monedas[i] and resto > 0 
                    si resto = 0
                        devolver true
                    sino 
                        devolver false
                fin si 

            fin para
            fin función
         */
        
        Collections.sort(monedas);   

        return true;
    }

}
