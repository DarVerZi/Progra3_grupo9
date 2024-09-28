package clase4.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.String;

public class Objeto {
    public String nombre;
    public double valor;
    public double peso;

    public Objeto(String nombre, double valor, double peso) {
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;
    }

    public double calcularRelacionPeso() {
        return valor / peso;
    }

    public static List<Objeto> ordenarPorValorPeso(List<Objeto> objetos) {
        Collections.sort(objetos, new Comparator<Objeto>() {
            @Override
            public int compare(Objeto o1, Objeto o2) {
                return Double.compare(o2.calcularRelacionPeso(), o1.calcularRelacionPeso());
            }
        });
        return objetos;
    }

    public static List<Objeto> cargarCamion(List<Objeto> listaValores, double capacidadCamion) {
        List<Objeto> objetosCargados = new ArrayList<>();
        double pesoDelCamionDisponible = capacidadCamion;

        for (Objeto objeto : listaValores) {
            if (objeto.peso <= pesoDelCamionDisponible) {
                objetosCargados.add(objeto);
                pesoDelCamionDisponible = pesoDelCamionDisponible - objeto.peso;
            } else {
                if(pesoDelCamionDisponible != 0){
                    double fraccionar = pesoDelCamionDisponible / objeto.peso;
                    Objeto fraccionado = new Objeto("ObjetoFraccionado",objeto.valor * fraccionar, pesoDelCamionDisponible);
                    objetosCargados.add(fraccionado);
                }
                break;
            }

        }
        return objetosCargados;
    }
}