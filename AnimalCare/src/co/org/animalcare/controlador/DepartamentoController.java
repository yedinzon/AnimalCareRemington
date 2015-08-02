package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.dto.DepartamentoDTO;
import co.org.animalcare.modelo.dto.PaisDTO;
import co.org.animalcare.modelo.negocio.DepartamentoService;

@Controller
@ManagedBean(name="departamentoController")
public class DepartamentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{departamentoService}")
    private DepartamentoService departamentoService;
	
  
    private List<DepartamentoDTO> listaDepartamentos;
    private DepartamentoDTO departamento = null;    
    private Long codigo = null;
    private String nombre = null;
    private PaisDTO pais = null;
    private Long codigoPais = null;
	private List<DepartamentoDTO> listaDepartamentosPorPais = null;	
    
	public DepartamentoService getDepartamentoService() {
		return departamentoService;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	public Long getCodigoPais() {
		return codigoPais;
		
	}

	public void setCodigoPais(Long codigoPais) {		
		this.codigoPais = codigoPais;
	}
	
	public List<DepartamentoDTO> getListaDepartamentosPorPais() {
		listaDepartamentosPorPais = new ArrayList<DepartamentoDTO>();
		listaDepartamentosPorPais.addAll(departamentoService.listDepartamentoPorPais(codigoPais));
		return listaDepartamentosPorPais;
	}
		
	public void setListaDepartamentosPorPais(List<DepartamentoDTO> listaDepartamentosPorPais) {
		this.listaDepartamentosPorPais = listaDepartamentosPorPais;
	}

	public List<DepartamentoDTO> getListaDepartamentos() {
		listaDepartamentos = new ArrayList<DepartamentoDTO>();
		listaDepartamentos.addAll(departamentoService.listDepartamento());
		return listaDepartamentos;
	}


	public void setListaDepartamentos(List<DepartamentoDTO> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
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

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public void eliminarDepartamento(ActionEvent event) {
		Long idDepartamento = (Long)event.getComponent().getAttributes().get("idDepartamento");
		departamentoService.eliminar(idDepartamento);
	}
	
	public void guardarDepartamento(ActionEvent event) {
		
		DepartamentoDTO dpto = new DepartamentoDTO();
		dpto.setCodigo(codigo);
		dpto.setNombre(nombre);
		dpto.setPais(pais);
		departamentoService.guardar(dpto);
	}

}
