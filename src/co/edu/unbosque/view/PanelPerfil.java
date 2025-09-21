package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPerfil extends JPanel {

	private JLabel lblImagenPerfil, lblNombre, lblEmail;
	private JButton btnUsuario, btnMetodoDePago;

	private final Color COLOR_FONDO = new Color(235, 235, 235);
	private final int POSICION_LBL = 410;
	private final int ANCHO_LBL = 148;
	private final int ALTURA_LBL = 32;
	private final int POSICION_TXT = 590;
	private final int ANCHO_TXT = 284;

	public PanelPerfil() {
		this.setVisible(true);
		this.setBackground(COLOR_FONDO);
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 800);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		lblNombre = new JLabel();
		lblNombre.setBounds(615, 138, 260, 32);
		lblEmail = new JLabel();
		lblEmail.setBounds(615, 192, 260, 32);
		lblImagenPerfil = new JLabel();
		lblImagenPerfil.setBounds(POSICION_LBL, 178, 112, 150);

		btnUsuario = new JButton("Datos de tu cuenta");
		btnUsuario.setBounds(290, 305, 300, 150);
		btnMetodoDePago = new JButton("Metodo de pago");
		btnMetodoDePago.setBounds(637, 305, 300, 150);

		this.add(lblNombre);
		this.add(lblEmail);
		this.add(lblImagenPerfil);
		this.add(btnUsuario);
		this.add(btnMetodoDePago);
	}

	public JLabel getLblImagenPerfil() {
		return lblImagenPerfil;
	}

	public void setLblImagenPerfil(JLabel lblImagenPerfil) {
		this.lblImagenPerfil = lblImagenPerfil;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JButton getBtnUsuario() {
		return btnUsuario;
	}

	public void setBtnUsuario(JButton btnUsuario) {
		this.btnUsuario = btnUsuario;
	}

	public JButton getBtnMetodoDePago() {
		return btnMetodoDePago;
	}

	public void setBtnMetodoDePago(JButton btnMetodoDePago) {
		this.btnMetodoDePago = btnMetodoDePago;
	}
	
}
