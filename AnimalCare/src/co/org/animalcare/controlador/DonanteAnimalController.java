package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.DonanteAnimalService;
import co.org.animalcare.modelo.dto.AnimalDTO;
import co.org.animalcare.modelo.dto.DonanteAnimalDTO;
import co.org.animalcare.modelo.dto.DonanteDTO;

@Controller
@ManagedBean(name="donanteAnimalController")
public class DonanteAnimalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{donanteAnimalService}")
    private DonanteAnimalService donanteAnimalService;
  
    private List<DonanteAnimalDTO> listaDonantesAnimales;
    private DonanteAnimalDTO donanteAnimal =new DonanteAnimalDTO();    
    private Long codigo;
    private DonanteDTO donante;
    private AnimalDTO animal;
    private boolean estado;

	public DonanteAnimalService getDonanteAnimalService() {
		return donanteAnimalService;
	}

	public void setDonanteAnimalService(DonanteAnimalService donanteAnimalService) {
		this.donanteAnimalService = donanteAnimalService;
	}

	public List<DonanteAnimalDTO> getListaDonantesAnimales() {
		listaDonantesAnimales = new ArrayList<DonanteAnimalDTO>();
		listaDonantesAnimales.addAll(donanteAnimalService.listDonanteAnimal());
		return listaDonantesAnimales;
	}

	public void setListaDonantesAnimales(
			List<DonanteAnimalDTO> listaDonantesAnimales) {
		this.listaDonantesAnimales = listaDonantesAnimales;
	}

	public DonanteAnimalDTO getDonanteAnimal() {
		return donanteAnimal;
	}

	public void setDonanteAnimal(DonanteAnimalDTO donanteAnimal) {
		this.donanteAnimal = donanteAnimal;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public DonanteDTO getDonante() {
		return donante;
	}

	public void setDonante(DonanteDTO donante) {
		this.donante = donante;
	}

	public AnimalDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void eliminarDonanteAnimal(ActionEvent event) {
		Long idDonanteAnimal = (Long)event.getComponent().getAttributes().get("idDonanteAnimal");
		donanteAnimalService.eliminar(idDonanteAnimal);
	}

	public void guardarDonanteAnimal(ActionEvent event) {
		
		DonanteAnimalDTO da = new DonanteAnimalDTO();
		da.setCodigo(codigo);
		da.setDonante(donante);
		da.setAnimal(animal);
		da.setEstado(estado);
		donanteAnimalService.guardar(da);
	}	

}
