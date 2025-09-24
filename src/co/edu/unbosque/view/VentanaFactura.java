package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaFactura extends JFrame {

	private JLabel lblFondo, lblTitulo, lblCompra, lblPrecio;

	public VentanaFactura() {
		this.setVisible(false);
		this.setBackground(new Color(235, 235, 235));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setBounds(0, 0, 400, 400);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 34, 400, 115);
		lblFondo.setBackground(Color.GREEN);

		lblTitulo = new JLabel();
		lblTitulo.setBounds(61, 64, 277, 55);

		lblCompra = new JLabel();
		lblCompra.setBounds(61, 195, 179, 42);

		lblPrecio = new JLabel();
		lblPrecio.setBounds(61, 239, 195, 42);

		this.add(lblFondo);
		this.add(lblTitulo);
		this.add(lblCompra);
		this.add(lblPrecio);
	}

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

}