/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatDarkLaf;
import controller.DataController;
import controller.DonationController;
import controller.ProductController;
import controller.UsuarioController;
import controller.ValidateDataController;
import controller.ViewController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import model.Donacion;
import model.Producto;
import model.TipoUsuario;
import model.datoDeTabla;

/**
 *
 * @author alex6
 */
public class Main extends javax.swing.JFrame {
    private ArrayList<datoDeTabla> listaProductos = new ArrayList<>();
    private ArrayList<datoDeTabla> listaDonativos = new ArrayList<>();
    private ArrayList<datoDeTabla> donacionesDisponibles = new ArrayList<>();
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        contenedorPrincipal.requestFocusInWindow();
        txtContraseña.setEchoChar('\u2022');
        DataController.cargarUsuarios();
        DataController.cargarDonaciones();
        cargarDonativos();
    }
    
    private String obtenerIDDonacion(JTable tabla) {
        int fila = tabla.getSelectedRow();
        return (String) tabla.getValueAt(fila, 0);
    }
    
    private void mostrarDonacion(JTable tablaDatos, JTable tablaMostrar) {
        String idDonacion = obtenerIDDonacion(tablaDatos);
        
        listaProductos.clear();
        if(DataController.getListaDonativos().containsKey(idDonacion)) {
            for(Producto p : DataController.getListaDonativos().get(idDonacion).getProductos()) {
                listaProductos.add(p);
            }
            txtObservaciones.setText(DataController.getListaDonativos().get(idDonacion).getObservaciones());
            txtObservacioDescrip.setText(DataController.getListaDonativos().get(idDonacion).getObservaciones());
        } else { 
            System.out.println("ID de producto no se encuentra en la lista |Main.tblDonacionesBenefactor|");
        }
        
        
        ViewController.mostrarTabla(tablaMostrar, listaProductos);
    }
    
    private void añadirALista(Producto producto) {  
        if(!this.listaProductos.isEmpty()) {
            for(int i = 0; i < this.listaProductos.size(); i++) {
                Producto enLista = (Producto) this.listaProductos.get(i);

                if(((Producto) this.listaProductos.get(i)).getAlimento().equals(producto.getAlimento())) {
                    enLista.setCantidad(enLista.getCantidad() + producto.getCantidad());
                    this.listaProductos.set(i, enLista);
                    break;
                } else {
                    this.listaProductos.add(producto);
                    break;
                }
            }
        } else {
            this.listaProductos.add(producto);
        }
    }
    
    private void cargarDonativos() {
        donacionesDisponibles.clear();
        for(Donacion d : DataController.getListaDonativos().values()) {
            if(d.getEstado()) {
                donacionesDisponibles.add(d);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        menuInicioSesion = new javax.swing.JPanel();
        lblTituloInicio = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        btnInicioSesion = new javax.swing.JButton();
        btnRegistro = new javax.swing.JLabel();
        menuRegistro = new javax.swing.JPanel();
        lblTituloRegistro = new javax.swing.JLabel();
        lblNoIdentificacion = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblTipoUsuario = new javax.swing.JLabel();
        cbxTipoUsuario = new javax.swing.JComboBox<>();
        lblContraseñaRegistro = new javax.swing.JLabel();
        txtContraseñaRegistro = new javax.swing.JPasswordField();
        lblConfirmContraseña = new javax.swing.JLabel();
        txtConfirmContraseña = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnInicio = new javax.swing.JLabel();
        menuBenefactor = new javax.swing.JPanel();
        scrollPaneBenefactor = new javax.swing.JScrollPane();
        tblDonacionesBenefactor = new javax.swing.JTable();
        btnCerrarSesionBenefactor = new javax.swing.JButton();
        lblBienvenidoBenefactor = new javax.swing.JLabel();
        btnAgregarDonativo = new javax.swing.JButton();
        btnEliminarDonativo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtProducto = new javax.swing.JTextField();
        spCantidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnPublicar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        menuBeneficiario = new javax.swing.JPanel();
        lblBienvenidoBeneficiario = new javax.swing.JLabel();
        btnCerrarSesionBeneficiario = new javax.swing.JButton();
        lblListaDonacionesDisponibles = new javax.swing.JLabel();
        scrollPaneBeneficiario = new javax.swing.JScrollPane();
        tablaBeneficiario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDescripcion = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObservacioDescrip = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(898, 605));
        setMinimumSize(new java.awt.Dimension(898, 605));
        setResizable(false);

        contenedorPrincipal.setMaximumSize(new java.awt.Dimension(1200, 693));
        contenedorPrincipal.setMinimumSize(new java.awt.Dimension(1200, 693));
        contenedorPrincipal.setPreferredSize(new java.awt.Dimension(1200, 693));
        contenedorPrincipal.setLayout(new java.awt.CardLayout());

        menuInicioSesion.setBackground(new java.awt.Color(204, 204, 255));
        menuInicioSesion.setMaximumSize(new java.awt.Dimension(1200, 605));
        menuInicioSesion.setMinimumSize(new java.awt.Dimension(1200, 605));
        menuInicioSesion.setOpaque(false);
        menuInicioSesion.setPreferredSize(new java.awt.Dimension(1200, 605));
        menuInicioSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloInicio.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTituloInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloInicio.setText("INICIAR SESION");
        menuInicioSesion.add(lblTituloInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 1199, -1));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");
        menuInicioSesion.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 296, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuInicioSesion.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 296, -1));

        lblContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña:");
        menuInicioSesion.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 225, 296, -1));

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuInicioSesion.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 251, 296, 31));

        btnInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInicioSesion.setText("Iniciar Sesion");
        btnInicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioSesionMouseClicked(evt);
            }
        });
        menuInicioSesion.add(btnInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 309, 296, 35));

        btnRegistro.setForeground(new java.awt.Color(51, 153, 255));
        btnRegistro.setText("¿Aun no tienes cuenta?");
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
        });
        menuInicioSesion.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 356, -1, -1));

        contenedorPrincipal.add(menuInicioSesion, "menu_inicio");

        menuRegistro.setBackground(new java.awt.Color(204, 255, 204));
        menuRegistro.setMaximumSize(new java.awt.Dimension(1200, 605));
        menuRegistro.setMinimumSize(new java.awt.Dimension(1200, 605));
        menuRegistro.setOpaque(false);
        menuRegistro.setPreferredSize(new java.awt.Dimension(1200, 605));
        menuRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloRegistro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTituloRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloRegistro.setText("REGISTRAR USUARIO");
        menuRegistro.add(lblTituloRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 36, 1087, -1));

        lblNoIdentificacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNoIdentificacion.setText("No. Identificacion");
        menuRegistro.add(lblNoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 117, 364, -1));

        txtIdentificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuRegistro.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 143, 364, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");
        menuRegistro.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 187, 364, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuRegistro.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 213, 364, -1));

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDireccion.setText("Direccion");
        menuRegistro.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 257, 364, -1));

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuRegistro.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 283, 364, -1));

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreUsuario.setText("Nombre de Usuario");
        menuRegistro.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 327, 175, -1));

        txtNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuRegistro.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 353, 175, -1));

        lblTipoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipoUsuario.setText("Tipo de Usuario");
        menuRegistro.add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 327, 171, -1));

        cbxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Benefactor", "Beneficiario" }));
        menuRegistro.add(cbxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 353, 171, 26));

        lblContraseñaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseñaRegistro.setText("Contraseña");
        menuRegistro.add(lblContraseñaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 397, 364, -1));

        txtContraseñaRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuRegistro.add(txtContraseñaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 423, 364, -1));

        lblConfirmContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConfirmContraseña.setText("Confirmar Contraseña");
        menuRegistro.add(lblConfirmContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 467, 364, -1));

        txtConfirmContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuRegistro.add(txtConfirmContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 493, 364, -1));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        menuRegistro.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 537, 364, 35));

        btnInicio.setForeground(new java.awt.Color(51, 153, 255));
        btnInicio.setText("¿Ya tienes una cuenta?");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });
        menuRegistro.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 590, -1, -1));

        contenedorPrincipal.add(menuRegistro, "menu_registro");

        menuBenefactor.setMaximumSize(new java.awt.Dimension(1200, 605));
        menuBenefactor.setMinimumSize(new java.awt.Dimension(1200, 605));
        menuBenefactor.setPreferredSize(new java.awt.Dimension(1200, 605));
        menuBenefactor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBenefactorMouseClicked(evt);
            }
        });
        menuBenefactor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDonacionesBenefactor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonacionesBenefactor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblDonacionesBenefactorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblDonacionesBenefactorFocusLost(evt);
            }
        });
        tblDonacionesBenefactor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonacionesBenefactorMouseClicked(evt);
            }
        });
        scrollPaneBenefactor.setViewportView(tblDonacionesBenefactor);

        menuBenefactor.add(scrollPaneBenefactor, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 450, 530));

        btnCerrarSesionBenefactor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrarSesionBenefactor.setText("CERRAR SESION ");
        btnCerrarSesionBenefactor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionBenefactorMouseClicked(evt);
            }
        });
        menuBenefactor.add(btnCerrarSesionBenefactor, new org.netbeans.lib.awtextra.AbsoluteConstraints(997, 10, 190, -1));

        lblBienvenidoBenefactor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBienvenidoBenefactor.setText("Bienvenido, <Nombre>");
        menuBenefactor.add(lblBienvenidoBenefactor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 828, 29));

        btnAgregarDonativo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarDonativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_icon.png"))); // NOI18N
        btnAgregarDonativo.setText("AGREGAR PRODUCTO");
        btnAgregarDonativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarDonativoMouseClicked(evt);
            }
        });
        menuBenefactor.add(btnAgregarDonativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 230, 34));

        btnEliminarDonativo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarDonativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus_icon.png"))); // NOI18N
        btnEliminarDonativo.setText("ELIMINAR PRODUCTO");
        btnEliminarDonativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarDonativoMouseClicked(evt);
            }
        });
        menuBenefactor.add(btnEliminarDonativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 190, 34));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad (Kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        menuBenefactor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 620, 290));

        txtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProductoMouseClicked(evt);
            }
        });
        menuBenefactor.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 30));

        spCantidad.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 1.0d));
        menuBenefactor.add(spCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Observacion general");
        menuBenefactor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 230, -1));

        btnPublicar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/send_icon.png"))); // NOI18N
        btnPublicar.setText("PUBLICAR");
        btnPublicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPublicarMouseClicked(evt);
            }
        });
        menuBenefactor.add(btnPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 180, 34));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Producto");
        menuBenefactor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 230, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Historial de Donaciones");
        menuBenefactor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 280, 40));

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        menuBenefactor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 566, 620, 120));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad (Kg)");
        menuBenefactor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, -1));

        contenedorPrincipal.add(menuBenefactor, "menu_benefactor");

        menuBeneficiario.setMaximumSize(new java.awt.Dimension(1200, 605));
        menuBeneficiario.setMinimumSize(new java.awt.Dimension(1200, 605));
        menuBeneficiario.setPreferredSize(new java.awt.Dimension(1200, 605));
        menuBeneficiario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBienvenidoBeneficiario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBienvenidoBeneficiario.setText("Bienvenido, <Nombre>");
        menuBeneficiario.add(lblBienvenidoBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 928, 39));

        btnCerrarSesionBeneficiario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrarSesionBeneficiario.setText("CERRAR SESION ");
        btnCerrarSesionBeneficiario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionBeneficiarioMouseClicked(evt);
            }
        });
        menuBeneficiario.add(btnCerrarSesionBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 6, 209, -1));

        lblListaDonacionesDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblListaDonacionesDisponibles.setText("DONACIONES");
        menuBeneficiario.add(lblListaDonacionesDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 280, 530, 20));

        tablaBeneficiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Donativo", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBeneficiario.setName("tabla_donaciones"); // NOI18N
        tablaBeneficiario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBeneficiarioMouseClicked(evt);
            }
        });
        scrollPaneBeneficiario.setViewportView(tablaBeneficiario);

        menuBeneficiario.add(scrollPaneBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1185, 383));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Productos:");
        menuBeneficiario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tblDescripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDescripcion);

        menuBeneficiario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, 180));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Observaciones:");
        menuBeneficiario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        txtObservacioDescrip.setEditable(false);
        txtObservacioDescrip.setColumns(20);
        txtObservacioDescrip.setRows(5);
        txtObservacioDescrip.setVerifyInputWhenFocusTarget(false);
        jScrollPane4.setViewportView(txtObservacioDescrip);

        menuBeneficiario.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 230, 180));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reserve_icon.png"))); // NOI18N
        jButton1.setText("Reservar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        menuBeneficiario.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        contenedorPrincipal.add(menuBeneficiario, "menu_beneficiario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        ViewController.cambiarMenu(contenedorPrincipal, "menu_registro");
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        ViewController.cambiarMenu(contenedorPrincipal, "menu_inicio");
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        String id = txtIdentificacion.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String username = txtNombreUsuario.getText();
        String clave  = String.valueOf(txtContraseñaRegistro.getPassword());
        String confirmClave = String.valueOf(txtConfirmContraseña.getPassword());
        String tipoUsuario = String.valueOf(cbxTipoUsuario.getSelectedItem());
        
        if(ValidateDataController.validarCampos(menuRegistro)) {
            if(ValidateDataController.validarRegistro(id, nombre, username, clave, confirmClave)) {
                UsuarioController.registrarUsuario(id, nombre, direccion, username, clave, tipoUsuario);
                DataController.guardarUsuarios();
                JOptionPane.showMessageDialog(this, "Usuario Registrado");
            }
        }
        
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtNombreUsuario.setText("");
        txtContraseñaRegistro.setText("");
        txtConfirmContraseña.setText("");
        cbxTipoUsuario.setToolTipText(" ");
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnInicioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioSesionMouseClicked
        String username = txtUsuario.getText();
        String clave = String.valueOf(txtContraseña.getPassword());
        ArrayList<datoDeTabla> listaDonativoUsuario = new ArrayList<>();
        
        if (ValidateDataController.validarCampos(menuInicioSesion)){
            
            if(UsuarioController.inicioSesion(username, clave)) {
                try {
                    switch(UsuarioController.getUsuarioSesion().getRol()){
                        case TipoUsuario.BENEFACTOR -> ViewController.cambiarMenu(contenedorPrincipal, "menu_benefactor");
                        case TipoUsuario.BENEFICIARIO -> ViewController.cambiarMenu(contenedorPrincipal, "menu_beneficiario");
                        case TipoUsuario.ADMINISTRADOR -> ViewController.cambiarMenu(contenedorPrincipal, "menu_benefactor");
                    }
                } catch (NullPointerException e) {
                    System.out.println("No hay usuario en sesion");
                }
                
                // Cargando datos de usuario
                lblBienvenidoBenefactor.setText("Bienvenido " + UsuarioController.getUsuarioSesion().getNombre());
                lblBienvenidoBeneficiario.setText("Bienvenido "+ UsuarioController.getUsuarioSesion().getNombre());
                
                for (Donacion d : DataController.getListaDonativos().values()) {
                    if(d.getProveedor().equals(UsuarioController.getUsuarioSesion().getNombre())) {
                        listaDonativoUsuario.add(d);
                    }
                }
                
                listaDonativos = listaDonativoUsuario;
                ViewController.mostrarTabla(tblDonacionesBenefactor, listaDonativos);
                ViewController.mostrarTabla(tablaBeneficiario, donacionesDisponibles);
            }
            
        }
        
        
    }//GEN-LAST:event_btnInicioSesionMouseClicked

    private void btnCerrarSesionBenefactorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionBenefactorMouseClicked
        ViewController.cambiarMenu(contenedorPrincipal, "menu_inicio");
        UsuarioController.setUsuarioSesion(null);
    }//GEN-LAST:event_btnCerrarSesionBenefactorMouseClicked

    private void btnCerrarSesionBeneficiarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionBeneficiarioMouseClicked
        ViewController.cambiarMenu(contenedorPrincipal, "menu_inicio");
    }//GEN-LAST:event_btnCerrarSesionBeneficiarioMouseClicked

    private void btnAgregarDonativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDonativoMouseClicked
        if(!txtProducto.getText().trim().isBlank()) {
            Number valor = (Number) spCantidad.getValue();
            double cantidad = valor.doubleValue();

           añadirALista(ProductController.crearProducto(txtProducto.getText(), cantidad));
           ViewController.mostrarTabla(tblProductos, this.listaProductos);
           
           txtProducto.setText("");
           spCantidad.setValue(1);
        }
    }//GEN-LAST:event_btnAgregarDonativoMouseClicked

    private void btnPublicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPublicarMouseClicked
        if(!listaProductos.isEmpty() && !txtObservaciones.getText().isBlank()) {
            ArrayList<Producto> listaP = new ArrayList<>();
            
            for(datoDeTabla producto : listaProductos) {
                if(producto instanceof Producto p) {
                    listaP.add(p);
                }
            }
            
            listaDonativos.add(DonationController.crearDonacion(listaP, UsuarioController.getUsuarioSesion().getNombre(), txtObservaciones.getText()));
            DataController.guardarDonaciones();
            JOptionPane.showMessageDialog(this, "Donacion Publicada: " + DonationController.codigo);
            ViewController.mostrarTabla(tblDonacionesBenefactor, listaDonativos);
            listaProductos.clear();
            txtObservaciones.setText("");
        } else {
            System.out.println("No hay elementos en el carrito");
        }
        
    }//GEN-LAST:event_btnPublicarMouseClicked

    private void tblDonacionesBenefactorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonacionesBenefactorMouseClicked
        mostrarDonacion(tblDonacionesBenefactor, tblProductos);
    }//GEN-LAST:event_tblDonacionesBenefactorMouseClicked

    private void txtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProductoMouseClicked
        
    }//GEN-LAST:event_txtProductoMouseClicked

    private void menuBenefactorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBenefactorMouseClicked
        menuBenefactor.requestFocusInWindow();
    }//GEN-LAST:event_menuBenefactorMouseClicked

    private void tblDonacionesBenefactorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDonacionesBenefactorFocusGained
        mostrarDonacion(tblDonacionesBenefactor, tblProductos);
    }//GEN-LAST:event_tblDonacionesBenefactorFocusGained

    private void tblDonacionesBenefactorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDonacionesBenefactorFocusLost
        listaProductos.clear();
        txtObservaciones.setText("");
        ViewController.mostrarTabla(tblProductos, listaProductos);
    }//GEN-LAST:event_tblDonacionesBenefactorFocusLost

    private void btnEliminarDonativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarDonativoMouseClicked
        String nombreProducto = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto: ");
        
        if(nombreProducto != null) {
            for(int i = 0; i < tblProductos.getRowCount(); i++) {
                String producto = (String) tblProductos.getValueAt(i, 0);
                
                if(producto.equals(nombreProducto)) {
                    listaProductos.remove(i);
                    JOptionPane.showMessageDialog(this, "Producto eliminado!");
                    ViewController.mostrarTabla(tblProductos, listaProductos);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No se encontro el producto especificado");
        }
    }//GEN-LAST:event_btnEliminarDonativoMouseClicked

    private void tablaBeneficiarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBeneficiarioMouseClicked
        mostrarDonacion(tablaBeneficiario, tblDescripcion);
    }//GEN-LAST:event_tablaBeneficiarioMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String IDDonacion = obtenerIDDonacion(tablaBeneficiario);
        
        if(DataController.getListaDonativos().containsKey(IDDonacion)) {
            DataController.getListaDonativos().get(IDDonacion).setEstado(false);
            cargarDonativos();
            ViewController.mostrarTabla(tablaBeneficiario, donacionesDisponibles);
            DataController.guardarDonaciones();
            JOptionPane.showMessageDialog(this, "Reservacion realizada: " + IDDonacion);
        } else {
            JOptionPane.showMessageDialog(this, "ID No encontrada " + IDDonacion);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDonativo;
    private javax.swing.JButton btnCerrarSesionBenefactor;
    private javax.swing.JButton btnCerrarSesionBeneficiario;
    private javax.swing.JButton btnEliminarDonativo;
    private javax.swing.JLabel btnInicio;
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel btnRegistro;
    private javax.swing.JComboBox<String> cbxTipoUsuario;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblBienvenidoBenefactor;
    private javax.swing.JLabel lblBienvenidoBeneficiario;
    private javax.swing.JLabel lblConfirmContraseña;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblContraseñaRegistro;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblListaDonacionesDisponibles;
    private javax.swing.JLabel lblNoIdentificacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTituloInicio;
    private javax.swing.JLabel lblTituloRegistro;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel menuBenefactor;
    private javax.swing.JPanel menuBeneficiario;
    private javax.swing.JPanel menuInicioSesion;
    private javax.swing.JPanel menuRegistro;
    private javax.swing.JScrollPane scrollPaneBenefactor;
    private javax.swing.JScrollPane scrollPaneBeneficiario;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JTable tablaBeneficiario;
    private javax.swing.JTable tblDescripcion;
    private javax.swing.JTable tblDonacionesBenefactor;
    private javax.swing.JTable tblProductos;
    private javax.swing.JPasswordField txtConfirmContraseña;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JPasswordField txtContraseñaRegistro;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextArea txtObservacioDescrip;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
