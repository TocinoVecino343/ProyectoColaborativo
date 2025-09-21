package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.MetodoDePago;

public class PanelMetodoDePago extends JPanel {
	private JLabel lblTitulo, lblTitular, lblNumeroTarjeta, lblFechaVencimiento, lblPinSeguridad;
	private JTextField txtTitular, txtNumeroTarjeta, txtFechaVencimiento, txtPinSeguridad;
	private JButton btnAgregarMetodo, btnEliminarMetodo, btnEditarMetodo, btnVolver;
	private JPanel panelTarjetas, panelFormulario, panelBotones;
	private List<MetodoDePago> metodosDePago;
	private MetodoDePago metodoSeleccionado;

	// Colores estilo MercadoLibre
	private final Color COLOR_FONDO = new Color(235, 235, 235);
	private final Color COLOR_PANEL_BLANCO = Color.WHITE;
	private final Color COLOR_TEXTO_PRINCIPAL = new Color(51, 51, 51);
	private final Color COLOR_TEXTO_SECUNDARIO = new Color(102, 102, 102);
	private final Color COLOR_BORDE_CAMPO = new Color(220, 220, 220);
	private final Color COLOR_BOTON_PRIMARIO = new Color(52, 131, 250);
	private final Color COLOR_BOTON_SECUNDARIO = new Color(46, 204, 113);
	private final Color COLOR_BOTON_PELIGRO = new Color(231, 76, 60);

