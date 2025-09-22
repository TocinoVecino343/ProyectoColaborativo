package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import co.edu.unbosque.model.*;

public class PanelProductoCreado extends JPanel {
	private JPanel panelProductos;
	private JScrollPane scrollPane;

	public PanelProductoCreado() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// Banner superior
		try {
			ImageIcon bannerIcon = new ImageIcon("assets/bannerSuperior.jpg");
			Image bannerImg = bannerIcon.getImage().getScaledInstance(1300, 100, Image.SCALE_SMOOTH);
			JLabel banner = new JLabel(new ImageIcon(bannerImg));
			banner.setPreferredSize(new Dimension(1300, 100));
			add(banner, BorderLayout.NORTH);
		} catch (Exception e) {
			JPanel bannerFallback = new JPanel();
			bannerFallback.setBackground(new Color(123, 31, 162));
			bannerFallback.setPreferredSize(new Dimension(getWidth(), 100));
			JLabel bannerText = new JLabel("Envíos Gratis a todo el país por compras mayores a $99.900");
			bannerText.setForeground(Color.WHITE);
			bannerText.setFont(new Font("Arial", Font.BOLD, 16));
			bannerFallback.add(bannerText);
			add(bannerFallback, BorderLayout.NORTH);
		}

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		panelProductos.setBackground(Color.WHITE);

		scrollPane = new JScrollPane(panelProductos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		add(scrollPane, BorderLayout.CENTER);
	}

