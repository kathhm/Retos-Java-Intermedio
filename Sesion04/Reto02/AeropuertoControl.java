package Sesion04.Reto02;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean disponible = ThreadLocalRandom.current().nextInt(100) < 80; // 80% de probabilidad
                System.out.println("🛣️ Pista disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar pista");
            }
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean favorable = ThreadLocalRandom.current().nextInt(100) < 85; // 85% de probabilidad
                System.out.println("🌦️ Clima favorable: " + favorable);
                return favorable;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar clima");
            }
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean despejado = ThreadLocalRandom.current().nextInt(100) < 90; // 90% de probabilidad
                System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
                return despejado;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar tráfico aéreo");
            }
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean disponible = ThreadLocalRandom.current().nextInt(100) < 95; // 95% de probabilidad
                System.out.println("👷‍♂️ Personal disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar personal de tierra");
            }
        });
    }

    public void procesarAterrizaje() {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture
            .allOf(pista, clima, trafico, personal)
            .thenApply(v -> pista.join() && clima.join() && trafico.join() && personal.join())
            .thenAccept(autorizado -> {
                if (autorizado) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            })
            .exceptionally(ex -> {
                System.out.println("\n❌ Error al procesar aterrizaje: " + ex.getMessage());
                return null;
            });
    }

}
