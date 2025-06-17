package Sesion02.Reto01;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String>{
    public String call() throws Exception {
        Thread.sleep(1000);
        return "💓 Soporte Vital: parámetros estables, todo en orden.";
    }

}
