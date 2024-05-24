public class Policia implements Recurso{
    private double facturacion = 500;
    private int tiempoRespuestaMinutos;

    public Policia(){
    }


    public Policia(double facturacion, int tiempoRespuestaMinutos) {
        this.facturacion = facturacion;
        this.tiempoRespuestaMinutos = tiempoRespuestaMinutos;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }

    public int getTiempoRespuestaMinutos() {
        return tiempoRespuestaMinutos;
    }

    public void setTiempoRespuestaMinutos(int tiempoRespuestaMinutos) {
        this.tiempoRespuestaMinutos = tiempoRespuestaMinutos;
    }
    @Override
    public double calculaCosto(){
        int tiempoRespuestaMinutos = getTiempoRespuestaMinutos();
        if(tiempoRespuestaMinutos>50){
            facturacion=facturacion/2;
        }
        return facturacion;
    }
}
