/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_DONANTES_ANIMALES, con sus respectivos métodos GET y SET.
 * En esta clase se asocian los animales y los donantes que los han apadrinado
 * @author Familiar
 */
@Entity
@Table(name = "AC_DONANTES_ANIMALES")
public class DonanteAnimalDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código del registro
	@Id
	@Column(name = "NM_CODIGO")
	private int codigo;
	
	//Corresponde al código del donante
	@Column(name = "NM_CODIGO_DONANTE")
	private DonanteDTO donante;
	
	//Corresponde al código del animal
	@Column(name = "NM_CODIGO_ANIMAL")
	private AnimalDTO animal;
	
	//Corresponde al estado en el que se encuentra un apadrinamiento. Si está o no activo.
	@Column(name = "BO_ESTADO")
	private boolean estado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
}
