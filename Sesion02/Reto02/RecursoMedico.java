package Sesion02.Reto02;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private String nombre;

    private ReentrantLock lock = new ReentrantLock(); //creamos una instancia del candado Lock 

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    
     public void usar(String profesional){
        System.out.println("🔧 " + profesional + " está intentando usar el recurso médico: " + nombre);
        lock.lock(); //obtenemos la llave para entrar (el candado)
        // si otro hilo intenta acceder mientras la llave está ocupada, se queda esperando 

        try {
            System.out.println("🔧 " + profesional + " está usando el recurso médico: " + nombre);
            Thread.sleep(2000); // simula el uso del recurso 2 segundos
            System.out.println("🔧 " + profesional + " ha terminado de usar el recurso médico: " + nombre); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // si el hilo es interrumpido, se marca como interrumpido
            System.out.println("🔧 " + profesional + " ha sido interrumpido mientras usaba el recurso médico: " + nombre);
        }finally{
            lock.unlock(); // liberamos la llave para que otros hilos puedan acceder al recurso
            System.out.println("🔧 " + profesional + " ha liberado el recurso médico: " + nombre);
        }



    }



    

}
