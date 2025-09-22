package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import co.edu.unbosque.model.*;

public class PanelPrincipal extends JPanel {
    private JPanel panelProductos;
    private JScrollPane scrollPane;

    public PanelPrincipal() {
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

    public void mostrarTodosLosProductos(
            ArrayList<AlimentoYBebida> productosAlimentos,
            ArrayList<Celular> productosCelulares,
            ArrayList<Construccion> productosConstruccion,
            ArrayList<DeporteYFitness> productosDeporteYFitness,
            ArrayList<Electrodomestico> productosElectrodomesticos,
            ArrayList<Juguete> productosJuguetes,
            ArrayList<Mascota> productosMascotas,
            ArrayList<Farmacia> productosFarmacia,
            ArrayList<Moda> productosModa,
            ArrayList<Vehiculo> productosVehiculos) {

        panelProductos.removeAll();

        if (!productosAlimentos.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Alimentos y Bebidas");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (AlimentoYBebida producto : productosAlimentos) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        if (!productosCelulares.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Celulares");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Celular producto : productosCelulares) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        if (!productosConstruccion.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Construcción");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Construccion producto : productosConstruccion) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        if (!productosDeporteYFitness.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Deporte y Fitness");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (DeporteYFitness producto : productosDeporteYFitness) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        if (!productosElectrodomesticos.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Electrodomésticos");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Electrodomestico producto : productosElectrodomesticos) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Juguetes
        if (!productosJuguetes.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Juguetes");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Juguete producto : productosJuguetes) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Mascotas
        if (!productosMascotas.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Mascotas");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Mascota producto : productosMascotas) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Farmacia
        if (!productosFarmacia.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Farmacia");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Farmacia producto : productosFarmacia) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Moda
        if (!productosModa.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Moda");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Moda producto : productosModa) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Vehículos
        if (!productosVehiculos.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Vehículos");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (Vehiculo producto : productosVehiculos) {
                productosPanel.add(crearPanelProducto(producto.getNombre(), producto.getPrecio(), producto.getFotoProducto()));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
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