package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.*;

public class PanelProductoCreado extends JPanel {
    private JPanel panelProductos;
    private JScrollPane scrollPane;
    private List<ActionListener> listeners = new ArrayList<>();

    public PanelProductoCreado() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

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

    // Método para agregar listeners
    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

    // Método para remover listeners
    public void removeActionListener(ActionListener listener) {
        listeners.remove(listener);
    }

    // Método para disparar eventos
    private void fireActionPerformed(ActionEvent e) {
        for (ActionListener listener : listeners) {
            listener.actionPerformed(e);
        }
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Alimentos y Bebidas");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosAlimentos.size(); z++) {
                    if (productosAlimentos.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosAlimentos.get(z).getNombre(),
                            productosAlimentos.get(z).getPrecio(),
                            productosAlimentos.get(z).getFotoProducto(),
                            productosAlimentos.get(z),
                            "AlimentoYBebida"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Celulares");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosCelulares.size(); z++) {
                    if (productosCelulares.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosCelulares.get(z).getNombre(),
                            productosCelulares.get(z).getPrecio(),
                            productosCelulares.get(z).getFotoProducto(),
                            productosCelulares.get(z),
                            "Celular"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Construcción");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosConstruccion.size(); z++) {
                    if (productosConstruccion.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosConstruccion.get(z).getNombre(),
                            productosConstruccion.get(z).getPrecio(),
                            productosConstruccion.get(z).getFotoProducto(),
                            productosConstruccion.get(z),
                            "Construccion"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Deporte y Fitness");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosDeporteYFitness.size(); z++) {
                    if (productosDeporteYFitness.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosDeporteYFitness.get(z).getNombre(),
                            productosDeporteYFitness.get(z).getPrecio(),
                            productosDeporteYFitness.get(z).getFotoProducto(),
                            productosDeporteYFitness.get(z),
                            "DeporteYFitness"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Electrodomésticos");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosElectrodomesticos.size(); z++) {
                    if (productosElectrodomesticos.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosElectrodomesticos.get(z).getNombre(),
                            productosElectrodomesticos.get(z).getPrecio(),
                            productosElectrodomesticos.get(z).getFotoProducto(),
                            productosElectrodomesticos.get(z),
                            "Electrodomestico"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Juguetes");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosJuguetes.size(); z++) {
                    if (productosJuguetes.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosJuguetes.get(z).getNombre(),
                            productosJuguetes.get(z).getPrecio(),
                            productosJuguetes.get(z).getFotoProducto(),
                            productosJuguetes.get(z),
                            "Juguete"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Mascotas");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosMascotas.size(); z++) {
                    if (productosMascotas.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosMascotas.get(z).getNombre(),
                            productosMascotas.get(z).getPrecio(),
                            productosMascotas.get(z).getFotoProducto(),
                            productosMascotas.get(z),
                            "Mascota"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Farmacia");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosFarmacia.size(); z++) {
                    if (productosFarmacia.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosFarmacia.get(z).getNombre(),
                            productosFarmacia.get(z).getPrecio(),
                            productosFarmacia.get(z).getFotoProducto(),
                            productosFarmacia.get(z),
                            "Farmacia"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Moda");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosModa.size(); z++) {
                    if (productosModa.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosModa.get(z).getNombre(),
                            productosModa.get(z).getPrecio(),
                            productosModa.get(z).getFotoProducto(),
                            productosModa.get(z),
                            "Moda"
                        ));
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

            if (productoCreado) {
                categoriaPanel = crearPanelCategoria("Vehículos");
                productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
                productosPanel.setBackground(Color.WHITE);

                for (int z = 0; z < productosVehiculos.size(); z++) {
                    if (productosVehiculos.get(z).getIdAsociado() == idUsuario) {
                        productosPanel.add(crearBotonProducto(
                            productosVehiculos.get(z).getNombre(),
                            productosVehiculos.get(z).getPrecio(),
                            productosVehiculos.get(z).getFotoProducto(),
                            productosVehiculos.get(z),
                            "Vehiculo"
                        ));
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

    // Método para crear botón de producto
    private JButton crearBotonProducto(String nombre, double precio, String fotoPath, Object producto, String tipoProducto) {
        JButton botonProducto = new JButton();
        botonProducto.setLayout(new BorderLayout());
        botonProducto.setPreferredSize(new Dimension(250, 300));
        botonProducto.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        botonProducto.setBackground(Color.WHITE);
        botonProducto.setActionCommand("actualizar");
        
        // Almacenar información del producto
        botonProducto.putClientProperty("producto", producto);
        botonProducto.putClientProperty("tipoProducto", tipoProducto);
        
        // Panel para la imagen
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(Color.WHITE);
        
        // Cargar imagen si existe
        if (fotoPath != null && !fotoPath.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(fotoPath);
                Image img = icon.getImage().getScaledInstance(230, 180, Image.SCALE_SMOOTH);
                JLabel lblImagen = new JLabel(new ImageIcon(img));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                panelImagen.add(lblImagen, BorderLayout.CENTER);
            } catch (Exception ex) {
                JLabel lblImagen = new JLabel("Imagen no disponible");
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                panelImagen.add(lblImagen, BorderLayout.CENTER);
            }
        } else {
            JLabel lblImagen = new JLabel("Imagen no disponible");
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            panelImagen.add(lblImagen, BorderLayout.CENTER);
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

        botonProducto.add(panelImagen, BorderLayout.CENTER);
        botonProducto.add(panelInfo, BorderLayout.SOUTH);
        
        // Agregar ActionListener al botón
        botonProducto.addActionListener(e -> {
            // Crear un nuevo ActionEvent con el botón como fuente
            ActionEvent event = new ActionEvent(botonProducto, ActionEvent.ACTION_PERFORMED, "actualizar");
            fireActionPerformed(event);
        });

        return botonProducto;
    }
}