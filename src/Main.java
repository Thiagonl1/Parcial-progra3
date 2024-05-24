import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor(-1, -1, "Saraca", "Tunga", 43434341);

        Usuario[] usuarios = new Usuario[1];
        // Recursos
        Ambulancia ambu = new Ambulancia();
        Bombero bomb = new Bombero();
        Policia poli = new Policia();
        ambu.setTiempoRespuestaMinutos(60);
        bomb.setTiempoRespuestaMinutos(90);
        poli.setTiempoRespuestaMinutos(30);

        Recurso[] recursos = new Recurso[3];
        recursos[0]=ambu;
        recursos[1]=bomb;
        recursos[2]=poli;

        // Usuario
        Usuario user = new Usuario("Si", recursos, -1, "Thiago", "Luque", 434343433);
        usuarios[0] = user;

        // b. Calcular el precio del recurso según su tipo y tiempo de respuesta.
        for(Usuario u : usuarios){
            System.out.println(u.getNombre() + u.getApellido());
            for(Recurso r : u.getRecurso()){
                u.factura(r, u);
                System.out.println(r.getFacturacion());
            }
        }
        // c. Calcular la factura del usuario según la facturación de sus emergencias.

        for(Usuario u : usuarios){
            System.out.println(u.getNombre() + u.getApellido());
            double total1 = 0;
            for(Recurso r : u.getRecurso()){
                total1 += r.getFacturacion();
            }
            u.setFacturaUsuario(total1);
            System.out.println(total1);
        }

        // d. Supervisar las emergencias mensuales y tiempos excesivos.
        double sara = supervisor.calculaCostoTotalMensual(usuarios);
        int catunga = supervisor.tiemposAltos(usuarios);
        System.out.println("Costo total mensual "+sara);
        System.out.println("Tiempo total de los salames altos "+catunga);

        /* e. Mostrar un detalle de cada una de las emergencias realizadas para un determinado
        usuario (polimórficamente). */

        for(Usuario u : usuarios){
            System.out.println(u.getNombre()+" "+ u.getApellido());
            for(Recurso r : recursos){
                System.out.println("Llamaste a");
                if(r instanceof Ambulancia){
                    System.out.println("Ambulancia y pagaste "+ r.getFacturacion()+"Con "+ ((Ambulancia) r).getTiempoRespuestaMinutos()+" Tiempo de respuesta");
                } else if (r instanceof  Bombero){
                    System.out.println("Bombero y pagaste "+ r.getFacturacion()+"Con "+ ((Bombero) r).getTiempoRespuestaMinutos()+" Tiempo de respuesta");
                } else if (r instanceof  Policia){
                    System.out.println("Policia y pagaste "+ r.getFacturacion()+"Con "+ ((Policia) r).getTiempoRespuestaMinutos()+" Tiempo de respuesta");
                }
            }
        }

    }
}
