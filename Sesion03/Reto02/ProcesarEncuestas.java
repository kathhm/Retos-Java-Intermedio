package Sesion03.Reto02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProcesarEncuestas {
    public static void main(String[] args) {

    Sucursal centro = new Sucursal("Centro", Arrays.asList(
            new Encuesta("Juan Perez", "Muy buena atención", 5),
            new Encuesta("Maria Lopez", null, 4),               
            new Encuesta("Carlos Gomez", "Excelente servicio", 5),
            new Encuesta("Ana Torres", "Podría mejorar", 3)
    ));

    Sucursal norte = new Sucursal("Norte", Arrays.asList(
            new Encuesta("Luis Ramirez", "Muy amable el personal", 5),
            new Encuesta("Elena Martinez", null, 4),
            new Encuesta("Pedro Sanchez", "Buen servicio", 4),
            new Encuesta("Laura Jimenez", "No me gustó el servicio", 2)
    ));

    List<Sucursal> sucursales = Arrays.asList(centro, norte);

    //proceso con flatMap y Optional
    sucursales.stream()
            .flatMap(sucursal -> 
                sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .flatMap(e -> e.getComentario()
                        .map(comentario -> 
                            Stream.of("Sucursal " + sucursal.getNombre() +
                                      ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
                        .orElseGet(Stream::empty))
            )
            .forEach(System.out::println);
    }



}
