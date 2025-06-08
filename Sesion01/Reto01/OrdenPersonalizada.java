package Sesion01.Reto01;

public class OrdenPersonalizada extends OrdenProduccion{
    String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    



}
