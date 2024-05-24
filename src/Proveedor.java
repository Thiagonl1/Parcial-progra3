public class Proveedor extends Empresa implements Facturacion{
    private String nombreContacto;
    private String telefonoContacto;
    private Pedido[] pedidosTienda = new Pedido[10];


    public Proveedor() {
    }

    public Proveedor(String nombreContacto, String telefonoContacto, Pedido[] pedidosTienda) {
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.pedidosTienda = pedidosTienda;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Pedido[] getPedidosTienda() {
        return pedidosTienda;
    }

    public void setPedidosTienda(Pedido[] pedidosTienda) {
        this.pedidosTienda = pedidosTienda;
    }

    @Override
    public void emitirFactura(Transaccion transaccion){
        if(transaccion instanceof Compra){
            double total = 0;
             Articulo[] articulosTienda =((Compra) transaccion).getTienda().getInventario();
             Articulo[] articulosPedido = transaccion.getPedido().getArticulos();
             for(int j = 0 ; j < articulosPedido.length ; j++) {
                 for(int i = 0 ; i < articulosTienda.length ; i++){
                     if (articulosTienda[i] == null) {             // SOY incapaz de usar el agregar articulo aca, sin embargo hice el equivalente a usarlo.
                         articulosTienda[i] = articulosPedido[j];
                         total+=articulosPedido[j].getPrecio();
                     }
                 }
             }
             if(total < 100000){
                 total=(total*0.95);
             }else if(total >= 100000 && total < 600000){
                 total=(total*0.90);
             } else if(total >= 600000 && total <= 1200000){
                 total=(total*0.80);
             }else if(total > 1200000){
                 total=(total*0.70);
             }
             transaccion.setMontoTotal(total);
        }
    }

    public void despacharPedidos(Pedido[] pedidos){
        Transaccion transaccion = new Transaccion();
        for(int i = 0 ; i < pedidos.length ; i++){
            transaccion.setId(i);
            transaccion.setPedido(pedidos[i]);
            transaccion.setEstado("Agregado");
            emitirFactura(transaccion);
        }
    }

}
