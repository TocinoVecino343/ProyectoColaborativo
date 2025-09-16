/*package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class PanelCrearMedicamento extends JPanel {
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock, lblFormatoMedicamento,
	lblFormatoDeVenta;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock;

	 private JComboBox<String> cmbFormatoMedicamento, cmbFormatoDeVenta;
	
	  private JButton btnCrearMedicamento;
	   
	  public PanelCrearMedicamento() {
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
	        lblFormatoMedicamento = new JLabel("Formato del medicamento:");
	        lblFormatoDeVenta = new JLabel("Formato de venta:");
	     
	        
	        
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        
	        cmbFormatoMedicamento = new JComboBox<>();
	        cmbFormatoMedicamento.addItem("Tableta");
	        cmbFormatoMedicamento.addItem("Capsula ");
	        cmbFormatoMedicamento.addItem("Jarabe");
	        cmbFormatoMedicamento.addItem("inyectable");
	        
	        
	        cmbFormatoDeVenta = new JComboBox<>();
	        cmbFormatoDeVenta.addItem("Unidad");
	        cmbFormatoDeVenta.addItem("Caja");
	        cmbFormatoDeVenta.addItem("Frasco");
	        
	        
	        
	        btnCrearMedicamento = new JButton("Crear Producto de Moda:");
	        
	        lblNombre.setBounds(150, 150, 150, 30);
	        txtNombre.setBounds(300, 150, 300, 30);

	        lblDescripcion.setBounds(150, 200, 150, 30);
	        txtDescripcion.setBounds(300, 200, 300, 60);

	        lblTipo.setBounds(150, 280, 150, 30);
	        txtTipo.setBounds(300, 280, 300, 30);

	        lblPrecio.setBounds(150, 330, 150, 30);
	        txtPrecio.setBounds(300, 330, 300, 30);

	        lblMarca.setBounds(150, 380, 150, 30);
	        txtMarca.setBounds(300, 380, 300, 30);

	        lblCaracteristicas.setBounds(150, 430, 150, 30);
	        txtCaracteristicas.setBounds(300, 430, 300, 60);

	        lblStock.setBounds(150, 500, 150, 30);
	        txtStock.setBounds(300, 500, 300, 30);

	        lblFormatoMedicamento.setBounds(150, 550, 200, 30);
	        cmbFormatoMedicamento.setBounds(300, 550, 300, 30);

	        lblFormatoDeVenta.setBounds(150, 600, 200, 30);
	        cmbFormatoDeVenta.setBounds(300, 600, 300, 30);

	        btnCrearMedicamento.setBounds(500, 700, 200, 40);
	        
	        
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
	        this.add(lblFormatoMedicamento);
	        this.add(cmbFormatoMedicamento);
	        this.add(lblFormatoDeVenta);
	        this.add(cmbFormatoDeVenta);
	        this.add(btnCrearMedicamento);
	        
	      
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


	public JLabel getLblFormatoMedicamento() {
		return lblFormatoMedicamento;
	}


	public void setLblFormatoMedicamento(JLabel lblFormatoMedicamento) {
		this.lblFormatoMedicamento = lblFormatoMedicamento;
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


	public JComboBox getCmbFormatoMedicamento() {
		return cmbFormatoMedicamento;
	}


	public void setCmbFormatoMedicamento(JComboBox cmbFormatoMedicamento) {
		this.cmbFormatoMedicamento = cmbFormatoMedicamento;
	}


	public JComboBox getCmbFormatoDeVenta() {
		return cmbFormatoDeVenta;
	}


	public void setCmbFormatoDeVenta(JComboBox cmbFormatoDeVenta) {
		this.cmbFormatoDeVenta = cmbFormatoDeVenta;
	}


	public JButton getBtnCrearMedicamento() {
		return btnCrearMedicamento;
	}


	public void setBtnCrearMedicamento(JButton btnCrearMedicamento) {
		this.btnCrearMedicamento = btnCrearMedicamento;
	}
	  
	  
	  
	  
	 

}*/
