
package vista;




import java.awt.Image;
import javax.swing.ImageIcon;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;



/**
 *
 * @author Master
 */
public class VistaMenu extends javax.swing.JFrame {
    
    private DatePicker datePickerIda;
    private DatePicker datePickerRegreso;
        
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaMenu.class.getName());
      
    
        
    public VistaMenu() {
        initComponents();
        configurarCalendarios();
     
        
    this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    //Ajustar la imagen del logo de la EPN
    java.awt.EventQueue.invokeLater(() -> {
        ImageIcon img = new ImageIcon(getClass().getResource("/img/politecnicaLogo.png"));
        Image escala = img.getImage().getScaledInstance(lblPoliLogo.getWidth(), lblPoliLogo.getHeight(), Image.SCALE_SMOOTH);
        lblPoliLogo.setIcon(new ImageIcon(escala));
        
    //Poner nombre a las pestañas de tbnMenu
    tbpMenu.setTitleAt(0, "     Vuelos     ");
    tbpMenu.setTitleAt(1, "Vuelos Registrados");
    

    tbpMenu.setToolTipTextAt(0, "Haga clic aquí para buscar elegir un origen y un destino");
    tbpMenu.setToolTipTextAt(1, "Haga clic aquí para buscar vuelos comprados y ver su recibo");
    
    //Cargar iconos de avion y folder
    ImageIcon iconoAvion = new ImageIcon(getClass().getResource("/img/plane.png")); 
    ImageIcon iconoFolder = new ImageIcon(getClass().getResource("/img/folder.png"));
    ImageIcon iconoOrigen = new ImageIcon(getClass().getResource("/img/departure.png"));
    ImageIcon iconoArrival = new ImageIcon(getClass().getResource("/img/arrival.png"));
    ImageIcon iconoCalendar = new ImageIcon(getClass().getResource("/img/calendar.png"));
    ImageIcon iconoPerson = new ImageIcon(getClass().getResource("/img/person.png"));
     
    Image imgEscalaAvion = iconoAvion.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
    Image imgEscalaFolder = iconoFolder.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image imgEscalaOrigen = iconoOrigen.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image imgEscalaArrival = iconoArrival.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image imgEscalaCalendar = iconoCalendar.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image imgEscalaPerson = iconoPerson.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
     
    tbpMenu.setIconAt(0, new ImageIcon(imgEscalaAvion));
    tbpMenu.setIconAt(1, new ImageIcon(imgEscalaFolder));    
    lblDeparture1.setIcon(new ImageIcon(imgEscalaOrigen));
    lblArrival.setIcon(new ImageIcon(imgEscalaArrival));
    lblCalendar.setIcon(new ImageIcon(imgEscalaCalendar));
    lblCalendar2.setIcon(new ImageIcon(imgEscalaCalendar));
    lblPerson.setIcon(new ImageIcon(imgEscalaPerson));
    
    //Maximizar para que se vea todo bien al abrir
    this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    
    //Tarjetas de viaje
    ImageIcon iconoGuayaquil = new ImageIcon(getClass().getResource("/img/guayaquil.jpg"));
    ImageIcon iconoCuenca = new ImageIcon(getClass().getResource("/img/cuenca.jpg"));
    ImageIcon iconoJaneiro = new ImageIcon(getClass().getResource("/img/rio_janeiro.jpg"));
    ImageIcon iconoLondres = new ImageIcon(getClass().getResource("/img/londres.jpg"));
    ImageIcon iconoPlanePlus = new ImageIcon(getClass().getResource("/img/plane_plus.png"));
    
    Image imgEscalaGuayaquil = iconoGuayaquil.getImage().getScaledInstance(lblGuayaquil.getWidth()
            ,lblGuayaquil.getHeight(), Image.SCALE_SMOOTH);
    Image imgEscalaCuenca = iconoCuenca.getImage().getScaledInstance(lblCuenca.getWidth()
            ,lblCuenca.getHeight(), Image.SCALE_SMOOTH);
    Image imgEscalaJaneiro = iconoJaneiro.getImage().getScaledInstance(lblRioJaneiro.getWidth()
            ,lblRioJaneiro.getHeight(), Image.SCALE_SMOOTH);
    Image imgEscalaLondres = iconoLondres.getImage().getScaledInstance(lblLondres.getWidth()
            ,lblLondres.getHeight(), Image.SCALE_SMOOTH);
     Image imgEscalaPlanePlus = iconoPlanePlus.getImage().getScaledInstance(lblPlanePlus.getWidth()
            ,lblPlanePlus.getHeight(), Image.SCALE_SMOOTH);
   
    lblGuayaquil.setIcon(new ImageIcon(imgEscalaGuayaquil));
    lblCuenca.setIcon(new ImageIcon(imgEscalaCuenca));
    lblRioJaneiro.setIcon(new ImageIcon(imgEscalaJaneiro));
    lblLondres.setIcon(new ImageIcon(imgEscalaLondres));
    lblPlanePlus.setIcon(new ImageIcon(imgEscalaPlanePlus));
     lblPlanePlus2.setIcon(new ImageIcon(imgEscalaPlanePlus));
    });
}
    
    
    private void configurarCalendarios() {
    //Configurar Fecha de Ida
    DatePickerSettings settingsIda = new DatePickerSettings();
    settingsIda.setFormatForDatesCommonEra("dd/MM/yyyy");
    datePickerIda = new DatePicker(settingsIda);
    datePickerIda.setDateToToday(); // Fecha de hoy por defecto
    
    pnlDateContainer.setLayout(new BorderLayout());
    pnlDateContainer.add(datePickerIda, BorderLayout.CENTER);
    pnlDateContainer.revalidate();

    //Configurar Fecha de Regreso
    DatePickerSettings settingsRegreso = new DatePickerSettings();
    settingsRegreso.setFormatForDatesCommonEra("dd/MM/yyyy");
    datePickerRegreso = new DatePicker(settingsRegreso);
    datePickerRegreso.setDateToToday();
    
    pnlDateContainer2.setLayout(new BorderLayout());
    pnlDateContainer2.add(datePickerRegreso, BorderLayout.CENTER);
    pnlDateContainer2.revalidate();
    
    }
    
    
    //Metodo para inyectar la lista a comboBox Origen en el controladorMenu
    public void cargarCiudadesEnCombo(ArrayList<String> listaOrigenes) {
    this.cmbOrigen.removeAllItems(); // Limpia el "Item 1" que viene por defecto
    for (String c : listaOrigenes) {this.cmbOrigen.addItem(c); }
    }
    
    //Metodo para inyectar la lista a comboBox Destino en el controladorMenu
    public void cargarCiudadesEnCombo2(ArrayList<String> listaOrigenes) {
    this.cmbDestino.removeAllItems(); // Limpia el "Item 1" que viene por defecto
    for (String c : listaOrigenes) {this.cmbDestino.addItem(c); }
    }
    
    
    //Getters de la información de origen, destino, fecha ida, fecha regreso, pasajeros y botón
    public String getOrigen() { return cmbOrigen.getSelectedItem().toString(); }
    public String getDestino() { return cmbDestino.getSelectedItem().toString(); }
    
    public LocalDate getFechaIda() { return datePickerIda.getDate(); }
    public LocalDate getFechaRegreso() { return datePickerRegreso.getDate(); }
    
    public String getNumPasajeros () { return cmbPasajeros.getSelectedItem().toString(); }
    
    public JButton getBtnBuscar() { return btnBuscar; }
    
    //Listener para el botón buscar
     public void addBtnBuscarListener(java.awt.event.ActionListener listen) {
        btnBuscar.addActionListener(listen);
    }
     
       
    
     
    
    
    
    

    

    

    
    
    

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPoliLogo = new javax.swing.JLabel();
        tbpMenu = new javax.swing.JTabbedPane();
        pnlVuelos = new javax.swing.JPanel();
        pnlOrigen = new javax.swing.JPanel();
        lblDeparture1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbOrigen = new javax.swing.JComboBox<>();
        pnlDestino = new javax.swing.JPanel();
        lblArrival = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbDestino = new javax.swing.JComboBox<>();
        pnlFechaIda = new javax.swing.JPanel();
        lblCalendar = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnlDateContainer = new javax.swing.JPanel();
        pnlFechaRegreso = new javax.swing.JPanel();
        lblCalendar2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnlDateContainer2 = new javax.swing.JPanel();
        pnlCantidadPersonas = new javax.swing.JPanel();
        lblPerson = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbPasajeros = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        pnlVuelosComprados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlCuenca = new javax.swing.JPanel();
        lblCuenca = new javax.swing.JLabel();
        pnlCuencaUsd = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPlanePlus = new javax.swing.JLabel();
        pnlMasVuelos = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnlRioJaneiro = new javax.swing.JPanel();
        lblRioJaneiro = new javax.swing.JLabel();
        pnlRioJaneiroUsd = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnlLondres = new javax.swing.JPanel();
        lblLondres = new javax.swing.JLabel();
        pnlLondresUsd = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblPlanePlus2 = new javax.swing.JLabel();
        pnlMasVuelos2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnlGuayaquil = new javax.swing.JPanel();
        lblGuayaquil = new javax.swing.JLabel();
        pnlGuayaquilUsd = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel1.setText("Aerolíneas FIS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(1225, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
        );

        lblPoliLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/politecnicaLogo.png"))); // NOI18N

        tbpMenu.setBackground(new java.awt.Color(153, 153, 153));
        tbpMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbpMenu.setToolTipText("");
        tbpMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlOrigen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel16.setText("Origen");

        cmbOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrigenLayout = new javax.swing.GroupLayout(pnlOrigen);
        pnlOrigen.setLayout(pnlOrigenLayout);
        pnlOrigenLayout.setHorizontalGroup(
            pnlOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrigenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDeparture1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnlOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(cmbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlOrigenLayout.setVerticalGroup(
            pnlOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrigenLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlOrigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDeparture1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrigenLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDestino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel17.setText("Destino");

        cmbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlDestinoLayout = new javax.swing.GroupLayout(pnlDestino);
        pnlDestino.setLayout(pnlDestinoLayout);
        pnlDestinoLayout.setHorizontalGroup(
            pnlDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnlDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlDestinoLayout.setVerticalGroup(
            pnlDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDestinoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDestinoLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFechaIda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel18.setText("Fecha Ida");

        pnlDateContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlDateContainerLayout = new javax.swing.GroupLayout(pnlDateContainer);
        pnlDateContainer.setLayout(pnlDateContainerLayout);
        pnlDateContainerLayout.setHorizontalGroup(
            pnlDateContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlDateContainerLayout.setVerticalGroup(
            pnlDateContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFechaIdaLayout = new javax.swing.GroupLayout(pnlFechaIda);
        pnlFechaIda.setLayout(pnlFechaIdaLayout);
        pnlFechaIdaLayout.setHorizontalGroup(
            pnlFechaIdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechaIdaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(pnlFechaIdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(pnlDateContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlFechaIdaLayout.setVerticalGroup(
            pnlFechaIdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFechaIdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFechaIdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFechaIdaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFechaIdaLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlDateContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pnlFechaRegreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel19.setText("Fecha Regreso");

        pnlDateContainer2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlDateContainer2Layout = new javax.swing.GroupLayout(pnlDateContainer2);
        pnlDateContainer2.setLayout(pnlDateContainer2Layout);
        pnlDateContainer2Layout.setHorizontalGroup(
            pnlDateContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlDateContainer2Layout.setVerticalGroup(
            pnlDateContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFechaRegresoLayout = new javax.swing.GroupLayout(pnlFechaRegreso);
        pnlFechaRegreso.setLayout(pnlFechaRegresoLayout);
        pnlFechaRegresoLayout.setHorizontalGroup(
            pnlFechaRegresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechaRegresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(pnlFechaRegresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDateContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFechaRegresoLayout.setVerticalGroup(
            pnlFechaRegresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFechaRegresoLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(pnlFechaRegresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFechaRegresoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDateContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pnlCantidadPersonas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel20.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel20.setText("Pasajeros");

        cmbPasajeros.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        cmbPasajeros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cmbPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPasajerosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCantidadPersonasLayout = new javax.swing.GroupLayout(pnlCantidadPersonas);
        pnlCantidadPersonas.setLayout(pnlCantidadPersonasLayout);
        pnlCantidadPersonasLayout.setHorizontalGroup(
            pnlCantidadPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCantidadPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(pnlCantidadPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCantidadPersonasLayout.setVerticalGroup(
            pnlCantidadPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCantidadPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCantidadPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCantidadPersonasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCantidadPersonasLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnBuscar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlVuelosLayout = new javax.swing.GroupLayout(pnlVuelos);
        pnlVuelos.setLayout(pnlVuelosLayout);
        pnlVuelosLayout.setHorizontalGroup(
            pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVuelosLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFechaIda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCantidadPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(118, 118, 118)
                .addGroup(pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFechaRegreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        pnlVuelosLayout.setVerticalGroup(
            pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVuelosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlFechaRegreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFechaIda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlCantidadPersonas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(pnlDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(75, 75, 75))
        );

        tbpMenu.addTab("Vuelos", pnlVuelos);

        javax.swing.GroupLayout pnlVuelosCompradosLayout = new javax.swing.GroupLayout(pnlVuelosComprados);
        pnlVuelosComprados.setLayout(pnlVuelosCompradosLayout);
        pnlVuelosCompradosLayout.setHorizontalGroup(
            pnlVuelosCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1232, Short.MAX_VALUE)
        );
        pnlVuelosCompradosLayout.setVerticalGroup(
            pnlVuelosCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        tbpMenu.addTab("Vuelos Comprados", pnlVuelosComprados);

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel2.setText("Grupo EPN");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel3.setText("Vuelos disponibles desde Quito ");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel4.setText("Descubre un nuevo destino");

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 3, 18)); // NOI18N
        jLabel5.setText("\"La excelencia que cruza fronetras\"");

        pnlCuenca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlCuencaUsd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel8.setText("Cuenca");

        jLabel14.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel14.setText("USD 55");

        javax.swing.GroupLayout pnlCuencaUsdLayout = new javax.swing.GroupLayout(pnlCuencaUsd);
        pnlCuencaUsd.setLayout(pnlCuencaUsdLayout);
        pnlCuencaUsdLayout.setHorizontalGroup(
            pnlCuencaUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCuencaUsdLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(28, 28, 28))
        );
        pnlCuencaUsdLayout.setVerticalGroup(
            pnlCuencaUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCuencaUsdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCuencaUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pnlCuencaLayout = new javax.swing.GroupLayout(pnlCuenca);
        pnlCuenca.setLayout(pnlCuencaLayout);
        pnlCuencaLayout.setHorizontalGroup(
            pnlCuencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCuenca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCuencaUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCuencaLayout.setVerticalGroup(
            pnlCuencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCuencaLayout.createSequentialGroup()
                .addComponent(lblCuenca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCuencaUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlMasVuelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel10.setText("¿No es lo que buscas? Aún puedes personalizar tu vuelo");

        javax.swing.GroupLayout pnlMasVuelosLayout = new javax.swing.GroupLayout(pnlMasVuelos);
        pnlMasVuelos.setLayout(pnlMasVuelosLayout);
        pnlMasVuelosLayout.setHorizontalGroup(
            pnlMasVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMasVuelosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMasVuelosLayout.setVerticalGroup(
            pnlMasVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMasVuelosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblPlanePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlMasVuelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblPlanePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlMasVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlRioJaneiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlRioJaneiroUsd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setText("Rio de Janeiro");

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel13.setText("USD 150");

        javax.swing.GroupLayout pnlRioJaneiroUsdLayout = new javax.swing.GroupLayout(pnlRioJaneiroUsd);
        pnlRioJaneiroUsd.setLayout(pnlRioJaneiroUsdLayout);
        pnlRioJaneiroUsdLayout.setHorizontalGroup(
            pnlRioJaneiroUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRioJaneiroUsdLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(27, 27, 27))
        );
        pnlRioJaneiroUsdLayout.setVerticalGroup(
            pnlRioJaneiroUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRioJaneiroUsdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRioJaneiroUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pnlRioJaneiroLayout = new javax.swing.GroupLayout(pnlRioJaneiro);
        pnlRioJaneiro.setLayout(pnlRioJaneiroLayout);
        pnlRioJaneiroLayout.setHorizontalGroup(
            pnlRioJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRioJaneiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRioJaneiroUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlRioJaneiroLayout.setVerticalGroup(
            pnlRioJaneiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRioJaneiroLayout.createSequentialGroup()
                .addComponent(lblRioJaneiro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRioJaneiroUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLondres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlLondresUsd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel9.setText("Londres");

        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel15.setText("USD 1200");

        javax.swing.GroupLayout pnlLondresUsdLayout = new javax.swing.GroupLayout(pnlLondresUsd);
        pnlLondresUsd.setLayout(pnlLondresUsdLayout);
        pnlLondresUsdLayout.setHorizontalGroup(
            pnlLondresUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLondresUsdLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(28, 28, 28))
        );
        pnlLondresUsdLayout.setVerticalGroup(
            pnlLondresUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLondresUsdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLondresUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout pnlLondresLayout = new javax.swing.GroupLayout(pnlLondres);
        pnlLondres.setLayout(pnlLondresLayout);
        pnlLondresLayout.setHorizontalGroup(
            pnlLondresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLondres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLondresUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlLondresLayout.setVerticalGroup(
            pnlLondresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLondresLayout.createSequentialGroup()
                .addComponent(lblLondres, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLondresUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlMasVuelos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel11.setText("¿No es lo que buscas? Aún puedes personalizar tu vuelo");

        javax.swing.GroupLayout pnlMasVuelos2Layout = new javax.swing.GroupLayout(pnlMasVuelos2);
        pnlMasVuelos2.setLayout(pnlMasVuelos2Layout);
        pnlMasVuelos2Layout.setHorizontalGroup(
            pnlMasVuelos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMasVuelos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMasVuelos2Layout.setVerticalGroup(
            pnlMasVuelos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMasVuelos2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lblPlanePlus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63))
            .addComponent(pnlMasVuelos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblPlanePlus2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMasVuelos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGuayaquil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlGuayaquilUsd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setText("Guayaquil");

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel12.setText("USD 55");

        javax.swing.GroupLayout pnlGuayaquilUsdLayout = new javax.swing.GroupLayout(pnlGuayaquilUsd);
        pnlGuayaquilUsd.setLayout(pnlGuayaquilUsdLayout);
        pnlGuayaquilUsdLayout.setHorizontalGroup(
            pnlGuayaquilUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuayaquilUsdLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(36, 36, 36))
        );
        pnlGuayaquilUsdLayout.setVerticalGroup(
            pnlGuayaquilUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGuayaquilUsdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlGuayaquilUsdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout pnlGuayaquilLayout = new javax.swing.GroupLayout(pnlGuayaquil);
        pnlGuayaquil.setLayout(pnlGuayaquilLayout);
        pnlGuayaquilLayout.setHorizontalGroup(
            pnlGuayaquilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGuayaquilUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGuayaquil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlGuayaquilLayout.setVerticalGroup(
            pnlGuayaquilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuayaquilLayout.createSequentialGroup()
                .addComponent(lblGuayaquil, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGuayaquilUsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblPoliLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(795, 795, 795))
                        .addComponent(tbpMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlRioJaneiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlGuayaquil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlLondres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlCuenca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(88, 88, 88)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblPoliLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addGap(42, 42, 42)
                .addComponent(tbpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCuenca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGuayaquil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLondres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRioJaneiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(600, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPasajerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPasajerosActionPerformed

    private void cmbOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrigenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new VistaMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbDestino;
    private javax.swing.JComboBox<String> cmbOrigen;
    private javax.swing.JComboBox<String> cmbPasajeros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArrival;
    private javax.swing.JLabel lblCalendar;
    private javax.swing.JLabel lblCalendar2;
    private javax.swing.JLabel lblCuenca;
    private javax.swing.JLabel lblDeparture1;
    private javax.swing.JLabel lblGuayaquil;
    private javax.swing.JLabel lblLondres;
    private javax.swing.JLabel lblPerson;
    private javax.swing.JLabel lblPlanePlus;
    private javax.swing.JLabel lblPlanePlus2;
    private javax.swing.JLabel lblPoliLogo;
    private javax.swing.JLabel lblRioJaneiro;
    private javax.swing.JPanel pnlCantidadPersonas;
    private javax.swing.JPanel pnlCuenca;
    private javax.swing.JPanel pnlCuencaUsd;
    private javax.swing.JPanel pnlDateContainer;
    private javax.swing.JPanel pnlDateContainer2;
    private javax.swing.JPanel pnlDestino;
    private javax.swing.JPanel pnlFechaIda;
    private javax.swing.JPanel pnlFechaRegreso;
    private javax.swing.JPanel pnlGuayaquil;
    private javax.swing.JPanel pnlGuayaquilUsd;
    private javax.swing.JPanel pnlLondres;
    private javax.swing.JPanel pnlLondresUsd;
    private javax.swing.JPanel pnlMasVuelos;
    private javax.swing.JPanel pnlMasVuelos2;
    private javax.swing.JPanel pnlOrigen;
    private javax.swing.JPanel pnlRioJaneiro;
    private javax.swing.JPanel pnlRioJaneiroUsd;
    private javax.swing.JPanel pnlVuelos;
    private javax.swing.JPanel pnlVuelosComprados;
    private javax.swing.JTabbedPane tbpMenu;
    // End of variables declaration//GEN-END:variables
}
