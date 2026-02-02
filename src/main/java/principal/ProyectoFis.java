/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import controlador.ControladorMenu;
import modelo.Ruta;
import modelo.RutaDAO;
import java.util.ArrayList;
import vista.VistaMenu;


public class ProyectoFis {
    public static void main(String[] args) {

        // Crear la Vista del Menú
        VistaMenu vMenu = new VistaMenu();
        
        RutaDAO dao = new RutaDAO();
        // Crear el Controlador del Menú
        ControladorMenu cMenu = new ControladorMenu(vMenu, dao);
        // Iniciar
       cMenu.iniciar();  
    }
}       
        
        
    
