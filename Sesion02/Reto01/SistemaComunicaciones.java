package Sesion02.Reto01;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    public String call() throws Exception{
        Thread.sleep(1000);
        return "📡 Comunicaciones: enlace estable, transmisión de datos en curso.";
    }

}
