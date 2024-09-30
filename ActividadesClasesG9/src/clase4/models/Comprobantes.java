package clase4.models;

public class Comprobantes {
    String tipo;
    int valor;
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Comprobantes [tipo=" + tipo + ", valor=" + valor + "]";
    }
    public Comprobantes(String tipo, int valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}
