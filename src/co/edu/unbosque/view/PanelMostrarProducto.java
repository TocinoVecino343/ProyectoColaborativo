package co.edu.unbosque.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class PanelMostrarProducto extends JPanel {

	// Variables privadas globales para componentes Swing
	private JPanel panelContenido;
	private JPanel panelSuperior;
	private JPanel panelImagen;
	private JLabel lblImagen;
	private JPanel panelInfoBasica;
	private JLabel lblTiendaOficial;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JLabel lblCantidad;
	private JPanel panelBotones;
	private JButton btnComprar;
	private JButton btnCarrito;
	private JPanel panelCaracteristicas;
	private JLabel lblTituloCaracteristicas;
	private JPanel panelListaCaracteristicas;
	private JPanel panelDescripcion;
	private JLabel lblTituloDescripcion;
	private JTextArea txtDescripcion;
	private JPanel panelInferior;
	private JScrollPane scrollPane;

	public PanelMostrarProducto() {
		initComponents();
	}

	public void actualizarProducto(String nombre, double precio, String fotoPath, String marca, int stock,
			String descripcion, String caracteristicas) {

		// Actualizar información básica
		lblNombre.setText("<html>" + (nombre != null ? nombre : "") + "</html>");
		lblPrecio.setText("$ " + String.format("%,.0f", precio));

		String stockTexto = stock > 0 ? "Stock disponible" : "Agotado";
		lblStock.setText(stockTexto);
		lblStock.setForeground(stock <= 0 ? Color.RED : new Color(0, 150, 0));

		lblCantidad.setText("Cantidad: " + (stock > 0 ? stock + " unidad" + (stock > 1 ? "es" : "") : "0"));

		// Actualizar imagen
		actualizarImagen(fotoPath);

		// Actualizar características
		actualizarCaracteristicas(caracteristicas);

		// Actualizar descripción
		actualizarDescripcion(descripcion);

		// Forzar actualización visual
		revalidate();
		repaint();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		setBackground(new Color(249, 249, 249));

		// Crear estructura una sola vez
		panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		panelContenido.setBackground(new Color(249, 249, 249));
		panelContenido.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

		// --- Panel Superior ---
		panelSuperior = new JPanel(new BorderLayout());
		panelSuperior.setBackground(new Color(249, 249, 249));
		panelSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 600));
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

		// Imagen
		panelImagen = new JPanel(new BorderLayout());
		panelImagen.setBackground(Color.WHITE);
		panelImagen.setPreferredSize(new Dimension(350, 350));
		panelImagen.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
						BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		lblImagen = new JLabel("Cargando...");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setVerticalAlignment(SwingConstants.CENTER);
		panelImagen.add(lblImagen, BorderLayout.CENTER);
		panelSuperior.add(panelImagen, BorderLayout.WEST);

		// Info básica
		panelInfoBasica = new JPanel();
		panelInfoBasica.setLayout(new BoxLayout(panelInfoBasica, BoxLayout.Y_AXIS));
		panelInfoBasica.setBackground(new Color(249, 249, 249));
		panelInfoBasica.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));

		lblTiendaOficial = new JLabel("TIENDA OFICIAL");
		lblTiendaOficial.setFont(new Font("Arial", Font.BOLD, 11));
		lblTiendaOficial.setForeground(Color.WHITE);
		lblTiendaOficial.setOpaque(true);
		lblTiendaOficial.setBackground(new Color(66, 66, 66));
		lblTiendaOficial.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
		lblTiendaOficial.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblNombre = new JLabel("<html></html>");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 24));
		lblNombre.setForeground(new Color(51, 51, 51));
		lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblNombre.setMaximumSize(new Dimension(400, 80));

		lblPrecio = new JLabel("$ 0");
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 36));
		lblPrecio.setForeground(new Color(51, 51, 51));
		lblPrecio.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblStock = new JLabel("Stock disponible");
		lblStock.setFont(new Font("Arial", Font.BOLD, 14));
		lblStock.setForeground(new Color(0, 150, 0));
		lblStock.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblCantidad = new JLabel("Cantidad: 0");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCantidad.setForeground(new Color(102, 102, 102));
		lblCantidad.setAlignmentX(Component.LEFT_ALIGNMENT);

		// Botones
		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		panelBotones.setBackground(new Color(249, 249, 249));
		panelBotones.setAlignmentX(Component.LEFT_ALIGNMENT);

		btnComprar = new JButton("Comprar ahora");
		btnComprar.setPreferredSize(new Dimension(280, 45));
		btnComprar.setMaximumSize(new Dimension(280, 45));
		btnComprar.setBackground(new Color(74, 144, 226));
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setFont(new Font("Arial", Font.BOLD, 14));
		btnComprar.setFocusPainted(false);
		btnComprar.setBorderPainted(false);
		btnComprar.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnComprar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCarrito = new JButton("Agregar al carrito");
		btnCarrito.setPreferredSize(new Dimension(280, 40));
		btnCarrito.setMaximumSize(new Dimension(280, 40));
		btnCarrito.setBackground(new Color(220, 230, 240));
		btnCarrito.setForeground(new Color(74, 144, 226));
		btnCarrito.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCarrito.setFocusPainted(false);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnCarrito.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Hover efectos
		setupButtonHover(btnComprar, new Color(74, 144, 226), new Color(60, 120, 190));
		setupButtonHover(btnCarrito, new Color(220, 230, 240), new Color(200, 210, 220));

		panelBotones.add(btnComprar);
		panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
		panelBotones.add(btnCarrito);

		panelInfoBasica.add(lblTiendaOficial);
		panelInfoBasica.add(Box.createRigidArea(new Dimension(0, 15)));
		panelInfoBasica.add(lblNombre);
		panelInfoBasica.add(Box.createRigidArea(new Dimension(0, 20)));
		panelInfoBasica.add(lblPrecio);
		panelInfoBasica.add(Box.createRigidArea(new Dimension(0, 15)));
		panelInfoBasica.add(lblStock);
		panelInfoBasica.add(Box.createRigidArea(new Dimension(0, 8)));
		panelInfoBasica.add(lblCantidad);
		panelInfoBasica.add(Box.createRigidArea(new Dimension(0, 30)));
		panelInfoBasica.add(panelBotones);

		panelSuperior.add(panelInfoBasica, BorderLayout.CENTER);

		// --- Sección de características ---
		panelCaracteristicas = new JPanel();
		panelCaracteristicas.setLayout(new BoxLayout(panelCaracteristicas, BoxLayout.Y_AXIS));
		panelCaracteristicas.setBackground(Color.WHITE);
		panelCaracteristicas.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
						BorderFactory.createEmptyBorder(25, 25, 25, 25)));
		panelCaracteristicas.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblTituloCaracteristicas = new JLabel("características");
		lblTituloCaracteristicas.setFont(new Font("Arial", Font.BOLD, 16));
		lblTituloCaracteristicas.setForeground(new Color(51, 51, 51));
		lblTituloCaracteristicas.setAlignmentX(Component.LEFT_ALIGNMENT);

		panelListaCaracteristicas = new JPanel();
		panelListaCaracteristicas.setLayout(new BoxLayout(panelListaCaracteristicas, BoxLayout.Y_AXIS));
		panelListaCaracteristicas.setBackground(Color.WHITE);
		panelListaCaracteristicas.setAlignmentX(Component.LEFT_ALIGNMENT);

		panelCaracteristicas.add(lblTituloCaracteristicas);
		panelCaracteristicas.add(Box.createRigidArea(new Dimension(0, 15)));
		panelCaracteristicas.add(panelListaCaracteristicas);

		// --- Descripción ---
		panelDescripcion = new JPanel();
		panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.Y_AXIS));
		panelDescripcion.setBackground(Color.WHITE);
		panelDescripcion.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
						BorderFactory.createEmptyBorder(25, 25, 25, 25)));
		panelDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

		// --- Panel inferior ---
		panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
		panelInferior.setBackground(new Color(249, 249, 249));
		panelInferior.setAlignmentX(Component.LEFT_ALIGNMENT);

		panelCaracteristicas.setMaximumSize(new Dimension(700, Integer.MAX_VALUE));
		panelInferior.add(panelCaracteristicas);

		// Agregar al contenido
		panelContenido.add(panelSuperior);
		panelContenido.add(Box.createRigidArea(new Dimension(0, 30)));
		panelContenido.add(panelInferior);

		// Scroll
		scrollPane = new JScrollPane(panelContenido);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(new Color(249, 249, 249));

		add(scrollPane, BorderLayout.CENTER);
	}

	private void setupButtonHover(JButton button, Color normal, Color hover) {
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(hover);
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(normal);
			}
		});
	}

	private void actualizarImagen(String fotoPath) {
		if (fotoPath != null && !fotoPath.trim().isEmpty()) {
			try {
				ImageIcon icon;
				if (fotoPath.startsWith("http")) {
					URL url = new URL(fotoPath);
					BufferedImage img = ImageIO.read(url);
					icon = new ImageIcon(img);
				} else {
					icon = new ImageIcon(fotoPath);
				}
				Image img = icon.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
				lblImagen.setIcon(new ImageIcon(img));
				lblImagen.setText(null); // Eliminar texto si hay imagen
			} catch (Exception ex) {
				lblImagen.setIcon(null);
				lblImagen.setText("Imagen no disponible");
				lblImagen.setForeground(Color.GRAY);
			}
		} else {
			lblImagen.setIcon(null);
			lblImagen.setText("Imagen no disponible");
			lblImagen.setForeground(Color.GRAY);
		}
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setVerticalAlignment(SwingConstants.CENTER);
	}

	private void actualizarCaracteristicas(String caracteristicas) {
		panelListaCaracteristicas.removeAll();
		if (caracteristicas != null && !caracteristicas.trim().isEmpty()) {
			String clean = caracteristicas.replaceAll("<[^>]*>", " ").replaceAll("\\s+", " ").trim();
			String[] parts = clean.split("\\.");
			for (String part : parts) {
				String p = part.trim();
				if (!p.isEmpty()) {
					JLabel label = new JLabel("• " + p + ".");
					label.setFont(new Font("Arial", Font.PLAIN, 14));
					label.setForeground(new Color(102, 102, 102));
					label.setAlignmentX(Component.LEFT_ALIGNMENT);
					label.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
					panelListaCaracteristicas.add(label);
				}
			}
		}
		panelListaCaracteristicas.revalidate();
		panelListaCaracteristicas.repaint();
	}

	private void actualizarDescripcion(String descripcion) {
		// Si ya existe un panel de descripción con contenido, lo removemos
		if (panelDescripcion.getComponentCount() > 0) {
			panelInferior.remove(panelDescripcion);
		}

		if (descripcion != null && !descripcion.trim().isEmpty()) {
			panelDescripcion.removeAll();

			lblTituloDescripcion = new JLabel("Descripción del producto");
			lblTituloDescripcion.setFont(new Font("Arial", Font.BOLD, 16));
			lblTituloDescripcion.setForeground(new Color(51, 51, 51));
			lblTituloDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

			txtDescripcion = new JTextArea(descripcion);
			txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
			txtDescripcion.setForeground(new Color(102, 102, 102));
			txtDescripcion.setLineWrap(true);
			txtDescripcion.setWrapStyleWord(true);
			txtDescripcion.setEditable(false);
			txtDescripcion.setBackground(Color.WHITE);
			txtDescripcion.setBorder(BorderFactory.createEmptyBorder());

			panelDescripcion.add(lblTituloDescripcion);
			panelDescripcion.add(Box.createRigidArea(new Dimension(0, 15)));
			panelDescripcion.add(txtDescripcion);

			panelDescripcion.setMaximumSize(new Dimension(700, Integer.MAX_VALUE));
			panelInferior.add(Box.createRigidArea(new Dimension(0, 20)));
			panelInferior.add(panelDescripcion);
		}

		panelInferior.revalidate();
		panelInferior.repaint();
	}

	public JPanel getPanelContenido() {
		return panelContenido;
	}

	public void setPanelContenido(JPanel panelContenido) {
		this.panelContenido = panelContenido;
	}

	public JPanel getPanelSuperior() {
		return panelSuperior;
	}

	public void setPanelSuperior(JPanel panelSuperior) {
		this.panelSuperior = panelSuperior;
	}

	public JPanel getPanelImagen() {
		return panelImagen;
	}

	public void setPanelImagen(JPanel panelImagen) {
		this.panelImagen = panelImagen;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JPanel getPanelInfoBasica() {
		return panelInfoBasica;
	}

	public void setPanelInfoBasica(JPanel panelInfoBasica) {
		this.panelInfoBasica = panelInfoBasica;
	}

	public JLabel getLblTiendaOficial() {
		return lblTiendaOficial;
	}

	public void setLblTiendaOficial(JLabel lblTiendaOficial) {
		this.lblTiendaOficial = lblTiendaOficial;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public void setLblPrecio(JLabel lblPrecio) {
		this.lblPrecio = lblPrecio;
	}

	public JLabel getLblStock() {
		return lblStock;
	}

	public void setLblStock(JLabel lblStock) {
		this.lblStock = lblStock;
	}

	public JLabel getLblCantidad() {
		return lblCantidad;
	}

	public void setLblCantidad(JLabel lblCantidad) {
		this.lblCantidad = lblCantidad;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JButton getBtnComprar() {
		return btnComprar;
	}

	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}

	public JButton getBtnCarrito() {
		return btnCarrito;
	}

	public void setBtnCarrito(JButton btnCarrito) {
		this.btnCarrito = btnCarrito;
	}

	public JPanel getPanelCaracteristicas() {
		return panelCaracteristicas;
	}

	public void setPanelCaracteristicas(JPanel panelCaracteristicas) {
		this.panelCaracteristicas = panelCaracteristicas;
	}

	public JLabel getLblTituloCaracteristicas() {
		return lblTituloCaracteristicas;
	}

	public void setLblTituloCaracteristicas(JLabel lblTituloCaracteristicas) {
		this.lblTituloCaracteristicas = lblTituloCaracteristicas;
	}

	public JPanel getPanelListaCaracteristicas() {
		return panelListaCaracteristicas;
	}

	public void setPanelListaCaracteristicas(JPanel panelListaCaracteristicas) {
		this.panelListaCaracteristicas = panelListaCaracteristicas;
	}

	public JPanel getPanelDescripcion() {
		return panelDescripcion;
	}

	public void setPanelDescripcion(JPanel panelDescripcion) {
		this.panelDescripcion = panelDescripcion;
	}

	public JLabel getLblTituloDescripcion() {
		return lblTituloDescripcion;
	}

	public void setLblTituloDescripcion(JLabel lblTituloDescripcion) {
		this.lblTituloDescripcion = lblTituloDescripcion;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextArea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JPanel getPanelInferior() {
		return panelInferior;
	}

	public void setPanelInferior(JPanel panelInferior) {
		this.panelInferior = panelInferior;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	
}