package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Panel que permite crear o actualizar información de medicamentos en el sistema.
 * Incluye formulario con campos para nombre, descripción, tipo, precio, marca, vendedor, características,
 * stock, laboratorio, formato de medicamento y formato de venta. También permite seleccionar una imagen
 * del producto y contiene botones para crear, actualizar o eliminar medicamentos.
 * 
 * @author TuNombre
 * @version 1.0
 * @since 1.0
 */
public class PanelCrearMedicamento extends JPanel {
    /** Etiqueta para el campo de nombre del medicamento */
    private JLabel lblNombre;
    
    /** Etiqueta para el campo de descripción del medicamento */
    private JLabel lblDescripcion;
    
    /** Etiqueta para el campo de tipo de medicamento */
    private JLabel lblTipo;
    
    /** Etiqueta para el campo de precio */
    private JLabel lblPrecio;
    
    /** Etiqueta para el campo de marca */
    private JLabel lblMarca;
    
    /** Etiqueta para el campo de vendedor */
    private JLabel lblVendedor;
    
    /** Etiqueta para el campo de características */
    private JLabel lblCaracteristicas;
    
    /** Etiqueta para el campo de stock */
    private JLabel lblStock;
    
    /** Etiqueta para el campo de laboratorio */
    private JLabel lblLaboratorio;
    
    /** Etiqueta para el campo de formato de medicamento */
    private JLabel lblFormatoMedicamento;
    
    /** Etiqueta para el campo de formato de venta */
    private JLabel lblFormatoDeVenta;
    
    /** Campo de texto para el nombre del medicamento */
    private JTextArea txtNombre;
    
    /** Campo de texto para la descripción del medicamento */
    private JTextArea txtDescripcion;
    
    /** Campo de texto para el tipo de medicamento */
    private JTextArea txtTipo;
    
    /** Campo de texto para el precio */
    private JTextArea txtPrecio;
    
    /** Campo de texto para la marca */
    private JTextArea txtMarca;
    
    /** Campo de texto para el vendedor */
    private JTextArea txtVendedor;
    
    /** Campo de texto para las características */
    private JTextArea txtCaracteristicas;
    
    /** Campo de texto para el stock */
    private JTextArea txtStock;
    
    /** Campo de texto para el laboratorio */
    private JTextArea txtLaboratorio;
    
    /** Combo box para seleccionar el formato de medicamento */
    private JComboBox<String> cmbFormatoMedicamento;
    
    /** Combo box para seleccionar el formato de venta */
    private JComboBox<String> cmbFormatoDeVenta;
    
    /** Botón para crear un nuevo medicamento */
    private JButton btnCrearFarmacia;
    
    /** Botón para seleccionar una imagen del producto */
    private JButton btnSeleccionarImagen;
    
    /** Botón para actualizar información de un medicamento existente */
    private JButton btnActualizarMedicamento;
    
    /** Botón para eliminar un medicamento existente */
    private JButton btnBorrarMedicamento;
    
    /** Etiqueta para mostrar la vista previa de la imagen seleccionada */
    private JLabel lblImagenPreview;
    
    /** Archivo de imagen seleccionado por el usuario */
    private File imagenSeleccionada;
    
    // Colores estilo MercadoLibre
    /** Color de fondo del panel */
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    
    /** Color para paneles blancos */
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    
    /** Color para texto principal */
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    
    /** Color para texto secundario */
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    
    /** Color para bordes de campos */
    private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
    
    /** Color para botones principales */
    private final Color COLOR_BOTON = new Color(52, 131, 250);
    
    /** Color para botones de eliminación */
    private final Color COLOR_BOTON_ELIMINAR = new Color(220, 53, 69);

