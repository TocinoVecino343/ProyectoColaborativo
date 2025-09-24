package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
 * Panel para crear y editar productos de construcción.
 * Permite ingresar información detallada del material de construcción incluyendo imagen,
 * datos básicos, especificaciones técnicas y dimensiones.
 * 
 * @author TuNombre
 * @version 1.0
 * @since 1.0
 */
public class PanelCrearConstruccion extends JPanel {
    /** Etiqueta para el campo nombre del material */
    private JLabel lblNombre;
    
    /** Etiqueta para el campo descripción del material */
    private JLabel lblDescripcion;
    
    /** Etiqueta para el campo tipo del material */
    private JLabel lblTipo;
    
    /** Etiqueta para el campo precio del material */
    private JLabel lblPrecio;
    
    /** Etiqueta para el campo marca del material */
    private JLabel lblMarca;
    
    /** Etiqueta para el campo características del material */
    private JLabel lblCaracteristicas;
    
    /** Etiqueta para el campo stock del material */
    private JLabel lblStock;
    
    /** Etiqueta para el campo modelo del material */
    private JLabel lblModelo;
    
    /** Etiqueta para el campo material del material */
    private JLabel lblMaterial;
    
    /** Etiqueta para el campo color del material */
    private JLabel lblColor;
    
    /** Etiqueta para el campo largo del material */
    private JLabel lblLargo;
    
    /** Etiqueta para el campo ancho del material */
    private JLabel lblAncho;
    
    /** Etiqueta para el campo altura del material */
    private JLabel lblAltura;
    
    /** Campo de texto para el nombre del material */
    private JTextArea txtNombre;
    
    /** Campo de texto para la descripción del material */
    private JTextArea txtDescripcion;
    
    /** Campo de texto para el tipo del material */
    private JTextArea txtTipo;
    
    /** Campo de texto para el precio del material */
    private JTextArea txtPrecio;
    
    /** Campo de texto para la marca del material */
    private JTextArea txtMarca;
    
    /** Campo de texto para las características del material */
    private JTextArea txtCaracteristicas;
    
    /** Campo de texto para el material del material */
    private JTextArea txtMaterial;
    
    /** Campo de texto para el stock del material */
    private JTextArea txtStock;
    
    /** Campo de texto para el color del material */
    private JTextArea txtColor;
    
    /** Campo de texto para el modelo del material */
    private JTextArea txtModelo;
    
    /** ComboBox para seleccionar el tipo de material */
    private JComboBox<String> cmbMaterial;
    
    /** Campo formateado para el largo del material */
    private JFormattedTextField txtLargo;
    
    /** Campo formateado para el ancho del material */
    private JFormattedTextField txtAncho;
    
    /** Campo formateado para la altura del material */
    private JFormattedTextField txtAltura;
    
    /** Botón para crear un nuevo material */
    private JButton btnCrearConstruccion;
    
    /** Botón para seleccionar la imagen del material */
    private JButton btnSeleccionarImagen;
    
    /** Botón para actualizar un material existente */
    private JButton btnActualizarConstruccion;
    
    /** Botón para borrar un material existente */
    private JButton btnBorrarConstruccion;
    
    /** Etiqueta para mostrar la vista previa de la imagen del material */
    private JLabel lblImagenPreview;
    
