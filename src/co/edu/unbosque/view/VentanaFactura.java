package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaFactura extends JFrame {
    private JLabel lblFondo, lblTitulo, lblCompra, lblPrecio;
    private JPanel panelPrincipal, panelHeader, panelContent;
    
    public VentanaFactura() {
        this.setVisible(false);
        this.setBackground(new Color(245, 245, 245));
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setBounds(0, 0, 600, 650);
        this.setTitle("Factura de Compra");
        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
        // Panel principal con bordes redondeados
        panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo con gradiente
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(255, 255, 255),
                    0, getHeight(), new Color(248, 250, 252)
                );
                g2.setPaint(gradient);
                g2.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 20, 20);
                
                // Sombra sutil
                g2.setColor(new Color(0, 0, 0, 30));
                g2.fillRoundRect(12, 12, getWidth() - 20, getHeight() - 20, 20, 20);
                
                g2.dispose();
                super.paintComponent(g);
            }
        };
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setOpaque(false);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel header con gradiente verde
        panelHeader = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Gradiente verde moderno
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(34, 197, 94),
                    0, getHeight(), new Color(22, 163, 74)
                );
                g2.setPaint(gradient);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                
                g2.dispose();
            }
        };
        panelHeader.setLayout(new BorderLayout());
        panelHeader.setOpaque(false);
        panelHeader.setPreferredSize(new java.awt.Dimension(0, 100));
        panelHeader.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        // Título con mejor tipografía
        lblTitulo = new JLabel("Resumen de tu compra");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Icono de éxito (usando texto Unicode)
        JLabel iconoExito = new JLabel("✓");
        iconoExito.setFont(new Font("Segoe UI", Font.BOLD, 32));
        iconoExito.setForeground(Color.WHITE);
        iconoExito.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelHeader.add(iconoExito, BorderLayout.WEST);
        panelHeader.add(lblTitulo, BorderLayout.CENTER);
        
        // Panel de contenido
        panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        panelContent.setOpaque(false);
        panelContent.setBorder(BorderFactory.createEmptyBorder(40, 30, 30, 30));
        
        // Etiqueta de compra mejorada
        lblCompra = new JLabel("Compraste: Producto");
        lblCompra.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblCompra.setForeground(new Color(51, 65, 85));
        lblCompra.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        // Etiqueta de precio mejorada
        lblPrecio = new JLabel("Pagaste: $0.00");
        lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblPrecio.setForeground(new Color(22, 163, 74));
        lblPrecio.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        // Separador visual
        JPanel separador = new JPanel();
        separador.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 1));
        separador.setBackground(new Color(226, 232, 240));
        
        // Mensaje de agradecimiento
        JLabel lblGracias = new JLabel("¡Gracias por tu compra!");
        lblGracias.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        lblGracias.setForeground(new Color(100, 116, 139));
        lblGracias.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        // Fecha y hora
        JLabel lblFecha = new JLabel("Fecha: " + java.time.LocalDateTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblFecha.setForeground(new Color(148, 163, 184));
        lblFecha.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        // Agregar componentes al panel de contenido
        panelContent.add(lblCompra);
        panelContent.add(Box.createVerticalStrut(15));
        panelContent.add(lblPrecio);
        panelContent.add(Box.createVerticalStrut(30));
        panelContent.add(separador);
        panelContent.add(Box.createVerticalStrut(20));
        panelContent.add(lblGracias);
        panelContent.add(Box.createVerticalStrut(10));
        panelContent.add(lblFecha);
        
        // lblFondo para compatibilidad (invisible)
        lblFondo = new JLabel();
        lblFondo.setOpaque(false);
        
        // Ensamblar la ventana
        panelPrincipal.add(panelHeader, BorderLayout.NORTH);
        panelPrincipal.add(panelContent, BorderLayout.CENTER);
        
        this.add(panelPrincipal, BorderLayout.CENTER);
        this.getContentPane().setBackground(new Color(241, 245, 249));
    }
    
    // Getters y setters mantienen la compatibilidad
    public JLabel getLblFondo() {
        return lblFondo;
    }
    
    public void setLblFondo(JLabel lblFondo) {
        this.lblFondo = lblFondo;
    }
    
    public JLabel getLblTitulo() {
        return lblTitulo;
    }
    
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }
    
    public JLabel getLblCompra() {
        return lblCompra;
    }
    
    public void setLblCompra(JLabel lblCompra) {
        this.lblCompra = lblCompra;
    }
    
    public JLabel getLblPrecio() {
        return lblPrecio;
    }
    
    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }
    
    public void setPrecioDesdeString(String precioLimpio) {
        try {
            // Usar BigDecimal para mantener precisión
            BigDecimal precio = new BigDecimal(precioLimpio);
            DecimalFormat formatter = new DecimalFormat("#.###,##");
            String precioFormateado = "Pagaste: $" + precio ;
            this.lblPrecio.setText(precioFormateado);
        } catch (Exception e) {
            this.lblPrecio.setText("Pagaste: $" + precioLimpio);
        }
    }
    
    public void setPrecioFormateado(float precio) {
        try {
            String precioFormateado = "Pagaste: $"+precio;
            this.lblPrecio.setText(precioFormateado);
        } catch (Exception e) {
            this.lblPrecio.setText("Pagaste: $" + precio);
        }
    }
    
    public void setPrecioTexto(String precioTexto) {
        if (!precioTexto.startsWith("Pagaste: ")) {
            this.lblPrecio.setText("Pagaste: " + precioTexto);
        } else {
            this.lblPrecio.setText(precioTexto);
        }
    }
}