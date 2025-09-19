package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class PanelSuperior extends JPanel {

    private JButton btnCategoria;
    private JButton btnVender;
    private JButton btnCarro;
    private JTextField txtFieldBuscador;
    private JLabel lblLogo;

    public PanelSuperior() {
        this.setVisible(true);
        this.setBackground(Color.decode("#ffe600"));
        this.setLayout(null); // Mantengo el layout absoluto como lo tenías
        this.setPreferredSize(new Dimension(1280, 120)); // Uso preferredSize en lugar de setBounds
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        // Logo/Título
        lblLogo = new JLabel("MercadoLibre");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 24));
        lblLogo.setForeground(Color.BLACK);
        lblLogo.setBounds(20, 45, 200, 30);

        // Buscador
        txtFieldBuscador = new JTextField("Buscar productos, marcas y más...");
        txtFieldBuscador.setBounds(250, 25, 600, 40);
        txtFieldBuscador.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtFieldBuscador.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldBuscador.setForeground(Color.GRAY);

        // Botón de búsqueda
        JButton btnBuscar = new JButton("🔍");
        btnBuscar.setBounds(850, 25, 50, 40);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnBuscar.setFocusPainted(false);

        // Botones de navegación
        btnCategoria = new JButton("Categorías");
        btnCategoria.setBounds(200, 80, 120, 35);
        estilizarBoton(btnCategoria);

        btnVender = new JButton("Vender");
        btnVender.setBounds(750, 80, 100, 35);
        estilizarBoton(btnVender);

        btnCarro = new JButton("Carrito 🛒");
        btnCarro.setBounds(900, 80, 120, 35);
        estilizarBoton(btnCarro);

        // Agregar componentes
        this.add(lblLogo);
        this.add(txtFieldBuscador);
        this.add(btnBuscar);
        this.add(btnCategoria);
        this.add(btnVender);
        this.add(btnCarro);

        // Agregar funcionalidad al campo de búsqueda
        txtFieldBuscador.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (txtFieldBuscador.getText().equals("Buscar productos, marcas y más...")) {
                    txtFieldBuscador.setText("");
                    txtFieldBuscador.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (txtFieldBuscador.getText().isEmpty()) {
                    txtFieldBuscador.setText("Buscar productos, marcas y más...");
                    txtFieldBuscador.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void estilizarBoton(JButton boton) {
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setBackground(Color.WHITE);
        boton.setForeground(Color.BLACK);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        boton.setFocusPainted(false);
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Efecto hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                boton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                boton.setBackground(Color.WHITE);
            }
        });
    }

    // Getters y setters
    public JButton getBtnCategoria() {
        return btnCategoria;
    }

    public void setBtnCategoria(JButton btnCategoria) {
        this.btnCategoria = btnCategoria;
    }

    public JButton getBtnVender() {
        return btnVender;
    }

    public void setBtnVender(JButton btnVender) {
        this.btnVender = btnVender;
    }

    public JButton getBtnCarro() {
        return btnCarro;
    }

    public void setBtnCarro(JButton btnCarro) {
        this.btnCarro = btnCarro;
    }

    public JTextField getTxtFieldBuscador() {
        return txtFieldBuscador;
    }

    public void setTxtFieldBuscador(JTextField txtFieldBuscador) {
        this.txtFieldBuscador = txtFieldBuscador;
    }

    public JLabel getLblLogo() {
        return lblLogo;
    }

    public void setLblLogo(JLabel lblLogo) {
        this.lblLogo = lblLogo;
    }
}