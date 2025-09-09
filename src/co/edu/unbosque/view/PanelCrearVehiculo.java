package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCrearVehiculo extends JPanel {

	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblVendedor, lblCaracteristicas,
			lblCalificacion;

	private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtVendedor, txtCaracteristicas,
			txtCalificacion;

	private JButton btnCrearVehiculo;

	public PanelCrearVehiculo() {
		this.setVisible(true);
		this.setBackground(Color.decode("#ffe600"));
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 150);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		lblNombre = new JLabel("Nombre:");
		lblDescripcion = new JLabel("Descripción:");
		lblTipo = new JLabel("Tipo:");
		lblPrecio = new JLabel("Precio:");
		lblMarca = new JLabel("Marca:");
		lblVendedor = new JLabel("Vendedor:");
		lblCaracteristicas = new JLabel("Características:");
		lblCalificacion = new JLabel("Calificación:");

		txtNombre = new JTextArea();
		txtDescripcion = new JTextArea();
		txtTipo = new JTextArea();
		txtPrecio = new JTextArea();
		txtMarca = new JTextArea();
		txtVendedor = new JTextArea();
		txtCaracteristicas = new JTextArea();
		txtCalificacion = new JTextArea();

		btnCrearVehiculo = new JButton("Crear Vehiculo:");
		btnCrearVehiculo.setBounds(500, 150, 100, 30);

		lblNombre.setBounds(150, 150, 100, 30);
		txtNombre.setBounds(300, 150, 300, 30);

		lblDescripcion.setBounds(150, 200, 100, 30);
		txtDescripcion.setBounds(300, 200, 300, 60);

		lblTipo.setBounds(150, 280, 100, 30);
		txtTipo.setBounds(300, 280, 300, 30);

		lblPrecio.setBounds(150, 330, 100, 30);
		txtPrecio.setBounds(300, 330, 300, 30);

		lblMarca.setBounds(150, 380, 100, 30);
		txtMarca.setBounds(300, 380, 300, 30);

		lblVendedor.setBounds(150, 430, 100, 30);
		txtVendedor.setBounds(300, 430, 300, 30);

		lblCaracteristicas.setBounds(150, 480, 120, 30);
		txtCaracteristicas.setBounds(300, 480, 300, 60);

		lblCalificacion.setBounds(150, 560, 100, 30);
		txtCalificacion.setBounds(300, 560, 300, 30);

		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		this.add(lblTipo);
		this.add(txtTipo);
		this.add(lblPrecio);
		this.add(txtPrecio);
		this.add(lblMarca);
		this.add(txtMarca);
		this.add(lblVendedor);
		this.add(txtVendedor);
		this.add(lblCaracteristicas);
		this.add(txtCaracteristicas);
		this.add(lblCalificacion);
		this.add(txtCalificacion);
		this.add(btnCrearVehiculo);
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	public void setLblDescripcion(JLabel lblDescripcion) {
		this.lblDescripcion = lblDescripcion;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public void setLblPrecio(JLabel lblPrecio) {
		this.lblPrecio = lblPrecio;
	}

	public JLabel getLblMarca() {
		return lblMarca;
	}

	public void setLblMarca(JLabel lblMarca) {
		this.lblMarca = lblMarca;
	}

	public JLabel getLblVendedor() {
		return lblVendedor;
	}

	public void setLblVendedor(JLabel lblVendedor) {
		this.lblVendedor = lblVendedor;
	}

	public JLabel getLblCaracteristicas() {
		return lblCaracteristicas;
	}

	public void setLblCaracteristicas(JLabel lblCaracteristicas) {
		this.lblCaracteristicas = lblCaracteristicas;
	}

	public JLabel getLblCalificacion() {
		return lblCalificacion;
	}

	public void setLblCalificacion(JLabel lblCalificacion) {
		this.lblCalificacion = lblCalificacion;
	}

	public JTextArea getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextArea txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextArea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JTextArea getTxtTipo() {
		return txtTipo;
	}

	public void setTxtTipo(JTextArea txtTipo) {
		this.txtTipo = txtTipo;
	}

	public JTextArea getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(JTextArea txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public JTextArea getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(JTextArea txtMarca) {
		this.txtMarca = txtMarca;
	}

	public JTextArea getTxtVendedor() {
		return txtVendedor;
	}

	public void setTxtVendedor(JTextArea txtVendedor) {
		this.txtVendedor = txtVendedor;
	}

	public JTextArea getTxtCaracteristicas() {
		return txtCaracteristicas;
	}

	public void setTxtCaracteristicas(JTextArea txtCaracteristicas) {
		this.txtCaracteristicas = txtCaracteristicas;
	}

	public JTextArea getTxtCalificacion() {
		return txtCalificacion;
	}

	public void setTxtCalificacion(JTextArea txtCalificacion) {
		this.txtCalificacion = txtCalificacion;
	}

	public JButton getBtnCrearVehiculo() {
		return btnCrearVehiculo;
	}

	public void setBtnCrearVehiculo(JButton btnCrearVehiculo) {
		this.btnCrearVehiculo = btnCrearVehiculo;
	}

	
}
