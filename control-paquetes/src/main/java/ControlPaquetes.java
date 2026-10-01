public class ControlPaquetes {

    public static void mostrarPaquetes(Paquete[] paquetes, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        for (int i = 0; i < paquetes.length; i++) {
            System.out.println("[" + i + "] " + paquetes[i]);
        }
    }

    public static void main(String[] args) {

        Paquete[] paquetes = {
                new Paquete("TRK1005", "Ana Gómez", "En tránsito"),
                new Paquete("TRK1002", "Carlos Ruiz", "Entregado"),
                new Paquete("TRK1008", "María López", "Pendiente"),
                new Paquete("TRK1001", "Pedro Sánchez", "En tránsito"),
                new Paquete("TRK1007", "Laura Fernández", "Devuelto"),
                new Paquete("TRK1003", "Juan Pérez", "Entregado"),
                new Paquete("TRK1006", "Sofía Martínez", "En tránsito"),
                new Paquete("TRK1004", "Diego Torres", "Pendiente")
        };

        mostrarPaquetes(paquetes, "Arreglo original de paquetes");
    }
}