package Sesion02.Reto01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> nav = executor.submit(new SistemaNavegacion());
        Future<String> com = executor.submit(new SistemaComunicaciones());
        Future<String> controlTermico = executor.submit(new SistemaControlTermico());
        Future<String> soporteVital = executor.submit(new SistemaSoporteVital());

        //obteniendo los resultados de las tareas con get
        System.out.println(nav.get());
        System.out.println(com.get());
        System.out.println(controlTermico.get());
        System.out.println(soporteVital.get());
        //cerrando el executor  
        executor.shutdown();



    }
}
