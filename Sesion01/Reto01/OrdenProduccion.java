package Sesion01.Reto01;

import java.util.List;

public abstract class OrdenProduccion {

    String codigo;
    int cantidad;

    public void mostrarResumen(){
        System.out.println("Código de la orden: " + codigo);
        System.out.println("Cantidad a producir: " + cantidad);
    }

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista ){
        for (OrdenProduccion orden : lista){
            orden.mostrarResumen();
            System.out.println("-----------------------");
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){
        for (Object obj : lista){
             if (obj instanceof OrdenPersonalizada){
                OrdenPersonalizada op = (OrdenPersonalizada) obj;
                System.out.println("Procesando orden personalizada para el cliente: " + op.getCliente());
                System.out.println("Costo adicional aplicado: $" + costoAdicional);
             }
        }

    }

}
