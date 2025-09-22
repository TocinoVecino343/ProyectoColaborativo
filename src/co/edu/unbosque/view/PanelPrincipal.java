package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import co.edu.unbosque.model.*;

public class PanelPrincipal extends JPanel {
    private JPanel panelProductos;
    private JScrollPane scrollPane;
    private ViewFacade vf;
    
    // Arrays para guardar los productos
    private ArrayList<AlimentoYBebida> productosAlimentos;
    private ArrayList<Celular> productosCelulares;
    private ArrayList<Construccion> productosConstruccion;
    private ArrayList<DeporteYFitness> productosDeporteYFitness;
    private ArrayList<Electrodomestico> productosElectrodomesticos;
    private ArrayList<Juguete> productosJuguetes;
    private ArrayList<Mascota> productosMascotas;
    private ArrayList<Farmacia> productosFarmacia;
    private ArrayList<Moda> productosModa;
    private ArrayList<Vehiculo> productosVehiculos;

    public PanelPrincipal(ViewFacade vf) {
        this.vf = vf;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Banner superior
        try {
            ImageIcon bannerIcon = new ImageIcon("assets/bannerSuperior.jpg");
            Image bannerImg = bannerIcon.getImage().getScaledInstance(1280, 100, Image.SCALE_SMOOTH);
            JLabel banner = new JLabel(new ImageIcon(bannerImg));
            banner.setPreferredSize(new Dimension(1280, 100));
            add(banner, BorderLayout.NORTH);
        } catch (Exception e) {
            // Si no se puede cargar la imagen, usar un color de fondo similar
            JPanel bannerFallback = new JPanel();
            bannerFallback.setBackground(new Color(123, 31, 162)); // Color morado similar
            bannerFallback.setPreferredSize(new Dimension(getWidth(), 100));
            JLabel bannerText = new JLabel("Envíos Gratis a todo el país por compras mayores a $99.900");
            bannerText.setForeground(Color.WHITE);
            bannerText.setFont(new Font("Arial", Font.BOLD, 16));
            bannerFallback.add(bannerText);
            add(bannerFallback, BorderLayout.NORTH);
        }

        // Panel para los productos con scroll
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

        // Guardar los arrays
        this.productosAlimentos = productosAlimentos;
        this.productosCelulares = productosCelulares;
        this.productosConstruccion = productosConstruccion;
        this.productosDeporteYFitness = productosDeporteYFitness;
        this.productosElectrodomesticos = productosElectrodomesticos;
        this.productosJuguetes = productosJuguetes;
        this.productosMascotas = productosMascotas;
        this.productosFarmacia = productosFarmacia;
        this.productosModa = productosModa;
        this.productosVehiculos = productosVehiculos;

        panelProductos.removeAll();

        // Sección de Alimentos y Bebidas
        if (!productosAlimentos.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Alimentos y Bebidas");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosAlimentos.size(); i++) {
                AlimentoYBebida producto = productosAlimentos.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "AlimentoYBebida",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Celulares
        if (!productosCelulares.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Celulares");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosCelulares.size(); i++) {
                Celular producto = productosCelulares.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Celular",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Construcción
        if (!productosConstruccion.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Construcción");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosConstruccion.size(); i++) {
                Construccion producto = productosConstruccion.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Construccion",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Deporte y Fitness
        if (!productosDeporteYFitness.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Deporte y Fitness");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosDeporteYFitness.size(); i++) {
                DeporteYFitness producto = productosDeporteYFitness.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "DeporteYFitness",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Electrodomésticos
        if (!productosElectrodomesticos.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Electrodomésticos");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosElectrodomesticos.size(); i++) {
                Electrodomestico producto = productosElectrodomesticos.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Electrodomestico",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Juguetes
        if (!productosJuguetes.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Juguetes");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosJuguetes.size(); i++) {
                Juguete producto = productosJuguetes.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Juguete",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Mascotas
        if (!productosMascotas.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Mascotas");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosMascotas.size(); i++) {
                Mascota producto = productosMascotas.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Mascota",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Farmacia
        if (!productosFarmacia.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Farmacia");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosFarmacia.size(); i++) {
                Farmacia producto = productosFarmacia.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Farmacia",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Moda
        if (!productosModa.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Moda");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosModa.size(); i++) {
                Moda producto = productosModa.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Moda",
                    i
                ));
            }
            
            categoriaPanel.add(productosPanel);
            panelProductos.add(categoriaPanel);
        }

        // Sección de Vehículos
        if (!productosVehiculos.isEmpty()) {
            JPanel categoriaPanel = crearPanelCategoria("Vehículos");
            JPanel productosPanel = new JPanel(new GridLayout(0, 4, 15, 15));
            productosPanel.setBackground(Color.WHITE);
            
            for (int i = 0; i < productosVehiculos.size(); i++) {
                Vehiculo producto = productosVehiculos.get(i);
                productosPanel.add(crearPanelProducto(
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getFotoProducto(), 
                    "Vehiculo",
                    i
                ));
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

    // Método unificado para crear panel de producto con ActionListener
    private JPanel crearPanelProducto(String nombre, double precio, String fotoPath, String tipoProducto, int indice) {
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
        btnImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Agregar ActionListener para abrir el detalle del producto
        btnImagen.addActionListener(e -> {
            // Llamar al método para mostrar el detalle del producto
            mostrarDetalleProducto(tipoProducto, indice);
        });
        
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

    private void mostrarDetalleProducto(String tipoProducto, int indice) {
        // Obtener los datos del producto según el tipo y el índice
        String nombre = "";
        double precio = 0;
        String fotoPath = "";
        String marca = "";
        int stock = 0;
        String descripcion = "";
        String caracteristicas = "";
        
        switch (tipoProducto) {
            case "Celular":
                if (productosCelulares != null && indice >= 0 && indice < productosCelulares.size()) {
                    Celular celular = productosCelulares.get(indice);
                    nombre = celular.getNombre();
                    precio = celular.getPrecio();
                    fotoPath = celular.getFotoProducto();
                    marca = celular.getMarca();
                    stock = celular.getStock();
                    descripcion = celular.getDescripcion() != null ? celular.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Memoria Interna:</b> " + celular.getMemoriaInterna() + " GB" +
                                     "<br><b>Memoria RAM:</b> " + celular.getMemoriaRam() + " GB" +
                                     "<br><b>Color:</b> " + celular.getColor() +
                                     "<br><b>Cámara Frontal:</b> " + celular.getCamaraFrontal() + " MP" +"\n" +
                                     "<br><b>Cámara Trasera:</b> " + celular.getCamaraTrasera() + " MP" +"\n" +
                                     "<br><b>Tiene NFC:</b> " + (celular.isPoseeNfc() ? "Sí" : "No") + "</html>";
                }
                break;
            case "AlimentoYBebida":
                if (productosAlimentos != null && indice >= 0 && indice < productosAlimentos.size()) {
                    AlimentoYBebida alimento = productosAlimentos.get(indice);
                    nombre = alimento.getNombre();
                    precio = alimento.getPrecio();
                    fotoPath = alimento.getFotoProducto();
                    marca = alimento.getMarca();
                    stock = alimento.getStock();
                    descripcion = alimento.getDescripcion() != null ? alimento.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Es Líquido:</b> " + (alimento.isEsLiquido() ? "Sí" : "No") +
                                     "<br><b>Cantidad:</b> " + alimento.getCantidadProducto() +"\n" +
                                     "<br><b>Tipo de Envase:</b> " + alimento.getTipoEnvase() +"\n" +
                                     "<br><b>Unidad de Envase:</b> " + alimento.getUnidadEnvase() + "</html>";
                }
                break;
            case "Construccion":
                if (productosConstruccion != null && indice >= 0 && indice < productosConstruccion.size()) {
                    Construccion construccion = productosConstruccion.get(indice);
                    nombre = construccion.getNombre();
                    precio = construccion.getPrecio();
                    fotoPath = construccion.getFotoProducto();
                    marca = construccion.getMarca();
                    stock = construccion.getStock();
                    descripcion = construccion.getDescripcion() != null ? construccion.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Modelo:</b> " + construccion.getModelo() +"\n" +
                                     "<br><b>Material:</b> " + construccion.getMaterial() +"\n" +
                                     "<br><b>Color:</b> " + construccion.getColor() +"\n" +
                                     "<br><b>Dimensiones:</b> " + construccion.getLargo() + " x " + construccion.getAncho() + " x " + construccion.getAltura() + "</html>";
                }
                break;
            case "DeporteYFitness":
                if (productosDeporteYFitness != null && indice >= 0 && indice < productosDeporteYFitness.size()) {
                    DeporteYFitness deporte = productosDeporteYFitness.get(indice);
                    nombre = deporte.getNombre();
                    precio = deporte.getPrecio();
                    fotoPath = deporte.getFotoProducto();
                    marca = deporte.getMarca();
                    stock = deporte.getStock();
                    descripcion = deporte.getDescripcion() != null ? deporte.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Color:</b> " + deporte.getColor() +"\n" +
                                     "<br><b>Material:</b> " + deporte.getMaterial() + "</html>";
                }
                break;
            case "Electrodomestico":
                if (productosElectrodomesticos != null && indice >= 0 && indice < productosElectrodomesticos.size()) {
                    Electrodomestico electrodomestico = productosElectrodomesticos.get(indice);
                    nombre = electrodomestico.getNombre();
                    precio = electrodomestico.getPrecio();
                    fotoPath = electrodomestico.getFotoProducto();
                    marca = electrodomestico.getMarca();
                    stock = electrodomestico.getStock();
                    descripcion = electrodomestico.getDescripcion() != null ? electrodomestico.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Modelo:</b> " + electrodomestico.getModelo() +"\n" +
                                     "<br><b>Voltaje:</b> " + electrodomestico.getVoltaje() + "V" +"\n" +
                                     "<br><b>Color:</b> " + electrodomestico.getColor() + "</html>";
                }
                break;
            case "Juguete":
                if (productosJuguetes != null && indice >= 0 && indice < productosJuguetes.size()) {
                    Juguete juguete = productosJuguetes.get(indice);
                    nombre = juguete.getNombre();
                    precio = juguete.getPrecio();
                    fotoPath = juguete.getFotoProducto();
                    marca = juguete.getMarca();
                    stock = juguete.getStock();
                    descripcion = juguete.getDescripcion() != null ? juguete.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Color:</b> " + juguete.getColor() +"\n" +
                                     "<br><b>Material:</b> " + juguete.getMaterial() +"\n" +
                                     "<br><b>Rango de Edad:</b> " + juguete.getRangoDeEdad() + "</html>";
                }
                break;
            case "Mascota":
                if (productosMascotas != null && indice >= 0 && indice < productosMascotas.size()) {
                    Mascota mascota = productosMascotas.get(indice);
                    nombre = mascota.getNombre();
                    precio = mascota.getPrecio();
                    fotoPath = mascota.getFotoProducto();
                    marca = mascota.getMarca();
                    stock = mascota.getStock();
                    descripcion = mascota.getDescripcion() != null ? mascota.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Tipo de Animal:</b> " + mascota.getTipoAnimal() +"\n" +
                                     "<br><b>Raza:</b> " + mascota.getRaza() +"\n" +
                                     "<br><b>Color:</b> " + mascota.getColor() +"\n" +
                                     "<br><b>Formato de Venta:</b> " + mascota.getFormatoDeVenta() + "</html>";
                }
                break;
            case "Farmacia":
                if (productosFarmacia != null && indice >= 0 && indice < productosFarmacia.size()) {
                    Farmacia farmacia = productosFarmacia.get(indice);
                    nombre = farmacia.getNombre();
                    precio = farmacia.getPrecio();
                    fotoPath = farmacia.getFotoProducto();
                    marca = farmacia.getMarca();
                    stock = farmacia.getStock();
                    descripcion = farmacia.getDescripcion() != null ? farmacia.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Laboratorio:</b> " + farmacia.getLaboratorio() + "\n" +
                                     "<br><b>Formato de Medicamento:</b> " + farmacia.getFormatoMedicamento() + "\n" +
                                     "<br><b>Formato de Venta:</b> " + farmacia.getFormatoDeVenta() + "</html>";
                }
                break;
            case "Moda":
                if (productosModa != null && indice >= 0 && indice < productosModa.size()) {
                    Moda moda = productosModa.get(indice);
                    nombre = moda.getNombre();
                    precio = moda.getPrecio();
                    fotoPath = moda.getFotoProducto();
                    marca = moda.getMarca();
                    stock = moda.getStock();
                    descripcion = moda.getDescripcion() != null ? moda.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Color:</b> " + moda.getColor() +"\n" +
                                     "<br><b>Talla:</b> " + moda.getTalla() +"\n" +
                                     "<br><b>Material:</b> " + moda.getMaterial() + "</html>";
                }
                break;
            case "Vehiculo":
                if (productosVehiculos != null && indice >= 0 && indice < productosVehiculos.size()) {
                    Vehiculo vehiculo = productosVehiculos.get(indice);
                    nombre = vehiculo.getNombre();
                    precio = vehiculo.getPrecio();
                    fotoPath = vehiculo.getFotoProducto();
                    marca = vehiculo.getMarca();
                    stock = vehiculo.getStock();
                    descripcion = vehiculo.getDescripcion() != null ? vehiculo.getDescripcion() : "Descripción no disponible";
                    caracteristicas = "<html><b>Es Financiable:</b> " + (vehiculo.isEsFinanciable() ? "Sí" : "No") +
                                     "<br><b>Kilometraje:</b> " + vehiculo.getKilometraje() + " km" +"\n" +
                                     "<br><b>Año:</b> " + vehiculo.getAnio() + "</html>";
                }
                break;
        }
        
        // Actualizar el PanelMostrarProducto con los datos obtenidos
        vf.getPanelMostrarProducto().actualizarProducto(nombre, precio, fotoPath, marca, stock, descripcion, caracteristicas);
        
        // En lugar de manipular toda la ventana, usar CardLayout o simplemente ocultar/mostrar paneles
        JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);
        Container contentPane = ventana.getContentPane();
        
        // Crear un panel con botón volver integrado en el panel de detalles
        JPanel panelConVolver = new JPanel(new BorderLayout());
        
        // Panel superior con botón volver
        JPanel panelVolver = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelVolver.setBackground(Color.WHITE);
        JButton btnVolver = new JButton("← Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.setForeground(new Color(123, 31, 162));
        btnVolver.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolver.addActionListener(e -> {
            // Simplemente ocultar el panel de detalles y mostrar este panel
            panelConVolver.setVisible(false);
            this.setVisible(true);
        });
        
        panelVolver.add(btnVolver);
        panelConVolver.add(panelVolver, BorderLayout.NORTH);
        panelConVolver.add(vf.getPanelMostrarProducto(), BorderLayout.CENTER);
        
        // Ocultar este panel y agregar el panel de detalles
        this.setVisible(false);
        contentPane.add(panelConVolver, BorderLayout.CENTER);
        
        ventana.revalidate();
        ventana.repaint();
    }
}