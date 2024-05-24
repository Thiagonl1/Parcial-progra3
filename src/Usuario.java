public class Usuario extends Persona{
    private String obraSocial;
    private Recurso[] recurso = new Recurso[10];
    private double facturaUsuario;

    public Usuario(String obraSocial, Recurso[] recurso, double facturaUsuario, String nombre, String apellido, long dni) {
        super(nombre, apellido, dni);
        this.obraSocial = obraSocial;
        this.recurso = recurso;
        this.facturaUsuario = facturaUsuario;

    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Recurso[] getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso[] recurso) {
        this.recurso = recurso;
    }

    public double getFacturaUsuario() {
        return facturaUsuario;
    }

    public void setFacturaUsuario(double facturaUsuario) {
        this.facturaUsuario = facturaUsuario;
    }


    public void factura(Recurso recurso, Usuario usuario){
        if(recurso instanceof Ambulancia) {
            if (usuario.getObraSocial() == "No") {
                ((Ambulancia) recurso).setFacturacion(((Ambulancia) recurso).getFacturacion() + 1000);
            }
        }
    }
}
