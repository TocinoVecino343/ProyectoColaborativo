package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUsuario extends JPanel {

	private JLabel lblTitulo, lblNombre, lblNombre2, lblEmail, lblEmail2, lblImagen, lblNombreUsuario, lblDocumento,
			lblTelefono, lblContrasenia;

	private JTextField txtNombre, txtEmail, txtNombreUsuario, txtDocumento, txtTelefono, txtContrasenia;

	private JButton btnActualizarUsuario, btnEliminarUsuario, btnSeleccionarImagen;

	private final Color COLOR_FONDO = new Color(235, 235, 235);
	private final int POSICION_LBL = 410;
	private final int ANCHO_LBL = 148;
	private final int ALTURA_LBL = 32;
	private final int POSICION_TXT = 590;
	private final int ANCHO_TXT = 284;

	public PanelUsuario() {
		this.setVisible(true);
		this.setBackground(COLOR_FONDO);
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 800);
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		lblTitulo = new JLabel("Datos de la cuenta");
		lblTitulo.setBounds(POSICION_LBL, 50, ANCHO_LBL, ALTURA_LBL);
		lblNombre2 = new JLabel();
		lblNombre2.setBounds(615, 138, 260, 32);
		lblEmail2 = new JLabel();
		lblEmail2.setBounds(615, 192, 260, 32);
		lblImagen = new JLabel();
		lblImagen.setBounds(POSICION_LBL, 178, 112, 150);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(POSICION_LBL, 320, ANCHO_LBL, ALTURA_LBL);
		txtNombre = new JTextField();
		txtNombre.setBounds(POSICION_TXT, 320, ANCHO_TXT, ALTURA_LBL);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(POSICION_LBL, 380, ANCHO_LBL, ALTURA_LBL);
		txtEmail = new JTextField();
		txtEmail.setBounds(POSICION_TXT, 380, ANCHO_TXT, ALTURA_LBL);

		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setBounds(POSICION_LBL, 440, ANCHO_LBL, ALTURA_LBL);
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(POSICION_TXT, 440, ANCHO_TXT, ALTURA_LBL);

		lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(POSICION_LBL, 500, ANCHO_LBL, ALTURA_LBL);
		txtDocumento = new JTextField();
		txtDocumento.setBounds(POSICION_TXT, 500, ANCHO_TXT, ALTURA_LBL);

		lblTelefono = new JLabel("Número de telefono");
		lblTelefono.setBounds(POSICION_LBL, 560, ANCHO_LBL, ALTURA_LBL);
		txtTelefono = new JTextField();
		txtTelefono.setBounds(POSICION_TXT, 560, ANCHO_TXT, ALTURA_LBL);

		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(POSICION_LBL, 620, ANCHO_LBL, ALTURA_LBL);
		txtContrasenia = new JTextField();
		txtContrasenia.setBounds(POSICION_TXT, 620, ANCHO_TXT, ALTURA_LBL);

		btnActualizarUsuario = new JButton("Actualizar datos");
		btnActualizarUsuario.setBounds(655, 715, 148, 32);
		btnEliminarUsuario = new JButton("ELIMINAR CUENTA");
		btnEliminarUsuario.setBounds(55, 715, 148, 32);
		btnSeleccionarImagen = new JButton("Seleccionar imagen");
		btnSeleccionarImagen.setBounds(410, 715, 148, 32);

		this.add(lblTitulo);
		this.add(lblNombre2);
		this.add(lblEmail2);
		this.add(lblImagen);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblNombreUsuario);
		this.add(txtNombreUsuario);
		this.add(lblDocumento);
		this.add(txtDocumento);
		this.add(lblTelefono);
		this.add(txtTelefono);
		this.add(txtContrasenia);
		this.add(txtContrasenia);
		this.add(btnActualizarUsuario);
		this.add(btnEliminarUsuario);
		this.add(btnSeleccionarImagen);
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblNombre2() {
		return lblNombre2;
	}

	public void setLblNombre2(JLabel lblNombre2) {
		this.lblNombre2 = lblNombre2;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblEmail2() {
		return lblEmail2;
	}

	public void setLblEmail2(JLabel lblEmail2) {
		this.lblEmail2 = lblEmail2;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	public void setLblNombreUsuario(JLabel lblNombreUsuario) {
		this.lblNombreUsuario = lblNombreUsuario;
	}

	public JLabel getLblDocumento() {
		return lblDocumento;
	}

	public void setLblDocumento(JLabel lblDocumento) {
		this.lblDocumento = lblDocumento;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}

	public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
		this.txtNombreUsuario = txtNombreUsuario;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(JTextField txtDocumento) {
		this.txtDocumento = txtDocumento;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtContrasenia() {
		return txtContrasenia;
	}

	public void setTxtContrasenia(JTextField txtContrasenia) {
		this.txtContrasenia = txtContrasenia;
	}

	public JButton getBtnActualizarUsuario() {
		return btnActualizarUsuario;
	}

	public void setBtnActualizarUsuario(JButton btnActualizarUsuario) {
		this.btnActualizarUsuario = btnActualizarUsuario;
	}

	public JButton getBtnEliminarUsuario() {
		return btnEliminarUsuario;
	}

	public void setBtnEliminarUsuario(JButton btnEliminarUsuario) {
		this.btnEliminarUsuario = btnEliminarUsuario;
	}

	public JButton getBtnSeleccionarImagen() {
		return btnSeleccionarImagen;
	}

	public void setBtnSeleccionarImagen(JButton btnSeleccionarImagen) {
		this.btnSeleccionarImagen = btnSeleccionarImagen;
	}

}
