package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private PanelSuperior panelS;

    public Ventana() {
        this.panelS = new PanelSuperior();

        setTitle("Mercado Libre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(panelS, BorderLayout.NORTH);

        pack(); 

        setSize(1280, 920);

        setVisible(false);
    }

    public PanelSuperior getPanelS() {
        return panelS;
    }
}