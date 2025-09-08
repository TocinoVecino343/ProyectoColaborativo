package co.edu.unbosque.view;

public class ViewFacade {

	private Ventana ven;

	public ViewFacade() {
		ven = new Ventana();
	}

	public Ventana getVen() {
		return ven;
	}

	public void setVen(Ventana ven) {
		this.ven = ven;
	}

}
