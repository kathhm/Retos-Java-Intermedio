package Sesion04.Reto01;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    // Simula el cálculo de ruta con latencia aleatoria
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(" Calculando ruta...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4)); // 2-3 segundos
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular ruta");
            }
        });
    }

    // Simula la estimación de tarifa con latencia aleatoria
    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Estimando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3)); // 1-2 segundos
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar tarifa");
            }
        });
    }

    // 🔁 Procesa la solicitud combinando ambas tareas
    public void procesarSolicitud() {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture
            .thenCombine(tarifaFuture, (ruta, tarifa) ->
                "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa
            )
            .exceptionally(ex -> "❌ Error al procesar solicitud: " + ex.getMessage())
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        // Importante: permitir que los hilos completen antes de que el main termine
        try {
            TimeUnit.SECONDS.sleep(5); // Ajusta al máximo tiempo de latencia estimado
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}