package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.CiudadService;
import co.org.animalcare.modelo.dto.CiudadDTO;
import co.org.animalcare.modelo.dto.DepartamentoDTO;

@Controller
@ManagedBean(name="ciudadController")
@ViewScoped
public class CiudadController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{ciudadService}")
    private CiudadService ciudadService;
  
    private List<CiudadDTO> listaCiudades;
	private CiudadDTO ciudadDTO;
    private Long codigo;
    private String nombre;
    private DepartamentoDTO departamento;
    private Long codigoDepartamento;
    private List<CiudadDTO> listaCiudadesPorDepartamento;

	public CiudadService getCiudadService() {
		return ciudadService;
	}

	public void setCiudadService(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}
	
	public Long getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Long codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
		
	}

	public List<CiudadDTO> getListaCiudadesPorDepartamento() {
		listaCiudadesPorDepartamento = new ArrayList<CiudadDTO>();
		listaCiudadesPorDepartamento.addAll(ciudadService.listCiudadesPorDepartamento(codigoDepartamento));
		return listaCiudadesPorDepartamento;
	}

	public void setListaCiudadesPorDepartamento(List<CiudadDTO> listaCiudadesPorDepartamento) {
		this.listaCiudadesPorDepartamento = listaCiudadesPorDepartamento;
	}

	public List<CiudadDTO> getListaCiudades() {
		listaCiudades = new ArrayList<CiudadDTO>();
		listaCiudades.addAll(ciudadService.listCiudad());
		return listaCiudades;
	}

	public void setListaCiudades(List<CiudadDTO> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}
	
	public CiudadDTO getCiudadDTO() {
		return ciudadDTO;
	}

	public void setCiudadDTO(CiudadDTO ciudadDTO) {
		this.ciudadDTO = ciudadDTO;
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

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

	public void eliminarCiudad(ActionEvent event) {
		Long idCiudad = (Long)event.getComponent().getAttributes().get("idCiudad");
		ciudadService.eliminar(idCiudad);
	}

	public void guardarCiudad(ActionEvent event) {
		
		CiudadDTO c = new CiudadDTO();
		c.setCodigo(codigo);
		c.setNombre(nombre);
		c.setDepartamento(departamento);
		ciudadService.guardar(c);
	}	

}
