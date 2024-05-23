public class Proveedor extends Empresa implements Facturacion{
    private String nombreContacto;
    private String telefonoContacto;
    private Pedido pedidosTienda[] = new Pedido[10];


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
    public void emitirFactura(Transaccion transaccion) {

    }
}
