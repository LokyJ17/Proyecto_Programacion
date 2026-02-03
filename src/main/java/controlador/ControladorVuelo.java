/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Ruta;
import vista.VistaVuelo;

/**
 *
 * @author Master
 */
public class ControladorVuelo {
    
    private VistaVuelo vistaVuelo;
    private Ruta ruta;

    public ControladorVuelo(VistaVuelo vistaVuelo, Ruta ruta) {
        this.vistaVuelo = vistaVuelo;
        this.ruta = ruta;

    }

    public void iniciarVistaVuelo() {
        vistaVuelo.setTitle("Selección de Asientos");
        vistaVuelo.setLocationRelativeTo(null);
        vistaVuelo.setVisible(true);
    }
    
}
