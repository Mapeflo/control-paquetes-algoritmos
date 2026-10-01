public class ControlPaquetes {

    public static void mostrarPaquetes(Paquete[] paquetes, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        for (int i = 0; i < paquetes.length; i++) {
            System.out.println("[" + i + "] " + paquetes[i]);
        }
    }

    /**
     * Búsqueda lineal por código de seguimiento.
     * Complejidad: O(n)
     * No requiere que el arreglo esté ordenado.
     */
    public static int busquedaLinealPorCodigo(Paquete[] paquetes, String codigo) {
        if (paquetes == null || paquetes.length == 0) {
            return -1;
        }

        for (int i = 0; i < paquetes.length; i++) {
            if (paquetes[i].getCodigoSeguimiento().equalsIgnoreCase(codigo)) {
                return i; // Encontrado
            }
        }
        return -1; // No encontrado
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

        // ========== PRUEBAS DE BÚSQUEDA LINEAL ==========
        System.out.println("\n>>> BÚSQUEDA LINEAL POR CÓDIGO");

        // Caso exitoso
        String codigoExito = "TRK1003";
        int posicion = busquedaLinealPorCodigo(paquetes, codigoExito);
        if (posicion != -1) {
            System.out.println("Búsqueda EXITOSA: \"" + codigoExito + "\" encontrado en el índice " + posicion);
            System.out.println("  → " + paquetes[posicion]);
        } else {
            System.out.println("Búsqueda NO EXITOSA: \"" + codigoExito + "\" no existe.");
        }

        // Caso no exitoso
        String codigoFallo = "TRK9999";
        posicion = busquedaLinealPorCodigo(paquetes, codigoFallo);
        if (posicion != -1) {
            System.out.println("Búsqueda EXITOSA: \"" + codigoFallo + "\" encontrado en el índice " + posicion);
        } else {
            System.out.println("Búsqueda NO EXITOSA: \"" + codigoFallo + "\" no existe.");
        }
    }
}