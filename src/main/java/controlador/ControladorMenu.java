
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RutaDAO;
import vista.VistaMenu;
import modelo.Ruta;
import vista.VistaVuelo;

/**
 *
 * @author Master
 */
public class ControladorMenu implements ActionListener {
    
    
    private VistaMenu VistaMenu;
    private RutaDAO rutaDAO;
    
 
    public ControladorMenu(VistaMenu vista, RutaDAO dao) {
        this.VistaMenu = vista;
        this.rutaDAO = dao;

        // rutaDao recive las listas de origen y destino
        ArrayList<String> ciudadesOrigen = this.rutaDAO.obtenerListaOrigenes();
        ArrayList<String> ciudadesDestino = this.rutaDAO.obtenerListaDestinos();

        // se llama a vistaMenu y a su metodo para iyectar listas en los comboBox
        this.VistaMenu.cargarCiudadesEnCombo(ciudadesOrigen);
        this.VistaMenu.cargarCiudadesEnCombo2(ciudadesDestino);
        
        this.VistaMenu.addBtnBuscarListener(this);
    }
    
    //Iniciador del menu, se usará en el app(Principal -> ProyectoFIS)
    public void iniciar() {
        VistaMenu.setTitle("Menú Principal");
        VistaMenu.setLocationRelativeTo(null);
        VistaMenu.setVisible(true);
    }
    
    private void manejarBusqueda() {
    String origen = VistaMenu.getOrigen();
    String destino = VistaMenu.getDestino();
    
    //Validar si no se está ingresando el mismo origen y destino
    if (origen.equalsIgnoreCase(destino)) {
        JOptionPane.showMessageDialog(VistaMenu,
            "El origen y el destino no pueden ser iguales.",
            "Error de Selección",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    Ruta rutaEncontrada = rutaDAO.buscarRuta(origen, destino);
    
    //Validar si la ruta seleccionada existe
    if (rutaEncontrada == null) {
        JOptionPane.showMessageDialog(VistaMenu,
            "Lo sentimos, no disponemos de rutas directas para el trayecto: "
            + origen + " a " + destino,
            "Ruta no encontrada",
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    System.out.println("Ruta encontrada: " + rutaEncontrada);

    //Cuando se ingrese una ruta válida se da paso a vistaVuelo
    VistaVuelo vistaVuelo = new VistaVuelo();
    ControladorVuelo controladorVuelo = new ControladorVuelo(vistaVuelo, rutaEncontrada);
    controladorVuelo.iniciarVistaVuelo();
    VistaMenu.dispose();
   }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaMenu.getBtnBuscar()) {
            manejarBusqueda();
        }
 
    }
    
}
