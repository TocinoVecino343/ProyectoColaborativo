package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	private PanelSuperior panelS;
	private PanelCrearVehiculo panelCv;
	private PanelCrearProductoModa panelCpm;

	Ventana() {
		this.setVisible(true);
		panelS = new PanelSuperior();
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		this.setTitle("Mercado Libre");
		this.setBounds(0, 0, 1280, 920);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Finaliza el programa completamente
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout(10, 10));
		this.getContentPane().add(panelS, BorderLayout.NORTH);

	}

	public PanelSuperior getPanelS() {
		return panelS;
	}

	public void setPanelS(PanelSuperior panelS) {
		this.panelS = panelS;
	}

	public PanelCrearVehiculo getPanelCv() {
		return panelCv;
	}

	public void setPanelCv(PanelCrearVehiculo panelCv) {
		this.panelCv = panelCv;
	}

	public PanelCrearProductoModa getPanelCpm() {
		return panelCpm;
	}

	public void setPanelCpm(PanelCrearProductoModa panelCpm) {
		this.panelCpm = panelCpm;
	}

}
