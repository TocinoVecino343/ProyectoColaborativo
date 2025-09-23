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

public class PanelCrearCelular extends JPanel {
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblColor,
			lblMemoriaInterna, lblMemoriaRam, lblLargoPantalla, lblAnchoPantalla, lblAlturaPantalla, lblCamaraFrontal,
			lblCamaraTrasera, lblPoseeNfc;
	private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock, txtColor;
	private JComboBox<String> cmbMemoriaInterna, cmbMemoriaRam;
	private JFormattedTextField txtLargoPantalla, txtAnchoPantalla, txtAlturaPantalla, txtCamaraFrontal,
			txtCamaraTrasera;
	private JComboBox<String> cmbPoseeNfc;
	private JButton btnCrearCelular, btnSeleccionarImagen;
	private JButton btnActualizarCelular;
	private JButton btnBorrarCelular;
	private JLabel lblImagenPreview;
	private File imagenSeleccionada;

	// Colores estilo MercadoLibre
	// Colores estilo MercadoLibre
	private final Color COLOR_FONDO = new Color(235, 235, 235);
	private final Color COLOR_PANEL_BLANCO = Color.WHITE;
	private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
	private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
	private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
	private final Color COLOR_BOTON = new Color(52, 131, 250);
	private final Color COLOR_BOTON_ELIMINAR = new Color(220, 53, 69);

	public PanelCrearCelular() {
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

	private JPanel crearPanelFormulario() {
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

	private void inicializarCamposFormulario() {
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

	private void posicionarComponentesFormulario(JPanel panel) {
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

	private void seleccionarImagen() {
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
		textArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
				BorderFactory.createEmptyBorder(8, 12, 8, 12)));
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
		textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
				BorderFactory.createEmptyBorder(8, 12, 8, 12)));
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

	private void aplicarEfectoFocus(JTextArea textArea) {
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

	private void aplicarEfectoFocusTextField(JFormattedTextField textField) {
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

	public JLabel getLblColor() {
		return lblColor;
	}

	public void setLblColor(JLabel lblColor) {
		this.lblColor = lblColor;
	}

	public JLabel getLblMemoriaInterna() {
		return lblMemoriaInterna;
	}

	public void setLblMemoriaInterna(JLabel lblMemoriaInterna) {
		this.lblMemoriaInterna = lblMemoriaInterna;
	}

	public JLabel getLblMemoriaRam() {
		return lblMemoriaRam;
	}

	public void setLblMemoriaRam(JLabel lblMemoriaRam) {
		this.lblMemoriaRam = lblMemoriaRam;
	}

	public JLabel getLblLargoPantalla() {
		return lblLargoPantalla;
	}

	public void setLblLargoPantalla(JLabel lblLargoPantalla) {
		this.lblLargoPantalla = lblLargoPantalla;
	}

	public JLabel getLblAnchoPantalla() {
		return lblAnchoPantalla;
	}

	public void setLblAnchoPantalla(JLabel lblAnchoPantalla) {
		this.lblAnchoPantalla = lblAnchoPantalla;
	}

	public JLabel getLblAlturaPantalla() {
		return lblAlturaPantalla;
	}

	public void setLblAlturaPantalla(JLabel lblAlturaPantalla) {
		this.lblAlturaPantalla = lblAlturaPantalla;
	}

	public JLabel getLblCamaraFrontal() {
		return lblCamaraFrontal;
	}

	public void setLblCamaraFrontal(JLabel lblCamaraFrontal) {
		this.lblCamaraFrontal = lblCamaraFrontal;
	}

	public JLabel getLblCamaraTrasera() {
		return lblCamaraTrasera;
	}

	public void setLblCamaraTrasera(JLabel lblCamaraTrasera) {
		this.lblCamaraTrasera = lblCamaraTrasera;
	}

	public JLabel getLblPoseeNfc() {
		return lblPoseeNfc;
	}

	public void setLblPoseeNfc(JLabel lblPoseeNfc) {
		this.lblPoseeNfc = lblPoseeNfc;
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

	public JTextArea getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextArea txtColor) {
		this.txtColor = txtColor;
	}

	public JComboBox<String> getCmbMemoriaInterna() {
		return cmbMemoriaInterna;
	}

	public void setCmbMemoriaInterna(JComboBox<String> cmbMemoriaInterna) {
		this.cmbMemoriaInterna = cmbMemoriaInterna;
	}

	public JComboBox<String> getCmbMemoriaRam() {
		return cmbMemoriaRam;
	}

	public void setCmbMemoriaRam(JComboBox<String> cmbMemoriaRam) {
		this.cmbMemoriaRam = cmbMemoriaRam;
	}

	public JFormattedTextField getTxtLargoPantalla() {
		return txtLargoPantalla;
	}

	public void setTxtLargoPantalla(JFormattedTextField txtLargoPantalla) {
		this.txtLargoPantalla = txtLargoPantalla;
	}

	public JFormattedTextField getTxtAnchoPantalla() {
		return txtAnchoPantalla;
	}

	public void setTxtAnchoPantalla(JFormattedTextField txtAnchoPantalla) {
		this.txtAnchoPantalla = txtAnchoPantalla;
	}

	public JFormattedTextField getTxtAlturaPantalla() {
		return txtAlturaPantalla;
	}

	public void setTxtAlturaPantalla(JFormattedTextField txtAlturaPantalla) {
		this.txtAlturaPantalla = txtAlturaPantalla;
	}

	public JFormattedTextField getTxtCamaraFrontal() {
		return txtCamaraFrontal;
	}

	public void setTxtCamaraFrontal(JFormattedTextField txtCamaraFrontal) {
		this.txtCamaraFrontal = txtCamaraFrontal;
	}

	public JFormattedTextField getTxtCamaraTrasera() {
		return txtCamaraTrasera;
	}

	public void setTxtCamaraTrasera(JFormattedTextField txtCamaraTrasera) {
		this.txtCamaraTrasera = txtCamaraTrasera;
	}

	public JComboBox<String> getCmbPoseeNfc() {
		return cmbPoseeNfc;
	}

	public void setCmbPoseeNfc(JComboBox<String> cmbPoseeNfc) {
		this.cmbPoseeNfc = cmbPoseeNfc;
	}

	public JButton getBtnCrearCelular() {
		return btnCrearCelular;
	}

	public void setBtnCrearCelular(JButton btnCrearCelular) {
		this.btnCrearCelular = btnCrearCelular;
	}

	public File getImagenSeleccionada() {
		return imagenSeleccionada;
	}

	public void setImagenSeleccionada(File imagenSeleccionada) {
		this.imagenSeleccionada = imagenSeleccionada;
	}
	public JButton getBtnActualizarCelular() {
	    return btnActualizarCelular;
	}

	public JButton getBtnBorrarCelular() {
	    return btnBorrarCelular;
	}
	
}
