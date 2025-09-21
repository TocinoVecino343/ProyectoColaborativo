package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.AlimentoYBebida;
import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.Construccion;
import co.edu.unbosque.model.DeporteYFitness;
import co.edu.unbosque.model.Electrodomestico;
import co.edu.unbosque.model.Farmacia;
import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.Moda;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.EmailInvalidoException;
import co.edu.unbosque.util.exception.EmailYaRegistradoException;
import co.edu.unbosque.util.exception.LanzadorExcepciones;
import co.edu.unbosque.view.ViewFacade;
import co.edu.unbosque.view.Ventana;

public class Controlador implements ActionListener {
	private ViewFacade vf;
	private ModelFacade mf;

	private Usuario usuarioLogueado;

	public Controlador() {
		this.vf = new ViewFacade();
		this.mf = new ModelFacade();

	}

	public void runGui() {
		System.out.println(mf.getAlimentoYBebidaDAO().mostrarDatos());
		inicializaraActionListener();
		vf.getVentana().add(vf.getPanelSuperior(), BorderLayout.NORTH);
		vf.getVentana().add(vf.getPanelLogin(), BorderLayout.CENTER);
		vf.getVentana().setSize(1280, 920);
		vf.getVentana().setLocationRelativeTo(null);
		vf.getVentana().setVisible(true);
	}

