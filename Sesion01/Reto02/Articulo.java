package Sesion01.Reto02;

public class Articulo extends MaterialCurso {
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }
    public int getPalabras() {
        return palabras;
    }
    public void setPalabras(int palabras) {
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Artículo: " + titulo + " por " + autor + " (" + palabras + " palabras)");
    }
    

}
