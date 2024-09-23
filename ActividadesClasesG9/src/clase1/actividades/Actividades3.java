package clase1.actividades;

public class Actividades3 {

    /*Sumar los primeros n números enteros, implementando en java un algoritmo que 
    use recursión.
    Realice el análisis de recurrencia */

    public double sumaPrimerosXNumeros (Integer cant, double salida) {

        if (cant == 0) {
            return salida;

        } 
        else if (cant == 1) {
            return 1;
        }   
        else {
            return sumaPrimerosXNumeros(cant-1,salida+cant);
        }
    }

}
