
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OrdenProduccion> ordenes = new ArrayList<>();

        ordenes.add(new OrdenPrototipo("P001", 100, "Fase 1"));
        ordenes.add(new OrdenMasa("M001", 500));            
        ordenes.add(new OrdenPersonalizada("C001", 200, "Cliente A"));
        ordenes.add(new OrdenPrototipo("P002", 150, "Fase 2"));
        ordenes.add(new OrdenMasa("M002", 300));
        ordenes.add(new OrdenPersonalizada("C002", 250, "Cliente B"));

        System.out.println("=== MOSTRANDO TODAS LAS ÓRDENES ===");
        OrdenProduccion.mostrarOrdenes(ordenes);

        System.out.println("\n=== PROCESANDO ÓRDENES PERSONALIZADAS ===");
        OrdenProduccion.procesarPersonalizadas(ordenes, 150);

    }
    
}
