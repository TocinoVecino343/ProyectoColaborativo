package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {

    private JButton btnCategoria;
    private JButton btnVender;
    private JButton btnCarro;
    private JTextField txtFieldBuscador;

    public PanelSuperior() {
        setBackground(Color.decode("#ffe600"));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(1280, 150));

        inicializarComponentes();
    }

    public void inicializarComponentes() {
        btnCategoria = new JButton("Categorias");
        btnVender = new JButton("Vender");
        btnCarro = new JButton("Carrito 🛒");
        txtFieldBuscador = new JTextField(30);

        txtFieldBuscador.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(btnCategoria);
        add(txtFieldBuscador);
        add(btnVender);
        add(btnCarro);

        setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    public JButton getBtnCategoria() { return btnCategoria; }
    public JButton getBtnVender() { return btnVender; }
    public JButton getBtnCarro() { return btnCarro; }
    public JTextField getTxtFieldBuscador() { return txtFieldBuscador; }
}
