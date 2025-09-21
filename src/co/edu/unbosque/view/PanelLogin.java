package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelLogin extends JPanel {
    private JTextField txtEmail;
    private JPasswordField txtContrasenia;
    private JButton btnIniciarSesion;
    private JButton btnCrearCuenta;

    
    // Colores estilo MercadoLibre
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
    private final Color COLOR_BOTON_PRIMARIO = new Color(52, 131, 250);
    private final Color COLOR_BOTON_SECUNDARIO = new Color(46, 204, 113);

    public PanelLogin() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(COLOR_FONDO);
        setPreferredSize(new Dimension(1280, 500));
        setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));

        // Panel principal con contenedor centrado
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_FONDO);
        
        // Panel contenedor centrado
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(COLOR_PANEL_BLANCO);
        centerPanel.setPreferredSize(new Dimension(500, 350));
        centerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));
        
        // Título
        JLabel titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(COLOR_TEXTO_PRINCIPAL);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        centerPanel.add(titulo, BorderLayout.NORTH);

        // Panel del formulario
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 15, 30));
        formPanel.setBackground(COLOR_PANEL_BLANCO);

        // Campos del formulario
        JLabel lblEmail = new JLabel("Correo Electrónico:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEmail.setForeground(COLOR_TEXTO_PRINCIPAL);
        formPanel.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        txtEmail.setBackground(COLOR_PANEL_BLANCO);
        txtEmail.setForeground(COLOR_TEXTO_PRINCIPAL);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        aplicarEfectoFocusTextField(txtEmail);
        formPanel.add(txtEmail);

        JLabel lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));
        lblContrasenia.setForeground(COLOR_TEXTO_PRINCIPAL);
        formPanel.add(lblContrasenia);
        
        txtContrasenia = new JPasswordField();
        txtContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));
        txtContrasenia.setBackground(COLOR_PANEL_BLANCO);
        txtContrasenia.setForeground(COLOR_TEXTO_PRINCIPAL);
        txtContrasenia.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        aplicarEfectoFocusTextField(txtContrasenia);
        formPanel.add(txtContrasenia);

        centerPanel.add(formPanel, BorderLayout.CENTER);

        // Panel de botones
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciarSesion.setBackground(COLOR_BOTON_PRIMARIO);
        btnIniciarSesion.setForeground(Color.WHITE);
        btnIniciarSesion.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnIniciarSesion.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnIniciarSesion.setBackground(new Color(45, 115, 220));
            }
            public void mouseExited(MouseEvent evt) {
                btnIniciarSesion.setBackground(COLOR_BOTON_PRIMARIO);
            }
        });

        btnCrearCuenta = new JButton("Crear Cuenta");
        btnCrearCuenta.setFont(new Font("Arial", Font.BOLD, 14));
        btnCrearCuenta.setBackground(COLOR_BOTON_SECUNDARIO);
        btnCrearCuenta.setForeground(Color.WHITE);
        btnCrearCuenta.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnCrearCuenta.setFocusPainted(false);
        btnCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCrearCuenta.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnCrearCuenta.setBackground(new Color(38, 184, 100));
            }
            public void mouseExited(MouseEvent evt) {
                btnCrearCuenta.setBackground(COLOR_BOTON_SECUNDARIO);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(COLOR_PANEL_BLANCO);
        buttonPanel.add(btnIniciarSesion);
        buttonPanel.add(btnCrearCuenta);

        centerPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Añadir el panel centrado al mainPanel
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
    }
     
    
    private void aplicarEfectoFocusTextField(JTextField textField) {
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON_PRIMARIO, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
    
    private void aplicarEfectoFocusComboBox(JComboBox<String> comboBox) {
        comboBox.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                comboBox.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON_PRIMARIO, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(FocusEvent evt) {
                comboBox.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }

    // Getters y setters
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public JButton getBtnCrearCuenta() {
        return btnCrearCuenta;
    }
    
    // Método para limpiar el formulario
    public void limpiarFormulario() {
        txtEmail.setText("");
        txtContrasenia.setText("");
    }
}