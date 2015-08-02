/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad AC_ANIMALES_VACUNAS, con sus respectivos m�todos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_ANIMALES_VACUNAS")
public class AnimalVacunaDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al c�digo del registro
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al c�digo del animal
	@Column(name = "NM_CODIGO_ANIMAL")
	private AnimalDTO animal;
	
	//Corresponde al c�digo de la vacuna
	@Column(name = "NM_CODIGO_VACUNA")
	private VacunaDTO vacuna;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
}
