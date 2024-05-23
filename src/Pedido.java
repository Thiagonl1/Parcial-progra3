public class Pedido {
    private int id;
    private Articulo[] articulos = new Articulo[10];
    private double cotizacionTotal;
    private String fechaCotizacion;




    public Pedido(int id, Articulo[] articulos, double cotizacionTotal, String fechaCotizacion) {
        this.id = id;
        this.articulos = articulos;
        this.cotizacionTotal = cotizacionTotal;
        this.fechaCotizacion = fechaCotizacion;
    }

    public Pedido() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }

    public double getCotizacionTotal() {
        return cotizacionTotal;
    }

    public void setCotizacionTotal(double cotizacionTotal) {
        this.cotizacionTotal = cotizacionTotal;
    }

    public String getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(String fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public void actualizarCotizacion(){

    }
}
