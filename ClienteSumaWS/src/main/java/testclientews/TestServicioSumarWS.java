package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestServicioSumarWS {
    public static void main(String[] args) {
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("ejecutando servicio sumar ws");
        int x = 6;
        int y = 3;
        int resultado = servicioSumar.sumar(x, y);
        System.out.println("resultado:" + resultado);
        System.out.println("fin de servicio sumar ws");
    }
}
