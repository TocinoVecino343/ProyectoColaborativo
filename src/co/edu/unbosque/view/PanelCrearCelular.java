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
 * Panel para crear y editar productos de tipo celular.
 * Permite ingresar información detallada del celular incluyendo imagen,
 * datos básicos, especificaciones técnicas y características especiales.
 * 
 * @author TuNombre
 * @version 1.0
 * @since 1.0
 */
public class PanelCrearCelular extends JPanel {
    /** Etiqueta para el campo nombre del celular */
	private JLabel lblNombre;
    
    /** Etiqueta para el campo descripción del celular */
	private JLabel lblDescripcion;
    
    /** Etiqueta para el campo tipo del celular */
	private JLabel lblTipo;
    
    /** Etiqueta para el campo precio del celular */
	private JLabel lblPrecio;
    
    /** Etiqueta para el campo marca del celular */
	private JLabel lblMarca;
    
    /** Etiqueta para el campo características del celular */
	private JLabel lblCaracteristicas;
    
    /** Etiqueta para el campo stock del celular */
	private JLabel lblStock;
    
    /** Etiqueta para el campo color del celular */
	private JLabel lblColor;
    
    /** Etiqueta para el campo memoria interna del celular */
	private JLabel lblMemoriaInterna;
    
    /** Etiqueta para el campo memoria RAM del celular */
	private JLabel lblMemoriaRam;
    
    /** Etiqueta para el campo largo de pantalla del celular */
	private JLabel lblLargoPantalla;
    
    /** Etiqueta para el campo ancho de pantalla del celular */
	private JLabel lblAnchoPantalla;
    
    /** Etiqueta para el campo altura de pantalla del celular */
	private JLabel lblAlturaPantalla;
    
    /** Etiqueta para el campo cámara frontal del celular */
	private JLabel lblCamaraFrontal;
    
    /** Etiqueta para el campo cámara trasera del celular */
	private JLabel lblCamaraTrasera;
    
    /** Etiqueta para el campo posee NFC del celular */
	private JLabel lblPoseeNfc;
    
    /** Campo de texto para el nombre del celular */
	private JTextArea txtNombre;
    
    /** Campo de texto para la descripción del celular */
	private JTextArea txtDescripcion;
    
    /** Campo de texto para el tipo del celular */
	private JTextArea txtTipo;
    
    /** Campo de texto para el precio del celular */
	private JTextArea txtPrecio;
    
    /** Campo de texto para la marca del celular */
	private JTextArea txtMarca;
    
    /** Campo de texto para las características del celular */
	private JTextArea txtCaracteristicas;
    
    /** Campo de texto para el stock del celular */
	private JTextArea txtStock;
    
    /** Campo de texto para el color del celular */
	private JTextArea txtColor;
    
    /** ComboBox para seleccionar la memoria interna del celular */
	private JComboBox<String> cmbMemoriaInterna;
    
    /** ComboBox para seleccionar la memoria RAM del celular */
	private JComboBox<String> cmbMemoriaRam;
    
    /** Campo formateado para el largo de pantalla del celular */
	private JFormattedTextField txtLargoPantalla;
    
    /** Campo formateado para el ancho de pantalla del celular */
	private JFormattedTextField txtAnchoPantalla;
    
    /** Campo formateado para la altura de pantalla del celular */
	private JFormattedTextField txtAlturaPantalla;
    
    /** Campo formateado para la cámara frontal del celular */
	private JFormattedTextField txtCamaraFrontal;
    
    /** Campo formateado para la cámara trasera del celular */
	private JFormattedTextField txtCamaraTrasera;
    
    /** ComboBox para seleccionar si el celular posee NFC */
	private JComboBox<String> cmbPoseeNfc;
    
    /** Botón para crear un nuevo celular */
	private JButton btnCrearCelular;
    
    /** Botón para seleccionar la imagen del celular */
	private JButton btnSeleccionarImagen;
    
    /** Botón para actualizar un celular existente */
	private JButton btnActualizarCelular;
    
    /** Botón para borrar un celular existente */
	private JButton btnBorrarCelular;
    
    /** Etiqueta para mostrar la vista previa de la imagen del celular */
	private JLabel lblImagenPreview;
    
