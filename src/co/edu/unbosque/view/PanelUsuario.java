package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelUsuario extends JPanel {
    private JLabel lblTitulo, lblNombre, lblEmail, lblImagen, lblNombreUsuario, lblDocumento,
            lblTelefono, lblContrasenia, lblImagenPreview;

    private JTextField txtNombre, txtEmail, txtNombreUsuario, txtDocumento, txtTelefono;
    private JPasswordField txtContrasenia;

    private JButton btnActualizarUsuario, btnEliminarUsuario, btnSeleccionarImagen;
    private File imagenSeleccionada;

    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
    private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
    private final Color COLOR_BOTON_PRIMARIO = new Color(52, 131, 250);
    private final Color COLOR_BOTON_SECUNDARIO = new Color(46, 204, 113);
    private final Color COLOR_BOTON_PELIGRO = new Color(231, 76, 60);

    public PanelUsuario() {
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
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setBackground(COLOR_FONDO);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        
        lblTitulo = new JLabel("Datos de la cuenta");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(COLOR_TEXTO_PRINCIPAL);
        panelSuperior.add(lblTitulo);
        
        // Panel central - Información del usuario
        JPanel panelCentral = new JPanel(new BorderLayout(40, 0));
        panelCentral.setBackground(COLOR_FONDO);
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));
        
        // Panel izquierdo - Imagen de perfil
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(COLOR_PANEL_BLANCO);
        panelImagen.setPreferredSize(new Dimension(400, 500));
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
        lblImagenPreview = new JLabel();
        lblImagenPreview.setHorizontalAlignment(JLabel.CENTER);
        lblImagenPreview.setVerticalAlignment(JLabel.CENTER);
        lblImagenPreview.setOpaque(true);
        lblImagenPreview.setBackground(new Color(248, 248, 248));
        
        // Texto placeholder
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>" +
                                "<div style='font-size: 60px; margin-bottom: 10px;'>👤</div>" +
                                "<div style='font-size: 16px; font-weight: bold;'>IMAGEN DE PERFIL</div>" +
                                "</html>");
        
        imageContainer.add(lblImagenPreview, BorderLayout.CENTER);
        panelImagen.add(imageContainer, BorderLayout.CENTER);
        
        // Botón seleccionar imagen
        btnSeleccionarImagen = new JButton("Seleccionar imagen");
        btnSeleccionarImagen.setFont(new Font("Arial", Font.BOLD, 14));
        btnSeleccionarImagen.setBackground(COLOR_PANEL_BLANCO);
        btnSeleccionarImagen.setForeground(COLOR_BOTON_PRIMARIO);
        btnSeleccionarImagen.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BOTON_PRIMARIO, 2),
            BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));
        btnSeleccionarImagen.setFocusPainted(false);
        btnSeleccionarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Efecto hover del botón imagen
        btnSeleccionarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSeleccionarImagen.setBackground(new Color(240, 247, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSeleccionarImagen.setBackground(COLOR_PANEL_BLANCO);
            }
        });
        
        // ActionListener para seleccionar imagen
        btnSeleccionarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        
        // Panel para el botón
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(COLOR_PANEL_BLANCO);
        buttonPanel.add(btnSeleccionarImagen);
        
        panelImagen.add(Box.createVerticalStrut(20), BorderLayout.SOUTH);
        panelImagen.add(buttonPanel, BorderLayout.PAGE_END);
        
        // Panel derecho - Formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBackground(COLOR_PANEL_BLANCO);
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        
        // Campos del formulario
        lblNombre = crearLabel("Nombre completo");
        txtNombre = crearTextField();
        
        lblEmail = crearLabel("Correo electrónico");
        txtEmail = crearTextField();
        
        lblNombreUsuario = crearLabel("Nombre de usuario");
        txtNombreUsuario = crearTextField();
        
        lblDocumento = crearLabel("Documento de identidad");
        txtDocumento = crearTextField();
        
        lblTelefono = crearLabel("Número de teléfono");
        txtTelefono = crearTextField();
        
        lblContrasenia = crearLabel("Contraseña");
        txtContrasenia = new JPasswordField();
        txtContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));
        txtContrasenia.setBackground(COLOR_PANEL_BLANCO);
        txtContrasenia.setForeground(COLOR_TEXTO_PRINCIPAL);
        txtContrasenia.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        aplicarEfectoFocus(txtContrasenia);
        
        // Añadir campos al panel
        panelFormulario.add(lblNombre);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtNombre);
        panelFormulario.add(Box.createVerticalStrut(15));
        
        panelFormulario.add(lblEmail);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtEmail);
        panelFormulario.add(Box.createVerticalStrut(15));
        
        panelFormulario.add(lblNombreUsuario);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtNombreUsuario);
        panelFormulario.add(Box.createVerticalStrut(15));
        
        panelFormulario.add(lblDocumento);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtDocumento);
        panelFormulario.add(Box.createVerticalStrut(15));
        
        panelFormulario.add(lblTelefono);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtTelefono);
        panelFormulario.add(Box.createVerticalStrut(15));
        
        panelFormulario.add(lblContrasenia);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtContrasenia);
        panelFormulario.add(Box.createVerticalStrut(30));
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.setBackground(COLOR_PANEL_BLANCO);
        
        btnActualizarUsuario = new JButton("Actualizar datos");
        btnActualizarUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        btnActualizarUsuario.setBackground(COLOR_BOTON_PRIMARIO);
        btnActualizarUsuario.setForeground(Color.WHITE);
        btnActualizarUsuario.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnActualizarUsuario.setFocusPainted(false);
        btnActualizarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarUsuario.setPreferredSize(new Dimension(200, 45));
        
        btnActualizarUsuario.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnActualizarUsuario.setBackground(new Color(45, 115, 220));
            }
            public void mouseExited(MouseEvent evt) {
                btnActualizarUsuario.setBackground(COLOR_BOTON_PRIMARIO);
            }
        });
        
        btnEliminarUsuario = new JButton("Eliminar cuenta");
        btnEliminarUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        btnEliminarUsuario.setBackground(COLOR_BOTON_PELIGRO);
        btnEliminarUsuario.setForeground(Color.WHITE);
        btnEliminarUsuario.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        btnEliminarUsuario.setFocusPainted(false);
        btnEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarUsuario.setPreferredSize(new Dimension(200, 45));
        
        btnEliminarUsuario.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnEliminarUsuario.setBackground(new Color(192, 57, 43));
            }
            public void mouseExited(MouseEvent evt) {
                btnEliminarUsuario.setBackground(COLOR_BOTON_PELIGRO);
            }
        });
        
        panelBotones.add(btnActualizarUsuario);
        panelBotones.add(btnEliminarUsuario);
        panelFormulario.add(panelBotones);
        
        // Añadir paneles al panel central
        panelCentral.add(panelImagen, BorderLayout.WEST);
        panelCentral.add(panelFormulario, BorderLayout.CENTER);
        
        // Añadir todos los paneles al panel principal
        mainPanel.add(panelSuperior, BorderLayout.NORTH);
        mainPanel.add(panelCentral, BorderLayout.CENTER);
        
        // Crear scroll
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen de perfil");
        
        // Filtro para imágenes
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Archivos de imagen (*.jpg, *.jpeg, *.png, *.gif)", 
            "jpg", "jpeg", "png", "gif"
        );
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        int resultado = fileChooser.showOpenDialog(this);
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            imagenSeleccionada = fileChooser.getSelectedFile();
            
            try {
                // Cargar y redimensionar imagen
                ImageIcon originalIcon = new ImageIcon(imagenSeleccionada.getAbsolutePath());
                Image img = originalIcon.getImage();
                Image scaledImg = img.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                
                lblImagenPreview.setText("");
                lblImagenPreview.setIcon(scaledIcon);
                
            } catch (Exception e) {
                lblImagenPreview.setText(
                        "<html><div style='text-align: center; color: red;'>" + "Error al cargar imagen</div></html>");
            }
        }
    }
    
    // Métodos para crear componentes con estilo
    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(COLOR_TEXTO_PRINCIPAL);
        label.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        return label;
    }
    
    private JTextField crearTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(COLOR_PANEL_BLANCO);
        textField.setForeground(COLOR_TEXTO_PRINCIPAL);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        aplicarEfectoFocus(textField);
        return textField;
    }
    
    private void aplicarEfectoFocus(JTextField textField) {
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON_PRIMARIO, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
    
    private void aplicarEfectoFocus(JPasswordField textField) {
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON_PRIMARIO, 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
    
    // Método para cargar la imagen de perfil
    public void cargarImagenPerfil(String rutaImagen) {
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            try {
                File imagenFile = new File(rutaImagen);
                if (imagenFile.exists()) {
                    ImageIcon originalIcon = new ImageIcon(rutaImagen);
                    Image img = originalIcon.getImage();
                    Image scaledImg = img.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImg);
                    
                    lblImagenPreview.setText("");
                    lblImagenPreview.setIcon(scaledIcon);
                }
            } catch (Exception e) {
                // Si hay error al cargar la imagen, mantener el placeholder
                System.err.println("Error al cargar la imagen de perfil: " + e.getMessage());
            }
        }
    }
    
    // Método para limpiar el formulario
    public void limpiarFormulario() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtNombreUsuario.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtContrasenia.setText("");
        
        // Restablecer imagen
        imagenSeleccionada = null;
        lblImagenPreview.setIcon(null);
        lblImagenPreview.setText("<html><div style='text-align: center; color: #999; font-family: Arial;'>" +
                                "<div style='font-size: 60px; margin-bottom: 10px;'>👤</div>" +
                                "<div style='font-size: 16px; font-weight: bold;'>IMAGEN DE PERFIL</div>" +
                                "</html>");
    }

    // Getters y Setters
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
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

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JLabel getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(JLabel lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public JLabel getLblDocumento() {
        return lblDocumento;
    }

    public void setLblDocumento(JLabel lblDocumento) {
        this.lblDocumento = lblDocumento;
    }

    public JLabel getLblTelefono() {
        return lblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        this.lblTelefono = lblTelefono;
    }

    public JLabel getLblContrasenia() {
        return lblContrasenia;
    }

    public void setLblContrasenia(JLabel lblContrasenia) {
        this.lblContrasenia = lblContrasenia;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public JTextField getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(JTextField txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public JButton getBtnActualizarUsuario() {
        return btnActualizarUsuario;
    }

    public void setBtnActualizarUsuario(JButton btnActualizarUsuario) {
        this.btnActualizarUsuario = btnActualizarUsuario;
    }

    public JButton getBtnEliminarUsuario() {
        return btnEliminarUsuario;
    }

    public void setBtnEliminarUsuario(JButton btnEliminarUsuario) {
        this.btnEliminarUsuario = btnEliminarUsuario;
    }

    public JButton getBtnSeleccionarImagen() {
        return btnSeleccionarImagen;
    }

    public void setBtnSeleccionarImagen(JButton btnSeleccionarImagen) {
        this.btnSeleccionarImagen = btnSeleccionarImagen;
    }

    public File getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    public void setImagenSeleccionada(File imagenSeleccionada) {
        this.imagenSeleccionada = imagenSeleccionada;
    }
}