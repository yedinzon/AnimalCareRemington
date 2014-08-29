package co.org.animalcare.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.dto.DepartamentoDTO;
import co.org.animalcare.modelo.negocio.DepartamentoService;
 
@SuppressWarnings("serial")
@ViewScoped
@Controller
@ManagedBean(name="departamentosBeans")
public class DepartamentosBeans implements Serializable {
     
	@ManagedProperty(value="#{departamentoService}")
    private DepartamentoService departamentoService;
	private int codigo;
	private List<DepartamentoDTO> listaDepartamentosPorPais;
	
	
	public DepartamentoService getDepartamentoService() {
		return departamentoService;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	public int getCodigo() {
		return codigo;
		
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public List<DepartamentoDTO> getListaDepartamentosPorPais() {
		listaDepartamentosPorPais = new ArrayList<DepartamentoDTO>();
		listaDepartamentosPorPais.addAll(departamentoService.listDepartamentoPorPais(codigo));
		return listaDepartamentosPorPais;
	}
		
	public void setListaDepartamentosPorPais(List<DepartamentoDTO> listaDepartamentosPorPais) {
		this.listaDepartamentosPorPais = listaDepartamentosPorPais;
	}

}