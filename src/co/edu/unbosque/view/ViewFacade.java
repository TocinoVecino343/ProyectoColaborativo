package co.edu.unbosque.view;

public class ViewFacade {

	private PanelSuperior panelSuperior;
	private PanelLogin panelLogin;
	private Ventana ventana;
	private PanelCrearAlimentoYBebida panelCrearAlimentoYBebida;
	private PanelCrearCelular panelCrearCelular;
	private PanelCrearConstruccion panelCrearConstruccion;
	private PanelCrearDeporteYFitness panelCDeporteYFitness;
	private PanelCrearElectrodomesticos panelCrearElectrodomesticos;
	private PanelCrearJuguete panelCrearJuguete;
	private PanelCrearMascota panelCrearMascota;
	private PanelCrearMedicamento panelCrearMedicamento;
	private PanelCrearProductoModa panelCrearProductoModa;
	private PanelCrearVehiculo panelCrearVehiculo;
	private PanelSeleccionarCategoria panelSeleccionarCategoria;
	private PanelPerfil panelPerfil;
	private PanelUsuario panelUsuario;
	private PanelMetodoDePago panelMetodoDePago;

	public ViewFacade() {
		panelSuperior = new PanelSuperior();
		panelLogin = new PanelLogin();
		ventana = new Ventana();
		panelCrearAlimentoYBebida = new PanelCrearAlimentoYBebida();
		panelCrearCelular = new PanelCrearCelular();
		panelCrearConstruccion = new PanelCrearConstruccion();
		panelCDeporteYFitness = new PanelCrearDeporteYFitness();
		panelCrearElectrodomesticos = new PanelCrearElectrodomesticos();
		panelCrearJuguete = new PanelCrearJuguete();
		panelCrearMascota = new PanelCrearMascota();
		panelCrearMedicamento = new PanelCrearMedicamento();
		panelCrearProductoModa = new PanelCrearProductoModa();
		panelCrearVehiculo = new PanelCrearVehiculo();
		panelSeleccionarCategoria = new PanelSeleccionarCategoria();
		panelPerfil = new PanelPerfil();
		panelUsuario = new PanelUsuario();
		panelMetodoDePago = new PanelMetodoDePago();
	}

	public PanelSuperior getPanelSuperior() {
		return panelSuperior;
	}

	public void setPanelSuperior(PanelSuperior panelSuperior) {
		this.panelSuperior = panelSuperior;
	}

	public PanelLogin getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(PanelLogin panelLogin) {
		this.panelLogin = panelLogin;
	}

	public Ventana getVentana() {
		return ventana;
	}

	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}

	public PanelCrearAlimentoYBebida getPanelCrearAlimentoYBebida() {
		return panelCrearAlimentoYBebida;
	}

	public void setPanelCrearAlimentoYBebida(PanelCrearAlimentoYBebida panelCrearAlimentoYBebida) {
		this.panelCrearAlimentoYBebida = panelCrearAlimentoYBebida;
	}

	public PanelCrearCelular getPanelCrearCelular() {
		return panelCrearCelular;
	}

	public void setPanelCrearCelular(PanelCrearCelular panelCrearCelular) {
		this.panelCrearCelular = panelCrearCelular;
	}

	public PanelCrearConstruccion getPanelCrearConstruccion() {
		return panelCrearConstruccion;
	}

	public void setPanelCrearConstruccion(PanelCrearConstruccion panelCrearConstruccion) {
		this.panelCrearConstruccion = panelCrearConstruccion;
	}

	public PanelCrearDeporteYFitness getPanelCDeporteYFitness() {
		return panelCDeporteYFitness;
	}

	public void setPanelCDeporteYFitness(PanelCrearDeporteYFitness panelCDeporteYFitness) {
		this.panelCDeporteYFitness = panelCDeporteYFitness;
	}

	public PanelCrearElectrodomesticos getPanelCrearElectrodomesticos() {
		return panelCrearElectrodomesticos;
	}

	public void setPanelCrearElectrodomesticos(PanelCrearElectrodomesticos paneCrearElectrodomesticos) {
		this.panelCrearElectrodomesticos = paneCrearElectrodomesticos;
	}

	public PanelCrearJuguete getPanelCrearJuguete() {
		return panelCrearJuguete;
	}

	public void setPanelCrearJuguete(PanelCrearJuguete panelCrearJuguete) {
		this.panelCrearJuguete = panelCrearJuguete;
	}

	public PanelCrearMascota getPanelCrearMascota() {
		return panelCrearMascota;
	}

	public void setPanelCrearMascota(PanelCrearMascota panelCrearMascota) {
		this.panelCrearMascota = panelCrearMascota;
	}

	public PanelCrearMedicamento getPanelCrearMedicamento() {
		return panelCrearMedicamento;
	}

	public void setPanelCrearMedicamento(PanelCrearMedicamento panelCrearMedicamento) {
		this.panelCrearMedicamento = panelCrearMedicamento;
	}

	public PanelCrearProductoModa getPanelCrearProductoModa() {
		return panelCrearProductoModa;
	}

	public void setPanelCrearProductoModa(PanelCrearProductoModa panelCrearProductoModa) {
		this.panelCrearProductoModa = panelCrearProductoModa;
	}

	public PanelCrearVehiculo getPanelCrearVehiculo() {
		return panelCrearVehiculo;
	}

	public void setPanelCrearVehiculo(PanelCrearVehiculo panelCrearVehiculo) {
		this.panelCrearVehiculo = panelCrearVehiculo;
	}

	public PanelSeleccionarCategoria getPanelSeleccionarCategoria() {
		return panelSeleccionarCategoria;
	}

	public void setPanelSeleccionarCategoria(PanelSeleccionarCategoria panelSeleccionarCategoria) {
		this.panelSeleccionarCategoria = panelSeleccionarCategoria;
	}

	public PanelPerfil getPanelPerfil() {
		return panelPerfil;
	}

	public void setPanelPerfil(PanelPerfil panelPerfil) {
		this.panelPerfil = panelPerfil;
	}

	public PanelUsuario getPanelUsuario() {
		return panelUsuario;
	}

	public void setPanelUsuario(PanelUsuario panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

	public PanelMetodoDePago getPanelMetodoDePago() {
		return panelMetodoDePago;
	}

	public void setPanelMetodoDePago(PanelMetodoDePago panelMetodoDePago) {
		this.panelMetodoDePago = panelMetodoDePago;
	}

}