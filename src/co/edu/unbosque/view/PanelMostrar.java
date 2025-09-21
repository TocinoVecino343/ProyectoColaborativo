package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import co.edu.unbosque.model.*;

public class PanelMostrar extends JPanel {

    // 🎨 Colores estilo Mercado Libre
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_MARCA = new Color(40, 167, 69);
    private final Color COLOR_PRECIO = new Color(220, 53, 69);
    private final Color COLOR_BOTON_EDITAR = new Color(52, 131, 250);
    private final Color COLOR_BOTON_ELIMINAR = new Color(220, 53, 69);

    private Producto producto;
    private JLabel lblImagen, lblDescripcion, lblPrecio;
    private JButton btnEditar, btnEliminar;
    private JPanel panelBotones;

    public PanelMostrar(Producto producto) {
        this.producto = producto;

        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_FONDO);

        // Panel central blanco
        JPanel panelContenido = new JPanel(new BorderLayout(10, 10));
        panelContenido.setBackground(COLOR_PANEL_BLANCO);
        panelContenido.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(panelContenido, BorderLayout.CENTER);

        // Imagen del producto
        lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(JLabel.CENTER);
        panelContenido.add(lblImagen, BorderLayout.NORTH);

        // Panel de info (descripcion + precio)
        JPanel panelInfo = new JPanel(new BorderLayout(5, 5));
        panelInfo.setBackground(COLOR_PANEL_BLANCO);

        // Descripción
        lblDescripcion = new JLabel();
        lblDescripcion.setHorizontalAlignment(JLabel.CENTER);
        lblDescripcion.setForeground(COLOR_TEXTO_PRINCIPAL);
        panelInfo.add(lblDescripcion, BorderLayout.CENTER);

        // Precio independiente
        lblPrecio = new JLabel();
        lblPrecio.setHorizontalAlignment(JLabel.CENTER);
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 16));
        lblPrecio.setForeground(COLOR_PRECIO);
        panelInfo.add(lblPrecio, BorderLayout.SOUTH);

        panelContenido.add(panelInfo, BorderLayout.CENTER);

        // Botones Editar / Eliminar
        panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        panelBotones.setBackground(COLOR_PANEL_BLANCO);

        btnEditar = new JButton("Editar");
        btnEditar.setBackground(COLOR_BOTON_EDITAR);
        btnEditar.setForeground(Color.WHITE);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(COLOR_BOTON_ELIMINAR);
        btnEliminar.setForeground(Color.WHITE);

        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);

        // Mostrar datos del producto
        mostrarProducto(producto);
    }

    private void mostrarProducto(Object obj) {
        if (obj instanceof Producto) {
            Producto p = (Producto) obj;

            // Imagen
         // Imagen
            if (p.getFotoProducto() != null && !p.getFotoProducto().isEmpty()) {
                ImageIcon icon = new ImageIcon(p.getFotoProducto());
                Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
            }


            // Descripción
            lblDescripcion.setText("<html><b style='color:rgb("
                    + COLOR_TEXTO_PRINCIPAL.getRed() + ","
                    + COLOR_TEXTO_PRINCIPAL.getGreen() + ","
                    + COLOR_TEXTO_PRINCIPAL.getBlue() + ")'>"
                    + p.getNombre() + "</b><br>"
                    + "<span style='color:rgb("
                    + COLOR_TEXTO_SECUNDARIO.getRed() + ","
                    + COLOR_TEXTO_SECUNDARIO.getGreen() + ","
                    + COLOR_TEXTO_SECUNDARIO.getBlue() + ")'>"
                    + p.getDescripcion() + "</span></html>");

            // Precio independiente
            lblPrecio.setText("$ " + p.getPrecio());
        }
    }

    // 👉 Métodos para que el CRUD pueda enganchar acciones
    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public Producto getProducto() {
        return producto;
    }
}