	public PanelMetodoDePago() {
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

		lblTitulo = new JLabel("Métodos de Pago");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setForeground(COLOR_TEXTO_PRINCIPAL);
		panelSuperior.add(lblTitulo);

		// Panel central - Contenido
		JPanel panelCentral = new JPanel(new BorderLayout(30, 0));
		panelCentral.setBackground(COLOR_FONDO);
		panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));

		// Panel izquierdo - Lista de métodos de pago
		panelTarjetas = new JPanel();
		panelTarjetas.setLayout(new BoxLayout(panelTarjetas, BoxLayout.Y_AXIS));
		panelTarjetas.setBackground(COLOR_PANEL_BLANCO);
		panelTarjetas.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
				BorderFactory.createEmptyBorder(20, 20, 20, 20)));

		// Título de la sección
		JLabel tituloTarjetas = new JLabel("Tus métodos de pago");
		tituloTarjetas.setFont(new Font("Arial", Font.BOLD, 18));
		tituloTarjetas.setForeground(COLOR_TEXTO_PRINCIPAL);
		tituloTarjetas.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		panelTarjetas.add(tituloTarjetas);
		panelTarjetas.add(Box.createVerticalStrut(20));

		// Panel derecho - Formulario
		panelFormulario = new JPanel();
		panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
		panelFormulario.setBackground(COLOR_PANEL_BLANCO);
		panelFormulario.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1), BorderFactory.createEmptyBorder(30, 30, 30, 30)));

		// Título del formulario
		JLabel tituloFormulario = new JLabel("Agregar/Editar método de pago");
		tituloFormulario.setFont(new Font("Arial", Font.BOLD, 18));
		tituloFormulario.setForeground(COLOR_TEXTO_PRINCIPAL);
		tituloFormulario.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		panelFormulario.add(tituloFormulario);
		panelFormulario.add(Box.createVerticalStrut(30));

		// Campos del formulario
		lblTitular = crearLabel("Titular de la tarjeta");
		txtTitular = crearTextField();

		lblNumeroTarjeta = crearLabel("Número de tarjeta");
		txtNumeroTarjeta = crearTextField();

		lblFechaVencimiento = crearLabel("Fecha de vencimiento (MM/AA)");
		txtFechaVencimiento = crearTextField();

		lblPinSeguridad = crearLabel("PIN de seguridad");
		txtPinSeguridad = crearTextField();

		// Añadir campos al panel
		panelFormulario.add(lblTitular);
		panelFormulario.add(Box.createVerticalStrut(5));
		panelFormulario.add(txtTitular);
		panelFormulario.add(Box.createVerticalStrut(15));

		panelFormulario.add(lblNumeroTarjeta);
		panelFormulario.add(Box.createVerticalStrut(5));
		panelFormulario.add(txtNumeroTarjeta);
		panelFormulario.add(Box.createVerticalStrut(15));

		panelFormulario.add(lblFechaVencimiento);
		panelFormulario.add(Box.createVerticalStrut(5));
		panelFormulario.add(txtFechaVencimiento);
		panelFormulario.add(Box.createVerticalStrut(15));

		panelFormulario.add(lblPinSeguridad);
		panelFormulario.add(Box.createVerticalStrut(5));
		panelFormulario.add(txtPinSeguridad);
		panelFormulario.add(Box.createVerticalStrut(30));

		// Panel de botones del formulario
		JPanel panelBotonesFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		panelBotonesFormulario.setBackground(COLOR_PANEL_BLANCO);

		btnAgregarMetodo = crearBoton("Agregar método", COLOR_BOTON_SECUNDARIO);
		btnEditarMetodo = crearBoton("Actualizar método", COLOR_BOTON_PRIMARIO);
		btnEliminarMetodo = crearBoton("Eliminar método", COLOR_BOTON_PELIGRO);

		panelBotonesFormulario.add(btnAgregarMetodo);
		panelBotonesFormulario.add(btnEditarMetodo);
		panelBotonesFormulario.add(btnEliminarMetodo);

		panelFormulario.add(panelBotonesFormulario);

		// Panel inferior - Botón volver
		panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBotones.setBackground(COLOR_FONDO);
		panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
		btnVolver.setBackground(COLOR_BOTON_PRIMARIO);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
		btnVolver.setFocusPainted(false);
		btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnVolver.setPreferredSize(new Dimension(150, 45));

		btnVolver.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnVolver.setBackground(new Color(45, 115, 220));
			}

			public void mouseExited(MouseEvent evt) {
				btnVolver.setBackground(COLOR_BOTON_PRIMARIO);
			}
		});

		panelBotones.add(btnVolver);

		// Añadir paneles al panel central
		panelCentral.add(panelTarjetas, BorderLayout.WEST);
		panelCentral.add(panelFormulario, BorderLayout.CENTER);

		// Añadir todos los paneles al panel principal
		mainPanel.add(panelSuperior, BorderLayout.NORTH);
		mainPanel.add(panelCentral, BorderLayout.CENTER);
		mainPanel.add(panelBotones, BorderLayout.SOUTH);

		// Crear scroll
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		this.add(scrollPane, BorderLayout.CENTER);
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
		textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
				BorderFactory.createEmptyBorder(8, 12, 8, 12)));
		textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
		aplicarEfectoFocus(textField);
		return textField;
	}

	private JButton crearBoton(String texto, Color colorFondo) {
		JButton boton = new JButton(texto);
		boton.setFont(new Font("Arial", Font.BOLD, 14));
		boton.setBackground(colorFondo);
		boton.setForeground(Color.WHITE);
		boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		boton.setFocusPainted(false);
		boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		boton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if (colorFondo.equals(COLOR_BOTON_PRIMARIO)) {
					boton.setBackground(new Color(45, 115, 220));
				} else if (colorFondo.equals(COLOR_BOTON_SECUNDARIO)) {
					boton.setBackground(new Color(38, 184, 100));
				} else if (colorFondo.equals(COLOR_BOTON_PELIGRO)) {
					boton.setBackground(new Color(192, 57, 43));
				}
			}

			public void mouseExited(MouseEvent evt) {
				boton.setBackground(colorFondo);
			}
		});

		return boton;
	}

	private void aplicarEfectoFocus(JTextField textField) {
		textField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				textField.setBorder(
						BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BOTON_PRIMARIO, 2),
								BorderFactory.createEmptyBorder(7, 11, 7, 11)));
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				textField.setBorder(
						BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1),
								BorderFactory.createEmptyBorder(8, 12, 8, 12)));
			}
		});
	}


	public void mostrarMetodosDePago(List<MetodoDePago> metodos) {
	        panelTarjetas.removeAll();

	        JLabel tituloTarjetas = new JLabel("Tus métodos de pago");
	        tituloTarjetas.setFont(new Font("Arial", Font.BOLD, 18));
	        tituloTarjetas.setForeground(COLOR_TEXTO_PRINCIPAL);
	        tituloTarjetas.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	        panelTarjetas.add(tituloTarjetas);
	        panelTarjetas.add(Box.createVerticalStrut(20));
	        
	        this.metodosDePago = metodos;
	        
	        if (metodos.isEmpty()) {
	            JLabel mensaje = new JLabel("No tienes métodos de pago registrados");
	            mensaje.setFont(new Font("Arial", Font.ITALIC, 16));
	            mensaje.setForeground(COLOR_TEXTO_SECUNDARIO);
	            mensaje.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	            panelTarjetas.add(mensaje);
	        } else {
	            for (MetodoDePago metodo : metodos) {
	                JPanel panelTarjeta = crearPanelTarjeta(metodo);
	                panelTarjetas.add(panelTarjeta);
	                panelTarjetas.add(Box.createVerticalStrut(15));
	            }
	        }
	        panelTarjetas.revalidate();
	        panelTarjetas.repaint();     
	}
	

	private JPanel crearPanelTarjeta(MetodoDePago metodo) {
		JPanel panelTarjeta = new JPanel(new BorderLayout(10, 10));
		panelTarjeta.setBackground(COLOR_PANEL_BLANCO);
		panelTarjeta.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));
		panelTarjeta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		panelTarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		JPanel panelIcono = new JPanel(new BorderLayout());
		panelIcono.setBackground(new Color(248, 248, 248));
		panelIcono.setPreferredSize(new Dimension(80, 80));
		panelIcono.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CAMPO, 1));

		JLabel lblIcono = new JLabel();
		lblIcono.setHorizontalAlignment(JLabel.CENTER);
		lblIcono.setVerticalAlignment(JLabel.CENTER);
		lblIcono.setText("💳");
		lblIcono.setFont(new Font("Arial", Font.PLAIN, 30));
		panelIcono.add(lblIcono, BorderLayout.CENTER);

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		panelInfo.setBackground(COLOR_PANEL_BLANCO);

		JLabel lblTitular = new JLabel(metodo.getTitular());
		lblTitular.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitular.setForeground(COLOR_TEXTO_PRINCIPAL);

		String numeroTarjetaStr = String.valueOf(metodo.getNumeroTarjeta());
		String numeroOculto = "**** **** **** "
				+ (numeroTarjetaStr.length() >= 4 ? numeroTarjetaStr.substring(numeroTarjetaStr.length() - 4) : "");
		JLabel lblNumero = new JLabel(numeroOculto);

		JLabel lblVencimiento = new JLabel("Vence: " + metodo.getFechaVencimiento());
		lblVencimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVencimiento.setForeground(COLOR_TEXTO_SECUNDARIO);

		panelInfo.add(lblTitular);
		panelInfo.add(Box.createVerticalStrut(5));
		panelInfo.add(lblNumero);
		panelInfo.add(lblVencimiento);

		// Añadir paneles al panel de la tarjeta
		panelTarjeta.add(panelIcono, BorderLayout.WEST);
		panelTarjeta.add(panelInfo, BorderLayout.CENTER);

		panelTarjeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionarMetodoDePago(metodo);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelTarjeta.setBackground(new Color(248, 248, 248));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelTarjeta.setBackground(COLOR_PANEL_BLANCO);
			}
		});

		return panelTarjeta;
	}

	private void seleccionarMetodoDePago(MetodoDePago metodo) {
		this.metodoSeleccionado = metodo;

		txtTitular.setText(metodo.getTitular());
		txtNumeroTarjeta.setText(String.valueOf(metodo.getNumeroTarjeta()));
		txtFechaVencimiento.setText(metodo.getFechaVencimiento());
		txtPinSeguridad.setText(String.valueOf(metodo.getPinDeSeguridad()));

		JLabel tituloFormulario = (JLabel) panelFormulario.getComponent(0);
		tituloFormulario.setText("Editar método de pago");

		panelFormulario.revalidate();
		panelFormulario.repaint();
	}


	public void limpiarFormulario() {
	    txtTitular.setText("");
	    txtNumeroTarjeta.setText("");
	    txtFechaVencimiento.setText("");
	    txtPinSeguridad.setText("");
	    metodoSeleccionado = null;
	    JLabel tituloFormulario = (JLabel) panelFormulario.getComponent(0);
	    tituloFormulario.setText("Agregar/Editar método de pago");
	    panelFormulario.revalidate();
	    panelFormulario.repaint();

	}

	// Getters y Setters
	public JTextField getTxtTitular() {
		return txtTitular;
	}

	public void setTxtTitular(JTextField txtTitular) {
		this.txtTitular = txtTitular;
	}

	public JTextField getTxtNumeroTarjeta() {
		return txtNumeroTarjeta;
	}

	public void setTxtNumeroTarjeta(JTextField txtNumeroTarjeta) {
		this.txtNumeroTarjeta = txtNumeroTarjeta;
	}

	public JTextField getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(JTextField txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public JTextField getTxtPinSeguridad() {
		return txtPinSeguridad;
	}

	public void setTxtPinSeguridad(JTextField txtPinSeguridad) {
		this.txtPinSeguridad = txtPinSeguridad;
	}

	public JButton getBtnAgregarMetodo() {
		return btnAgregarMetodo;
	}

	public void setBtnAgregarMetodo(JButton btnAgregarMetodo) {
		this.btnAgregarMetodo = btnAgregarMetodo;
	}

	public JButton getBtnEliminarMetodo() {
		return btnEliminarMetodo;
	}

	public void setBtnEliminarMetodo(JButton btnEliminarMetodo) {
		this.btnEliminarMetodo = btnEliminarMetodo;
	}

	public JButton getBtnEditarMetodo() {
		return btnEditarMetodo;
	}

	public void setBtnEditarMetodo(JButton btnEditarMetodo) {
		this.btnEditarMetodo = btnEditarMetodo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public MetodoDePago getMetodoSeleccionado() {
		return metodoSeleccionado;
	}

	public void setMetodoSeleccionado(MetodoDePago metodoSeleccionado) {
		this.metodoSeleccionado = metodoSeleccionado;
	}
}