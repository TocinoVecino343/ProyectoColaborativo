/*package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelCrearMascota extends JPanel {
	//private String tipoAnimal;
	//private String raza;
	//private String color;
	//private String formatoDeVenta;

	
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblTipoAnimal,
	lblRaza, lblColor,lblFormatoDeVenta;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock, txtRaza,txtColor;

	 private JComboBox cmbTipoAnimal,cmbFormatoDeVenta;
	
	  private JButton btnCrearMascota;
	
	  
	  public PanelCrearMascota() {
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
	        lblTipoAnimal = new JLabel("Tipo del animal:");
	        lblRaza = new JLabel("Raza del animal:");
	        lblColor = new JLabel("Color del animal:");
	        lblFormatoDeVenta = new JLabel("Formato de venta:");
	  
	        
	        
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        txtRaza = new JTextArea();
	        txtColor = new JTextArea();
	        
	        
	        cmbTipoAnimal = new JComboBox<>();
	        
	        
	        cmbTipoAnimal.addItem("Perro");
	        cmbTipoAnimal.addItem("Gato");
	        cmbTipoAnimal.addItem("Aves");
	        cmbTipoAnimal.addItem("Peces");
	        cmbTipoAnimal.addItem("Roedores");
	        cmbTipoAnimal.addItem("Reptiles");
	        cmbTipoAnimal.addItem("Anfibios");
	        cmbTipoAnimal.addItem("Caballos");
	        
	        
	        
	        cmbFormatoDeVenta = new JComboBox<>();
	        
	        cmbFormatoDeVenta.addItem("Unidad");
	        cmbFormatoDeVenta.addItem("Caja");
	        cmbFormatoDeVenta.addItem("Frasco");
	        cmbFormatoDeVenta.addItem("Bolsa");
	        cmbFormatoDeVenta.addItem("Paquete");
	        cmbFormatoDeVenta.addItem("kit");
	        cmbFormatoDeVenta.addItem("Saco/Bulto");
	        cmbFormatoDeVenta.addItem("Lata");
	        cmbFormatoDeVenta.addItem("Sobre");
	        
	        
  btnCrearMascota = new JButton("Crear Producto de Mascota:");
	        
  lblNombre.setBounds(150, 100, 100, 30);
  lblDescripcion.setBounds(150, 150, 100, 30);
  lblTipo.setBounds(150, 200, 100, 30);
  lblPrecio.setBounds(150, 250, 100, 30);
  lblMarca.setBounds(150, 300, 100, 30);
  lblCaracteristicas.setBounds(150, 350, 120, 30);
  lblStock.setBounds(150, 410, 100, 30);
  lblTipoAnimal.setBounds(150, 460, 150, 30);
  lblRaza.setBounds(150, 510, 100, 30);
  lblColor.setBounds(150, 560, 100, 30);
  lblFormatoDeVenta.setBounds(150, 610, 150, 30);

 
  txtNombre.setBounds(300, 100, 300, 30);
  txtDescripcion.setBounds(300, 150, 300, 60);
  txtTipo.setBounds(300, 220, 300, 30);
  txtPrecio.setBounds(300, 250, 300, 30);
  txtMarca.setBounds(300, 300, 300, 30);
  txtCaracteristicas.setBounds(300, 350, 300, 60);
  txtStock.setBounds(300, 420, 300, 30);
  txtRaza.setBounds(300, 510, 300, 30);
  txtColor.setBounds(300, 560, 300, 30);


  cmbTipoAnimal.setBounds(300, 460, 300, 30);
  cmbFormatoDeVenta.setBounds(300, 610, 300, 30);

 
  btnCrearMascota.setBounds(500, 680, 200, 40);
  
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
  this.add(lblTipoAnimal);
  this.add(cmbTipoAnimal);
  this.add(lblRaza);
  this.add(txtRaza);
  this.add(lblColor);
  this.add(txtColor);
  this.add(lblFormatoDeVenta);
  this.add(cmbFormatoDeVenta);
  this.add(btnCrearMascota);
	  
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


	public JLabel getLblTipoAnimal() {
		return lblTipoAnimal;
	}


	public void setLblTipoAnimal(JLabel lblTipoAnimal) {
		this.lblTipoAnimal = lblTipoAnimal;
	}


	public JLabel getLblRaza() {
		return lblRaza;
	}


	public void setLblRaza(JLabel lblRaza) {
		this.lblRaza = lblRaza;
	}


	public JLabel getLblColor() {
		return lblColor;
	}


	public void setLblColor(JLabel lblColor) {
		this.lblColor = lblColor;
	}


	public JLabel getLblFormatoDeVenta() {
		return lblFormatoDeVenta;
	}


	public void setLblFormatoDeVenta(JLabel lblFormatoDeVenta) {
		this.lblFormatoDeVenta = lblFormatoDeVenta;
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


	public JTextArea getTxtRaza() {
		return txtRaza;
	}


	public void setTxtRaza(JTextArea txtRaza) {
		this.txtRaza = txtRaza;
	}


	public JTextArea getTxtColor() {
		return txtColor;
	}


	public void setTxtColor(JTextArea txtColor) {
		this.txtColor = txtColor;
	}


	public JComboBox getCmbTipoAnimal() {
		return cmbTipoAnimal;
	}


	public void setCmbTipoAnimal(JComboBox cmbTipoAnimal) {
		this.cmbTipoAnimal = cmbTipoAnimal;
	}


	public JComboBox getCmbFormatoDeVenta() {
		return cmbFormatoDeVenta;
	}


	public void setCmbFormatoDeVenta(JComboBox cmbFormatoDeVenta) {
		this.cmbFormatoDeVenta = cmbFormatoDeVenta;
	}


	public JButton getBtnCrearMedicamento() {
		return btnCrearMascota;
	}


	public void setBtnCrearMedicamento(JButton btnCrearMascota) {
		this.btnCrearMascota = btnCrearMascota;
	}
	  
	  
	  
	  
}*/
