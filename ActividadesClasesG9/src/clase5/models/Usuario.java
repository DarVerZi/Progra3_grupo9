package clase5.models;

import java.util.*;

public class Usuario {
    private String id;

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    // Sobrescribir equals y hashCode para poder usar Usuario como clave en un HashMap
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}