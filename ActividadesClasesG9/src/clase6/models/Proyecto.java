package clase6.models;

public class Proyecto {
    public int indice;
    public int costo;
    public int beneficio;
    public double relacionBeneficioCosto;

    public Proyecto(int indice, int costo, int beneficio, double relacionBeneficioCosto) {
        this.indice = indice;
        this.costo = costo;
        this.beneficio = beneficio;
        this.relacionBeneficioCosto = relacionBeneficioCosto;
    }
}
