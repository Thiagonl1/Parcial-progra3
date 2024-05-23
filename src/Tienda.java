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

    }

    public void eliminarArticulo(Articulo articulo){

    }
    @Override
     public void emitirFactura(Transaccion transaccion){
         if(transaccion instanceof Venta){
             double total = 0;
             Articulo[] articulosTienda =((Venta) transaccion).getTienda().getInventario();
             Articulo[] articulosPedido = transaccion.getPedido().getArticulos();
             for(int j = 0 ; j < articulosPedido.length ; j++) {
                 for(int i = 0 ; i < articulosTienda.length ; i++){
                     if (articulosTienda[i] == articulosPedido[j]) {
                         articulosTienda[i] = null;
                         total+=articulosPedido[j].getPrecio();
                     }
                 }
             }
             transaccion.setMontoTotal(total);
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
                 System.out.println("Entregado");
                 break;
             }else if( i == pedidosTienda.length ){
                 System.out.println("Cancelado");
             }
         }
     }
 }
