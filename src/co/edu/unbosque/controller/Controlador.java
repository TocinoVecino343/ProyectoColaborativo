package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controlador {

	private ViewFacade vf;
	private ModelFacade mf;

	Controlador() {
		vf = new ViewFacade();
		mf = new ModelFacade();
	}

	public void runGui() {

	}
}
