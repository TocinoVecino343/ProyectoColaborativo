package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSuperior extends JPanel {

	private JButton btnCategoria;
	private JButton btnVender;
	private JButton btnCarro;

	private JTextField txtFieldBuscador;

	public PanelSuperior() {
		this.setVisible(true);
		this.setBackground(Color.decode("#ffe600"));
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 150);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		btnCategoria = new JButton("Categorias");
		btnVender = new JButton("Vender");
		btnCarro = new JButton("Carrito 🛒");

		txtFieldBuscador = new JTextField();

		btnCategoria.setBounds(150, 90, 100, 30);
		btnVender.setBounds(800, 90, 100, 30);
		btnCarro.setBounds(1000, 90, 100, 30);

		txtFieldBuscador.setBounds(300, 20, 700, 40);
		txtFieldBuscador.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(btnCategoria);
		this.add(btnVender);
		this.add(btnCarro);
		this.add(txtFieldBuscador);
	}

}