    /**
     * Constructor por defecto que inicializa el panel con sus componentes.
     */
    public PanelCrearMedicamento() {
        this.setVisible(true);
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1280, 800);
        inicializarComponentes();
    }

    /**
     * Inicializa todos los componentes del panel.
     * Crea el panel principal con scroll, el panel de contenido y organiza
     * los paneles izquierdo (imagen) y derecho (formulario).
     */
    public void inicializarComponentes() {
        // Panel principal con scroll
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_FONDO);
        
        // Panel de contenido
        JPanel contentPanel = new JPanel(new BorderLayout(40, 0));
        contentPanel.setBackground(COLOR_FONDO);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        // Panel izquierdo - Imagen
        JPanel leftPanel = crearPanelImagen();
        
        // Panel derecho - Formulario
        JPanel rightPanel = crearPanelFormulario();
        
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(rightPanel, BorderLayout.CENTER);
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Crear scroll
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * Crea el panel para la selección y vista previa de la imagen del medicamento.
     * 
     * @return JPanel configurado para mostrar la imagen y el botón de selección
     */
    private JPanel crearPanelImagen() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(COLOR_PANEL_BLANCO);
        imagePanel.setPreferredSize(new Dimension(500, 700));
        imagePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        
        // Contenedor de la imagen
        JPanel imageContainer = new JPanel(new BorderLayout());
        imageContainer.setBackground(new Color(248, 248, 248));
        imageContainer.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));
        imageContainer.setPreferredSize(new Dimension(400, 400));
        
        // Label para mostrar imagen o placeholder
        lblImagenPreview = new JLabel();
        lblImagenPreview.setHorizontalAlignment(JLabel.CENTER);
        lblImagenPreview.setVerticalAlignment(JLabel.CENTER);
        lblImagenPreview.setOpaque(true);
        lblImagenPreview.setBackground(new Color(248, 248, 248));
        
        // Texto placeholder
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>" +
                                "<div style='font-size: 60px; margin-bottom: 10px;'>💊</div>" +
                                "<div style='font-size: 16px; font-weight: bold;'>IMAGEN NO DISPONIBLE</div>" +
                                "</html>");
        
        imageContainer.add(lblImagenPreview, BorderLayout.CENTER);
        
        // Botón seleccionar imagen
        btnSeleccionarImagen = new JButton("Seleccionar imagen del medicamento");
        btnSeleccionarImagen.setFont(new Font("Arial", Font.BOLD, 14));
        btnSeleccionarImagen.setBackground(COLOR_PANEL_BLANCO);
        btnSeleccionarImagen.setForeground(COLOR_BOTON);
        btnSeleccionarImagen.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BOTON, 2),
            BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));
        btnSeleccionarImagen.setFocusPainted(false);
        btnSeleccionarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Efecto hover del botón imagen
        btnSeleccionarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSeleccionarImagen.setBackground(new Color(240, 247, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSeleccionarImagen.setBackground(COLOR_PANEL_BLANCO);
            }
        });
        
        // ActionListener para seleccionar imagen
        btnSeleccionarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        
        // Panel para el botón
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(COLOR_PANEL_BLANCO);
        buttonPanel.add(btnSeleccionarImagen);
        
        imagePanel.add(imageContainer, BorderLayout.CENTER);
        imagePanel.add(Box.createVerticalStrut(20), BorderLayout.SOUTH);
        imagePanel.add(buttonPanel, BorderLayout.PAGE_END);
        
        return imagePanel;
    }
    
    /**
     * Crea el panel que contiene el formulario para ingresar datos del medicamento.
     * 
     * @return JPanel configurado con todos los campos del formulario
     */
    private JPanel crearPanelFormulario() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(COLOR_PANEL_BLANCO);
        formPanel.setPreferredSize(new Dimension(600, 1000));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        
        // Inicializar componentes del formulario
        inicializarCamposFormulario();
        posicionarComponentesFormulario(formPanel);
        
        return formPanel;
    }
    
    /**
     * Inicializa todos los campos del formulario (etiquetas, áreas de texto, combos y botones).
     */
    private void inicializarCamposFormulario(){
        // Labels
        lblNombre = crearLabel("Nombre");
        lblDescripcion = crearLabel("Descripción");
        lblTipo = crearLabel("Tipo");
        lblPrecio = crearLabel("Precio");
        lblMarca = crearLabel("Marca");
        lblVendedor = crearLabel("Vendedor");
        lblCaracteristicas = crearLabel("Características");
        lblStock = crearLabel("Stock");
        lblLaboratorio = crearLabel("Laboratorio");
        lblFormatoMedicamento = crearLabel("Formato medicamento");
        lblFormatoDeVenta = crearLabel("Formato de venta");

        // TextAreas
        txtNombre = crearTextArea();
        txtDescripcion = crearTextAreaGrande();
        txtTipo = crearTextArea();
        txtPrecio = crearTextArea();
        txtMarca = crearTextArea();
        txtVendedor = crearTextArea();
        txtCaracteristicas = crearTextAreaGrande();
        txtStock = crearTextArea();
        txtLaboratorio = crearTextArea();

        // ComboBoxes
        cmbFormatoMedicamento = crearComboBox();
        cmbFormatoMedicamento.addItem("Tableta");
        cmbFormatoMedicamento.addItem("Cápsula");
        cmbFormatoMedicamento.addItem("Jarabe");
        cmbFormatoMedicamento.addItem("Inyección");
        cmbFormatoMedicamento.addItem("Crema");
        cmbFormatoMedicamento.addItem("Gel");
        cmbFormatoMedicamento.addItem("Gotas");

        cmbFormatoDeVenta = crearComboBox();
        cmbFormatoDeVenta.addItem("Unidad");
        cmbFormatoDeVenta.addItem("Caja");
        cmbFormatoDeVenta.addItem("Frasco");
        cmbFormatoDeVenta.addItem("Tubo");
        cmbFormatoDeVenta.addItem("Blister");

        // Botón principal
        btnCrearFarmacia = crearBotonPrincipal("Crear Medicamento");
        btnCrearFarmacia.setActionCommand("Crear Medicamento");

        btnActualizarMedicamento = crearBotonPrincipal("Actualizar");
        btnActualizarMedicamento.setActionCommand("Actualizar Medicamento");
        btnActualizarMedicamento.setVisible(false);

        btnBorrarMedicamento = crearBotonEliminar("Eliminar Producto");
        btnBorrarMedicamento.setActionCommand("Borrar Medicamento");
        btnBorrarMedicamento.setVisible(false);
    }
    
    /**
     * Posiciona todos los componentes del formulario en el panel especificado.
     * 
     * @param panel JPanel donde se posicionarán los componentes
     */
    private void posicionarComponentesFormulario(JPanel panel){
        int x = 20, yLabel = 20, yField = 45, gap = 65, fieldWidth = 480, fieldHeight = 35;

        // Título de sección
        JLabel titulo = new JLabel("Información del medicamento");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(COLOR_TEXTO_PRINCIPAL);
        titulo.setBounds(x, 0, 400, 25);
        panel.add(titulo);

        // Información básica
        lblNombre.setBounds(x, yLabel, 200, 20);
        txtNombre.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblMarca.setBounds(x, yLabel, 200, 20);
        txtMarca.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblDescripcion.setBounds(x, yLabel, 200, 20);
        txtDescripcion.setBounds(x, yField, fieldWidth, 60);

        yLabel += 85;
        yField += 85;
        lblTipo.setBounds(x, yLabel, 200, 20);
        txtTipo.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblPrecio.setBounds(x, yLabel, 200, 20);
        txtPrecio.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblVendedor.setBounds(x, yLabel, 200, 20);
        txtVendedor.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblCaracteristicas.setBounds(x, yLabel, 200, 20);
        txtCaracteristicas.setBounds(x, yField, fieldWidth, 60);

        yLabel += 85;
        yField += 85;
        lblStock.setBounds(x, yLabel, 200, 20);
        txtStock.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblLaboratorio.setBounds(x, yLabel, 200, 20);
        txtLaboratorio.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblFormatoMedicamento.setBounds(x, yLabel, 200, 20);
        cmbFormatoMedicamento.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblFormatoDeVenta.setBounds(x, yLabel, 200, 20);
        cmbFormatoDeVenta.setBounds(x, yField, fieldWidth, fieldHeight);

        // Posicionar botones con coordenadas absolutas
        btnCrearFarmacia.setBounds((panel.getPreferredSize().width - 180) / 2, yField + 80, 180, 45);
        btnActualizarMedicamento.setBounds((panel.getPreferredSize().width - 380) / 2, yField + 80, 180, 45);
        btnBorrarMedicamento.setBounds((panel.getPreferredSize().width + 100) / 2, yField + 80, 180, 45);

        // Agregar todos los componentes
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblMarca);
        panel.add(txtMarca);
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblTipo);
        panel.add(txtTipo);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(lblVendedor);
        panel.add(txtVendedor);
        panel.add(lblCaracteristicas);
        panel.add(txtCaracteristicas);
        panel.add(lblStock);
        panel.add(txtStock);
        panel.add(lblLaboratorio);
        panel.add(txtLaboratorio);
        panel.add(lblFormatoMedicamento);
        panel.add(cmbFormatoMedicamento);
        panel.add(lblFormatoDeVenta);
        panel.add(cmbFormatoDeVenta);
        panel.add(btnCrearFarmacia);
        panel.add(btnActualizarMedicamento);
        panel.add(btnBorrarMedicamento);
    }
    
    /**
     * Abre un diálogo para seleccionar una imagen del medicamento.
     * Permite filtrar por tipos de archivo de imagen válidos (jpg, jpeg, png, gif).
     * Si se selecciona una imagen, la muestra en la vista previa.
     */
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen del medicamento");
        
        // Filtro para imágenes
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Archivos de imagen (*.jpg, *.jpeg, *.png, *.gif)", 
            "jpg", "jpeg", "png", "gif"
        );
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        int resultado = fileChooser.showOpenDialog(this);
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            imagenSeleccionada = fileChooser.getSelectedFile();
            
            try {
                // Cargar y redimensionar imagen
                ImageIcon originalIcon = new ImageIcon(imagenSeleccionada.getAbsolutePath());
                Image img = originalIcon.getImage();
                Image scaledImg = img.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                
                lblImagenPreview.setText("");
                lblImagenPreview.setIcon(scaledIcon);
                
            } catch (Exception e) {
                lblImagenPreview.setText("<html><div style='text-align: center; color: red;'>" +
                                        "Error al cargar imagen</div></html>");
            }
        }
    }
    
    // Métodos para crear componentes con estilo
    
    /**
     * Crea una etiqueta con el texto y estilo predefinidos.
     * 
     * @param texto Texto que mostrará la etiqueta
     * @return JLabel configurada con el estilo predefinido
     */
    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(COLOR_TEXTO_PRINCIPAL);
        return label;
    }
    
    /**
     * Crea un área de texto con el estilo predefinido.
     * 
     * @return JTextArea configurada con el estilo predefinido
     */
    private JTextArea crearTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBackground(COLOR_PANEL_BLANCO);
        textArea.setForeground(COLOR_TEXTO_PRINCIPAL);
        textArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        aplicarEfectoFocus(textArea);
        return textArea;
    }
    
    /**
     * Crea un área de texto grande con el estilo predefinido.
     * 
     * @return JTextArea configurada con el estilo predefinido para campos grandes
     */
    private JTextArea crearTextAreaGrande() {
        JTextArea textArea = crearTextArea();
        return textArea;
    }
    
    /**
     * Crea un combo box con el estilo predefinido.
     * 
     * @return JComboBox configurado con el estilo predefinido
     */
    private JComboBox<String> crearComboBox() {
        JComboBox<String> combo = new JComboBox<>();
        combo.setFont(new Font("Arial", Font.PLAIN, 14));
        combo.setBackground(COLOR_PANEL_BLANCO);
        combo.setForeground(COLOR_TEXTO_PRINCIPAL);
        combo.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));
        aplicarEfectoFocusComboBox(combo);
        return combo;
    }
    
    /**
     * Crea un botón principal con el estilo predefinido.
     * 
     * @param texto Texto que mostrará el botón
     * @return JButton configurado con el estilo predefinido para botones principales
     */
    private JButton crearBotonPrincipal(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(COLOR_BOTON);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        boton.setFocusPainted(false);
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(45, 115, 220));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(COLOR_BOTON);
            }
        });
        
        return boton;
    }
    
    /**
     * Crea un botón de eliminación con el estilo predefinido.
     * 
     * @param texto Texto que mostrará el botón
     * @return JButton configurado con el estilo predefinido para botones de eliminación
     */
    private JButton crearBotonEliminar(String texto){
        JButton boton= new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(COLOR_BOTON_ELIMINAR);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        boton.setFocusPainted(false);
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                boton.setBackground(new Color(190, 30, 45));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                boton.setBackground(COLOR_BOTON_ELIMINAR);
            }
        });

        return boton;
    }
    
    /**
     * Aplica un efecto visual de focus al área de texto especificada.
     * 
     * @param textArea JTextArea al que se le aplicará el efecto
     */
    private void aplicarEfectoFocus(JTextArea textArea) {
        textArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textArea.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textArea.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
    
    /**
     * Aplica un efecto visual de focus al combo box especificado.
     * 
     * @param comboBox JComboBox al que se le aplicará el efecto
     */
    private void aplicarEfectoFocusComboBox(JComboBox<String> comboBox) {
        comboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBox.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBox.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
    
    /**
     * Limpia todos los campos del formulario, restableciendo sus valores por defecto.
     * También restablece la vista previa de la imagen y elimina la imagen seleccionada.
     */
    public void limpiarFormulario() {
        getTxtNombre().setText("");
        getTxtDescripcion().setText("");
        getTxtTipo().setText("");
        getTxtPrecio().setText("");
        getTxtMarca().setText("");
        getTxtVendedor().setText("");
        getTxtCaracteristicas().setText("");
        getTxtStock().setText("");
        getTxtLaboratorio().setText("");
        getCmbFormatoMedicamento().setSelectedIndex(0);
        getCmbFormatoDeVenta().setSelectedIndex(0);
        
        // Reiniciar la imagen
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>"
                + "<div style='font-size: 60px; margin-bottom: 10px;'>💊</div>"
                + "<div style='font-size: 16px; font-weight: bold;'>IMAGEN NO DISPONIBLE</div>"
                + "</html>");
        lblImagenPreview.setIcon(null);
        imagenSeleccionada = null;
    }

    // Getters y Setters con Javadoc
    
    /**
     * Obtiene la etiqueta del campo nombre.
     * 
     * @return JLabel del campo nombre
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     * Establece la etiqueta del campo nombre.
     * 
     * @param lblNombre JLabel del campo nombre
     */
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    /**
     * Obtiene la etiqueta del campo descripción.
     * 
     * @return JLabel del campo descripción
     */
    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    /**
     * Establece la etiqueta del campo descripción.
     * 
     * @param lblDescripcion JLabel del campo descripción
     */
    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    /**
     * Obtiene la etiqueta del campo tipo.
     * 
     * @return JLabel del campo tipo
     */
    public JLabel getLblTipo() {
        return lblTipo;
    }

    /**
     * Establece la etiqueta del campo tipo.
     * 
     * @param lblTipo JLabel del campo tipo
     */
    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    /**
     * Obtiene la etiqueta del campo precio.
     * 
     * @return JLabel del campo precio
     */
    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    /**
     * Establece la etiqueta del campo precio.
     * 
     * @param lblPrecio JLabel del campo precio
     */
    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    /**
     * Obtiene la etiqueta del campo marca.
     * 
     * @return JLabel del campo marca
     */
    public JLabel getLblMarca() {
        return lblMarca;
    }

    /**
     * Establece la etiqueta del campo marca.
     * 
     * @param lblMarca JLabel del campo marca
     */
    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    /**
     * Obtiene la etiqueta del campo vendedor.
     * 
     * @return JLabel del campo vendedor
     */
    public JLabel getLblVendedor() {
        return lblVendedor;
    }

    /**
     * Establece la etiqueta del campo vendedor.
     * 
     * @param lblVendedor JLabel del campo vendedor
     */
    public void setLblVendedor(JLabel lblVendedor) {
        this.lblVendedor = lblVendedor;
    }

    /**
     * Obtiene la etiqueta del campo características.
     * 
     * @return JLabel del campo características
     */
    public JLabel getLblCaracteristicas() {
        return lblCaracteristicas;
    }

    /**
     * Establece la etiqueta del campo características.
     * 
     * @param lblCaracteristicas JLabel del campo características
     */
    public void setLblCaracteristicas(JLabel lblCaracteristicas) {
        this.lblCaracteristicas = lblCaracteristicas;
    }

    /**
     * Obtiene la etiqueta del campo stock.
     * 
     * @return JLabel del campo stock
     */
    public JLabel getLblStock() {
        return lblStock;
    }

    /**
     * Establece la etiqueta del campo stock.
     * 
     * @param lblStock JLabel del campo stock
     */
    public void setLblStock(JLabel lblStock) {
        this.lblStock = lblStock;
    }

    /**
     * Obtiene la etiqueta del campo laboratorio.
     * 
     * @return JLabel del campo laboratorio
     */
    public JLabel getLblLaboratorio() {
        return lblLaboratorio;
    }

    /**
     * Establece la etiqueta del campo laboratorio.
     * 
     * @param lblLaboratorio JLabel del campo laboratorio
     */
    public void setLblLaboratorio(JLabel lblLaboratorio) {
        this.lblLaboratorio = lblLaboratorio;
    }

    /**
     * Obtiene la etiqueta del campo formato de medicamento.
     * 
     * @return JLabel del campo formato de medicamento
     */
    public JLabel getLblFormatoMedicamento() {
        return lblFormatoMedicamento;
    }

    /**
     * Establece la etiqueta del campo formato de medicamento.
     * 
     * @param lblFormatoMedicamento JLabel del campo formato de medicamento
     */
    public void setLblFormatoMedicamento(JLabel lblFormatoMedicamento) {
        this.lblFormatoMedicamento = lblFormatoMedicamento;
    }

    /**
     * Obtiene la etiqueta del campo formato de venta.
     * 
     * @return JLabel del campo formato de venta
     */
    public JLabel getLblFormatoDeVenta() {
        return lblFormatoDeVenta;
    }

    /**
     * Establece la etiqueta del campo formato de venta.
     * 
     * @param lblFormatoDeVenta JLabel del campo formato de venta
     */
    public void setLblFormatoDeVenta(JLabel lblFormatoDeVenta) {
        this.lblFormatoDeVenta = lblFormatoDeVenta;
    }

    /**
     * Obtiene el campo de texto para el nombre.
     * 
     * @return JTextArea para el nombre
     */
    public JTextArea getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto para el nombre.
     * 
     * @param txtNombre JTextArea para el nombre
     */
    public void setTxtNombre(JTextArea txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Obtiene el campo de texto para la descripción.
     * 
     * @return JTextArea para la descripción
     */
    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    /**
     * Establece el campo de texto para la descripción.
     * 
     * @param txtDescripcion JTextArea para la descripción
     */
    public void setTxtDescripcion(JTextArea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    /**
     * Obtiene el campo de texto para el tipo.
     * 
     * @return JTextArea para el tipo
     */
    public JTextArea getTxtTipo() {
        return txtTipo;
    }

    /**
     * Establece el campo de texto para el tipo.
     * 
     * @param txtTipo JTextArea para el tipo
     */
    public void setTxtTipo(JTextArea txtTipo) {
        this.txtTipo = txtTipo;
    }

    /**
     * Obtiene el campo de texto para el precio.
     * 
     * @return JTextArea para el precio
     */
    public JTextArea getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * Establece el campo de texto para el precio.
     * 
     * @param txtPrecio JTextArea para el precio
     */
    public void setTxtPrecio(JTextArea txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    /**
     * Obtiene el campo de texto para la marca.
     * 
     * @return JTextArea para la marca
     */
    public JTextArea getTxtMarca() {
        return txtMarca;
    }

    /**
     * Establece el campo de texto para la marca.
     * 
     * @param txtMarca JTextArea para la marca
     */
    public void setTxtMarca(JTextArea txtMarca) {
        this.txtMarca = txtMarca;
    }

    /**
     * Obtiene el campo de texto para el vendedor.
     * 
     * @return JTextArea para el vendedor
     */
    public JTextArea getTxtVendedor() {
        return txtVendedor;
    }

    /**
     * Establece el campo de texto para el vendedor.
     * 
     * @param txtVendedor JTextArea para el vendedor
     */
    public void setTxtVendedor(JTextArea txtVendedor) {
        this.txtVendedor = txtVendedor;
    }

    /**
     * Obtiene el campo de texto para las características.
     * 
     * @return JTextArea para las características
     */
    public JTextArea getTxtCaracteristicas() {
        return txtCaracteristicas;
    }

    /**
     * Establece el campo de texto para las características.
     * 
     * @param txtCaracteristicas JTextArea para las características
     */
    public void setTxtCaracteristicas(JTextArea txtCaracteristicas) {
        this.txtCaracteristicas = txtCaracteristicas;
    }

    /**
     * Obtiene el campo de texto para el stock.
     * 
     * @return JTextArea para el stock
     */
    public JTextArea getTxtStock() {
        return txtStock;
    }

    /**
     * Establece el campo de texto para el stock.
     * 
     * @param txtStock JTextArea para el stock
     */
    public void setTxtStock(JTextArea txtStock) {
        this.txtStock = txtStock;
    }

    /**
     * Obtiene el campo de texto para el laboratorio.
     * 
     * @return JTextArea para el laboratorio
     */
    public JTextArea getTxtLaboratorio() {
        return txtLaboratorio;
    }

    /**
     * Establece el campo de texto para el laboratorio.
     * 
     * @param txtLaboratorio JTextArea para el laboratorio
     */
    public void setTxtLaboratorio(JTextArea txtLaboratorio) {
        this.txtLaboratorio = txtLaboratorio;
    }

    /**
     * Obtiene el combo box para el formato de medicamento.
     * 
     * @return JComboBox para el formato de medicamento
     */
    public JComboBox<String> getCmbFormatoMedicamento() {
        return cmbFormatoMedicamento;
    }

    /**
     * Establece el combo box para el formato de medicamento.
     * 
     * @param cmbFormatoMedicamento JComboBox para el formato de medicamento
     */
    public void setCmbFormatoMedicamento(JComboBox<String> cmbFormatoMedicamento) {
        this.cmbFormatoMedicamento = cmbFormatoMedicamento;
    }

    /**
     * Obtiene el combo box para el formato de venta.
     * 
     * @return JComboBox para el formato de venta
     */
    public JComboBox<String> getCmbFormatoDeVenta() {
        return cmbFormatoDeVenta;
    }

    /**
     * Establece el combo box para el formato de venta.
     * 
     * @param cmbFormatoDeVenta JComboBox para el formato de venta
     */
    public void setCmbFormatoDeVenta(JComboBox<String> cmbFormatoDeVenta) {
        this.cmbFormatoDeVenta = cmbFormatoDeVenta;
    }

    /**
     * Obtiene el botón para crear medicamento.
     * 
     * @return JButton para crear medicamento
     */
    public JButton getBtnCrearFarmacia() {
        return btnCrearFarmacia;
    }

    /**
     * Establece el botón para crear medicamento.
     * 
     * @param btnCrearFarmacia JButton para crear medicamento
     */
    public void setBtnCrearFarmacia(JButton btnCrearFarmacia) {
        this.btnCrearFarmacia = btnCrearFarmacia;
    }

    /**
     * Obtiene el botón para seleccionar imagen.
     * 
     * @return JButton para seleccionar imagen
     */
    public JButton getBtnSeleccionarImagen() {
        return btnSeleccionarImagen;
    }

    /**
     * Establece el botón para seleccionar imagen.
     * 
     * @param btnSeleccionarImagen JButton para seleccionar imagen
     */
    public void setBtnSeleccionarImagen(JButton btnSeleccionarImagen) {
        this.btnSeleccionarImagen = btnSeleccionarImagen;
    }

    /**
     * Obtiene la etiqueta para la vista previa de la imagen.
     * 
     * @return JLabel para la vista previa de la imagen
     */
    public JLabel getLblImagenPreview() {
        return lblImagenPreview;
    }

    /**
     * Establece la etiqueta para la vista previa de la imagen.
     * 
     * @param lblImagenPreview JLabel para la vista previa de la imagen
     */
    public void setLblImagenPreview(JLabel lblImagenPreview) {
        this.lblImagenPreview = lblImagenPreview;
    }

    /**
     * Obtiene el archivo de imagen seleccionado.
     * 
     * @return File con la imagen seleccionada
     */
    public File getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    /**
     * Establece el archivo de imagen seleccionado.
     * 
     * @param imagenSeleccionada File con la imagen seleccionada
     */
    public void setImagenSeleccionada(File imagenSeleccionada) {
        this.imagenSeleccionada = imagenSeleccionada;
    }

    /**
     * Obtiene el botón para actualizar medicamento.
     * 
     * @return JButton para actualizar medicamento
     */
    public JButton getBtnActualizarMedicamento() {
        return btnActualizarMedicamento;
    }

    /**
     * Obtiene el botón para borrar medicamento.
     * 
     * @return JButton para borrar medicamento
     */
    public JButton getBtnBorrarMedicamento() {
        return btnBorrarMedicamento;
    }
}