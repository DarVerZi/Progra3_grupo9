package clase1.test;
import java.util.ArrayList;
import java.util.List;

import clase1.actividades.Actividades1_A;
import clase1.actividades.Actividades1_B;
import clase1.actividades.Actividades2;
import clase1.actividades.Actividades3;
import clase1.models.Cliente;
import clase1.models.Factura;

import java.math.BigInteger;

public class TestApp {
    public static void main(String[] args) throws Exception {
        
    /*Actividad 1 A */  
    List<Integer> listaNumeros = new ArrayList<>();      
    listaNumeros.add(12);
    listaNumeros.add(32);
    listaNumeros.add(44);
    listaNumeros.add(65);
    listaNumeros.add(18);
    listaNumeros.add(23);
    Actividades1_A act1_A = new Actividades1_A();
    System.out.println(act1_A.buscarMaximo(listaNumeros));
    

    /*Actividad 1 B */    
    Cliente cliente1 = new Cliente(1, "cliente1");
    Cliente cliente2 = new Cliente(2, "cliente2");
    Cliente cliente3 = new Cliente(3, "cliente3");
    Cliente cliente4 = new Cliente(4, "cliente4");
    List<Cliente> listaClientes = new ArrayList<>();
    listaClientes.add(cliente1);
    listaClientes.add(cliente2);
    listaClientes.add(cliente3);
    listaClientes.add(cliente4);

    Factura factura1 = new Factura(1, 1, 2000);
    Factura factura2 = new Factura(2, 1, 2000);
    Factura factura3 = new Factura(3, 1, 2000);
    Factura factura4 = new Factura(4, 2, 5000);
    List<Factura> listaFacturas = new ArrayList<>();
    listaFacturas.add(factura1);
    listaFacturas.add(factura2);
    listaFacturas.add(factura3);
    listaFacturas.add(factura4);

    Actividades1_B actividades1_B = new Actividades1_B();
    List<Factura> listaFacturas1 = new ArrayList<>();
    listaFacturas1 = actividades1_B.buscarFacturasClientesSinMap(listaFacturas,listaClientes);
    
        
    listaFacturas1 = actividades1_B.buscarFacturasClientesConMap(listaFacturas, listaClientes);

    /*Actividad 2 */  
    Actividades2 act2 = new Actividades2();
    long number = 5;
    long result = act2.factorialLong(number);
    System.out.println("El factorial de " + number + " es " + result);    

    BigInteger number2 = new BigInteger("5");
    BigInteger result2 = act2.factorialBigInteger(number2);
    System.out.println("El factorial de " + number2 + " es " + result2);    


    /*Actividad 3 */
    Actividades3 act3 = new Actividades3();
    System.out.println(act3.sumaPrimerosXNumeros(12,0));
    }
}
