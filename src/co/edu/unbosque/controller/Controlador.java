package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controlador implements ActionListener {

    private ViewFacade vf;
    private ModelFacade mf;

    public Controlador() {
        this.vf = new ViewFacade(this);
        this.mf = new ModelFacade();
    }

    public void runGui() {
        vf.showLogin();
    }

    public void onLoginSuccess() {
        vf.showMain();
        
        inicializarOyentesSuperior();
    }

    private void inicializarOyentesSuperior() {
        vf.getMainVentana().getPanelS().getBtnCategoria().addActionListener(this);
        vf.getMainVentana().getPanelS().getBtnCategoria().setActionCommand("boton_categoria");

        vf.getMainVentana().getPanelS().getBtnVender().addActionListener(this);
        vf.getMainVentana().getPanelS().getBtnVender().setActionCommand("boton_vender");

        vf.getMainVentana().getPanelS().getBtnCarro().addActionListener(this);
        vf.getMainVentana().getPanelS().getBtnCarro().setActionCommand("boton_carrito");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "boton_categoria":
                System.out.println("Botón Categorías presionado");
                break;

            case "boton_vender":
                System.out.println("Botón Vender presionado");
                break;

            case "boton_carrito":
                System.out.println("Botón Carrito presionado");
                break;
        }
    }
}
   /* public void inicializarOyentes() {
        // Crear
        vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().addActionListener(this);
        vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().setActionCommand("boton_crear_vehiculo");

        vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().addActionListener(this);
        vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().setActionCommand("boton_crear_producto_moda");

        vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().addActionListener(this);
        vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().setActionCommand("boton_crear_producto_mascota");

        vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().addActionListener(this);
        vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().setActionCommand("boton_crear_producto_juguete");

        vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().addActionListener(this);
        vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().setActionCommand("boton_crear_producto_farmacia");

        vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico().addActionListener(this);
        vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico().setActionCommand("boton_crear_electrodomestico");

        vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness().addActionListener(this);
        vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness()
                .setActionCommand("boton_crear_producto_deporteyfitness");

        vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion().addActionListener(this);
        vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion()
                .setActionCommand("boton_crear_producto_construccion");

        vf.getMainVentana().getPanelCcel.getBtnCrearCelular().addActionListener(this);
        vf.getMainVentana().getPanelCcel.getBtnCrearCelular().setActionCommand("boton_crear_celular");

        vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida().addActionListener(this);
        vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida()
                .setActionCommand("boton_crear_producto_alimentoybebida");

        // Actualizar
        vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().addActionListener(this);
        vf.getMainVentana().getPanelCv().getBtnCrearVehiculo().setActionCommand("boton_actualizar_vehiculo");

        vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().addActionListener(this);
        vf.getMainVentana().getPanelCpm().getBtnCrearProductoModa().setActionCommand("boton_actualizar_producto_moda");

        vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().addActionListener(this);
        vf.getMainVentana().getPanelCmas.getBtnCrearProductoMascota().setActionCommand("boton_actualizar_producto_mascota");

        vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().addActionListener(this);
        vf.getMainVentana().getPanelCpj.getBtnCrearProductoJuguete().setActionCommand("boton_actualizar_producto_juguete");

        vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().addActionListener(this);
        vf.getMainVentana().getPanelCpf.getBtnCrearProductoFarmacia().setActionCommand("boton_actualizar_producto_farmacia");

        vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico().addActionListener(this);
        vf.getMainVentana().getPanelCe.getBtnCrearProductoElectrodomestico()
                .setActionCommand("boton_actualizar_electrodomestico");

        vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness().addActionListener(this);
        vf.getMainVentana().getPanelCpd.getBtnCrearProductoDeporteYFitness()
                .setActionCommand("boton_actualizar_producto_deporteyfitness");

        vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion().addActionListener(this);
        vf.getMainVentana().getPanelCcon.getBtnCrearProductoConstruccion()
                .setActionCommand("boton_actualizar_producto_construccion");

        vf.getMainVentana().getPanelCcel.getBtnCrearCelular().addActionListener(this);
        vf.getMainVentana().getPanelCcel.getBtnCrearCelular().setActionCommand("boton_actualizar_celular");

        vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida().addActionListener(this);
        vf.getMainVentana().getPanelCab.getBtnCrearProductoAlimentoYBebida()
                .setActionCommand("boton_actualizar_producto_alimentoybebida");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String alias = e.getActionCommand();

        switch (alias) {

        // BOTONES PARA CREAR PRODUCTOS
        case "boton_crear_vehiculo": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCv().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCv().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCv().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCv().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCv().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCv().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getTxtStock()));

            boolean esFinanciable = false;
            if (vf.getMainVentana().getPanelCv().getCmbEsFinanciable().getSelectedItem().equals("Si")) {
                esFinanciable = true;
            }
            int kilometraje = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getTxtKilometraje()));
            int anio = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getCmbAnio().getSelectedItem()));

            Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    esFinanciable, kilometraje, anio);

            mf.getVehiculoDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_moda": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpm().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpm().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCpm().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpm().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtColor());
            String talla = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtTalla());
            String material = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtMaterial());

            Moda temp = new Moda(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, color,
                    talla, material);

            mf.getModaDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_mascota": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCmas().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCmas().getTxtStock()));

            String tipoAnimal = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtTipoAnimal());
            String raza = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtRaza());
            String color = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtColor());
            String formatoDeVenta = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtFormatoDeVenta());

            Mascota temp = new Mascota(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    tipoAnimal, raza, color, formatoDeVenta);

            mf.getMascotaDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_juguete": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpj().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpj().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpj().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtColor());
            String material = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtMaterial());
            String rangoDeEdad = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtRangoDeEdad());

            Juguete temp = new Juguete(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    color, material, rangoDeEdad);

            mf.getJugueteDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_farmacia": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpf().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpf().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCpf().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpf().getTxtStock()));

            String laboratorio = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtLaboratorio());
            String formatoMedicamento = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoMedicamento());
            String formatoDeVenta = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoDeVenta());

            Farmacia temp = new Farmacia(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    laboratorio, formatoMedicamento, formatoDeVenta);

            mf.getFarmaciaDAO().crear(temp);
            break;
        }

        case "boton_crear_electrodomestico": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCe().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCe().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCe().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCe().getTxtPrecio()));
            String Marca = String.valueOf(vf.getMainVentana().getPanelCe().getCmbMarca().getSelectedItem());
            String Vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCe().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxtStock()));

            String modelo = String.valueOf(vf.getMainVentana().getPanelCe().getTxtModelo());
            int voltaje = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxVoltaje()));
            String color = String.valueOf(vf.getMainVentana().getPanelCe().getTxtColor());

            Electrodomestico temp = new Electrodomestico(nombre, descripcion, tipo, precio, Marca, Vendedor,
                    caracteristicas, stock, modelo, voltaje, color);

            mf.getElectrodomesticoDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_deporteyfitness": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpd().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpd().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCpd().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpd().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtColor());
            String material = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtMaterial());

            DeporteYFitness temp = new DeporteYFitness(nombre, descripcion, tipo, precio, marca, vendedor,
                    caracteristicas, stock, color, material);

            mf.getDeporteYFitnessDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_construccion": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCcon().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCcon().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtStock()));

            String modelo = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtModelo());
            String material = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtMaterial());
            String color = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtColor());
            float largo = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtLargo()));
            float ancho = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtAncho()));
            float altura = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtAltura()));

            Construccion temp = new Construccion(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas,
                    stock, modelo, material, color, largo, ancho, altura);

            mf.getConstruccionDAO().crear(temp);
            break;
        }

        case "boton_crear_celular": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtColor());
            int memoriaInterna = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtMemoriaInterna));
            int memoriaRam = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtMemoriaRam()));
            float largoPantalla = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtLargoPantalla()));
            float anchoPantalla = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtAnchoPantalla()));
            float altoPantalla = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtAltoPantalla()));
            int camaraFrontal = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCamaraInterna()));
            int camaraTrasera = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCamaraTrasera()));
            boolean poseeNfc = false;
            if (vf.getMainVentana().getPanelCcel().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
                poseeNfc = true;
            }

            Celular temp = new Celular(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    color, memoriaInterna, memoriaRam, largoPantalla, anchoPantalla, altoPantalla, camaraFrontal,
                    camaraTrasera, poseeNfc);

            mf.getCelularDAO().crear(temp);
            break;
        }

        case "boton_crear_producto_alimentoybebida": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCab().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCab().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCab().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCab().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCab().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtStock()));

            boolean esLiquido = false;
            if (vf.getMainVentana().getPanelCab().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
                esLiquido = true;
            }
            int cantidadProducto = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtCantidadProducto()));
            String tipoEnvase = String.valueOf(vf.getMainVentana().getPanelCab().getTxtTipoEnvase());
            int unidadEnvase = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtunidadEnvase()));

            AlimentoYBebida temp = new AlimentoYBebida(nombre, descripcion, tipo, precio, marca, vendedor,
                    caracteristicas, stock, esLiquido, cantidadProducto, tipoEnvase, unidadEnvase);

            mf.getAlimentoYBebidaDAO().crear(temp);
            break;
        }

        // BOTONES PARA ACTUALIZAR PRODUCTOS
        case "boton_actualizar_vehiculo": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCv().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCv().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCv().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCv().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCv().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCv().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getTxtStock()));

            boolean esFinanciable = false;
            if (vf.getMainVentana().getPanelCv().getCmbEsFinanciable().getSelectedItem().equals("Si")) {
                esFinanciable = true;
            }
            int kilometraje = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getTxtKilometraje()));
            int anio = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCv().getCmbAnio().getSelectedItem()));

            Vehiculo temp = new Vehiculo(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    esFinanciable, kilometraje, anio);

            mf.getVehiculoDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_moda": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpm().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpm().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCpm().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpm().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtColor());
            String talla = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtTalla());
            String material = String.valueOf(vf.getMainVentana().getPanelCpm().getTxtMaterial());

            Moda temp = new Moda(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, color,
                    talla, material);

            mf.getModaDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_mascota": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCmas().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCmas().getTxtStock()));

            String tipoAnimal = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtTipoAnimal());
            String raza = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtRaza());
            String color = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtColor());
            String formatoDeVenta = String.valueOf(vf.getMainVentana().getPanelCmas().getTxtFormatoDeVenta());

            Mascota temp = new Mascota(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    tipoAnimal, raza, color, formatoDeVenta);

            mf.getMascotaDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_juguete": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpj().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpj().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCmas().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpj().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtColor());
            String material = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtMaterial());
            String rangoDeEdad = String.valueOf(vf.getMainVentana().getPanelCpj().getTxtRangoDeEdad());

            Juguete temp = new Juguete(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    color, material, rangoDeEdad);

            mf.getJugueteDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_farmacia": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpf().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpf().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCpf().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpf().getTxtStock()));

            String laboratorio = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtLaboratorio());
            String formatoMedicamento = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoMedicamento());
            String formatoDeVenta = String.valueOf(vf.getMainVentana().getPanelCpf().getTxtFormatoDeVenta());

            Farmacia temp = new Farmacia(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    laboratorio, formatoMedicamento, formatoDeVenta);

            mf.getFarmaciaDAO().crear(temp);
            break;
        }

        case "boton_actualizar_electrodomestico": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCe().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCe().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCe().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCe().getTxtPrecio()));
            String Marca = String.valueOf(vf.getMainVentana().getPanelCe().getCmbMarca().getSelectedItem());
            String Vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCe().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxtStock()));

            String modelo = String.valueOf(vf.getMainVentana().getPanelCe().getTxtModelo());
            int voltaje = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCe().getTxVoltaje()));
            String color = String.valueOf(vf.getMainVentana().getPanelCe().getTxtColor());

            Electrodomestico temp = new Electrodomestico(nombre, descripcion, tipo, precio, Marca, Vendedor,
                    caracteristicas, stock, modelo, voltaje, color);

            mf.getElectrodomesticoDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_deporteyfitness": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCpd().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCpd().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCpd().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCpd().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtColor());
            String material = String.valueOf(vf.getMainVentana().getPanelCpd().getTxtMaterial());

            DeporteYFitness temp = new DeporteYFitness(nombre, descripcion, tipo, precio, marca, vendedor,
                    caracteristicas, stock, color, material);

            mf.getDeporteYFitnessDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_construccion": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCcon().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCcon().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtStock()));

            String modelo = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtModelo());
            String material = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtMaterial());
            String color = String.valueOf(vf.getMainVentana().getPanelCcon().getTxtColor());
            float largo = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtLargo()));
            float ancho = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtAncho()));
            float altura = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcon().getTxtAltura()));

            Construccion temp = new Construccion(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas,
                    stock, modelo, material, color, largo, ancho, altura);

            mf.getConstruccionDAO().crear(temp);
            break;
        }

        case "boton_actualizar_celular": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtStock()));

            String color = String.valueOf(vf.getMainVentana().getPanelCcel().getTxtColor());
            int memoriaInterna = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtMemoriaInterna));
            int memoriaRam = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtMemoriaRam()));
            float largoPantalla = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtLargoPantalla()));
            float anchoPantalla = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtAnchoPantalla()));
            float altoPantalla = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtAltoPantalla()));
            int camaraFrontal = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCamaraInterna()));
            int camaraTrasera = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCcel().getTxtCamaraTrasera()));
            boolean poseeNfc = false;
            if (vf.getMainVentana().getPanelCcel().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
                poseeNfc = true;
            }

            Celular temp = new Celular(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock,
                    color, memoriaInterna, memoriaRam, largoPantalla, anchoPantalla, altoPantalla, camaraFrontal,
                    camaraTrasera, poseeNfc);

            mf.getCelularDAO().crear(temp);
            break;
        }

        case "boton_actualizar_producto_alimentoybebida": {
            String nombre = String.valueOf(vf.getMainVentana().getPanelCab().getTxtNombre());
            String descripcion = String.valueOf(vf.getMainVentana().getPanelCab().getTxtDescripcion());
            String tipo = String.valueOf(vf.getMainVentana().getPanelCab().getCmbTipo().getSelectedItem());
            float precio = Float.parseFloat(String.valueOf(vf.getMainVentana().getPanelCab().getTxtPrecio()));
            String marca = String.valueOf(vf.getMainVentana().getPanelCcel().getCmbMarca().getSelectedItem());
            String vendedor = "CONFIGURAR PARA QUE SEA EL MISMO DEL USUARIO USANDO LA APP";
            String caracteristicas = String.valueOf(vf.getMainVentana().getPanelCab().getTxtCaracteristicas());
            int stock = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtStock()));

            boolean esLiquido = false;
            if (vf.getMainVentana().getPanelCab().getCmbPoseeNfc().getSelectedItem().equals("Si")) {
                esLiquido = true;
            }
            int cantidadProducto = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtCantidadProducto()));
            String tipoEnvase = String.valueOf(vf.getMainVentana().getPanelCab().getTxtTipoEnvase());
            int unidadEnvase = Integer.parseInt(String.valueOf(vf.getMainVentana().getPanelCab().getTxtunidadEnvase()));

            AlimentoYBebida temp = new AlimentoYBebida(nombre, descripcion, tipo, precio, marca, vendedor,
                    caracteristicas, stock, esLiquido, cantidadProducto, tipoEnvase, unidadEnvase);

            mf.getAlimentoYBebidaDAO().crear(temp);
            break;
        }
        }
    }
}*/