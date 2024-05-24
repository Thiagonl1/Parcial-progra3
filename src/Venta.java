public class Venta extends Transaccion{
    private Tienda tienda = new Tienda();
    private Cliente cliente = new Cliente();

    public Venta(){
    }

    public Venta(int id, Pedido pedido, String estado, String fechaPago, double montoTotal, Tienda tienda, Cliente cliente) {
        super(id, pedido, estado, fechaPago, montoTotal);
        this.tienda = tienda;
        this.cliente = cliente;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
