package co.edu.unbosque.view;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelCrearCelular extends JPanel {

	private JLabel lblNombre, lblDescripcion, lblTipo, lblPrecio, lblMarca, lblCaracteristicas, lblStock,lblColor,lblMemoriaInterna,lblMemoriaRam,lblLargoPantalla,lblAnchoPantalla,lblAlturaPantalla,lblCamaraFrontal,lblCamaraTrasera,lblPoseeNFT;
	
	 private JTextArea txtNombre, txtDescripcion, txtTipo, txtPrecio, txtMarca, txtCaracteristicas, txtStock,txtColor;

	 private JComboBox<String> cmbMemoriaInterna,cmbMemoriaRam;
	 private JFormattedTextField txtLargoPantalla, txtAnchoPantalla, txtAlturaPantalla,txtCamaraFrontal,txtCamaraTrasera;
	 private JComboBox cmbPoseeNFT;
	
	 
	 
	
	  private JButton btnCrearCelular;
	
	  
	  public PanelCrearCelular() {
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
	        lblMemoriaInterna = new JLabel("Memoria Interna:");
	        lblColor = new JLabel("Color:");
	        lblMemoriaRam = new JLabel("Memoria Ram:");
	        lblLargoPantalla = new JLabel("Largo pantalla:");
	        lblAnchoPantalla = new JLabel("Ancho:");
	        lblAlturaPantalla = new JLabel("Altura pantalla:");
	        lblCamaraFrontal = new JLabel("Camara frontal:");
	        lblCamaraTrasera = new JLabel("Camara trasera:");
	        lblPoseeNFT = new JLabel("Posee NFT?:");
	        
	        
	        txtNombre = new JTextArea();
	        txtDescripcion = new JTextArea();
	        txtTipo = new JTextArea();
	        txtPrecio = new JTextArea();
	        txtMarca = new JTextArea();
	        txtCaracteristicas = new JTextArea();
	        txtStock = new JTextArea();
	        txtColor = new JTextArea();
	        
	        
	        cmbMemoriaInterna = new JComboBox<>();
	        
	        cmbMemoriaInterna.addItem("8GB");
	        cmbMemoriaInterna.addItem("16GB");
	        cmbMemoriaInterna.addItem("32GB");
	        cmbMemoriaInterna.addItem("64GB");
	        cmbMemoriaInterna.addItem("128GB");
	        cmbMemoriaInterna.addItem("256GB");
	        cmbMemoriaInterna.addItem("512GB");
	        cmbMemoriaInterna.addItem("1024GB");
	        
	        cmbMemoriaRam = new JComboBox<>();
	        
	        cmbMemoriaRam.addItem("2GB");
	        cmbMemoriaRam.addItem("3GB");
	        cmbMemoriaRam.addItem("6GB");
	        cmbMemoriaRam.addItem("8GB");
	        cmbMemoriaRam.addItem("12GB");
	        cmbMemoriaRam.addItem("16GB");
	        cmbMemoriaRam.addItem("18GB");
	        cmbMemoriaRam.addItem("2GB");
	        

	        NumberFormat numberFormat = NumberFormat.getNumberInstance();
	        txtLargoPantalla = new JFormattedTextField(numberFormat);
	        txtAnchoPantalla = new JFormattedTextField(numberFormat);
	        txtAlturaPantalla = new JFormattedTextField(numberFormat);
	        
	        
	        cmbPoseeNFT = new JComboBox<>();
	        
	        cmbPoseeNFT.addItem("si");
	        cmbPoseeNFT.addItem("no");
	        
	        btnCrearCelular = new JButton("Crear Celular:");
	        
	        
	        
	        btnCrearCelular.setBounds(100, 700, 200, 40);

	    
	     lblNombre.setBounds(30, 30, 120, 25);
	     txtNombre.setBounds(150, 30, 200, 25);

	    
	     lblDescripcion.setBounds(30, 70, 120, 25);
	     txtDescripcion.setBounds(150, 70, 200, 50);

	     
	     lblTipo.setBounds(30, 140, 120, 25);
	     txtTipo.setBounds(150, 140, 200, 25);

	    
	     lblPrecio.setBounds(30, 180, 120, 25);
	     txtPrecio.setBounds(150, 180, 200, 25);

	    
	     lblMarca.setBounds(30, 220, 120, 25);
	     txtMarca.setBounds(150, 220, 200, 25);

	     
	     lblCaracteristicas.setBounds(30, 260, 120, 25);
	     txtCaracteristicas.setBounds(150, 260, 200, 50);

	     
	     lblStock.setBounds(30, 330, 120, 25);
	     txtStock.setBounds(150, 330, 200, 25);

	    
	     lblColor.setBounds(30, 370, 120, 25);
	     txtColor.setBounds(150, 370, 200, 25);

	    
	     lblMemoriaInterna.setBounds(30, 410, 120, 25);
	     cmbMemoriaInterna.setBounds(150, 410, 200, 25);

	    
	     lblMemoriaRam.setBounds(30, 450, 120, 25);
	     cmbMemoriaRam.setBounds(150, 450, 200, 25);

	    
	     lblLargoPantalla.setBounds(30, 490, 120, 25);
	     txtLargoPantalla.setBounds(150, 490, 200, 25);

	    
	     lblAnchoPantalla.setBounds(30, 530, 120, 25);
	     txtAnchoPantalla.setBounds(150, 530, 200, 25);

	     
	     lblAlturaPantalla.setBounds(30, 570, 120, 25);
	     txtAlturaPantalla.setBounds(150, 570, 200, 25);


	     lblCamaraFrontal.setBounds(30, 610, 120, 25);
	     txtCamaraFrontal.setBounds(150, 610, 200, 25);

	     
	     lblCamaraTrasera.setBounds(30, 650, 120, 25);
	     txtCamaraTrasera.setBounds(150, 650, 200, 25);

	    
	     lblPoseeNFT.setBounds(30, 690, 120, 25);
	     cmbPoseeNFT.setBounds(150, 690, 200, 25);

	   
	     this.add(lblNombre);        this.add(txtNombre);
	     this.add(lblDescripcion);   this.add(txtDescripcion);
	     this.add(lblTipo);          this.add(txtTipo);
	     this.add(lblPrecio);        this.add(txtPrecio);
	     this.add(lblMarca);         this.add(txtMarca);
	     this.add(lblCaracteristicas); this.add(txtCaracteristicas);
	     this.add(lblStock);         this.add(txtStock);
	     this.add(lblColor);         this.add(txtColor);
	     this.add(lblMemoriaInterna); this.add(cmbMemoriaInterna);
	     this.add(lblMemoriaRam);    this.add(cmbMemoriaRam);
	     this.add(lblLargoPantalla); this.add(txtLargoPantalla);
	     this.add(lblAnchoPantalla); this.add(txtAnchoPantalla);
	     this.add(lblAlturaPantalla); this.add(txtAlturaPantalla);
	     this.add(lblCamaraFrontal); this.add(txtCamaraFrontal);
	     this.add(lblCamaraTrasera); this.add(txtCamaraTrasera);
	     this.add(lblPoseeNFT);      this.add(cmbPoseeNFT);
	     this.add(btnCrearCelular);
		  
		  
		  
	  }
}
