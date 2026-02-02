
package modelo;


public class ClienteDAO {

    public boolean guardar(Cliente cliente) {
        // Aquí conectarías a la base de datos
        System.out.println("Cliente guardado: " + cliente.getNombre() + " " + cliente.getApellido());
        return true; 
    }
}

