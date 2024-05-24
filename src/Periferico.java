public class Periferico extends Componente{
    private String tipo;


    public Periferico() {
    }

    public Periferico(int id, String nombre, double precio, String marca, String tipo) {
        super(id, nombre, precio, marca);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
