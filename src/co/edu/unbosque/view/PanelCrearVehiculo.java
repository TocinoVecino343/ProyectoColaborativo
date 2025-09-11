package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCrearVehiculo extends JPanel {

	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblAnio,
			lblEsFinanciable, lblKilometraje;

	private JTextArea txtNombre, txtDescripcion, txtPrecio, txtCaracteristicas, txtStock, txtKilometraje;

	private JComboBox cmbTipo, cmbMarca, cmbAnio, cmbEsFinanciable;

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
		lblCaracteristicas = new JLabel("Características:");
		lblStock = new JLabel("Stock:");
		lblAnio = new JLabel("Año");
		lblEsFinanciable = new JLabel("Es financiable");

		txtNombre = new JTextArea();
		txtDescripcion = new JTextArea();
		txtPrecio = new JTextArea();
		txtCaracteristicas = new JTextArea();
		txtStock = new JTextArea();

		cmbTipo = new JComboBox<>();
		cmbTipo.addItem("Carros y camionetas");
		cmbTipo.addItem("Motos");
		cmbTipo.addItem("Maquinaria Pesada");
		cmbTipo.addItem("Carros de Coleccion");
		cmbTipo.addItem("Otros Vehiculos");

		cmbMarca = new JComboBox<>();
		cmbMarca.addItem("Toyota");
		cmbMarca.addItem("Chevrolet");
		cmbMarca.addItem("Renault");
		cmbMarca.addItem("Nissan");
		cmbMarca.addItem("Ford");
		cmbMarca.addItem("Hyundai");
		cmbMarca.addItem("Kia");
		cmbMarca.addItem("Volkswagen");
		cmbMarca.addItem("Mazda");
		cmbMarca.addItem("Suzuki");
		cmbMarca.addItem("Mercedes-Benz");
		cmbMarca.addItem("BMW");
		cmbMarca.addItem("Audi");
		cmbMarca.addItem("Mitsubishi");
		cmbMarca.addItem("Subaru");
		cmbMarca.addItem("Peugeot");
		cmbMarca.addItem("Citroën");
		cmbMarca.addItem("Seat");
		cmbMarca.addItem("Volvo");
		cmbMarca.addItem("Jeep");
		cmbMarca.addItem("Honda");
		cmbMarca.addItem("Otro");

		cmbAnio = new JComboBox<>();
		for (int i = 1980; i <= 2025; i++) {
			cmbAnio.addItem(String.valueOf(i));
		}

		cmbEsFinanciable = new JComboBox<>();
		cmbEsFinanciable.addItem("Si");
		cmbEsFinanciable.addItem("No");

		btnCrearVehiculo = new JButton("Crear Vehiculo:");
		btnCrearVehiculo.setBounds(500, 150, 100, 30);

		lblNombre.setBounds(150, 150, 100, 30);
		txtNombre.setBounds(300, 150, 300, 30);

		lblDescripcion.setBounds(150, 200, 100, 30);
		txtDescripcion.setBounds(300, 200, 300, 60);

		lblTipo.setBounds(150, 280, 100, 30);

		lblPrecio.setBounds(150, 330, 100, 30);
		txtPrecio.setBounds(300, 330, 300, 30);

		lblMarca.setBounds(150, 380, 100, 30);

		lblAnio.setBounds(150, 300, 200, 200);

		lblEsFinanciable.setBounds(150, 500, 100, 30);

		lblCaracteristicas.setBounds(150, 480, 120, 30);
		txtCaracteristicas.setBounds(300, 480, 300, 60);

		lblStock.setBounds(150, 560, 100, 30);
		txtStock.setBounds(300, 560, 300, 30);

		lblKilometraje.setBounds(300, 560, 300, 30);
		txtKilometraje.setBounds(300, 560, 300, 30);

		cmbTipo.setBounds(300, 560, 300, 30);
		cmbMarca.setBounds(300, 860, 300, 30);

		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		this.add(lblTipo);
		this.add(lblPrecio);
		this.add(txtPrecio);
		this.add(lblMarca);
		this.add(lblCaracteristicas);
		this.add(txtCaracteristicas);
		this.add(lblStock);
		this.add(txtStock);
		this.add(cmbTipo);
		this.add(cmbMarca);
		this.add(cmbAnio);
		this.add(btnCrearVehiculo);
		this.add(lblAnio);
		this.add(lblEsFinanciable);
		this.add(cmbEsFinanciable);
		this.add(lblKilometraje);
		this.add(txtKilometraje);
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

	public JLabel getLblCaracteristicas() {
		return lblCaracteristicas;
	}

	public void setLblCaracteristicas(JLabel lblCaracteristicas) {
		this.lblCaracteristicas = lblCaracteristicas;
	}

	public JLabel getLblStock() {
		return lblStock;
	}

	public void setLblStock(JLabel lblStock) {
		this.lblStock = lblStock;
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

	public JTextArea getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(JTextArea txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public JTextArea getTxtCaracteristicas() {
		return txtCaracteristicas;
	}

	public void setTxtCaracteristicas(JTextArea txtCaracteristicas) {
		this.txtCaracteristicas = txtCaracteristicas;
	}

	public JTextArea getTxtStock() {
		return txtStock;
	}

	public void setTxtStock(JTextArea txtStock) {
		this.txtStock = txtStock;
	}

	public JComboBox getCmbTipo() {
		return cmbTipo;
	}

	public void setCmbTipo(JComboBox cmbTipo) {
		this.cmbTipo = cmbTipo;
	}

	public JComboBox getCmbMarca() {
		return cmbMarca;
	}

	public void setCmbMarca(JComboBox cmbMarca) {
		this.cmbMarca = cmbMarca;
	}

	public JComboBox getCmbAnio() {
		return cmbAnio;
	}

	public void setCmbAnio(JComboBox cmbAnio) {
		this.cmbAnio = cmbAnio;
	}

	public JLabel getLblAnio() {
		return lblAnio;
	}

	public void setLblAnio(JLabel lblAnio) {
		this.lblAnio = lblAnio;
	}

	public JButton getBtnCrearVehiculo() {
		return btnCrearVehiculo;
	}

	public void setBtnCrearVehiculo(JButton btnCrearVehiculo) {
		this.btnCrearVehiculo = btnCrearVehiculo;
	}

	public JLabel getLblEsFinanciable() {
		return lblEsFinanciable;
	}

	public void setLblEsFinanciable(JLabel lblEsFinanciable) {
		this.lblEsFinanciable = lblEsFinanciable;
	}

	public JComboBox getCmbEsFinanciable() {
		return cmbEsFinanciable;
	}

	public void setCmbEsFinanciable(JComboBox cmbEsFinanciable) {
		this.cmbEsFinanciable = cmbEsFinanciable;
	}

	public JLabel getLblKilometraje() {
		return lblKilometraje;
	}

	public void setLblKilometraje(JLabel lblKilometraje) {
		this.lblKilometraje = lblKilometraje;
	}

	public JTextArea getTxtKilometraje() {
		return txtKilometraje;
	}

	public void setTxtKilometraje(JTextArea txtKilometraje) {
		this.txtKilometraje = txtKilometraje;
	}
	
	

}
