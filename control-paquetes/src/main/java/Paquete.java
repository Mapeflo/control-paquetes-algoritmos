public class Paquete {
    private String codigoSeguimiento;
    private String destinatario;
    private String estado;

    public Paquete(String codigoSeguimiento, String destinatario, String estado) {
        this.codigoSeguimiento = codigoSeguimiento;
        this.destinatario = destinatario;
        this.estado = estado;
    }

    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Paquete{codigo='" + codigoSeguimiento +
                "', destinatario='" + destinatario +
                "', estado='" + estado + "'}";
    }
}