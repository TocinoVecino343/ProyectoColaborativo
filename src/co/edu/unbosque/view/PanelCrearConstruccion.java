package co.edu.unbosque.view;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelCrearConstruccion extends JPanel{
/*	
	private String modelo;
	private String material;
	private String color;
	private float largo;
	private float ancho;
	private float altura;
*/
	
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblModelo, lblMaterial,lblColor,lblLargo,lblAncho,lblAltura;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas,txtMaterial,txtStock,txtColor,txtModelo;

	 private JComboBox<String> cmbMaterial;

	/*NumberFormat numberFormat = NumberFormat.getNumberInstance();
numberFormat.setMaximumFractionDigits(2); // Máx. 2 decimales

txtLargo = new JFormattedTextField(numberFormat);
txtAncho = new JFormattedTextField(numberFormat);
txtAltura = new JFormattedTextField(numberFormat);*/
	 //se supone que de esa forma se usa en el controler, es algo para que valide solo numeros :v
	private JFormattedTextField txtLargo, txtAncho, txtAltura;
	
	  private JButton btnCrearConstruccion;
	  
	  
	  
	  public PanelCrearConstruccion() {
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
	        lblMaterial = new JLabel("Material:");
	        lblColor = new JLabel("Color:");
	        lblModelo = new JLabel("Modelo:");
	        lblLargo = new JLabel("Largo:");
	        lblAncho = new JLabel("Ancho:");
	        lblAltura = new JLabel("Altura:");
	        
	        
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        txtColor = new JTextArea();
	        txtModelo = new JTextArea();
	        
	        
	        
	        cmbMaterial = new JComboBox<>();
	        
	        cmbMaterial.addItem("Cemento");
	        cmbMaterial.addItem("Concreto");
	        cmbMaterial.addItem("Ladrillo");
	        cmbMaterial.addItem("Madera");
	        cmbMaterial.addItem("Acero");
	        cmbMaterial.addItem("Hierro");
	        cmbMaterial.addItem("Plástico");
	        cmbMaterial.addItem("Vidrio");
	        cmbMaterial.addItem("Cerámica");
	        cmbMaterial.addItem("Piedra natural");
	        cmbMaterial.addItem("Panel de yeso");
	        cmbMaterial.addItem("Yeso");
	        cmbMaterial.addItem("Impermeabilizante");
	        cmbMaterial.addItem("Sellador");
	        cmbMaterial.addItem("Pintura");
	        
	     
	        NumberFormat numberFormat = NumberFormat.getNumberInstance();
	        txtLargo = new JFormattedTextField(numberFormat);
	        txtAncho = new JFormattedTextField(numberFormat);
	        txtAltura = new JFormattedTextField(numberFormat);
	  
	        btnCrearConstruccion = new JButton("Crear tipo Construccion:");
	        
	        lblNombre.setBounds(30, 30, 100, 25);
	        txtNombre.setBounds(150, 30, 200, 25);

	        lblDescripcion.setBounds(30, 70, 100, 25);
	        txtDescripcion.setBounds(150, 70, 200, 50);

	        lblTipo.setBounds(30, 140, 100, 25);
	        txtTipo.setBounds(150, 140, 200, 25);

	        lblPrecio.setBounds(30, 180, 100, 25);
	        txtPrecio.setBounds(150, 180, 200, 25);

	        lblMarca.setBounds(30, 220, 100, 25);
	        txtMarca.setBounds(150, 220, 200, 25);

	        lblCaracteristicas.setBounds(30, 260, 100, 25);
	        txtCaracteristicas.setBounds(150, 260, 200, 50);

	        lblStock.setBounds(30, 330, 100, 25);
	        txtStock.setBounds(150, 330, 200, 25);

	        lblModelo.setBounds(30, 370, 100, 25);
	        txtModelo.setBounds(150, 370, 200, 25);

	        lblMaterial.setBounds(30, 410, 100, 25);
	        cmbMaterial.setBounds(150, 410, 200, 25);

	        lblColor.setBounds(30, 450, 100, 25);
	        txtColor.setBounds(150, 450, 200, 25);

	        lblLargo.setBounds(30, 490, 100, 25);
	        txtLargo.setBounds(150, 490, 200, 25);

	        lblAncho.setBounds(30, 530, 100, 25);
	        txtAncho.setBounds(150, 530, 200, 25);

	        lblAltura.setBounds(30, 570, 100, 25);
	        txtAltura.setBounds(150, 570, 200, 25);

	        btnCrearConstruccion.setBounds(100, 620, 200, 40);

	        // Agregar componentes al panel
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
	        this.add(lblModelo);
	        this.add(txtModelo);
	        this.add(lblMaterial);
	        this.add(cmbMaterial);
	        this.add(lblColor);
	        this.add(txtColor);
	        this.add(lblLargo);
	        this.add(txtLargo);
	        this.add(lblAncho);
	        this.add(txtAncho);
	        this.add(lblAltura);
	        this.add(txtAltura);
	        this.add(btnCrearConstruccion);

	  

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

	public JLabel getLblMaterial() {
		return lblMaterial;
	}

	public void setLblMaterial(JLabel lblMaterial) {
		this.lblMaterial = lblMaterial;
	}

	public JLabel getLblColor() {
		return lblColor;
	}

	public void setLblColor(JLabel lblColor) {
		this.lblColor = lblColor;
	}

	public JLabel getLblLargo() {
		return lblLargo;
	}

	public void setLblLargo(JLabel lblLargo) {
		this.lblLargo = lblLargo;
	}

	public JLabel getLblAncho() {
		return lblAncho;
	}

	public void setLblAncho(JLabel lblAncho) {
		this.lblAncho = lblAncho;
	}

	public JLabel getLblAltura() {
		return lblAltura;
	}

	public void setLblAltura(JLabel lblAltura) {
		this.lblAltura = lblAltura;
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

	public JTextArea getTxtMaterial() {
		return txtMaterial;
	}

	public void setTxtMaterial(JTextArea txtMaterial) {
		this.txtMaterial = txtMaterial;
	}

	public JTextArea getTxtStock() {
		return txtStock;
	}

	public void setTxtStock(JTextArea txtStock) {
		this.txtStock = txtStock;
	}

	public JTextArea getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextArea txtColor) {
		this.txtColor = txtColor;
	}

	public JTextArea getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(JTextArea txtModelo) {
		this.txtModelo = txtModelo;
	}

	public JComboBox getCmbMaterial() {
		return cmbMaterial;
	}

	public void setCmbMaterial(JComboBox cmbMaterial) {
		this.cmbMaterial = cmbMaterial;
	}

	public JFormattedTextField getTxtLargo() {
		return txtLargo;
	}

	public void setTxtLargo(JFormattedTextField txtLargo) {
		this.txtLargo = txtLargo;
	}

	public JFormattedTextField getTxtAncho() {
		return txtAncho;
	}

	public void setTxtAncho(JFormattedTextField txtAncho) {
		this.txtAncho = txtAncho;
	}

	public JFormattedTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JFormattedTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

	public JButton getBtnCrearConstruccion() {
		return btnCrearConstruccion;
	}

	public void setBtnCrearConstruccion(JButton btnCrearConstruccion) {
		this.btnCrearConstruccion = btnCrearConstruccion;
	}
	  
	  
}
