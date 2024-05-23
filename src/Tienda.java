 public class Tienda extends Empresa implements Facturacion{
    private int sucursal;
    private Articulo[] inventario = new Articulo[10];
    private Pedido[] pedidosCliente = new Pedido[10];
    private Transaccion[] transaccion = new Transaccion[10];

     public Tienda() {
     }

     public Tienda(String nombre, String cuit, int sucursal, Articulo[] inventario, Pedido[] pedidosCliente, Transaccion[] transaccion) {
         super(nombre, cuit);
         this.sucursal = sucursal;
         this.inventario = inventario;
         this.pedidosCliente = pedidosCliente;
         this.transaccion = transaccion;
     }

     public int getSucursal() {
         return sucursal;
     }

     public void setSucursal(int sucursal) {
         this.sucursal = sucursal;
     }

     public Articulo[] getInventario() {
         return inventario;
     }

     public void setInventario(Articulo[] inventario) {
         this.inventario = inventario;
     }

     public Pedido[] getPedidosCliente() {
         return pedidosCliente;
     }

     public void setPedidosCliente(Pedido[] pedidosCliente) {
         this.pedidosCliente = pedidosCliente;
     }

     public Transaccion[] getTransaccion() {
         return transaccion;
     }

     public void setTransaccion(Transaccion[] transaccion) {
         this.transaccion = transaccion;
     }

     @Override
    public void emitirFactura(Transaccion transaccion){

    }

    //METODOS A PARTE


    public void agregarArticulo(Articulo articulo){

    }

    public void eliminarArticulo(Articulo articulo){

    }

    public Articulo buscarArticulo(String nombre){

        return null;
    }


}
