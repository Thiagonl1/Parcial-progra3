public class Cliente implements Comprador{
    private String nombre;
    private String apellido;
    private int documento;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    @Override
    public void realizarPedido(Pedido pedido, Empresa empresa){
        if(empresa instanceof Tienda){
            Pedido[] pedidos = ((Tienda) empresa).getPedidosCliente();
            for(int i = 0 ; i < pedidos.length ; i++){
                if(pedidos[i] == null){
                    pedidos[i] = pedido;
                    ((Tienda) empresa).setPedidosCliente(pedidos);
                    break;
                }
            }
        }
    }
}
