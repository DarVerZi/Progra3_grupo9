package clase4.actividades;

import clase4.models.Objeto;

import java.util.*;

public class Actividad3 {
    public static void main(String[] args) {
        List<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto("Objeto1", 60, 10));
        objetos.add(new Objeto("Objeto2", 100, 20));
        objetos.add(new Objeto("Objeto3", 120, 30));

        double capacidadCamion = 11;

        List<Objeto> listaValores = Objeto.ordenarPorValorPeso(objetos);
        List<Objeto> resultado = Objeto.cargarCamion(listaValores, capacidadCamion);

        System.out.println("Objetos cargados:");
        for (Objeto objeto : resultado) {
            System.out.println(objeto.nombre + " Valor: " + objeto.valor + ", Peso: " + objeto.peso);
        }
    }
}
