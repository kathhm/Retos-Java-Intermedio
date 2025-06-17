package Sesion01.Reto02;

public class Ejercicio extends MaterialCurso{
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }
 
    public void setRevisado() {
        this.revisado = true;
    }
    
    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio: " + titulo + " por " + autor + " - " +
                           (revisado ? "Revisado" : "No revisado"));
    }
}
