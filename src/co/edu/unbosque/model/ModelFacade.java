package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AlimentoYBebidaDAO;
import co.edu.unbosque.model.persistence.CelularDAO;
import co.edu.unbosque.model.persistence.ConstruccionDAO;
import co.edu.unbosque.model.persistence.DeporteYFitnessDAO;
import co.edu.unbosque.model.persistence.ElectrodomesticoDAO;
import co.edu.unbosque.model.persistence.FarmaciaDAO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import co.edu.unbosque.model.persistence.MascotaDAO;
import co.edu.unbosque.model.persistence.MetodoDePagoDAO;
import co.edu.unbosque.model.persistence.ModaDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.model.persistence.VehiculoDAO;

public class ModelFacade {

	private AlimentoYBebidaDAO alimentoYBebidaDAO;
	private CelularDAO celularDAO;
	private ConstruccionDAO construccionDAO;
	private DeporteYFitnessDAO deporteYFitnessDAO;
	private ElectrodomesticoDAO electrodomesticoDAO;
	private FarmaciaDAO farmaciaDAO;
	private JugueteDAO jugueteDAO;
	private MascotaDAO mascotaDAO;
	private ModaDAO modaDAO;
	private VehiculoDAO vehiculoDAO; 
	private MetodoDePagoDAO metodoDePagoDAO;
	
	private UsuarioDAO usuarioDAO;
	
	public ModelFacade() {
	    alimentoYBebidaDAO = new AlimentoYBebidaDAO();
	    celularDAO = new CelularDAO();
	    construccionDAO = new ConstruccionDAO();
	    deporteYFitnessDAO = new DeporteYFitnessDAO();
	    electrodomesticoDAO = new ElectrodomesticoDAO();
	    farmaciaDAO = new FarmaciaDAO();
	    jugueteDAO = new JugueteDAO();
	    mascotaDAO = new MascotaDAO();
	    modaDAO = new ModaDAO();
	    vehiculoDAO = new VehiculoDAO();
	    usuarioDAO = new UsuarioDAO();
	    metodoDePagoDAO = new MetodoDePagoDAO();
	}

	public AlimentoYBebidaDAO getAlimentoYBebidaDAO() {
		return alimentoYBebidaDAO;
	}

	public void setAlimentoYBebidaDAO(AlimentoYBebidaDAO alimentoYBebidaDAO) {
		this.alimentoYBebidaDAO = alimentoYBebidaDAO;
	}

	public CelularDAO getCelularDAO() {
		return celularDAO;
	}

	public void setCelularDAO(CelularDAO celularDAO) {
		this.celularDAO = celularDAO;
	}

	public ConstruccionDAO getConstruccionDAO() {
		return construccionDAO;
	}

	public void setConstruccionDAO(ConstruccionDAO construccionDAO) {
		this.construccionDAO = construccionDAO;
	}

	public DeporteYFitnessDAO getDeporteYFitnessDAO() {
		return deporteYFitnessDAO;
	}

	public void setDeporteYFitnessDAO(DeporteYFitnessDAO deporteYFitnessDAO) {
		this.deporteYFitnessDAO = deporteYFitnessDAO;
	}

	public ElectrodomesticoDAO getElectrodomesticoDAO() {
		return electrodomesticoDAO;
	}

	public void setElectrodomesticoDAO(ElectrodomesticoDAO electrodomesticoDAO) {
		this.electrodomesticoDAO = electrodomesticoDAO;
	}

	public FarmaciaDAO getFarmaciaDAO() {
		return farmaciaDAO;
	}

	public void setFarmaciaDAO(FarmaciaDAO farmaciaDAO) {
		this.farmaciaDAO = farmaciaDAO;
	}

	public JugueteDAO getJugueteDAO() {
		return jugueteDAO;
	}

	public void setJugueteDAO(JugueteDAO jugueteDAO) {
		this.jugueteDAO = jugueteDAO;
	}

	public MascotaDAO getMascotaDAO() {
		return mascotaDAO;
	}

	public void setMascotaDAO(MascotaDAO mascotaDAO) {
		this.mascotaDAO = mascotaDAO;
	}

	public ModaDAO getModaDAO() {
		return modaDAO;
	}

	public void setModaDAO(ModaDAO modaDAO) {
		this.modaDAO = modaDAO;
	}

	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}

	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public MetodoDePagoDAO getMetodoDePagoDAO() {
		return metodoDePagoDAO;
	}

	public void setMetodoDePagoDAO(MetodoDePagoDAO metodoDePagoDAO) {
		this.metodoDePagoDAO = metodoDePagoDAO;
	}

	
	
}
