package Sesion01.Reto02;

public class Video extends MaterialCurso {
    private int duracion; // Duración en minutos

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Video: " + titulo + " por " + autor + " (" + duracion + " min)");
    }

    

}
