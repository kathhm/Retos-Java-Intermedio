package Sesion03.Reto02;

import java.util.List;

public class Sucursal {
    private String nombre;
    private List<Encuesta> encuestas;

    public Sucursal(String nombre, List<Encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
    public void setEncuestas(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }
    

}
