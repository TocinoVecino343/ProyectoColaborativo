package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionarCategoria extends JPanel {
    private JButton btnAlimentoYBebida, btnCelular, btnConstruccion, btnDeporteYFitness,
                    btnElectrodomesticos, btnJuguete, btnMascota, btnMedicamento,
                    btnModa, btnVehiculo;
    
    // Colores estilo MercadoLibre
    private final Color COLOR_FONDO = new Color(235, 235, 235);
    private final Color COLOR_PANEL_BLANCO = Color.WHITE;
    private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
    private final Color COLOR_BOTON_NORMAL = new Color(52, 131, 250);
    private final Color COLOR_BOTON_HOVER = new Color(45, 115, 220);
    private final Color COLOR_BORDE = new Color(220, 220, 220);
    
    // Iconos para las categorías
    private final String[] ICONOS = {
        "🍔", "📱", "🏗️", "🏋️", 
        "🔌", "🔫", "🐾", "💊", 
        "👕", "🚗"
    };

    public PanelSeleccionarCategoria() {
        this.setBackground(COLOR_FONDO);
        this.setLayout(new BorderLayout());
        
        // Panel principal con scroll
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_FONDO);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        // Título del panel
        JLabel lblTitulo = new JLabel("Selecciona una categoría");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(COLOR_TEXTO_PRINCIPAL);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        
        // Panel para los botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 2, 25, 25));
        panelBotones.setBackground(COLOR_FONDO);
        
        // Crear botones
        JButton[] botones = crearBotones();
        
        // Añadir botones al panel
        for (JButton btn : botones) {
            panelBotones.add(btn);
        }
        
        // Añadir componentes al panel principal
        mainPanel.add(lblTitulo, BorderLayout.NORTH);
        mainPanel.add(panelBotones, BorderLayout.CENTER);
        
        // Añadir panel principal a este panel
        this.add(mainPanel);
    }
    
    private JButton[] crearBotones() {
        JButton[] botones = new JButton[10];
        String[] textos = {
            "Alimentos y Bebidas", "Celulares", "Construcción", "Deporte y Fitness",
            "Electrodomésticos", "Juguetes", "Mascotas", "Medicamentos",
            "Moda", "Vehículos"
        };
        
        String[] comandos = {
            "Alimentos y Bebidas", "Celulares", "Construcción", "Deporte y Fitness",
            "Electrodomésticos", "Juguetes", "Mascotas", "Medicamentos",
            "Moda", "Vehículos"
        };
        
        for (int i = 0; i < botones.length; i++) {
            botones[i] = crearBotonCategoria(textos[i], comandos[i], ICONOS[i]);
        }
        
        // Asignar botones a las variables de instancia
        btnAlimentoYBebida = botones[0];
        btnCelular = botones[1];
        btnConstruccion = botones[2];
        btnDeporteYFitness = botones[3];
        btnElectrodomesticos = botones[4];
        btnJuguete = botones[5];
        btnMascota = botones[6];
        btnMedicamento = botones[7];
        btnModa = botones[8];
        btnVehiculo = botones[9];
        
        return botones;
    }
    
    private JButton crearBotonCategoria(String texto, String comando, String icono) {
        JButton boton = new JButton();
        boton.setText("<html><div style='text-align: center;'><div style='font-size: 30px; margin-bottom: 5px;'>" + 
                     icono + "</div><div style='font-size: 14px; font-weight: bold;'>" + texto + "</div></div></html>");
        boton.setActionCommand(comando);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBackground(COLOR_PANEL_BLANCO);
        boton.setForeground(COLOR_TEXTO_PRINCIPAL);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDE, 1),
            BorderFactory.createEmptyBorder(20, 10, 20, 10)
        ));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efecto hover
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(248, 249, 250));
                boton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BOTON_NORMAL, 2),
                    BorderFactory.createEmptyBorder(19, 9, 19, 9)
                ));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(COLOR_PANEL_BLANCO);
                boton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(COLOR_BORDE, 1),
                    BorderFactory.createEmptyBorder(20, 10, 20, 10)
                ));
            }
        });
        
        return boton;
    }

    // Getters y Setters
    public JButton getBtnAlimentoYBebida() {
        return btnAlimentoYBebida;
    }

    public void setBtnAlimentoYBebida(JButton btnAlimentoYBebida) {
        this.btnAlimentoYBebida = btnAlimentoYBebida;
    }

    public JButton getBtnCelular() {
        return btnCelular;
    }

    public void setBtnCelular(JButton btnCelular) {
        this.btnCelular = btnCelular;
    }

    public JButton getBtnConstruccion() {
        return btnConstruccion;
    }

    public void setBtnConstruccion(JButton btnConstruccion) {
        this.btnConstruccion = btnConstruccion;
    }

    public JButton getBtnDeporteYFitness() {
        return btnDeporteYFitness;
    }

    public void setBtnDeporteYFitness(JButton btnDeporteYFitness) {
        this.btnDeporteYFitness = btnDeporteYFitness;
    }

    public JButton getBtnElectrodomesticos() {
        return btnElectrodomesticos;
    }

    public void setBtnElectrodomesticos(JButton btnElectrodomesticos) {
        this.btnElectrodomesticos = btnElectrodomesticos;
    }

    public JButton getBtnJuguete() {
        return btnJuguete;
    }

    public void setBtnJuguete(JButton btnJuguete) {
        this.btnJuguete = btnJuguete;
    }

    public JButton getBtnMascota() {
        return btnMascota;
    }

    public void setBtnMascota(JButton btnMascota) {
        this.btnMascota = btnMascota;
    }

    public JButton getBtnMedicamento() {
        return btnMedicamento;
    }

    public void setBtnMedicamento(JButton btnMedicamento) {
        this.btnMedicamento = btnMedicamento;
    }

    public JButton getBtnModa() {
        return btnModa;
    }

    public void setBtnModa(JButton btnModa) {
        this.btnModa = btnModa;
    }

    public JButton getBtnVehiculo() {
        return btnVehiculo;
    }

    public void setBtnVehiculo(JButton btnVehiculo) {
        this.btnVehiculo = btnVehiculo;
    }
}