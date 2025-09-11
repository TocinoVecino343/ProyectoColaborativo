package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.AlimentoYBebida;
import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.Construccion;
import co.edu.unbosque.model.DeporteYFitness;
import co.edu.unbosque.model.Electrodomestico;
import co.edu.unbosque.model.Farmacia;
import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.Mascota;
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
		// Crear

		vf.getVen().getPanelCv().getBtnCrearVehiculo().addActionListener(this);
		vf.getVen().getPanelCv().getBtnCrearVehiculo().setActionCommand("boton_crear_vehiculo");

		vf.getVen().getPanelCpm().getBtnCrearProductoModa().addActionListener(this);
		vf.getVen().getPanelCpm().getBtnCrearProductoModa().setActionCommand("boton_crear_producto_moda");

		vf.getVen().getPanelCmas.getBtnCrearProductoMascota().addActionListener(this);
		vf.getVen().getPanelCmas.getBtnCrearProductoMascota().setActionCommand("boton_crear_producto_mascota");

		vf.getVen().getPanelCpj.getBtnCrearProductoJuguete().addActionListener(this);
		vf.getVen().getPanelCpj.getBtnCrearProductoJuguete().setActionCommand("boton_crear_producto_juguete");

		vf.getVen().getPanelCpf.getBtnCrearProductoFarmacia().addActionListener(this);
		vf.getVen().getPanelCpf.getBtnCrearProductoFarmacia().setActionCommand("boton_crear_producto_farmacia");

		vf.getVen().getPanelCe.getBtnCrearProductoElectrodomestico().addActionListener(this);
		vf.getVen().getPanelCe.getBtnCrearProductoElectrodomestico().setActionCommand("boton_crear_electrodomestico");

		vf.getVen().getPanelCpd.getBtnCrearProductoDeporteYFitness().addActionListener(this);
		vf.getVen().getPanelCpd.getBtnCrearProductoDeporteYFitness()
				.setActionCommand("boton_crear_producto_deporteyfitness");

		vf.getVen().getPanelCcon.getBtnCrearProductoConstruccion().addActionListener(this);
		vf.getVen().getPanelCcon.getBtnCrearProductoConstruccion()
				.setActionCommand("boton_crear_producto_construccion");

		vf.getVen().getPanelCcel.getBtnCrearCelular().addActionListener(this);
		vf.getVen().getPanelCcel.getBtnCrearCelular().setActionCommand("boton_crear_celular");

		vf.getVen().getPanelCab.getBtnCrearProductoAlimentoYBebida().addActionListener(this);
		vf.getVen().getPanelCab.getBtnCrearProductoAlimentoYBebida()
				.setActionCommand("boton_crear_producto_alimentoybebida");

		// Actualizar

		vf.getVen().getPanelCv().getBtnCrearVehiculo().addActionListener(this);
		vf.getVen().getPanelCv().getBtnCrearVehiculo().setActionCommand("boton_actualizar_vehiculo");

		vf.getVen().getPanelCpm().getBtnCrearProductoModa().addActionListener(this);
		vf.getVen().getPanelCpm().getBtnCrearProductoModa().setActionCommand("boton_actualizar_producto_moda");

		vf.getVen().getPanelCmas.getBtnCrearProductoMascota().addActionListener(this);
		vf.getVen().getPanelCmas.getBtnCrearProductoMascota().setActionCommand("boton_actualizar_producto_mascota");

		vf.getVen().getPanelCpj.getBtnCrearProductoJuguete().addActionListener(this);
		vf.getVen().getPanelCpj.getBtnCrearProductoJuguete().setActionCommand("boton_actualizar_producto_juguete");

		vf.getVen().getPanelCpf.getBtnCrearProductoFarmacia().addActionListener(this);
		vf.getVen().getPanelCpf.getBtnCrearProductoFarmacia().setActionCommand("boton_actualizar_producto_farmacia");

		vf.getVen().getPanelCe.getBtnCrearProductoElectrodomestico().addActionListener(this);
		vf.getVen().getPanelCe.getBtnCrearProductoElectrodomestico()
				.setActionCommand("boton_actualizar_electrodomestico");

		vf.getVen().getPanelCpd.getBtnCrearProductoDeporteYFitness().addActionListener(this);
		vf.getVen().getPanelCpd.getBtnCrearProductoDeporteYFitness()
				.setActionCommand("boton_actualizar_producto_deporteyfitness");

		vf.getVen().getPanelCcon.getBtnCrearProductoConstruccion().addActionListener(this);
		vf.getVen().getPanelCcon.getBtnCrearProductoConstruccion()
				.setActionCommand("boton_actualizar_producto_construccion");

		vf.getVen().getPanelCcel.getBtnCrearCelular().addActionListener(this);
		vf.getVen().getPanelCcel.getBtnCrearCelular().setActionCommand("boton_actualizar_celular");

		vf.getVen().getPanelCab.getBtnCrearProductoAlimentoYBebida().addActionListener(this);
		vf.getVen().getPanelCab.getBtnCrearProductoAlimentoYBebida()
				.setActionCommand("boton_actualizar_producto_alimentoybebida");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();

		switch (alias) {

		// BOTONES PARA CREAR PRODUCTOS
		case "boton_crear_vehiculo": {
			String nombre = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCv().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCv().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCv().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCv().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCv().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtStock()));

			boolean esFinanciable = false;
			if (vf.getVen().getPanelCv().getCmbEsFinanciable().getSelectedItem().equals("Si")) {
				esFinanciable = true;
			}
			int kilometraje = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtKilometraje()));
			int anio = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getCmbAnio().getSelectedItem()));

			Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					esFinanciable, kilometraje, anio);

			mf.getVehiculoDAO().crear(temp);

			break;
		}

		case "boton_crear_producto_moda": {
			String nombre = String.valueOf(vf.getVen().getPanelCpm().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpm().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpm().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpm().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCpm().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpm().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpm().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCpm().getTxtColor());
			String talla = String.valueOf(vf.getVen().getPanelCpm().getTxtTalla());
			String material = String.valueOf(vf.getVen().getPanelCpm().getTxtMaterial());

			Moda temp = new Moda(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, color,
					talla, material);

			mf.getModaDAO().crear(temp);
			break;
		}

		case "boton_crear_producto_mascota": {
			String nombre = String.valueOf(vf.getVen().getPanelCmas().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCmas().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCmas().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCmas().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCmas().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCmas().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCmas().getTxtStock()));

			String tipoAnimal = String.valueOf(vf.getVen().getPanelCmas().getTxtTipoAnimal());
			String raza = String.valueOf(vf.getVen().getPanelCmas().getTxtRaza());
			String color = String.valueOf(vf.getVen().getPanelCmas().getTxtColor());
			String formatoDeVenta = String.valueOf(vf.getVen().getPanelCmas().getTxtFormatoDeVenta());

			Mascota temp = new Mascota(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					tipoAnimal, raza, color, formatoDeVenta);

			mf.getMascotaDAO().crear(temp);
			break;
		}

		case "boton_crear_producto_juguete": {
			String nombre = String.valueOf(vf.getVen().getPanelCpj().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpj().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpj().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpj().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCmas().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpj().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpj().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCpj().getTxtColor());
			String material = String.valueOf(vf.getVen().getPanelCpj().getTxtMaterial());
			String rangoDeEdad = String.valueOf(vf.getVen().getPanelCpj().getTxtRangoDeEdad());

			Juguete temp = new Juguete(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					color, material, rangoDeEdad);

			mf.getJugueteDAO().crear(temp);
			break;
		}

		case "boton_crear_producto_farmacia": {
			String nombre = String.valueOf(vf.getVen().getPanelCpf().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpf().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpf().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpf().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCpf().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpf().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpf().getTxtStock()));

			String laboratorio = String.valueOf(vf.getVen().getPanelCpf().getTxtLaboratorio());
			String formatoMedicamento = String.valueOf(vf.getVen().getPanelCpf().getTxtFormatoMedicamento());
			String formatoDeVenta = String.valueOf(vf.getVen().getPanelCpf().getTxtFormatoDeVenta());

			Farmacia temp = new Farmacia(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					laboratorio, formatoMedicamento, formatoDeVenta);

			mf.getFarmaciaDAO().crear(temp);
			break;
		}

		case "boton_crear_electrodomestico": {
			String nombre = String.valueOf(vf.getVen().getPanelCe().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCe().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCe().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCe().getTxtPrecio()));
			String Marca = String.valueOf(vf.getVen().getPanelCe().getCmbMarca().getSelectedItem());
			String Vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCe().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCe().getTxtStock()));

			String modelo = String.valueOf(vf.getVen().getPanelCe().getTxtModelo());
			int voltaje = Integer.parseInt(String.valueOf(vf.getVen().getPanelCe().getTxVoltaje()));
			String color = String.valueOf(vf.getVen().getPanelCe().getTxtColor());

			Electrodomestico temp = new Electrodomestico(nombre, descripcion, tipo, precio, Marca, Vendedor,
					caracteristicas, stock, modelo, voltaje, color);

			mf.getElectrodomesticoDAO().crear(temp);
			break;
		}

		case "boton_crear_producto_deporteyfitness": {
			String nombre = String.valueOf(vf.getVen().getPanelCpd().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpd().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpd().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpd().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCpd().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpd().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpd().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCpd().getTxtColor());
			String material = String.valueOf(vf.getVen().getPanelCpd().getTxtMaterial());

			DeporteYFitness temp = new DeporteYFitness(nombre, descripcion, tipo, precio, marca, vendedor,
					caracteristicas, stock, color, material);

			mf.getDeporteYFitnessDAO().crear(temp);
			break;
		}

		case "boton_crear_producto_construccion": {
			String nombre = String.valueOf(vf.getVen().getPanelCcon().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCcon().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCcon().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCcon().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCcon().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcon().getTxtStock()));

			String modelo = String.valueOf(vf.getVen().getPanelCcon().getTxtModelo());
			String material = String.valueOf(vf.getVen().getPanelCcon().getTxtMaterial());
			String color = String.valueOf(vf.getVen().getPanelCcon().getTxtColor());
			float largo = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtLargo()));
			float ancho = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtAncho()));
			float altura = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtAltura()));

			Construccion temp = new Construccion(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas,
					stock, modelo, material, color, largo, ancho, altura);

			mf.getConstruccionDAO().crear(temp);
			break;
		}

		case "boton_crear_celular": {
			String nombre = String.valueOf(vf.getVen().getPanelCcel().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCcel().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCcel().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCcel().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCcel().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCcel().getTxtColor());
			int memoriaInterna = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtMemoriaInterna));
			int memoriaRam = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtMemoriaRam()));
			float largoPantalla = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtLargoPantalla()));
			float anchoPantalla = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtAnchoPantalla()));
			float altoPantalla = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtAltoPantalla()));
			int camaraFrontal = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtCamaraInterna()));
			int camaraTrasera = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtCamaraTrasera()));
			boolean poseeNfc = false;
			if (vf.getVen().getPanelCcel().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
				poseeNfc = true;
			}

			Celular temp = new Celular(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					color, memoriaInterna, memoriaRam, largoPantalla, anchoPantalla, altoPantalla, camaraFrontal,
					camaraTrasera, poseeNfc);

			mf.getCelularDAO().crear(temp);

			break;
		}

		case "boton_crear_producto_alimentoybebida": {
			String nombre = String.valueOf(vf.getVen().getPanelCab().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCab().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCab().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCab().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCcel().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCab().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCab().getTxtStock()));

			boolean esLiquido = false;
			if (vf.getVen().getPanelCab().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
				esLiquido = true;
			}
			int cantidadProducto = Integer.parseInt(String.valueOf(vf.getVen().getPanelCab().getTxtCantidadProducto()));
			String tipoEnvase = String.valueOf(vf.getVen().getPanelCab().getTxtTipoEnvase());
			int unidadEnvase = Integer.parseInt(String.valueOf(vf.getVen().getPanelCab().getTxtunidadEnvase()));

			AlimentoYBebida temp = new AlimentoYBebida(nombre, descripcion, tipo, precio, marca, vendedor,
					caracteristicas, stock, esLiquido, cantidadProducto, tipoEnvase, unidadEnvase);

			mf.getAlimentoYBebidaDAO().crear(temp);

			break;
		}

		// BOTONES PARA ACTUALIZAR PRODUCTOS
		case "boton_actualizar_vehiculo": {

			String nombre = String.valueOf(vf.getVen().getPanelCv().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCv().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCv().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCv().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCv().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCv().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtStock()));

			boolean esFinanciable = false;
			if (vf.getVen().getPanelCv().getCmbEsFinanciable().getSelectedItem().equals("Si")) {
				esFinanciable = true;
			}
			int kilometraje = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getTxtKilometraje()));
			int anio = Integer.parseInt(String.valueOf(vf.getVen().getPanelCv().getCmbAnio().getSelectedItem()));

			Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					esFinanciable, kilometraje, anio);

			mf.getVehiculoDAO().crear(temp);

			break;
		}

		case "boton_actualizar_producto_moda": {
			String nombre = String.valueOf(vf.getVen().getPanelCpm().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpm().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpm().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpm().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCpm().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpm().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpm().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCpm().getTxtColor());
			String talla = String.valueOf(vf.getVen().getPanelCpm().getTxtTalla());
			String material = String.valueOf(vf.getVen().getPanelCpm().getTxtMaterial());

			Moda temp = new Moda(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, color,
					talla, material);

			mf.getModaDAO().crear(temp);
			break;
		}

		case "boton_actualizar_producto_mascota": {
			String nombre = String.valueOf(vf.getVen().getPanelCmas().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCmas().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCmas().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCmas().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCmas().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCmas().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCmas().getTxtStock()));

			String tipoAnimal = String.valueOf(vf.getVen().getPanelCmas().getTxtTipoAnimal());
			String raza = String.valueOf(vf.getVen().getPanelCmas().getTxtRaza());
			String color = String.valueOf(vf.getVen().getPanelCmas().getTxtColor());
			String formatoDeVenta = String.valueOf(vf.getVen().getPanelCmas().getTxtFormatoDeVenta());

			Mascota temp = new Mascota(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					tipoAnimal, raza, color, formatoDeVenta);

			mf.getMascotaDAO().crear(temp);
			break;
		}

		case "boton_actualizar_producto_juguete": {
			String nombre = String.valueOf(vf.getVen().getPanelCpj().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpj().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpj().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpj().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCmas().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpj().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpj().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCpj().getTxtColor());
			String material = String.valueOf(vf.getVen().getPanelCpj().getTxtMaterial());
			String rangoDeEdad = String.valueOf(vf.getVen().getPanelCpj().getTxtRangoDeEdad());

			Juguete temp = new Juguete(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					color, material, rangoDeEdad);

			mf.getJugueteDAO().crear(temp);
			break;
		}

		case "boton_actualizar_producto_farmacia": {
			String nombre = String.valueOf(vf.getVen().getPanelCpf().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpf().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpf().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpf().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCpf().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpf().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpf().getTxtStock()));

			String laboratorio = String.valueOf(vf.getVen().getPanelCpf().getTxtLaboratorio());
			String formatoMedicamento = String.valueOf(vf.getVen().getPanelCpf().getTxtFormatoMedicamento());
			String formatoDeVenta = String.valueOf(vf.getVen().getPanelCpf().getTxtFormatoDeVenta());

			Farmacia temp = new Farmacia(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					laboratorio, formatoMedicamento, formatoDeVenta);

			mf.getFarmaciaDAO().crear(temp);
			break;
		}

		case "boton_actualizar_electrodomestico": {
			String nombre = String.valueOf(vf.getVen().getPanelCe().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCe().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCe().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCe().getTxtPrecio()));
			String Marca = String.valueOf(vf.getVen().getPanelCe().getCmbMarca().getSelectedItem());
			String Vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCe().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCe().getTxtStock()));

			String modelo = String.valueOf(vf.getVen().getPanelCe().getTxtModelo());
			int voltaje = Integer.parseInt(String.valueOf(vf.getVen().getPanelCe().getTxVoltaje()));
			String color = String.valueOf(vf.getVen().getPanelCe().getTxtColor());

			Electrodomestico temp = new Electrodomestico(nombre, descripcion, tipo, precio, Marca, Vendedor,
					caracteristicas, stock, modelo, voltaje, color);

			mf.getElectrodomesticoDAO().crear(temp);
			break;
		}

		case "boton_actualizar_producto_deporteyfitness": {
			String nombre = String.valueOf(vf.getVen().getPanelCpd().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCpd().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCpd().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCpd().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCpd().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCpd().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCpd().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCpd().getTxtColor());
			String material = String.valueOf(vf.getVen().getPanelCpd().getTxtMaterial());

			DeporteYFitness temp = new DeporteYFitness(nombre, descripcion, tipo, precio, marca, vendedor,
					caracteristicas, stock, color, material);

			mf.getDeporteYFitnessDAO().crear(temp);
			break;
		}

		case "boton_actualizar_producto_construccion": {
			String nombre = String.valueOf(vf.getVen().getPanelCcon().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCcon().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCcon().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCcon().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCcon().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcon().getTxtStock()));

			String modelo = String.valueOf(vf.getVen().getPanelCcon().getTxtModelo());
			String material = String.valueOf(vf.getVen().getPanelCcon().getTxtMaterial());
			String color = String.valueOf(vf.getVen().getPanelCcon().getTxtColor());
			float largo = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtLargo()));
			float ancho = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtAncho()));
			float altura = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcon().getTxtAltura()));

			Construccion temp = new Construccion(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas,
					stock, modelo, material, color, largo, ancho, altura);

			mf.getConstruccionDAO().crear(temp);
			break;
		}

		case "boton_actualizar_celular": {
			String nombre = String.valueOf(vf.getVen().getPanelCcel().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCcel().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCcel().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCcel().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCcel().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtStock()));

			String color = String.valueOf(vf.getVen().getPanelCcel().getTxtColor());
			int memoriaInterna = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtMemoriaInterna));
			int memoriaRam = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtMemoriaRam()));
			float largoPantalla = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtLargoPantalla()));
			float anchoPantalla = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtAnchoPantalla()));
			float altoPantalla = Float.parseFloat(String.valueOf(vf.getVen().getPanelCcel().getTxtAltoPantalla()));
			int camaraFrontal = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtCamaraInterna()));
			int camaraTrasera = Integer.parseInt(String.valueOf(vf.getVen().getPanelCcel().getTxtCamaraTrasera()));
			boolean poseeNfc = false;
			if (vf.getVen().getPanelCcel().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
				poseeNfc = true;
			}

			Celular temp = new Celular(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
					color, memoriaInterna, memoriaRam, largoPantalla, anchoPantalla, altoPantalla, camaraFrontal,
					camaraTrasera, poseeNfc);

			mf.getCelularDAO().crear(temp);

			break;
		}

		case "boton_actualizar_producto_alimentoybebida": {
			String nombre = String.valueOf(vf.getVen().getPanelCab().getTxtNombre());
			String descripcion = String.valueOf(vf.getVen().getPanelCab().getTxtDescripcion());
			String tipo = String.valueOf(vf.getVen().getPanelCab().getCmbTipo().getSelectedItem());
			float precio = Float.parseFloat(String.valueOf(vf.getVen().getPanelCab().getTxtPrecio()));
			String marca = String.valueOf(vf.getVen().getPanelCcel().getCmbMarca().getSelectedItem());
			String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP"; // ARREGLAR A FUTURO
			String caracteristicas = String.valueOf(vf.getVen().getPanelCab().getTxtCaracteristicas());
			int stock = Integer.parseInt(String.valueOf(vf.getVen().getPanelCab().getTxtStock()));

			boolean esLiquido = false;
			if (vf.getVen().getPanelCab().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
				esLiquido = true;
			}
			int cantidadProducto = Integer.parseInt(String.valueOf(vf.getVen().getPanelCab().getTxtCantidadProducto()));
			String tipoEnvase = String.valueOf(vf.getVen().getPanelCab().getTxtTipoEnvase());
			int unidadEnvase = Integer.parseInt(String.valueOf(vf.getVen().getPanelCab().getTxtunidadEnvase()));

			AlimentoYBebida temp = new AlimentoYBebida(nombre, descripcion, tipo, precio, marca, vendedor,
					caracteristicas, stock, esLiquido, cantidadProducto, tipoEnvase, unidadEnvase);

			mf.getAlimentoYBebidaDAO().crear(temp);

			break;
		}
		}
	}
}
