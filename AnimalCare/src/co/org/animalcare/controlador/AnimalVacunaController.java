package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.AnimalVacunaService;
import co.org.animalcare.modelo.dto.AnimalDTO;
import co.org.animalcare.modelo.dto.AnimalVacunaDTO;
import co.org.animalcare.modelo.dto.VacunaDTO;

@Controller
@ManagedBean(name="animalVacunaController")
public class AnimalVacunaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{animalVacunaService}")
    private AnimalVacunaService animalVacunaService;
  
    private List<AnimalVacunaDTO> listaAnimalesVacunas;
    private AnimalVacunaDTO animalVacuna =new AnimalVacunaDTO();    
    private int codigo;
    private AnimalDTO animal;
    private VacunaDTO vacuna;
	

	public AnimalVacunaService getAnimalVacunaService() {
		return animalVacunaService;
	}

	public void setAnimalVacunaService(AnimalVacunaService animalVacunaService) {
		this.animalVacunaService = animalVacunaService;
	}

	public List<AnimalVacunaDTO> getListaAnimalesVacunas() {
		listaAnimalesVacunas = new ArrayList<AnimalVacunaDTO>();
		listaAnimalesVacunas.addAll(animalVacunaService.listAnimalVacuna());
		return listaAnimalesVacunas;
	}

	public void setListaAnimalesVacunas(List<AnimalVacunaDTO> listaAnimalesVacunas) {
		this.listaAnimalesVacunas = listaAnimalesVacunas;
	}

	public AnimalVacunaDTO getAnimalVacuna() {
		return animalVacuna;
	}

	public void setAnimalVacuna(AnimalVacunaDTO animalVacuna) {
		this.animalVacuna = animalVacuna;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public AnimalDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}

	public VacunaDTO getVacuna() {
		return vacuna;
	}

	public void setVacuna(VacunaDTO vacuna) {
		this.vacuna = vacuna;
	}

	public void eliminarAnimalVacuna(ActionEvent event) {
		int idAnimalVacuna = (int)event.getComponent().getAttributes().get("idAnimalVacuna");
		animalVacunaService.eliminar(idAnimalVacuna);
	}

	public void guardarAnimalVacuna(ActionEvent event) {
		
		AnimalVacunaDTO av = new AnimalVacunaDTO();
		av.setCodigo(codigo);
		av.setAnimal(animal);
		av.setVacuna(vacuna);
		animalVacunaService.guardar(av);
	}	

}
