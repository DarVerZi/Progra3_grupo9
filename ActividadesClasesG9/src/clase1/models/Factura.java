package clase1.models;

public class Factura {

    int idFactura;
    int idCliente;
    float monto;
 
    public Factura(int idFactura, int idCliente, float monto) {
         this.idFactura = idFactura;
         this.idCliente = idCliente;
         this.monto = monto;
     }
 
     //Get and set
     public int getIdFactura() {
         return idFactura;
     }
     public void setIdFactura(int idFactura) {
         this.idFactura = idFactura;
     }
     public int getIdCliente() {
         return idCliente;
     }
     public void setIdCliente(int idCliente) {
         this.idCliente = idCliente;
     }
     public float getMonto() {
         return monto;
     }
     public void setMonto(float monto) {
         this.monto = monto;
     }
     
     @Override
     public String toString() {
         return "Factura [idFactura=" + idFactura + ", idCliente=" + idCliente + ", monto=" + monto + "]";
     }
 
}
