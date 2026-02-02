
package modelo;

public class Ruta {
    private String origen;
    private String destino;
    private String idVuelo;
    private double precio;

    public Ruta(String origen, String destino, String idVuelo, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.idVuelo = idVuelo;
        this.precio = precio;
    }

    // Getters y Setters
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getIdVuelo() { return idVuelo; }
    public double getPrecio() { return precio; }

    @Override
    //Obtener el csv de la ruta
    public String toString() {
        return origen + "," + destino + "," + idVuelo + "," + precio;
    }
}
