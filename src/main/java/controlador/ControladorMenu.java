/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.RutaDAO;
import vista.VistaMenu;

/**
 *
 * @author Master
 */
public class ControladorMenu {
    
    private VistaMenu VistaMenu;
    private RutaDAO dao;

    public ControladorMenu(VistaMenu VistaMenu) {
        this.VistaMenu = VistaMenu;
    }
    
    public ControladorMenu(VistaMenu vista, RutaDAO dao) {
        this.VistaMenu = vista;
        this.dao = dao;

        // 1. Le pedimos la lista al DAO
        ArrayList<String> ciudadesOrigen = this.dao.obtenerListaOrigenes();
        ArrayList<String> ciudadesDestino = this.dao.obtenerListaDestinos();

        // 2. Se la pasamos a la Vista para que el combo deje de estar vacío
        this.VistaMenu.cargarCiudadesEnCombo(ciudadesOrigen);
        this.VistaMenu.cargarCiudadesEnCombo2(ciudadesDestino);
    }
    
    
    public void iniciar() {
        VistaMenu.setTitle("Menú Principal");
        VistaMenu.setLocationRelativeTo(null);
        VistaMenu.setVisible(true);
    }
}
