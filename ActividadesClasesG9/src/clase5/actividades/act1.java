package clase5.actividades;

import clase5.models.RedSocial;
import clase5.models.Usuario;

public class act1 {
    public static void main(String[] args) {
        System.out.println("Actividad 1");
        System.out.println();

        RedSocial redSocial = new RedSocial();

        Usuario usuario1 = new Usuario("Julian");
        Usuario usuario2 = new Usuario("Matias");
        Usuario usuario3 = new Usuario("Pedro");

        // Agregar usuarios
        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);

        redSocial.seguir(usuario1, usuario2);
        redSocial.seguir(usuario1, usuario3);

        redSocial.seguir(usuario2, usuario3);

        System.out.println("Julian sigue a: " + redSocial.listaDeSeguidos(usuario1));

        System.out.println("Matias es seguido por: " + redSocial.listaDeSeguidores(usuario3));

        redSocial.dejarDeSeguir(usuario1, usuario2);
        System.out.println("Julian sigue a: " + redSocial.listaDeSeguidos(usuario1));

    }
}