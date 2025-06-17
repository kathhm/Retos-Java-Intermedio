package Sesion01.Reto02;

import java.util.List;

public class UtilMaterialCurso {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        for(MaterialCurso material : lista){
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista){
        int total = 0;
        for(Video video : lista){
            total += video.getDuracion();
        }
        System.out.println("Duración total de videos: " + total + "minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        for(Object obj : lista){
            if (obj instanceof Ejercicio ejercicio){
                ejercicio.setRevisado();
                System.out.println("Ejercicio ya revisado ✅: " + ejercicio.titulo);
            }
            
        }
    }


}