	private void iniciarSesion() {
		String email = vf.getPanelLogin().getTxtEmail().getText().trim();
		String contrasenia = new String(vf.getPanelLogin().getTxtContrasenia().getPassword());

		try {
			LanzadorExcepciones.validarEmail(email);
			Usuario usuario = mf.getUsuarioDAO().login(email, contrasenia);
			if (usuario != null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Bienvenido, " + usuario.getNombre() + "!",
						"Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);

				vf.getVentana().remove(vf.getPanelLogin());
				vf.getVentana().revalidate();
				vf.getVentana().repaint();

				vf.getPanelSuperior().getBtnCategoria().setVisible(true);
				vf.getPanelSuperior().getBtnVender().setVisible(true);
				vf.getPanelSuperior().getBtnCarro().setVisible(true);

				usuarioLogueado = usuario;

				vf.getPanelLogin().getTxtEmail().setText("");
				vf.getPanelLogin().getTxtContrasenia().setText("");
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Correo o contraseña incorrectos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (EmailInvalidoException ex) {
			JOptionPane.showMessageDialog(vf.getVentana(), ex.getMessage(), "Error de validación",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error inesperado: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void mostrarFormularioRegistro() {
		JDialog dialog = new JDialog(vf.getVentana(), "Crear Cuenta - Registro Completo", true);
		dialog.setSize(850, 750);
		dialog.setLocationRelativeTo(vf.getVentana());
		dialog.setLayout(new BorderLayout());

		JLabel title = new JLabel("Registra tu cuenta completa", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(new Color(52, 73, 94));
		title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		dialog.add(title, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

		JPanel form = new JPanel(new GridLayout(8, 2, 15, 15));
		form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JTextField txtNombre = new JTextField();
		JTextField txtNombreUsuario = new JTextField();
		JTextField txtDocumento = new JTextField();
		JTextField txtEmail = new JTextField();
		JTextField txtTelefono = new JTextField();
		JPasswordField txtContrasenia = new JPasswordField();

		JPanel panelImagen = new JPanel(new BorderLayout(10, 5));
		JTextField txtRutaImagen = new JTextField("No se ha seleccionado imagen");
		txtRutaImagen.setEditable(false);
		txtRutaImagen.setBackground(Color.WHITE);
		txtRutaImagen.setBorder(BorderFactory.createLoweredBevelBorder());
		JButton btnSeleccionarImagen = new JButton("Seleccionar Foto");
		btnSeleccionarImagen.setFont(new Font("Arial", Font.BOLD, 11));
		btnSeleccionarImagen.setBackground(new Color(52, 152, 219));
		btnSeleccionarImagen.setForeground(Color.WHITE);
		btnSeleccionarImagen.setFocusPainted(false);
		btnSeleccionarImagen.setPreferredSize(new Dimension(120, 25));
		JLabel lblPreviewImagen = new JLabel();
		lblPreviewImagen.setPreferredSize(new Dimension(80, 80));
		lblPreviewImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblPreviewImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreviewImagen.setText("Sin imagen");
		lblPreviewImagen.setOpaque(true);
		lblPreviewImagen.setBackground(Color.LIGHT_GRAY);

		panelImagen.add(txtRutaImagen, BorderLayout.CENTER);
		panelImagen.add(btnSeleccionarImagen, BorderLayout.EAST);

		estilizarCampoTexto(txtNombre);
		estilizarCampoTexto(txtNombreUsuario);
		estilizarCampoTexto(txtDocumento);
		estilizarCampoTexto(txtEmail);
		estilizarCampoTexto(txtTelefono);
		estilizarCampoTexto(txtContrasenia);

		form.add(crearLabel("Nombre completo:"));
		form.add(txtNombre);
		form.add(crearLabel("Nombre de usuario:"));
		form.add(txtNombreUsuario);
		form.add(crearLabel("Documento de identidad:"));
		form.add(txtDocumento);
		form.add(crearLabel("Correo electrónico:"));
		form.add(txtEmail);
		form.add(crearLabel("Número de teléfono:"));
		form.add(txtTelefono);
		form.add(crearLabel("Contraseña:"));
		form.add(txtContrasenia);
		form.add(crearLabel("Foto de perfil:"));
		form.add(panelImagen);

		JPanel previewPanel = new JPanel(new FlowLayout());
		previewPanel.add(new JLabel("Vista previa:"));
		previewPanel.add(lblPreviewImagen);

		btnSeleccionarImagen.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Seleccionar foto de perfil");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter(
					"Imágenes (*.jpg, *.jpeg, *.png, *.gif)", "jpg", "jpeg", "png", "gif");
			fileChooser.setFileFilter(filter);
			fileChooser.setCurrentDirectory(new java.io.File("."));
			int result = fileChooser.showOpenDialog(dialog);
			if (result == JFileChooser.APPROVE_OPTION) {
				java.io.File selectedFile = fileChooser.getSelectedFile();
				String rutaArchivo = selectedFile.getAbsolutePath();
				txtRutaImagen.setText(selectedFile.getName());
				try {
					ImageIcon imageIcon = new ImageIcon(rutaArchivo);
					Image img = imageIcon.getImage();
					Image scaledImg = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon = new ImageIcon(scaledImg);
					lblPreviewImagen.setIcon(scaledIcon);
					lblPreviewImagen.setText("");
					txtRutaImagen.setToolTipText(rutaArchivo);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(dialog, "Error al cargar la imagen: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel contentPanel = new JPanel(new BorderLayout(0, 15));
		contentPanel.add(form, BorderLayout.CENTER);
		contentPanel.add(previewPanel, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(contentPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		mainPanel.add(scrollPane, BorderLayout.CENTER);

		JButton btnRegistrar = new JButton("Crear Cuenta");
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBackground(new Color(46, 204, 113));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setPreferredSize(new Dimension(200, 45));
		btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnRegistrar.setBackground(new Color(39, 174, 96));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnRegistrar.setBackground(new Color(46, 204, 113));
			}
		});

		btnRegistrar.addActionListener(e2 -> {
			String rutaImagenCompleta = txtRutaImagen.getToolTipText();
			if (rutaImagenCompleta == null || rutaImagenCompleta.isEmpty()) {
				rutaImagenCompleta = "assets/foto_perfil.png";
			}
			validarYCrearUsuario(dialog, txtNombre, txtNombreUsuario, txtDocumento, txtEmail, txtTelefono,
					txtContrasenia, rutaImagenCompleta);
		});

		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		buttonPanel.add(btnRegistrar);

		dialog.add(mainPanel, BorderLayout.CENTER);
		dialog.add(buttonPanel, BorderLayout.SOUTH);
		dialog.setVisible(true);
	}

	private JLabel crearLabel(String texto) {
		JLabel label = new JLabel(texto);
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setForeground(new Color(44, 62, 80));
		return label;
	}

	private void estilizarCampoTexto(JTextField campo) {
		campo.setFont(new Font("Arial", Font.PLAIN, 13));
		campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
				BorderFactory.createEmptyBorder(5, 8, 5, 8)));
		campo.setPreferredSize(new Dimension(200, 35));

		campo.addFocusListener(new java.awt.event.FocusListener() {
			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				campo.setBorder(
						BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
								BorderFactory.createEmptyBorder(4, 7, 4, 7)));
			}

			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				campo.setBorder(
						BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
								BorderFactory.createEmptyBorder(5, 8, 5, 8)));
			}
		});
	}

	private void validarYCrearUsuario(JDialog dialog, JTextField txtNombre, JTextField txtNombreUsuario,
			JTextField txtDocumento, JTextField txtEmail, JTextField txtTelefono, JPasswordField txtContrasenia,
			String rutaImagen) {
		String nombre = txtNombre.getText().trim();
		String nombreUsuario = txtNombreUsuario.getText().trim();
		String documentoStr = txtDocumento.getText().trim();
		String email = txtEmail.getText().trim();
		String telefonoStr = txtTelefono.getText().trim();
		String contrasenia = new String(txtContrasenia.getPassword());

		if (nombre.isEmpty()) {
			mostrarErrorValidacion(dialog, "El nombre completo es obligatorio.", txtNombre);
			return;
		}
		if (nombre.length() < 2) {
			mostrarErrorValidacion(dialog, "El nombre debe tener al menos 2 caracteres.", txtNombre);
			return;
		}
		if (nombreUsuario.isEmpty()) {
			mostrarErrorValidacion(dialog, "El nombre de usuario es obligatorio.", txtNombreUsuario);
			return;
		}
		if (nombreUsuario.length() < 3) {
			mostrarErrorValidacion(dialog, "El nombre de usuario debe tener al menos 3 caracteres.", txtNombreUsuario);
			return;
		}
		if (documentoStr.isEmpty()) {
			mostrarErrorValidacion(dialog, "El documento de identidad es obligatorio.", txtDocumento);
			return;
		}
		if (!documentoStr.matches("\\d{6,12}")) {
			mostrarErrorValidacion(dialog, "El documento debe ser un número entre 6 y 12 dígitos.", txtDocumento);
			return;
		}
		if (email.isEmpty()) {
			mostrarErrorValidacion(dialog, "El correo electrónico es obligatorio.", txtEmail);
			return;
		}
		if (telefonoStr.isEmpty()) {
			mostrarErrorValidacion(dialog, "El número de teléfono es obligatorio.", txtTelefono);
			return;
		}
		if (!telefonoStr.matches("\\d{7,15}")) {
			mostrarErrorValidacion(dialog, "El teléfono debe ser un número entre 7 y 15 dígitos.", txtTelefono);
			return;
		}
		if (contrasenia.length() < 8) {
			mostrarErrorValidacion(dialog, "La contraseña debe tener al menos 8 caracteres.", txtContrasenia);
			return;
		}
		if (!validarFortalezaContrasenia(contrasenia)) {
			mostrarErrorValidacion(dialog,
					"La contraseña debe contener al menos:\n- Una letra mayúscula\n- Una letra minúscula\n- Un número",
					txtContrasenia);
			return;
		}

		try {
			LanzadorExcepciones.validarEmail(email);
			LanzadorExcepciones.verificarEmailNoRegistrado(email);
			int documento = Integer.parseInt(documentoStr);
			int telefono = Integer.parseInt(telefonoStr);
			int id = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;
			String rutaImagenFinal = (rutaImagen != null && !rutaImagen.isEmpty()) ? rutaImagen
					: "assets/foto_perfil.png";

			Usuario nuevoUsuario = new Usuario(nombre, nombreUsuario, documento, email, telefono, contrasenia,
					rutaImagenFinal, id);
			mf.getUsuarioDAO().crear(nuevoUsuario);

			String mensajeExito = String.format(
					"¡Cuenta creada exitosamente! \nDetalles de tu cuenta:\nNombre: %s\nID de usuario: %d\nEmail: %s\n¡Bienvenido a MercadoLibre!",
					nombre, id, email);
			JOptionPane.showMessageDialog(dialog, mensajeExito, "¡Registro Exitoso!", JOptionPane.INFORMATION_MESSAGE);
			dialog.dispose();
		} catch (EmailInvalidoException e) {
			mostrarErrorValidacion(dialog, e.getMessage(), txtEmail);
		} catch (EmailYaRegistradoException e) {
			mostrarErrorValidacion(dialog, e.getMessage(), txtEmail);
		} catch (NumberFormatException e) {
			mostrarErrorValidacion(dialog, "Error en el formato de los números ingresados.", null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dialog, "Error inesperado al crear la cuenta: " + e.getMessage(),
					"Error del Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void mostrarErrorValidacion(JDialog dialog, String mensaje, JTextField campo) {
		JOptionPane.showMessageDialog(dialog, mensaje, "Error de Validación", JOptionPane.WARNING_MESSAGE);
		if (campo != null) {
			campo.requestFocus();
			campo.selectAll();
		}
	}

	private boolean validarFortalezaContrasenia(String contrasenia) {
		boolean tieneMayuscula = contrasenia.matches(".*[A-Z].*");
		boolean tieneMinuscula = contrasenia.matches(".*[a-z].*");
		boolean tieneNumero = contrasenia.matches(".*\\d.*");
		return tieneMayuscula && tieneMinuscula && tieneNumero;
	}

	private void ocultarTodosLosPaneles() {
		vf.getVentana().remove(vf.getPanelSeleccionarCategoria());
		vf.getVentana().remove(vf.getPanelCrearAlimentoYBebida());
		vf.getVentana().remove(vf.getPanelCrearCelular());
		vf.getVentana().remove(vf.getPanelCrearConstruccion());
		vf.getVentana().remove(vf.getPanelCDeporteYFitness());
		vf.getVentana().remove(vf.getPanelCrearElectrodomesticos());
		vf.getVentana().remove(vf.getPanelCrearJuguete());
		vf.getVentana().remove(vf.getPanelCrearMascota());
		vf.getVentana().remove(vf.getPanelCrearMedicamento());
		vf.getVentana().remove(vf.getPanelCrearProductoModa());
		vf.getVentana().remove(vf.getPanelCrearVehiculo());
		vf.getVentana().remove(vf.getPanelUsuario());
		vf.getVentana().remove(vf.getPanelPerfil());
		vf.getVentana().remove(vf.getPanelMetodoDePago());
	}

	private void guardarAlimentoYBebida() {
		String nombre = vf.getPanelCrearAlimentoYBebida().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearAlimentoYBebida().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearAlimentoYBebida().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearAlimentoYBebida().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().getText().trim();
		String caracteristicas = vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearAlimentoYBebida().getTxtStock().getText().trim());
		boolean esLiquido = "si"
				.equals(vf.getPanelCrearAlimentoYBebida().getCmbEsLiquido().getSelectedItem().toString());
		int cantidadProducto = Integer
				.parseInt(vf.getPanelCrearAlimentoYBebida().getTxtCantidadProducto().getText().trim());
		String tipoEnvase = vf.getPanelCrearAlimentoYBebida().getCmbTipoEnvase().getSelectedItem().toString();
		String unidadEnvase = vf.getPanelCrearAlimentoYBebida().getTxtUnidadEnvase().getText().trim();

		AlimentoYBebida nuevoProducto = new AlimentoYBebida(nombre, descripcion, tipoEnvase, precio, marca, vendedor,
				caracteristicas, stock, cantidadProducto);

		mf.getAlimentoYBebidaDAO().crear(nuevoProducto);

		JOptionPane.showMessageDialog(vf.getVentana(), "¡Alimento y bebida guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelAlimentoYBebida();
	}

	private void guardarCelular() {
		String nombre = vf.getPanelCrearCelular().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearCelular().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearCelular().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearCelular().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearCelular().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearCelular().getTxtCaracteristicas().getText().trim();
		String caracteristicas = vf.getPanelCrearCelular().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearCelular().getTxtStock().getText().trim());
		String color = vf.getPanelCrearCelular().getTxtColor().getText().trim();
		int memoriaInterna = Integer
				.parseInt((String) vf.getPanelCrearCelular().getCmbMemoriaInterna().getSelectedItem());
		int memoriaRam = Integer.parseInt((String) vf.getPanelCrearCelular().getCmbMemoriaRam().getSelectedItem());
		float largoPantalla = Float.parseFloat(vf.getPanelCrearCelular().getTxtLargoPantalla().getText().trim());
		float anchoPantalla = Float.parseFloat(vf.getPanelCrearCelular().getTxtAnchoPantalla().getText().trim());
		float altoPantalla = Float.parseFloat(vf.getPanelCrearCelular().getTxtAlturaPantalla().getText().trim());
		int camaraFrontal = Integer.parseInt(vf.getPanelCrearCelular().getTxtCamaraFrontal().getText().trim());
		int camaraTrasera = Integer.parseInt(vf.getPanelCrearCelular().getTxtCamaraTrasera().getText().trim());
		boolean poseeNfc = "si".equals(vf.getPanelCrearCelular().getCmbPoseeNfc().getSelectedItem());

		Celular nuevoProducto = new Celular(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
				usuarioLogueado.getId(), color, memoriaInterna, memoriaRam, largoPantalla, anchoPantalla, altoPantalla,
				camaraFrontal, camaraTrasera, poseeNfc);

		mf.getCelularDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Celular guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelCelular();
	}

	private void guardarConstruccion() {
		String nombre = vf.getPanelCrearConstruccion().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearConstruccion().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearConstruccion().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearConstruccion().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearConstruccion().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearConstruccion().getTxtCaracteristicas().getText().trim();
		String caracteristicas = vf.getPanelCrearConstruccion().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearConstruccion().getTxtStock().getText().trim());
		String modelo = vf.getPanelCrearConstruccion().getTxtModelo().getText().trim();
		String material = vf.getPanelCrearConstruccion().getCmbMaterial().getSelectedItem().toString();
		String color = vf.getPanelCrearConstruccion().getTxtColor().getText().trim();
		float largo = Float.parseFloat(vf.getPanelCrearConstruccion().getTxtLargo().getText().trim());
		float ancho = Float.parseFloat(vf.getPanelCrearConstruccion().getTxtAncho().getText().trim());
		float altura = Float.parseFloat(vf.getPanelCrearConstruccion().getTxtAltura().getText().trim());

		Construccion nuevoProducto = new Construccion(nombre, descripcion, tipo, precio, marca, vendedor,
				caracteristicas, stock, usuarioLogueado.getId(), modelo, material, color, largo, ancho, altura);

		mf.getConstruccionDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de construcción guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelConstruccion();
	}

	private void guardarDeporteYFitness() {
		String nombre = vf.getPanelCDeporteYFitness().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCDeporteYFitness().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCDeporteYFitness().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCDeporteYFitness().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCDeporteYFitness().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCDeporteYFitness().getTxtCaracteristicas().getText().trim();
		String caracteristicas = vf.getPanelCDeporteYFitness().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCDeporteYFitness().getTxtStock().getText().trim());
		String color = vf.getPanelCDeporteYFitness().getTxtColor().getText().trim();
		String material = vf.getPanelCDeporteYFitness().getTxtMaterial().getText().trim();

		DeporteYFitness nuevoProducto = new DeporteYFitness(nombre, descripcion, tipo, precio, marca, vendedor,
				caracteristicas, stock, usuarioLogueado.getId(), color, material);

		mf.getDeporteYFitnessDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de deporte y fitness guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelDeporteYFitness();
	}

	private void guardarElectrodomestico() {
		String nombre = vf.getPanelCrearElectrodomesticos().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearElectrodomesticos().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearElectrodomesticos().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearElectrodomesticos().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearElectrodomesticos().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearElectrodomesticos().getTxtVendedor().getText().trim();
		String caracteristicas = vf.getPanelCrearElectrodomesticos().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearElectrodomesticos().getTxtStock().getText().trim());
		String modelo = vf.getPanelCrearElectrodomesticos().getTxtModelo().getText().trim();
		int voltaje = Integer.parseInt(vf.getPanelCrearElectrodomesticos().getTxtVoltaje().getText().trim());
		String color = vf.getPanelCrearElectrodomesticos().getTxtColor().getText().trim();

		Electrodomestico nuevoProducto = new Electrodomestico(nombre, descripcion, tipo, precio, marca, vendedor,
				caracteristicas, stock, usuarioLogueado.getId(), modelo, voltaje, color);

		mf.getElectrodomesticoDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Electrodoméstico guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelElectrodomestico();
	}

