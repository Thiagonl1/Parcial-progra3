
public class Main {
    public static void main(String[] args) {
        // CREAMOS UN CLIENTE
        Cliente cliente = new Cliente("Thiago", "Luque", 43457401);

        // ARTICULOS EN LA TIENDA
        Articulo ar1 = new Articulo(24, "Mouse", 30);
        Articulo ar2 = new Articulo(1, "Teclado", 20);
        Articulo ar3 = new Articulo(44, "Auriculares", 90);
        Articulo ar4 = new Articulo(40, "Monitor", 4000);
        Articulo[] articulos = new Articulo[7];
        articulos[0] = ar1;
        articulos[1] = ar2;
        articulos[2] = ar3;
        articulos[3] = ar4;

        // ARTICULO QUE EL CLIENTE AGARRA DE LA TIENDA
        Articulo[] articuloCliente = new Articulo[2];
        articuloCliente[0] = ar4;
        articuloCliente[1] = ar2;

        //PEDIDO DE TIENDA A PROOVEDOR
        Pedido pedido = new Pedido(40 ,articulos, 0, "28/03/203" );
        Pedido[] pedidoTienda = new Pedido[1];
        pedidoTienda[0] = pedido;

        //PEDIDOS CLIENTE A TIENDA
        Pedido[] pedidoCliente = new Pedido[1];
        Pedido p1 = new Pedido(1, articuloCliente, 0, "31/02/13");
        pedidoCliente[0] = p1;
        p1.actualizarCotizacion();

        // PROVEEDOR
        Proveedor proveedor = new Proveedor("Saracatunga", "2246152520", pedidoTienda);

        //TRANSACCIONES
        Transaccion t1 = new Transaccion(40, pedido, "", "28/03/13", 0);

        //VECTOR TRANSACCION
        Transaccion[] transacciones = new Transaccion[1];
        transacciones[0] = t1;

        //CREAMOS TIENDA
        Tienda tienda = new Tienda("Sucucho", "2893512412-1", 3, articulos, pedidoCliente, transacciones);

        //VENTA
        Venta v1 = new Venta(1, p1, "", "31/3/23", p1.getCotizacionTotal(), tienda, cliente);



        System.out.println("NOMBRE DE TIENDA: "+ tienda.getNombre());
        System.out.println("CUIT: "+ tienda.getCuit());
        System.out.println("SUCURSAL NUMERO: "+ tienda.getSucursal());
        System.out.println("PEDIDOS ACTUALES DE CLIENTES");
        for(int i = 0 ; i < pedidoCliente.length ; i++){
            Transaccion transaccion = new Transaccion(i, pedidoCliente[i], "", "1/2/12", 0);
            Pedido aux = transaccion.getPedido();
            tienda.despacharPedidos(pedidoCliente);
            transaccion.setPedido(pedidoCliente[i]);
            System.out.println("--------------------------------");
            System.out.println("ID: "+ transaccion.getId());
            System.out.println("ESTADO: "+ transaccion.getEstado());
            System.out.println("ARTICULOS");
            System.out.println("---------------------------------");
            if (aux != null) {
                Articulo[] auxArt = aux.getArticulos();
                for(int j = 0 ; j < auxArt.length ; j++ ){
                    System.out.println("Nombre del articulo: "+ auxArt[j].getNombre());
                    System.out.println("Precio: "+ auxArt[j].getPrecio());
                }
                System.out.println("Precio total: "+ transaccion.getMontoTotal());
            } else {
                System.out.println("El pedido es nulo");
            }
            System.out.println("----------------------------");
            System.out.println("Inventario de la tienda (en stock actual)");
            Articulo[] inventario = tienda.getInventario();
            for (Articulo a : inventario){
                if(a!=null){
                    System.out.println("Nombre de articulo: "+ a.getNombre());
                }
            }
        }
    }
}