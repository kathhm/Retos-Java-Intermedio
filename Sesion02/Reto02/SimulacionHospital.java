package Sesion02.Reto02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        RecursoMedico salaRayosX = new RecursoMedico("Equipo de Rayos X");

        
        ExecutorService executor = Executors.newFixedThreadPool(4); //creo 4 hilos concurrentes

        executor.execute(new ProfesionalMedico("Dr. Pérez", salaRayosX));
        executor.execute(new ProfesionalMedico("Dra. Gómez", salaRayosX));
        executor.execute(new ProfesionalMedico("Dr. López", salaRayosX));
        executor.execute(new ProfesionalMedico("Dra. Martínez", salaRayosX));
        executor.shutdown(); //cierro el executor para que no acepte más tareas





    }
}
