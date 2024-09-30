package clase6.models;

import java.util.List;

public class Resultado {
    public int beneficioMaximo;
    public List<Integer> proyectosSeleccionados;

    public Resultado(int beneficioMaximo, List<Integer> proyectosSeleccionados) {
        this.beneficioMaximo = beneficioMaximo;
        this.proyectosSeleccionados = proyectosSeleccionados;
    }
}