package clase1.actividades;

import java.util.ArrayList;
import java.util.List;

import clase1.models.Cliente;
import clase1.models.Factura;

public class Actividades1_B {
                /* b. Un sistema de facturación, recibe una lista de comprobantes facturas 
            electrónicas, con id de factura, id de cliente, e importe y una lista de clientes, 
            con id cliente, y nombre de cliente, realizar un código de java, que genere 
            otra lista, con id cliente, suma importes de las facturas.
            Realizar la implementación en java, sin Maps y luego con Maps, ¿ cuál es la 
            diferencia en cuanto a la complejidad asintótica ? */


    public List <Factura> buscarFacturasClientesSinMap( List<Factura> facturas , List<Cliente> clientes ) {
        List <Factura> salida = new ArrayList<>();

        for (Cliente cliente : clientes) {
            float monto = 0;
            for (Factura factura : facturas) {
                if (cliente.getIdCliente() == factura.getIdCliente()) {
                    monto = monto + factura.getMonto() ;
                }
                salida.add(new Factura(0, cliente.getIdCliente(), monto));
            }
        }
        return salida;
    }

    public List <Factura> buscarFacturasClientesConMap(List<Factura> facturas, List<Cliente> clientes) {
        List <Factura> salida = new ArrayList<>();

        for (Cliente cliente : clientes) {
            float monto = 0;
            for (Factura factura : facturas) {
                if (cliente.getIdCliente() == factura.getIdCliente()) {
                    monto = monto + factura.getMonto() ;
                }
                salida.add(new Factura(0, cliente.getIdCliente(), monto));
            }
        }
        return salida;
    }

}
