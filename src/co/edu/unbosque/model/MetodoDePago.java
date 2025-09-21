package co.edu.unbosque.model;

import java.io.Serializable;

public class MetodoDePago implements Serializable {

	private static final long serialVersionUID = -1194621474458762572L;
	private String titular;
	private long numeroTarjeta;
	private String fechaVencimiento;
	private int pinDeSeguridad;
	private int idAsociado;

	public MetodoDePago() {
	}

	public MetodoDePago(String titular, long numeroTarjeta, String fechaVencimiento, int pinDeSeguridad,
			int idAsociado) {
		super();
		this.titular = titular;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.pinDeSeguridad = pinDeSeguridad;
		this.idAsociado = idAsociado;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getPinDeSeguridad() {
		return pinDeSeguridad;
	}

	public void setPinDeSeguridad(int pinDeSeguridad) {
		this.pinDeSeguridad = pinDeSeguridad;
	}

	public int getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(int idAsociado) {
		this.idAsociado = idAsociado;
	}

	@Override
	public String toString() {
		return "MetodoDePago [titular=" + titular + ", numeroTarjeta=" + numeroTarjeta + ", fechaVencimiento="
				+ fechaVencimiento + ", pinDeSeguridad=" + pinDeSeguridad + ", idAsociado=" + idAsociado + "]";
	}

}
