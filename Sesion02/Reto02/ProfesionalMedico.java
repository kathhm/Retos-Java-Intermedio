package Sesion02.Reto02;

public class ProfesionalMedico implements Runnable {
    private String nombre;
    private RecursoMedico recursoMedico;

    public ProfesionalMedico(String nombre, RecursoMedico recursoMedico) {
        this.nombre = nombre;
        this.recursoMedico = recursoMedico;
    }

    @Override
    public void run() {
        recursoMedico.usar(nombre);
    }

}
