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
 * Panel que permite crear o actualizar información de mascotas en el sistema.
 * Incluye formulario con campos para nombre, descripción, tipo, precio, marca, características,
 * stock, tipo de animal, raza, color y formato de venta. También permite seleccionar una imagen
 * del producto y contiene botones para crear, actualizar o eliminar mascotas.
 * 
 * @author TuNombre
 * @version 1.0
 * @since 1.0
 */
public class PanelCrearMascota extends JPanel {
    /** Etiqueta para el campo de nombre de la mascota */
    private JLabel lblNombre;
    
    /** Etiqueta para el campo de descripción de la mascota */
    private JLabel lblDescripcion;
    
    /** Etiqueta para el campo de tipo de producto */
    private JLabel lblTipo;
    
    /** Etiqueta para el campo de precio */
    private JLabel lblPrecio;
    
    /** Etiqueta para el campo de marca */
    private JLabel lblMarca;
    
    /** Etiqueta para el campo de características */
    private JLabel lblCaracteristicas;
    
    /** Etiqueta para el campo de stock */
    private JLabel lblStock;
    
    /** Etiqueta para el campo de tipo de animal */
    private JLabel lblTipoAnimal;
    
    /** Etiqueta para el campo de raza */
    private JLabel lblRaza;
    
    /** Etiqueta para el campo de color */
    private JLabel lblColor;
    
    /** Etiqueta para el campo de formato de venta */
    private JLabel lblFormatoDeVenta;
    
    /** Campo de texto para el nombre de la mascota */
    private JTextArea txtNombre;
    
    /** Campo de texto para la descripción de la mascota */
    private JTextArea txtDescripcion;
    
    /** Campo de texto para el tipo de producto */
    private JTextArea txtTipo;
    
    /** Campo de texto para el precio */
    private JTextArea txtPrecio;
    
    /** Campo de texto para la marca */
    private JTextArea txtMarca;
    
    /** Campo de texto para las características */
    private JTextArea txtCaracteristicas;
    
    /** Campo de texto para el stock */
    private JTextArea txtStock;
    
    /** Campo de texto para la raza */
    private JTextArea txtRaza;
    
    /** Campo de texto para el color */
    private JTextArea txtColor;
    
    /** Combo box para seleccionar el tipo de animal */
    private JComboBox<String> cmbTipoAnimal;
    
    /** Combo box para seleccionar el formato de venta */
    private JComboBox<String> cmbFormatoDeVenta;
    
    /** Botón para crear una nueva mascota */
    private JButton btnCrearMascota;
    
    /** Botón para seleccionar una imagen del producto */
    private JButton btnSeleccionarImagen;
    
    /** Botón para actualizar información de una mascota existente */
    private JButton btnActualizarMascota;
    
    /** Botón para eliminar una mascota existente */
    private JButton btnBorrarMascota;
    
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
    public PanelCrearMascota() {
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
     * Crea el panel para la selección y vista previa de la imagen del producto.
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
                                "<div style='font-size: 60px; margin-bottom: 10px;'>🐾</div>" +
                                "<div style='font-size: 16px; font-weight: bold;'>IMAGEN NO DISPONIBLE</div>" +
                                "</html>");
        
        imageContainer.add(lblImagenPreview, BorderLayout.CENTER);
        
        // Botón seleccionar imagen
        btnSeleccionarImagen = new JButton("Seleccionar imagen del producto");
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
     * Crea el panel que contiene el formulario para ingresar datos de la mascota.
     * 
     * @return JPanel configurado con todos los campos del formulario
     */
    private JPanel crearPanelFormulario() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(COLOR_PANEL_BLANCO);
        formPanel.setPreferredSize(new Dimension(600, 1200));
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
        lblCaracteristicas = crearLabel("Características");
        lblStock = crearLabel("Stock");
        lblTipoAnimal = crearLabel("Tipo del animal");
        lblRaza = crearLabel("Raza del animal");
        lblColor = crearLabel("Color del animal");
        lblFormatoDeVenta = crearLabel("Formato de venta");

