package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelSeleccionarCategoria extends JPanel {
    private JButton btnAlimentoYBebida, btnCelular, btnConstruccion, btnDeporteYFitness,
                    btnElectrodomesticos, btnJuguete, btnMascota, btnMedicamento,
                    btnModa, btnVehiculo;

    public PanelSeleccionarCategoria() {
        this.setBackground(Color.decode("#f8f9fa"));
        this.setLayout(new GridLayout(5, 2, 20, 20));
        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        btnAlimentoYBebida = new JButton("Alimentos y Bebidas");
        btnAlimentoYBebida.setActionCommand("Alimentos y Bebidas");

        btnCelular = new JButton("Celulares");
        btnCelular.setActionCommand("Celulares");

        btnConstruccion = new JButton("Construcción");
        btnConstruccion.setActionCommand("Construcción");

        btnDeporteYFitness = new JButton("Deporte y Fitness");
        btnDeporteYFitness.setActionCommand("Deporte y Fitness");

        btnElectrodomesticos = new JButton("Electrodomésticos");
        btnElectrodomesticos.setActionCommand("Electrodomésticos");

        btnJuguete = new JButton("Juguetes");
        btnJuguete.setActionCommand("Juguetes");

        btnMascota = new JButton("Mascotas");
        btnMascota.setActionCommand("Mascotas");

        btnMedicamento = new JButton("Medicamentos");
        btnMedicamento.setActionCommand("Medicamentos");

        btnModa = new JButton("Moda");
        btnModa.setActionCommand("Moda");

        btnVehiculo = new JButton("Vehículos");
        btnVehiculo.setActionCommand("Vehículos");

        for (JButton btn : new JButton[]{btnAlimentoYBebida, btnCelular, btnConstruccion, btnDeporteYFitness,
                btnElectrodomesticos, btnJuguete, btnMascota, btnMedicamento, btnModa, btnVehiculo}) {
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.setPreferredSize(new Dimension(200, 60));
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
            btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
        }

        add(btnAlimentoYBebida); add(btnCelular);
        add(btnConstruccion); add(btnDeporteYFitness);
        add(btnElectrodomesticos); add(btnJuguete);
        add(btnMascota); add(btnMedicamento);
        add(btnModa); add(btnVehiculo);
    }
	public JButton getBtnAlimentoYBebida() {
		return btnAlimentoYBebida;
	}

	public void setBtnAlimentoYBebida(JButton btnAlimentoYBebida) {
		this.btnAlimentoYBebida = btnAlimentoYBebida;
	}

	public JButton getBtnCelular() {
		return btnCelular;
	}

	public void setBtnCelular(JButton btnCelular) {
		this.btnCelular = btnCelular;
	}

	public JButton getBtnConstruccion() {
		return btnConstruccion;
	}

	public void setBtnConstruccion(JButton btnConstruccion) {
		this.btnConstruccion = btnConstruccion;
	}

	public JButton getBtnDeporteYFitness() {
		return btnDeporteYFitness;
	}

	public void setBtnDeporteYFitness(JButton btnDeporteYFitness) {
		this.btnDeporteYFitness = btnDeporteYFitness;
	}

	public JButton getBtnElectrodomesticos() {
		return btnElectrodomesticos;
	}

	public void setBtnElectrodomesticos(JButton btnElectrodomesticos) {
		this.btnElectrodomesticos = btnElectrodomesticos;
	}

	public JButton getBtnJuguete() {
		return btnJuguete;
	}

	public void setBtnJuguete(JButton btnJuguete) {
		this.btnJuguete = btnJuguete;
	}

	public JButton getBtnMascota() {
		return btnMascota;
	}

	public void setBtnMascota(JButton btnMascota) {
		this.btnMascota = btnMascota;
	}

	public JButton getBtnMedicamento() {
		return btnMedicamento;
	}

	public void setBtnMedicamento(JButton btnMedicamento) {
		this.btnMedicamento = btnMedicamento;
	}

	public JButton getBtnModa() {
		return btnModa;
	}

	public void setBtnModa(JButton btnModa) {
		this.btnModa = btnModa;
	}

	public JButton getBtnVehiculo() {
		return btnVehiculo;
	}

	public void setBtnVehiculo(JButton btnVehiculo) {
		this.btnVehiculo = btnVehiculo;
	}

}