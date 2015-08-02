package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.VacunaService;
import co.org.animalcare.modelo.dto.VacunaDTO;

@Controller
@ManagedBean(name="vacunaController")
public class VacunaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{vacunaService}")
    private VacunaService vacunaService;
  
    private List<VacunaDTO> listaVacunas;
    private VacunaDTO vacuna =new VacunaDTO();    
    private Long codigo;
    private String nombre;

	public VacunaService getVacunaService() {
		return vacunaService;
	}

	public void setVacunaService(VacunaService vacunaService) {
		this.vacunaService = vacunaService;
	}

	public List<VacunaDTO> getListaVacunas() {
		listaVacunas = new ArrayList<VacunaDTO>();
		listaVacunas.addAll(vacunaService.listVacunaa());
		return listaVacunas;
	}

	public void setListaVacunas(List<VacunaDTO> listaVacunas) {
		this.listaVacunas = listaVacunas;
	}

	public VacunaDTO getVacuna() {
		return vacuna;
	}

	public void setVacuna(VacunaDTO vacuna) {
		this.vacuna = vacuna;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void eliminarVacuna(ActionEvent event) {
		Long idVacuna = (Long)event.getComponent().getAttributes().get("idVacuna");
		vacunaService.eliminar(idVacuna);
	}

	public void guardarVacuna(ActionEvent event) {
		
		VacunaDTO v = new VacunaDTO();
		v.setCodigo(codigo);
		v.setNombre(nombre);		
		vacunaService.guardar(v);
	}	

}
