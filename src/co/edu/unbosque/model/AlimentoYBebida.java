package co.edu.unbosque.model;

public class AlimentoYBebida extends Producto {

	private static final long serialVersionUID = 4020600054540463285L;
	private boolean esLiquido;
	private int cantidadProducto;
	private String tipoEnvase;
	private int unidadEnvase;

	public AlimentoYBebida() {
		super();
	}

	public AlimentoYBebida(boolean esLiquido, int cantidadProducto, String tipoEnvase, int unidadEnvase) {
		super();
		this.esLiquido = esLiquido;
		this.cantidadProducto = cantidadProducto;
		this.tipoEnvase = tipoEnvase;
		this.unidadEnvase = unidadEnvase;
	}

	public AlimentoYBebida(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, int idAsociado, boolean esLiquido, int cantidadProducto,
			String tipoEnvase, int unidadEnvase) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado);
		this.esLiquido = esLiquido;
		this.cantidadProducto = cantidadProducto;
		this.tipoEnvase = tipoEnvase;
		this.unidadEnvase = unidadEnvase;
	}

	public AlimentoYBebida(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, int idAsociado) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsLiquido() {
		return esLiquido;
	}

	public void setEsLiquido(boolean esLiquido) {
		this.esLiquido = esLiquido;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getTipoEnvase() {
		return tipoEnvase;
	}

	public void setTipoEnvase(String tipoEnvase) {
		this.tipoEnvase = tipoEnvase;
	}

	public int getUnidadEnvase() {
		return unidadEnvase;
	}

	public void setUnidadEnvase(int unidadesEnvase) {
		this.unidadEnvase = unidadesEnvase;
	}

	@Override
	public String toString() {
		return "AlimentosYBebidas [" + super.toString() + ", esLiquido=" + esLiquido + ", cantidadProducto="
				+ cantidadProducto + ", tipoEnvase=" + tipoEnvase + ", unidadesEnvase=" + unidadEnvase + "]";
	}
}
