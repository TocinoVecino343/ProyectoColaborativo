package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelCrearDeporteYFitness extends JPanel {
	/*	private String color;
	private String material;
*/
	
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblMaterial, lblColor;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas,txtMaterial,txtStock,txtColor;

	
	
	  private JButton btnCrearDeporteYFitness;

	  
	  public PanelCrearDeporteYFitness() {
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
	        

	        txtNombre = new JTextArea();
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        txtMaterial = new JTextArea();
	        txtColor = new JTextArea();
	        
	        btnCrearDeporteYFitness = new JButton("Crear Deporte y Fitness:");
	        
	        lblNombre.setBounds(150, 100, 100, 30);
			lblDescripcion.setBounds(150, 150, 100, 30);
			lblTipo.setBounds(150, 200, 100, 30);
			lblPrecio.setBounds(150, 250, 100, 30);
			lblMarca.setBounds(150, 300, 100, 30);
			lblCaracteristicas.setBounds(150, 350, 120, 30);
			lblStock.setBounds(150, 410, 100, 30);
			lblMaterial.setBounds(150, 460, 100, 30);
			lblColor.setBounds(150, 510, 100, 30);

			txtNombre.setBounds(300, 100, 300, 30);
			txtDescripcion.setBounds(300, 150, 300, 60);
			txtTipo.setBounds(300, 220, 300, 30);
			txtPrecio.setBounds(300, 250, 300, 30);
			txtMarca.setBounds(300, 300, 300, 30);
			txtCaracteristicas.setBounds(300, 350, 300, 60);
			txtStock.setBounds(300, 420, 300, 30);
			txtMaterial.setBounds(300, 460, 300, 30);
			txtColor.setBounds(300, 510, 300, 30);

			btnCrearDeporteYFitness.setBounds(500, 580, 250, 40);

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
			this.add(lblMaterial);
			this.add(txtMaterial);
			this.add(lblColor);
			this.add(txtColor);
			this.add(btnCrearDeporteYFitness);
	        
	        
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

	public JButton getBtnCrearDeporteYFitness() {
		return btnCrearDeporteYFitness;
	}

	public void setBtnCrearDeporteYFitness(JButton btnCrearDeporteYFitness) {
		this.btnCrearDeporteYFitness = btnCrearDeporteYFitness;
	}
	  
	  
	  

}
