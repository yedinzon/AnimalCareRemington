package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.DonanteService;
import co.org.animalcare.modelo.dto.DonanteDTO;

@Controller
@ManagedBean(name="donanteController")
public class DonanteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{donanteService}")
    private DonanteService donanteService;
  
    private List<DonanteDTO> listaDonantes;
    private DonanteDTO donante =new DonanteDTO();    
    private int codigo;
    private String nombres;
    private String apellidos;
    private String email;
    private String clave;

	public DonanteService getDonanteService() {
		return donanteService;
	}

	public void setDonanteService(DonanteService donanteService) {
		this.donanteService = donanteService;
	}

	public List<DonanteDTO> getListaDonantes() {
		listaDonantes = new ArrayList<DonanteDTO>();
		listaDonantes.addAll(donanteService.listDonante());
		return listaDonantes;
	}

	public void setListaDonantes(List<DonanteDTO> listaDonantes) {
		this.listaDonantes = listaDonantes;
	}

	public DonanteDTO getDonante() {
		return donante;
	}

	public void setDonante(DonanteDTO donante) {
		this.donante = donante;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void eliminarDonante(ActionEvent event) {
		int idDonante = (int)event.getComponent().getAttributes().get("idDonante");
		donanteService.eliminar(idDonante);
	}

	public void guardarDonante(ActionEvent event) {
		
		DonanteDTO d = new DonanteDTO();
		//d.setCodigo(codigo);
		d.setNombres(nombres);
		d.setApellidos(apellidos);
		d.setEmail(email);
		d.setClave(clave);
		donanteService.guardar(d);
	}	

}