    /** Archivo de imagen seleccionado para el celular */
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
    public PanelCrearCelular() {
        this.setVisible(true);
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1280, 800);
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
     * Crea el panel izquierdo para mostrar la imagen del celular.
     * Incluye un contenedor para la imagen y un botón para seleccionar imagen.
     * 
     * @return JPanel configurado para mostrar la imagen del celular
     */
    public JPanel crearPanelImagen() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(COLOR_PANEL_BLANCO);
        imagePanel.setPreferredSize(new Dimension(500, 700));
        imagePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)));

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
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>"
                + "<div style='font-size: 60px; margin-bottom: 10px;'>📱</div>"
                + "<div style='font-size: 16px; font-weight: bold;'>IMAGEN NO SELECCIONADA</div>" + "</html>");

        imageContainer.add(lblImagenPreview, BorderLayout.CENTER);

        // Botón seleccionar imagen
        btnSeleccionarImagen = new JButton("Seleccionar imagen del celular");
        btnSeleccionarImagen.setFont(new Font("Arial", Font.BOLD, 14));
        btnSeleccionarImagen.setBackground(COLOR_PANEL_BLANCO);
        btnSeleccionarImagen.setForeground(COLOR_BOTON);
        btnSeleccionarImagen.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BOTON, 2), BorderFactory.createEmptyBorder(12, 20, 12, 20)));
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
     * Crea el panel derecho con el formulario para ingresar datos del celular.
     * Inicializa y posiciona todos los campos del formulario.
     * 
     * @return JPanel configurado con el formulario del celular
     */
    public JPanel crearPanelFormulario() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(COLOR_PANEL_BLANCO);
        formPanel.setPreferredSize(new Dimension(600, 1200));
        formPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)));

        // Inicializar componentes del formulario
        inicializarCamposFormulario();
        posicionarComponentesFormulario(formPanel);

        return formPanel;
    }

    /**
     * Inicializa todos los campos del formulario (etiquetas, campos de texto, combobox y botones).
     * Configura las propiedades visuales y comportamientos de cada componente.
     */
    public void inicializarCamposFormulario() {
        // Labels
        lblNombre = crearLabel("Nombre");
        lblDescripcion = crearLabel("Descripción");
        lblTipo = crearLabel("Tipo");
        lblPrecio = crearLabel("Precio");
        lblMarca = crearLabel("Marca");
        lblCaracteristicas = crearLabel("Características");
        lblStock = crearLabel("Stock");
        lblColor = crearLabel("Color");
        lblMemoriaInterna = crearLabel("Memoria Interna");
        lblMemoriaRam = crearLabel("Memoria RAM");
        lblLargoPantalla = crearLabel("Largo pantalla");
        lblAnchoPantalla = crearLabel("Ancho pantalla");
        lblAlturaPantalla = crearLabel("Altura pantalla");
        lblCamaraFrontal = crearLabel("Cámara frontal (MP)");
        lblCamaraTrasera = crearLabel("Cámara trasera (MP)");
        lblPoseeNfc = crearLabel("¿Posee NFC?");

        // TextAreas
        txtNombre = crearTextArea();
        txtDescripcion = crearTextAreaGrande();
        txtTipo = crearTextArea();
        txtPrecio = crearTextArea();
        txtMarca = crearTextArea();
        txtCaracteristicas = crearTextAreaGrande();
        txtStock = crearTextArea();
        txtColor = crearTextArea();

        // ComboBoxes de memoria
        cmbMemoriaInterna = crearComboBox();
        cmbMemoriaInterna.addItem("8GB");
        cmbMemoriaInterna.addItem("16GB");
        cmbMemoriaInterna.addItem("32GB");
        cmbMemoriaInterna.addItem("64GB");
        cmbMemoriaInterna.addItem("128GB");
        cmbMemoriaInterna.addItem("256GB");
        cmbMemoriaInterna.addItem("512GB");
        cmbMemoriaInterna.addItem("1TB");

        cmbMemoriaRam = crearComboBox();
        cmbMemoriaRam.addItem("2GB");
        cmbMemoriaRam.addItem("3GB");
        cmbMemoriaRam.addItem("4GB");
        cmbMemoriaRam.addItem("6GB");
        cmbMemoriaRam.addItem("8GB");
        cmbMemoriaRam.addItem("12GB");
        cmbMemoriaRam.addItem("16GB");

        // Campos formateados
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        txtLargoPantalla = new JFormattedTextField(numberFormat);
        txtAnchoPantalla = new JFormattedTextField(numberFormat);
        txtAlturaPantalla = new JFormattedTextField(numberFormat);
        txtCamaraFrontal = new JFormattedTextField(numberFormat);
        txtCamaraTrasera = new JFormattedTextField(numberFormat);

        aplicarEstiloTextField(txtLargoPantalla);
        aplicarEstiloTextField(txtAnchoPantalla);
        aplicarEstiloTextField(txtAlturaPantalla);
        aplicarEstiloTextField(txtCamaraFrontal);
        aplicarEstiloTextField(txtCamaraTrasera);

        // ComboBox NFC
        cmbPoseeNfc = crearComboBox();
        cmbPoseeNfc.addItem("Sí");
        cmbPoseeNfc.addItem("No");

        // Botón principal
        btnCrearCelular= crearBotonPrincipal("Crear Celular");
        btnCrearCelular.setActionCommand("Crear Celular");
        btnCrearCelular.setVisible(true);

        btnActualizarCelular= crearBotonPrincipal("Actualizar");
        btnActualizarCelular.setActionCommand("Actualizar Celular");
        btnActualizarCelular.setVisible(false);

        btnBorrarCelular= crearBotonEliminar("Eliminar Producto");
        btnBorrarCelular.setActionCommand("Borrar Celular"); 
        btnBorrarCelular.setVisible(false); 
    }

    /**
     * Posiciona todos los componentes del formulario en el panel.
     * Establece las coordenadas y dimensiones de cada elemento.
     * 
     * @param panel JPanel donde se posicionarán los componentes
     */
    public void posicionarComponentesFormulario(JPanel panel) {
        int x = 20, yLabel = 20, yField = 45, gap = 65, fieldWidth = 480, fieldHeight = 35;

        // Título de sección
        JLabel titulo = new JLabel("Información del celular");
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
        lblColor.setBounds(x, yLabel, 200, 20);
        txtColor.setBounds(x, yField, fieldWidth, fieldHeight);

        // Especificaciones técnicas
        yLabel += gap;
        yField += gap;
        lblMemoriaInterna.setBounds(x, yLabel, 200, 20);
        cmbMemoriaInterna.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblMemoriaRam.setBounds(x, yLabel, 200, 20);
        cmbMemoriaRam.setBounds(x, yField, fieldWidth, fieldHeight);

        // Pantalla
        yLabel += gap;
        yField += gap;
        lblLargoPantalla.setBounds(x, yLabel, 200, 20);
        txtLargoPantalla.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblAnchoPantalla.setBounds(x, yLabel, 200, 20);
        txtAnchoPantalla.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblAlturaPantalla.setBounds(x, yLabel, 200, 20);
        txtAlturaPantalla.setBounds(x, yField, fieldWidth, fieldHeight);

        // Cámaras
        yLabel += gap;
        yField += gap;
        lblCamaraFrontal.setBounds(x, yLabel, 200, 20);
        txtCamaraFrontal.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblCamaraTrasera.setBounds(x, yLabel, 200, 20);
        txtCamaraTrasera.setBounds(x, yField, fieldWidth, fieldHeight);

        yLabel += gap;
        yField += gap;
        lblPoseeNfc.setBounds(x, yLabel, 200, 20);
        cmbPoseeNfc.setBounds(x, yField, fieldWidth, fieldHeight);
        btnCrearCelular.setBounds((panel.getPreferredSize().width - 180) / 2, yField + 80, 180, 45);
        btnActualizarCelular.setBounds((panel.getPreferredSize().width - 380) / 2, yField + 80, 180, 45);
        btnBorrarCelular.setBounds((panel.getPreferredSize().width + 100) / 2, yField + 80, 180, 45);

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
        panel.add(lblColor);
        panel.add(txtColor);
        panel.add(lblMemoriaInterna);
        panel.add(cmbMemoriaInterna);
        panel.add(lblMemoriaRam);
        panel.add(cmbMemoriaRam);
        panel.add(lblLargoPantalla);
        panel.add(txtLargoPantalla);
        panel.add(lblAnchoPantalla);
        panel.add(txtAnchoPantalla);
        panel.add(lblAlturaPantalla);
        panel.add(txtAlturaPantalla);
        panel.add(lblCamaraFrontal);
        panel.add(txtCamaraFrontal);
        panel.add(lblCamaraTrasera);
        panel.add(txtCamaraTrasera);
        panel.add(lblPoseeNfc);
        panel.add(cmbPoseeNfc);
        panel.add(btnCrearCelular);
        panel.add(btnCrearCelular);
        panel.add(btnActualizarCelular);
        panel.add(btnBorrarCelular);
    }

    /**
     * Abre un selector de archivos para elegir una imagen para el celular.
     * Filtra solo archivos de imagen y muestra una vista previa en el panel.
     */
    public void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen del celular");

        // Filtro para imágenes
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen (*.jpg, *.jpeg, *.png, *.gif)",
                "jpg", "jpeg", "png", "gif");
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
                lblImagenPreview.setText(
                        "<html><div style='text-align: center; color: red;'>" + "Error al cargar imagen</div></html>");
            }
        }
    }

    /**
     * Crea una etiqueta con el estilo estándar del formulario.
     * 
     * @param texto Texto que mostrará la etiqueta
     * @return JLabel configurada con el estilo estándar
     */
    public JLabel crearLabel(String texto) {
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
    public JTextArea crearTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBackground(COLOR_PANEL_BLANCO);
        textArea.setForeground(COLOR_TEXTO_PRINCIPAL);
        textArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        aplicarEfectoFocus(textArea);
        return textArea;
    }

    /**
     * Crea un campo de texto grande con el estilo estándar del formulario.
     * 
     * @return JTextArea configurada para mayor tamaño
     */
    public JTextArea crearTextAreaGrande() {
        JTextArea textArea = crearTextArea();
        return textArea;
    }

    /**
     * Crea un ComboBox con el estilo estándar del formulario.
     * 
     * @return JComboBox configurado con el estilo estándar
     */
    public JComboBox<String> crearComboBox() {
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
    public void aplicarEstiloTextField(JFormattedTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(COLOR_PANEL_BLANCO);
        textField.setForeground(COLOR_TEXTO_PRINCIPAL);
        textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        aplicarEfectoFocusTextField(textField);
    }

    /**
     * Crea un botón principal con el estilo estándar del formulario.
     * 
     * @param texto Texto que mostrará el botón
     * @return JButton configurado con el estilo principal
     */
    public JButton crearBotonPrincipal(String texto) {
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
    public JButton crearBotonEliminar(String texto){
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
    public void aplicarEfectoFocus(JTextArea textArea) {
        textArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BOTON, 2),
                        BorderFactory.createEmptyBorder(7, 11, 7, 11)));
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                textArea.setBorder(
                        BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                                BorderFactory.createEmptyBorder(8, 12, 8, 12)));
            }
        });
    }

    /**
     * Aplica un efecto visual cuando un JFormattedTextField recibe o pierde el foco.
     * 
     * @param textField JFormattedTextField al que se le aplicará el efecto
     */
    public void aplicarEfectoFocusTextField(JFormattedTextField textField) {
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BOTON, 2),
                        BorderFactory.createEmptyBorder(7, 11, 7, 11)));
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                textField.setBorder(
                        BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                                BorderFactory.createEmptyBorder(8, 12, 8, 12)));
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
        getTxtColor().setText("");
        getCmbMemoriaInterna().setSelectedIndex(0);
        getCmbMemoriaRam().setSelectedIndex(0);
        getTxtLargoPantalla().setText("");
        getTxtAnchoPantalla().setText("");
        getTxtAlturaPantalla().setText("");
        getTxtCamaraFrontal().setText("");
        getTxtCamaraTrasera().setText("");
        getCmbPoseeNfc().setSelectedIndex(0);
        
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>"
                + "<div style='font-size: 60px; margin-bottom: 10px;'>📱</div>"
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
     * Obtiene la etiqueta del campo memoria interna.
     * 
     * @return JLabel del campo memoria interna
     */
    public JLabel getLblMemoriaInterna() {
        return lblMemoriaInterna;
    }

    /**
     * Establece la etiqueta del campo memoria interna.
     * 
     * @param lblMemoriaInterna JLabel del campo memoria interna
     */
    public void setLblMemoriaInterna(JLabel lblMemoriaInterna) {
        this.lblMemoriaInterna = lblMemoriaInterna;
    }

    /**
     * Obtiene la etiqueta del campo memoria RAM.
     * 
     * @return JLabel del campo memoria RAM
     */
    public JLabel getLblMemoriaRam() {
        return lblMemoriaRam;
    }

    /**
     * Establece la etiqueta del campo memoria RAM.
     * 
     * @param lblMemoriaRam JLabel del campo memoria RAM
     */
    public void setLblMemoriaRam(JLabel lblMemoriaRam) {
        this.lblMemoriaRam = lblMemoriaRam;
    }

    /**
     * Obtiene la etiqueta del campo largo pantalla.
     * 
     * @return JLabel del campo largo pantalla
     */
    public JLabel getLblLargoPantalla() {
        return lblLargoPantalla;
    }

    /**
     * Establece la etiqueta del campo largo pantalla.
     * 
     * @param lblLargoPantalla JLabel del campo largo pantalla
     */
    public void setLblLargoPantalla(JLabel lblLargoPantalla) {
        this.lblLargoPantalla = lblLargoPantalla;
    }

    /**
     * Obtiene la etiqueta del campo ancho pantalla.
     * 
     * @return JLabel del campo ancho pantalla
     */
    public JLabel getLblAnchoPantalla() {
        return lblAnchoPantalla;
    }

    /**
     * Establece la etiqueta del campo ancho pantalla.
     * 
     * @param lblAnchoPantalla JLabel del campo ancho pantalla
     */
    public void setLblAnchoPantalla(JLabel lblAnchoPantalla) {
        this.lblAnchoPantalla = lblAnchoPantalla;
    }

    /**
     * Obtiene la etiqueta del campo altura pantalla.
     * 
     * @return JLabel del campo altura pantalla
     */
    public JLabel getLblAlturaPantalla() {
        return lblAlturaPantalla;
    }

    /**
     * Establece la etiqueta del campo altura pantalla.
     * 
     * @param lblAlturaPantalla JLabel del campo altura pantalla
     */
    public void setLblAlturaPantalla(JLabel lblAlturaPantalla) {
        this.lblAlturaPantalla = lblAlturaPantalla;
    }

    /**
     * Obtiene la etiqueta del campo cámara frontal.
     * 
     * @return JLabel del campo cámara frontal
     */
    public JLabel getLblCamaraFrontal() {
        return lblCamaraFrontal;
    }

    /**
     * Establece la etiqueta del campo cámara frontal.
     * 
     * @param lblCamaraFrontal JLabel del campo cámara frontal
     */
    public void setLblCamaraFrontal(JLabel lblCamaraFrontal) {
        this.lblCamaraFrontal = lblCamaraFrontal;
    }

    /**
     * Obtiene la etiqueta del campo cámara trasera.
     * 
     * @return JLabel del campo cámara trasera
     */
    public JLabel getLblCamaraTrasera() {
        return lblCamaraTrasera;
    }

    /**
     * Establece la etiqueta del campo cámara trasera.
     * 
     * @param lblCamaraTrasera JLabel del campo cámara trasera
     */
    public void setLblCamaraTrasera(JLabel lblCamaraTrasera) {
        this.lblCamaraTrasera = lblCamaraTrasera;
    }

    /**
     * Obtiene la etiqueta del campo posee NFC.
     * 
     * @return JLabel del campo posee NFC
     */
    public JLabel getLblPoseeNfc() {
        return lblPoseeNfc;
    }

    /**
     * Establece la etiqueta del campo posee NFC.
     * 
     * @param lblPoseeNfc JLabel del campo posee NFC
     */
    public void setLblPoseeNfc(JLabel lblPoseeNfc) {
        this.lblPoseeNfc = lblPoseeNfc;
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
     * Obtiene el ComboBox de memoria interna.
     * 
     * @return JComboBox de memoria interna
     */
    public JComboBox<String> getCmbMemoriaInterna() {
        return cmbMemoriaInterna;
    }

    /**
     * Establece el ComboBox de memoria interna.
     * 
     * @param cmbMemoriaInterna JComboBox de memoria interna
     */
    public void setCmbMemoriaInterna(JComboBox<String> cmbMemoriaInterna) {
        this.cmbMemoriaInterna = cmbMemoriaInterna;
    }

    /**
     * Obtiene el ComboBox de memoria RAM.
     * 
     * @return JComboBox de memoria RAM
     */
    public JComboBox<String> getCmbMemoriaRam() {
        return cmbMemoriaRam;
    }

    /**
     * Establece el ComboBox de memoria RAM.
     * 
     * @param cmbMemoriaRam JComboBox de memoria RAM
     */
    public void setCmbMemoriaRam(JComboBox<String> cmbMemoriaRam) {
        this.cmbMemoriaRam = cmbMemoriaRam;
    }

    /**
     * Obtiene el campo formateado de largo de pantalla.
     * 
     * @return JFormattedTextField de largo de pantalla
     */
    public JFormattedTextField getTxtLargoPantalla() {
        return txtLargoPantalla;
    }

    /**
     * Establece el campo formateado de largo de pantalla.
     * 
     * @param txtLargoPantalla JFormattedTextField de largo de pantalla
     */
    public void setTxtLargoPantalla(JFormattedTextField txtLargoPantalla) {
        this.txtLargoPantalla = txtLargoPantalla;
    }

    /**
     * Obtiene el campo formateado de ancho de pantalla.
     * 
     * @return JFormattedTextField de ancho de pantalla
     */
    public JFormattedTextField getTxtAnchoPantalla() {
        return txtAnchoPantalla;
    }

    /**
     * Establece el campo formateado de ancho de pantalla.
     * 
     * @param txtAnchoPantalla JFormattedTextField de ancho de pantalla
     */
    public void setTxtAnchoPantalla(JFormattedTextField txtAnchoPantalla) {
        this.txtAnchoPantalla = txtAnchoPantalla;
    }

    /**
     * Obtiene el campo formateado de altura de pantalla.
     * 
     * @return JFormattedTextField de altura de pantalla
     */
    public JFormattedTextField getTxtAlturaPantalla() {
        return txtAlturaPantalla;
    }

    /**
     * Establece el campo formateado de altura de pantalla.
     * 
     * @param txtAlturaPantalla JFormattedTextField de altura de pantalla
     */
    public void setTxtAlturaPantalla(JFormattedTextField txtAlturaPantalla) {
        this.txtAlturaPantalla = txtAlturaPantalla;
    }

    /**
     * Obtiene el campo formateado de cámara frontal.
     * 
     * @return JFormattedTextField de cámara frontal
     */
    public JFormattedTextField getTxtCamaraFrontal() {
        return txtCamaraFrontal;
    }

    /**
     * Establece el campo formateado de cámara frontal.
     * 
     * @param txtCamaraFrontal JFormattedTextField de cámara frontal
     */
    public void setTxtCamaraFrontal(JFormattedTextField txtCamaraFrontal) {
        this.txtCamaraFrontal = txtCamaraFrontal;
    }

    /**
     * Obtiene el campo formateado de cámara trasera.
     * 
     * @return JFormattedTextField de cámara trasera
     */
    public JFormattedTextField getTxtCamaraTrasera() {
        return txtCamaraTrasera;
    }

    /**
     * Establece el campo formateado de cámara trasera.
     * 
     * @param txtCamaraTrasera JFormattedTextField de cámara trasera
     */
    public void setTxtCamaraTrasera(JFormattedTextField txtCamaraTrasera) {
        this.txtCamaraTrasera = txtCamaraTrasera;
    }

    /**
     * Obtiene el ComboBox de posee NFC.
     * 
     * @return JComboBox de posee NFC
     */
    public JComboBox<String> getCmbPoseeNfc() {
        return cmbPoseeNfc;
    }

    /**
     * Establece el ComboBox de posee NFC.
     * 
     * @param cmbPoseeNfc JComboBox de posee NFC
     */
    public void setCmbPoseeNfc(JComboBox<String> cmbPoseeNfc) {
        this.cmbPoseeNfc = cmbPoseeNfc;
    }

    /**
     * Obtiene el botón de crear celular.
     * 
     * @return JButton de crear celular
     */
    public JButton getBtnCrearCelular() {
        return btnCrearCelular;
    }

    /**
     * Establece el botón de crear celular.
     * 
     * @param btnCrearCelular JButton de crear celular
     */
    public void setBtnCrearCelular(JButton btnCrearCelular) {
        this.btnCrearCelular = btnCrearCelular;
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
     * Obtiene el botón de actualizar celular.
     * 
     * @return JButton de actualizar celular
     */
    public JButton getBtnActualizarCelular() {
        return btnActualizarCelular;
    }

    /**
     * Obtiene el botón de borrar celular.
     * 
     * @return JButton de borrar celular
     */
    public JButton getBtnBorrarCelular() {
        return btnBorrarCelular;
    }
}