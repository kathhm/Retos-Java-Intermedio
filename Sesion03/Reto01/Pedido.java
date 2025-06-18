package Sesion03.Reto01;

import java.util.Optional;

public class Pedido {
    private String cliente;
    private String tipoEntrega;
    private Optional<String> telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = Optional.ofNullable(telefono);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Optional<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(Optional<String> telefono) {
        this.telefono = Optional.ofNullable(telefono);
    }

  

    

}
