package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.controller.Controlador;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.util.exception.EmailInvalidoException;
import co.edu.unbosque.util.exception.EmailYaRegistradoException;
import co.edu.unbosque.util.exception.LanzadorExcepciones;

public class PanelLogin extends JPanel {

    private JTextField txtEmail, txtNombre, txtNombreUsuario, txtTelefono, txtRutaImagen;
    private JPasswordField txtContrasenia;
    private JTextField txtDocumento;
    private JButton btnIniciarSesion, btnCrearCuenta;
    private JComboBox<String> cmbIdioma;
    private JFrame frame;
    private Controlador controlador;

    private String[] labelsEsp = {
        "Nombre:", "Nombre de Usuario:", "Documento:", "Correo Electrónico:",
        "Teléfono:", "Contraseña:", "Ruta Imagen:", "Iniciar Sesión", "Crear Cuenta"
    };
    private String[] labelsEng = {
        "Name:", "Username:", "ID:", "Email:", "Phone:", "Password:", "Profile Image:", "Sign In", "Create Account"
    };
    private String[] labelsPor = {
        "Nome:", "Nome de Usuário:", "ID:", "Email:", "Telefone:", "Senha:", "Imagem de Perfil:", "Entrar", "Criar Conta"
    };
    private String[] labelsLat = {
        "Nomen:", "NomenUsus:", "Codex:", "Email:", "Telephonum:", "Clavis:", "ImagoProfilis:", "Inire", "Creare Contum"
    };

    private String[][] traducciones = {labelsEsp, labelsEng, labelsPor, labelsLat};
    private int idiomaActual = 0;

    public PanelLogin(JFrame frame, Controlador controlador) {
        this.frame = frame;
        this.controlador = controlador;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600, 700));

        JLabel titulo = new JLabel("Bienvenido", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(40, 0, 30, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelIdioma = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        cmbIdioma = new JComboBox<>(new String[]{"Español", "English", "Português", "Latin"});
        cmbIdioma.setSelectedIndex(0);
        cmbIdioma.addActionListener(e -> cambiarIdioma());
        panelIdioma.add(cmbIdioma);
        add(panelIdioma, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 15, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        formPanel.setBackground(Color.WHITE);

        formPanel.add(new JLabel(traducciones[idiomaActual][3]));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);

        formPanel.add(new JLabel(traducciones[idiomaActual][5]));
        txtContrasenia = new JPasswordField();
        formPanel.add(txtContrasenia);

        btnIniciarSesion = new JButton(traducciones[idiomaActual][7]);
        btnCrearCuenta = new JButton(traducciones[idiomaActual][8]);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnIniciarSesion);
        buttonPanel.add(btnCrearCuenta);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        btnIniciarSesion.addActionListener(e -> iniciarSesion());
        btnCrearCuenta.addActionListener(e -> mostrarFormularioRegistro());
    }

    private void cambiarIdioma() {
        idiomaActual = cmbIdioma.getSelectedIndex();
        actualizarTextos();
    }

    private void actualizarTextos() {
        ((JLabel) ((Container) ((JPanel) getComponent(1)).getLayout()).getComponent(0)).setText(traducciones[idiomaActual][3]);
        ((JLabel) ((Container) ((JPanel) getComponent(1)).getLayout()).getComponent(2)).setText(traducciones[idiomaActual][5]);
        btnIniciarSesion.setText(traducciones[idiomaActual][7]);
        btnCrearCuenta.setText(traducciones[idiomaActual][8]);
    }

    private void iniciarSesion() {
        String email = txtEmail.getText();
        String contrasenia = new String(txtContrasenia.getPassword());

        try {
            LanzadorExcepciones.validarEmail(email);

            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.login(email, contrasenia);

            if (usuario != null) {
                JOptionPane.showMessageDialog(this,
                    "¡Bienvenido, " + usuario.getNombre() + "!",
                    "Inicio de sesión exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

                frame.dispose();
                controlador.onLoginSuccess();
            } else {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (EmailInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarFormularioRegistro() {
        JDialog dialog = new JDialog(frame, "Crear Cuenta - Datos Completos", true);
        dialog.setSize(550, 650);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BorderLayout());

        JLabel title = new JLabel("Registra tu cuenta completa", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        dialog.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(9, 2, 15, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        form.add(new JLabel(traducciones[idiomaActual][0] + ":"));
        txtNombre = new JTextField();
        form.add(txtNombre);

        form.add(new JLabel(traducciones[idiomaActual][1] + ":"));
        txtNombreUsuario = new JTextField();
        form.add(txtNombreUsuario);

        form.add(new JLabel(traducciones[idiomaActual][2] + ":"));
        txtDocumento = new JTextField();
        form.add(txtDocumento);

        form.add(new JLabel(traducciones[idiomaActual][3] + ":"));
        txtEmail = new JTextField();
        form.add(txtEmail);

        form.add(new JLabel(traducciones[idiomaActual][4] + ":"));
        txtTelefono = new JTextField();
        form.add(txtTelefono);

        form.add(new JLabel(traducciones[idiomaActual][5] + ":"));
        txtContrasenia = new JPasswordField();
        form.add(txtContrasenia);

        form.add(new JLabel(traducciones[idiomaActual][6] + " (opcional):"));
        txtRutaImagen = new JTextField();
        txtRutaImagen.setText("assets/foto_perfil.png");
        form.add(txtRutaImagen);

        JButton btnRegistrar = new JButton("Crear Cuenta");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color(41, 128, 185));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(e -> validarYCrearUsuario(dialog));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnRegistrar);

        dialog.add(form, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    private void validarYCrearUsuario(JDialog dialog) {
        String nombre = txtNombre.getText().trim();
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String documentoStr = txtDocumento.getText().trim();
        String email = txtEmail.getText().trim();
        String telefonoStr = txtTelefono.getText().trim();
        String contrasenia = new String(txtContrasenia.getPassword());
        String rutaImagen = txtRutaImagen.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (documentoStr.isEmpty() || !documentoStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El documento debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo electrónico es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (telefonoStr.isEmpty () || !telefonoStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (contrasenia.length() < 8) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            LanzadorExcepciones.validarEmail(email);
            LanzadorExcepciones.verificarEmailNoRegistrado(email);

            int documento = Integer.parseInt(documentoStr);
            int telefono = Integer.parseInt(telefonoStr);
            int id = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;

            Usuario nuevoUsuario = new Usuario(
                nombre,
                nombreUsuario,
                documento,
                email,
                telefono,
                contrasenia,
                rutaImagen,
                id
            );

            UsuarioDAO dao = new UsuarioDAO();
            dao.crear(nuevoUsuario);

            JOptionPane.showMessageDialog(null,
                "¡Cuenta creada exitosamente!\n" +
                "ID: " + id + "\n" +
                "Bienvenido, " + nombre + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            dialog.dispose();
            txtEmail.setText("");
            txtContrasenia.setText("");

        } catch (EmailInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (EmailYaRegistradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}