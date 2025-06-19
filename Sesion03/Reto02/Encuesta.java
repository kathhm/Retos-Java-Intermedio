package Sesion03.Reto02;

import java.util.Optional;

public class Encuesta {
    private String paciente;
    private Optional<String> comentario;
    private int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = Optional.ofNullable(comentario);
        this.calificacion = calificacion;
    }
    public String getPaciente() {
        return paciente;
    }
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    public Optional<String> getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = Optional.ofNullable(comentario);
    }
    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    

}
