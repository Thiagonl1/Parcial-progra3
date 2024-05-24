public class Computadora extends Componente{
    private String especificaciones;

    public Computadora() {
    }

    public Computadora(int id, String nombre, double precio, String marca, String especificaciones) {
        super(id, nombre, precio, marca);
        this.especificaciones = especificaciones;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }
}
