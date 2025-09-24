package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import co.edu.unbosque.model.AlimentoYBebida;
import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.Construccion;
import co.edu.unbosque.model.DeporteYFitness;
import co.edu.unbosque.model.Electrodomestico;
import co.edu.unbosque.model.Farmacia;
import co.edu.unbosque.model.Item;
import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.MetodoDePago;
import co.edu.unbosque.model.Moda;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.EmailInvalidoException;
import co.edu.unbosque.util.exception.EmailYaRegistradoException;
import co.edu.unbosque.util.exception.LanzadorExcepciones;
import co.edu.unbosque.view.ViewFacade;
import co.edu.unbosque.view.PanelPrincipalFiltrado;
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
		inicializarActionListener();
		vf.getVentana().add(vf.getPanelSuperior(), BorderLayout.NORTH);
		vf.getVentana().add(vf.getPanelLogin(), BorderLayout.CENTER);
		vf.getVentana().setSize(1280, 920);
		vf.getVentana().setLocationRelativeTo(null);
		vf.getVentana().setVisible(true);
	}

	public void iniciarSesion() {
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
				vf.getPanelSuperior().getBtnPerfil().setVisible(true);

				usuarioLogueado = usuario;

				vf.getPanelLogin().limpiarFormulario();

				mostrarPanelPrincipal();

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

	public void mostrarFormularioRegistro() {
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

	public JLabel crearLabel(String texto) {
		JLabel label = new JLabel(texto);
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setForeground(new Color(44, 62, 80));
		return label;
	}

	public void estilizarCampoTexto(JTextField campo) {
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

	public void validarYCrearUsuario(JDialog dialog, JTextField txtNombre, JTextField txtNombreUsuario,
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

	public void mostrarErrorValidacion(JDialog dialog, String mensaje, JTextField campo) {
		JOptionPane.showMessageDialog(dialog, mensaje, "Error de Validación", JOptionPane.WARNING_MESSAGE);
		if (campo != null) {
			campo.requestFocus();
			campo.selectAll();
		}
	}

	public boolean validarFortalezaContrasenia(String contrasenia) {
		boolean tieneMayuscula = contrasenia.matches(".*[A-Z].*");
		boolean tieneMinuscula = contrasenia.matches(".*[a-z].*");
		boolean tieneNumero = contrasenia.matches(".*\\d.*");
		return tieneMayuscula && tieneMinuscula && tieneNumero;
	}

	public void cerrarSesion() {
		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Estás seguro de que quieres cerrar sesión?",
				"Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			usuarioLogueado = null;

			vf.getPanelSuperior().getBtnCategoria().setVisible(false);
			vf.getPanelSuperior().getBtnVender().setVisible(false);
			vf.getPanelSuperior().getBtnCarro().setVisible(false);
			vf.getPanelSuperior().getBtnPerfil().setVisible(false);

			vf.getPanelLogin().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelLogin(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
		}
	}

	// Métodos para agregar a tu clase Controlador

	public void mostrarPanelPrincipal() {
		ocultarTodosLosPaneles();

		// Obtener productos de todas las categorías
		ArrayList<AlimentoYBebida> productosAlimentos = mf.getAlimentoYBebidaDAO().getListaAlimentosYBebidas();
		ArrayList<Celular> productosCelulares = mf.getCelularDAO().getListaCelulares();
		ArrayList<Construccion> productosConstruccion = mf.getConstruccionDAO().getListaConstruccion();
		ArrayList<DeporteYFitness> productosDeporteYFitness = mf.getDeporteYFitnessDAO().getListaDeportesYFitness();
		ArrayList<Electrodomestico> productosElectrodomesticos = mf.getElectrodomesticoDAO()
				.getListaElectrodomesticos();
		ArrayList<Juguete> productosJuguetes = mf.getJugueteDAO().getListaJuguetes();
		ArrayList<Mascota> productosMascotas = mf.getMascotaDAO().getListaMascotas();
		ArrayList<Farmacia> productosFarmacia = mf.getFarmaciaDAO().getListaFarmacia();
		ArrayList<Moda> productosModa = mf.getModaDAO().getListaModa();
		ArrayList<Vehiculo> productosVehiculos = mf.getVehiculoDAO().getListaVehiculos();

		vf.getPanelPrincipal().mostrarTodosLosProductos(productosAlimentos, productosCelulares, productosConstruccion,
				productosDeporteYFitness, productosElectrodomesticos, productosJuguetes, productosMascotas,
				productosFarmacia, productosModa, productosVehiculos);

		vf.getVentana().add(vf.getPanelPrincipal(), BorderLayout.CENTER);
		vf.getVentana().revalidate();
		vf.getVentana().repaint();
	}

	public void actualizarPanelPrincipal() {
		boolean panelPrincipalVisible = false;
		Component[] components = vf.getVentana().getContentPane().getComponents();
		for (Component comp : components) {
			if (comp == vf.getPanelPrincipal()) {
				panelPrincipalVisible = true;
				break;
			}
		}

		if (panelPrincipalVisible) {
			// Obtener productos de todas las categorías
			ArrayList<AlimentoYBebida> productosAlimentos = mf.getAlimentoYBebidaDAO().getListaAlimentosYBebidas();
			ArrayList<Celular> productosCelulares = mf.getCelularDAO().getListaCelulares();
			ArrayList<Construccion> productosConstruccion = mf.getConstruccionDAO().getListaConstruccion();
			ArrayList<DeporteYFitness> productosDeporteYFitness = mf.getDeporteYFitnessDAO().getListaDeportesYFitness();
			ArrayList<Electrodomestico> productosElectrodomesticos = mf.getElectrodomesticoDAO()
					.getListaElectrodomesticos();
			ArrayList<Juguete> productosJuguetes = mf.getJugueteDAO().getListaJuguetes();
			ArrayList<Mascota> productosMascotas = mf.getMascotaDAO().getListaMascotas();
			ArrayList<Farmacia> productosFarmacia = mf.getFarmaciaDAO().getListaFarmacia();
			ArrayList<Moda> productosModa = mf.getModaDAO().getListaModa();
			ArrayList<Vehiculo> productosVehiculos = mf.getVehiculoDAO().getListaVehiculos();

			// Mostrar todos los productos en el panel principal
			vf.getPanelPrincipal().mostrarTodosLosProductos(productosAlimentos, productosCelulares,
					productosConstruccion, productosDeporteYFitness, productosElectrodomesticos, productosJuguetes,
					productosMascotas, productosFarmacia, productosModa, productosVehiculos);
		}
	}

	public void actualizarPanelProductoCreado() {
		ArrayList<AlimentoYBebida> productosAlimentos = mf.getAlimentoYBebidaDAO().getListaAlimentosYBebidas();
		ArrayList<Celular> productosCelulares = mf.getCelularDAO().getListaCelulares();
		ArrayList<Construccion> productosConstruccion = mf.getConstruccionDAO().getListaConstruccion();
		ArrayList<DeporteYFitness> productosDeporteYFitness = mf.getDeporteYFitnessDAO().getListaDeportesYFitness();
		ArrayList<Electrodomestico> productosElectrodomesticos = mf.getElectrodomesticoDAO()
				.getListaElectrodomesticos();
		ArrayList<Juguete> productosJuguetes = mf.getJugueteDAO().getListaJuguetes();
		ArrayList<Mascota> productosMascotas = mf.getMascotaDAO().getListaMascotas();
		ArrayList<Farmacia> productosFarmacia = mf.getFarmaciaDAO().getListaFarmacia();
		ArrayList<Moda> productosModa = mf.getModaDAO().getListaModa();
		ArrayList<Vehiculo> productosVehiculos = mf.getVehiculoDAO().getListaVehiculos();
		int idUsuario = usuarioLogueado.getId();

		vf.getPanelProductoCreado().mostrarTodosLosProductos(productosAlimentos, productosCelulares,
				productosConstruccion, productosDeporteYFitness, productosElectrodomesticos, productosJuguetes,
				productosMascotas, productosFarmacia, productosModa, productosVehiculos, idUsuario);

	}

	public void comprarProducto() {
	    String nombre = vf.getPanelMostrarProducto().getLblNombre().getText();
	    String precioString = vf.getPanelMostrarProducto().getLblPrecio().getText();

	    // Limpiar etiquetas HTML en el nombre
	    nombre = nombre.replaceAll("<[^>]*>", "").trim();

	    // Limpiar y normalizar el precio (tu código - perfecto como está)
	    precioString = precioString.replaceAll("<[^>]*>", "").trim();
	    String limpio = precioString.replaceAll("[^\\d.,]", "");

	    if (limpio.contains(",") && limpio.contains(".")) {
	        limpio = limpio.replace(".", "");
	        limpio = limpio.replace(",", ".");
	    } else if (limpio.indexOf('.') != limpio.lastIndexOf('.')) {
	        int last = limpio.lastIndexOf('.');
	        limpio = limpio.substring(0, last).replace(".", "") + "." + limpio.substring(last + 1);
	    } else if (limpio.indexOf(',') != limpio.lastIndexOf(',')) {
	        int last = limpio.lastIndexOf(',');
	        limpio = limpio.substring(0, last).replace(",", "") + "." + limpio.substring(last + 1);
	    } else if (limpio.contains(",")) {
	        limpio = limpio.replace(",", ".");
	    }

	    // Mostrar ventana factura
	    vf.getVentanaFactura().setVisible(true);
	    vf.getVentanaFactura().getLblTitulo().setText("Resumen de tu compra");
	    vf.getVentanaFactura().getLblCompra().setText("Compraste: " + nombre);
	    vf.getVentanaFactura().setPrecioDesdeString(limpio);
	    vf.getVentanaFactura().revalidate();
	    vf.getVentanaFactura().repaint();
	}
	public void agregarCarrito() {
		String nombreProducto = vf.getPanelMostrarProducto().getLblNombre().getText();
		String precioString = vf.getPanelMostrarProducto().getLblPrecio().getText();

		// Limpiar etiquetas HTML en nombre y precio
		nombreProducto = nombreProducto.replaceAll("<[^>]*>", "").trim();
		precioString = precioString.replaceAll("<[^>]*>", "").trim();

		// Limpiar precio (igual que en comprarProducto)
		String limpio = precioString.replaceAll("[^\\d.,]", "");
		if (limpio.contains(",") && limpio.contains(".")) {
			limpio = limpio.replace(".", "").replace(",", ".");
		} else if (limpio.contains(",")) {
			limpio = limpio.replace(",", ".");
		}

		float precio = limpio.isEmpty() ? 0 : Float.parseFloat(limpio);

		// Crear item y agregar al carrito
		Item temp = new Item(nombreProducto, precio);
		int indiceCarrito = mf.getCarritoDAO().buscarIndiceCarrito(usuarioLogueado.getId());
		mf.getCarritoDAO().getListaCarritos().get(indiceCarrito).getListaItems().add(temp);
	}

	public void comprarCarrito() {

		String nombre = vf.getPanelMostrarProducto().getLblNombre().getText();
		float precio = vf.getPanelCarrito().getPrecioTotal();

		// Mostrar ventana factura
		vf.getVentanaFactura().setVisible(true);
		vf.getVentanaFactura().getLblTitulo().setText("Resumen de tu compra");
		vf.getVentanaFactura().getLblCompra().setText("Compraste: Tu carrito");
		vf.getVentanaFactura().setPrecioFormateado(precio);
		vf.getVentanaFactura().revalidate();
		vf.getVentanaFactura().repaint();
		vf.getPanelCarrito().limpiarCarrito();
	}

	public void ocultarTodosLosPaneles() {
	    vf.getPanelProductoCreado().removeActionListener(this);
	    
	    Container contentPane = vf.getVentana().getContentPane();
	    contentPane.removeAll();
	    
	    contentPane.add(vf.getPanelSuperior(), BorderLayout.NORTH);
	}

	public void guardarAlimentoYBebida() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearAlimentoYBebida().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearAlimentoYBebida().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearAlimentoYBebida().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearAlimentoYBebida().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearAlimentoYBebida().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearAlimentoYBebida().getTxtStock().getText().trim();
			String unidadEnvaseStr = vf.getPanelCrearAlimentoYBebida().getTxtUnidadEnvase().getText().trim();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty()
					|| unidadEnvaseStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int unidadEnvase = Integer.parseInt(unidadEnvaseStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();
			boolean esLiquido = "Sí"
					.equals(vf.getPanelCrearAlimentoYBebida().getCmbEsLiquido().getSelectedItem().toString());
			String tipoEnvase = vf.getPanelCrearAlimentoYBebida().getCmbTipoEnvase().getSelectedItem().toString();

			Object cantidadObj = vf.getPanelCrearAlimentoYBebida().getTxtCantidadProducto().getValue();
			int cantidadProducto = (cantidadObj != null) ? Integer.parseInt(cantidadObj.toString()) : 0;

			String rutaImagen = null;
			File imagen = vf.getPanelCrearAlimentoYBebida().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			AlimentoYBebida nuevoProducto = new AlimentoYBebida(nombre, descripcion, tipo, precio, marca, vendedor,
					caracteristicas, stock, id, idAsociado, esLiquido, cantidadProducto, tipoEnvase, unidadEnvase,
					rutaImagen);

			mf.getAlimentoYBebidaDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Alimento y bebida guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearAlimentoYBebida().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarCelular() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearCelular().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearCelular().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearCelular().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearCelular().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearCelular().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearCelular().getTxtCaracteristicas().getText().trim();
			String caracteristicas = vf.getPanelCrearCelular().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearCelular().getTxtStock().getText().trim();
			String color = vf.getPanelCrearCelular().getTxtColor().getText().trim();
			String memoriaInternaStr = (String) vf.getPanelCrearCelular().getCmbMemoriaInterna().getSelectedItem();
			String memoriaRamStr = (String) vf.getPanelCrearCelular().getCmbMemoriaRam().getSelectedItem();
			String largoPantallaStr = vf.getPanelCrearCelular().getTxtLargoPantalla().getText().trim();
			String anchoPantallaStr = vf.getPanelCrearCelular().getTxtAnchoPantalla().getText().trim();
			String altoPantallaStr = vf.getPanelCrearCelular().getTxtAlturaPantalla().getText().trim();
			String camaraFrontalStr = vf.getPanelCrearCelular().getTxtCamaraFrontal().getText().trim();
			String camaraTraseraStr = vf.getPanelCrearCelular().getTxtCamaraTrasera().getText().trim();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty()
					|| memoriaInternaStr.isEmpty() || memoriaRamStr.isEmpty() || largoPantallaStr.isEmpty()
					|| anchoPantallaStr.isEmpty() || altoPantallaStr.isEmpty() || camaraFrontalStr.isEmpty()
					|| camaraTraseraStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int memoriaInterna = Integer.parseInt(memoriaInternaStr.replace("GB", ""));
			int memoriaRam = Integer.parseInt(memoriaRamStr.replace("GB", ""));
			float largoPantalla = Float.parseFloat(largoPantallaStr);
			float anchoPantalla = Float.parseFloat(anchoPantallaStr);
			float altoPantalla = Float.parseFloat(altoPantallaStr);
			int camaraFrontal = Integer.parseInt(camaraFrontalStr);
			int camaraTrasera = Integer.parseInt(camaraTraseraStr);
			boolean poseeNfc = "Sí".equals(vf.getPanelCrearCelular().getCmbPoseeNfc().getSelectedItem().toString());
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearCelular().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Celular nuevoProducto = new Celular(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, // stock
					id, idAsociado, // idAsociado (ID del usuario logueado)
					color, // color
					memoriaInterna, // memoriaInterna
					memoriaRam, // memoriaRam
					largoPantalla, // largoPantalla
					anchoPantalla, // anchoPantalla
					altoPantalla, // altoPantalla
					camaraFrontal, // camaraFrontal
					camaraTrasera, // camaraTrasera
					poseeNfc, // poseeNfc
					rutaImagen // fotoProducto
			);

			mf.getCelularDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Celular guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearCelular().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarConstruccion() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearConstruccion().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearConstruccion().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearConstruccion().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearConstruccion().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearConstruccion().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearConstruccion().getTxtCaracteristicas().getText().trim();
			String caracteristicas = vf.getPanelCrearConstruccion().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearConstruccion().getTxtStock().getText().trim();
			String modelo = vf.getPanelCrearConstruccion().getTxtModelo().getText().trim();
			String material = vf.getPanelCrearConstruccion().getCmbMaterial().getSelectedItem().toString();
			String color = vf.getPanelCrearConstruccion().getTxtColor().getText().trim();
			String largoStr = vf.getPanelCrearConstruccion().getTxtLargo().getText().trim();
			String anchoStr = vf.getPanelCrearConstruccion().getTxtAncho().getText().trim();
			String alturaStr = vf.getPanelCrearConstruccion().getTxtAltura().getText().trim();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || modelo.isEmpty()
					|| material.isEmpty() || color.isEmpty() || largoStr.isEmpty() || anchoStr.isEmpty()
					|| alturaStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			float largo = Float.parseFloat(largoStr);
			float ancho = Float.parseFloat(anchoStr);
			float altura = Float.parseFloat(alturaStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearConstruccion().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Construccion nuevoProducto = new Construccion(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, idAsociado, // idAsociado (ID del usuario logueado)
					modelo, // modelo
					material, // material
					color, // color
					largo, // largo
					ancho, // ancho
					altura, // altura
					rutaImagen // fotoProducto
			);

			mf.getConstruccionDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de construcción guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearConstruccion().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarDeporteYFitness() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCDeporteYFitness().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCDeporteYFitness().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCDeporteYFitness().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCDeporteYFitness().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCDeporteYFitness().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCDeporteYFitness().getTxtCaracteristicas().getText().trim();
			String caracteristicas = vf.getPanelCDeporteYFitness().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCDeporteYFitness().getTxtStock().getText().trim();
			String color = vf.getPanelCDeporteYFitness().getTxtColor().getText().trim();
			String material = vf.getPanelCDeporteYFitness().getTxtMaterial().getText().trim();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty()
					|| material.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCDeporteYFitness().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			DeporteYFitness nuevoProducto = new DeporteYFitness(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, idAsociado, // idAsociado (ID del usuario logueado)
					color, // color
					material, // material
					rutaImagen // fotoProducto
			);

			mf.getDeporteYFitnessDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de deporte y fitness guardado exitosamente!",
					"Éxito", JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCDeporteYFitness().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarElectrodomestico() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearElectrodomesticos().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearElectrodomesticos().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearElectrodomesticos().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearElectrodomesticos().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearElectrodomesticos().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearElectrodomesticos().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearElectrodomesticos().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearElectrodomesticos().getTxtStock().getText().trim();
			String modelo = vf.getPanelCrearElectrodomesticos().getTxtModelo().getText().trim();
			String voltajeStr = vf.getPanelCrearElectrodomesticos().getTxtVoltaje().getText().trim();
			String color = vf.getPanelCrearElectrodomesticos().getTxtColor().getText().trim();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || modelo.isEmpty()
					|| voltajeStr.isEmpty() || color.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int voltaje = Integer.parseInt(voltajeStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearElectrodomesticos().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Electrodomestico nuevoProducto = new Electrodomestico(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, // stock
					idAsociado, // idAsociado (ID del usuario logueado)
					modelo, // modelo
					voltaje, // voltaje
					color, // color
					rutaImagen // fotoProducto
			);

			mf.getElectrodomesticoDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Electrodoméstico guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearElectrodomesticos().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarJuguete() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearJuguete().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearJuguete().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearJuguete().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearJuguete().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearJuguete().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearJuguete().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearJuguete().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearJuguete().getTxtStock().getText().trim();
			String color = vf.getPanelCrearJuguete().getTxtColor().getText().trim();
			String material = vf.getPanelCrearJuguete().getTxtMaterial().getText().trim();
			String rangoEdad = vf.getPanelCrearJuguete().getTxtRangoDeEdad().getText().trim();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty()
					|| material.isEmpty() || rangoEdad.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearJuguete().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Juguete nuevoProducto = new Juguete(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, // stock
					idAsociado, // idAsociado (ID del usuario logueado)
					color, // color
					material, // material
					rangoEdad, // rangoEdad
					rutaImagen // fotoProducto
			);

			mf.getJugueteDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Juguete guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearJuguete().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarMascota() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearMascota().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearMascota().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearMascota().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearMascota().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearMascota().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearMascota().getTxtCaracteristicas().getText().trim();
			String caracteristicas = vf.getPanelCrearMascota().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearMascota().getTxtStock().getText().trim();
			String tipoAnimal = vf.getPanelCrearMascota().getCmbTipoAnimal().getSelectedItem().toString();
			String raza = vf.getPanelCrearMascota().getTxtRaza().getText().trim();
			String color = vf.getPanelCrearMascota().getTxtColor().getText().trim();
			String formatoVenta = vf.getPanelCrearMascota().getCmbFormatoDeVenta().getSelectedItem().toString();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || tipoAnimal.isEmpty()
					|| raza.isEmpty() || color.isEmpty() || formatoVenta.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearMascota().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Mascota nuevoProducto = new Mascota(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, // stock
					idAsociado, // idAsociado (ID del usuario logueado)
					tipoAnimal, // tipoAnimal
					raza, // raza
					color, // color
					formatoVenta, // formatoVenta
					rutaImagen // fotoProducto
			);

			mf.getMascotaDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto para mascota guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearMascota().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarMedicamento() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearMedicamento().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearMedicamento().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearMedicamento().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearMedicamento().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearMedicamento().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearMedicamento().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearMedicamento().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearMedicamento().getTxtStock().getText().trim();
			String laboratorio = vf.getPanelCrearMedicamento().getTxtLaboratorio().getText().trim();
			String formatoMedicamento = vf.getPanelCrearMedicamento().getCmbFormatoMedicamento().getSelectedItem()
					.toString();
			String formatoVenta = vf.getPanelCrearMedicamento().getCmbFormatoDeVenta().getSelectedItem().toString();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || laboratorio.isEmpty()
					|| formatoMedicamento.isEmpty() || formatoVenta.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearMedicamento().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Farmacia nuevoProducto = new Farmacia(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, // stock
					idAsociado, // idAsociado (ID del usuario logueado)
					laboratorio, // laboratorio
					formatoMedicamento, // formatoMedicamento
					formatoVenta, // formatoVenta
					rutaImagen // fotoProducto
			);

			mf.getFarmaciaDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Medicamento guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearMedicamento().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarModa() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearProductoModa().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearProductoModa().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearProductoModa().getCmbTipo().getSelectedItem().toString();
			String precioStr = vf.getPanelCrearProductoModa().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearProductoModa().getCmbMarca().getSelectedItem().toString();
			String vendedor = vf.getPanelCrearProductoModa().getTxtCaracteristicas().getText().trim();
			String caracteristicas = vf.getPanelCrearProductoModa().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearProductoModa().getTxtStock().getText().trim();
			String color = vf.getPanelCrearProductoModa().getTxtColor().getText().trim();
			String talla = vf.getPanelCrearProductoModa().getCmbTalla().getSelectedItem().toString();
			String material = vf.getPanelCrearProductoModa().getCmbMaterial().getSelectedItem().toString();

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty()
					|| talla.isEmpty() || material.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearProductoModa().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Moda nuevoProducto = new Moda(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					vendedor, // vendedor
					caracteristicas, // caracteristicas
					stock, id, // stock
					idAsociado, // idAsociado (ID del usuario logueado)
					color, // color
					talla, // talla
					material, // material
					rutaImagen // fotoProducto
			);

			mf.getModaDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de moda guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearProductoModa().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void guardarVehiculo() {
		Random random = new Random();
		try {
			String nombre = vf.getPanelCrearVehiculo().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearVehiculo().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearVehiculo().getCmbTipo().getSelectedItem().toString();
			String precioStr = vf.getPanelCrearVehiculo().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearVehiculo().getCmbMarca().getSelectedItem().toString();
			String caracteristicas = vf.getPanelCrearVehiculo().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearVehiculo().getTxtStock().getText().trim();
			String anioStr = vf.getPanelCrearVehiculo().getCmbAnio().getSelectedItem().toString();
			String kilometrajeStr = vf.getPanelCrearVehiculo().getTxtKilometraje().getText().trim();
			boolean esFinanciable = "Sí"
					.equals(vf.getPanelCrearVehiculo().getCmbEsFinanciable().getSelectedItem().toString());

			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || anioStr.isEmpty()
					|| kilometrajeStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			float precio = Float.parseFloat(precioStr);
			int stock = Integer.parseInt(stockStr);
			int anio = Integer.parseInt(anioStr);
			int kilometraje = Integer.parseInt(kilometrajeStr);
			int id = random.nextInt(999999 - 100000 + 1) + 999999;
			int idAsociado = usuarioLogueado.getId();

			String rutaImagen = null;
			File imagen = vf.getPanelCrearVehiculo().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Vehiculo nuevoProducto = new Vehiculo(nombre, // nombre
					descripcion, // descripcion
					tipo, // tipo
					precio, // precio
					marca, // marca
					"Vendedor", // vendedor
					caracteristicas, // caracteristicas
					stock, id, // stock
					idAsociado, // idAsociado (ID del usuario logueado)
					esFinanciable, // esFinanciable
					kilometraje, // kilometraje
					anio, // anio
					rutaImagen // fotoProducto
			);

			mf.getVehiculoDAO().crear(nuevoProducto);

			JOptionPane.showMessageDialog(vf.getVentana(), "¡Vehículo guardado exitosamente!", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			vf.getPanelCrearVehiculo().limpiarFormulario();

			actualizarPanelPrincipal();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al guardar el producto: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarAlimentoYBebida() {
		try {
			AlimentoYBebida productoActual = (AlimentoYBebida) vf.getPanelCrearAlimentoYBebida()
					.getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearAlimentoYBebida().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearAlimentoYBebida().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearAlimentoYBebida().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearAlimentoYBebida().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearAlimentoYBebida().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearAlimentoYBebida().getTxtStock().getText().trim();
			String unidadEnvaseStr = vf.getPanelCrearAlimentoYBebida().getTxtUnidadEnvase().getText().trim();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty()
					|| unidadEnvaseStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setVendedor(vendedor);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setEsLiquido(
					"Sí".equals(vf.getPanelCrearAlimentoYBebida().getCmbEsLiquido().getSelectedItem().toString()));
			productoActual.setCantidadProducto(
					Integer.parseInt(vf.getPanelCrearAlimentoYBebida().getTxtCantidadProducto().getValue().toString()));
			productoActual
					.setTipoEnvase(vf.getPanelCrearAlimentoYBebida().getCmbTipoEnvase().getSelectedItem().toString());
			productoActual.setUnidadEnvase(Integer.parseInt(unidadEnvaseStr));

			File imagen = vf.getPanelCrearAlimentoYBebida().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}
			int indice = mf.getAlimentoYBebidaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getAlimentoYBebidaDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Alimento y bebida actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				actualizarPanelProductoCreado();

				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarCelular() {
		try {
			Celular productoActual = (Celular) vf.getPanelCrearCelular().getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearCelular().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearCelular().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearCelular().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearCelular().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearCelular().getTxtMarca().getText().trim();
			String caracteristicas = vf.getPanelCrearCelular().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearCelular().getTxtStock().getText().trim();
			String color = vf.getPanelCrearCelular().getTxtColor().getText().trim();
			String memoriaInternaStr = (String) vf.getPanelCrearCelular().getCmbMemoriaInterna().getSelectedItem();
			String memoriaRamStr = (String) vf.getPanelCrearCelular().getCmbMemoriaRam().getSelectedItem();
			String largoPantallaStr = vf.getPanelCrearCelular().getTxtLargoPantalla().getText().trim();
			String anchoPantallaStr = vf.getPanelCrearCelular().getTxtAnchoPantalla().getText().trim();
			String altoPantallaStr = vf.getPanelCrearCelular().getTxtAlturaPantalla().getText().trim();
			String camaraFrontalStr = vf.getPanelCrearCelular().getTxtCamaraFrontal().getText().trim();
			String camaraTraseraStr = vf.getPanelCrearCelular().getTxtCamaraTrasera().getText().trim();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty() || memoriaInternaStr.isEmpty()
					|| memoriaRamStr.isEmpty() || largoPantallaStr.isEmpty() || anchoPantallaStr.isEmpty()
					|| altoPantallaStr.isEmpty() || camaraFrontalStr.isEmpty() || camaraTraseraStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setColor(color);
			productoActual.setMemoriaInterna(Integer.parseInt(memoriaInternaStr.replace("GB", "")));
			productoActual.setMemoriaRam(Integer.parseInt(memoriaRamStr.replace("GB", "")));
			productoActual.setLargoPantalla(Float.parseFloat(largoPantallaStr));
			productoActual.setAnchoPantalla(Float.parseFloat(anchoPantallaStr));
			productoActual.setAltoPantalla(Float.parseFloat(altoPantallaStr));
			productoActual.setCamaraFrontal(Integer.parseInt(camaraFrontalStr));
			productoActual.setCamaraTrasera(Integer.parseInt(camaraTraseraStr));
			productoActual
					.setPoseeNfc("Sí".equals(vf.getPanelCrearCelular().getCmbPoseeNfc().getSelectedItem().toString()));

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearCelular().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getCelularDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getCelularDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Celular actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarConstruccion() {
		try {
			Construccion productoActual = (Construccion) vf.getPanelCrearConstruccion()
					.getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearConstruccion().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearConstruccion().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearConstruccion().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearConstruccion().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearConstruccion().getTxtMarca().getText().trim();
			String caracteristicas = vf.getPanelCrearConstruccion().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearConstruccion().getTxtStock().getText().trim();
			String modelo = vf.getPanelCrearConstruccion().getTxtModelo().getText().trim();
			String material = vf.getPanelCrearConstruccion().getCmbMaterial().getSelectedItem().toString();
			String color = vf.getPanelCrearConstruccion().getTxtColor().getText().trim();
			String largoStr = vf.getPanelCrearConstruccion().getTxtLargo().getText().trim();
			String anchoStr = vf.getPanelCrearConstruccion().getTxtAncho().getText().trim();
			String alturaStr = vf.getPanelCrearConstruccion().getTxtAltura().getText().trim();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || modelo.isEmpty() || material.isEmpty()
					|| color.isEmpty() || largoStr.isEmpty() || anchoStr.isEmpty() || alturaStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setModelo(modelo);
			productoActual.setMaterial(material);
			productoActual.setColor(color);
			productoActual.setLargo(Float.parseFloat(largoStr));
			productoActual.setAncho(Float.parseFloat(anchoStr));
			productoActual.setAltura(Float.parseFloat(alturaStr));

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearConstruccion().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getConstruccionDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getConstruccionDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de construcción actualizado exitosamente!",
						"Éxito", JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarDeporteYFitness() {
		try {
			DeporteYFitness productoActual = (DeporteYFitness) vf.getPanelCDeporteYFitness()
					.getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCDeporteYFitness().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCDeporteYFitness().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCDeporteYFitness().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCDeporteYFitness().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCDeporteYFitness().getTxtMarca().getText().trim();
			String caracteristicas = vf.getPanelCDeporteYFitness().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCDeporteYFitness().getTxtStock().getText().trim();
			String color = vf.getPanelCDeporteYFitness().getTxtColor().getText().trim();
			String material = vf.getPanelCDeporteYFitness().getTxtMaterial().getText().trim();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty() || material.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setColor(color);
			productoActual.setMaterial(material);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCDeporteYFitness().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getDeporteYFitnessDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getDeporteYFitnessDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(),
						"¡Producto de deporte y fitness actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarElectrodomestico() {
		try {
			Electrodomestico productoActual = (Electrodomestico) vf.getPanelCrearElectrodomesticos()
					.getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearElectrodomesticos().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearElectrodomesticos().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearElectrodomesticos().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearElectrodomesticos().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearElectrodomesticos().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearElectrodomesticos().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearElectrodomesticos().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearElectrodomesticos().getTxtStock().getText().trim();
			String modelo = vf.getPanelCrearElectrodomesticos().getTxtModelo().getText().trim();
			String voltajeStr = vf.getPanelCrearElectrodomesticos().getTxtVoltaje().getText().trim();
			String color = vf.getPanelCrearElectrodomesticos().getTxtColor().getText().trim();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || modelo.isEmpty()
					|| voltajeStr.isEmpty() || color.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setVendedor(vendedor);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setModelo(modelo);
			productoActual.setVoltaje(Integer.parseInt(voltajeStr));
			productoActual.setColor(color);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearElectrodomesticos().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getElectrodomesticoDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getElectrodomesticoDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Electrodoméstico actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarJuguete() {
		try {
			Juguete productoActual = (Juguete) vf.getPanelCrearJuguete().getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearJuguete().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearJuguete().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearJuguete().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearJuguete().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearJuguete().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearJuguete().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearJuguete().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearJuguete().getTxtStock().getText().trim();
			String color = vf.getPanelCrearJuguete().getTxtColor().getText().trim();
			String material = vf.getPanelCrearJuguete().getTxtMaterial().getText().trim();
			String rangoEdad = vf.getPanelCrearJuguete().getTxtRangoDeEdad().getText().trim();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty()
					|| material.isEmpty() || rangoEdad.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setVendedor(vendedor);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setColor(color);
			productoActual.setMaterial(material);
			productoActual.setRangoDeEdad(rangoEdad);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearJuguete().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getJugueteDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getJugueteDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Juguete actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarMascota() {
		try {
			Mascota productoActual = (Mascota) vf.getPanelCrearMascota().getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearMascota().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearMascota().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearMascota().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearMascota().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearMascota().getTxtMarca().getText().trim();
			String caracteristicas = vf.getPanelCrearMascota().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearMascota().getTxtStock().getText().trim();
			String tipoAnimal = vf.getPanelCrearMascota().getCmbTipoAnimal().getSelectedItem().toString();
			String raza = vf.getPanelCrearMascota().getTxtRaza().getText().trim();
			String color = vf.getPanelCrearMascota().getTxtColor().getText().trim();
			String formatoVenta = vf.getPanelCrearMascota().getCmbFormatoDeVenta().getSelectedItem().toString();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || tipoAnimal.isEmpty() || raza.isEmpty()
					|| color.isEmpty() || formatoVenta.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setTipoAnimal(tipoAnimal);
			productoActual.setRaza(raza);
			productoActual.setColor(color);
			productoActual.setFormatoDeVenta(formatoVenta);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearMascota().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getMascotaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getMascotaDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto para mascota actualizado exitosamente!",
						"Éxito", JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarMedicamento() {
		try {
			Farmacia productoActual = (Farmacia) vf.getPanelCrearMedicamento().getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearMedicamento().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearMedicamento().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearMedicamento().getTxtTipo().getText().trim();
			String precioStr = vf.getPanelCrearMedicamento().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearMedicamento().getTxtMarca().getText().trim();
			String vendedor = vf.getPanelCrearMedicamento().getTxtVendedor().getText().trim();
			String caracteristicas = vf.getPanelCrearMedicamento().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearMedicamento().getTxtStock().getText().trim();
			String laboratorio = vf.getPanelCrearMedicamento().getTxtLaboratorio().getText().trim();
			String formatoMedicamento = vf.getPanelCrearMedicamento().getCmbFormatoMedicamento().getSelectedItem()
					.toString();
			String formatoVenta = vf.getPanelCrearMedicamento().getCmbFormatoDeVenta().getSelectedItem().toString();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| vendedor.isEmpty() || caracteristicas.isEmpty() || stockStr.isEmpty() || laboratorio.isEmpty()
					|| formatoMedicamento.isEmpty() || formatoVenta.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setVendedor(vendedor);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setLaboratorio(laboratorio);
			productoActual.setFormatoMedicamento(formatoMedicamento);
			productoActual.setFormatoDeVenta(formatoVenta);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearMedicamento().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getFarmaciaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getFarmaciaDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Medicamento actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarModa() {
		try {
			Moda productoActual = (Moda) vf.getPanelCrearProductoModa().getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearProductoModa().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearProductoModa().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearProductoModa().getCmbTipo().getSelectedItem().toString();
			String precioStr = vf.getPanelCrearProductoModa().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearProductoModa().getCmbMarca().getSelectedItem().toString();
			String caracteristicas = vf.getPanelCrearProductoModa().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearProductoModa().getTxtStock().getText().trim();
			String color = vf.getPanelCrearProductoModa().getTxtColor().getText().trim();
			String talla = vf.getPanelCrearProductoModa().getCmbTalla().getSelectedItem().toString();
			String material = vf.getPanelCrearProductoModa().getCmbMaterial().getSelectedItem().toString();

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || color.isEmpty() || talla.isEmpty()
					|| material.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setColor(color);
			productoActual.setTalla(talla);
			productoActual.setMaterial(material);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearProductoModa().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getModaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getModaDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de moda actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void actualizarVehiculo() {
		try {
			Vehiculo productoActual = (Vehiculo) vf.getPanelCrearVehiculo().getClientProperty("productoActual");

			if (productoActual == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para actualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Obtener datos del formulario
			String nombre = vf.getPanelCrearVehiculo().getTxtNombre().getText().trim();
			String descripcion = vf.getPanelCrearVehiculo().getTxtDescripcion().getText().trim();
			String tipo = vf.getPanelCrearVehiculo().getCmbTipo().getSelectedItem().toString();
			String precioStr = vf.getPanelCrearVehiculo().getTxtPrecio().getText().trim();
			String marca = vf.getPanelCrearVehiculo().getCmbMarca().getSelectedItem().toString();
			String caracteristicas = vf.getPanelCrearVehiculo().getTxtCaracteristicas().getText().trim();
			String stockStr = vf.getPanelCrearVehiculo().getTxtStock().getText().trim();
			String anioStr = vf.getPanelCrearVehiculo().getCmbAnio().getSelectedItem().toString();
			String kilometrajeStr = vf.getPanelCrearVehiculo().getTxtKilometraje().getText().trim();
			boolean esFinanciable = "Sí"
					.equals(vf.getPanelCrearVehiculo().getCmbEsFinanciable().getSelectedItem().toString());

			// Validar campos
			if (nombre.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || precioStr.isEmpty() || marca.isEmpty()
					|| caracteristicas.isEmpty() || stockStr.isEmpty() || anioStr.isEmpty()
					|| kilometrajeStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar objeto
			productoActual.setNombre(nombre);
			productoActual.setDescripcion(descripcion);
			productoActual.setTipo(tipo);
			productoActual.setPrecio(Float.parseFloat(precioStr));
			productoActual.setMarca(marca);
			productoActual.setCaracteristicas(caracteristicas);
			productoActual.setStock(Integer.parseInt(stockStr));
			productoActual.setAnio(Integer.parseInt(anioStr));
			productoActual.setKilometraje(Integer.parseInt(kilometrajeStr));
			productoActual.setEsFinanciable(esFinanciable);

			// Actualizar imagen si se seleccionó una nueva
			File imagen = vf.getPanelCrearVehiculo().getImagenSeleccionada();
			if (imagen != null) {
				productoActual.setFotoProducto(imagen.getAbsolutePath());
			}

			// Actualizar en la base de datos
			int indice = mf.getVehiculoDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getVehiculoDAO().actualizar(indice, productoActual);
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Vehículo actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el producto: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void borrarAlimentoYBebida() {
		AlimentoYBebida productoActual = (AlimentoYBebida) vf.getPanelCrearAlimentoYBebida()
				.getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getAlimentoYBebidaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getAlimentoYBebidaDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				actualizarPanelProductoCreado();

				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarCelular() {
		Celular productoActual = (Celular) vf.getPanelCrearCelular().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getCelularDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getCelularDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarConstruccion() {
		Construccion productoActual = (Construccion) vf.getPanelCrearConstruccion().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getConstruccionDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getConstruccionDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarDeporteYFitness() {
		DeporteYFitness productoActual = (DeporteYFitness) vf.getPanelCDeporteYFitness()
				.getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getDeporteYFitnessDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getDeporteYFitnessDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarElectrodomestico() {
		Electrodomestico productoActual = (Electrodomestico) vf.getPanelCrearElectrodomesticos()
				.getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getElectrodomesticoDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getElectrodomesticoDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarJuguete() {
		Juguete productoActual = (Juguete) vf.getPanelCrearJuguete().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getJugueteDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getJugueteDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarMascota() {
		Mascota productoActual = (Mascota) vf.getPanelCrearMascota().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getMascotaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getMascotaDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarMedicamento() {
		Farmacia productoActual = (Farmacia) vf.getPanelCrearMedicamento().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getFarmaciaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getFarmaciaDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarModa() {
		Moda productoActual = (Moda) vf.getPanelCrearProductoModa().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getModaDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getModaDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Actualizar panel de productos creados
				actualizarPanelProductoCreado();

				// Volver al panel de productos creados
				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void borrarVehiculo() {
		Vehiculo productoActual = (Vehiculo) vf.getPanelCrearVehiculo().getClientProperty("productoActual");

		if (productoActual == null) {
			JOptionPane.showMessageDialog(vf.getVentana(), "No hay producto seleccionado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(), "¿Está seguro de que desea eliminar este producto?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			int indice = mf.getVehiculoDAO().buscarIndicePorId(productoActual.getId());
			if (indice != -1) {
				mf.getVehiculoDAO().eliminarDato(indice);
				JOptionPane.showMessageDialog(vf.getVentana(), "Producto eliminado exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				actualizarPanelProductoCreado();

				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void cargarAlimentoYBebidaEnPanel(AlimentoYBebida producto) {
		vf.getPanelCrearAlimentoYBebida().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearAlimentoYBebida().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearAlimentoYBebida().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearAlimentoYBebida().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearAlimentoYBebida().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearAlimentoYBebida().getTxtVendedor().setText(producto.getVendedor());
		vf.getPanelCrearAlimentoYBebida().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearAlimentoYBebida().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearAlimentoYBebida().getCmbEsLiquido().setSelectedItem(producto.isEsLiquido() ? "Sí" : "No");
		vf.getPanelCrearAlimentoYBebida().getTxtCantidadProducto().setValue(producto.getCantidadProducto());
		vf.getPanelCrearAlimentoYBebida().getCmbTipoEnvase().setSelectedItem(producto.getTipoEnvase());
		vf.getPanelCrearAlimentoYBebida().getTxtUnidadEnvase().setText(String.valueOf(producto.getUnidadEnvase()));

		// Cargar imagen si existe
		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearAlimentoYBebida().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// Ocultar botón de crear y mostrar botones de actualizar y borrar
		vf.getPanelCrearAlimentoYBebida().getBtnCrearAlimentoYBebida().setVisible(false);
		vf.getPanelCrearAlimentoYBebida().getBtnActualizarAlimentoYBebida().setVisible(true);
		vf.getPanelCrearAlimentoYBebida().getBtnBorrarAlimentoYBebida().setVisible(true);

		// Guardar el producto actual para referencia futura
		vf.getPanelCrearAlimentoYBebida().putClientProperty("productoActual", producto);
	}

	public void cargarCelularEnPanel(Celular producto) {
		vf.getPanelCrearCelular().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearCelular().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearCelular().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearCelular().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearCelular().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearCelular().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearCelular().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearCelular().getTxtColor().setText(producto.getColor());
		vf.getPanelCrearCelular().getCmbMemoriaInterna().setSelectedItem(producto.getMemoriaInterna() + "GB");
		vf.getPanelCrearCelular().getCmbMemoriaRam().setSelectedItem(producto.getMemoriaRam() + "GB");
		vf.getPanelCrearCelular().getTxtLargoPantalla().setText(String.valueOf(producto.getLargoPantalla()));
		vf.getPanelCrearCelular().getTxtAnchoPantalla().setText(String.valueOf(producto.getAnchoPantalla()));
		vf.getPanelCrearCelular().getTxtAlturaPantalla().setText(String.valueOf(producto.getAltoPantalla()));
		vf.getPanelCrearCelular().getTxtCamaraFrontal().setText(String.valueOf(producto.getCamaraFrontal()));
		vf.getPanelCrearCelular().getTxtCamaraTrasera().setText(String.valueOf(producto.getCamaraTrasera()));
		vf.getPanelCrearCelular().getCmbPoseeNfc().setSelectedItem(producto.isPoseeNfc() ? "Sí" : "No");

		// Cargar imagen si existe
		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearCelular().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// Ocultar botón de crear y mostrar botones de actualizar y borrar
		vf.getPanelCrearCelular().getBtnCrearCelular().setVisible(false);
		vf.getPanelCrearCelular().getBtnActualizarCelular().setVisible(true);
		vf.getPanelCrearCelular().getBtnBorrarCelular().setVisible(true);

		// Guardar el producto actual para referencia futura
		vf.getPanelCrearCelular().putClientProperty("productoActual", producto);
	}

	public void cargarConstruccionEnPanel(Construccion producto) {
		vf.getPanelCrearConstruccion().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearConstruccion().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearConstruccion().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearConstruccion().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearConstruccion().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearConstruccion().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearConstruccion().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearConstruccion().getTxtModelo().setText(producto.getModelo());
		vf.getPanelCrearConstruccion().getCmbMaterial().setSelectedItem(producto.getMaterial());
		vf.getPanelCrearConstruccion().getTxtColor().setText(producto.getColor());
		vf.getPanelCrearConstruccion().getTxtLargo().setText(String.valueOf(producto.getLargo()));
		vf.getPanelCrearConstruccion().getTxtAncho().setText(String.valueOf(producto.getAncho()));
		vf.getPanelCrearConstruccion().getTxtAltura().setText(String.valueOf(producto.getAltura()));

		// Cargar imagen si existe
		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearConstruccion().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// Ocultar botón de crear y mostrar botones de actualizar y borrar
		vf.getPanelCrearConstruccion().getBtnCrearConstruccion().setVisible(false);
		vf.getPanelCrearConstruccion().getBtnActualizarConstruccion().setVisible(true);
		vf.getPanelCrearConstruccion().getBtnBorrarConstruccion().setVisible(true);

		// Guardar el producto actual para referencia futura
		vf.getPanelCrearConstruccion().putClientProperty("productoActual", producto);
	}

	public void cargarDeporteYFitnessEnPanel(DeporteYFitness producto) {
		vf.getPanelCDeporteYFitness().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCDeporteYFitness().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCDeporteYFitness().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCDeporteYFitness().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCDeporteYFitness().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCDeporteYFitness().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCDeporteYFitness().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCDeporteYFitness().getTxtColor().setText(producto.getColor());
		vf.getPanelCDeporteYFitness().getTxtMaterial().setText(producto.getMaterial());

		// Cargar imagen si existe
		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCDeporteYFitness().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		vf.getPanelCDeporteYFitness().getBtnCrearDeporteYFitness().setVisible(false);
		vf.getPanelCDeporteYFitness().getBtnActualizarDeporteYFitness().setVisible(true);
		vf.getPanelCDeporteYFitness().getBtnBorrarDeporteYFitness().setVisible(true);

		vf.getPanelCDeporteYFitness().putClientProperty("productoActual", producto);
	}

	public void cargarElectrodomesticoEnPanel(Electrodomestico producto) {
		vf.getPanelCrearElectrodomesticos().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearElectrodomesticos().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearElectrodomesticos().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearElectrodomesticos().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearElectrodomesticos().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearElectrodomesticos().getTxtVendedor().setText(producto.getVendedor());
		vf.getPanelCrearElectrodomesticos().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearElectrodomesticos().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearElectrodomesticos().getTxtModelo().setText(producto.getModelo());
		vf.getPanelCrearElectrodomesticos().getTxtVoltaje().setText(String.valueOf(producto.getVoltaje()));
		vf.getPanelCrearElectrodomesticos().getTxtColor().setText(producto.getColor());

		vf.getPanelCrearElectrodomesticos().getBtnCrearElectrodomestico().setVisible(false);
		vf.getPanelCrearElectrodomesticos().getBtnActualizarElectrodomestico().setVisible(true);
		vf.getPanelCrearElectrodomesticos().getBtnBorrarElectrodomestico().setVisible(true);

		vf.getPanelCrearElectrodomesticos().putClientProperty("productoActual", producto);

		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearElectrodomesticos().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public void cargarJugueteEnPanel(Juguete producto) {
		vf.getPanelCrearJuguete().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearJuguete().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearJuguete().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearJuguete().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearJuguete().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearJuguete().getTxtVendedor().setText(producto.getVendedor());
		vf.getPanelCrearJuguete().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearJuguete().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearJuguete().getTxtColor().setText(producto.getColor());
		vf.getPanelCrearJuguete().getTxtMaterial().setText(producto.getMaterial());
		vf.getPanelCrearJuguete().getTxtRangoDeEdad().setText(producto.getRangoDeEdad());

		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearJuguete().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			vf.getPanelCrearJuguete().getBtnCrearJuguete().setVisible(false);
			vf.getPanelCrearJuguete().getBtnActualizarJuguete().setVisible(true);
			vf.getPanelCrearJuguete().getBtnBorrarJuguete().setVisible(true);
		}

		vf.getPanelCrearJuguete().putClientProperty("productoActual", producto);
	}

	public void cargarMascotaEnPanel(Mascota producto) {
		vf.getPanelCrearMascota().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearMascota().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearMascota().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearMascota().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearMascota().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearMascota().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearMascota().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearMascota().getCmbTipoAnimal().setSelectedItem(producto.getTipoAnimal());
		vf.getPanelCrearMascota().getTxtRaza().setText(producto.getRaza());
		vf.getPanelCrearMascota().getTxtColor().setText(producto.getColor());
		vf.getPanelCrearMascota().getCmbFormatoDeVenta().setSelectedItem(producto.getFormatoDeVenta());
		vf.getPanelCrearMascota().getBtnCrearMascota().setVisible(false);
		vf.getPanelCrearMascota().getBtnActualizarMascota().setVisible(true);
		vf.getPanelCrearMascota().getBtnBorrarMascota().setVisible(true);

		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearMascota().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		vf.getPanelCrearMascota().putClientProperty("productoActual", producto);
	}

	public void cargarFarmaciaEnPanel(Farmacia producto) {
		vf.getPanelCrearMedicamento().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearMedicamento().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearMedicamento().getTxtTipo().setText(producto.getTipo());
		vf.getPanelCrearMedicamento().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearMedicamento().getTxtMarca().setText(producto.getMarca());
		vf.getPanelCrearMedicamento().getTxtVendedor().setText(producto.getVendedor());
		vf.getPanelCrearMedicamento().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearMedicamento().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearMedicamento().getTxtLaboratorio().setText(producto.getLaboratorio());
		vf.getPanelCrearMedicamento().getCmbFormatoMedicamento().setSelectedItem(producto.getFormatoMedicamento());
		vf.getPanelCrearMedicamento().getCmbFormatoDeVenta().setSelectedItem(producto.getFormatoDeVenta());
		vf.getPanelCrearMedicamento().getBtnCrearFarmacia().setVisible(false);
		vf.getPanelCrearMedicamento().getBtnActualizarMedicamento().setVisible(true);
		vf.getPanelCrearMedicamento().getBtnBorrarMedicamento().setVisible(true);

		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearMedicamento().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		vf.getPanelCrearMedicamento().putClientProperty("productoActual", producto);
	}

	public void cargarModaEnPanel(Moda producto) {
		vf.getPanelCrearProductoModa().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearProductoModa().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearProductoModa().getCmbTipo().setSelectedItem(producto.getTipo());
		vf.getPanelCrearProductoModa().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearProductoModa().getCmbMarca().setSelectedItem(producto.getMarca());
		vf.getPanelCrearProductoModa().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearProductoModa().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearProductoModa().getTxtColor().setText(producto.getColor());
		vf.getPanelCrearProductoModa().getCmbTalla().setSelectedItem(producto.getTalla());
		vf.getPanelCrearProductoModa().getCmbMaterial().setSelectedItem(producto.getMaterial());
		vf.getPanelCrearProductoModa().getBtnCrearProductoModa().setVisible(false);
		vf.getPanelCrearProductoModa().getBtnActualizarProductoModa().setVisible(true);
		vf.getPanelCrearProductoModa().getBtnBorrarProductoModa().setVisible(true);

		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearProductoModa().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		vf.getPanelCrearProductoModa().putClientProperty("productoActual", producto);
	}

	public void cargarVehiculoEnPanel(Vehiculo producto) {
		vf.getPanelCrearVehiculo().getTxtNombre().setText(producto.getNombre());
		vf.getPanelCrearVehiculo().getTxtDescripcion().setText(producto.getDescripcion());
		vf.getPanelCrearVehiculo().getCmbTipo().setSelectedItem(producto.getTipo());
		vf.getPanelCrearVehiculo().getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
		vf.getPanelCrearVehiculo().getCmbMarca().setSelectedItem(producto.getMarca());
		vf.getPanelCrearVehiculo().getTxtCaracteristicas().setText(producto.getCaracteristicas());
		vf.getPanelCrearVehiculo().getTxtStock().setText(String.valueOf(producto.getStock()));
		vf.getPanelCrearVehiculo().getCmbAnio().setSelectedItem(String.valueOf(producto.getAnio()));
		vf.getPanelCrearVehiculo().getTxtKilometraje().setText(String.valueOf(producto.getKilometraje()));
		vf.getPanelCrearVehiculo().getCmbEsFinanciable().setSelectedItem(producto.isEsFinanciable() ? "Sí" : "No");
		vf.getPanelCrearVehiculo().getBtnCrearVehiculo().setVisible(false);
		vf.getPanelCrearVehiculo().getBtnActualizarVehiculo().setVisible(true);
		vf.getPanelCrearVehiculo().getBtnBorrarVehiculo().setVisible(true);

		if (producto.getFotoProducto() != null && !producto.getFotoProducto().isEmpty()) {
			try {
				File imagen = new File(producto.getFotoProducto());
				vf.getPanelCrearVehiculo().setImagenSeleccionada(imagen);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		vf.getPanelCrearVehiculo().putClientProperty("productoActual", producto);
	}

	public void mostrarPanelPerfil() {
		vf.getPanelPerfil().cargarImagenPerfil(usuarioLogueado.getRutaImagenDePerfil());

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
		vf.getPanelPerfil().cargarImagenPerfil(usuarioLogueado.getRutaImagenDePerfil());
	}

	public void mostrarPanelCarro() {
		ocultarTodosLosPaneles();
		vf.getVentana().add(vf.getPanelCarrito(), BorderLayout.CENTER);
		vf.getPanelCarrito().setVisible(true);

		int indice = mf.getCarritoDAO().buscarIndiceCarrito(usuarioLogueado.getId());
		ArrayList<Item> listaItems = mf.getCarritoDAO().getListaCarritos().get(indice).getListaItems();

		vf.getPanelCarrito().cargarCarrito(listaItems, this::eliminarDelCarrito);

		// Refrescar la vista
		vf.getVentana().revalidate();
		vf.getVentana().repaint();
	}

	// Método para manejar la eliminación de items
	public void eliminarDelCarrito(int indiceItem) {
		try {
			int indiceCarrito = mf.getCarritoDAO().buscarIndiceCarrito(usuarioLogueado.getId());
			ArrayList<Item> listaItems = mf.getCarritoDAO().getListaCarritos().get(indiceCarrito).getListaItems();

			if (indiceItem >= 0 && indiceItem < listaItems.size()) {
				// Eliminar el item de la lista
				listaItems.remove(indiceItem);

				// Actualizar en el DAO
				mf.getCarritoDAO().getListaCarritos().get(indiceCarrito).setListaItems(listaItems);

				// Recargar la vista del carrito
				mostrarPanelCarro();
			}
		} catch (Exception e) {
			// Manejar error
			System.err.println("Error al eliminar item del carrito: " + e.getMessage());
		}

		// Refrescar la vista
		vf.getVentana().revalidate();
		vf.getVentana().repaint();
	}

	public void actualizarUsuario() {
		try {
			String nombre = vf.getPanelUsuario().getTxtNombre().getText().trim();
			String email = vf.getPanelUsuario().getTxtEmail().getText().trim();
			String nombreUsuario = vf.getPanelUsuario().getTxtNombreUsuario().getText().trim();
			String documentoStr = vf.getPanelUsuario().getTxtDocumento().getText().trim();
			String telefonoStr = vf.getPanelUsuario().getTxtTelefono().getText().trim();
			String contrasenia = new String(vf.getPanelUsuario().getTxtContrasenia().getPassword());

			if (nombre.isEmpty() || email.isEmpty() || nombreUsuario.isEmpty() || documentoStr.isEmpty()
					|| telefonoStr.isEmpty() || contrasenia.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El formato del correo electrónico no es válido",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!documentoStr.matches("\\d+")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El documento debe contener solo números",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!telefonoStr.matches("\\d+")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El teléfono debe contener solo números",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!validarFortalezaContrasenia(contrasenia)) {
				JOptionPane.showMessageDialog(vf.getVentana(),
						"La contraseña debe contener al menos:\n- Una letra mayúscula\n- Una letra minúscula\n- Un número",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int documento = Integer.parseInt(documentoStr);
			int telefono = Integer.parseInt(telefonoStr);

			String rutaImagen = usuarioLogueado.getRutaImagenDePerfil();
			File imagen = vf.getPanelUsuario().getImagenSeleccionada();
			if (imagen != null) {
				rutaImagen = imagen.getAbsolutePath();
			}

			Usuario usuarioActualizado = new Usuario(nombre, nombreUsuario, documento, email, telefono, contrasenia,
					rutaImagen, usuarioLogueado.getId());

			int indice = mf.getUsuarioDAO().buscarIndicePorId(usuarioLogueado.getId());

			if (indice == -1) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No se encontró el usuario en la base de datos", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			boolean actualizado = mf.getUsuarioDAO().actualizar(indice, usuarioActualizado);

			if (actualizado) {
				usuarioLogueado = usuarioActualizado;

				JOptionPane.showMessageDialog(vf.getVentana(), "¡Datos actualizados exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				vf.getPanelPerfil().cargarImagenPerfil(rutaImagen);
				vf.getPanelPerfil().getLblNombre().setText(nombre);
				vf.getPanelPerfil().getLblEmail().setText(email);

				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelPerfil(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar los datos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar los datos: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarUsuario() {
		int opcion = JOptionPane.showConfirmDialog(vf.getVentana(),
				"¿Estás seguro de que quieres eliminar tu cuenta? Esta acción es irreversible.", "Eliminar Cuenta",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			boolean eliminado = mf.getUsuarioDAO().eliminar(usuarioLogueado.getId());

			if (eliminado) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Tu cuenta ha sido eliminada exitosamente",
						"Cuenta Eliminada", JOptionPane.INFORMATION_MESSAGE);

				usuarioLogueado = null;
				vf.getPanelSuperior().getBtnCategoria().setVisible(false);
				vf.getPanelSuperior().getBtnVender().setVisible(false);
				vf.getPanelSuperior().getBtnCarro().setVisible(false);
				vf.getPanelSuperior().getBtnPerfil().setVisible(false);

				vf.getPanelLogin().limpiarFormulario();

				ocultarTodosLosPaneles();
				vf.getVentana().add(vf.getPanelLogin(), BorderLayout.CENTER);
				vf.getVentana().revalidate();
				vf.getVentana().repaint();
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar la cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public List<MetodoDePago> obtenerMetodosDePagoPorUsuario(int idUsuario) {
		List<MetodoDePago> metodosDePagoUsuario = new ArrayList<>();

		List<MetodoDePago> todosLosMetodos = mf.getMetodoDePagoDAO().getListaMetodosDePago();

		for (MetodoDePago metodo : todosLosMetodos) {
			if (metodo.getIdAsociado() == idUsuario) {
				metodosDePagoUsuario.add(metodo);
			}
		}

		return metodosDePagoUsuario;
	}

	public void mostrarPanelMetodoDePago() {
		ocultarTodosLosPaneles();

		List<MetodoDePago> metodosDePago = obtenerMetodosDePagoPorUsuario(usuarioLogueado.getId());

		vf.getPanelMetodoDePago().mostrarMetodosDePago(metodosDePago);

		vf.getVentana().add(vf.getPanelMetodoDePago(), BorderLayout.CENTER);
		vf.getVentana().revalidate();
		vf.getVentana().repaint();
	}

	public void agregarMetodoDePago() {
		try {
			String titular = vf.getPanelMetodoDePago().getTxtTitular().getText().trim();
			String numeroTarjetaStr = vf.getPanelMetodoDePago().getTxtNumeroTarjeta().getText().trim();
			String fechaVencimiento = vf.getPanelMetodoDePago().getTxtFechaVencimiento().getText().trim();
			String pinSeguridadStr = vf.getPanelMetodoDePago().getTxtPinSeguridad().getText().trim();

			if (titular.isEmpty() || numeroTarjetaStr.isEmpty() || fechaVencimiento.isEmpty()
					|| pinSeguridadStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!fechaVencimiento.matches("\\d{2}/\\d{2}")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "La fecha de vencimiento debe tener formato MM/AA",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!numeroTarjetaStr.matches("\\d{16}")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El número de tarjeta debe contener 16 dígitos",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!pinSeguridadStr.matches("\\d{3}")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El PIN debe contener 3 dígitos", "Error de validación",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			long numeroTarjeta = Long.parseLong(numeroTarjetaStr);
			int pinSeguridad = Integer.parseInt(pinSeguridadStr);

			MetodoDePago nuevoMetodo = new MetodoDePago(titular, numeroTarjeta, fechaVencimiento, pinSeguridad,
					usuarioLogueado.getId());
			mf.getMetodoDePagoDAO().crear(nuevoMetodo);

			List<MetodoDePago> metodosActualizados = obtenerMetodosDePagoPorUsuario(usuarioLogueado.getId());

			boolean agregado = false;

			for (MetodoDePago metodo : metodosActualizados) {
				if (metodo.getTitular().equals(titular) && metodo.getNumeroTarjeta() == numeroTarjeta
						&& metodo.getFechaVencimiento().equals(fechaVencimiento)
						&& metodo.getPinDeSeguridad() == pinSeguridad) {
					agregado = true;
					break;
				}
			}

			if (agregado) {

				JOptionPane.showMessageDialog(vf.getVentana(), "¡Método de pago agregado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				vf.getPanelMetodoDePago().limpiarFormulario();

				vf.getPanelMetodoDePago().mostrarMetodosDePago(metodosActualizados);
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al agregar el método de pago", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al agregar el método de pago: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarMetodoDePago() {
		try {
			MetodoDePago metodoSeleccionado = vf.getPanelMetodoDePago().getMetodoSeleccionado();
			if (metodoSeleccionado == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Debes seleccionar un método de pago para actualizar",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String titular = vf.getPanelMetodoDePago().getTxtTitular().getText().trim();
			String numeroTarjetaStr = vf.getPanelMetodoDePago().getTxtNumeroTarjeta().getText().trim();
			String fechaVencimiento = vf.getPanelMetodoDePago().getTxtFechaVencimiento().getText().trim();
			String pinSeguridadStr = vf.getPanelMetodoDePago().getTxtPinSeguridad().getText().trim();

			if (titular.isEmpty() || numeroTarjetaStr.isEmpty() || fechaVencimiento.isEmpty()
					|| pinSeguridadStr.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Todos los campos son obligatorios",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!fechaVencimiento.matches("\\d{2}/\\d{2}")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "La fecha de vencimiento debe tener formato MM/AA",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!numeroTarjetaStr.matches("\\d{16}")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El número de tarjeta debe contener 16 dígitos",
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!pinSeguridadStr.matches("\\d{3}")) {
				JOptionPane.showMessageDialog(vf.getVentana(), "El PIN debe contener 3 dígitos", "Error de validación",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			int numeroTarjeta = Integer.parseInt(numeroTarjetaStr);
			int pinSeguridad = Integer.parseInt(pinSeguridadStr);

			String titularOriginal = metodoSeleccionado.getTitular();
			double numeroTarjetaOriginal = metodoSeleccionado.getNumeroTarjeta();
			String fechaVencimientoOriginal = metodoSeleccionado.getFechaVencimiento();
			int pinSeguridadOriginal = metodoSeleccionado.getPinDeSeguridad();

			metodoSeleccionado.setTitular(titular);
			metodoSeleccionado.setNumeroTarjeta(numeroTarjeta);
			metodoSeleccionado.setFechaVencimiento(fechaVencimiento);
			metodoSeleccionado.setPinDeSeguridad(pinSeguridad);

			int indice = mf.getMetodoDePagoDAO().buscarIndicePorAtributos(titularOriginal, numeroTarjetaOriginal,
					fechaVencimientoOriginal, pinSeguridadOriginal, metodoSeleccionado.getIdAsociado());

			if (indice == -1) {
				JOptionPane.showMessageDialog(vf.getVentana(), "No se encontró el método de pago en la base de datos",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			mf.getMetodoDePagoDAO().actualizar(indice, metodoSeleccionado);

			List<MetodoDePago> metodosActualizados = obtenerMetodosDePagoPorUsuario(usuarioLogueado.getId());
			boolean actualizado = false;

			for (MetodoDePago metodo : metodosActualizados) {
				if (metodo.getTitular().equals(titular) && metodo.getNumeroTarjeta() == numeroTarjeta
						&& metodo.getFechaVencimiento().equals(fechaVencimiento)
						&& metodo.getPinDeSeguridad() == pinSeguridad) {
					actualizado = true;
					break;
				}
			}

			if (actualizado) {
				JOptionPane.showMessageDialog(vf.getVentana(), "¡Método de pago actualizado exitosamente!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
				vf.getPanelMetodoDePago().limpiarFormulario();
				vf.getPanelMetodoDePago().mostrarMetodosDePago(metodosActualizados);
			} else {
				JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el método de pago", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error en el formato de los campos numéricos",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al actualizar el método de pago: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarMetodoDePago() {
		try {
			MetodoDePago metodoSeleccionado = vf.getPanelMetodoDePago().getMetodoSeleccionado();
			if (metodoSeleccionado == null) {
				JOptionPane.showMessageDialog(vf.getVentana(), "Debes seleccionar un método de pago para eliminar",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int opcion = JOptionPane.showConfirmDialog(vf.getVentana(),
					"¿Estás seguro de que quieres eliminar este método de pago?", "Eliminar Método de Pago",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (opcion == JOptionPane.YES_OPTION) {

				int indice = mf.getMetodoDePagoDAO().buscarIndicePorAtributos(metodoSeleccionado.getTitular(),
						metodoSeleccionado.getNumeroTarjeta(), metodoSeleccionado.getFechaVencimiento(),
						metodoSeleccionado.getPinDeSeguridad(), metodoSeleccionado.getIdAsociado());

				if (indice == -1) {
					JOptionPane.showMessageDialog(vf.getVentana(),
							"No se encontró el método de pago en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String titular = metodoSeleccionado.getTitular();
				double numeroTarjeta = metodoSeleccionado.getNumeroTarjeta();
				String fechaVencimiento = metodoSeleccionado.getFechaVencimiento();
				int pinSeguridad = metodoSeleccionado.getPinDeSeguridad();
				mf.getMetodoDePagoDAO().eliminar(indice);

				List<MetodoDePago> metodosActualizados = obtenerMetodosDePagoPorUsuario(usuarioLogueado.getId());
				boolean eliminado = true;

				for (MetodoDePago metodo : metodosActualizados) {
					if (metodo.getTitular().equals(titular) && metodo.getNumeroTarjeta() == numeroTarjeta
							&& metodo.getFechaVencimiento().equals(fechaVencimiento)
							&& metodo.getPinDeSeguridad() == pinSeguridad) {
						eliminado = false;
						break;
					}
				}

				if (eliminado) {
					JOptionPane.showMessageDialog(vf.getVentana(), "¡Método de pago eliminado exitosamente!", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					vf.getPanelMetodoDePago().limpiarFormulario();
					vf.getPanelMetodoDePago().mostrarMetodosDePago(metodosActualizados);
				} else {
					JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el método de pago", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(vf.getVentana(), "Error al eliminar el método de pago: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void panelPrincipalFiltrado() {
		ocultarTodosLosPaneles();
		String textoBusqueda = vf.getPanelSuperior().getTxtFieldBuscador().getText();
	    if (!textoBusqueda.equals("Buscar productos, marcas y más...") && !textoBusqueda.isEmpty()) {
	        ArrayList<AlimentoYBebida> alimentos = mf.getAlimentoYBebidaDAO().getListaAlimentosYBebidas();
	        ArrayList<Celular> celulares = mf.getCelularDAO().getListaCelulares();
	        ArrayList<Construccion> construcciones = mf.getConstruccionDAO().getListaConstruccion();
	        ArrayList<DeporteYFitness> deportes = mf.getDeporteYFitnessDAO().getListaDeportesYFitness();
	        ArrayList<Electrodomestico> electrodomesticos = mf.getElectrodomesticoDAO().getListaElectrodomesticos();
	        ArrayList<Juguete> juguetes = mf.getJugueteDAO().getListaJuguetes();
	        ArrayList<Mascota> mascotas = mf.getMascotaDAO().getListaMascotas();
	        ArrayList<Farmacia> farmacias = mf.getFarmaciaDAO().getListaFarmacia();
	        ArrayList<Moda> modas = mf.getModaDAO().getListaModa();
	        ArrayList<Vehiculo> vehiculos = mf.getVehiculoDAO().getListaVehiculos();
	        
	        // Crear el panel filtrado
	        PanelPrincipalFiltrado panelFiltrado = new PanelPrincipalFiltrado(vf);
	        panelFiltrado.mostrarProductosFiltrados(
	            textoBusqueda, 
	            alimentos, 
	            celulares, 
	            construcciones, 
	            deportes, 
	            electrodomesticos, 
	            juguetes, 
	            mascotas, 
	            farmacias, 
	            modas, 
	            vehiculos
	        );
	        
	        ocultarTodosLosPaneles();
	        vf.getVentana().add(panelFiltrado, BorderLayout.CENTER);
	        vf.getVentana().revalidate();
	        vf.getVentana().repaint();
	    } else {
	        mostrarPanelPrincipal();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println(comando);

		switch (comando) {
		case "Iniciar Sesion": {
			iniciarSesion();
			break;
		}

		case "Crear Cuenta": {
			mostrarFormularioRegistro();
			break;
		}

		case "Principal":
			if (usuarioLogueado != null) {
				mostrarPanelPrincipal();
			}
			break;

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
			mostrarPanelCarro();
			break;
		}

		case "Alimentos y Bebidas": {
			vf.getPanelCrearAlimentoYBebida().getBtnCrearAlimentoYBebida().setVisible(true);
			vf.getPanelCrearAlimentoYBebida().getBtnActualizarAlimentoYBebida().setVisible(false);
			vf.getPanelCrearAlimentoYBebida().getBtnBorrarAlimentoYBebida().setVisible(false);
			vf.getPanelCrearAlimentoYBebida().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearAlimentoYBebida(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			System.out.println(mf.getAlimentoYBebidaDAO().mostrarDatos());
			break;
		}

		case "Celulares": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearCelular().getBtnCrearCelular().setVisible(true);
			vf.getPanelCrearCelular().getBtnActualizarCelular().setVisible(false);
			vf.getPanelCrearCelular().getBtnBorrarCelular().setVisible(false);
			vf.getPanelCrearCelular().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearCelular(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Construccion": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearConstruccion().getBtnCrearConstruccion().setVisible(true);
			vf.getPanelCrearConstruccion().getBtnActualizarConstruccion().setVisible(false);
			vf.getPanelCrearConstruccion().getBtnBorrarConstruccion().setVisible(false);
			vf.getPanelCrearConstruccion().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearConstruccion(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Deporte y Fitness": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCDeporteYFitness().getBtnCrearDeporteYFitness().setVisible(true);
			vf.getPanelCDeporteYFitness().getBtnActualizarDeporteYFitness().setVisible(false);
			vf.getPanelCDeporteYFitness().getBtnBorrarDeporteYFitness().setVisible(false);
			vf.getPanelCDeporteYFitness().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCDeporteYFitness(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Electrodomesticos": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearElectrodomesticos().getBtnCrearElectrodomestico().setVisible(true);
			vf.getPanelCrearElectrodomesticos().getBtnActualizarElectrodomestico().setVisible(false);
			vf.getPanelCrearElectrodomesticos().getBtnBorrarElectrodomestico().setVisible(false);
			vf.getPanelCrearElectrodomesticos().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearElectrodomesticos(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Juguetes": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearJuguete().getBtnCrearJuguete().setVisible(true);
			vf.getPanelCrearJuguete().getBtnActualizarJuguete().setVisible(false);
			vf.getPanelCrearJuguete().getBtnBorrarJuguete().setVisible(false);
			vf.getPanelCrearJuguete().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearJuguete(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Mascotas": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearMascota().getBtnCrearMascota().setVisible(true);
			vf.getPanelCrearMascota().getBtnActualizarMascota().setVisible(false);
			vf.getPanelCrearMascota().getBtnBorrarMascota().setVisible(false);
			vf.getPanelCrearMascota().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearMascota(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Medicamentos": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearMedicamento().getBtnCrearFarmacia().setVisible(true);
			vf.getPanelCrearMedicamento().getBtnActualizarMedicamento().setVisible(false);
			vf.getPanelCrearMedicamento().getBtnBorrarMedicamento().setVisible(false);
			vf.getPanelCrearMedicamento().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearMedicamento(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Moda": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearProductoModa().getBtnCrearProductoModa().setVisible(true);
			vf.getPanelCrearProductoModa().getBtnActualizarProductoModa().setVisible(false);
			vf.getPanelCrearProductoModa().getBtnBorrarProductoModa().setVisible(false);
			vf.getPanelCrearProductoModa().limpiarFormulario();

			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelCrearProductoModa(), BorderLayout.CENTER);
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Vehiculos": {
			// Mostrar botón de crear y ocultar botones de actualizar y borrar
			vf.getPanelCrearVehiculo().getBtnCrearVehiculo().setVisible(true);
			vf.getPanelCrearVehiculo().getBtnActualizarVehiculo().setVisible(false);
			vf.getPanelCrearVehiculo().getBtnBorrarVehiculo().setVisible(false);
			vf.getPanelCrearVehiculo().limpiarFormulario();

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

		case "Crear vehiculo": {
			guardarVehiculo();
			break;
		}

		case "actualizar": {
			JButton boton = (JButton) e.getSource();
			Object producto = boton.getClientProperty("producto");
			String tipoProducto = (String) boton.getClientProperty("tipoProducto");

			ocultarTodosLosPaneles();

			switch (tipoProducto) {
			case "AlimentoYBebida":
				vf.getVentana().add(vf.getPanelCrearAlimentoYBebida(), BorderLayout.CENTER);
				cargarAlimentoYBebidaEnPanel((AlimentoYBebida) producto);
				break;
			case "Celular":
				vf.getVentana().add(vf.getPanelCrearCelular(), BorderLayout.CENTER);
				cargarCelularEnPanel((Celular) producto);
				break;
			case "Construccion":
				vf.getVentana().add(vf.getPanelCrearConstruccion(), BorderLayout.CENTER);
				cargarConstruccionEnPanel((Construccion) producto);
				break;
			case "DeporteYFitness":
				vf.getVentana().add(vf.getPanelCDeporteYFitness(), BorderLayout.CENTER);
				cargarDeporteYFitnessEnPanel((DeporteYFitness) producto);
				break;
			case "Electrodomestico":
				vf.getVentana().add(vf.getPanelCrearElectrodomesticos(), BorderLayout.CENTER);
				cargarElectrodomesticoEnPanel((Electrodomestico) producto);
				break;
			case "Juguete":
				vf.getVentana().add(vf.getPanelCrearJuguete(), BorderLayout.CENTER);
				cargarJugueteEnPanel((Juguete) producto);
				break;
			case "Mascota":
				vf.getVentana().add(vf.getPanelCrearMascota(), BorderLayout.CENTER);
				cargarMascotaEnPanel((Mascota) producto);
				break;
			case "Farmacia":
				vf.getVentana().add(vf.getPanelCrearMedicamento(), BorderLayout.CENTER);
				cargarFarmaciaEnPanel((Farmacia) producto);
				break;
			case "Moda":
				vf.getVentana().add(vf.getPanelCrearProductoModa(), BorderLayout.CENTER);
				cargarModaEnPanel((Moda) producto);
				break;
			case "Vehiculo":
				vf.getVentana().add(vf.getPanelCrearVehiculo(), BorderLayout.CENTER);
				cargarVehiculoEnPanel((Vehiculo) producto);
				break;
			}

			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Cerrar Sesion": {
			cerrarSesion();
			break;
		}

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
			vf.getVentana().add(vf.getPanelUsuario(), BorderLayout.CENTER);
			mostrarPanelUsuario();
			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Panel Productos Creados": {
			ocultarTodosLosPaneles();
			vf.getVentana().add(vf.getPanelProductoCreado(), BorderLayout.CENTER);
			actualizarPanelProductoCreado();

			vf.getPanelProductoCreado().addActionListener(this);

			vf.getVentana().revalidate();
			vf.getVentana().repaint();
			break;
		}

		case "Actualizar AlimentoYBebida": {
			actualizarAlimentoYBebida();
			break;
		}

		case "Actualizar Celular": {
			actualizarCelular();
			break;
		}

		case "Actualizar Construccion": {
			actualizarConstruccion();
			break;
		}

		case "Actualizar DeporteYFitness": {
			actualizarDeporteYFitness();
			break;
		}

		case "Actualizar Electrodomestico": {
			actualizarElectrodomestico();
			break;
		}

		case "Actualizar Juguete": {
			actualizarJuguete();
			break;
		}

		case "Actualizar Mascota": {
			actualizarMascota();
			break;
		}

		case "Actualizar Medicamento": {
			actualizarMedicamento();
			break;
		}

		case "Actualizar ProductoModa": {
			actualizarModa();
			break;
		}

		case "Actualizar Vehiculo": {
			actualizarVehiculo();
			break;
		}

		case "Borrar AlimentoYBebida": {
			borrarAlimentoYBebida();
			break;
		}

		case "Borrar Celular": {
			borrarCelular();
			break;
		}

		case "Borrar Construccion": {
			borrarConstruccion();
			break;
		}

		case "Borrar DeporteYFitness": {
			borrarDeporteYFitness();
			break;
		}

		case "Borrar Electrodomestico": {
			borrarElectrodomestico();
			break;
		}

		case "Borrar Juguete": {
			borrarJuguete();
			break;
		}

		case "Borrar Mascota": {
			borrarMascota();
			break;
		}

		case "Borrar Medicamento": {
			borrarMedicamento();
			break;
		}

		case "Borrar ProductoModa": {
			borrarModa();
			break;
		}

		case "Borrar Vehiculo": {
			borrarVehiculo();
			break;
		}

		case "Actualizar Usuario": {
			actualizarUsuario();
			break;
		}
		case "Eliminar Usuario": {
			eliminarUsuario();
			break;
		}

		case "Panel MetodoDePago": {
			mostrarPanelMetodoDePago();
			break;
		}

		case "Agregar MetodoPago": {
			agregarMetodoDePago();
			break;
		}

		case "Actualizar MetodoPago": {
			actualizarMetodoDePago();
			break;
		}

		case "Eliminar MetodoPago": {
			eliminarMetodoDePago();
			break;
		}

		case "Volver MetodoPago": {
            mostrarPanelPrincipal();
			break;
		}
		case "Comprar Producto": {
			comprarProducto();
			break;
		}
		case "Agregar Carrito": {
			agregarCarrito();
			break;
		}
		case "Comprar Carrito": {
			comprarCarrito();
		}
		case "Buscar": {
		    panelPrincipalFiltrado();
		    break;
		}
		}
	}

	public void inicializarActionListener() {
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
		vf.getPanelSeleccionarCategoria().getBtnAlimentoYBebida().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnAlimentoYBebida().setActionCommand("Alimentos y Bebidas");
		vf.getPanelSeleccionarCategoria().getBtnCelular().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnCelular().setActionCommand("Celulares");
		vf.getPanelSeleccionarCategoria().getBtnConstruccion().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnConstruccion().setActionCommand("Construccion");
		vf.getPanelSeleccionarCategoria().getBtnDeporteYFitness().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnDeporteYFitness().setActionCommand("Deporte y Fitness");
		vf.getPanelSeleccionarCategoria().getBtnElectrodomesticos().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnElectrodomesticos().setActionCommand("Electrodomesticos");
		vf.getPanelSeleccionarCategoria().getBtnJuguete().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnJuguete().setActionCommand("Juguetes");
		vf.getPanelSeleccionarCategoria().getBtnMascota().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnMascota().setActionCommand("Mascotas");
		vf.getPanelSeleccionarCategoria().getBtnMedicamento().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnMedicamento().setActionCommand("Medicamentos");
		vf.getPanelSeleccionarCategoria().getBtnModa().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnModa().setActionCommand("Moda");
		vf.getPanelSeleccionarCategoria().getBtnVehiculo().addActionListener(this);
		vf.getPanelSeleccionarCategoria().getBtnVehiculo().setActionCommand("Vehiculos");
		vf.getPanelPerfil().getBtnUsuario().addActionListener(this);
		vf.getPanelPerfil().getBtnUsuario().setActionCommand("Panel Usuario");
		vf.getPanelPerfil().getBtnCerrarSesion().addActionListener(this);
		vf.getPanelPerfil().getBtnCerrarSesion().setActionCommand("Cerrar Sesion");
		vf.getPanelUsuario().getBtnActualizarUsuario().addActionListener(this);
		vf.getPanelUsuario().getBtnActualizarUsuario().setActionCommand("Actualizar Usuario");
		vf.getPanelUsuario().getBtnEliminarUsuario().addActionListener(this);
		vf.getPanelUsuario().getBtnEliminarUsuario().setActionCommand("Eliminar Usuario");
		vf.getPanelMetodoDePago().getBtnAgregarMetodo().addActionListener(this);
		vf.getPanelMetodoDePago().getBtnAgregarMetodo().setActionCommand("Agregar MetodoPago");
		vf.getPanelMetodoDePago().getBtnEditarMetodo().addActionListener(this);
		vf.getPanelMetodoDePago().getBtnEditarMetodo().setActionCommand("Actualizar MetodoPago");
		vf.getPanelMetodoDePago().getBtnEliminarMetodo().addActionListener(this);
		vf.getPanelMetodoDePago().getBtnEliminarMetodo().setActionCommand("Eliminar MetodoPago");
		vf.getPanelMetodoDePago().getBtnVolver().addActionListener(this);
		vf.getPanelMetodoDePago().getBtnVolver().setActionCommand("Volver MetodoPago");
		vf.getPanelPerfil().getBtnMetodoDePago().addActionListener(this);
		vf.getPanelPerfil().getBtnMetodoDePago().setActionCommand("Panel MetodoDePago");
		vf.getPanelPerfil().getBtnProducto().addActionListener(this);
		vf.getPanelPerfil().getBtnProducto().setActionCommand("Panel Productos Creados");
		vf.getPanelSuperior().getBtnCategoria().setVisible(false);
		vf.getPanelSuperior().getBtnVender().setVisible(false);
		vf.getPanelSuperior().getBtnCarro().setVisible(false);
		vf.getPanelSuperior().getBtnPerfil().setVisible(false);
		vf.getPanelSuperior().getBtnMercadoLibre().addActionListener(this);

		vf.getPanelCrearAlimentoYBebida().getBtnActualizarAlimentoYBebida().addActionListener(this);
		vf.getPanelCrearAlimentoYBebida().getBtnActualizarAlimentoYBebida()
				.setActionCommand("Actualizar AlimentoYBebida");
		vf.getPanelCrearAlimentoYBebida().getBtnBorrarAlimentoYBebida().addActionListener(this);
		vf.getPanelCrearAlimentoYBebida().getBtnBorrarAlimentoYBebida().setActionCommand("Borrar AlimentoYBebida");

		// PanelCrearCelular
		vf.getPanelCrearCelular().getBtnActualizarCelular().addActionListener(this);
		vf.getPanelCrearCelular().getBtnActualizarCelular().setActionCommand("Actualizar Celular");
		vf.getPanelCrearCelular().getBtnBorrarCelular().addActionListener(this);
		vf.getPanelCrearCelular().getBtnBorrarCelular().setActionCommand("Borrar Celular");

		// PanelCrearConstruccion
		vf.getPanelCrearConstruccion().getBtnActualizarConstruccion().addActionListener(this);
		vf.getPanelCrearConstruccion().getBtnActualizarConstruccion().setActionCommand("Actualizar Construccion");
		vf.getPanelCrearConstruccion().getBtnBorrarConstruccion().addActionListener(this);
		vf.getPanelCrearConstruccion().getBtnBorrarConstruccion().setActionCommand("Borrar Construccion");

		// PanelCDeporteYFitness
		vf.getPanelCDeporteYFitness().getBtnActualizarDeporteYFitness().addActionListener(this);
		vf.getPanelCDeporteYFitness().getBtnActualizarDeporteYFitness().setActionCommand("Actualizar DeporteYFitness");
		vf.getPanelCDeporteYFitness().getBtnBorrarDeporteYFitness().addActionListener(this);
		vf.getPanelCDeporteYFitness().getBtnBorrarDeporteYFitness().setActionCommand("Borrar DeporteYFitness");

		// PanelCrearElectrodomesticos
		vf.getPanelCrearElectrodomesticos().getBtnActualizarElectrodomestico().addActionListener(this);
		vf.getPanelCrearElectrodomesticos().getBtnActualizarElectrodomestico()
				.setActionCommand("Actualizar Electrodomestico");
		vf.getPanelCrearElectrodomesticos().getBtnBorrarElectrodomestico().addActionListener(this);
		vf.getPanelCrearElectrodomesticos().getBtnBorrarElectrodomestico().setActionCommand("Borrar Electrodomestico");

		// PanelCrearJuguete
		vf.getPanelCrearJuguete().getBtnActualizarJuguete().addActionListener(this);
		vf.getPanelCrearJuguete().getBtnActualizarJuguete().setActionCommand("Actualizar Juguete");
		vf.getPanelCrearJuguete().getBtnBorrarJuguete().addActionListener(this);
		vf.getPanelCrearJuguete().getBtnBorrarJuguete().setActionCommand("Borrar Juguete");

		// PanelCrearMascota
		vf.getPanelCrearMascota().getBtnActualizarMascota().addActionListener(this);
		vf.getPanelCrearMascota().getBtnActualizarMascota().setActionCommand("Actualizar Mascota");
		vf.getPanelCrearMascota().getBtnBorrarMascota().addActionListener(this);
		vf.getPanelCrearMascota().getBtnBorrarMascota().setActionCommand("Borrar Mascota");

		// PanelCrearMedicamento
		vf.getPanelCrearMedicamento().getBtnActualizarMedicamento().addActionListener(this);
		vf.getPanelCrearMedicamento().getBtnActualizarMedicamento().setActionCommand("Actualizar Medicamento");
		vf.getPanelCrearMedicamento().getBtnBorrarMedicamento().addActionListener(this);
		vf.getPanelCrearMedicamento().getBtnBorrarMedicamento().setActionCommand("Borrar Medicamento");

		// PanelCrearProductoModa
		vf.getPanelCrearProductoModa().getBtnActualizarProductoModa().addActionListener(this);
		vf.getPanelCrearProductoModa().getBtnActualizarProductoModa().setActionCommand("Actualizar ProductoModa");
		vf.getPanelCrearProductoModa().getBtnBorrarProductoModa().addActionListener(this);
		vf.getPanelCrearProductoModa().getBtnBorrarProductoModa().setActionCommand("Borrar ProductoModa");

		// PanelCrearVehiculo
		vf.getPanelCrearVehiculo().getBtnActualizarVehiculo().addActionListener(this);
		vf.getPanelCrearVehiculo().getBtnActualizarVehiculo().setActionCommand("Actualizar Vehiculo");
		vf.getPanelCrearVehiculo().getBtnBorrarVehiculo().addActionListener(this);
		vf.getPanelCrearVehiculo().getBtnBorrarVehiculo().setActionCommand("Borrar Vehiculo");

		// PanelMostrar
		vf.getPanelMostrarProducto().getBtnComprar().addActionListener(this);
		vf.getPanelMostrarProducto().getBtnComprar().setActionCommand("Comprar Producto");

		vf.getPanelMostrarProducto().getBtnCarrito().addActionListener(this);
		vf.getPanelMostrarProducto().getBtnCarrito().setActionCommand("Agregar Carrito");

		// Factura
		vf.getPanelCarrito().getBtnComprarCarrito().addActionListener(this);
		vf.getPanelCarrito().getBtnComprarCarrito().setActionCommand("Comprar Carrito");
		
		vf.getPanelSuperior().getBtnBuscar().addActionListener(this);
		vf.getPanelSuperior().getBtnBuscar().setActionCommand("Buscar");
	    
	    // ActionListener para el campo de búsqueda (cuando se presiona Enter)
	    vf.getPanelSuperior().getTxtFieldBuscador().addActionListener(this);
	    vf.getPanelSuperior().getTxtFieldBuscador().setActionCommand("Buscar");
	}
}