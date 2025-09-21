package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import co.edu.unbosque.model.Moda;

public class PanelMostrar extends JPanel {
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_MARCA = new Color(40, 167, 69);
    private final Color COLOR_PRECIO = new Color(220, 53, 69);
    private final Color COLOR_BOTON_EDITAR = new Color(52, 131, 250);
    private final Color COLOR_BOTON_ELIMINAR = new Color(220, 53, 69);

    private Moda producto;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JPanel panelBotones;

    // ==================== CONSTRUCTOR ====================

    public PanelMostrar(Moda producto) {
        this.producto = producto;
        inicializarComponente();
    }

    // ==================== GETTERS ====================

    public Moda getProducto() { 
        return producto; 
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    // ==================== MÉTODOS PARA CONTROLAR BOTONES ====================

    public void mostrarBotonEditar() {
        btnEditar.setVisible(true);
        btnEliminar.setVisible(false);
        panelBotones.setVisible(true);
        revalidate();
        repaint();
    }

    public void mostrarBotonEliminar() {
        btnEliminar.setVisible(true);
        btnEditar.setVisible(false);
        panelBotones.setVisible(true);
        revalidate();
        repaint();
    }

    public void mostrarAmboBotones() {
        btnEditar.setVisible(true);
        btnEliminar.setVisible(true);
        panelBotones.setVisible(true);
        revalidate();
        repaint();
    }

    public void ocultarBotones() {
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        panelBotones.setVisible(false);
        revalidate();
        repaint();
    }

    public void setActionListenerEditar(ActionListener listener) {
        for (ActionListener al : btnEditar.getActionListeners()) {
            btnEditar.removeActionListener(al);
        }
        btnEditar.addActionListener(listener);
    }

    public void setActionListenerEliminar(ActionListener listener) {
        for (ActionListener al : btnEliminar.getActionListeners()) {
            btnEliminar.removeActionListener(al);
        }
        btnEliminar.addActionListener(listener);
    }

    // ==================== INICIALIZACIÓN DEL PANEL ====================

    private void inicializarComponente() {
        setLayout(new BorderLayout());
        setBackground(COLOR_FONDO);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_FONDO);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);

        JPanel productoPanel = crearProductoPanel();
        mainPanel.add(productoPanel, BorderLayout.CENTER);

