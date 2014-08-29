package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.PaisService;
import co.org.animalcare.modelo.dto.PaisDTO;

@Controller
@ManagedBean(name="paisController")
public class PaisController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{paisService}")
    private PaisService paisService;
  
    public List<PaisDTO> listaPaises;
    private PaisDTO pais =new PaisDTO();    
    private int codigo;
    private String nombre;

	public PaisService getPaisService() {
		return paisService;
	}

	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}

	public List<PaisDTO> getListaPaises() {
		listaPaises = new ArrayList<PaisDTO>();
		listaPaises.addAll(paisService.listPais());
		return listaPaises;
	}

	public void setListaPaises(List<PaisDTO> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
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

	public void eliminarPais(ActionEvent event) {
		int idPais = (int)event.getComponent().getAttributes().get("idPais");
		paisService.eliminar(idPais);
	}

	public void guardarPais(ActionEvent event) {
		
		PaisDTO p = new PaisDTO();
		p.setCodigo(codigo);
		p.setNombre(nombre);
		paisService.guardar(p);
	}	

}