	private void guardarJuguete() {
		String nombre = vf.getPanelCrearJuguete().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearJuguete().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearJuguete().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearJuguete().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearJuguete().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearJuguete().getTxtVendedor().getText().trim();
		String caracteristicas = vf.getPanelCrearJuguete().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearJuguete().getTxtStock().getText().trim());
		String color = vf.getPanelCrearJuguete().getTxtColor().getText().trim();
		String material = vf.getPanelCrearJuguete().getTxtMaterial().getText().trim();
		String rangoEdad = vf.getPanelCrearJuguete().getTxtRangoDeEdad().getText().trim();

		Juguete nuevoProducto = new Juguete(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
				usuarioLogueado.getId(), color, material, rangoEdad);

		mf.getJugueteDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Juguete guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelJuguete();
	}

	private void guardarMascota() {
		String nombre = vf.getPanelCrearMascota().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearMascota().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearMascota().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearMascota().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearMascota().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearMascota().getTxtCaracteristicas().getText().trim();
		String caracteristicas = vf.getPanelCrearMascota().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearMascota().getTxtStock().getText().trim());
		String tipoAnimal = vf.getPanelCrearMascota().getCmbTipoAnimal().getSelectedItem().toString();
		String raza = vf.getPanelCrearMascota().getTxtRaza().getText().trim();
		String color = vf.getPanelCrearMascota().getTxtColor().getText().trim();
		String formatoVenta = vf.getPanelCrearMascota().getCmbFormatoDeVenta().getSelectedItem().toString();

		Mascota nuevoProducto = new Mascota(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
				usuarioLogueado.getId(), tipoAnimal, raza, color, formatoVenta);

		mf.getMascotaDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto para mascota guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelMascota();
	}

	private void guardarMedicamento() {
		String nombre = vf.getPanelCrearMedicamento().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearMedicamento().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearMedicamento().getTxtTipo().getText().trim();
		float precio = Float.parseFloat(vf.getPanelCrearMedicamento().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearMedicamento().getTxtMarca().getText().trim();
		String vendedor = vf.getPanelCrearMedicamento().getTxtVendedor().getText().trim();
		String caracteristicas = vf.getPanelCrearMedicamento().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearMedicamento().getTxtStock().getText().trim());
		String laboratorio = vf.getPanelCrearMedicamento().getTxtLaboratorio().getText().trim();
		String formatoMedicamento = vf.getPanelCrearMedicamento().getCmbFormatoMedicamento().getSelectedItem()
				.toString();
		String formatoVenta = vf.getPanelCrearMedicamento().getCmbFormatoDeVenta().getSelectedItem().toString();

		Farmacia nuevoProducto = new Farmacia(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas,
				stock, usuarioLogueado.getId(), laboratorio, formatoMedicamento, formatoVenta);

		mf.getFarmaciaDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Medicamento guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelMedicamento();
	}

	private void guardarModa() {
		String nombre = vf.getPanelCrearProductoModa().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearProductoModa().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearProductoModa().getCmbTipo().getSelectedItem().toString();
		float precio = Float.parseFloat(vf.getPanelCrearProductoModa().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearProductoModa().getCmbMarca().getSelectedItem().toString();
		String vendedor = vf.getPanelCrearProductoModa().getTxtCaracteristicas().getText().trim();
		String caracteristicas = vf.getPanelCrearProductoModa().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearProductoModa().getTxtStock().getText().trim());
		String color = vf.getPanelCrearProductoModa().getTxtColor().getText().trim();
		String talla = vf.getPanelCrearProductoModa().getCmbTalla().getSelectedItem().toString();
		String material = vf.getPanelCrearProductoModa().getCmbMaterial().getSelectedItem().toString();

		Moda nuevoProducto = new Moda(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
				usuarioLogueado.getId(), color, talla, material);

		mf.getModaDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de moda guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelModa();
	}

	private void guardarVehiculo() {
		String nombre = vf.getPanelCrearVehiculo().getTxtNombre().getText().trim();
		String descripcion = vf.getPanelCrearVehiculo().getTxtDescripcion().getText().trim();
		String tipo = vf.getPanelCrearVehiculo().getCmbTipo().getSelectedItem().toString();
		float precio = Float.parseFloat(vf.getPanelCrearVehiculo().getTxtPrecio().getText().trim());
		String marca = vf.getPanelCrearVehiculo().getCmbMarca().getSelectedItem().toString();
		String caracteristicas = vf.getPanelCrearVehiculo().getTxtCaracteristicas().getText().trim();
		int stock = Integer.parseInt(vf.getPanelCrearVehiculo().getTxtStock().getText().trim());
		int anio = Integer.parseInt(vf.getPanelCrearVehiculo().getCmbAnio().getSelectedItem().toString());
		int kilometraje = Integer.parseInt(vf.getPanelCrearVehiculo().getTxtKilometraje().getText().trim());
		boolean esFinanciable = "Si"
				.equals(vf.getPanelCrearVehiculo().getCmbEsFinanciable().getSelectedItem().toString());

		Vehiculo nuevoProducto = new Vehiculo(nombre, descripcion, tipo, precio, marca, "Vendedor", caracteristicas,
				stock, usuarioLogueado.getId(), esFinanciable, kilometraje, anio);

		mf.getVehiculoDAO().crear(nuevoProducto);
		JOptionPane.showMessageDialog(vf.getVentana(), "¡Vehículo guardado exitosamente!", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarPanelVehiculo();
	}

	public void mostrarPanelActualizarAlimentoYBebida() {
		vf.getPanelCrearAlimentoYBebida().getTxtNombre().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtTipo().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtPrecio().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtMarca().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtVendedor().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtStock().setText();
		vf.getPanelCrearAlimentoYBebida().getCmbEsLiquido().getSelectedItem(String.valueOf());
		vf.getPanelCrearAlimentoYBebida().getTxtCantidadProducto().setText();
		vf.getPanelCrearAlimentoYBebida().getCmbTipoEnvase().setSelectedItem();
		vf.getPanelCrearAlimentoYBebida().getTxtUnidadEnvase().setText();

	}

	public void mostrarPanelActualizarCelular() {
		vf.getPanelCrearCelular().getTxtNombre().setText();
		vf.getPanelCrearCelular().getTxtDescripcion().setText();
		vf.getPanelCrearCelular().getTxtTipo().setText();
		vf.getPanelCrearCelular().getTxtPrecio().setText();
		vf.getPanelCrearCelular().getTxtMarca().setText();
		vf.getPanelCrearCelular().getTxtVendedor().setText();
		vf.getPanelCrearCelular().getTxtCaracteristicas().setText();
		vf.getPanelCrearCelular().getTxtStock().setText();

		vf.getPanelCrearCelular().getTxtColor().setText();
		vf.getPanelCrearCelular().getCmbMemoriaInterna().setSelectedItem();
		vf.getPanelCrearCelular().getCmbMemoriaRam().setSelectedItem();
		vf.getPanelCrearCelular().getTxtLargoPantalla().setText();
		vf.getPanelCrearCelular().getTxtAnchoPantalla().setText();
		vf.getPanelCrearCelular().getTxtAlturaPantalla().setText();
		vf.getPanelCrearCelular().getTxtCamaraFrontal().setText();
		vf.getPanelCrearCelular().getTxtCamaraTrasera().setText();
		vf.getPanelCrearCelular().getCmbPoseeNfc().setSelectedItem(String.valueOf());

	}

	public void mostrarPanelActualizarConstruccion() {
		vf.getPanelCrearConstruccion().getTxtNombre().setText();
		vf.getPanelCrearConstruccion().getTxtDescripcion().setText();
		vf.getPanelCrearConstruccion().getTxtTipo().setText();
		vf.getPanelCrearConstruccion().getTxtPrecio().setText();
		vf.getPanelCrearConstruccion().getTxtMarca().setText();
		vf.getPanelCrearConstruccion().getTxtVendedor().setText();
		vf.getPanelCrearConstruccion().getTxtCaracteristicas().setText();
		vf.getPanelCrearConstruccion().getTxtStock().setText();

		vf.getPanelCrearConstruccion().getTxtModelo().setText();
		vf.getPanelCrearConstruccion().getTxtMaterial().setText();
		vf.getPanelCrearConstruccion().getTxtColor().setText();
		vf.getPanelCrearConstruccion().getTxtLargo().setText();
		vf.getPanelCrearConstruccion().getTxtAncho().setText();
		vf.getPanelCrearConstruccion().getTxtAltura().setText();

	}

	public void mostrarPanelActualizarDeporteYFitness() {
		vf.getPanelCDeporteYFitness().getTxtNombre().setText();
		vf.getPanelCDeporteYFitness().getTxtDescripcion().setText();
		vf.getPanelCDeporteYFitness().getTxtTipo().setText();
		vf.getPanelCDeporteYFitness().getTxtPrecio().setText();
		vf.getPanelCDeporteYFitness().getTxtMarca().setText();
		vf.getPanelCDeporteYFitness().getTxtVendedor().setText();
		vf.getPanelCDeporteYFitness().getTxtCaracteristicas().setText();
		vf.getPanelCDeporteYFitness().getTxtStock().setText();

		vf.getPanelCDeporteYFitness().getTxtColor().setText();
		vf.getPanelCDeporteYFitness().getTxtMaterial().setText();

	}

	public void mostrarPanelActualizarElectrodomestico() {
		vf.getPanelCrearElectrodomesticos().getTxtNombre().setText();
		vf.getPanelCrearElectrodomesticos().getTxtDescripcion().setText();
		vf.getPanelCrearElectrodomesticos().getTxtTipo().setText();
		vf.getPanelCrearElectrodomesticos().getTxtPrecio().setText();
		vf.getPanelCrearElectrodomesticos().getTxtMarca().setText();
		vf.getPanelCrearElectrodomesticos().getTxtVendedor().setText();
		vf.getPanelCrearElectrodomesticos().getTxtCaracteristicas().setText();
		vf.getPanelCrearElectrodomesticos().getTxtStock().setText();
		vf.getPanelCrearElectrodomesticos().getTxtModelo().setText();
		vf.getPanelCrearElectrodomesticos().getTxtVoltaje().setText();
		vf.getPanelCrearElectrodomesticos().getTxtColor().setText();

	}

	public void mostrarPanelActualizarMedicamento() {
		vf.getPanelCrearMedicamento().getTxtNombre().setText();
		vf.getPanelCrearMedicamento().getTxtDescripcion().setText();
		vf.getPanelCrearMedicamento().getTxtTipo().setText();
		vf.getPanelCrearMedicamento().getTxtPrecio().setText();
		vf.getPanelCrearMedicamento().getTxtMarca().setText();
		vf.getPanelCrearMedicamento().getTxtVendedor().setText();
		vf.getPanelCrearMedicamento().getTxtCaracteristicas().setText();
		vf.getPanelCrearMedicamento().getTxtStock().setText();
		vf.getPanelCrearMedicamento().getTxtLaboratorio().setText();
		vf.getPanelCrearMedicamento().getCmbFormatoMedicamento().setSelectedItem();
		vf.getPanelCrearMedicamento().getCmbFormatoDeVenta().setSelectedItem();

	}

	public void mostrarPanelActualizarJuguete() {
		vf.getPanelCrearJuguete().getTxtNombre().setText();
		vf.getPanelCrearJuguete().getTxtDescripcion().setText();
		vf.getPanelCrearJuguete().getTxtTipo().setText();
		vf.getPanelCrearJuguete().getTxtPrecio().setText();
		vf.getPanelCrearJuguete().getTxtMarca().setText();
		vf.getPanelCrearJuguete().getTxtVendedor().setText();
		vf.getPanelCrearJuguete().getTxtCaracteristicas().setText();
		vf.getPanelCrearJuguete().getTxtStock().setText();
		vf.getPanelCrearJuguete().getTxtColor().setText();
		vf.getPanelCrearJuguete().getTxtMaterial().setText();
		vf.getPanelCrearJuguete().getTxtRangoDeEdad().setText();

	}

	public void mostrarPanelActualizarMascota() {
		vf.getPanelCrearAlimentoYBebida().getTxtNombre().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtTipo().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtPrecio().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtMarca().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtVendedor().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtStock().setText();

	}

	public void mostrarPanelActualizarModa() {
		vf.getPanelCrearAlimentoYBebida().getTxtNombre().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtTipo().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtPrecio().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtMarca().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtVendedor().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtStock().setText();

	}

	public void mostrarPanelActualizarVehiculo() {
		vf.getPanelCrearAlimentoYBebida().getTxtNombre().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtTipo().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtPrecio().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtMarca().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtVendedor().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().setText();
		vf.getPanelCrearAlimentoYBebida().getTxtStock().setText();

	}

	public void mostrarPanelPerfil() {
		vf.getPanelPerfil().getLblImagenPerfil().setText(usuarioLogueado.getRutaImagenDePerfil());
		vf.getPanelPerfil().getLblNombre().setText(usuarioLogueado.getNombre());
		vf.getPanelPerfil().getLblEmail().setText(usuarioLogueado.getEmail());
	}

	public void mostrarPanelUsuario() {
		vf.getPanelUsuario().getTxtNombre().setText(usuarioLogueado.getNombre());
		vf.getPanelUsuario().getTxtNombreUsuario().setText(usuarioLogueado.getNombreDeUsuario());
		vf.getPanelUsuario().getTxtEmail().setText(usuarioLogueado.getEmail());
		vf.getPanelUsuario().getTxtDocumento().setText(String.valueOf(usuarioLogueado.getDocumentoDeIdentidad()));
		vf.getPanelUsuario().getTxtTelefono().setText(String.valueOf(usuarioLogueado.getTelefono()));
		vf.getPanelUsuario().getTxtContrasenia().setText(usuarioLogueado.getContrasenia());
	}

	public void mostrarPanelMetodoDePago() {

		vf.getPanelMetodoDePago().getLblTitular().setText();
		vf.getPanelMetodoDePago().getLblNumeroTarjeta().setText();
		vf.getPanelMetodoDePago().getLblFechaVencimiento();
		vf.getPanelMetodoDePago().getLblPinSeguridad();
	}

	private void limpiarPanelAlimentoYBebida() {
		var p = vf.getPanelCrearAlimentoYBebida();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getCmbEsLiquido().setSelectedIndex(0);
		p.getTxtCantidadDelProducto().setValue(0);
		p.getCmbTipoEnvase().setSelectedIndex(0);
		p.getCmbUnidadEnvase().setSelectedIndex(0);
	}

	private void limpiarPanelCelular() {
		var p = vf.getPanelCrearCelular();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtColor().setText("");
		p.getCmbMemoriaInterna().setSelectedIndex(0);
		p.getCmbMemoriaRam().setSelectedIndex(0);
		p.getTxtLargoPantalla().setValue(0);
		p.getTxtAnchoPantalla().setValue(0);
		p.getTxtAlturaPantalla().setValue(0);
		p.getTxtCamaraFrontal().setValue(0);
		p.getTxtCamaraTrasera().setValue(0);
		p.getCmbPoseeNfc().setSelectedIndex(0);
	}

	private void limpiarPanelConstruccion() {
		var p = vf.getPanelCrearConstruccion();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtModelo().setText("");
		p.getCmbMaterial().setSelectedIndex(0);
		p.getTxtColor().setText("");
		p.getTxtLargo().setValue(0);
		p.getTxtAncho().setValue(0);
		p.getTxtAltura().setValue(0);
	}

	private void limpiarPanelDeporteYFitness() {
		var p = vf.getPanelCDeporteYFitness();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtColor().setText("");
		p.getTxtMaterial().setText("");
	}

	private void limpiarPanelElectrodomestico() {
		var p = vf.getPanelCrearElectrodomesticos();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtVendedor().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtModelo().setText("");
		p.getTxtVoltaje().setText("");
		p.getTxtColor().setText("");
	}

	private void limpiarPanelJuguete() {
		var p = vf.getPanelCrearJuguete();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtVendedor().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtColor().setText("");
		p.getTxtMaterial().setText("");
		p.getTxtRangoDeEdad().setText("");
	}

	private void limpiarPanelMascota() {
		var p = vf.getPanelCrearMascota();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getCmbTipoAnimal().setSelectedIndex(0);
		p.getTxtRaza().setText("");
		p.getTxtColor().setText("");
		p.getCmbFormatoDeVenta().setSelectedIndex(0);
	}

	private void limpiarPanelMedicamento() {
		var p = vf.getPanelCrearMedicamento();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtTipo().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtMarca().setText("");
		p.getTxtVendedor().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtLaboratorio().setText("");
		p.getCmbFormatoMedicamento().setSelectedIndex(0);
		p.getCmbFormatoDeVenta().setSelectedIndex(0);
	}

	private void limpiarPanelModa() {
		var p = vf.getPanelCrearProductoModa();
		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getCmbTipo().setSelectedIndex(0);
		p.getTxtPrecio().setText("");
		p.getCmbMarca().setSelectedIndex(0);
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtColor().setText("");
		p.getCmbTalla().setSelectedIndex(0);
		p.getCmbMaterial().setSelectedIndex(0);
	}

	private void limpiarPanelVehiculo() {
		var p = vf.getPanelCrearVehiculo();

		p.getTxtNombre().setText("");
		p.getTxtDescripcion().setText("");
		p.getTxtPrecio().setText("");
		p.getTxtCaracteristicas().setText("");
		p.getTxtStock().setText("");
		p.getTxtKilometraje().setText("");
		p.getCmbTipo().setSelectedIndex(0);
		p.getCmbMarca().setSelectedIndex(0);
		p.getCmbAnio().setSelectedIndex(0);
		p.getCmbEsFinanciable().setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		switch (comando) {
		case "Iniciar Sesion": {
			iniciarSesion();
			break;
		}

		case "Crear Cuenta": {
			mostrarFormularioRegistro();
			break;
		}

		case "Categorias": {
			JOptionPane.showMessageDialog(vf.getVentana(), "Funcionalidad de categorías en desarrollo", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		case "Vender": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelSeleccionarCategoria(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Carrito": {
			JOptionPane.showMessageDialog(vf.getVentana(), "Funcionalidad del carrito en desarrollo", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		case "Alimentos y Bebidas": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearAlimentoYBebida(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			System.out.println(mf.getAlimentoYBebidaDAO().mostrarDatos());
			break;
		}

		case "Celulares": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearCelular(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Construccion": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearConstruccion(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Deporte y Fitness": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCDeporteYFitness(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Electrodomesticos": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearElectrodomesticos(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Juguetes": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearJuguete(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Mascotas": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearMascota(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Medicamentos": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearMedicamento(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Moda": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearProductoModa(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Vehiculos": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearVehiculo(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Crear AlimentoYBebida": {
			guardarAlimentoYBebida();
			break;
		}

		case "Crear Celular": {
			guardarCelular();
			break;
		}

		case "Crear Construccion": {
			guardarConstruccion();
			break;
		}

		case "Crear DeporteYFitness": {
			guardarDeporteYFitness();
			break;
		}

		case "Crear Electrodomestico": {
			guardarElectrodomestico();
			break;
		}

		case "Crear Juguete": {
			guardarJuguete();
			break;
		}

		case "Crear Mascota": {
			guardarMascota();
			break;
		}

		case "Crear Medicamento": {
			guardarMedicamento();
			break;
		}

		case "Crear Moda": {
			guardarModa();
			break;
		}

		case "Crear Vehiculo": {
			guardarVehiculo();
			break;
		}

		// Paneles para Actualizar
		case "Panel Actualizar Alimentos y Bebidas": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearAlimentoYBebida(), BorderLayout.CENTER);
			mostrarPanelActualizarAlimentoYBebida();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			System.out.println(mf.getAlimentoYBebidaDAO().mostrarDatos());
			break;
		}

		case "Panel Actualizar Celulares": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearCelular(), BorderLayout.CENTER);
			mostrarPanelActualizarCelular();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Construcción": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearConstruccion(), BorderLayout.CENTER);
			mostrarPanelActualizarConstruccion();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Deporte y Fitness": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCDeporteYFitness(), BorderLayout.CENTER);
			mostrarPanelActualizarDeporteYFitness();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Electrodomésticos": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearElectrodomesticos(), BorderLayout.CENTER);
			mostrarPanelActualizarElectrodomestico();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Juguetes": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearJuguete(), BorderLayout.CENTER);
			mostrarPanelActualizarJuguete();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Mascotas": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearMascota(), BorderLayout.CENTER);
			mostrarPanelActualizarMascota();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Medicamentos": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearMedicamento(), BorderLayout.CENTER);
			mostrarPanelActualizarMedicamento();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Moda": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearProductoModa(), BorderLayout.CENTER);
			mostrarPanelActualizarModa();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Actualizar Vehículos": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearVehiculo(), BorderLayout.CENTER);
			mostrarPanelActualizarVehiculo();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		// Paneles datos cuenta
		case "Panel Perfil": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelPerfil(), BorderLayout.CENTER);
			mostrarPanelPerfil();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Usuario": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelPerfil(), BorderLayout.CENTER);
			mostrarPanelUsuario();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel MetodoDePago": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelMetodoDePago(), BorderLayout.CENTER);
			mostrarPanelMetodoDePago();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		// Guardar los Productos Actualizados
		case "Actualizar AlimentoYBebida": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Celular": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Construccion": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar DeporteYFitness": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Electrodomestica": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Juguete": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Mascota": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Medicamento": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar ProductoModa": {
			guardarAlimentoYBebida();
			break;
		}

		case "Actualizar Vehiculo": {
			guardarAlimentoYBebida();
			break;
		}

		default:
			System.out.println("Acción no reconocida: " + comando);
			break;
		}
	}

	public void inicializaraActionListener() {
		// Panel Superior
		vf.getPanelLogin().getBtnIniciarSesion().addActionListener(this);
		vf.getPanelLogin().getBtnIniciarSesion().setActionCommand("Iniciar Sesion");
		vf.getPanelLogin().getBtnCrearCuenta().addActionListener(this);
		vf.getPanelLogin().getBtnCrearCuenta().setActionCommand("Crear Cuenta");
		vf.getPanelSuperior().getBtnCategoria().addActionListener(this);
		vf.getPanelSuperior().getBtnCategoria().setActionCommand("Categorias");
		vf.getPanelSuperior().getBtnVender().addActionListener(this);
		vf.getPanelSuperior().getBtnVender().setActionCommand("Vender");
		vf.getPanelSuperior().getBtnCarro().addActionListener(this);
		vf.getPanelSuperior().getBtnCarro().setActionCommand("Carrito");
		vf.getPanelSuperior().getBtnPerfil().addActionListener(this);
		vf.getPanelSuperior().getBtnPerfil().setActionCommand("Panel Perfil");

		// Crear Objetos
		vf.getPanelCrearAlimentoYBebida().getBtnCrearAlimentoYBebida().addActionListener(this);
		vf.getPanelCrearAlimentoYBebida().getBtnCrearAlimentoYBebida().setActionCommand("Crear AlimentoYBebida");
		vf.getPanelCrearCelular().getBtnCrearCelular().addActionListener(this);
		vf.getPanelCrearCelular().getBtnCrearCelular().setActionCommand("Crear Celular");
		vf.getPanelCrearConstruccion().getBtnCrearConstruccion().addActionListener(this);
		vf.getPanelCrearConstruccion().getBtnCrearConstruccion().setActionCommand("Crear Construccion");
		vf.getPanelCDeporteYFitness().getBtnCrearDeporteYFitness().addActionListener(this);
		vf.getPanelCDeporteYFitness().getBtnCrearDeporteYFitness().setActionCommand("Crear DeporteYFitness");
		vf.getPanelCrearElectrodomesticos().getBtnCrearElectrodomestico().addActionListener(this);
		vf.getPanelCrearElectrodomesticos().getBtnCrearElectrodomestico().setActionCommand("Crear Electrodomestico");
		vf.getPanelCrearJuguete().getBtnCrearJuguete().addActionListener(this);
		vf.getPanelCrearJuguete().getBtnCrearJuguete().setActionCommand("Crear Juguete");
		vf.getPanelCrearMascota().getBtnCrearMascota().addActionListener(this);
		vf.getPanelCrearMascota().getBtnCrearMascota().setActionCommand("Crear Mascota");
		vf.getPanelCrearMedicamento().getBtnCrearFarmacia().addActionListener(this);
		vf.getPanelCrearMedicamento().getBtnCrearFarmacia().setActionCommand("Crear Medicamento");
		vf.getPanelCrearProductoModa().getBtnCrearProductoModa().addActionListener(this);
		vf.getPanelCrearProductoModa().getBtnCrearProductoModa().setActionCommand("Crear Moda");
		vf.getPanelCrearVehiculo().getBtnCrearVehiculo().addActionListener(this);
		vf.getPanelCrearVehiculo().getBtnCrearVehiculo().setActionCommand("Crear vehiculo");

		// Seleccionar Categorias
		vf.getPanelSeleccionarCategoria().getBtnAlimentoYBebida().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnCelular().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnConstruccion().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnDeporteYFitness().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnElectrodomesticos().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnJuguete().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnMascota().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnMedicamento().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnModa().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnVehiculo().addActionListener(this);

		// Datos Cuenta
		vf.getPanelPerfil().getBtnUsuario().addActionListener(this);
		vf.getPanelPerfil().getBtnUsuario().setActionCommand("Panel Usuario");
		vf.getPanelPerfil().getBtnUsuario().addActionListener(this);
		vf.getPanelPerfil().getBtnUsuario().setActionCommand("Panel MetodoDePago");

		// Oculta los botones para el login
		vf.getPanelSuperior().getBtnCategoria().setVisible(false);
		vf.getPanelSuperior().getBtnVender().setVisible(false);
		vf.getPanelSuperior().getBtnCarro().setVisible(false);
		vf.getPanelSuperior().getBtnPerfil().setVisible(false);
	}
}
