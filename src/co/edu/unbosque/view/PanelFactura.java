package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFactura extends JPanel {

	private JLabel lblFondo, lblInterfaz, lblTitulo, lblCompra, lblPrecio;

	public PanelFactura() {
		this.setVisible(true);
		this.setBackground(new Color(235, 235, 235));
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 1280, 800);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 1280, 800);
		lblFondo.setBackground(Color.GREEN);

		lblInterfaz = new JLabel();
		lblInterfaz.setBounds(303, 92, 600, 600);
		lblInterfaz.setBackground(Color.WHITE);

		lblTitulo = new JLabel("Resumen de tu compra");
		lblTitulo.setBounds(430, 272, 230, 50);

		lblCompra = new JLabel("Compraste: ");
		lblCompra.setBounds(405, 147, 396, 50);

		lblPrecio = new JLabel("Pagaste: ");
		lblPrecio.setBounds(430, 370, 245, 70);

		this.add(lblFondo);
		this.add(lblInterfaz);
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

	public JLabel getLblInterfaz() {
		return lblInterfaz;
	}

	public void setLblInterfaz(JLabel lblInterfaz) {
		this.lblInterfaz = lblInterfaz;
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