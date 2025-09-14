package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private PanelSuperior panelS;

    public Ventana() {
        // Inicializa el panel superior
        this.panelS = new PanelSuperior();

        // Configura la ventana principal
        setTitle("Mercado Libre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Usa BorderLayout (correcto)
        setLayout(new BorderLayout());

        // Agrega PanelSuperior en la parte superior
        add(panelS, BorderLayout.NORTH);

        // ¡IMPORTANTE! Ajusta el tamaño automáticamente según los componentes
        pack(); // ← Esto hace que la ventana se ajuste al contenido

        // Si quieres forzar un tamaño mínimo (opcional)
        setSize(1280, 920);

        // Ocultar hasta que se inicie sesión
        setVisible(false);
    }

    public PanelSuperior getPanelS() {
        return panelS;
    }
}