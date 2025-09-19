package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        setTitle("Mercado Libre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        setSize(1280, 920);
        setVisible(true);
    }
}