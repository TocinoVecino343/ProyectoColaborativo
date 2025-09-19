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
            JOptionPane.showMessageDialog(vf.getVentana(), ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
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
            javax.swing.filechooser.FileNameExtensionFilter filter =
                    new javax.swing.filechooser.FileNameExtensionFilter(
                            "Imágenes (*.jpg, *.jpeg, *.png, *.gif)",
                            "jpg", "jpeg", "png", "gif");
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
                    JOptionPane.showMessageDialog(dialog,
                            "Error al cargar la imagen: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
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
            validarYCrearUsuario(dialog, txtNombre, txtNombreUsuario, txtDocumento,
                    txtEmail, txtTelefono, txtContrasenia, rutaImagenCompleta);
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
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        campo.setPreferredSize(new Dimension(200, 35));

        campo.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                campo.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
                        BorderFactory.createEmptyBorder(4, 7, 4, 7)
                ));
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                campo.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                        BorderFactory.createEmptyBorder(5, 8, 5, 8)
                ));
            }
        });
    }

    private void validarYCrearUsuario(JDialog dialog, JTextField txtNombre, JTextField txtNombreUsuario,
                                      JTextField txtDocumento, JTextField txtEmail, JTextField txtTelefono,
                                      JPasswordField txtContrasenia, String rutaImagen) {
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
            mostrarErrorValidacion(dialog, "La contraseña debe contener al menos:\n- Una letra mayúscula\n- Una letra minúscula\n- Un número", txtContrasenia);
            return;
        }

        try {
            LanzadorExcepciones.validarEmail(email);
            LanzadorExcepciones.verificarEmailNoRegistrado(email);
            int documento = Integer.parseInt(documentoStr);
            int telefono = Integer.parseInt(telefonoStr);
            int id = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;
            String rutaImagenFinal = (rutaImagen != null && !rutaImagen.isEmpty()) ? rutaImagen : "assets/foto_perfil.png";

            Usuario nuevoUsuario = new Usuario(nombre, nombreUsuario, documento, email, telefono, contrasenia, rutaImagenFinal, id);
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
        vf.getVentana().remove(vf.getPaneCrearElectrodomesticos());
        vf.getVentana().remove(vf.getPanelCrearJuguete());
        vf.getVentana().remove(vf.getPanelCrearMascota());
        vf.getVentana().remove(vf.getPanelCrearMedicamento());
        vf.getVentana().remove(vf.getPanelCrearProductoModa());
        vf.getVentana().remove(vf.getPanelCrearVehiculo());
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
        String color = vf.getPanelCrearAlimentoYBebida().getTxtColor().getText().trim();
        boolean esLiquido = "si".equals(vf.getPanelCrearAlimentoYBebida().getCmbEsLiquido().getSelectedItem().toString());
        int cantidadProducto = Integer.parseInt(vf.getPanelCrearAlimentoYBebida().getTxtCantidadDelProducto().getText().trim());
        String tipoEnvase = vf.getPanelCrearAlimentoYBebida().getCmbTipoEnvase().getSelectedItem().toString();
        String unidadEnvase = vf.getPanelCrearAlimentoYBebida().getCmbUnidadEnvase().getSelectedItem().toString();

        AlimentoYBebida nuevoProducto = new AlimentoYBebida(nombre, descripcion, tipoEnvase, precio, marca, vendedor, caracteristicas, stock, cantidadProducto);

        mf.getAlimentoYBebidaDAO().crear(nuevoProducto);

        JOptionPane.showMessageDialog(vf.getVentana(), "¡Alimento y bebida guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        int memoriaInterna = Integer.parseInt((String) vf.getPanelCrearCelular().getCmbMemoriaInterna().getSelectedItem());
        int memoriaRam = Integer.parseInt((String) vf.getPanelCrearCelular().getCmbMemoriaRam().getSelectedItem());
        float largoPantalla = Float.parseFloat(vf.getPanelCrearCelular().getTxtLargoPantalla().getText().trim());
        float anchoPantalla = Float.parseFloat(vf.getPanelCrearCelular().getTxtAnchoPantalla().getText().trim());
        float altoPantalla = Float.parseFloat(vf.getPanelCrearCelular().getTxtAlturaPantalla().getText().trim());
        int camaraFrontal = Integer.parseInt(vf.getPanelCrearCelular().getTxtCamaraFrontal().getText().trim());
        int camaraTrasera = Integer.parseInt(vf.getPanelCrearCelular().getTxtCamaraTrasera().getText().trim());
        boolean poseeNfc = "si".equals(vf.getPanelCrearCelular().getCmbPoseeNFT().getSelectedItem().toString());

        Celular nuevoProducto = new Celular(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), color,
                memoriaInterna, memoriaRam, largoPantalla, anchoPantalla, altoPantalla,
                camaraFrontal, camaraTrasera, poseeNfc
        );

        mf.getCelularDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Celular guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        Construccion nuevoProducto = new Construccion(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), modelo, material, color,
                largo, ancho, altura
        );

        mf.getConstruccionDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de construcción guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        DeporteYFitness nuevoProducto = new DeporteYFitness(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), color, material
        );

        mf.getDeporteYFitnessDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de deporte y fitness guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarPanelDeporteYFitness();
    }

    private void guardarElectrodomestico() {
        String nombre = vf.getPaneCrearElectrodomesticos().getTxtNombre().getText().trim();
        String descripcion = vf.getPaneCrearElectrodomesticos().getTxtDescripcion().getText().trim();
        String tipo = vf.getPaneCrearElectrodomesticos().getTxtTipo().getText().trim();
        float precio = Float.parseFloat(vf.getPaneCrearElectrodomesticos().getTxtPrecio().getText().trim());
        String marca = vf.getPaneCrearElectrodomesticos().getTxtMarca().getText().trim();
        String vendedor = vf.getPaneCrearElectrodomesticos().getTxtVendedor().getText().trim();
        String caracteristicas = vf.getPaneCrearElectrodomesticos().getTxtCaracteristicas().getText().trim();
        int stock = Integer.parseInt(vf.getPaneCrearElectrodomesticos().getTxtStock().getText().trim());
        String modelo = vf.getPaneCrearElectrodomesticos().getTxtModelo().getText().trim();
        int voltaje = Integer.parseInt(vf.getPaneCrearElectrodomesticos().getTxtVoltaje().getText().trim());
        String color = vf.getPaneCrearElectrodomesticos().getTxtColor().getText().trim();

        Electrodomestico nuevoProducto = new Electrodomestico(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), modelo, voltaje, color
        );

        mf.getElectrodomesticoDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Electrodoméstico guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        Juguete nuevoProducto = new Juguete(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), color, material, rangoEdad
        );

        mf.getJugueteDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Juguete guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        Mascota nuevoProducto = new Mascota(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), tipoAnimal, raza, color, formatoVenta
        );

        mf.getMascotaDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto para mascota guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        String formatoMedicamento = vf.getPanelCrearMedicamento().getCmbFormatoMedicamento().getSelectedItem().toString();
        String formatoVenta = vf.getPanelCrearMedicamento().getCmbFormatoDeVenta().getSelectedItem().toString();

        Farmacia nuevoProducto = new Farmacia(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), laboratorio, formatoMedicamento, formatoVenta
        );

        mf.getFarmaciaDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Medicamento guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        Moda nuevoProducto = new Moda(
                nombre, descripcion, tipo, precio, marca, vendedor,
                caracteristicas, stock, usuarioLogueado.getId(), color, talla, material
        );

        mf.getModaDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Producto de moda guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        boolean esFinanciable = "Si".equals(vf.getPanelCrearVehiculo().getCmbEsFinanciable().getSelectedItem().toString());

        Vehiculo nuevoProducto = new Vehiculo(
            nombre, descripcion, tipo, precio, marca, "Vendedor",
            caracteristicas, stock, usuarioLogueado.getId(), esFinanciable, kilometraje, anio
        );

        mf.getVehiculoDAO().crear(nuevoProducto);
        JOptionPane.showMessageDialog(vf.getVentana(), "¡Vehículo guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarPanelVehiculo();
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
        p.getTxtColor().setText("");
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
        p.getCmbPoseeNFT().setSelectedIndex(0);
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
        var p = vf.getPaneCrearElectrodomesticos();
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
            case "Iniciar Sesión":
                iniciarSesion();
                break;

            case "Crear Cuenta":
                mostrarFormularioRegistro();
                break;

            case "Categorías":
                JOptionPane.showMessageDialog(vf.getVentana(), "Funcionalidad de categorías en desarrollo", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Vender":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelSeleccionarCategoria(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Carrito 🛒":
                JOptionPane.showMessageDialog(vf.getVentana(), "Funcionalidad del carrito en desarrollo", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Alimentos y Bebidas":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearAlimentoYBebida(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                System.out.println(mf.getAlimentoYBebidaDAO().mostrarDatos());
                break;

            case "Celulares":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearCelular(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Construcción":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearConstruccion(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Deporte y Fitness":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCDeporteYFitness(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Electrodomésticos":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPaneCrearElectrodomesticos(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Juguetes":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearJuguete(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Mascotas":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearMascota(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Medicamentos":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearMedicamento(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Moda":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearProductoModa(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Vehículos":
                ocultarTodosLosPaneles();
                vf.getVentana().add(vf.getPanelCrearVehiculo(), BorderLayout.CENTER);
                vf.getVentana().revalidate();
                vf.getVentana().repaint();
                break;

            case "Crear AlimentoYBebida":
                guardarAlimentoYBebida();
                break;

            case "Crear Celular":
                guardarCelular();
                break;

            case "Crear Construccion":
                guardarConstruccion();
                break;

            case "Crear DeporteYFitness":
                guardarDeporteYFitness();
                break;

            case "Crear Electrodomestico":
                guardarElectrodomestico();
                break;

            case "Crear Juguete":
                guardarJuguete();
                break;

            case "Crear Mascota":
                guardarMascota();
                break;

            case "Crear Medicamento":
                guardarMedicamento();
                break;

            case "Crear Moda":
                guardarModa();
                break;

            case "Crear Vehiculo":
                guardarVehiculo();
                break;

            default:
                System.out.println("Acción no reconocida: " + comando);
                break;
        }
    }
    
    public void inicializaraActionListener() {
    	vf.getPanelLogin().getBtnIniciarSesion().addActionListener(this);
        vf.getPanelLogin().getBtnCrearCuenta().addActionListener(this);
        vf.getPanelSuperior().getBtnCategoria().addActionListener(this);
        vf.getPanelSuperior().getBtnVender().addActionListener(this);
        vf.getPanelSuperior().getBtnCarro().addActionListener(this);
        vf.getPanelCrearAlimentoYBebida().getBtnCrearAlimentoYBebida().addActionListener(this);
        vf.getPanelCrearCelular().getBtnCrearCelular().addActionListener(this);
        vf.getPanelCrearConstruccion().getBtnCrearConstruccion().addActionListener(this);
        vf.getPanelCDeporteYFitness().getBtnCrearDeporteYFitness().addActionListener(this);
        vf.getPaneCrearElectrodomesticos().getBtnCrearElectrodomestico().addActionListener(this);
        vf.getPanelCrearJuguete().getBtnCrearJuguete().addActionListener(this);
        vf.getPanelCrearMascota().getBtnCrearMascota().addActionListener(this);
        vf.getPanelCrearMedicamento().getBtnCrearFarmacia().addActionListener(this);
        vf.getPanelCrearProductoModa().getBtnCrearProductoModa().addActionListener(this);
        vf.getPanelCrearVehiculo().getBtnCrearVehiculo().addActionListener(this);
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
        vf.getPanelSuperior().getBtnCategoria().setVisible(false);
        vf.getPanelSuperior().getBtnVender().setVisible(false);
        vf.getPanelSuperior().getBtnCarro().setVisible(false);
    }
}
/*
 * public void inicializarOyentes() { // Crear
 * vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().addActionListener(this
 * ); vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().setActionCommand(
 * "boton_crear_vehiculo");
 * 
 * vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().addActionListener
 * (this);
 * vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().setActionCommand(
 * "boton_crear_producto_moda");
 * 
 * vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().
 * setActionCommand("boton_crear_producto_mascota");
 * 
 * vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().setActionCommand
 * ("boton_crear_producto_juguete");
 * 
 * vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().
 * setActionCommand("boton_crear_producto_farmacia");
 * 
 * vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico().
 * setActionCommand("boton_crear_electrodomestico");
 * 
 * vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness()
 * .setActionCommand("boton_crear_producto_deporteyfitness");
 * 
 * vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion()
 * .setActionCommand("boton_crear_producto_construccion");
 * 
 * vf.getMainVentana().getPanelCcel.getBtnCrearCelular().addActionListener(this)
 * ; vf.getMainVentana().getPanelCcel.getBtnCrearCelular().setActionCommand(
 * "boton_crear_celular");
 * 
 * vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida()
 * .setActionCommand("boton_crear_producto_alimentoybebida");
 * 
 * // Actualizar
 * vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().addActionListener(this
 * ); vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().setActionCommand(
 * "boton_actualizar_vehiculo");
 * 
 * vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().addActionListener
 * (this);
 * vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().setActionCommand(
 * "boton_actualizar_producto_moda");
 * 
 * vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().
 * setActionCommand("boton_actualizar_producto_mascota");
 * 
 * vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().setActionCommand
 * ("boton_actualizar_producto_juguete");
 * 
 * vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().
 * setActionCommand("boton_actualizar_producto_farmacia");
 * 
 * vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico()
 * .setActionCommand("boton_actualizar_electrodomestico");
 * 
 * vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness()
 * .setActionCommand("boton_actualizar_producto_deporteyfitness");
 * 
 * vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion()
 * .setActionCommand("boton_actualizar_producto_construccion");
 * 
 * vf.getMainVentana().getPanelCcel.getBtnCrearCelular().addActionListener(this)
 * ; vf.getMainVentana().getPanelCcel.getBtnCrearCelular().setActionCommand(
 * "boton_actualizar_celular");
 * 
 * vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida().
 * addActionListener(this);
 * vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida()
 * .setActionCommand("boton_actualizar_producto_alimentoybebida"); }
 * 
 * @Override public void actionPerformed(ActionEvent e) { String alias =
 * e.getActionCommand();
 * 
 * switch (alias) {
 * 
 * // BOTONES PARA CREAR PRODUCTOS case "boton_crear_vehiculo": { String nombre
 * = String.valueOf(vf.getMainVentana().getPanelCv().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCv().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCv().getCmbTipo().getSelectedItem(
 * )); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCv().getTxtPrecio
 * ())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCv().getCmbMarca().getSelectedItem
 * ()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCv().getTxtCaracteristicas()); int
 * stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getTxtStock(
 * )));
 * 
 * boolean esFinanciable = false; if
 * (vf.getMainVentana().getPanelCv().getCmbEsFinanciable().getSelectedItem().
 * equals("Si")) { esFinanciable = true; } int kilometraje =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().
 * getTxtKilometraje())); int anio =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getCmbAnio()
 * .getSelectedItem()));
 * 
 * Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, esFinanciable, kilometraje, anio);
 * 
 * mf.getVehiculoDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_moda": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpm().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpm().getTxtStock
 * ()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtColor()); String talla
 * = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtTalla()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtMaterial());
 * 
 * Moda temp = new Moda(nombre, descripcion, tipo, precio, marca, vendedor,
 * caracteristicas, stock, color, talla, material);
 * 
 * mf.getModaDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_mascota": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtDescripcion());
 * String tipo = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbTipo().
 * getSelectedItem()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCmas().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCmas().
 * getTxtStock()));
 * 
 * String tipoAnimal =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtTipoAnimal()); String
 * raza = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtRaza());
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtColor()); String
 * formatoDeVenta =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtFormatoDeVenta());
 * 
 * Mascota temp = new Mascota(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, tipoAnimal, raza, color, formatoDeVenta);
 * 
 * mf.getMascotaDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_juguete": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpj().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpj().getTxtStock
 * ()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtColor()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtMaterial()); String
 * rangoDeEdad =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtRangoDeEdad());
 * 
 * Juguete temp = new Juguete(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, color, material, rangoDeEdad);
 * 
 * mf.getJugueteDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_farmacia": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpf().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpf().getTxtStock
 * ()));
 * 
 * String laboratorio =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtLaboratorio()); String
 * formatoMedicamento =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoMedicamento());
 * String formatoDeVenta =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoDeVenta());
 * 
 * Farmacia temp = new Farmacia(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, laboratorio, formatoMedicamento,
 * formatoDeVenta);
 * 
 * mf.getFarmaciaDAO().crear(temp); break; }
 * 
 * case "boton_crear_electrodomestico": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCe().getCmbTipo().getSelectedItem(
 * )); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCe().getTxtPrecio
 * ())); String Marca =
 * String.valueOf(vf.getMainVentana().getPanelCe().getCmbMarca().getSelectedItem
 * ()); String Vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtCaracteristicas()); int
 * stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxtStock(
 * )));
 * 
 * String modelo =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtModelo()); int voltaje
 * =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxVoltaje
 * ())); String color =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtColor());
 * 
 * Electrodomestico temp = new Electrodomestico(nombre, descripcion, tipo,
 * precio, Marca, Vendedor, caracteristicas, stock, modelo, voltaje, color);
 * 
 * mf.getElectrodomesticoDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_deporteyfitness": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpd().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpd().getTxtStock
 * ()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtColor()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtMaterial());
 * 
 * DeporteYFitness temp = new DeporteYFitness(nombre, descripcion, tipo, precio,
 * marca, vendedor, caracteristicas, stock, color, material);
 * 
 * mf.getDeporteYFitnessDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_construccion": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtDescripcion());
 * String tipo = String.valueOf(vf.getMainVentana().getPanelCcon().getCmbTipo().
 * getSelectedItem()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtStock()));
 * 
 * String modelo =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtModelo()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtMaterial()); String
 * color = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtColor());
 * float largo =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtLargo())); float ancho =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtAncho())); float altura =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtAltura()));
 * 
 * Construccion temp = new Construccion(nombre, descripcion, tipo, precio,
 * marca, vendedor, caracteristicas, stock, modelo, material, color, largo,
 * ancho, altura);
 * 
 * mf.getConstruccionDAO().crear(temp); break; }
 * 
 * case "boton_crear_celular": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtDescripcion());
 * String tipo = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbTipo().
 * getSelectedItem()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtStock()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtColor()); int
 * memoriaInterna =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtMemoriaInterna)); int memoriaRam =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtMemoriaRam())); float largoPantalla =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtLargoPantalla())); float anchoPantalla =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtAnchoPantalla())); float altoPantalla =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtAltoPantalla())); int camaraFrontal =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtCamaraInterna())); int camaraTrasera =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtCamaraTrasera())); boolean poseeNfc = false; if
 * (vf.getMainVentana().getPanelCcel().getCmbPoseeNfc().getSelectedItem().equals
 * ("Si")) { poseeNfc = true; }
 * 
 * Celular temp = new Celular(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, color, memoriaInterna, memoriaRam,
 * largoPantalla, anchoPantalla, altoPantalla, camaraFrontal, camaraTrasera,
 * poseeNfc);
 * 
 * mf.getCelularDAO().crear(temp); break; }
 * 
 * case "boton_crear_producto_alimentoybebida": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCab().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCab().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtStock
 * ()));
 * 
 * boolean esLiquido = false; if
 * (vf.getMainVentana().getPanelCab().getCmbPoseeNfc().getSelectedItem().equals(
 * "Si")) { esLiquido = true; } int cantidadProducto =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().
 * getTxtCantidadProducto())); String tipoEnvase =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtTipoEnvase()); int
 * unidadEnvase =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().
 * getTxtunidadEnvase()));
 * 
 * AlimentoYBebida temp = new AlimentoYBebida(nombre, descripcion, tipo, precio,
 * marca, vendedor, caracteristicas, stock, esLiquido, cantidadProducto,
 * tipoEnvase, unidadEnvase);
 * 
 * mf.getAlimentoYBebidaDAO().crear(temp); break; }
 * 
 * // BOTONES PARA ACTUALIZAR PRODUCTOS case "boton_actualizar_vehiculo": {
 * String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCv().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCv().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCv().getCmbTipo().getSelectedItem(
 * )); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCv().getTxtPrecio
 * ())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCv().getCmbMarca().getSelectedItem
 * ()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCv().getTxtCaracteristicas()); int
 * stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getTxtStock(
 * )));
 * 
 * boolean esFinanciable = false; if
 * (vf.getMainVentana().getPanelCv().getCmbEsFinanciable().getSelectedItem().
 * equals("Si")) { esFinanciable = true; } int kilometraje =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().
 * getTxtKilometraje())); int anio =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getCmbAnio()
 * .getSelectedItem()));
 * 
 * Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, esFinanciable, kilometraje, anio);
 * 
 * mf.getVehiculoDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_moda": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpm().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpm().getTxtStock
 * ()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtColor()); String talla
 * = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtTalla()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCpm().getTxtMaterial());
 * 
 * Moda temp = new Moda(nombre, descripcion, tipo, precio, marca, vendedor,
 * caracteristicas, stock, color, talla, material);
 * 
 * mf.getModaDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_mascota": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtDescripcion());
 * String tipo = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbTipo().
 * getSelectedItem()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCmas().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCmas().
 * getTxtStock()));
 * 
 * String tipoAnimal =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtTipoAnimal()); String
 * raza = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtRaza());
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtColor()); String
 * formatoDeVenta =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getTxtFormatoDeVenta());
 * 
 * Mascota temp = new Mascota(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, tipoAnimal, raza, color, formatoDeVenta);
 * 
 * mf.getMascotaDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_juguete": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpj().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpj().getTxtStock
 * ()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtColor()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtMaterial()); String
 * rangoDeEdad =
 * String.valueOf(vf.getMainVentana().getPanelCpj().getTxtRangoDeEdad());
 * 
 * Juguete temp = new Juguete(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, color, material, rangoDeEdad);
 * 
 * mf.getJugueteDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_farmacia": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpf().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpf().getTxtStock
 * ()));
 * 
 * String laboratorio =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtLaboratorio()); String
 * formatoMedicamento =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoMedicamento());
 * String formatoDeVenta =
 * String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoDeVenta());
 * 
 * Farmacia temp = new Farmacia(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, laboratorio, formatoMedicamento,
 * formatoDeVenta);
 * 
 * mf.getFarmaciaDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_electrodomestico": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCe().getCmbTipo().getSelectedItem(
 * )); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCe().getTxtPrecio
 * ())); String Marca =
 * String.valueOf(vf.getMainVentana().getPanelCe().getCmbMarca().getSelectedItem
 * ()); String Vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtCaracteristicas()); int
 * stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxtStock(
 * )));
 * 
 * String modelo =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtModelo()); int voltaje
 * =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxVoltaje
 * ())); String color =
 * String.valueOf(vf.getMainVentana().getPanelCe().getTxtColor());
 * 
 * Electrodomestico temp = new Electrodomestico(nombre, descripcion, tipo,
 * precio, Marca, Vendedor, caracteristicas, stock, modelo, voltaje, color);
 * 
 * mf.getElectrodomesticoDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_deporteyfitness": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpd().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpd().getTxtStock
 * ()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtColor()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCpd().getTxtMaterial());
 * 
 * DeporteYFitness temp = new DeporteYFitness(nombre, descripcion, tipo, precio,
 * marca, vendedor, caracteristicas, stock, color, material);
 * 
 * mf.getDeporteYFitnessDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_construccion": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtDescripcion());
 * String tipo = String.valueOf(vf.getMainVentana().getPanelCcon().getCmbTipo().
 * getSelectedItem()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtStock()));
 * 
 * String modelo =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtModelo()); String
 * material =
 * String.valueOf(vf.getMainVentana().getPanelCcon().getTxtMaterial()); String
 * color = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtColor());
 * float largo =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtLargo())); float ancho =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtAncho())); float altura =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().
 * getTxtAltura()));
 * 
 * Construccion temp = new Construccion(nombre, descripcion, tipo, precio,
 * marca, vendedor, caracteristicas, stock, modelo, material, color, largo,
 * ancho, altura);
 * 
 * mf.getConstruccionDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_celular": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtDescripcion());
 * String tipo = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbTipo().
 * getSelectedItem()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtStock()));
 * 
 * String color =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getTxtColor()); int
 * memoriaInterna =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtMemoriaInterna)); int memoriaRam =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtMemoriaRam())); float largoPantalla =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtLargoPantalla())); float anchoPantalla =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtAnchoPantalla())); float altoPantalla =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtAltoPantalla())); int camaraFrontal =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtCamaraInterna())); int camaraTrasera =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().
 * getTxtCamaraTrasera())); boolean poseeNfc = false; if
 * (vf.getMainVentana().getPanelCcel().getCmbPoseeNfc().getSelectedItem().equals
 * ("Si")) { poseeNfc = true; }
 * 
 * Celular temp = new Celular(nombre, descripcion, tipo, precio, marca,
 * vendedor, caracteristicas, stock, color, memoriaInterna, memoriaRam,
 * largoPantalla, anchoPantalla, altoPantalla, camaraFrontal, camaraTrasera,
 * poseeNfc);
 * 
 * mf.getCelularDAO().crear(temp); break; }
 * 
 * case "boton_actualizar_producto_alimentoybebida": { String nombre =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtNombre()); String
 * descripcion =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtDescripcion()); String
 * tipo =
 * String.valueOf(vf.getMainVentana().getPanelCab().getCmbTipo().getSelectedItem
 * ()); float precio =
 * Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCab().
 * getTxtPrecio())); String marca =
 * String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().
 * getSelectedItem()); String vendedor =
 * "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; String
 * caracteristicas =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtCaracteristicas());
 * int stock =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtStock
 * ()));
 * 
 * boolean esLiquido = false; if
 * (vf.getMainVentana().getPanelCab().getCmbPoseeNfc().getSelectedItem().equals(
 * "Si")) { esLiquido = true; } int cantidadProducto =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().
 * getTxtCantidadProducto())); String tipoEnvase =
 * String.valueOf(vf.getMainVentana().getPanelCab().getTxtTipoEnvase()); int
 * unidadEnvase =
 * Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().
 * getTxtunidadEnvase()));
 * 
 * AlimentoYBebida temp = new AlimentoYBebida(nombre, descripcion, tipo, precio,
 * marca, vendedor, caracteristicas, stock, esLiquido, cantidadProducto,
 * tipoEnvase, unidadEnvase);
 * 
 * mf.getAlimentoYBebidaDAO().crear(temp); break; } } } }
 */