    /** Archivo de imagen seleccionado para el material */
    private File imagenSeleccionada;
    
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
     * Constructor por defecto que inicializa el panel.
     * Configura el tamaño, color de fondo y layout del panel.
     */
    public PanelCrearConstruccion() {
        this.setVisible(true);
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1280, 920);
        inicializarComponentes();
    }

    /**
     * Inicializa todos los componentes del panel.
     * Crea el panel principal con scroll y añade los paneles izquierdo (imagen) 
     * y derecho (formulario).
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
     * Crea el panel izquierdo para mostrar la imagen del material.
     * Incluye un contenedor para la imagen y un botón para seleccionar imagen.
     * 
     * @return JPanel configurado para mostrar la imagen del material
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
                                "<div style='font-size: 60px; margin-bottom: 10px;'>🏗️</div>" +
                                "<div style='font-size: 16px; font-weight: bold;'>IMAGEN NO DISPONIBLE</div>" +
                                "</html>");
        
        imageContainer.add(lblImagenPreview, BorderLayout.CENTER);
        
        // Botón seleccionar imagen
        btnSeleccionarImagen = new JButton("Seleccionar imagen del material");
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
     * Crea el panel derecho con el formulario para ingresar datos del material.
     * Inicializa y posiciona todos los campos del formulario.
     * 
     * @return JPanel configurado con el formulario del material
     */
    private JPanel crearPanelFormulario() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(COLOR_PANEL_BLANCO);
        formPanel.setPreferredSize(new Dimension(600, 1100));
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
     * Inicializa todos los campos del formulario (etiquetas, campos de texto, combobox y botones).
     * Configura las propiedades visuales y comportamientos de cada componente.
     */
    private void inicializarCamposFormulario() {
        // Labels
        lblNombre = crearLabel("Nombre");
        lblDescripcion = crearLabel("Descripción"); 
        lblTipo = crearLabel("Tipo");
        lblPrecio = crearLabel("Precio");
        lblMarca = crearLabel("Marca");
        lblCaracteristicas = crearLabel("Características");
        lblStock = crearLabel("Stock");
        lblModelo = crearLabel("Modelo");
        lblMaterial = crearLabel("Material");
        lblColor = crearLabel("Color");
        lblLargo = crearLabel("Largo (m)");
        lblAncho = crearLabel("Ancho (m)");
        lblAltura = crearLabel("Altura (m)");

        // TextAreas
        txtNombre = crearTextArea();
        txtDescripcion = crearTextAreaGrande();
        txtTipo = crearTextArea();
        txtPrecio = crearTextArea();
        txtMarca = crearTextArea();
        txtCaracteristicas = crearTextAreaGrande();
        txtStock = crearTextArea();
        txtColor = crearTextArea();
        txtModelo = crearTextArea();

        // ComboBox de materiales
        cmbMaterial = crearComboBox();
        cmbMaterial.addItem("Cemento");
        cmbMaterial.addItem("Concreto");
        cmbMaterial.addItem("Ladrillo");
        cmbMaterial.addItem("Madera");
        cmbMaterial.addItem("Acero");
        cmbMaterial.addItem("Hierro");
        cmbMaterial.addItem("Plástico");
        cmbMaterial.addItem("Vidrio");
        cmbMaterial.addItem("Cerámica");
        cmbMaterial.addItem("Piedra natural");
        cmbMaterial.addItem("Panel de yeso");
        cmbMaterial.addItem("Yeso");
        cmbMaterial.addItem("Impermeabilizante");
        cmbMaterial.addItem("Sellador");
        cmbMaterial.addItem("Pintura");

        // Campos formateados para dimensiones
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        txtLargo = new JFormattedTextField(numberFormat);
        txtAncho = new JFormattedTextField(numberFormat);
        txtAltura = new JFormattedTextField(numberFormat);
        
        aplicarEstiloTextField(txtLargo);
        aplicarEstiloTextField(txtAncho);
        aplicarEstiloTextField(txtAltura);

        // Botón principal
        btnCrearConstruccion = crearBotonPrincipal("Crear Construcción");
        btnCrearConstruccion.setActionCommand("Crear Construccion");
        btnActualizarConstruccion = new JButton("Actualizar");
        btnActualizarConstruccion.setVisible(false); // Inicialmente oculto
        btnBorrarConstruccion = new JButton("Borrar");
        btnBorrarConstruccion.setVisible(false); // Inicialmente oculto

        btnCrearConstruccion= crearBotonPrincipal("Crear Construcción");
        btnCrearConstruccion.setActionCommand("Crear Construccion");

        btnActualizarConstruccion= crearBotonPrincipal("Actualizar");
        btnActualizarConstruccion.setActionCommand("Actualizar Construccion");
        btnActualizarConstruccion.setVisible(false);

        btnBorrarConstruccion= crearBotonEliminar("Eliminar Producto");
        btnBorrarConstruccion.setActionCommand("Borrar Construccion");
        btnBorrarConstruccion.setVisible(false);
    }
    
    /**
     * Posiciona todos los componentes del formulario en el panel.
     * Establece las coordenadas y dimensiones de cada elemento.
     * 
     * @param panel JPanel donde se posicionarán los componentes
     */
    private void posicionarComponentesFormulario(JPanel panel){
        int x = 20, yLabel = 20, yField = 45, gap = 65, fieldWidth = 480, fieldHeight = 35;

        // Título de sección
        JLabel titulo = new JLabel("Información del material de construcción");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(COLOR_TEXTO_PRINCIPAL);
        titulo.setBounds(x, 0, 450, 25);
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
        lblModelo.setBounds(x, yLabel, 200, 20);
        txtModelo.setBounds(x, yField, fieldWidth, fieldHeight);

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
        lblCaracteristicas.setBounds(x, yLabel, 200, 20);
        txtCaracteristicas.setBounds(x, yField, fieldWidth, 60);

        yLabel += 85;
        yField += 85;
        lblStock.setBounds(x, yLabel, 200, 20);
        txtStock.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblColor.setBounds(x, yLabel, 200, 20);
        txtColor.setBounds(x, yField, fieldWidth, fieldHeight);

        // Especificaciones del material
        yLabel += gap;
        yField += gap;
        lblMaterial.setBounds(x, yLabel, 200, 20);
        cmbMaterial.setBounds(x, yField, fieldWidth, fieldHeight);

        // Dimensiones
        yLabel += gap;
        yField += gap;
        lblLargo.setBounds(x, yLabel, 200, 20);
        txtLargo.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblAncho.setBounds(x, yLabel, 200, 20);
        txtAncho.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblAltura.setBounds(x, yLabel, 200, 20);
        txtAltura.setBounds(x, yField, fieldWidth, fieldHeight);

        btnCrearConstruccion.setBounds((panel.getPreferredSize().width - 180) / 2, yField + 80, 180, 45);
        btnActualizarConstruccion.setBounds((panel.getPreferredSize().width - 380) / 2, yField + 80, 180, 45);
        btnBorrarConstruccion.setBounds((panel.getPreferredSize().width + 100) / 2, yField + 80, 180, 45);

        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblMarca);
        panel.add(txtMarca);
        panel.add(lblModelo);
        panel.add(txtModelo);
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblTipo);
        panel.add(txtTipo);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(lblCaracteristicas);
        panel.add(txtCaracteristicas);
        panel.add(lblStock);
        panel.add(txtStock);
        panel.add(lblColor);
        panel.add(txtColor);
        panel.add(lblMaterial);
        panel.add(cmbMaterial);
        panel.add(lblLargo);
        panel.add(txtLargo);
        panel.add(lblAncho);
        panel.add(txtAncho);
        panel.add(lblAltura);
        panel.add(txtAltura);
        panel.add(btnCrearConstruccion);
        panel.add(btnActualizarConstruccion);
        panel.add(btnBorrarConstruccion);
    }
    
    /**
     * Abre un selector de archivos para elegir una imagen para el material.
     * Filtra solo archivos de imagen y muestra una vista previa en el panel.
     */
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen del material de construcción");
        
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
    
    /**
     * Crea una etiqueta con el estilo estándar del formulario.
     * 
     * @param texto Texto que mostrará la etiqueta
     * @return JLabel configurada con el estilo estándar
     */
    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(COLOR_TEXTO_PRINCIPAL);
        return label;
    }
    
    /**
     * Crea un campo de texto con el estilo estándar del formulario.
     * 
     * @return JTextArea configurada con el estilo estándar
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
     * Crea un campo de texto grande con el estilo estándar del formulario.
     * 
     * @return JTextArea configurada para mayor tamaño
     */
    private JTextArea crearTextAreaGrande() {
        JTextArea textArea = crearTextArea();
        return textArea;
    }
    
    /**
     * Crea un ComboBox con el estilo estándar del formulario.
     * 
     * @return JComboBox configurado con el estilo estándar
     */
    private JComboBox<String> crearComboBox() {
        JComboBox<String> combo = new JComboBox<>();
        combo.setFont(new Font("Arial", Font.PLAIN, 14));
        combo.setBackground(COLOR_PANEL_BLANCO);
        combo.setForeground(COLOR_TEXTO_PRINCIPAL);
        combo.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));
        return combo;
    }
    
    /**
     * Aplica estilo estándar a un campo de texto formateado.
     * 
     * @param textField JFormattedTextField al que se le aplicará el estilo
     */
    private void aplicarEstiloTextField(JFormattedTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(COLOR_PANEL_BLANCO);
        textField.setForeground(COLOR_TEXTO_PRINCIPAL);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        aplicarEfectoFocusTextField(textField);
    }
    
    /**
     * Crea un botón principal con el estilo estándar del formulario.
     * 
     * @param texto Texto que mostrará el botón
     * @return JButton configurado con el estilo principal
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
     * Crea un botón de eliminación con el estilo estándar del formulario.
     * 
     * @param texto Texto que mostrará el botón
     * @return JButton configurado con el estilo de eliminación
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
     * Aplica un efecto visual cuando un JTextArea recibe o pierde el foco.
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
     * Aplica un efecto visual cuando un JFormattedTextField recibe o pierde el foco.
     * 
     * @param textField JFormattedTextField al que se le aplicará el efecto
     */
    private void aplicarEfectoFocusTextField(JFormattedTextField textField) {
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
    
    /**
     * Limpia todos los campos del formulario y restaura los valores por defecto.
     * Restablece la vista previa de la imagen a su estado inicial.
     */
    public void limpiarFormulario() {
        getTxtNombre().setText("");
        getTxtDescripcion().setText("");
        getTxtTipo().setText("");
        getTxtPrecio().setText("");
        getTxtMarca().setText("");
        getTxtCaracteristicas().setText("");
        getTxtStock().setText("");
        getTxtModelo().setText("");
        getCmbMaterial().setSelectedIndex(0);
        getTxtColor().setText("");
        getTxtLargo().setText("");
        getTxtAncho().setText("");
        getTxtAltura().setText("");
        
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>"
                + "<div style='font-size: 60px; margin-bottom: 10px;'>🏗</div>"
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
     * Obtiene la etiqueta del campo modelo.
     * 
     * @return JLabel del campo modelo
     */
    public JLabel getLblModelo() {
        return lblModelo;
    }

    /**
     * Establece la etiqueta del campo modelo.
     * 
     * @param lblModelo JLabel del campo modelo
     */
    public void setLblModelo(JLabel lblModelo) {
        this.lblModelo = lblModelo;
    }

    /**
     * Obtiene la etiqueta del campo material.
     * 
     * @return JLabel del campo material
     */
    public JLabel getLblMaterial() {
        return lblMaterial;
    }

    /**
     * Establece la etiqueta del campo material.
     * 
     * @param lblMaterial JLabel del campo material
     */
    public void setLblMaterial(JLabel lblMaterial) {
        this.lblMaterial = lblMaterial;
    }

    /**
     * Obtiene la etiqueta del campo color.
     * 
     * @return JLabel del campo color
     */
    public JLabel getLblColor() {
        return lblColor;
    }

    /**
     * Establece la etiqueta del campo color.
     * 
     * @param lblColor JLabel del campo color
     */
    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    /**
     * Obtiene la etiqueta del campo largo.
     * 
     * @return JLabel del campo largo
     */
    public JLabel getLblLargo() {
        return lblLargo;
    }

    /**
     * Establece la etiqueta del campo largo.
     * 
     * @param lblLargo JLabel del campo largo
     */
    public void setLblLargo(JLabel lblLargo) {
        this.lblLargo = lblLargo;
    }

    /**
     * Obtiene la etiqueta del campo ancho.
     * 
     * @return JLabel del campo ancho
     */
    public JLabel getLblAncho() {
        return lblAncho;
    }

    /**
     * Establece la etiqueta del campo ancho.
     * 
     * @param lblAncho JLabel del campo ancho
     */
    public void setLblAncho(JLabel lblAncho) {
        this.lblAncho = lblAncho;
    }

    /**
     * Obtiene la etiqueta del campo altura.
     * 
     * @return JLabel del campo altura
     */
    public JLabel getLblAltura() {
        return lblAltura;
    }

    /**
     * Establece la etiqueta del campo altura.
     * 
     * @param lblAltura JLabel del campo altura
     */
    public void setLblAltura(JLabel lblAltura) {
        this.lblAltura = lblAltura;
    }

    /**
     * Obtiene el campo de texto del nombre.
     * 
     * @return JTextArea del campo nombre
     */
    public JTextArea getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto del nombre.
     * 
     * @param txtNombre JTextArea del campo nombre
     */
    public void setTxtNombre(JTextArea txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Obtiene el campo de texto de la descripción.
     * 
     * @return JTextArea del campo descripción
     */
    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    /**
     * Establece el campo de texto de la descripción.
     * 
     * @param txtDescripcion JTextArea del campo descripción
     */
    public void setTxtDescripcion(JTextArea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    /**
     * Obtiene el campo de texto del tipo.
     * 
     * @return JTextArea del campo tipo
     */
    public JTextArea getTxtTipo() {
        return txtTipo;
    }

    /**
     * Establece el campo de texto del tipo.
     * 
     * @param txtTipo JTextArea del campo tipo
     */
    public void setTxtTipo(JTextArea txtTipo) {
        this.txtTipo = txtTipo;
    }

    /**
     * Obtiene el campo de texto del precio.
     * 
     * @return JTextArea del campo precio
     */
    public JTextArea getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * Establece el campo de texto del precio.
     * 
     * @param txtPrecio JTextArea del campo precio
     */
    public void setTxtPrecio(JTextArea txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    /**
     * Obtiene el campo de texto de la marca.
     * 
     * @return JTextArea del campo marca
     */
    public JTextArea getTxtMarca() {
        return txtMarca;
    }

    /**
     * Establece el campo de texto de la marca.
     * 
     * @param txtMarca JTextArea del campo marca
     */
    public void setTxtMarca(JTextArea txtMarca) {
        this.txtMarca = txtMarca;
    }

    /**
     * Obtiene el campo de texto de las características.
     * 
     * @return JTextArea del campo características
     */
    public JTextArea getTxtCaracteristicas() {
        return txtCaracteristicas;
    }

    /**
     * Establece el campo de texto de las características.
     * 
     * @param txtCaracteristicas JTextArea del campo características
     */
    public void setTxtCaracteristicas(JTextArea txtCaracteristicas) {
        this.txtCaracteristicas = txtCaracteristicas;
    }

    /**
     * Obtiene el campo de texto del material.
     * 
     * @return JTextArea del campo material
     */
    public JTextArea getTxtMaterial() {
        return txtMaterial;
    }

    /**
     * Establece el campo de texto del material.
     * 
     * @param txtMaterial JTextArea del campo material
     */
    public void setTxtMaterial(JTextArea txtMaterial) {
        this.txtMaterial = txtMaterial;
    }

    /**
     * Obtiene el campo de texto del stock.
     * 
     * @return JTextArea del campo stock
     */
    public JTextArea getTxtStock() {
        return txtStock;
    }

    /**
     * Establece el campo de texto del stock.
     * 
     * @param txtStock JTextArea del campo stock
     */
    public void setTxtStock(JTextArea txtStock) {
        this.txtStock = txtStock;
    }

    /**
     * Obtiene el campo de texto del color.
     * 
     * @return JTextArea del campo color
     */
    public JTextArea getTxtColor() {
        return txtColor;
    }

    /**
     * Establece el campo de texto del color.
     * 
     * @param txtColor JTextArea del campo color
     */
    public void setTxtColor(JTextArea txtColor) {
        this.txtColor = txtColor;
    }

    /**
     * Obtiene el campo de texto del modelo.
     * 
     * @return JTextArea del campo modelo
     */
    public JTextArea getTxtModelo() {
        return txtModelo;
    }

    /**
     * Establece el campo de texto del modelo.
     * 
     * @param txtModelo JTextArea del campo modelo
     */
    public void setTxtModelo(JTextArea txtModelo) {
        this.txtModelo = txtModelo;
    }

    /**
     * Obtiene el ComboBox de material.
     * 
     * @return JComboBox de material
     */
    public JComboBox getCmbMaterial() {
        return cmbMaterial;
    }

    /**
     * Establece el ComboBox de material.
     * 
     * @param cmbMaterial JComboBox de material
     */
    public void setCmbMaterial(JComboBox cmbMaterial) {
        this.cmbMaterial = cmbMaterial;
    }

    /**
     * Obtiene el campo formateado del largo.
     * 
     * @return JFormattedTextField del largo
     */
    public JFormattedTextField getTxtLargo() {
        return txtLargo;
    }

    /**
     * Establece el campo formateado del largo.
     * 
     * @param txtLargo JFormattedTextField del largo
     */
    public void setTxtLargo(JFormattedTextField txtLargo) {
        this.txtLargo = txtLargo;
    }

    /**
     * Obtiene el campo formateado del ancho.
     * 
     * @return JFormattedTextField del ancho
     */
    public JFormattedTextField getTxtAncho() {
        return txtAncho;
    }

    /**
     * Establece el campo formateado del ancho.
     * 
     * @param txtAncho JFormattedTextField del ancho
     */
    public void setTxtAncho(JFormattedTextField txtAncho) {
        this.txtAncho = txtAncho;
    }

    /**
     * Obtiene el campo formateado de la altura.
     * 
     * @return JFormattedTextField de la altura
     */
    public JFormattedTextField getTxtAltura() {
        return txtAltura;
    }

    /**
     * Establece el campo formateado de la altura.
     * 
     * @param txtAltura JFormattedTextField de la altura
     */
    public void setTxtAltura(JFormattedTextField txtAltura) {
        this.txtAltura = txtAltura;
    }

    /**
     * Obtiene el botón de crear construcción.
     * 
     * @return JButton de crear construcción
     */
    public JButton getBtnCrearConstruccion() {
        return btnCrearConstruccion;
    }

    /**
     * Establece el botón de crear construcción.
     * 
     * @param btnCrearConstruccion JButton de crear construcción
     */
    public void setBtnCrearConstruccion(JButton btnCrearConstruccion) {
        this.btnCrearConstruccion = btnCrearConstruccion;
    }

    /**
     * Obtiene el archivo de imagen seleccionado.
     * 
     * @return File de imagen seleccionado
     */
    public File getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    /**
     * Establece el archivo de imagen seleccionado.
     * 
     * @param imagenSeleccionada File de imagen seleccionado
     */
    public void setImagenSeleccionada(File imagenSeleccionada) {
        this.imagenSeleccionada = imagenSeleccionada;
    }
    
    /**
     * Obtiene el botón de actualizar construcción.
     * 
     * @return JButton de actualizar construcción
     */
    public JButton getBtnActualizarConstruccion() {
        return btnActualizarConstruccion;
    }

    /**
     * Obtiene el botón de borrar construcción.
     * 
     * @return JButton de borrar construcción
     */
    public JButton getBtnBorrarConstruccion() {
        return btnBorrarConstruccion;	
    }
}