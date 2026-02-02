package controlador;

import java.awt.event.*;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.VistaVentaPasaje;
import vista.VistaPago;

public class ControladorVenta {
    private VistaVentaPasaje vista;
    private Cliente modelo;
    private ClienteDAO dao;

    public ControladorVenta(VistaVentaPasaje vista, Cliente modelo, ClienteDAO dao) {
        this.vista = vista;
        this.modelo = modelo;
        this.dao = dao;

        // Validación de solo números 
        this.vista.txtNumdoc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) e.consume();
            }
        });

        //  Acción del botón Confirmar Datos
        this.vista.btnConfirmar.addActionListener(e -> ejecutarSiguiente());
    }

    private void ejecutarSiguiente() {
       
        if (vista.txtNumdoc.getText().isEmpty() || vista.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Complete los campos obligatorios");
            return;
        }

        // Pasar datos al modelo 
        modelo.setNombre(vista.txtNombre.getText());
        modelo.setApellido(vista.txtApellido.getText());
        modelo.setNumDoc(vista.txtNumdoc.getText()); 
        modelo.setEmail(vista.txtEmail.getText());
        modelo.setTelefono(vista.txtTelefono.getText());

        
        if (dao.guardar(modelo)) { 
            JOptionPane.showMessageDialog(vista, "Registro exitoso.");
            
            // Navegación a la vista de pago
            VistaPago vPago = new VistaPago();
            vPago.setVisible(true);
            vPago.setLocationRelativeTo(null);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar datos.");
        }
    }
}