package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.dto.AnimalDTO;
import co.org.animalcare.modelo.dto.EntidadDTO;
import co.org.animalcare.modelo.dto.RazaDTO;
import co.org.animalcare.modelo.negocio.AnimalService;

@Controller
@ManagedBean(name = "animalController")
public class AnimalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{animalService}")
	private AnimalService animalService;

	private List<AnimalDTO> listaAnimales;
	private AnimalDTO animal;
	private Long codigo;
	private String comentario;
	private String edad;
	private EntidadDTO entidad;
	private String estado;
	private boolean fertilidad;
	private String nombre;
	private RazaDTO raza;
	private boolean sexo;
	private String tamano;	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public AnimalService getAnimalService() {
		return animalService;
	}

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public List<AnimalDTO> getListaAnimales() {
		listaAnimales = new ArrayList<AnimalDTO>();
		listaAnimales.addAll(animalService.listAnimal());
		return listaAnimales;
	}

	public void setListaAnimales(List<AnimalDTO> listaAnimales) {
		this.listaAnimales = listaAnimales;
	}

	public AnimalDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public EntidadDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isFertilidad() {
		return fertilidad;
	}

	public void setFertilidad(boolean fertilidad) {
		this.fertilidad = fertilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public RazaDTO getRaza() {
		return raza;
	}

	public void setRaza(RazaDTO raza) {
		this.raza = raza;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public void eliminarAnimal(ActionEvent event) {
		Long idAnimal = (Long) event.getComponent().getAttributes()
				.get("idAnimal");
		animalService.eliminar(idAnimal);
	}

	public void guardarAnimal(ActionEvent event) {

		AnimalDTO a = new AnimalDTO();
		a.setCodigo(codigo);
		a.setComentario(comentario);
		a.setEdad(edad);
		a.setEntidad(entidad);
		a.setEstado(estado);
		a.setFertilidad(fertilidad);
		a.setNombre(nombre);
		a.setRaza(raza);
		a.setSexo(sexo);
		a.setTamano(tamano);
		animalService.guardar(a);
	}

	/**
	 * Cargar entidad/variable animal al momento de recibir parámetro en algunas
	 * páginas
	 */
	public void cargarAnimal() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
			animal = animalService.consultar(codigo);
		}
	}

}
