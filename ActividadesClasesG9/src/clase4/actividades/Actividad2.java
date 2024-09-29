package clase4.actividades;

import clase4.algoritmos.MergeSortComprobantes;
import clase4.models.Comprobantes;
import java.util.ArrayList;

public class Actividad2 {

        /*
            Descripción del Problema:
            Un sistema de tesorería tiene a disposición una variedad de comprobantes que 
            incluyen monedas, cheques, bonos y otros documentos financieros. Cada 
            comprobante tiene un valor específico. El objetivo es realizar una compra de 
            moneda extranjera minimizando el número de comprobantes utilizados.
            Resolver mediante pseudocódigo e implementación java.
            Indicar la complejidad algorítmica
        */    
        public static void main(String[] args) {
            ArrayList<Comprobantes> resultado  = new ArrayList<>();
            ArrayList<Comprobantes> comprobantes = new ArrayList<>();
            Comprobantes comp1 = new Comprobantes("Cheque", 100);
            Comprobantes comp2 = new Comprobantes("Moneda", 50);
            Comprobantes comp3 = new Comprobantes("Cheque", 90);
            Comprobantes comp4 = new Comprobantes("Moneda", 500);
            comprobantes.add(comp1);
            comprobantes.add(comp2);
            comprobantes.add(comp3);
            comprobantes.add(comp4);
            int monto = 7000;

            resultado = obtenerComprobantes(comprobantes,monto);

            for (Comprobantes aux : resultado) {
                aux.toString();
            }
  
        }

        public static ArrayList<Comprobantes> obtenerComprobantes(ArrayList<Comprobantes> comprobantes, int monto) {
            ArrayList<Comprobantes> resultado = new ArrayList<>();
            MergeSortComprobantes.mergeSort(comprobantes);  
            
            for (Comprobantes comprobante : comprobantes) {
                if (monto <= 0) break;
                if (comprobante.getValor() <= monto) {
                    resultado.add(comprobante);
                    monto -= comprobante.getValor();
                }
            }
    
            return monto == 0 ? resultado : new ArrayList<>(); // Devolver lista vacía si no se puede cubrir el monto
        }

}
