package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelPerfil extends JPanel {
    private JLabel lblImagenPerfil, lblNombre, lblEmail, lblTitulo;
    private JButton btnUsuario, btnMetodoDePago, btnCerrarSesion;
    private JPanel panelSuperior, panelCentral, panelInferior, panelInfoUsuario, panelBotones;
    
    // Colores estilo MercadoLibre
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
    private final Color COLOR_BOTON_PRIMARIO = new Color(52, 131, 250);
    private final Color COLOR_BOTON_SECUNDARIO = new Color(46, 204, 113);
    private final Color COLOR_BOTON_PELIGRO = new Color(231, 76, 60);

    public PanelPerfil() {
        this.setVisible(true);
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1280, 800);
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        // Panel principal con scroll
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_FONDO);
        
        // Panel superior - Título
        panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setBackground(COLOR_FONDO);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        
        lblTitulo = new JLabel("Mi Perfil");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(COLOR_TEXTO_PRINCIPAL);
        panelSuperior.add(lblTitulo);
        
        // Panel central - Información del usuario
        panelCentral = new JPanel(new BorderLayout(40, 0));
        panelCentral.setBackground(COLOR_FONDO);
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));
        
        // Panel izquierdo - Imagen de perfil
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(COLOR_PANEL_BLANCO);
        panelImagen.setPreferredSize(new Dimension(400, 400));
        panelImagen.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        
        // Contenedor de la imagen
        JPanel imageContainer = new JPanel(new BorderLayout());
        imageContainer.setBackground(new Color(248, 248, 248));
        imageContainer.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));
        imageContainer.setPreferredSize(new Dimension(300, 300));
        
        // Label para mostrar imagen o placeholder
        lblImagenPerfil = new JLabel();
        lblImagenPerfil.setHorizontalAlignment(JLabel.CENTER);
        lblImagenPerfil.setVerticalAlignment(JLabel.CENTER);
        lblImagenPerfil.setOpaque(true);
        lblImagenPerfil.setBackground(new Color(248, 248, 248));
        
        // Texto placeholder
        lblImagenPerfil.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>" +
                                "<div style='font-size: 60px; margin-bottom: 10px;'>👤</div>" +
                                "<div style='font-size: 16px; font-weight: bold;'>IMAGEN DE PERFIL</div>" +
                                "</html>");
        
        imageContainer.add(lblImagenPerfil, BorderLayout.CENTER);
        panelImagen.add(imageContainer, BorderLayout.CENTER);
        
        // Panel derecho - Información del usuario
        panelInfoUsuario = new JPanel();
        panelInfoUsuario.setLayout(new BoxLayout(panelInfoUsuario, BoxLayout.Y_AXIS));
        panelInfoUsuario.setBackground(COLOR_PANEL_BLANCO);
        panelInfoUsuario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        
        // Título de la sección
        JLabel tituloInfo = new JLabel("Información de la cuenta");
        tituloInfo.setFont(new Font("Arial", Font.BOLD, 18));
        tituloInfo.setForeground(COLOR_TEXTO_PRINCIPAL);
        tituloInfo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panelInfoUsuario.add(tituloInfo);
        panelInfoUsuario.add(Box.createVerticalStrut(30));
        
        // Nombre del usuario
        JPanel panelNombre = new JPanel(new BorderLayout());
        panelNombre.setBackground(COLOR_PANEL_BLANCO);
        
        JLabel lblTituloNombre = new JLabel("Nombre:");
        lblTituloNombre.setFont(new Font("Arial", Font.BOLD, 14));
        lblTituloNombre.setForeground(COLOR_TEXTO_SECUNDARIO);
        
        lblNombre = new JLabel();
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNombre.setForeground(COLOR_TEXTO_PRINCIPAL);
        
        panelNombre.add(lblTituloNombre, BorderLayout.NORTH);
        panelNombre.add(lblNombre, BorderLayout.CENTER);
        panelNombre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        panelInfoUsuario.add(panelNombre);
        
        // Email del usuario
        JPanel panelEmail = new JPanel(new BorderLayout());
        panelEmail.setBackground(COLOR_PANEL_BLANCO);
        
        JLabel lblTituloEmail = new JLabel("Email:");
        lblTituloEmail.setFont(new Font("Arial", Font.BOLD, 14));
        lblTituloEmail.setForeground(COLOR_TEXTO_SECUNDARIO);
        
        lblEmail = new JLabel();
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEmail.setForeground(COLOR_TEXTO_PRINCIPAL);
        
        panelEmail.add(lblTituloEmail, BorderLayout.NORTH);
        panelEmail.add(lblEmail, BorderLayout.CENTER);
        
        panelInfoUsuario.add(panelEmail);
        panelInfoUsuario.add(Box.createVerticalStrut(30));
        
        // Añadir paneles al panel central
        panelCentral.add(panelImagen, BorderLayout.WEST);
        panelCentral.add(panelInfoUsuario, BorderLayout.CENTER);
        
        // Panel inferior - Botones
        panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBackground(COLOR_FONDO);
        panelInferior.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));
        
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        panelBotones.setBackground(COLOR_FONDO);
        
        // Botón de datos de usuario
        btnUsuario = new JButton("Datos de tu cuenta");
        btnUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        btnUsuario.setBackground(COLOR_BOTON_PRIMARIO);
        btnUsuario.setForeground(Color.WHITE);
        btnUsuario.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnUsuario.setFocusPainted(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.setPreferredSize(new Dimension(250, 50));
        
        btnUsuario.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnUsuario.setBackground(new Color(45, 115, 220));
            }
            public void mouseExited(MouseEvent evt) {
                btnUsuario.setBackground(COLOR_BOTON_PRIMARIO);
            }
        });
        
        // Botón de método de pago
        btnMetodoDePago = new JButton("Método de pago");
        btnMetodoDePago.setFont(new Font("Arial", Font.BOLD, 16));
        btnMetodoDePago.setBackground(COLOR_BOTON_SECUNDARIO);
        btnMetodoDePago.setForeground(Color.WHITE);
        btnMetodoDePago.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnMetodoDePago.setFocusPainted(false);
        btnMetodoDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMetodoDePago.setPreferredSize(new Dimension(250, 50));
        
        btnMetodoDePago.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnMetodoDePago.setBackground(new Color(38, 184, 100));
            }
            public void mouseExited(MouseEvent evt) {
                btnMetodoDePago.setBackground(COLOR_BOTON_SECUNDARIO);
            }
        });
        
        // Botón de cerrar sesión
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 16));
        btnCerrarSesion.setBackground(COLOR_BOTON_PELIGRO);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setPreferredSize(new Dimension(250, 50));
        
        btnCerrarSesion.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnCerrarSesion.setBackground(new Color(192, 57, 43));
            }
            public void mouseExited(MouseEvent evt) {
                btnCerrarSesion.setBackground(COLOR_BOTON_PELIGRO);
            }
        });
        
        panelBotones.add(btnUsuario);
        panelBotones.add(btnMetodoDePago);
        panelBotones.add(btnCerrarSesion);
        
        panelInferior.add(panelBotones, BorderLayout.CENTER);
        
        // Añadir todos los paneles al panel principal
        mainPanel.add(panelSuperior, BorderLayout.NORTH);
        mainPanel.add(panelCentral, BorderLayout.CENTER);
        mainPanel.add(panelInferior, BorderLayout.SOUTH);
        
        // Crear scroll
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void cargarImagenPerfil(String rutaImagen) {
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            try {
                File imagenFile = new File(rutaImagen);
                if (imagenFile.exists()) {
                    ImageIcon originalIcon = new ImageIcon(rutaImagen);
                    Image img = originalIcon.getImage();
                    Image scaledImg = img.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImg);
                    
                    lblImagenPerfil.setText("");
                    lblImagenPerfil.setIcon(scaledIcon);
                }
            } catch (Exception e) {
                // Si hay error al cargar la imagen, mantener el placeholder
                System.err.println("Error al cargar la imagen de perfil: " + e.getMessage());
            }
        }
    }
    
    

    // Getters y Setters
    public JLabel getLblImagenPerfil() {
        return lblImagenPerfil;
    }

    public void setLblImagenPerfil(JLabel lblImagenPerfil) {
        this.lblImagenPerfil = lblImagenPerfil;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    public JButton getBtnUsuario() {
        return btnUsuario;
    }

    public void setBtnUsuario(JButton btnUsuario) {
        this.btnUsuario = btnUsuario;
    }

    public JButton getBtnMetodoDePago() {
        return btnMetodoDePago;
    }

    public void setBtnMetodoDePago(JButton btnMetodoDePago) {
        this.btnMetodoDePago = btnMetodoDePago;
    }
    
    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setBtnCerrarSesion(JButton btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }
}
