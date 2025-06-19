package Sesion05.Reto02;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class UCIMonitor {

    public static void main(String[] args) throws InterruptedException {
        // Generar flujo por paciente
        Flux<String> paciente1 = generarSignosVitales(1);
        Flux<String> paciente2 = generarSignosVitales(2);
        Flux<String> paciente3 = generarSignosVitales(3);

        // Combina todos los pacientes y aplica filtrado + backpressure
        Flux<String> flujoUnificado = Flux.merge(paciente1, paciente2, paciente3)
            .delayElements(Duration.ofSeconds(1)) // Procesamiento más lento (simula personal médico)
            .filter(msg -> !msg.isEmpty()); // Solo muestra alertas

        flujoUnificado.subscribe(System.out::println);

        Thread.sleep(30000); // Ejecutar por 30 segundos
    }

    private static Flux<String> generarSignosVitales(int pacienteId) {
        return Flux.interval(Duration.ofMillis(300)) // Datos cada 300ms
            .onBackpressureDrop() // Controla el exceso de datos para evitar errores
            .map(i -> {
                int fc = ThreadLocalRandom.current().nextInt(40, 130); // FC
                int pas = ThreadLocalRandom.current().nextInt(80, 160); // Presión sistólica
                int pad = ThreadLocalRandom.current().nextInt(50, 100); // Presión diastólica
                int spo2 = ThreadLocalRandom.current().nextInt(85, 100); // SpO2

                StringBuilder alerta = new StringBuilder();

                if (fc < 50 || fc > 120)
                    alerta.append("⚠️ Paciente ").append(pacienteId).append(" - FC crítica: ").append(fc).append(" bpm\n");
                if (pas < 90 || pad < 60 || pas > 140 || pad > 90)
                    alerta.append("⚠️ Paciente ").append(pacienteId).append(" - PA crítica: ").append(pas).append("/").append(pad).append(" mmHg\n");
                if (spo2 < 90)
                    alerta.append("⚠️ Paciente ").append(pacienteId).append(" - SpO2 baja: ").append(spo2).append("%\n");

                return alerta.toString();
            });
    }
}
