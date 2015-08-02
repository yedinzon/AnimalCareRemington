package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.RazaService;
import co.org.animalcare.modelo.dto.EspecieDTO;
import co.org.animalcare.modelo.dto.RazaDTO;

@Controller
@ManagedBean(name="razaController")
public class RazaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{razaService}")
    private RazaService razaService;
  
    private List<RazaDTO> listaRazas;
    private RazaDTO raza =new RazaDTO();    
    private Long codigo;
    private String nombre;
    private EspecieDTO especie;

	public RazaService getRazaService() {
		return razaService;
	}

	public void setRazaService(RazaService razaService) {
		this.razaService = razaService;
	}

	public List<RazaDTO> getListaRazas() {
		listaRazas = new ArrayList<RazaDTO>();
		listaRazas.addAll(razaService.listRaza());
		return listaRazas;
	}

	public void setListaRazas(List<RazaDTO> listaRazas) {
		this.listaRazas = listaRazas;
	}

	public RazaDTO getRaza() {
		return raza;
	}

	public void setRaza(RazaDTO raza) {
		this.raza = raza;
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

	public EspecieDTO getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieDTO especie) {
		this.especie = especie;
	}

	public void eliminarRaza(ActionEvent event) {
		Long idRaza = (Long)event.getComponent().getAttributes().get("idRaza");
		razaService.eliminar(idRaza);
	}

	public void guardarRaza(ActionEvent event) {
		
		RazaDTO r = new RazaDTO();
		r.setCodigo(codigo);
		r.setNombre(nombre);
		r.setEspecie(especie);
		razaService.guardar(r);
	}	

}