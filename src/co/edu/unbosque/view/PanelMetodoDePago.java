package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelMetodoDePago extends JPanel {

	private JLabel lblTitulo, lblTitular, lblNumeroTarjeta, lblFechaVencimiento, lblPinSeguridad, lblFrenteTarjeta,
			lblPosteriorTarjeta;

	private JTextField txtTitular, txtNumeroTarjeta, txtFechaVencimiento;

	private JPasswordField txtPinSeguridad;
	private JButton btnActualizar, btnEliminar;

	private ImageIcon frenteTarjeta;
	private ImageIcon posteriorTarjeta;

	private final Color COLOR_FONDO = new Color(235, 235, 235);
	private final int POSICION_LBL = 115;
	private final int POSICION_TXT = 355;
	private final int ANCHO = 200;
	private final int ALTURA = 30;

	public PanelMetodoDePago() {
		this.setVisible(true);
		this.setBackground(COLOR_FONDO);
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 800);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		lblTitulo = new JLabel("Método de Pago");
		lblTitulo.setBounds(115, 175, ANCHO, 50);

		lblTitular = new JLabel("Titular:");
		lblTitular.setBounds(POSICION_LBL, 275, ANCHO, ALTURA);

		lblNumeroTarjeta = new JLabel("Número de Tarjeta:");
		lblNumeroTarjeta.setBounds(POSICION_LBL, 333, ANCHO, ALTURA);

		lblFechaVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaVencimiento.setBounds(POSICION_LBL, 391, ANCHO, ALTURA);

		lblPinSeguridad = new JLabel("PIN de Seguridad:");
		lblPinSeguridad.setBounds(POSICION_LBL, 449, ANCHO, ALTURA);

		txtTitular = new JTextField();
		txtTitular.setBounds(POSICION_TXT, 275, ANCHO, ALTURA);

		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.setBounds(POSICION_TXT, 333, ANCHO, ALTURA);

		txtFechaVencimiento = new JTextField();
		txtFechaVencimiento.setBounds(POSICION_TXT, 391, ANCHO, ALTURA);

		txtPinSeguridad = new JPasswordField();
		txtPinSeguridad.setBounds(POSICION_TXT, 449, ANCHO, ALTURA);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(167, 644, 95, 30);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(407, 644, 95, 30);

		frenteTarjeta = new ImageIcon("/frenteTarjeta.png");
		lblFrenteTarjeta = new JLabel(frenteTarjeta);
		lblFrenteTarjeta.setBounds(770, 150, 328, 200);

		posteriorTarjeta = new ImageIcon("/posteriorTarjeta.png");
		lblPosteriorTarjeta = new JLabel(posteriorTarjeta);
		lblPosteriorTarjeta.setBounds(770, 340, 328, 200);

		this.add(lblTitulo);
		this.add(lblTitular);
		this.add(lblNumeroTarjeta);
		this.add(lblFechaVencimiento);
		this.add(lblPinSeguridad);
		this.add(txtTitular);
		this.add(txtNumeroTarjeta);
		this.add(txtFechaVencimiento);
		this.add(txtPinSeguridad);
		this.add(btnActualizar);
		this.add(btnEliminar);
		this.add(lblFrenteTarjeta);
		this.add(lblPosteriorTarjeta);
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblTitular() {
		return lblTitular;
	}

	public void setLblTitular(JLabel lblTitular) {
		this.lblTitular = lblTitular;
	}

	public JLabel getLblNumeroTarjeta() {
		return lblNumeroTarjeta;
	}

	public void setLblNumeroTarjeta(JLabel lblNumeroTarjeta) {
		this.lblNumeroTarjeta = lblNumeroTarjeta;
	}

	public JLabel getLblFechaVencimiento() {
		return lblFechaVencimiento;
	}

	public void setLblFechaVencimiento(JLabel lblFechaVencimiento) {
		this.lblFechaVencimiento = lblFechaVencimiento;
	}

	public JLabel getLblPinSeguridad() {
		return lblPinSeguridad;
	}

	public void setLblPinSeguridad(JLabel lblPinSeguridad) {
		this.lblPinSeguridad = lblPinSeguridad;
	}

	public JLabel getLblFrenteTarjeta() {
		return lblFrenteTarjeta;
	}

	public void setLblFrenteTarjeta(JLabel lblFrenteTarjeta) {
		this.lblFrenteTarjeta = lblFrenteTarjeta;
	}

	public JLabel getLblPosteriorTarjeta() {
		return lblPosteriorTarjeta;
	}

	public void setLblPosteriorTarjeta(JLabel lblPosteriorTarjeta) {
		this.lblPosteriorTarjeta = lblPosteriorTarjeta;
	}

	public JTextField getTxtTitular() {
		return txtTitular;
	}

	public void setTxtTitular(JTextField txtTitular) {
		this.txtTitular = txtTitular;
	}

	public JTextField getTxtNumeroTarjeta() {
		return txtNumeroTarjeta;
	}

	public void setTxtNumeroTarjeta(JTextField txtNumeroTarjeta) {
		this.txtNumeroTarjeta = txtNumeroTarjeta;
	}

	public JTextField getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(JTextField txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public JPasswordField getTxtPinSeguridad() {
		return txtPinSeguridad;
	}

	public void setTxtPinSeguridad(JPasswordField txtPinSeguridad) {
		this.txtPinSeguridad = txtPinSeguridad;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public ImageIcon getFrenteTarjeta() {
		return frenteTarjeta;
	}

	public void setFrenteTarjeta(ImageIcon frenteTarjeta) {
		this.frenteTarjeta = frenteTarjeta;
	}

	public ImageIcon getPosteriorTarjeta() {
		return posteriorTarjeta;
	}

	public void setPosteriorTarjeta(ImageIcon posteriorTarjeta) {
		this.posteriorTarjeta = posteriorTarjeta;
	}
	
	
}
