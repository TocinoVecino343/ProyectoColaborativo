package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelCrearElectrodomesticos extends JPanel {
	
	
	/*private String modelo;
	private int voltaje;
	private String color;
*/
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblModelo,
	lblVoltaje, lblColor;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas,txtStock, txtModelo,txtColor;

	 private JComboBox<String> cmbVoltaje;


	
	  private JButton btnCrearElectrodomestico;
	
	  
	  public PanelCrearElectrodomesticos() {
	        this.setVisible(true);
	        this.setBackground(Color.decode("#ffe600"));
	        this.setLayout(null);
	        this.setBounds(0, 0, 1280, 920);
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
	        lblColor = new JLabel("Color:");
	        lblModelo = new JLabel("Modelo:");
	        lblVoltaje = new JLabel("Voltaje:");
	  
	  
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        txtColor = new JTextArea();
	  
	        cmbVoltaje = new JComboBox<>();
	        
	        cmbVoltaje.addItem("110V");
	        cmbVoltaje.addItem("220V-240V");
	  
	        btnCrearElectrodomestico = new JButton("Crear Electrodomestico:");
	        
	        lblNombre.setBounds(150, 100, 100, 30);
			lblDescripcion.setBounds(150, 150, 100, 30);
			lblTipo.setBounds(150, 200, 100, 30);
			lblPrecio.setBounds(150, 250, 100, 30);
			lblMarca.setBounds(150, 300, 100, 30);
			lblCaracteristicas.setBounds(150, 350, 120, 30);
			lblStock.setBounds(150, 410, 100, 30);
			lblColor.setBounds(150, 460, 100, 30);
			lblModelo.setBounds(150, 510, 100, 30);
			lblVoltaje.setBounds(150, 560, 100, 30);

			txtNombre.setBounds(300, 100, 300, 30);
			txtDescripcion.setBounds(300, 150, 300, 60);
			txtTipo.setBounds(300, 220, 300, 30);
			txtPrecio.setBounds(300, 250, 300, 30);
			txtMarca.setBounds(300, 300, 300, 30);
			txtCaracteristicas.setBounds(300, 350, 300, 60);
			txtStock.setBounds(300, 420, 300, 30);
			txtColor.setBounds(300, 460, 300, 30);
			txtModelo.setBounds(300, 510, 300, 30);

			cmbVoltaje.setBounds(300, 560, 300, 30);

			btnCrearElectrodomestico.setBounds(500, 630, 250, 40);

			// Añadir componentes al panel
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
			this.add(lblCaracteristicas);
			this.add(txtCaracteristicas);
			this.add(lblStock);
			this.add(txtStock);
			this.add(lblColor);
			this.add(txtColor);
			this.add(lblModelo);
			this.add(txtModelo);
			this.add(lblVoltaje);
			this.add(cmbVoltaje);
			this.add(btnCrearElectrodomestico);
	        
	        
	        
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


	public JLabel getLblModelo() {
		return lblModelo;
	}


	public void setLblModelo(JLabel lblModelo) {
		this.lblModelo = lblModelo;
	}


	public JLabel getLblVoltaje() {
		return lblVoltaje;
	}


	public void setLblVoltaje(JLabel lblVoltaje) {
		this.lblVoltaje = lblVoltaje;
	}


	public JLabel getLblColor() {
		return lblColor;
	}


	public void setLblColor(JLabel lblColor) {
		this.lblColor = lblColor;
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


	public JTextArea getTxtModelo() {
		return txtModelo;
	}


	public void setTxtModelo(JTextArea txtModelo) {
		this.txtModelo = txtModelo;
	}


	public JTextArea getTxtColor() {
		return txtColor;
	}


	public void setTxtColor(JTextArea txtColor) {
		this.txtColor = txtColor;
	}


	public JComboBox getCmbVoltaje() {
		return cmbVoltaje;
	}


	public void setCmbVoltaje(JComboBox cmbVoltaje) {
		this.cmbVoltaje = cmbVoltaje;
	}


	public JButton getBtnCrearElectrodomestico() {
		return btnCrearElectrodomestico;
	}


	public void setBtnCrearElectrodomestico(JButton btnCrearElectrodomestico) {
		this.btnCrearElectrodomestico = btnCrearElectrodomestico;
	}
	  
	  
	  
}
