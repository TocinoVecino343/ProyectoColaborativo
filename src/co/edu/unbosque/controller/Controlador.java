package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.view.ViewFacade;

public class Controlador implements ActionListener {

	private ViewFacade vf;
	private ModelFacade mf;

	Controlador() {
		vf = new ViewFacade();
		mf = new ModelFacade();
	}

	public void runGui() {

	}

	public void inicializarOyentes() {
		vf.getVen().getPanelCv().getBtnCrearVehiculo().addActionListener(null);
		vf.getVen().getPanelCv().getBtnCrearVehiculo().setActionCommand("boton_crear_vehiculo");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();

		switch (alias) {

		case "boton_crear_vehiculo": {
			String nombre = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCv().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCv().getTxtTipo());
			float Precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCv().getTxtPrecio()));
			String Marca = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String Vendedor = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String caracteristicas = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtNombre()));
			boolean esFinanciable = Boolean.valueOf(String.valueOf(vf.getVen().getPanelCv().getTxtNombre()));
			int kilometraje = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtNombre()));

			Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, Precio, Marca, Vendedor, caracteristicas, stock,
					esFinanciable, kilometraje);

			mf.getVehiculoDAO().crear(temp);

			break;
		}
		}

	}
}
