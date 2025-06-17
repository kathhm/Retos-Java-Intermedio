package Sesion01.Reto02;

public abstract class MaterialCurso {
    String titulo;
    String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract void mostrarDetalle();

 
}
