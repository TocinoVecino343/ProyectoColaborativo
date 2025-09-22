package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;

public class PanelMostrarProducto extends JPanel {
    
    public PanelMostrarProducto() {
        initComponents();
    }
    
    public void actualizarProducto(String nombre, double precio, String fotoPath, String marca, 
                                 int stock, String descripcion, String caracteristicas) {
        // Limpiar el panel antes de agregar nueva información
        removeAll();
        
        // Volver a inicializar con los nuevos datos
        initComponents(nombre, precio, fotoPath, marca, stock, descripcion, caracteristicas);
        
        revalidate();
        repaint();
    }
    
    private void initComponents() {
        // Inicialización sin datos específicos
        initComponents("", 0, "", "", 0, "", "");
    }
    
    private void initComponents(String nombre, double precio, String fotoPath, String marca, 
                             int stock, String descripcion, String caracteristicas) {
        setLayout(new BorderLayout());
        setBackground(new Color(249, 249, 249)); // Fondo gris claro como en la imagen
        
        // Panel principal con scroll
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setBackground(new Color(249, 249, 249));
        panelContenido.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        // Panel superior con layout horizontal mejorado
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(249, 249, 249));
        panelSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 600));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        
        // Panel para la imagen (izquierda) - más pequeña y con bordes redondeados simulados
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(Color.WHITE);
        panelImagen.setPreferredSize(new Dimension(350, 350));
        panelImagen.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Cargar imagen
        if (fotoPath != null && !fotoPath.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(fotoPath);
                Image img = icon.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
                JLabel lblImagen = new JLabel(new ImageIcon(img));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                panelImagen.add(lblImagen, BorderLayout.CENTER);
            } catch (Exception ex) {
                JLabel lblImagen = new JLabel("Imagen no disponible");
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                lblImagen.setVerticalAlignment(SwingConstants.CENTER);
                lblImagen.setFont(new Font("Arial", Font.PLAIN, 14));
                lblImagen.setForeground(Color.GRAY);
                panelImagen.add(lblImagen, BorderLayout.CENTER);
            }
        } else {
            JLabel lblImagen = new JLabel("Imagen no disponible");
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            lblImagen.setVerticalAlignment(SwingConstants.CENTER);
            lblImagen.setFont(new Font("Arial", Font.PLAIN, 14));
            lblImagen.setForeground(Color.GRAY);
            panelImagen.add(lblImagen, BorderLayout.CENTER);
        }
        
        // Panel para la información básica (derecha)
        JPanel panelInfoBasica = new JPanel();
        panelInfoBasica.setLayout(new BoxLayout(panelInfoBasica, BoxLayout.Y_AXIS));
        panelInfoBasica.setBackground(new Color(249, 249, 249));
        panelInfoBasica.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
        
        // Etiqueta de tienda oficial (como en la imagen)
        JLabel lblTiendaOficial = new JLabel("TIENDA OFICIAL");
        lblTiendaOficial.setFont(new Font("Arial", Font.BOLD, 11));
        lblTiendaOficial.setForeground(Color.WHITE);
        lblTiendaOficial.setOpaque(true);
        lblTiendaOficial.setBackground(new Color(66, 66, 66));
        lblTiendaOficial.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        lblTiendaOficial.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Nombre del producto
        JLabel lblNombre = new JLabel("<html>" + nombre + "</html>");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 24));
        lblNombre.setForeground(new Color(51, 51, 51));
        lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblNombre.setMaximumSize(new Dimension(400, 80));
        
        // Precio más destacado
        JLabel lblPrecio = new JLabel("$ " + String.format("%,.0f", precio));
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 36));
        lblPrecio.setForeground(new Color(51, 51, 51));
        lblPrecio.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Estado del stock más visible
        String stockTexto = stock > 0 ? "Stock disponible" : "Agotado";
        JLabel lblStock = new JLabel(stockTexto);
        lblStock.setFont(new Font("Arial", Font.BOLD, 14));
        if (stock <= 0) {
            lblStock.setForeground(Color.RED);
        } else {
            lblStock.setForeground(new Color(0, 150, 0));
        }
        lblStock.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Cantidad disponible
        JLabel lblCantidad = new JLabel("Cantidad: " + (stock > 0 ? stock + " unidad" + (stock > 1 ? "es" : "") : "0"));
        lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCantidad.setForeground(new Color(102, 102, 102));
        lblCantidad.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(new Color(249, 249, 249));
        panelBotones.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Botón de comprar - estilo más moderno
        JButton btnComprar = new JButton("Comprar ahora");
        btnComprar.setPreferredSize(new Dimension(280, 45));
        btnComprar.setMaximumSize(new Dimension(280, 45));
        btnComprar.setBackground(new Color(74, 144, 226)); // Azul similar al de la imagen
        btnComprar.setForeground(Color.WHITE);
        btnComprar.setFont(new Font("Arial", Font.BOLD, 14));
        btnComprar.setFocusPainted(false);
        btnComprar.setBorderPainted(false);
        btnComprar.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnComprar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Botón de agregar al carrito
        JButton btnCarrito = new JButton("Agregar al carrito");
        btnCarrito.setPreferredSize(new Dimension(280, 40));
        btnCarrito.setMaximumSize(new Dimension(280, 40));
        btnCarrito.setBackground(new Color(220, 230, 240));
        btnCarrito.setForeground(new Color(74, 144, 226));
        btnCarrito.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCarrito.setFocusPainted(false);
        btnCarrito.setBorderPainted(false);
        btnCarrito.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnCarrito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efectos hover para los botones
        btnComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComprar.setBackground(new Color(60, 120, 190));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComprar.setBackground(new Color(74, 144, 226));
            }
        });
        
        btnCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCarrito.setBackground(new Color(200, 210, 220));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCarrito.setBackground(new Color(220, 230, 240));
            }
        });
        
        panelBotones.add(btnComprar);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBotones.add(btnCarrito);
        
        // Agregar elementos al panel de información básica
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
        
        panelSuperior.add(panelImagen, BorderLayout.WEST);
        panelSuperior.add(panelInfoBasica, BorderLayout.CENTER);
        
        // Sección de características - con diseño más limpio
        JPanel panelCaracteristicas = new JPanel();
        panelCaracteristicas.setLayout(new BoxLayout(panelCaracteristicas, BoxLayout.Y_AXIS));
        panelCaracteristicas.setBackground(Color.WHITE);
        panelCaracteristicas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        panelCaracteristicas.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelCaracteristicas.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
        JLabel lblTituloCaracteristicas = new JLabel("características");
        lblTituloCaracteristicas.setFont(new Font("Arial", Font.BOLD, 16));
        lblTituloCaracteristicas.setForeground(new Color(51, 51, 51));
        lblTituloCaracteristicas.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Parsear las características y mostrarlas como lista con bullets
        JPanel panelListaCaracteristicas = new JPanel();
        panelListaCaracteristicas.setLayout(new BoxLayout(panelListaCaracteristicas, BoxLayout.Y_AXIS));
        panelListaCaracteristicas.setBackground(Color.WHITE);
        panelListaCaracteristicas.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        if (caracteristicas != null && !caracteristicas.trim().isEmpty()) {
            // Limpiar el HTML y procesar las características
            String caracteristicasLimpias = caracteristicas.replaceAll("<[^>]*>", " ").replaceAll("\\s+", " ").trim();
            String[] lineas = caracteristicasLimpias.split("\\.");
            for (String linea : lineas) {
                if (!linea.trim().isEmpty()) {
                    JLabel lblCaracteristica = new JLabel("• " + linea.trim() + ".");
                    lblCaracteristica.setFont(new Font("Arial", Font.PLAIN, 14));
                    lblCaracteristica.setForeground(new Color(102, 102, 102));
                    lblCaracteristica.setAlignmentX(Component.LEFT_ALIGNMENT);
                    lblCaracteristica.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
                    panelListaCaracteristicas.add(lblCaracteristica);
                }
            }
        }
        
        panelCaracteristicas.add(lblTituloCaracteristicas);
        panelCaracteristicas.add(Box.createRigidArea(new Dimension(0, 15)));
        panelCaracteristicas.add(panelListaCaracteristicas);
        
        // Panel para la descripción (si es necesario)
        JPanel panelDescripcion = new JPanel();
        panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.Y_AXIS));
        panelDescripcion.setBackground(Color.WHITE);
        panelDescripcion.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        panelDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelDescripcion.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            JLabel lblTituloDescripcion = new JLabel("Descripción del producto");
            lblTituloDescripcion.setFont(new Font("Arial", Font.BOLD, 16));
            lblTituloDescripcion.setForeground(new Color(51, 51, 51));
            lblTituloDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            JTextArea txtDescripcion = new JTextArea(descripcion);
            txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
            txtDescripcion.setForeground(new Color(102, 102, 102));
            txtDescripcion.setLineWrap(true);
            txtDescripcion.setWrapStyleWord(true);
            txtDescripcion.setEditable(false);
            txtDescripcion.setBackground(Color.WHITE);
            txtDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);
            txtDescripcion.setBorder(BorderFactory.createEmptyBorder());
            
            panelDescripcion.add(lblTituloDescripcion);
            panelDescripcion.add(Box.createRigidArea(new Dimension(0, 15)));
            panelDescripcion.add(txtDescripcion);
        }
        
        // Crear un panel contenedor para las secciones inferiores, alineadas a la izquierda
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        panelInferior.setBackground(new Color(249, 249, 249));
        panelInferior.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Limitar el ancho de las cajas para que estén más a la izquierda
        panelCaracteristicas.setMaximumSize(new Dimension(700, Integer.MAX_VALUE));
        panelInferior.add(panelCaracteristicas);
        
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            panelDescripcion.setMaximumSize(new Dimension(700, Integer.MAX_VALUE));
            panelInferior.add(Box.createRigidArea(new Dimension(0, 20)));
            panelInferior.add(panelDescripcion);
        }
        
        // Agregar todos los paneles al panel de contenido
        panelContenido.add(panelSuperior);
        panelContenido.add(Box.createRigidArea(new Dimension(0, 30)));
        panelContenido.add(panelInferior);
        
        // Agregar el panel de contenido a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(new Color(249, 249, 249));
        
        // Agregar el JScrollPane al panel principal
        add(scrollPane, BorderLayout.CENTER);
    }
}