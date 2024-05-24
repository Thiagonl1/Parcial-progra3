public class Supervisor extends Persona{
    private double facturacionTotal;
    private int resultadoAuditoriaTiempos;

    public Supervisor(double facturacionTotal, int resultadoAuditoriaTiempos, String nombre, String apellido, long dni){
        super(nombre,apellido,dni);
        this.facturacionTotal = facturacionTotal;
        this.resultadoAuditoriaTiempos = resultadoAuditoriaTiempos;
    }

    public double getFacturacionTotal() {
        return facturacionTotal;
    }

    public void setFacturacionTotal(double facturacionTotal) {
        this.facturacionTotal = facturacionTotal;
    }

    public int getResultadoAuditoriaTiempos() {
        return resultadoAuditoriaTiempos;
    }

    public void setResultadoAuditoriaTiempos(int resultadoAuditoriaTiempos) {
        this.resultadoAuditoriaTiempos = resultadoAuditoriaTiempos;
    }

    public double calculaCostoTotalMensual(Usuario[] usuario){
        double total =0;
        for(Usuario u : usuario){
            for(Recurso r : u.getRecurso()){
                if(r instanceof Ambulancia){
                    total += ((Ambulancia) r).getFacturacion();
                }else if(r instanceof Bombero){
                    total += ((Bombero) r).getFacturacion();
                }else if(r instanceof Policia){
                    total += ((Policia) r).getFacturacion();
                }
            }
        }
        return total;
    }

    public int tiemposAltos(Usuario[] usuarios){
        int total=0;
        for(Usuario u : usuarios){
            for(Recurso r : u.getRecurso()){
                if(r instanceof Ambulancia){
                    if(((Ambulancia) r).getTiempoRespuestaMinutos() > 50){
                        total += ((Ambulancia) r).getTiempoRespuestaMinutos();
                    }
                }else if(r instanceof Bombero){
                    if(((Bombero) r).getTiempoRespuestaMinutos() > 50){
                        total += ((Bombero) r).getTiempoRespuestaMinutos();
                    }
                }else if(r instanceof Policia){
                    if(((Policia) r).getTiempoRespuestaMinutos() > 50){
                        total += ((Policia) r).getTiempoRespuestaMinutos();
                    }
                }
            }
        }
        return total;
    }
}
