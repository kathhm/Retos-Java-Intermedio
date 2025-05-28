public class OrdenPrototipo extends OrdenProduccion {
 String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.faseDesarrollo = faseDesarrollo;
    }

    public String getFaseDesarrollo() {
        return faseDesarrollo;
    }

}
