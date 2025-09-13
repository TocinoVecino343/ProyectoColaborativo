package co.edu.unbosque.model;

public class Farmacia extends Producto {

	private static final long serialVersionUID = -7927239735946763076L;
	private String laboratorio;
	private String formatoMedicamento;
	private String formatoDeVenta;

	public Farmacia() {
		super();
	}

	public Farmacia(String laboratorio, String formatoMedicamento, String formatoDeVenta) {
		super();
		this.laboratorio = laboratorio;
		this.formatoMedicamento = formatoMedicamento;
		this.formatoDeVenta = formatoDeVenta;
	}

	public Farmacia(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, int idAsociado, String laboratorio, String formatoMedicamento,
			String formatoDeVenta) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado);
		this.laboratorio = laboratorio;
		this.formatoMedicamento = formatoMedicamento;
		this.formatoDeVenta = formatoDeVenta;
	}

	public Farmacia(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, int idAsociado) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado);
		// TODO Auto-generated constructor stub
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getFormatoMedicamento() {
		return formatoMedicamento;
	}

	public void setFormatoMedicamento(String formatoMedicamento) {
		this.formatoMedicamento = formatoMedicamento;
	}

	public String getFormatoDeVenta() {
		return formatoDeVenta;
	}

	public void setFormatoDeVenta(String formatoDeVenta) {
		this.formatoDeVenta = formatoDeVenta;
	}

	@Override
	public String toString() {
		return "Farmacia [" + super.toString() + ", laboratorio=" + laboratorio + ", formatoMedicamento="
				+ formatoMedicamento + ", formatoDeVenta=" + formatoDeVenta + "]";
	}
}
