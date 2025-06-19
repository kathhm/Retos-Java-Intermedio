package Sesion05.Reto01;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.util.concurrent.ThreadLocalRandom;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeControl {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> flujoTrafico = Flux.interval(Duration.ofMillis(500))
            .map(i -> ThreadLocalRandom.current().nextInt(0,101))
            .onBackpressureBuffer(50)
            .filter(val -> val > 70)
            .map(val -> "🚗 Alerta: Congestión del " + val + "% en Avenida Solar");

        Flux<String> flujoContaminacion = Flux.interval(Duration.ofMillis(600))
            .map(i -> ThreadLocalRandom.current().nextInt(0,120))
            .filter(val -> val > 50)
            .map(val -> "🌫️ Alerta: Contaminación alta (PM2.5: " + val + " ug/m3)");

        Flux<String> flujoAccidentes = Flux.interval(Duration.ofMillis(800))
            .map(i -> {
                String[] prioridades = {"Baja","Media","Alta"};
                return prioridades[ThreadLocalRandom.current().nextInt(0,3)];
            })
            .filter(prio -> prio.equals("Alta"))
            .map(prio -> "🚑 Emergencia vial: Accidente con prioridad " + prio);

        Flux<String> flujoTrenes = Flux.interval(Duration.ofMillis(700))
            .map(i -> ThreadLocalRandom.current().nextInt(0,11))
            .filter(val -> val > 5)
            .map(val -> "🚝 Tren maglev con retraso crítico: " + val + " minutos");

        Flux<String> flujoSemaforos = Flux.interval(Duration.ofMillis(400))
            .map(i -> {
                String[] estados = {"Verde","Amarillo","Rojo"};
                return estados[ThreadLocalRandom.current().nextInt(0,3)];
            })
            .buffer(3,1)
            .filter(seq -> seq.stream().allMatch(val -> val.equals("Rojo")))
            .map(seq -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce");

        Flux<String> flujoEventos = Flux.merge(
            flujoTrafico, flujoContaminacion, flujoAccidentes, flujoTrenes, flujoSemaforos
        );

        AtomicInteger contadorGlobal = new AtomicInteger(0);

        flujoEventos
            .publishOn(Schedulers.parallel())
            .doOnNext(evt -> {
                System.out.println(evt);
                contadorGlobal.incrementAndGet();
            })
            .window(Duration.ofSeconds(1))
            .flatMap(window -> window.count()
                .filter(c -> c >= 3)
                .doOnNext(c -> System.out.println("\n🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime\n"))
            )
            .subscribe();

        Thread.sleep(20000);
    }
}
