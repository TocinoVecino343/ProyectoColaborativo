package co.edu.unbosque.view;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelCrearAlimentoYBebida extends JPanel {
	
	
	/*	private boolean esLiquido;
	private int cantidadProducto;
	private String tipoEnvase;
	private int unidadEnvase;
*/
	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock,lblColor,lblEsLiquido,lblCantidadProducto,lblTipoEnvase,lblUnidadEnvase;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock,txtColor;

	 private JComboBox<String> cmbEsLiquido;
	 private JFormattedTextField txtCantidadDelProducto;
	 private JComboBox cmbUnidadEnvase,cmbTipoEnvase;
	
	 
	 
	
	  private JButton btnCrearAlimetoYBebida;
	
	  
	  public PanelCrearAlimentoYBebida() {
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
	        lblEsLiquido = new JLabel("Es liquido?:");
	        lblColor = new JLabel("Color:");
	        lblCantidadProducto = new JLabel("Cantidad del producto:");
	        lblTipoEnvase = new JLabel("Tipo del envase:");
	        lblUnidadEnvase = new JLabel("Cual es la unidad del envase:");
	        
	        
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        txtColor = new JTextArea();
	        
	        
	        cmbEsLiquido = new JComboBox<>();
	        
	        
	        cmbEsLiquido.addItem("si"); 
	        cmbEsLiquido.addItem("no");
	        
	        
	        NumberFormat numberFormat = NumberFormat.getNumberInstance();
	        txtCantidadDelProducto = new JFormattedTextField(numberFormat);
	        
	        
	        cmbUnidadEnvase = new JComboBox<>();
	        
	        cmbUnidadEnvase.addItem("mL");
	        cmbUnidadEnvase.addItem("L");
	        cmbUnidadEnvase.addItem("g");
	        cmbUnidadEnvase.addItem("kg");
	        cmbUnidadEnvase.addItem("Unidad");
	    
	        cmbTipoEnvase = new JComboBox<>();
	        
	        cmbTipoEnvase.addItem("Bolsa");
	        cmbTipoEnvase.addItem("Caja");
	        cmbTipoEnvase.addItem("Unidad/Paquete");
	        cmbTipoEnvase.addItem("Botella");
		
	        
	        
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

	        lblColor.setBounds(30, 370, 100, 25);
	        txtColor.setBounds(150, 370, 200, 25);

	        lblEsLiquido.setBounds(30, 410, 100, 25);
	        cmbEsLiquido.setBounds(150, 410, 200, 25);

	        lblCantidadProducto.setBounds(30, 450, 150, 25);
	        txtCantidadDelProducto.setBounds(180, 450, 170, 25);

	        lblUnidadEnvase.setBounds(30, 490, 150, 25);
	        cmbUnidadEnvase.setBounds(180, 490, 170, 25);

	        lblTipoEnvase.setBounds(30, 530, 150, 25);
	        cmbTipoEnvase.setBounds(180, 530, 170, 25);

	        btnCrearAlimetoYBebida.setBounds(100, 580, 220, 40);

	      
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
	        this.add(lblEsLiquido);
	        this.add(cmbEsLiquido);
	        this.add(lblCantidadProducto);
	        this.add(txtCantidadDelProducto);
	        this.add(lblUnidadEnvase);
	        this.add(cmbUnidadEnvase);
	        this.add(lblTipoEnvase);
	        this.add(cmbTipoEnvase);
	        this.add(btnCrearAlimetoYBebida);
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

	public JLabel getLblColor() {
		return lblColor;
	}

	public void setLblColor(JLabel lblColor) {
		this.lblColor = lblColor;
	}

	public JLabel getLblEsLiquido() {
		return lblEsLiquido;
	}

	public void setLblEsLiquido(JLabel lblEsLiquido) {
		this.lblEsLiquido = lblEsLiquido;
	}

	public JLabel getLblCantidadProducto() {
		return lblCantidadProducto;
	}

	public void setLblCantidadProducto(JLabel lblCantidadProducto) {
		this.lblCantidadProducto = lblCantidadProducto;
	}

	public JLabel getLblTipoEnvase() {
		return lblTipoEnvase;
	}

	public void setLblTipoEnvase(JLabel lblTipoEnvase) {
		this.lblTipoEnvase = lblTipoEnvase;
	}

	public JLabel getLblUnidadEnvase() {
		return lblUnidadEnvase;
	}

	public void setLblUnidadEnvase(JLabel lblUnidadEnvase) {
		this.lblUnidadEnvase = lblUnidadEnvase;
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

	public JTextArea getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextArea txtColor) {
		this.txtColor = txtColor;
	}

	public JComboBox<String> getCmbEsLiquido() {
		return cmbEsLiquido;
	}

	public void setCmbEsLiquido(JComboBox<String> cmbEsLiquido) {
		this.cmbEsLiquido = cmbEsLiquido;
	}

	public JFormattedTextField getTxtCantidadDelProducto() {
		return txtCantidadDelProducto;
	}

	public void setTxtCantidadDelProducto(JFormattedTextField txtCantidadDelProducto) {
		this.txtCantidadDelProducto = txtCantidadDelProducto;
	}

	public JComboBox getCmbUnidadEnvase() {
		return cmbUnidadEnvase;
	}

	public void setCmbUnidadEnvase(JComboBox cmbUnidadEnvase) {
		this.cmbUnidadEnvase = cmbUnidadEnvase;
	}

	public JComboBox getCmbTipoEnvase() {
		return cmbTipoEnvase;
	}

	public void setCmbTipoEnvase(JComboBox cmbTipoEnvase) {
		this.cmbTipoEnvase = cmbTipoEnvase;
	}

	public JButton getBtnCrearAlimetoYBebida() {
		return btnCrearAlimetoYBebida;
	}

	public void setBtnCrearAlimetoYBebida(JButton btnCrearAlimetoYBebida) {
		this.btnCrearAlimetoYBebida = btnCrearAlimetoYBebida;
	}
	  
	  
}
