package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.EspecieService;
import co.org.animalcare.modelo.dto.EspecieDTO;

@Controller
@ManagedBean(name="especieController")
public class EspecieController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{especieService}")
    private EspecieService especieService;
  
    private List<EspecieDTO> listaEspecies;
    private EspecieDTO especie =new EspecieDTO();    
    private int codigo;
    private String nombre;

	public EspecieService getEspecieService() {
		return especieService;
	}

	public void setEspecieService(EspecieService especieService) {
		this.especieService = especieService;
	}

	public List<EspecieDTO> getListaEspecies() {
		listaEspecies = new ArrayList<EspecieDTO>();
		listaEspecies.addAll(especieService.listEspecie());
		return listaEspecies;
	}

	public void setListaEspecies(List<EspecieDTO> listaEspecies) {
		this.listaEspecies = listaEspecies;
	}

	public EspecieDTO getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieDTO especie) {
		this.especie = especie;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void eliminarEspecie(ActionEvent event) {
		int idEspecie = (int)event.getComponent().getAttributes().get("idEspecie");
		especieService.eliminar(idEspecie);
	}

	public void guardarEspecie(ActionEvent event) {
		
		EspecieDTO esp = new EspecieDTO();
		esp.setCodigo(codigo);
		esp.setNombre(nombre);
		especieService.guardar(esp);
	}	

}
