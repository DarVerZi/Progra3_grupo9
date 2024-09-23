package clase3.models;

public class Cliente {
    int id_cliente;
    String nombre;
    int scoring;

    

    public Cliente(int id_cliente, String nombre, int scoring) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getScoring() {
        return scoring;
    }
    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", nombre=" + nombre + ", scoring=" + scoring + "]";
    }

}