        // TextAreas
        txtNombre = crearTextArea();
        txtDescripcion = crearTextAreaGrande();
        txtTipo = crearTextArea();
        txtPrecio = crearTextArea();
        txtMarca = crearTextArea();
        txtCaracteristicas = crearTextAreaGrande();
        txtStock = crearTextArea();
        txtRaza = crearTextArea();
        txtColor = crearTextArea();

        // ComboBoxes
        cmbTipoAnimal = crearComboBox();
        cmbTipoAnimal.addItem("Perro");
        cmbTipoAnimal.addItem("Gato");
        cmbTipoAnimal.addItem("Aves");
        cmbTipoAnimal.addItem("Peces");
        cmbTipoAnimal.addItem("Roedores");
        cmbTipoAnimal.addItem("Reptiles");
        cmbTipoAnimal.addItem("Anfibios");
        cmbTipoAnimal.addItem("Caballos");

        cmbFormatoDeVenta = crearComboBox();
        cmbFormatoDeVenta.addItem("Unidad");
        cmbFormatoDeVenta.addItem("Caja");
        cmbFormatoDeVenta.addItem("Frasco");
        cmbFormatoDeVenta.addItem("Bolsa");
        cmbFormatoDeVenta.addItem("Paquete");
        cmbFormatoDeVenta.addItem("kit");
        cmbFormatoDeVenta.addItem("Saco/Bulto");
        cmbFormatoDeVenta.addItem("Lata");
        cmbFormatoDeVenta.addItem("Sobre");

        // Botón principal
        btnCrearMascota = crearBotonPrincipal("Crear Mascota");
        btnCrearMascota.setActionCommand("Crear Mascota");

        btnActualizarMascota = crearBotonPrincipal("Actualizar");
        btnActualizarMascota.setActionCommand("Actualizar Mascota");
        btnActualizarMascota.setVisible(false);

