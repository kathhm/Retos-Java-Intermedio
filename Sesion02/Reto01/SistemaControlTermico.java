package Sesion02.Reto01;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String>{
    public String call() throws Exception {
        Thread.sleep(1000);
        return "🌡️ Control Térmico: temperatura dentro de los parámetros normales.";
    }

}
