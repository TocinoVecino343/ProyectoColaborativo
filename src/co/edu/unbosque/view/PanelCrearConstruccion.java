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

public class PanelCrearConstruccion extends JPanel {
    private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblModelo,
            lblMaterial, lblColor, lblLargo, lblAncho, lblAltura;
    private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtMaterial,
            txtStock, txtColor, txtModelo;
    private JComboBox<String> cmbMaterial;
    private JFormattedTextField txtLargo, txtAncho, txtAltura;
    private JButton btnCrearConstruccion, btnSeleccionarImagen;
    private JLabel lblImagenPreview;
    private File imagenSeleccionada;
    
    // Colores estilo MercadoLibre
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
    private final Color COLOR_BOTON = new Color(52, 131, 250);

    public PanelCrearConstruccion() {
        this.setVisible(true);
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1280, 920);
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
    
    private JPanel crearPanelFormulario() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Layout absoluto como el original
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
    }
    
    private void posicionarComponentesFormulario(JPanel panel) {
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
        
        yLabel += gap; yField += gap;
        lblMarca.setBounds(x, yLabel, 200, 20);
        txtMarca.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblModelo.setBounds(x, yLabel, 200, 20);
        txtModelo.setBounds(x, yField, fieldWidth, fieldHeight);
        
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
        lblColor.setBounds(x, yLabel, 200, 20);
        txtColor.setBounds(x, yField, fieldWidth, fieldHeight);
        
        // Especificaciones del material
        yLabel += gap; yField += gap;
        lblMaterial.setBounds(x, yLabel, 200, 20);
        cmbMaterial.setBounds(x, yField, fieldWidth, fieldHeight);
        
        // Dimensiones
        yLabel += gap; yField += gap;
        lblLargo.setBounds(x, yLabel, 200, 20);
        txtLargo.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblAncho.setBounds(x, yLabel, 200, 20);
        txtAncho.setBounds(x, yField, fieldWidth, fieldHeight);
        
        yLabel += gap; yField += gap;
        lblAltura.setBounds(x, yLabel, 200, 20);
        txtAltura.setBounds(x, yField, fieldWidth, fieldHeight);
        
        // Botón
        btnCrearConstruccion.setBounds((panel.getPreferredSize().width - 220) / 2, yField + 80, 220, 45);
        
        // Agregar todos los componentes
        panel.add(lblNombre); panel.add(txtNombre);
        panel.add(lblMarca); panel.add(txtMarca);
        panel.add(lblModelo); panel.add(txtModelo);
        panel.add(lblDescripcion); panel.add(txtDescripcion);
        panel.add(lblTipo); panel.add(txtTipo);
        panel.add(lblPrecio); panel.add(txtPrecio);
        panel.add(lblCaracteristicas); panel.add(txtCaracteristicas);
        panel.add(lblStock); panel.add(txtStock);
        panel.add(lblColor); panel.add(txtColor);
        panel.add(lblMaterial); panel.add(cmbMaterial);
        panel.add(lblLargo); panel.add(txtLargo);
        panel.add(lblAncho); panel.add(txtAncho);
        panel.add(lblAltura); panel.add(txtAltura);
        panel.add(btnCrearConstruccion);
    }
    
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
        return combo;
    }
    
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

	public JLabel getLblModelo() {
		return lblModelo;
	}

	public void setLblModelo(JLabel lblModelo) {
		this.lblModelo = lblModelo;
	}

	public JLabel getLblMaterial() {
		return lblMaterial;
	}

	public void setLblMaterial(JLabel lblMaterial) {
		this.lblMaterial = lblMaterial;
	}

	public JLabel getLblColor() {
		return lblColor;
	}

	public void setLblColor(JLabel lblColor) {
		this.lblColor = lblColor;
	}

	public JLabel getLblLargo() {
		return lblLargo;
	}

	public void setLblLargo(JLabel lblLargo) {
		this.lblLargo = lblLargo;
	}

	public JLabel getLblAncho() {
		return lblAncho;
	}

	public void setLblAncho(JLabel lblAncho) {
		this.lblAncho = lblAncho;
	}

	public JLabel getLblAltura() {
		return lblAltura;
	}

	public void setLblAltura(JLabel lblAltura) {
		this.lblAltura = lblAltura;
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

	public JTextArea getTxtMaterial() {
		return txtMaterial;
	}

	public void setTxtMaterial(JTextArea txtMaterial) {
		this.txtMaterial = txtMaterial;
	}

	public JTextArea getTxtStock() {
		return txtStock;
	}

	public void setTxtStock(JTextArea txtStock) {
		this.txtStock = txtStock;
	}

	public JTextArea getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextArea txtColor) {
		this.txtColor = txtColor;
	}

	public JTextArea getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(JTextArea txtModelo) {
		this.txtModelo = txtModelo;
	}

	public JComboBox getCmbMaterial() {
		return cmbMaterial;
	}

	public void setCmbMaterial(JComboBox cmbMaterial) {
		this.cmbMaterial = cmbMaterial;
	}

	public JFormattedTextField getTxtLargo() {
		return txtLargo;
	}

	public void setTxtLargo(JFormattedTextField txtLargo) {
		this.txtLargo = txtLargo;
	}

	public JFormattedTextField getTxtAncho() {
		return txtAncho;
	}

	public void setTxtAncho(JFormattedTextField txtAncho) {
		this.txtAncho = txtAncho;
	}

	public JFormattedTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JFormattedTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

	public JButton getBtnCrearConstruccion() {
		return btnCrearConstruccion;
	}

	public void setBtnCrearConstruccion(JButton btnCrearConstruccion) {
		this.btnCrearConstruccion = btnCrearConstruccion;
	}

}
