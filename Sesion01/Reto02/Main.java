package Sesion01.Reto02;

import static Sesion01.Reto02.UtilMaterialCurso.contarDuracionVideos;
import static Sesion01.Reto02.UtilMaterialCurso.marcarEjerciciosRevisados;
import static Sesion01.Reto02.UtilMaterialCurso.mostrarMateriales;
import java.util.ArrayList;
import java.util.List;




public class Main {
    public static void main(String[] args) {

        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Intro a Java", "Ana", 10));
        materiales.add(new Video("POO en Java", "Luis", 15));
        materiales.add(new Articulo("Guía de instalación", "Ana", 800));
        materiales.add(new Articulo("Conceptos de OOP", "Luis", 1200));
        materiales.add(new Ejercicio("Ejercicio 1", "Carlos"));
        materiales.add(new Ejercicio("Ejercicio 2", "Carlos"));

        mostrarMateriales(materiales);

        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        contarDuracionVideos(videos);

        marcarEjerciciosRevisados(materiales);
        mostrarMateriales(materiales);



    }
    
}
