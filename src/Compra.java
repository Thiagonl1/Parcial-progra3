public class Compra extends Transaccion{
    private Tienda tienda;
    private Proveedor proveedor;

    public Compra(int id, Pedido pedido, String estado, String fechaPago, double montoTotal) {
        super(id, pedido, estado, fechaPago, montoTotal);
    }

    public Compra(int id, Pedido pedido, String estado, String fechaPago, double montoTotal, Tienda tienda, Proveedor proveedor) {
        super(id, pedido, estado, fechaPago, montoTotal);
        this.tienda = tienda;
        this.proveedor = proveedor;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
