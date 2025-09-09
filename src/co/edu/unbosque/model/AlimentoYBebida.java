package co.edu.unbosque.model;

public class AlimentoYBebida extends Producto {

	private boolean esLiquido;
	private int cantidadProducto;
	private String tipoEnvase;
	private int unidadesEnvase;

	public AlimentoYBebida() {
		super();
	}

	public AlimentoYBebida(boolean esLiquido, int cantidadProducto, String tipoEnvase, int unidadesEnvase) {
		super();
		this.esLiquido = esLiquido;
		this.cantidadProducto = cantidadProducto;
		this.tipoEnvase = tipoEnvase;
		this.unidadesEnvase = unidadesEnvase;
	}

	public AlimentoYBebida(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, boolean esLiquido, int cantidadProducto, String tipoEnvase,
			int unidadesEnvase) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		this.esLiquido = esLiquido;
		this.cantidadProducto = cantidadProducto;
		this.tipoEnvase = tipoEnvase;
		this.unidadesEnvase = unidadesEnvase;
	}

	public AlimentoYBebida(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String usarProducto(String forma) {
		// TODO Auto-generated method stub
		return null;
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

	public int getUnidadesEnvase() {
		return unidadesEnvase;
	}

	public void setUnidadesEnvase(int unidadesEnvase) {
		this.unidadesEnvase = unidadesEnvase;
	}

	@Override
	public String toString() {
		return "AlimentosYBebidas [" + super.toString() + ", esLiquido=" + esLiquido + ", cantidadProducto="
				+ cantidadProducto + ", tipoEnvase=" + tipoEnvase + ", unidadesEnvase=" + unidadesEnvase + "]";
	}
}
