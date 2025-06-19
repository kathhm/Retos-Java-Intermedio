package Sesion04.Reto02;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        control.procesarAterrizaje();

        // Esperar suficiente para que todas las tareas terminen
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
