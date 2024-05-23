//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // CREAMOS UN CLIENTE
        Cliente cliente = new Cliente("Thiago", "Luque", 43457401);



        // ARTICULOS EN GENERAL
        Articulo ar1 = new Articulo(24, "Mouse", 30);
        Articulo ar2 = new Articulo(1, "Teclado", 20);
        Articulo ar3 = new Articulo(44, "Auriculares", 90);
        Articulo ar4 = new Articulo(40, "Monitor", 4000);
        Articulo[] articulos = null;
        articulos[0] = ar1;
        articulos[1] = ar2;
        articulos[2] = ar3;

        // ARTICULO TIENDA/PROVEEDOR
        Articulo[] articulo = new Articulo[1];
        articulo[0] = ar4;

        //PEDIDOS
        Pedido pedido = new Pedido(40 ,articulos, 0, "28/03/203" );
        Pedido[] pedidoTienda = new Pedido[1];
        pedidoTienda[0] = pedido;

        // PROVEEDOR
        Proveedor proveedor = new Proveedor("Saracatunga", "2246152520", pedidoTienda);

        //TRANSACCION
        Transaccion transaccion = new Transaccion(40, , "", "1/2/2302", 0);


        Tienda tienda = new Tienda("Sucucho", "2893512412-1",articulos, pedido, transaccion);
    }
}