        panelBotones = crearPanelBotones();
        mainPanel.add(panelBotones, BorderLayout.SOUTH);
    }

    private JPanel crearProductoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(COLOR_PANEL_BLANCO);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        panel.add(crearPanelImagen());
        panel.add(Box.createVerticalStrut(15));
        panel.add(crearPanelInformacion());

        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        btnEditar = crearBotonEditar();
        btnEliminar = crearBotonEliminar();

        panel.add(btnEditar);
        panel.add(btnEliminar);

        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        panel.setVisible(false);

        return panel;
    }

    private JButton crearBotonEditar() {
        JButton boton = new JButton(" Editar Producto");
        boton.setBackground(COLOR_BOTON_EDITAR);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (boton.isVisible()) {
                    boton.setBackground(COLOR_BOTON_EDITAR.darker());
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (boton.isVisible()) {
                    boton.setBackground(COLOR_BOTON_EDITAR);
                }
            }
        });

        return boton;
    }

    private JButton crearBotonEliminar() {
        JButton boton = new JButton("Eliminar Producto");
        boton.setBackground(COLOR_BOTON_ELIMINAR);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (boton.isVisible()) {
                    boton.setBackground(COLOR_BOTON_ELIMINAR.darker());
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (boton.isVisible()) {
                    boton.setBackground(COLOR_BOTON_ELIMINAR);
                }
            }
        });

        return boton;
    }

    private JPanel crearPanelImagen() {
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(COLOR_PANEL_BLANCO);
        panelImagen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));

        ImageIcon icon = cargarImagen(producto.getFotoProducto());
        if (icon == null) {
            icon = crearImagenPlaceholder();
        }

        JLabel imgLabel = new JLabel(icon);
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelImagen.add(imgLabel, BorderLayout.CENTER);

        return panelImagen;
    }

    private JPanel crearPanelInformacion() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(COLOR_PANEL_BLANCO);

        JLabel nombreLabel = new JLabel(producto.getNombre());
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nombreLabel.setForeground(COLOR_TEXTO_PRINCIPAL);
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(nombreLabel);

        infoPanel.add(Box.createVerticalStrut(10));

        JLabel precioLabel = new JLabel("$" + String.format("%.2f", producto.getPrecio()));
        precioLabel.setFont(new Font("Arial", Font.BOLD, 24));
        precioLabel.setForeground(COLOR_PRECIO);
        precioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(precioLabel);

        infoPanel.add(Box.createVerticalStrut(15));

        if (producto.getDescripcion() != null && !producto.getDescripcion().trim().isEmpty()) {
            JTextArea descripcionArea = new JTextArea(producto.getDescripcion());
            descripcionArea.setFont(new Font("Arial", Font.PLAIN, 12));
            descripcionArea.setForeground(COLOR_TEXTO_SECUNDARIO);
            descripcionArea.setBackground(COLOR_PANEL_BLANCO);
            descripcionArea.setEditable(false);
            descripcionArea.setLineWrap(true);
            descripcionArea.setWrapStyleWord(true);
            descripcionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            infoPanel.add(descripcionArea);
            infoPanel.add(Box.createVerticalStrut(15));
        }

        JPanel detallesPrincipales = new JPanel(new GridLayout(2, 2, 15, 8));
        detallesPrincipales.setBackground(COLOR_PANEL_BLANCO);
        detallesPrincipales.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            "Información General",
            0, 0,
            new Font("Arial", Font.BOLD, 12),
            COLOR_TEXTO_PRINCIPAL
        ));

        detallesPrincipales.add(crearLabelDetalle("Marca:"));
        JLabel marcaLabel = crearLabelValor(producto.getMarca());
        marcaLabel.setForeground(COLOR_MARCA);
        marcaLabel.setFont(new Font("Arial", Font.BOLD, 12));
        detallesPrincipales.add(marcaLabel);

        detallesPrincipales.add(crearLabelDetalle("Tipo:"));
        detallesPrincipales.add(crearLabelValor(producto.getTipo()));

        detallesPrincipales.add(crearLabelDetalle("Vendedor:"));
        detallesPrincipales.add(crearLabelValor(producto.getVendedor()));

        detallesPrincipales.add(crearLabelDetalle("Stock:"));
        JLabel stockLabel = crearLabelValor(String.valueOf(producto.getStock()) + " unidades");
        if (producto.getStock() <= 5) {
            stockLabel.setForeground(COLOR_PRECIO);
            stockLabel.setFont(new Font("Arial", Font.BOLD, 12));
        }
        detallesPrincipales.add(stockLabel);

        infoPanel.add(detallesPrincipales);
        infoPanel.add(Box.createVerticalStrut(15));

        JPanel detallesModa = new JPanel(new GridLayout(3, 2, 15, 8));
        detallesModa.setBackground(COLOR_PANEL_BLANCO);
        detallesModa.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            "Detalles de Moda",
            0, 0,
            new Font("Arial", Font.BOLD, 12),
            COLOR_TEXTO_PRINCIPAL
        ));

        if (producto.getColor() != null && !producto.getColor().trim().isEmpty()) {
            detallesModa.add(crearLabelDetalle("Color:"));
            detallesModa.add(crearLabelValor(producto.getColor()));
        }

        if (producto.getTalla() != null && !producto.getTalla().trim().isEmpty()) {
            detallesModa.add(crearLabelDetalle("Talla:"));
            detallesModa.add(crearLabelValor(producto.getTalla()));
        }

        if (producto.getMaterial() != null && !producto.getMaterial().trim().isEmpty()) {
            detallesModa.add(crearLabelDetalle("Material:"));
            detallesModa.add(crearLabelValor(producto.getMaterial()));
        }

        if (detallesModa.getComponentCount() > 0) {
            infoPanel.add(detallesModa);
            infoPanel.add(Box.createVerticalStrut(15));
        }

        if (producto.getCaracteristicas() != null && !producto.getCaracteristicas().trim().isEmpty()) {
            JPanel caracPanel = new JPanel();
            caracPanel.setLayout(new BoxLayout(caracPanel, BoxLayout.Y_AXIS));
            caracPanel.setBackground(COLOR_PANEL_BLANCO);
            caracPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Características",
                0, 0,
                new Font("Arial", Font.BOLD, 12),
                COLOR_TEXTO_PRINCIPAL
            ));

            JTextArea caracArea = new JTextArea(producto.getCaracteristicas());
            caracArea.setFont(new Font("Arial", Font.PLAIN, 11));
            caracArea.setForeground(COLOR_TEXTO_SECUNDARIO);
            caracArea.setBackground(new Color(248, 249, 250));
            caracArea.setEditable(false);
            caracArea.setLineWrap(true);
            caracArea.setWrapStyleWord(true);
            caracArea.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            caracPanel.add(caracArea);
            infoPanel.add(caracPanel);
        }

        return infoPanel;
    }

    private JLabel crearLabelDetalle(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(COLOR_TEXTO_PRINCIPAL);
        return label;
    }

    private JLabel crearLabelValor(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(COLOR_TEXTO_SECUNDARIO);
        return label;
    }

    private ImageIcon cargarImagen(String url) {
        if (url == null || url.trim().isEmpty()) {
            return null;
        }
        try {
            URL imageUrl = new URL(url.trim());
            BufferedImage image = ImageIO.read(imageUrl);
            if (image != null) {
                return new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
            }
        } catch (IOException e) {
            System.err.println(" Error al cargar imagen: " + url + " | " + e.getMessage());
        }
        return null;
    }

    private ImageIcon crearImagenPlaceholder() {
        BufferedImage placeholder = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = placeholder.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(new Color(240, 240, 240));
        g2d.fillRect(0, 0, 200, 200);
        
        g2d.setColor(new Color(180, 180, 180));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(10, 10, 180, 180);
        
        g2d.setColor(COLOR_TEXTO_SECUNDARIO);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics fm = g2d.getFontMetrics();
        String texto = "Sin imagen";
        int x = (200 - fm.stringWidth(texto)) / 2;
        int y = (200 - fm.getHeight()) / 2 + fm.getAscent();
        g2d.drawString(texto, x, y);
        
        g2d.dispose();
        return new ImageIcon(placeholder);
    }

    public void actualizarProducto(Moda nuevoProducto) {
        this.producto = nuevoProducto;
        removeAll();
        inicializarComponente();
        revalidate();
        repaint();
    }
}