        btnBorrarMascota = crearBotonEliminar("Eliminar Producto");
        btnBorrarMascota.setActionCommand("Borrar Mascota");
        btnBorrarMascota.setVisible(false);
    }
    
    /**
     * Posiciona todos los componentes del formulario en el panel especificado.
     * 
     * @param panel JPanel donde se posicionarán los componentes
     */
    private void posicionarComponentesFormulario(JPanel panel){
        int x = 20, yLabel = 20, yField = 45, gap = 65, fieldWidth = 480, fieldHeight = 35;

        // Título de sección
        JLabel titulo = new JLabel("Información del producto para mascotas");
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
        lblCaracteristicas.setBounds(x, yLabel, 200, 20);
        txtCaracteristicas.setBounds(x, yField, fieldWidth, 60);

        yLabel += 85;
        yField += 85;
        lblStock.setBounds(x, yLabel, 200, 20);
        txtStock.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblTipoAnimal.setBounds(x, yLabel, 200, 20);
        cmbTipoAnimal.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblRaza.setBounds(x, yLabel, 200, 20);
        txtRaza.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblColor.setBounds(x, yLabel, 200, 20);
        txtColor.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblFormatoDeVenta.setBounds(x, yLabel, 200, 20);
        cmbFormatoDeVenta.setBounds(x, yField, fieldWidth, fieldHeight);

        // Posicionar botones con coordenadas absolutas
        btnCrearMascota.setBounds((panel.getPreferredSize().width - 180) / 2, yField + 80, 180, 45);
        btnActualizarMascota.setBounds((panel.getPreferredSize().width - 380) / 2, yField + 80, 180, 45);
        btnBorrarMascota.setBounds((panel.getPreferredSize().width + 100) / 2, yField + 80, 180, 45);

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
        panel.add(lblCaracteristicas);
        panel.add(txtCaracteristicas);
        panel.add(lblStock);
        panel.add(txtStock);
        panel.add(lblTipoAnimal);
        panel.add(cmbTipoAnimal);
        panel.add(lblRaza);
        panel.add(txtRaza);
        panel.add(lblColor);
        panel.add(txtColor);
        panel.add(lblFormatoDeVenta);
        panel.add(cmbFormatoDeVenta);
        panel.add(btnCrearMascota);
        panel.add(btnActualizarMascota);
        panel.add(btnBorrarMascota);
    }
    
    /**
     * Abre un diálogo para seleccionar una imagen del producto.
     * Permite filtrar por tipos de archivo de imagen válidos (jpg, jpeg, png, gif).
     * Si se selecciona una imagen, la muestra en la vista previa.
     */
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen del producto");
        
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
        getTxtCaracteristicas().setText("");
        getTxtStock().setText("");
        getCmbTipoAnimal().setSelectedIndex(0);
        getTxtRaza().setText("");
        getTxtColor().setText("");
        getCmbFormatoDeVenta().setSelectedIndex(0);
        
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>"
                + "<div style='font-size: 60px; margin-bottom: 10px;'>🐾</div>"
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
     * Obtiene la etiqueta del campo tipo de animal.
     * 
     * @return JLabel del campo tipo de animal
     */
    public JLabel getLblTipoAnimal() {
        return lblTipoAnimal;
    }

    /**
     * Establece la etiqueta del campo tipo de animal.
     * 
     * @param lblTipoAnimal JLabel del campo tipo de animal
     */
    public void setLblTipoAnimal(JLabel lblTipoAnimal) {
        this.lblTipoAnimal = lblTipoAnimal;
    }

    /**
     * Obtiene la etiqueta del campo raza.
     * 
     * @return JLabel del campo raza
     */
    public JLabel getLblRaza() {
        return lblRaza;
    }

    /**
     * Establece la etiqueta del campo raza.
     * 
     * @param lblRaza JLabel del campo raza
     */
    public void setLblRaza(JLabel lblRaza) {
        this.lblRaza = lblRaza;
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
     * Obtiene el campo de texto para la raza.
     * 
     * @return JTextArea para la raza
     */
    public JTextArea getTxtRaza() {
        return txtRaza;
    }

    /**
     * Establece el campo de texto para la raza.
     * 
     * @param txtRaza JTextArea para la raza
     */
    public void setTxtRaza(JTextArea txtRaza) {
        this.txtRaza = txtRaza;
    }

    /**
     * Obtiene el campo de texto para el color.
     * 
     * @return JTextArea para el color
     */
    public JTextArea getTxtColor() {
        return txtColor;
    }

    /**
     * Establece el campo de texto para el color.
     * 
     * @param txtColor JTextArea para el color
     */
    public void setTxtColor(JTextArea txtColor) {
        this.txtColor = txtColor;
    }

    /**
     * Obtiene el combo box para el tipo de animal.
     * 
     * @return JComboBox para el tipo de animal
     */
    public JComboBox<String> getCmbTipoAnimal() {
        return cmbTipoAnimal;
    }

    /**
     * Establece el combo box para el tipo de animal.
     * 
     * @param cmbTipoAnimal JComboBox para el tipo de animal
     */
    public void setCmbTipoAnimal(JComboBox<String> cmbTipoAnimal) {
        this.cmbTipoAnimal = cmbTipoAnimal;
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
     * Obtiene el botón para crear mascota.
     * 
     * @return JButton para crear mascota
     */
    public JButton getBtnCrearMascota() {
        return btnCrearMascota;
    }

    /**
     * Establece el botón para crear mascota.
     * 
     * @param btnCrearMascota JButton para crear mascota
     */
    public void setBtnCrearMascota(JButton btnCrearMascota) {
        this.btnCrearMascota = btnCrearMascota;
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
     * Obtiene el botón para actualizar mascota.
     * 
     * @return JButton para actualizar mascota
     */
    public JButton getBtnActualizarMascota() {
        return btnActualizarMascota;
    }

    /**
     * Obtiene el botón para borrar mascota.
     * 
     * @return JButton para borrar mascota
     */
    public JButton getBtnBorrarMascota() {
        return btnBorrarMascota;
    }
}