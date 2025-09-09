package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Moda;
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
		vf.getVen().getPanelCv().getBtnCrearVehiculo().addActionListener(this);
		vf.getVen().getPanelCv().getBtnCrearVehiculo().setActionCommand("boton_crear_vehiculo");

		vf.getVen().getPanelCpm().getBtnCrearProductoModa().addActionListener(this);
		vf.getVen().getPanelCpm().getBtnCrearProductoModa().setActionCommand("boton_crear_producto_moda");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();

		switch (alias) {

		// BOTONES PARA CREAR PRODUCTOS
		case "boton_crear_vehiculo": {
			String nombre = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCv().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCv().getTxtTipo());
			float Precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCv().getTxtPrecio()));
			String Marca = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String Vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtStock()));
			boolean esFinanciable = Boolean.valueOf(String.valueOf(vf.getVen().getPanelCv().getTxtNombre()));
			int kilometraje = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtNombre()));
			int anio = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getCmbAnio().getSelectedItem()));

			Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, Precio, Marca, Vendedor, caracteristicas, stock,
					esFinanciable, kilometraje, anio);

			mf.getVehiculoDAO().crear(temp);

			break;
		}

		case "boton_crear_producto_moda": {
			String nombre = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCv().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCv().getTxtTipo());
			float Precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCv().getTxtPrecio()));
			String Marca = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String Vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtStock()));
			String color = String.valueOf(vf.getVen().getPanelCpm().getTxtColor());
			String talla = String.valueOf(vf.getVen().getPanelCpm().getTxtTalla());
			String material = String.valueOf(vf.getVen().getPanelCpm().getTxtMaterial());

			Moda temp = new Moda(nombre, descripcion, tipo, Precio, Marca, Vendedor, caracteristicas, stock, color,
					talla, material);

			mf.getModaDAO().crear(temp);
			break;
		}

		}

	}
}
