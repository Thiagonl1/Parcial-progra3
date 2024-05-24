public class Transaccion {
    private int id;
    private Pedido pedido = new Pedido();
    private String estado;
    private String fechaPago;
    private double montoTotal;

    public Transaccion() {
    }

    public Transaccion(int id, Pedido pedido, String estado, String fechaPago, double montoTotal) {
        this.id = id;
        this.pedido = pedido;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.montoTotal = montoTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