	public void mostrarTodosLosProductos(ArrayList<AlimentoYBebida> productosAlimentos,
			ArrayList<Celular> productosCelulares, ArrayList<Construccion> productosConstruccion,
			ArrayList<DeporteYFitness> productosDeporteYFitness, ArrayList<Electrodomestico> productosElectrodomesticos,
			ArrayList<Juguete> productosJuguetes, ArrayList<Mascota> productosMascotas,
			ArrayList<Farmacia> productosFarmacia, ArrayList<Moda> productosModa,
			ArrayList<Vehiculo> productosVehiculos, int idUsuario) {

		panelProductos.removeAll();

		// Sección de Alimentos y Bebidas
		if (!productosAlimentos.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosAlimentos.size(); i++) {
		        if (productosAlimentos.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Alimentos y Bebidas");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosAlimentos.size(); z++) {
		            if (productosAlimentos.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosAlimentos.get(z).getNombre(),
		                        productosAlimentos.get(z).getPrecio(),
		                        productosAlimentos.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Celulares
		if (!productosCelulares.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosCelulares.size(); i++) {
		        if (productosCelulares.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Celulares");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosCelulares.size(); z++) {
		            if (productosCelulares.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosCelulares.get(z).getNombre(),
		                        productosCelulares.get(z).getPrecio(),
		                        productosCelulares.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Construcción
		if (!productosConstruccion.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosConstruccion.size(); i++) {
		        if (productosConstruccion.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Construcción");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosConstruccion.size(); z++) {
		            if (productosConstruccion.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosConstruccion.get(z).getNombre(),
		                        productosConstruccion.get(z).getPrecio(),
		                        productosConstruccion.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Deporte y Fitness
		if (!productosDeporteYFitness.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosDeporteYFitness.size(); i++) {
		        if (productosDeporteYFitness.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Deporte y Fitness");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosDeporteYFitness.size(); z++) {
		            if (productosDeporteYFitness.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosDeporteYFitness.get(z).getNombre(),
		                        productosDeporteYFitness.get(z).getPrecio(),
		                        productosDeporteYFitness.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Electrodomésticos
		if (!productosElectrodomesticos.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosElectrodomesticos.size(); i++) {
		        if (productosElectrodomesticos.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Electrodomésticos");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosElectrodomesticos.size(); z++) {
		            if (productosElectrodomesticos.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosElectrodomesticos.get(z).getNombre(),
		                        productosElectrodomesticos.get(z).getPrecio(),
		                        productosElectrodomesticos.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Juguetes
		if (!productosJuguetes.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosJuguetes.size(); i++) {
		        if (productosJuguetes.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Juguetes");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosJuguetes.size(); z++) {
		            if (productosJuguetes.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosJuguetes.get(z).getNombre(),
		                        productosJuguetes.get(z).getPrecio(),
		                        productosJuguetes.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Mascotas
		if (!productosMascotas.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosMascotas.size(); i++) {
		        if (productosMascotas.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Mascotas");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosMascotas.size(); z++) {
		            if (productosMascotas.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosMascotas.get(z).getNombre(),
		                        productosMascotas.get(z).getPrecio(),
		                        productosMascotas.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Farmacia
		if (!productosFarmacia.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosFarmacia.size(); i++) {
		        if (productosFarmacia.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Farmacia");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosFarmacia.size(); z++) {
		            if (productosFarmacia.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosFarmacia.get(z).getNombre(),
		                        productosFarmacia.get(z).getPrecio(),
		                        productosFarmacia.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}

		// Sección de Moda
		if (!productosModa.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosModa.size(); i++) {
		        if (productosModa.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Moda");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosModa.size(); z++) {
		            if (productosModa.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosModa.get(z).getNombre(),
		                        productosModa.get(z).getPrecio(),
		                        productosModa.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}
		
		// Sección de Vehículos
		if (!productosVehiculos.isEmpty()) {

		    boolean productoCreado = false;
		    JPanel categoriaPanel = null;
		    JPanel productosPanel = null;

		    for (int i = 0; i < productosVehiculos.size(); i++) {
		        if (productosVehiculos.get(i).getIdAsociado() == idUsuario) {
		            productoCreado = true;
		            break;
		        }
		    }

		    if (productoCreado == true) {
		        categoriaPanel = crearPanelCategoria("Vehículos");
		        productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
		        productosPanel.setBackground(Color.WHITE);

		        for (int z = 0; z < productosVehiculos.size(); z++) {
		            if (productosVehiculos.get(z).getIdAsociado() == idUsuario) {
		                productosPanel.add(crearPanelProducto(productosVehiculos.get(z).getNombre(),
		                        productosVehiculos.get(z).getPrecio(),
		                        productosVehiculos.get(z).getFotoProducto()));
		            }
		        }

		        categoriaPanel.add(productosPanel);
		        panelProductos.add(categoriaPanel);
		    }
		}
		

		panelProductos.revalidate();
		panelProductos.repaint();
	}

	// Método para crear panel de categoría
	private JPanel crearPanelCategoria(String nombreCategoria) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel lblCategoria = new JLabel(nombreCategoria);
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 20));
		lblCategoria.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(lblCategoria);

		// Espacio entre título y productos
		panel.add(Box.createRigidArea(new Dimension(0, 15)));

		return panel;
	}

	// Método unificado para crear panel de producto
	private JPanel crearPanelProducto(String nombre, double precio, String fotoPath) {
		JPanel panelProducto = new JPanel();
		panelProducto.setLayout(new BorderLayout());
		panelProducto.setPreferredSize(new Dimension(250, 300));
		panelProducto.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
		panelProducto.setBackground(Color.WHITE);

		// Panel para la imagen (que será un botón)
		JButton btnImagen = new JButton();
		btnImagen.setLayout(new BorderLayout());
		btnImagen.setBorder(BorderFactory.createEmptyBorder());
		btnImagen.setContentAreaFilled(false);
		btnImagen.setFocusPainted(false);

		// Cargar imagen si existe
		if (fotoPath != null && !fotoPath.isEmpty()) {
			try {
				ImageIcon icon = new ImageIcon(fotoPath);
				Image img = icon.getImage().getScaledInstance(230, 180, Image.SCALE_SMOOTH);
				JLabel lblImagen = new JLabel(new ImageIcon(img));
				lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
				btnImagen.add(lblImagen, BorderLayout.CENTER);
			} catch (Exception ex) {
				JLabel lblImagen = new JLabel("Imagen no disponible");
				lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
				btnImagen.add(lblImagen, BorderLayout.CENTER);
			}
		} else {
			JLabel lblImagen = new JLabel("Imagen no disponible");
			lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
			btnImagen.add(lblImagen, BorderLayout.CENTER);
		}

		// Panel para la información
		JPanel panelInfo = new JPanel(new GridLayout(3, 1, 0, 5));
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblNombre = new JLabel(nombre);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setForeground(Color.BLACK);

		JLabel lblPrecio = new JLabel("$" + precio);
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecio.setForeground(new Color(50, 150, 50)); // Color verde para precio

		JLabel lblMarca = new JLabel("Marca"); // Placeholder para marca
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMarca.setForeground(Color.GRAY);

		panelInfo.add(lblNombre);
		panelInfo.add(lblPrecio);
		panelInfo.add(lblMarca);

		panelProducto.add(btnImagen, BorderLayout.CENTER);
		panelProducto.add(panelInfo, BorderLayout.SOUTH);

		return panelProducto;
	}
}