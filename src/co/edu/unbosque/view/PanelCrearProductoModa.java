package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.*;

public class PanelCrearProductoModa extends JPanel {

    private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock,
                   lblColor, lblTalla, lblMaterial;

    private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock,
                      txtColor;

    private JComboBox<String> cmbTipo, cmbMarca, cmbTalla, cmbMaterial;

    private JButton btnCrearProductoModa;

    public PanelCrearProductoModa() {
        this.setVisible(true);
        this.setBackground(Color.decode("#ffe600"));
        this.setLayout(null);
        this.setBounds(0, 0, 1280, 920);
        inicializarComponentes();
    }

    public void inicializarComponentes() {

        // ===== ETIQUETAS =====
        lblNombre = new JLabel("Nombre:");
        lblDescripcion = new JLabel("Descripción:");
        lblTipo = new JLabel("Tipo:");
        lblPrecio = new JLabel("Precio:");
        lblMarca = new JLabel("Marca:");
        lblCaracteristicas = new JLabel("Características:");
        lblStock = new JLabel("Stock:");
        lblColor = new JLabel("Color:");
        lblTalla = new JLabel("Talla:");
        lblMaterial = new JLabel("Material:");

        txtNombre = new JTextArea();
        txtDescripcion = new JTextArea();
        txtTipo = new JTextArea();
        txtPrecio = new JTextArea();
        txtMarca = new JTextArea();
        txtCaracteristicas = new JTextArea();
        txtStock = new JTextArea();
        txtColor = new JTextArea();

        cmbTipo = new JComboBox<>();
        cmbTipo.addItem("Tenis");
        cmbTipo.addItem("Pantalones y Jeans");
        cmbTipo.addItem("Sacos y Buzos");
        cmbTipo.addItem("Accesorios de Moda");
        cmbTipo.addItem("Ropa Interior");
        cmbTipo.addItem("Bolsos");
        cmbTipo.addItem("Calzado");

        cmbMarca = new JComboBox<>();
        cmbMarca.addItem("Adidas");
        cmbMarca.addItem("Levis");
        cmbMarca.addItem("GAP");
        cmbMarca.addItem("Guess");
        cmbMarca.addItem("Lacoste");
        cmbMarca.addItem("Ray-Ban");
        cmbMarca.addItem("Calvin Klein");
        cmbMarca.addItem("Pandora");
        cmbMarca.addItem("Sajú");
        cmbMarca.addItem("Gooms");
        cmbMarca.addItem("Mr. Boho");
        cmbMarca.addItem("Cuarzos");
        cmbMarca.addItem("Ángeles");
        cmbMarca.addItem("Marini Star");
        cmbMarca.addItem("The Five Brand");
        cmbMarca.addItem("Lunia");
        cmbMarca.addItem("Juliana Sánchez");
        cmbMarca.addItem("Amai");
        cmbMarca.addItem("Easy People");
        cmbMarca.addItem("Dulzamara");
        cmbMarca.addItem("Mía de Dios");
        cmbMarca.addItem("Domenica");
        cmbMarca.addItem("Palo Rosa");
        cmbMarca.addItem("Monastery");
        cmbMarca.addItem("Arturo Calle");
        cmbMarca.addItem("Mister Jack");
        cmbMarca.addItem("Estefanía Turbay");
        cmbMarca.addItem("Algodón y Coco");
        cmbMarca.addItem("Closetup");
        cmbMarca.addItem("Otro");
        cmbTalla = new JComboBox<>();
        cmbTalla.addItem("XS");
        cmbTalla.addItem("S");
        cmbTalla.addItem("M");
        cmbTalla.addItem("L");
        cmbTalla.addItem("XL");
        cmbTalla.addItem("XXL");
        cmbTalla.addItem("XXXL");
        cmbTalla.addItem("Única");

        cmbMaterial = new JComboBox<>();
        cmbMaterial.addItem("Algodón");
        cmbMaterial.addItem("Seda");
        cmbMaterial.addItem("Lino");
        cmbMaterial.addItem("Poliéster");
        cmbMaterial.addItem("Lana");
        cmbMaterial.addItem("Cuero");
        cmbMaterial.addItem("Sintético");
        cmbMaterial.addItem("Jeans");
        cmbMaterial.addItem("Tela de punto");
        cmbMaterial.addItem("Terciopelo");
        cmbMaterial.addItem("Nylon");
        cmbMaterial.addItem("Spandex");
        cmbMaterial.addItem("Viscosa");
        cmbMaterial.addItem("Modal");
        cmbMaterial.addItem("Microfibra");

        btnCrearProductoModa = new JButton("Crear Producto de Moda:");

        lblNombre.setBounds(150, 150, 100, 30);
        txtNombre.setBounds(300, 150, 300, 30);

        lblDescripcion.setBounds(150, 200, 100, 30);
        txtDescripcion.setBounds(300, 200, 300, 60);

        lblTipo.setBounds(150, 280, 100, 30);
        cmbTipo.setBounds(300, 280, 300, 30);

        lblPrecio.setBounds(150, 330, 100, 30);
        txtPrecio.setBounds(300, 330, 300, 30);

        lblMarca.setBounds(150, 380, 100, 30);
        cmbMarca.setBounds(300, 380, 300, 30); 
        txtMarca.setBounds(300, 380, 300, 30); 

        lblCaracteristicas.setBounds(150, 480, 120, 30);
        txtCaracteristicas.setBounds(300, 480, 300, 60);

        lblStock.setBounds(150, 560, 100, 30);
        txtStock.setBounds(300, 560, 300, 30);

        lblColor.setBounds(150, 610, 100, 30);
        txtColor.setBounds(300, 610, 300, 30);

        lblTalla.setBounds(150, 660, 100, 30);
        cmbTalla.setBounds(300, 660, 300, 30);

        lblMaterial.setBounds(150, 710, 100, 30);
        cmbMaterial.setBounds(300, 710, 300, 30);

        btnCrearProductoModa.setBounds(500, 780, 200, 30);

        this.add(lblNombre); 
        this.add(txtNombre);
        this.add(lblDescripcion); 
        this.add(txtDescripcion);
        this.add(lblTipo); 
        this.add(cmbTipo);
        this.add(lblPrecio); 
        this.add(txtPrecio);
        this.add(lblMarca); 
        this.add(cmbMarca); 
        this.add(txtMarca);
        this.add(lblCaracteristicas); 
        this.add(txtCaracteristicas);
        this.add(lblStock); 
        this.add(txtStock);
        this.add(lblColor); 
        this.add(txtColor);
        this.add(lblTalla); 
        this.add(cmbTalla);
        this.add(lblMaterial); 
        this.add(cmbMaterial);
        this.add(btnCrearProductoModa);
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

	public JLabel getLblTalla() {
		return lblTalla;
	}

	public void setLblTalla(JLabel lblTalla) {
		this.lblTalla = lblTalla;
	}

	public JLabel getLblMaterial() {
		return lblMaterial;
	}

	public void setLblMaterial(JLabel lblMaterial) {
		this.lblMaterial = lblMaterial;
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

	public JComboBox getCmbTalla() {
		return cmbTalla;
	}

	public void setCmbTalla(JComboBox cmbTalla) {
		this.cmbTalla = cmbTalla;
	}

	public JComboBox getCmbMaterial() {
		return cmbMaterial;
	}

	public void setCmbMaterial(JComboBox cmbMaterial) {
		this.cmbMaterial = cmbMaterial;
	}

	public JButton getBtnCrearProductoModa() {
		return btnCrearProductoModa;
	}

	public void setBtnCrearProductoModa(JButton btnCrearProductoModa) {
		this.btnCrearProductoModa = btnCrearProductoModa;
	}

	

}
