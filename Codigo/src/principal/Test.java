package principal;

import java.util.Calendar;
import java.util.GregorianCalendar;

import controladores.EnvioCorreo;
import datos.Localizacion;
import datos.Magnitud;
import datos.Sismo;
import datos.TOrigen;
import datos.TProvincia;

public class Test {
    public static void main(String[] args) {
        Calendar fechaHora = new GregorianCalendar();
        Localizacion localizacion = new Localizacion(9.1643, -84.161, "El Roble", TProvincia.PUNTARENAS);
        Magnitud magnitud = new Magnitud(4.4);
        Sismo sismo = new Sismo(20, fechaHora, 27.0, TOrigen.DEFORMACION_INTERNA, magnitud, localizacion);

        System.out.println(sismo);
        EnvioCorreo.enviar("Deyan Sanabria Fallas", "DeanYT0417@gmail.com", sismo);
    }
}
