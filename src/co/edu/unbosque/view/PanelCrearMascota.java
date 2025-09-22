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

public class PanelCrearMascota extends JPanel {
    private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblTipoAnimal,
            lblRaza, lblColor, lblFormatoDeVenta;
    private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock, txtRaza,
            txtColor;
    private JComboBox<String> cmbTipoAnimal, cmbFormatoDeVenta;
    private JButton btnCrearMascota, btnSeleccionarImagen;
    private JLabel lblImagenPreview;
    private File imagenSeleccionada;
    
    // Colores estilo MercadoLibre
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
    private final Color COLOR_BOTON = new Color(52, 131, 250);

    public PanelCrearMascota() {
        this.setVisible(true);
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1280, 800);
        inicializarComponentes();
    }

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
    
    private void inicializarCamposFormulario() {
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
    }
    
    private void posicionarComponentesFormulario(JPanel panel) {
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
        
        yLabel += gap; yField += gap;
        lblMarca.setBounds(x, yLabel, 200, 20);
        txtMarca.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblDescripcion.setBounds(x, yLabel, 200, 20);
        txtDescripcion.setBounds(x, yField, fieldWidth, 60);
        
        yLabel += 85; yField += 85;
        lblTipo.setBounds(x, yLabel, 200, 20);
        txtTipo.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblPrecio.setBounds(x, yLabel, 200, 20);
        txtPrecio.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblCaracteristicas.setBounds(x, yLabel, 200, 20);
        txtCaracteristicas.setBounds(x, yField, fieldWidth, 60);
        
        yLabel += 85; yField += 85;
        lblStock.setBounds(x, yLabel, 200, 20);
        txtStock.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblTipoAnimal.setBounds(x, yLabel, 200, 20);
        cmbTipoAnimal.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblRaza.setBounds(x, yLabel, 200, 20);
        txtRaza.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblColor.setBounds(x, yLabel, 200, 20);
        txtColor.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblFormatoDeVenta.setBounds(x, yLabel, 200, 20);
        cmbFormatoDeVenta.setBounds(x, yField, fieldWidth, fieldHeight);
        
        // Botón
        btnCrearMascota.setBounds((panel.getPreferredSize().width - 200) / 2, yField + 80, 200, 45);
        
        // Agregar todos los componentes
        panel.add(lblNombre); panel.add(txtNombre);
        panel.add(lblMarca); panel.add(txtMarca);
        panel.add(lblDescripcion); panel.add(txtDescripcion);
        panel.add(lblTipo); panel.add(txtTipo);
        panel.add(lblPrecio); panel.add(txtPrecio);
        panel.add(lblCaracteristicas); panel.add(txtCaracteristicas);
        panel.add(lblStock); panel.add(txtStock);
        panel.add(lblTipoAnimal); panel.add(cmbTipoAnimal);
        panel.add(lblRaza); panel.add(txtRaza);
        panel.add(lblColor); panel.add(txtColor);
        panel.add(lblFormatoDeVenta); panel.add(cmbFormatoDeVenta);
        panel.add(btnCrearMascota);
    }
    
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
    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(COLOR_TEXTO_PRINCIPAL);
        return label;
    }
    
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
    
    private JTextArea crearTextAreaGrande() {
        JTextArea textArea = crearTextArea();
        return textArea;
    }
    
    private JComboBox<String> crearComboBox() {
        JComboBox<String> combo = new JComboBox<>();
        combo.setFont(new Font("Arial", Font.PLAIN, 14));
        combo.setBackground(COLOR_PANEL_BLANCO);
        combo.setForeground(COLOR_TEXTO_PRINCIPAL);
        combo.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));
        aplicarEfectoFocusComboBox(combo);
        return combo;
    }
    
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

    // Getters y Setters
    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JLabel getLblCaracteristicas() {
        return lblCaracteristicas;
    }

    public void setLblCaracteristicas(JLabel lblCaracteristicas) {
        this.lblCaracteristicas = lblCaracteristicas;
    }

    public JLabel getLblStock() {
        return lblStock;
    }

    public void setLblStock(JLabel lblStock) {
        this.lblStock = lblStock;
    }

    public JLabel getLblTipoAnimal() {
        return lblTipoAnimal;
    }

    public void setLblTipoAnimal(JLabel lblTipoAnimal) {
        this.lblTipoAnimal = lblTipoAnimal;
    }

    public JLabel getLblRaza() {
        return lblRaza;
    }

    public void setLblRaza(JLabel lblRaza) {
        this.lblRaza = lblRaza;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JLabel getLblFormatoDeVenta() {
        return lblFormatoDeVenta;
    }

    public void setLblFormatoDeVenta(JLabel lblFormatoDeVenta) {
        this.lblFormatoDeVenta = lblFormatoDeVenta;
    }

    public JTextArea getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextArea txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextArea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextArea getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextArea txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextArea getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextArea txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JTextArea getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextArea txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextArea getTxtCaracteristicas() {
        return txtCaracteristicas;
    }

    public void setTxtCaracteristicas(JTextArea txtCaracteristicas) {
        this.txtCaracteristicas = txtCaracteristicas;
    }

    public JTextArea getTxtStock() {
        return txtStock;
    }

    public void setTxtStock(JTextArea txtStock) {
        this.txtStock = txtStock;
    }

    public JTextArea getTxtRaza() {
        return txtRaza;
    }

    public void setTxtRaza(JTextArea txtRaza) {
        this.txtRaza = txtRaza;
    }

    public JTextArea getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextArea txtColor) {
        this.txtColor = txtColor;
    }

    public JComboBox<String> getCmbTipoAnimal() {
        return cmbTipoAnimal;
    }

    public void setCmbTipoAnimal(JComboBox<String> cmbTipoAnimal) {
        this.cmbTipoAnimal = cmbTipoAnimal;
    }

    public JComboBox<String> getCmbFormatoDeVenta() {
        return cmbFormatoDeVenta;
    }

    public void setCmbFormatoDeVenta(JComboBox<String> cmbFormatoDeVenta) {
        this.cmbFormatoDeVenta = cmbFormatoDeVenta;
    }

    public JButton getBtnCrearMascota() {
        return btnCrearMascota;
    }

    public void setBtnCrearMascota(JButton btnCrearMascota) {
        this.btnCrearMascota = btnCrearMascota;
    }

    public JButton getBtnSeleccionarImagen() {
        return btnSeleccionarImagen;
    }

    public void setBtnSeleccionarImagen(JButton btnSeleccionarImagen) {
        this.btnSeleccionarImagen = btnSeleccionarImagen;
    }

    public JLabel getLblImagenPreview() {
        return lblImagenPreview;
    }

    public void setLblImagenPreview(JLabel lblImagenPreview) {
        this.lblImagenPreview = lblImagenPreview;
    }

    public File getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    public void setImagenSeleccionada(File imagenSeleccionada) {
        this.imagenSeleccionada = imagenSeleccionada;
    }
}
