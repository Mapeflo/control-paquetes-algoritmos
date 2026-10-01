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
    /**
     * Busca y muestra todos los paquetes con un estado específico.
     * Complejidad: O(n)
     * Valida casos con 0, 1 o varios resultados.
     */
    public static void buscarTodosPorEstado(Paquete[] paquetes, String estado) {
        boolean encontrado = false;
        System.out.println("\n--- Paquetes con estado: \"" + estado + "\" ---");

        for (int i = 0; i < paquetes.length; i++) {
            if (paquetes[i].getEstado().equalsIgnoreCase(estado)) {
                System.out.println("  Índice " + i + ": " + paquetes[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("  No se encontraron paquetes con ese estado.");
        }
    }
    /**
     * Ordena el arreglo por código de seguimiento usando Bubble Sort.
     * Complejidad: O(n²)
     * Este ordenamiento es la precondición necesaria para la búsqueda binaria.
     */
    public static void ordenarPorCodigo(Paquete[] paquetes) {
        int n = paquetes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (paquetes[j].getCodigoSeguimiento()
                        .compareToIgnoreCase(paquetes[j + 1].getCodigoSeguimiento()) > 0) {
                    // Intercambio
                    Paquete temp = paquetes[j];
                    paquetes[j] = paquetes[j + 1];
                    paquetes[j + 1] = temp;
                }
            }
        }
    }
    /**
     * Búsqueda binaria por código de seguimiento.
     * PRECONDICIÓN: el arreglo DEBE estar ordenado por código.
     * Complejidad: O(log n)
     */
    public static int busquedaBinariaPorCodigo(Paquete[] paquetes, String codigo) {
        if (paquetes == null || paquetes.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = paquetes.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1); // evita overflow
            int comparacion = paquetes[mid].getCodigoSeguimiento()
                    .compareToIgnoreCase(codigo);

            if (comparacion == 0) {
                return mid; // Encontrado
            } else if (comparacion < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
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
        // ========== BÚSQUEDA POR ESTADO ==========
        System.out.println("\n>>> BÚSQUEDA DE TODOS LOS PAQUETES POR ESTADO");

        buscarTodosPorEstado(paquetes, "En tránsito");   // Varios resultados
        buscarTodosPorEstado(paquetes, "Entregado");     // Varios resultados
        buscarTodosPorEstado(paquetes, "Perdido");       // Ningún resultado

        // ========== ORDENAMIENTO POR CÓDIGO ==========
        System.out.println("\n>>> ORDENAMIENTO POR CÓDIGO DE SEGUIMIENTO");
        ordenarPorCodigo(paquetes);
        mostrarPaquetes(paquetes, "Arreglo ordenado por código");

        // ========== BÚSQUEDA BINARIA ==========
        System.out.println("\n>>> BÚSQUEDA BINARIA POR CÓDIGO");
        System.out.println("PRECONDICIÓN: El arreglo ya está ordenado por código.");

        // Caso exitoso
        String codigoBinExito = "TRK1006";
        int posBinaria = busquedaBinariaPorCodigo(paquetes, codigoBinExito);
        if (posBinaria != -1) {
            System.out.println("Búsqueda binaria EXITOSA: \"" + codigoBinExito +
                    "\" encontrado en el índice " + posBinaria);
            System.out.println("  → " + paquetes[posBinaria]);
        } else {
            System.out.println("Búsqueda binaria NO EXITOSA.");
        }

        // Caso no exitoso
        String codigoBinFallo = "TRK1010";
        posBinaria = busquedaBinariaPorCodigo(paquetes, codigoBinFallo);
        if (posBinaria != -1) {
            System.out.println("Búsqueda binaria EXITOSA: \"" + codigoBinFallo + "\" encontrado.");
        } else {
            System.out.println("Búsqueda binaria NO EXITOSA: \"" + codigoBinFallo + "\" no existe.");
        }
    }
}