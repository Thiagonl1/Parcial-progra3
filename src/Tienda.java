 public class Tienda extends Empresa implements Facturacion, Comprador{
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


    //METODOS A PARTE

    public void agregarArticulo(Articulo articulo){
         for(int i = 0 ; i < this.inventario.length ; i++){
             if(this.inventario[i] == null){
                 this.inventario[i] = articulo;
                 break;
             }
         }
    }

    public void eliminarArticulo(Articulo articulo){
         for(int i = 0 ; i < this.inventario.length ; i++){
             if(articulo.equals(this.inventario[i])){
                 this.inventario[i] = null;
                 break;
             }
         }
    }

    /*   Profe, aca en emitir factura tengo un problema que no me toma el monto total, la unica
    * solucion que veo es que emitir factura, en vez de un void sea un tipo Transaccion. Pero como la vision que tengo
    * de hacer el parcial es ser lo maximo fiel posible al UML no voy a implementar eso. */

    @Override
     public void emitirFactura(Transaccion transaccion){
         if(transaccion instanceof Venta){
             Pedido aux = transaccion.getPedido();
             aux.actualizarCotizacion();
             Articulo[] articuloCliente = transaccion.getPedido().getArticulos();
             for(int j = 0 ; j < articuloCliente.length ; j++){
                 eliminarArticulo(articuloCliente[j]);
             }
             transaccion.setPedido(aux);
             transaccion.setMontoTotal(aux.getCotizacionTotal());
         }
    }

     @Override
     public void realizarPedido(Pedido pedido, Empresa empresa) {
         if(empresa instanceof Proveedor){
             Pedido[] pedidos = ((Proveedor) empresa).getPedidosTienda();
             for(int i = 0 ; i < pedidos.length ; i++){
                 if(pedidos[i] == null){
                     pedidos[i] = pedido;
                     ((Proveedor) empresa).setPedidosTienda(pedidos);
                     despacharPedidos(pedidos);
                     break;
                 }
             }
         }
     }


     public void despacharPedidos(Pedido[] pedidos){
         Pedido[] pedidosTienda = this.pedidosCliente;
         for(int i = 0 ; i < pedidosTienda.length ; i++){
             for(int j = 0 ; j < pedidos.length ; j++)
                 if(pedidosTienda[i] == pedidos[j]){
                     Transaccion aux = new Transaccion(i, pedidos[j], "Aprobado", "31/3/33", 0);
                     emitirFactura(aux);
                     // Actualizar el inventario de la tienda eliminando los artículos vendidos
                     Articulo[] articulosVendidos = pedidos[j].getArticulos();
                     for(Articulo articulo : articulosVendidos) {
                         eliminarArticulo(articulo);
                     }
                     break;
                 } else if(i == pedidosTienda.length-1){
                     System.out.println("Cancelado");
                 }
         }
     }
 }