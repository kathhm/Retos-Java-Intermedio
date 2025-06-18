package Sesion03.Reto01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProcesarPedidos {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Cliente1", "Entrega a Domicilio","1234567890"),
            new Pedido("Cliente2", "Recoger en Tienda", null),
            new Pedido("Cliente3", "Entrega a Domicilio", "0987654321"),
            new Pedido("Cliente4", "Recoger en Tienda", null),
            new Pedido("Cliente5", "Entrega a Domicilio", "1122334455"));

            pedidos.stream()
            .filter(pedido -> pedido.getTipoEntrega().equalsIgnoreCase("Entrega a Domicilio")) // Solo pedidos a domicilio
            .map(Pedido::getTelefono) // Obtener Optional<String>
            .filter(Optional::isPresent) // Filtrar los que SÍ tienen teléfono
            .map(Optional::get) // Extraer el teléfono del Optional
            .map(telefono -> "📞 Confirmación enviada al número: " + telefono) // Crear el mensaje
            .forEach(System.out::println); // Mostrar en consola


    }

    
}
